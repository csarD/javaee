package servicio;


import domain.Persona;
import domain.Usuario;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UsuarioServiceLocal {
    public List<Usuario> listarPersonas();
    public Usuario encontrarPersonaporId(Usuario persona);

    public void registrarPersona(Usuario persona);
    public void modificarPersona(Usuario persona);
    public void eliminarPersona(Usuario persona);
}
