/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Usuario;
import java.util.List;
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

    private String correoE;
    private String pass;
    private List<Usuario> usuarios;
    private Control control;

    @Inject
    private Control ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {

    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios() {
        this.usuarios = control.getUsuarios();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public String autenticar() {
        String aux = "Hola";
        for (Usuario u : usuarios) {
            if (u.getCorreoE().equalsIgnoreCase(correoE)) {

                if (u.getPassword().equals(pass)) {
                    control.setUsuario(u);
                    aux = control.home();
                } else {
                    FacesContext ctx = FacesContext.getCurrentInstance();
                    ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "contraseña errónea", "contraseña errónea"));
                }
            } else {
                FacesContext ctx = FacesContext.getCurrentInstance();
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no existe", "El usuario no existe"));
            }
        }
        return aux;
    }

}
