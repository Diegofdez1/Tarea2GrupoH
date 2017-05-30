/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diego
 */
@Entity
public class Event implements Serializable{
    
public enum TipoEvento {
    deporte, musica, cultura, viajes, cursos, restaurantes, tecnologia
}

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_evento")
    private Integer id;
    
    @Column(name = "titulo", nullable = false, length = 60)
    private String titulo;


    @Column(name = "descripcion", nullable = false, length = 60)
    private String descripcion;

    @Column(name = "localizacion", nullable = false, length = 40)
    private String localizacion;

    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio", nullable = false)
    private java.util.Date fecha_inicio;

    @Column(name = "hora_inicio", nullable = false)
    private java.sql.Time hora_inicio;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_fin", nullable = true)
    private java.util.Date fecha_fin;

    @Column(name = "contacto_evento", nullable = false, length = 20)
    private String contacto;

    @Column(name = "tipo_evento", nullable = false, length = 9)
    @Enumerated
    private TipoEvento tipo_evento;

    private boolean aceptado;
    
    @Column(name ="valoracion", nullable = true)
    private int valoracion;

    
    
    public Event() {
    }

    public boolean isAceptado() {
        return aceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }
    
    
    
    public Event(int id, String titulo, String descripcion, String localizacion, Date fecha_inicio, Time hora_inicio, String contacto, TipoEvento tipo_evento, List<Foto> images){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.localizacion = localizacion;
        this.fecha_inicio = fecha_inicio;
        this.hora_inicio = hora_inicio;
        this.contacto = contacto;
        this.tipo_evento = tipo_evento;
        this.fotos= images;
        this.aceptado = false;
    }
    
   
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    

    //--------Relaciones---------
    @ManyToOne
    @JoinColumn(name = "usuario", nullable = true)
    private Usuario usuario;

    @OneToMany
    private List<Foto> fotos;

    @OneToMany
    private List<Comentario> comentarios;
    

    //--------End Relaciones---------

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

   
    

  
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public java.util.Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Timestamp fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public java.util.Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Timestamp fecha_fin) {
        this.fecha_fin = fecha_fin;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", localizacion=" + localizacion + ", fecha_inicio=" + fecha_inicio + ", hora_inicio=" + hora_inicio + ", fecha_fin=" + fecha_fin + ", contacto=" + contacto + ", tipo_evento=" + tipo_evento + ", valoracion=" + valoracion + ", usuario=" + usuario + ", fotos=" + fotos + ", comentarios=" + comentarios + '}';
    }

    

}
