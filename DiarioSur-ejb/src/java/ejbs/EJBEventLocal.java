/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.*;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author H
 */
@Local
public interface EJBEventLocal {
    
   
   
    public void crearEvent(Event e) throws DiarioException;
    public void borrarEvent(Event e) throws DiarioException;
    public void modificarEvento(Event e) throws DiarioException;   
    public Event refrescarEvento(Event e)throws DiarioException;
    public List<Event> getEventos(); 
    //public List<Event> getEventos(); Para que lo quieres??
    //public List<Event> getEventosPorTipo(TipoEvento t);
   // public Event buscarEvento(Event e);
    
}
