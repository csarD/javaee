package servicio;


import domain.Persona;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PersonaServiceLocal {
    public List<Persona> listarPersonas();
    public Persona encontrarPersonaporId(Persona persona);
    public Persona encontrarPersonaporEmail(Persona persona);
    public void registrarPersona(Persona persona);
    public void modificarPersona(Persona persona);
    public void eliminarPersona(Persona persona);
}
