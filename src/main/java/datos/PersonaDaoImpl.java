package datos;

import domain.Persona;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class PersonaDaoImpl  implements PersonaDAO {
    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;
    @Override
    public List<Persona> findAllPersonas() {

        return em.createNamedQuery("Persona.findAll", Persona.class).getResultList();


    }

    @Override
    public Persona findPersonaById(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public Persona findPersonaByEmail(Persona persona) {
        Query query = em.createQuery("select p from Persona p where p.email = :email").setParameter("email", persona.getEmail());
        return (Persona) query.getSingleResult();
    }

    @Override
    public void savePersona(Persona persona) {
        em.persist(persona);
    }

    @Override
    public void updatePersona(Persona persona) {
    em.merge(persona);
    }

    @Override
    public void deletePersona(Persona persona) {
        em.remove(em.merge(persona));

    }




}
