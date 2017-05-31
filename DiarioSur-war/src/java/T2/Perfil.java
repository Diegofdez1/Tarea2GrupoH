/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Usuario;
import ejbs.DiarioException;
import ejbs.EJBUsuario;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author diego
 */
@Named("perfil")
@RequestScoped
public class Perfil {

   @Inject
   private Control ctrl;
   
   @EJB
   private EJBUsuario usuarioEJB;
   
   private Usuario usuario;

   private String email;
   private String nombre;
   private String apellidos;
   private String password;
   private int telefono;

    public Perfil() {
        usuario = new Usuario();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public void setEmail(String email) {
        this.email = email;
    }

    
    public Control getCtrl() {
        return ctrl;
    }

    public void setCtrl(Control ctrl) {
        this.ctrl = ctrl;
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

    public EJBUsuario getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(EJBUsuario usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    public String modificar(){
        this.setEmail(ctrl.getUsuario().getCorreoE());
        this.setPassword(ctrl.getUsuario().getPassword());
        this.setNombre(ctrl.getUsuario().getNombre());
        this.setApellidos(ctrl.getUsuario().getApellidos());
        this.setTelefono(ctrl.getUsuario().getTelefono());
        return "modificarPerfil.xhtml";
    }
    
    public String actualizar() throws DiarioException{
        
        usuario = ctrl.getUsuario();
        usuario.setPassword(password);
        usuario.setApellidos(apellidos);
        usuario.setNombre(nombre);
        usuario.setTelefono(telefono);
         
        usuarioEJB.modificarUsuario(usuario);
        
        return "perfil.xhtml";
       
    }
   
   
}
