package jpql;

import domain.Persona;
import domain.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PruebaApiCriteria {
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder criteria = em.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona= null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
    List<Persona> personas= null;

        criteriaQuery= criteria.createQuery(Persona.class);
        fromPersona= criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);
        query= em.createQuery(criteriaQuery);
        personas= query.getResultList();
        //mostrarPersonas(personas);
        criteria= em.getCriteriaBuilder();
        criteriaQuery= criteria.createQuery(Persona.class);
        fromPersona= criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(criteria.equal(fromPersona.get("idPersona"),1));
        query= em.createQuery(criteriaQuery);
        persona =  query.getSingleResult();
        log.debug("Filter id 1"+ persona);


        criteria= em.getCriteriaBuilder();
        criteriaQuery= criteria.createQuery(Persona.class);
        fromPersona= criteriaQuery.from(Persona.class);
        List<Predicate> criterios = new ArrayList<Predicate>();
        Integer idPersonaParam = 1;
        ParameterExpression<Integer> parameter = criteria.parameter(Integer.class,"idPersona");
        criterios.add(criteria.equal(fromPersona.get("idPersona"),parameter));
        criteriaQuery.select(fromPersona).where(criteria.equal(fromPersona.get("idPersona"),1));
        if(criterios.isEmpty()){
            throw  new RuntimeException("No criterios");
        }else if(criterios.size() == 1){
            criteriaQuery.select(fromPersona).where(criterios.get(0));
        }else{
            criteriaQuery.select(fromPersona).where(criteria.and(criterios.toArray(new Predicate[0]))) ;
        }
        query= em.createQuery(criteriaQuery);
        query.setParameter("idPersona", idPersonaParam);
        persona =  query.getSingleResult();
        log.debug("Filter id 1 with criterios"+ persona);

    }
    private static void mostrarPersonas(List<Persona> personas) {
        for(Persona p : personas){
            log.debug(p);
        }
    }
}
