package web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import domain.Persona;
import servicio.PersonaServiceLocal;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@WebServlet("/personas")
public class PersonaServlet extends HttpServlet {
    @Inject
    PersonaServiceLocal personaService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     List<Persona> personas = personaService.listarPersonas();
     System.out.println(personas);
     request.setAttribute("personas", personas);
     request.getRequestDispatcher("/listadopersonas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
