package controlador;

import modelo.Usuario;
import modelo.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class Validar extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("Ingresar".equalsIgnoreCase(accion)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Usuario user = usuarioDAO.validarUsuario(username, password);

            if (user != null) {
                // ✅ Login exitoso → crear sesión
                HttpSession session = request.getSession(true);
                session.setAttribute("usuario", user.getNombre());

                response.sendRedirect("Controlador");
            } else {
                // ❌ Usuario o contraseña incorrectos
                request.setAttribute("error", "Usuario o contraseña incorrectos");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
