package controlador;
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class Validar extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String accion = request.getParameter("accion");
 
        if ("Ingresar".equalsIgnoreCase(accion)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
 
            if ("pdeleon".equals(username) && "1234".equals(password)) {
                response.sendRedirect("Controlador");
            } else {
                request.setAttribute("error", "Usuario o contraseña incorrectos");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            // si hay otras acciones, manejarlas aquí
            response.sendRedirect("index.jsp");
        }
    }
}