/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Entidades.Event;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
    
    @JoinColumn(name="valUsuario",referencedColumnName="id_usuario")
    @ManyToOne
    private Usuario usuario;
    
    public Valoracion() {
    }   
    
    public ValoracionId getValoracionId() {
        return valoracionId;
    }

    public void setValoracionId(ValoracionId valoracionId) {
        this.valoracionId = valoracionId;
    }

    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.valoracionId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Valoracion other = (Valoracion) obj;
        if (!Objects.equals(this.valoracionId, other.valoracionId)) {
            return false;
        }
        return true;
    }
    
    
}


   

