package cliente.asociaciones;

import domain.Persona;
import domain.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ClienteAsociacionesJPA {
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        List<Persona> persons = em.createNamedQuery("Persona.findAll").getResultList();
        em.close();

        for(Persona p : persons){
            log.debug("Persona: " + p);
            for(Usuario usuario : p.getUsuariosByIdPersona()){
                log.debug("Usuario: " + usuario);
            }
        }
    }
}
