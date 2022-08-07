package jpql;

import domain.Persona;
import domain.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

public class PruebaJPQL {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        String jqpl = null;
        Query q = null;
        List<Persona> personas=null;
        Persona persona=null;
        Iterator iter = null;
        Object[] tuple = null;
        List<String> nombres=null;
        List<Usuario> usuarios=null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        log.debug("Consulta de todas las personas");
        jqpl= "select p from Persona p";
        personas= em.createQuery(jqpl).getResultList();
        mostrarPersonas(personas);
        log.debug("Consulta de todas las persona 1");
        jqpl= "select p from Persona p where p.idPersona = 1";
        persona= (Persona) em.createQuery(jqpl).getSingleResult();
        log.debug(persona);
        log.debug("Consulta de todas las persona con nombre cesar");
        jqpl= "select p from Persona p where p.nombre = 'cesar'";
        personas=  em.createQuery(jqpl).getResultList();
        mostrarPersonas(personas);


        log.debug("Consulta de datos individuales con tupla");
        jqpl= "select p.nombre,p.apellido,p.email from Persona p";
        iter=  em.createQuery(jqpl).getResultList().iterator();
        while (iter.hasNext()) {
            tuple= (Object[]) iter.next();
            String nombre= (String) tuple[0];
            String apellido= (String) tuple[1];
            String email= (String) tuple[2];
            log.debug(nombre+" "+apellido+" "+email);
        }
        log.debug("Consulta de datos individuales con object");
        jqpl= "select p,p.idPersona from Persona p";
        iter=  em.createQuery(jqpl).getResultList().iterator();
        while (iter.hasNext()) {
            tuple= (Object[]) iter.next();
            Persona nombre= (Persona) tuple[0];
            int id= (int) tuple[1];

            log.debug(nombre+" "+id+" ");
        }
        log.debug("consulta con domain");
        jqpl= "select new domain.Persona(p.idPersona)  from Persona p";
        personas=  em.createQuery(jqpl).getResultList();
        mostrarPersonas(personas);


        log.debug("consulta con valores min y max");
        jqpl= "select max(p.idPersona) as maximo, min(p.idPersona) as minimo,count(p.idPersona) as conteo from Persona p";
        iter=  em.createQuery(jqpl).getResultList().iterator();
        while (iter.hasNext()) {
            tuple= (Object[]) iter.next();
            Integer max= (Integer) tuple[0];
            Integer min= (Integer) tuple[1];
            Long conteo= (Long) tuple[2];
            log.debug(max+" "+min+" "+conteo+" ");
        }



        log.debug("consulta con nombres distintos");
        jqpl= "select count(distinct p.nombre) as conteo from Persona p";
        Long contador= (Long) em.createQuery(jqpl).getSingleResult();

            log.debug(contador+" ");


        log.debug("consulta con concater y mayusculas");
        jqpl= "select CONCAT(p.nombre,' ',p.apellido) from Persona p";
        nombres= em.createQuery(jqpl).getResultList();
        for(String nombre: nombres){
            log.debug(nombre.toUpperCase()+" ");
        }
        log.debug("Consulta de todas las persona con id parametro");
        jqpl= "select p from Persona p where p.idPersona = :id";
        persona= (Persona) em.createQuery(jqpl).setParameter("id",1).getSingleResult();
        log.debug(persona);

        log.debug("Consulta de todas las persona con a en el nombre sin ser sensible");
        jqpl= "select p from Persona p where upper(p.nombre) like upper(:nombre)";
        personas=  em.createQuery(jqpl).setParameter("nombre","%a%").getResultList();
        mostrarPersonas(personas);

        log.debug("uso de between");
        jqpl= "select p from Persona p where p.idPersona between 1 and 3";
        personas=  em.createQuery(jqpl).getResultList();
        mostrarPersonas(personas);

        log.debug("uso de order by");
        jqpl= "select p from Persona p order by p.idPersona desc";
        personas=  em.createQuery(jqpl).getResultList();
        mostrarPersonas(personas);




        log.debug("uso de subquery");
        jqpl= "select p from Persona p where  p.idPersona in (select min(p1.idPersona) from Persona p1)";
        personas=  em.createQuery(jqpl).getResultList();
        mostrarPersonas(personas);

        log.debug("uso de join con lazy loading");
        jqpl= "select u from Usuario u join u.personaByIdPersona p ";
        usuarios=  em.createQuery(jqpl).getResultList();
        mostrarusuarios(usuarios);

        log.debug("uso de left join con eager loading");
        jqpl= "select u from Usuario u left join fetch u.personaByIdPersona p ";
        usuarios=  em.createQuery(jqpl).getResultList();
        mostrarusuarios(usuarios);

    }

    private static void mostrarusuarios(List<Usuario> usuarios) {
        for(Usuario p : usuarios){
            log.debug(p);
        }
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for(Persona p : personas){
            log.debug(p);
        }
    }
}
