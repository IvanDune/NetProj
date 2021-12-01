import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Project", "postgres","Sova1029");
            Statement stmt = connection.createStatement();
            ResultSet rs1 = stmt.executeQuery("SELECT User.nickname FROM User");
           // ResultSet rs = stmt.executeQuery("insert into User (login, password, nickname, email)" +
                    //" values (login1, 123456, Iv@n, qwert@gmail.com)")
            while(rs1.next()){
                System.out.println(rs1.getString("nickname"));
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
