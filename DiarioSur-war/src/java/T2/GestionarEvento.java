/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Comentario;
import Entidades.Evento;
import Entidades.Evento.TipoEvento;
import Entidades.Rol;
import Entidades.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Grupo H
 */
@Named(value = "gestE")
@RequestScoped
public class GestionarEvento {


    private String titulo;
    private String contenido;
    private String localizacion;
    private Date fecha;
    private java.sql.Time horaini;
    private String telefono;
    private TipoEvento tipo;
    private String foto;
    private List<Usuario> usuarios;
    private List<Evento> pendientes;
    private Evento evento;
    private Usuario usuario;
    private UploadedFile file;
    private List<Evento> eventos;

    @PostConstruct
    public void init() {
        eventos = new ArrayList<Evento>();
        eventos.add(new Evento(1, "Malaga Viva", "Contenido de la noticia1", "Malaga", new java.util.Date(2017, 5, 11), new java.sql.Time(2, 30, 00), new java.util.Date(2017, 5, 11), "607625489", TipoEvento.musica, 0, "/imagenes/foto1", ""));
        eventos.add(new Evento(2, "Motos", "Contenido de la noticia2", "Malaga", new java.util.Date(2017, 6, 11), new java.sql.Time(2, 40, 00), new java.util.Date(2017, 6, 15), "607625489", TipoEvento.deporte, 0, "/imagenes/foto2", ""));
        eventos.add(new Evento(3, "El mejor Restaurante", "Contenido de la noticia3", "Malaga", new java.util.Date(2017, 7, 11), new java.sql.Time(2, 50, 00), new java.util.Date(2017, 9, 19), "607625489", TipoEvento.restaurantes, 0, "/imagenes/foto3", ""));

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
    private Control control;

    //private List<Foto> fotos;
    //private Comentario comentario;
    //private List<Comentario> comentarios;
    /**
     * Creates a new instance of GestionarEvento
     */
    public GestionarEvento(Evento e) {
        evento = e;
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

        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "No tiene permiso para modificar el evento.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        return "eventos.xhtml";
    }

    public String nuevoEvento() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        if (evento.getTitulo().trim().equals("")) {
            ctx.addMessage("gestE:titulo", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contacto vacío", "Contacto vacío"));
            return null;
        } else if (evento.getContacto().trim().equals("")) {
            ctx.addMessage("gestE:contacto", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contacto vacío", "Contacto vacío"));
            return null;
        } else if (evento.getLocalizacion().trim().equals("")) {
            ctx.addMessage("gestE:localizacion", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dirección vacía", "Dirección vacía"));
            return null;
        } else if (evento.getDescripcion().trim().equals("")) {
            ctx.addMessage("gestE:descripcion", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Descripción vacía", "Descripción vacía"));
            return null;
        }

        Evento e = new Evento(5, titulo, contenido, localizacion,fecha, horaini, fecha, telefono, tipo, 0, foto, "");
        control.setEventos(e);
        return control.home();

    }

    public void upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void comentarEvento(Evento e, Comentario com) {
        evento = e;
        List<Comentario> comentarios = evento.getComentarios();
        comentarios.add(com);
        //Si salimos de la vista, un retutn "Evento.xhtml"
    }

    public int valorarEvento(Evento e) {
        return e.getValoracion();
    }

    public List<Evento> eventosRelacionados(Evento e) {
        List<Evento> res = new ArrayList<Evento>();
        for (Evento x : res) {
            if (e.getTipo_evento().equals(x.getTipo_evento())) {
                res.add(e);
            } else if (e.getLocalizacion().equalsIgnoreCase(x.getLocalizacion())) {
                res.add(e);
            }
        }
        return res;

    }

    public List<Evento> EventosCulturales() {
        return BuscarEvento("musica", "tipo");
    }

    public List<Evento> BuscarEvento(String busqueda, String filtro) {
        List<Evento> res = new ArrayList<Evento>();
        if (filtro.equalsIgnoreCase("titulo")) {
            for (Evento e : eventos) {
                if (e.getTitulo().equalsIgnoreCase(busqueda)) {
                    res.add(e);
                }
            }

        } else if (filtro.equalsIgnoreCase("tipo")) {
            for (Evento e : eventos) {
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

    public List<Evento> TodosEventos() {
        List<Evento> res = new ArrayList<Evento>();
        for (Evento e : eventos) {
            res.add(e);
            System.out.println(e.getTitulo());
        }

        return res;
    }
}
