package servicio;


import domain.Persona;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface PersonaServiceRemote {
    public List<Persona> listarPersonas();
    public Persona encontrarPersonaporId(Persona persona);
    public Persona encontrarPersonaporEmail(Persona persona);
    public void registrarPersona(Persona persona);
    public void modificarPersona(Persona persona);
    public void eliminarPersona(Persona persona);
}
