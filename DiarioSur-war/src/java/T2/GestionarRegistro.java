/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Rol;
import Entidades.Usuario;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author H
 */
@Named(value = "gestionarRegistro")
@RequestScoped
public class GestionarRegistro {
    private Usuario usuario;
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    private String password2;
    private Long telefono;
    private Rol rol;
    
    @Inject
    private Control control;
    
   

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.apellidos = Apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
   
    public String validar(){
        FacesContext ctx = FacesContext.getCurrentInstance(); 
        if(nombre.trim().equals("")){
         ctx.addMessage("gestionarRegistro:nombre", new FacesMessage(FacesMessage.SEVERITY_ERROR, "nombre vacío","Nombre vacío"));
         return null;
        }else if(apellidos.trim().equals("")){
            ctx.addMessage("gestionarRegistro:apellidos", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Apellidos vacío","Apellidos vacío"));
            return null;
        }else if(email.trim().equals("")){
            ctx.addMessage("gestionarRegistro:email", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email vacío","Email vacío"));
            return null;
        }else if(password.trim().equals("")){
            ctx.addMessage("gestionarRegistro:password", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password vacío","Password vacío"));
            return null;
            
        }else if(password2.trim().equals("")){
            ctx.addMessage("gestionarRegistro:password2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password2 vacío","Password2 vacío"));
            return null;
        }else if(telefono==null){
            ctx.addMessage("gestionarRegistro:telefono", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Telefono vacío","Telefono vacío"));
            return null;
        }
        
        usuario = new Usuario(nombre,apellidos,email,password,password2,telefono,Rol.usuario_registrado);
        control.setUsuario(usuario);
        return control.home();
             
           
      
    }
}
