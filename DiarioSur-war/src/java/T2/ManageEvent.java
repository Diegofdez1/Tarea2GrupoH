/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Comentario;
import Entidades.Event;
import Entidades.Event.TipoEvento;
import Entidades.Rol;
import Entidades.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Grupo H
 */
@Named(value = "gestE")
@RequestScoped
@ManagedBean
public class ManageEvent {


    private String titulo;
    private String contenido;
    private String localizacion;
    private Date fecha;
    private java.sql.Time horaini;
    private String telefono;
    private TipoEvento tipo;
    private String foto;
    private List<Usuario> usuarios;
    private List<Event> pendientes;
    private Event evento;
    private Usuario usuario;
    private UploadedFile file;
    private List<Event> eventos;
    private Control control;
    
    public ManageEvent(){
        eventos = new ArrayList<Event>();
    }

    @PostConstruct
    public void init() {
        eventos = new ArrayList<Event>();
        eventos.add(new Event(1, "Malaga Viva", "Contenido de la noticia1", "Malaga", new java.util.Date(2017, 5, 11), new java.sql.Time(2, 30, 00), new java.util.Date(2017, 5, 11), "607625489", TipoEvento.musica, 0, "/imagenes/foto1", ""));
        eventos.add(new Event(2, "Motos", "Contenido de la noticia2", "Malaga", new java.util.Date(2017, 6, 11), new java.sql.Time(2, 40, 00), new java.util.Date(2017, 6, 15), "607625489", TipoEvento.deporte, 0, "/imagenes/foto2", ""));
        eventos.add(new Event(3, "El mejor Restaurante", "Contenido de la noticia3", "Malaga", new java.util.Date(2017, 7, 11), new java.sql.Time(2, 50, 00), new java.util.Date(2017, 9, 19), "607625489", TipoEvento.restaurantes, 0, "/imagenes/foto3", ""));

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public java.sql.Time getHoraini() {
        return horaini;
    }

    public void setHoraini(java.sql.Time horaini) {
        this.horaini = horaini;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    

    public ManageEvent(Event e) {
        evento = e;
    }

    public Event getEvento() {
        return evento;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Event> getEventos() {
        return eventos;
    }

    public void setEventos(List<Event> eventos) {
        this.eventos = eventos;
    }

    public List<Event> getPendientes() {
        return pendientes;
    }

    public void setPendientes(List<Event> pendientes) {
        this.pendientes = pendientes;
    }

    public String modificarEvento(Usuario u, Event e) {
        if ((u.getRol().equals(Rol.superusuario)) || u.getRol().equals(Rol.administrador)) { //Control usuario aaquí?? Modificar
            evento = e;

        } else if (u.equals(e.getUsuario())) {

            pendientes.add(e);

        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "No tiene permiso para modificar el evento.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        return "eventos.xhtml";
    }

    public String nuevoEvento() {
        String vista = "eventos.xhtml";
        boolean err = false;

        FacesContext ctx = FacesContext.getCurrentInstance();
        if (evento.getTitulo().trim().equals("")) {
            ctx.addMessage("gestEvent:titulo", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contacto vacío", "Contacto vacío"));
            err = true;
        }
        if (evento.getContacto().trim().equals("")) {
            ctx.addMessage("gestEvent:contacto", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contacto vacío", "Contacto vacío"));
            err = true;
        }
        if (evento.getLocalizacion().trim().equals("")) {
            ctx.addMessage("gestEvent:localizacion", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dirección vacía", "Dirección vacía"));
            err = true;
        }
        if (evento.getDescripcion().trim().equals("")) {
            ctx.addMessage("gestEvent:descripcion", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Descripción vacía", "Descripción vacía"));
            err = true;
        }
        if (!err) {

        }
        return vista;
    }

    public void upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void comentarEvento(Event e, Comentario com) {
        evento = e;
        List<Comentario> comentarios = evento.getComentarios();
        comentarios.add(com);
        //Si salimos de la vista, un retutn "Evento.xhtml"
    }

    public int valorarEvento(Event e) {
        return e.getValoracion();
    }

    public List<String> tiposeventos(){
        List<String> res = new ArrayList<String>();
        for(TipoEvento aux :  Event.TipoEvento.values()){
            res.add( aux.toString());
        }
        
        return res;
    }
    public List<Event> eventosRelacionados(Event e) {
        List<Event> res = new ArrayList<Event>();
        for (Event x : res) {
            if (e.getTipo_evento().equals(x.getTipo_evento())) {
                res.add(e);
            } else if (e.getLocalizacion().equalsIgnoreCase(x.getLocalizacion())) {
                res.add(e);
            }
        }
        return res;

    }

    public List<Event> EventosCulturales() {
        return BuscarEvento("musica", "tipo");
    }

    public List<Event> BuscarEvento(String busqueda, String filtro) {
        List<Event> res = new ArrayList<Event>();
        if (filtro.equalsIgnoreCase("titulo")) {
            for (Event e : eventos) {
                if (e.getTitulo().equalsIgnoreCase(busqueda)) {
                    res.add(e);
                }
            }

        } else if (filtro.equalsIgnoreCase("tipo")) {
            for (Event e : eventos) {
                for (TipoEvento te : TipoEvento.values()) {
                    if (te.toString().equalsIgnoreCase(busqueda)) {
                        res.add(e);
                    }
                    res.add(e);
                }
            }
        }
        return res;
    }

    public List<Event> TodosEventos() {
        List<Event> res = new ArrayList<Event>();
        for (Event e : eventos) {
            res.add(e);
            System.out.println(e.getTitulo());
        }
        return res;
    }
    
    
}
