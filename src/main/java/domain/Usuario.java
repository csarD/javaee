package domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Usuario.findAll", query = "SELECT p FROM Usuario p"),

})
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_usuario", nullable = false)
    private int idUsuario;
    @Basic
    @Column(name = "id_persona", nullable = true)
    private Integer idPersona;
    @Basic
    @Column(name = "username", nullable = true, length = 50)
    private String username;
    @Basic
    @Column(name = "password", nullable = true, length = 50)
    private String password;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Persona personaByIdPersona;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idUsuario == usuario.idUsuario && Objects.equals(idPersona, usuario.idPersona) && Objects.equals(username, usuario.username) && Objects.equals(password, usuario.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idPersona, username, password);
    }

    public Persona getPersonaByIdPersona() {
        return personaByIdPersona;
    }

    public void setPersonaByIdPersona(Persona personaByIdPersona) {
        this.personaByIdPersona = personaByIdPersona;
    }

    public Usuario() {
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", idPersona=" + idPersona +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", personaByIdPersona=" + personaByIdPersona +
                '}';
    }
}
