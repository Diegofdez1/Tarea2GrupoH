/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Event;
import ejbs.DiarioException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import ejbs.EJBEvent;
import ejbs.EJBEventLocal;
import ejbs.EJBUsuario;
import javax.ejb.EJB;

/**
 *
 * @author Grupo Hi
 */
@Named(value = "admCtrl")
@SessionScoped
public class AdminControl implements Serializable {
    private Event evento;
    private List<Event> pendientes;
    private List<Event> eventos;
    

    @EJB
    EJBEventLocal eventEjb;
    

    /**
     * Creates a new instance of AdminControl
     */
    public AdminControl() {
        pendientes= new ArrayList<>();
        eventos= new ArrayList<>();
    }
    
    public String borrarEvento(Event e) throws DiarioException
    {
      eventEjb.borrarEvent(e);
     //eventos.remove(e);
     return "eventosAdm.xhtm";
    }
    
    public void validarEvento(Event e) throws DiarioException
    {
        evento=e;
        eventEjb.crearEvent(e);
        //eventos.add(evento);
        pendientes.remove(e);
        //Nos quedamos en la misma vista con el evento validado
    }
    public void rechazarEvento (Event e)
    {
        
        pendientes.remove(e);
    }
            
    
}