/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Event;
import Entidades.Event.TipoEvento;
import ejbs.DiarioException;
import ejbs.EJBEvent;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author diego
 */

@Named("editEvento")
@RequestScoped
public class EditEvento {

    @Inject
    private ManageEvent manageEvento;
    
    @EJB
    private EJBEvent eventoEJB;
    
    private Event evento;
    
    private String titulo;
    private String contenido;
    private String localizacion;
    private Timestamp fecha_inicio;
    private Time horaini;
    private String contacto;
    private TipoEvento tipo_evento;

    public EditEvento() {
        evento = new Event();
    }

    public ManageEvent getManageEvento() {
        return manageEvento;
    }

    public void setManageEvento(ManageEvent manageEvento) {
        this.manageEvento = manageEvento;
    }

    public EJBEvent getEventoEJB() {
        return eventoEJB;
    }

    public void setEventoEJB(EJBEvent eventoEJB) {
        this.eventoEJB = eventoEJB;
    }

    public Event getEvento() {
        return evento;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
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

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Timestamp fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Time getHoraini() {
        return horaini;
    }

    public void setHoraini(Time horaini) {
        this.horaini = horaini;
    }

    
    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public TipoEvento getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(TipoEvento tipo_evento) {
        this.tipo_evento = tipo_evento;
    }
    
     
    
    public String modificar(){
        this.setTitulo(manageEvento.getEvento().getTitulo());
        this.setContenido(manageEvento.getEvento().getDescripcion());
        this.setContacto(manageEvento.getEvento().getContacto());
        this.setFecha_inicio((Timestamp) manageEvento.getEvento().getFecha_inicio());
        this.setLocalizacion(manageEvento.getEvento().getLocalizacion());
        this.setHoraini(manageEvento.getEvento().getHora_inicio());
        this.setTipo_evento(manageEvento.getEvento().getTipo_evento());
        
        return "modificarEvento.xhtml";
    }
    
    
    public String actualizar() throws DiarioException{
        evento = manageEvento.getEvento();
        evento.setTitulo(titulo);
        evento.setDescripcion(contenido);
        evento.setContacto(contacto);
        evento.setFecha_inicio(fecha_inicio);
        evento.setLocalizacion(localizacion);
        evento.setHora_inicio(horaini);
        evento.setTipo_evento(tipo_evento);
        eventoEJB.modificarEvento(evento);
        return "periodista.xhtml";
    }
    
    public String borrar() throws DiarioException{
        evento = manageEvento.getEvento();
        eventoEJB.borrarEvent(evento);
        return "periodista.xhtml";
    }
    
    
    
    
    
    
    
    
}
