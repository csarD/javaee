package cliente.cascade;

import domain.Persona;
import domain.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class PersistenciaCascadaJPA {
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Persona persona = new Persona("Hugo","Hernandez","hernandez@gmail.com","1248545");
        Usuario usuario = new Usuario("hherdnzar","123",persona);
        em.persist(usuario);
        tx.commit();
        em.close();
        log.debug(persona);
        log.debug(usuario);

    }
}
