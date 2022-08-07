package ciclovidaJPA;

import domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EncontrarObjetoJPA {
    static Logger log =LogManager.getRootLogger();
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Persona persona = em.find(Persona.class,1);
        log.debug("objeto recuperado"+ persona);
        tx.commit();

    }
}
