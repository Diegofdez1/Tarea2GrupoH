/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Evento;
import Entidades.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Grupo H
 */
@Named(value = "ctrl")
@SessionScoped
public class Control implements Serializable {
    
    private Usuario usuario;
    private List<Usuario> usuarios;
    private List<Evento> eventos;
    
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

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Evento e) {
        eventos.add(e);
        this.eventos = eventos;
    }
    
    public String home() 
    {
        
        String aux=null;
        
        if (usuario == null) 
        {
            aux="index.xhtml";
        } 
        else 
        {
            //usuarios.add(usuario.getId().intValue(), usuario);
            switch (usuario.getRol()) {
               /* case usuario_anonimo:
                  return "index.xhtml"; */
                case usuario_registrado:
                    aux="eventos.xhtml";
                case periodista:
                    aux="periodista.xhtml"; //(Vista no existente)
                case superusuario:
                    aux="superusuario.xhtml";  // (Vista no eistente)
                   
            }
        } 
        return aux;
        //return "eventos.xhtml";
    }
    
    
    public String logout() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "home.xhtml";

    }
    
   
    
}
