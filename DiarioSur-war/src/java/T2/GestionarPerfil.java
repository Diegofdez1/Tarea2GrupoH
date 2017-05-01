/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Grupo H
 */
@Named(value = "gestionarPerfil")
@SessionScoped

public class GestionarPerfil implements Serializable {
    private Usuario usuario;
    //private List<Usuario> usuarios; NO!!!!
    private String email;
    private String nombre;
    private String apellidos;
    private int telefono;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    

    /**
     * Creates a new instance of GestionarPerfil
     */
    public GestionarPerfil() {
    }
    
    
    public String crearPerfil(Usuario u, String mail, String nom, String Ap, int tel)
    { //vista perfil.xhtml (Modificar perfil button)-->  a vista registrarse.xhtml modificarPerfil(...)->perfil.xhtml
        usuario=u;
        usuario.setCorreoE(mail);
        usuario.setNombre(nom);
        usuario.setApellidos(Ap);
        usuario.setTelefono(tel);
        return "perfil.xhtml";
    }
    
    
    
}
