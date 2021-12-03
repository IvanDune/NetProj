import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Configuration
public class MyApplicationContextConfiguration {
    @Bean
    public Statement statement() throws ClassNotFoundException, SQLException {
        Statement stmt;
        Class.forName("org.postgresql.Driver");
        stmt = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Project",
                "postgres","Sova1029").createStatement();


        return  stmt;
    }

    @Bean
    public UserDAO userDAO() throws SQLException, ClassNotFoundException {
        return new UserDAO(statement());
    }
}
