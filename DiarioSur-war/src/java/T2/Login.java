/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Rol;
import Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Hind
 */
@Named(value = "login")
@RequestScoped
public class Login {

    private String email;
    private String pass;
    private List<Usuario> usuarios;

    @Inject
    private Control ctrl;
    
    
    @PostConstruct
    public void init() {
        usuarios = new ArrayList<>();
         for(Usuario u : ctrl.getUsuarios()){
            usuarios.add(u);
        }
    }

    public Login(){
  
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios() {
        this.usuarios = ctrl.getUsuarios();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public String autenticar() { // autenticar checked and approved. 
        for (Usuario u : usuarios) {
            if (u.getCorreoE().equalsIgnoreCase(email)) {
                if (u.getPassword().equals(pass)) {
                    ctrl.setUsuario(u);
                } else {
                    FacesContext ctx = FacesContext.getCurrentInstance();
                    ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "contraseña errónea", "contraseña errónea"));
                }
            } else {
                FacesContext ctx = FacesContext.getCurrentInstance();
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no existe", "El usuario no existe"));
            }
        }
        return ctrl.home();
    }

}
