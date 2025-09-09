package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Palabra;
import modelo.PalabraDAO;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    PalabraDAO palabraDAO = new PalabraDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        menu = "Palabras";
        if (menu.equals("Palabras")) {
            switch (accion) {
                case "Listar":
                    System.out.println("listandopalabra");
                    List<Palabra> listaPalabras = palabraDAO.listar();
                    request.setAttribute("palabras", listaPalabras);
                    request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
                    System.out.println(listaPalabras);
                    break;

                default:
                    // Acción no reconocida → al index
                    response.sendRedirect("index.jsp");
                    break;
            }

        } else {
            // Menú no válido → al index
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Controlador principal para el proyecto de Ahorcado";
    }
}
