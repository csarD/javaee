package ciclovidaJPA;

import domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ActualizarObjetoJPA {
    static Logger log =LogManager.getRootLogger();
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Persona persona = em.find(Persona.class,1);
        log.debug("objeto recuperado"+ persona);
        tx.commit();
        log.debug("objeto detached"+ persona);
         persona.setApellido("Juarez");
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        em.merge(persona);
        tx2.commit();
        em.close();
    }
}
