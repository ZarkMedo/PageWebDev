package com.hrzx.big.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName: JDBCUtils
 * @Auther: medo
 * @Date: 2019-09-11 01:56
 * @Description: TODO
 **/
public class JDBCUtils {
    private static DataSource ds;

    static {
        Properties props = new Properties();

        URL resource = JDBCUtils.class.getClassLoader().getResource("druid.properties");
        String path = resource.getPath();
        System.out.println(path);
        InputStream rs = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            props.load(rs);
            for (Map.Entry<Object, Object> objectObjectEntry : props.entrySet()) {
                System.out.println(objectObjectEntry.getKey());
                System.out.println(objectObjectEntry.getValue());
            }
            ds = DruidDataSourceFactory.createDataSource(props);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static DataSource getDatasource() {
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


}
