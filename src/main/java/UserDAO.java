import javax.swing.plaf.nimbus.State;
import java.io.PrintWriter;
import java.sql.*;

public class UserDAO {

    Statement stmt;

    public StringBuilder stringBuilder = new StringBuilder("");

    public UserDAO(Statement stmt){
        this.stmt=stmt;
    }

    public void insertNewUser(String table, String login, String password, String nickname, String email){
       stringBuilder.append("insert into ").append(table + " (login, password, nickname, email) values (").append(login+',')
                       .append(password+',').append(nickname+',').append(email+')');
        try {
            stmt.executeUpdate(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        stringBuilder.setLength(0);
    }

    public void getColumn(String table, String column){
        PrintWriter printWriter = new PrintWriter(System.out);
        stringBuilder.append("select "+ column +" from " + table);
        try {
            ResultSet resultSet = stmt.executeQuery(stringBuilder.toString());
            while (resultSet.next()){
                printWriter.println(resultSet.getString(column));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void renameUser(int id, String newName){
        stringBuilder.append("update \"user\" set nickname = "+newName+" where id = "+ id);
        try {
            stmt.executeUpdate(stringBuilder.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        stringBuilder.setLength(0);
    }
}
