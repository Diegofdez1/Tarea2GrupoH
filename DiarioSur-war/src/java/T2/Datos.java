/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Evento;
import Entidades.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author diego
 */
@Named(value = "datos")
@SessionScoped
public class Datos implements Serializable {

    private List<Evento> eventos;
    private List<Usuario> usuario;
    /**
     * Creates a new instance of Datos
     */
    public Datos() {
    }
    
}
