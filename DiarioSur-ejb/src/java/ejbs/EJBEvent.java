/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.Event;
import Entidades.Usuario.Rol;
import Entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Hind
 */
@Stateless
public class EJBEvent implements EJBEventLocal {

    @PersistenceContext(unitName = "DiarioSur1PU")
    private EntityManager em;

    /* @Override
    protected void finalize() throws Throwable {
       
    }

    @Override
    public String toString() {
        return null; //To change body of generated methods, choose Tools | Templates.
    }
     */

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void crearEvent(Event e) throws DiarioException  {
        em.persist(e);
    }

    @Override
    public void borrarEvent(Event e) throws DiarioException {
        
        Usuario u = em.find(Usuario.class, e.getUsuario());

        compruebaLogin(u);

        em.remove(e);
        
    }

    @Override
    public void modificarEvento(Event e) throws DiarioException {
        em.merge(e);
    }
    
    
    @Override
    public List<Event> getEventos(){
        TypedQuery query = em.createQuery("Select e from Event e", Event.class);
        return query.getResultList();
    }

    /*@Override Para que lo quieres?? Porque se va a usar en el método todosEventos para traerlos de la base de datos
    public List<Event> getEventos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

 /*@Override
    public Event buscarEvento(Event e) {
       
  return null;
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> getEventos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    @Override
    public Event refrescarEvento(Event e) throws DiarioException {
       
        Event even = em.find(Event.class, e.getId());

        em.refresh(even);

        return even;
        
        
    }

    private void compruebaEvento(Event e) throws DiarioException{
        Event res = em.find(Event.class, e.getId());
        if(res==null){
            throw new DiarioException("NO EXISTE EL EVENTOOO");
        }
    }
    private void compruebaLogin(Usuario u) throws DiarioException {

        Usuario us = em.find(Usuario.class, u.getCorreoE());

        if (us != null) {
            if (us.getPassword().equalsIgnoreCase(u.getPassword())) {
                if (u.getRol() == Rol.usuario_anonimo) {

                    throw new ValidacionIncorrectaException();
                }
            } else {
                throw new ContraseniaInvalidaException();
            }
        } else {
            throw new CuentaInexistenteException();
        }

    }
}
