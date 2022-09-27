package com.it;

import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;

import java.io.IOException;

/**
 * @author ZuYingFang
 * @time 2022-09-24 18:31
 * @description
 */
public class HBaseDDL {

    public static Connection connection = HBaseConnection1.connection;

    // 创建命名空间
    public static void createNamespace(String namespace) throws IOException {
        // 1 获取admin，轻量级的，不是线程安全的，不推荐池化或者缓存这个连接，用到了就用，用完关闭掉
        Admin admin = connection.getAdmin();

        // builder建造者模式，你可以对他增加各种属性，然后使用build()方法返回这个对象
        NamespaceDescriptor.Builder builder = NamespaceDescriptor.create(namespace);
        builder.addConfiguration("user", "xiaofang"); // 这个只是我们示例加入一些属性，实则是没用的

        // 2 调用方法创建命名空间
        admin.createNamespace(builder.build());

        // 3 关闭admin
        admin.close();
    }

    public static void main(String[] args) throws IOException {

        HBaseDDL.createNamespace("xiaofang");

        HBaseConnection1.closeConnection();

    }

}
