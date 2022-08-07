package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),

})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_persona", nullable = false)
    private int idPersona;
    @Basic
    @Column(name = "nombre", nullable = true, length = 50)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = true, length = 50)
    private String apellido;
    @Basic
    @Column(name = "email", nullable = true, length = 50)
    private String email;
    @Basic
    @Column(name = "telefono", nullable = true, length = 50)
    private String telefono;
    //EAGER or lazy
    //lazy es por default
    @OneToMany(mappedBy = "personaByIdPersona",fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    private Collection<Usuario> usuariosByIdPersona;

    public Persona() {

    }
    public Persona(int idPersona) {
    this.idPersona = idPersona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return idPersona == persona.idPersona && Objects.equals(nombre, persona.nombre) && Objects.equals(apellido, persona.apellido) && Objects.equals(email, persona.email) && Objects.equals(telefono, persona.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersona, nombre, apellido, email, telefono);
    }

    public Collection<Usuario> getUsuariosByIdPersona() {
        return usuariosByIdPersona;
    }

    public void setUsuariosByIdPersona(Collection<Usuario> usuariosByIdPersona) {
        this.usuariosByIdPersona = usuariosByIdPersona;
    }

    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
