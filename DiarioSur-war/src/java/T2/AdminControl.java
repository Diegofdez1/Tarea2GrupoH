/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Evento;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Grupo Hi
 */
@Named(value = "admCtrl")
@Dependent
public class AdminControl {
    private Evento evento;
    private List<Evento> pendientes;
    private List<Evento> eventos;

    /**
     * Creates a new instance of AdminControl
     */
    public AdminControl() {
        pendientes= new ArrayList<>();
        eventos= new ArrayList<>();
    }
    
    public String borrarEvento(Evento e)
    {
     eventos.remove(e);
     return "eventosAdm.xhtm";
    }
    
    public void validarEvento(Evento e)
    {
        evento=e;
        eventos.add(evento);
        pendientes.remove(e);
        //Nos quedamos en la misma vista con el evento validado
    }
    public void rechazarEvento (Evento e)
    {
        pendientes.remove(e);
    }
            
    
}