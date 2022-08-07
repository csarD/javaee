package datos;

import domain.Persona;
import domain.Usuario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UsuarioDaoImpl implements UsuarioDAO {
    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;
    @Override
    public List<Usuario> findAllPersonas() {

        return em.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();


    }

    @Override
    public Usuario findPersonaById(Usuario persona) {
        return em.find(Usuario.class, persona.getIdUsuario());
    }



    @Override
    public void savePersona(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void updatePersona(Usuario usuario) {
    em.merge(usuario);
    }

    @Override
    public void deletePersona(Usuario usuario) {
        em.remove(em.merge(usuario));

    }




}
