package servicio;

import datos.PersonaDAO;
import domain.Persona;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PersonaServiceImpl implements  PersonaServiceLocal{
    @Inject
    private PersonaDAO personaDao;
    @Override
    public List<Persona> listarPersonas() {
         return personaDao.findAllPersonas();
    }

    @Override
    public Persona encontrarPersonaporId(Persona persona) {
        return personaDao.findPersonaById( persona);
    }

    @Override
    public Persona encontrarPersonaporEmail(Persona persona) {
        return personaDao.findPersonaByEmail( persona);
    }

    @Override
    public void registrarPersona(Persona persona) {
personaDao.savePersona(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
    personaDao.updatePersona(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {
    personaDao.deletePersona(persona);
    }
}
