package servicio;

import datos.PersonaDAO;
import datos.UsuarioDAO;
import domain.Persona;
import domain.Usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class UsuarioServiceImpl implements  UsuarioServiceLocal{
    @Inject
    private UsuarioDAO personaDao;
    @Override
    public List<Usuario> listarPersonas() {
         return personaDao.findAllPersonas();
    }

    @Override
    public Usuario encontrarPersonaporId(Usuario persona) {
        return personaDao.findPersonaById( persona);
    }



    @Override
    public void registrarPersona(Usuario persona) {
personaDao.savePersona(persona);
    }

    @Override
    public void modificarPersona(Usuario persona) {
    personaDao.updatePersona(persona);
    }

    @Override
    public void eliminarPersona(Usuario persona) {
    personaDao.deletePersona(persona);
    }
}
