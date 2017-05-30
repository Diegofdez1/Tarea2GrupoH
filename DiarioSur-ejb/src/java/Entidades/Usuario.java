/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;
import java.util.List;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 *
 * @author diego
 */
@Entity
public class Usuario implements Serializable {

    public enum Rol{     
        administrador, periodista, superusuario, usuario_registrado, usuario_anonimo}
    

    
    private static final long serialVersionUID = 1L;
     
    @Column (name= "nombre", nullable=false, length = 100)
    private String nombre;
    
    @Column (name= "apellidos", nullable=false, length = 20)
    private String apellidos;

    @Id
    @Column (name = "correoE", nullable = false, length = 20)
    private String correoE;
    
    @Column (name = "password", nullable = false, length = 20)
    private String password;
    
    @Column (name = "telefono", nullable = true, length = 12)
    private int telefono;
    
    @Enumerated(EnumType.STRING)
    @Column (name = "rol", nullable = false, length = 100)
    private Rol rol;
    
   
    
   public Usuario() {
        
    }
   

    public Usuario(String nombre, String apellidos, String correoE, String password, int telefono,Rol rol) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoE = correoE;
        this.password = password;
        this.telefono = telefono;
        this.rol = rol;
        
    }
    
    
    
    //--------Relaciones---------
    @OneToMany(mappedBy="usuario")
    private List<Event> eventos;
    
    @OneToMany(mappedBy="usuario")
    private List<Foto> fotos;
    
    @OneToMany(mappedBy="usuario")
    private List<Comentario> comentarios;

    

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    //--------End Relaciones---------
    
    
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
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

  
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.correoE);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.correoE, other.correoE)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
