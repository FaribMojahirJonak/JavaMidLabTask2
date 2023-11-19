import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    public static void create(User user) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionManager.getConnection();
        String sql = "INSERT INTO users SET email = ?, fullName = ?, password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getFullName());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.executeUpdate();
        System.out.println(user.getEmail());
    }

    public static User validateUser(String email, String password) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionManager.getConnection();
        String sql = "SELECT * FROM users WHERE Email = ? AND Password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            //String email = resultSet.getString("email");
            String fullName = resultSet.getString("fullName");
            User user = new User(email, fullName, password);
            return user;
        } else {
            return null;
        }
    }
}