/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Entidades.Event;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author diego
 */
@Entity
public class Valoracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private ValoracionId valoracionId;
    
    @Column(name="valor")//enum
    private int valor;

    @JoinColumn(name="valEvento",referencedColumnName="descripcion")
    @ManyToOne
    private Event evento;
    
    @JoinColumn(name="valUsuario",referencedColumnName="id_usuario")
    @ManyToOne
    private Usuario usuario;

    


    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}


   

