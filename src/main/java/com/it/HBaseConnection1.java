package com.it;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.AsyncConnection;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * @author ZuYingFang
 * @time 2022-09-24 18:08
 * @description 多线程
 */
public class HBaseConnection1 {

    // 声明一个静态属性
    public static Connection connection = null;
    static {
        try {
            // 读取本地配置文件模式创建连接
            connection = ConnectionFactory.createConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() throws IOException {
        if (connection==null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws IOException {

        // 直接使用创建好的连接
        System.out.println(HBaseConnection1.connection);
        HBaseConnection1.closeConnection();

    }

}
