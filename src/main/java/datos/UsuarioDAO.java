package datos;

import domain.Persona;
import domain.Usuario;

import java.util.List;

public interface UsuarioDAO {
    public List<Usuario> findAllPersonas();
    public Usuario findPersonaById(Usuario usuario);

    public void savePersona(Usuario usuario);
    public void updatePersona(Usuario usuario);
    public void deletePersona(Usuario usuario);
}
