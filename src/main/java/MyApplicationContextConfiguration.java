import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Statement;

@Configuration
public class MyApplicationContextConfiguration {
    @Bean
    public Statement statement(){
        return statement();
    }

    @Bean
    public UserDAO userDAO(){
        return new UserDAO(statement());
    }
}
