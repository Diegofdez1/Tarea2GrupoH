/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;


import Entidades.Usuario;
import ejbs.DiarioException;
import ejbs.EJBUsuarioLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
    
        @EJB
    EJBUsuarioLocal usuarioEjb;

    @Inject
    private Control ctrl;
    
    
   /* @PostConstruct
    public void init() {
        usuarios = new ArrayList<>();
         for(Usuario u : ctrl.getUsuarios()){
            usuarios.add(u);
        }
    }*/

    public Login(){
  
    }
    
    public List<Usuario> getUsuarios() throws DiarioException {
        usuarios=usuarioEjb.getUsuarios();     //¿NECESARIO? 
        return usuarios;
    }

   /* public void setUsuarios() {
        
        //this.usuarios = ctrl.getUsuarios(); QUÉ ES ESTO? JAJA H
    }*/

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

   

    public String autenticar() throws DiarioException { // autenticar checked and approved. 
       Usuario user = new Usuario(null, null,email,pass,0,null);
       Usuario encontrado = usuarioEjb.compruebaLogin(user);
        System.out.println("AUTENTICAaAAAARRRRRRR   " + encontrado.toString());
       ctrl.setUsuario(encontrado);
       return ctrl.home();
    }

}
