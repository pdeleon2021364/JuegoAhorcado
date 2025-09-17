package controlador;

import modelo.Palabra;
import modelo.PalabraDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {

    private final PalabraDAO palabraDAO = new PalabraDAO();

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

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Carga la lista de palabras desde la base de datos
        List<Palabra> listaPalabras = palabraDAO.listar();

        // Pasa la lista a la vista
        request.setAttribute("palabras", listaPalabras);

        // Envía la solicitud al archivo JSP
        request.getRequestDispatcher("ahorcado.jsp").forward(request, response);
    }
}