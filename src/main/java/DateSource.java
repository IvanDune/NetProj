import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public enum DateSource {
    INSTANCE;

    private DateSource dateSource;

    public Statement statement() throws ClassNotFoundException, SQLException {
        {
            Statement stmt;


                Class.forName("org.postgresql.Driver");
                stmt = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/Project",
                        "postgres","Sova1029").createStatement();


            return  stmt;
        }
    }
}
