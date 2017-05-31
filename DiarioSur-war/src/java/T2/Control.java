/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Event;
import Entidades.Usuario;
import ejbs.DiarioException;
import ejbs.EJBEventLocal;
import ejbs.EJBUsuarioLocal;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Grupo H
 */
@Named(value = "control")
@SessionScoped
public class Control implements Serializable {

    private Usuario usuario;
    private List<Usuario> usuarios;
    private List<Event> eventos;

    @EJB
    EJBUsuarioLocal usuarioEjb;

    @EJB
    EJBEventLocal eventEjb;

    /*@PostConstruct
    public void init() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Diego", "Fernandez", "diego@gmail.com", "diego", 789456213, Rol.usuario_registrado));
        usuarios.add(new Usuario("Ruben", "Bonilla", "ruben@gmail.com", "ruben", 789456213, Rol.usuario_registrado));
        usuarios.add(new Usuario("Hind", "Gutierrez", "hind@gmail.com", "hind", 789456213, Rol.usuario_registrado));

    }
     */
    public Control() {
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario u) throws DiarioException {
        usuario = u;
    }

    public List<Event> getEventos() {
        eventos = eventEjb.getEventos();
        return eventos;
    }

    public void setEventos(Event e) {
        eventos = eventEjb.getEventos();
        eventos.add(e);
        //this.eventos = eventos;
    }

    public EJBUsuarioLocal getUsuarioEjb() {
        return usuarioEjb;
    }

    public void setUsuarioEjb(EJBUsuarioLocal usuarioEjb) {
        this.usuarioEjb = usuarioEjb;
    }

    public EJBEventLocal getEventEjb() {
        return eventEjb;
    }

    public void setEventEjb(EJBEventLocal eventEjb) {
        this.eventEjb = eventEjb;
    }

    public String home() {

        if (usuario == null) {
            return "index.xhtml";
        } else {
            //usuarios.add(usuario.getId().intValue(), usuario);
            switch (usuario.getRol()) {
                case usuario_registrado:
                    return "index.xhtml";
                case periodista:
                    return "periodista.xhtml"; //(Vista no existente)
                case superusuario:
                    return "eventos.xhtml";  // (Vista no eistente)
            }
        }
        return null;

    }

    public String getIdParam(FacesContext fc) {
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("id");
    }

    public void modificar(Usuario u) throws DiarioException {
        
        System.out.println("USUARIOOOOOOOO MODI     " + u.toString() );
        usuarioEjb.modificarUsuario(u);
            

    }

    public String borrarUsuario(Usuario u) throws DiarioException{
        usuarioEjb.borrarUsuario(u);
        this.setUsuario(null);
        return "index.xhtml";
    }
    
    public String logout() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";

    }

}
