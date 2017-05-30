/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Usuario.Rol;
import Entidades.Usuario;
import ejbs.DiarioException;
import ejbs.EJBUsuario;
import ejbs.EJBUsuarioLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
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
    private int telefono;
    
        @EJB
    EJBUsuarioLocal usuarioEjb;

    @Inject
    private Control control;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EJBUsuarioLocal getUsuarioEjb() {
        return usuarioEjb;
    }

    public void setUsuarioEjb(EJBUsuarioLocal usuarioEjb) {
        this.usuarioEjb = usuarioEjb;
    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }
    
    

    public GestionarRegistro() {
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String validar() {

            usuario = new Usuario(nombre, apellidos, email, password, telefono, Rol.usuario_registrado);
            
            try{
                 usuarioEjb.registrarUsuario(usuario);
            }catch(DiarioException de){
                de.toString();
            }
           
            /// control.setUsuario(usuario);
           // control.getUsuarios().add(usuario);
 
        return "login.xhtml";

    }

}
