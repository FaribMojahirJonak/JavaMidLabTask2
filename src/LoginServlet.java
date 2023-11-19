import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            User user;
            if(DBUtil.validateUser(email,password)!=null)
            {
                user =DBUtil.validateUser(email,password);
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                session.setAttribute("fullName", user.getFullName());
                response.sendRedirect("welcome.jsp");
            }
            else {
                response.sendRedirect("login.jsp?error=1");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}