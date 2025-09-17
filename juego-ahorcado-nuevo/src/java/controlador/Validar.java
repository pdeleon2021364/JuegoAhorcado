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
        System.out.println("mensaje");
        String accion = request.getParameter("accion");
        
        if ("Ingresar".equalsIgnoreCase(accion)) {
            System.out.println("ingresando");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if ("pdeleon".equals(username) && "1234".equals(password)) {
    // Entra directo al servlet que carga palabras
    response.sendRedirect("Controlador");
} else {
    request.setAttribute("error", "Usuario o contraseña incorrectos");
    // Cambiar a index.jsp (nombre real de tu login)
    request.getRequestDispatcher("index.jsp").forward(request, response);
}

    }
}
}
