package web;

import domain.Persona;
import domain.Usuario;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import servicio.PersonaServiceLocal;
import servicio.UsuarioServiceLocal;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsuarioServlet", value = "/Usuarios")
public class UsuarioServlet extends HttpServlet {
    @Inject
    UsuarioServiceLocal usuarioService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> personas = usuarioService.listarPersonas();
        System.out.println(personas);
        request.setAttribute("usuarios", personas);
        request.getRequestDispatcher("/listadousuarios.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
