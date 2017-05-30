/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Hind
 */
@Embeddable
public class ValoracionId implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name="id_valoracion",nullable=false)
    private int id;
    
    @Column(name="id_evento",nullable=false)
    private int evento;
    
    @Column(name="id_usuario",nullable=false)
    private int usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEvento() {
        return evento;
    }

    public void setEvento(int evento) {
        this.evento = evento;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    
    

    @Override
    public String toString() {
        return "Entidades.ValoracionId[ id=" + id + " ]";
    }
    
}
