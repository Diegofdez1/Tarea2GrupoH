/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;
import java.util.List;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author diego
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Long id;
     
    @Column (name= "nombre", nullable=false, length = 10)
    private String nombre;
    
    @Column (name= "apellidos", nullable=false, length = 20)
    private String apellidos;

    @Column (name = "correoE", nullable = false, length = 20)
    private String correoE;
    
    @Column (name = "password", nullable = false, length = 20)
    private String password;
    
    @Column (name = "telefono", nullable = true, length = 12)
    private int telefono;
    
    @Enumerated(EnumType.STRING)
    @Column (name = "rol", nullable = false, length = 10)
    private Rol rol;

    public Usuario(String nombre, String apellidos, String correoE, String password, int telefono,Rol rol) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoE = correoE;
        this.password = password;
        this.telefono = telefono;
        this.rol =rol;
        
    }
    
    
    
    //--------Relaciones---------
    @OneToMany(mappedBy="usuario")
    private List<Event> eventos;
    
    @OneToMany(mappedBy="usuario")
    private List<Foto> fotos;
    
    @OneToMany(mappedBy="usuario")
    private List<Comentario> comentarios;

    public Usuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    //--------End Relaciones---------
    
    
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    

    public List<Event> getEventos() {
        return eventos;
    }

    public void setEventos(List<Event> eventos) {
        this.eventos = eventos;
    }
    
    

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public int getTelefono() {
        return telefono;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correoE=" + correoE + ", password=" + password + ", telefono=" + telefono + ", rol=" + rol + ", eventos=" + eventos + ", fotos=" + fotos + ", comentarios=" + comentarios + '}';
    }

    
    
    
}
