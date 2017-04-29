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
    private String horaini;
    private Long telefono;
    private TipoEvento tipo;
    private String foto;
    private List<TipoEvento> listatipos;


    private Evento evento;
    private Usuario usuario;
    private UploadedFile file;

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

    public String getHoraini() {
        return horaini;
    }

    public void setHoraini(String horaini) {
        this.horaini = horaini;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
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
        pendientes = new ArrayList();
    }

    public GestionarEvento(Evento e) {
        evento = e;
    }

    public List<TipoEvento> getListatipos() {
        List<TipoEvento> tipos = new ArrayList<>();
        for(TipoEvento tp: Evento.TipoEvento.values()){
            tipos.add(tp);
        }
        return tipos;
     
    }

    public void setListatipos(List<TipoEvento> listatipos) {
        this.listatipos = listatipos;
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
}
