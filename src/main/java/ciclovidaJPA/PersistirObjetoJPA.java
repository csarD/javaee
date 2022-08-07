package ciclovidaJPA;

import domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistirObjetoJPA {
    static Logger log =LogManager.getRootLogger();
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Persona persona = new Persona("Pedro","Escamoso","pescamo@mail.com","1442645");
        tx.begin();
        em.persist(persona);
        log.debug("objeto no persistido"+ persona);
        tx.commit();
        log.debug("objeto persistido"+ persona);
        em.close();
    }
}
