import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyApplicationContextConfiguration.class);
        UserDAO userDAO = applicationContext.getBean(UserDAO.class);
        Statement stmt = applicationContext.getBean(Statement.class);

        userDAO.insertNewUser("\"user\"","\'TestLog\'","\'TestPass\'",
                "\'TestNick\'","\'TestEmail\'");
        userDAO.renameUser(3,"\'apple\'");
        //userDAO.getColumn("\"user\"","login");
    }
}
