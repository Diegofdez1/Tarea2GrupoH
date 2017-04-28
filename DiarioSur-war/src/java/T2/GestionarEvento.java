/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Comentario;
import Entidades.Evento;
import Entidades.Foto;
import Entidades.Rol;
import Entidades.TipoEvento;
import Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Grupo H
 */
@Named(value = "gestE")
@RequestScoped
public class GestionarEvento {

    private Evento evento;
    private Usuario usuario;
    private Foto foto;
    //private List<Foto> fotos;
    private List<Usuario> usuarios;
    private List<Evento> eventos; // 
    private List<Evento> pendientes;
    //private Comentario comentario;
    //private List<Comentario> comentarios;

    /**
     * Creates a new instance of GestionarEvento
     */
    public GestionarEvento() {
        eventos = new ArrayList();
        usuarios = new ArrayList();   ///// Cargar con ficticios
        pendientes= new ArrayList();
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Evento> getPendientes() {
        return pendientes;
    }

    public void setPendientes(List<Evento> pendientes) {
        this.pendientes = pendientes;
    }


    
    

    public String modificarEvento(Usuario u, Evento e) {
        if ((u.getRol().equals(Rol.superusuario)) || u.getRol().equals(Rol.administrador)) { //Control usuario aaquí?? Modificar
            evento = e;
            
        } else if (u.equals(e.getUsuario())) {
            
            pendientes.add(e);
            
        }
        else
        {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "No tiene permiso para modificar el evento.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
        return "evento.xhtml";
    }
    
    public String aniadirEvento(Evento e, String desc, String loc)
    {
        if((usuario.getRol().equals(Rol.periodista))||(usuario.getRol().equals(Rol.superusuario)))
                {
        evento=e; ///check if necessary e as parameter
        evento.setDescripcion(desc);
        evento.setLocalizacion(loc);
        eventos.add(evento);
                }
        else
        {
            pendientes.add(e); //pendientes de validar
            //// 
        }
        
        return "eventos.xhtml";
    }
    
    
    public String aniadirFoto(Evento e, String nom, String path)
    {
        evento=e;
        foto.getNombre();
        foto.getPath();
        List<Foto> fotos= evento.getFotos();
       fotos.add(foto);
       return "Evento.xhtml";
    }
    
    
    public void comentarEvento(Evento e, Comentario com)
    {
        evento=e;
        List<Comentario> comentarios=evento.getComentarios();
        comentarios.add(com);    
        //Si salimos de la vista, un retutn "Evento.xhtml"
    }
    
    public int valorarEvento(Evento e)
    {
        return e.getValoracion();
    }
    
    public List<Evento> eventosRelacionados(Evento e){
        List<Evento> res = new ArrayList<Evento>();
        for(Evento x: res){
            if(e.getTipo_evento().equals(x.getTipo_evento())){
                res.add(e);
            }else{
                if(e.getLocalizacion().equalsIgnoreCase(x.getLocalizacion())){
                    res.add(e);
                }
              
            }
        }
        return res;
        
    }
    
    public List<Evento> BuscarEvento(String busqueda, String filtro){
        List<Evento> res = new ArrayList<Evento>();
        if(filtro.equalsIgnoreCase("titulo")){
            for(Evento e: eventos){
                if(e.getTitulo().equalsIgnoreCase(busqueda)){
                    res.add(e);
                }
            }
            
        }else
            if(filtro.equalsIgnoreCase("tipo")){
            for(Evento e: eventos){
                for(TipoEvento te: TipoEvento.values()){
                    if(te.toString().equalsIgnoreCase(busqueda)){
                        res.add(e);
                    }
                    res.add(e);
                }
            }
        }
        return res;
    }
}


