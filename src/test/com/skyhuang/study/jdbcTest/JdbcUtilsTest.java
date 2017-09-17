package com.skyhuang.study.jdbcTest;

import com.skyhuang.study.jdbc.JdbcUtils;
import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hk on 2017/9/5.
 */
public class JdbcUtilsTest {

    @Test
    public void getConnectionByAnnotationTest(){
        try {
            Connection connectionByAnnotation = JdbcUtils.getConnectionByAnnotation();
            System.out.println(connectionByAnnotation);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
