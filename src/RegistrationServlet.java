import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User(request.getParameter("email"), request.getParameter("fullName"), request.getParameter("password"));
        try {
            DBUtil.create(user);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect( "login.jsp");
    }
}

