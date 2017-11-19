package databaseTest;

import com.skyhuang.domain.User;
import com.skyhuang.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by hk on 2017/11/18.
 */
public class c3p0Test {

    @Test
    public void loginTest(){
        String sql = "select * from s_user where logonName=? and logonPwd=?";

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            User query = runner.query(sql, new BeanHandler<User>(User.class), "admin", "admin");
            System.out.println(query.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
