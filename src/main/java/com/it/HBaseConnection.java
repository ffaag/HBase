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
 * @description 单线程
 */
public class HBaseConnection {

    public static void main(String[] args) throws IOException {

        // 1 创建配置对象
        Configuration configuration = new Configuration();
        configuration.set("hbase.zookeeper.quorum","hadoop102,hadoop103,hadoop104");

        // 2 创建连接，默认使用的同步连接
        Connection connection = ConnectionFactory.createConnection(configuration);

        // 可以使用异步连接，不推荐使用异步连接
        CompletableFuture<AsyncConnection> asyncConnection = ConnectionFactory.createAsyncConnection(configuration);

        // 3 使用连接
        System.out.println(connection);

        // 4 关闭连接
        connection.close();

    }

}
