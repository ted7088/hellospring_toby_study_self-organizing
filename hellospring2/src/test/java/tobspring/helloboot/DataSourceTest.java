package tobspring.helloboot;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import tobyspring.helloboot.HellobootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
@JdbcTest
@ContextConfiguration(classes = HellobootApplication.class)
public class DataSourceTest {
    @Autowired DataSource dataSource;

    @Test
    void connect() throws SQLException{
        Connection connection = dataSource.getConnection();
        connection.close();

    }
}
