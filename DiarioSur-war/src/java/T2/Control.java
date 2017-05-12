/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Event;
import Entidades.Rol;
import Entidades.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void init() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Diego", "Fernandez", "diego@gmail.com", "diego", 789456213, Rol.usuario_registrado));
        usuarios.add(new Usuario("Ruben", "Bonilla", "ruben@gmail.com", "ruben", 789456213, Rol.usuario_registrado));
        usuarios.add(new Usuario("Hind", "Gutierrez", "hind@gmail.com", "hind", 789456213, Rol.usuario_registrado));

    }

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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        usuarios.add(usuario);
    }

    public List<Event> getEventos() {
        return eventos;
    }

    public void setEventos(Event e) {
        eventos.add(e);
        this.eventos = eventos;
    }

    public String home() {

        if (usuario == null) {
            return "index.xhtml";
        } else {
            //usuarios.add(usuario.getId().intValue(), usuario);
            switch (usuario.getRol()) {
                case usuario_registrado:
                    return "eventosregistrado.xhtml";
                case periodista:
                    return "periodista.xhtml"; //(Vista no existente)
                case superusuario:
                    return "eventos.xhtml";  // (Vista no eistente)
            }
        }
        return null;

    }

    public String logout() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";

    }

}
