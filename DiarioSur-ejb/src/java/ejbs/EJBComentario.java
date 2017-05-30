/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.Comentario;
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
public class EJBComentario implements EJBComentarioLocal {

    @PersistenceContext(unitName = "DiarioSur1PU")
    private EntityManager em;
    


    /*@Override
    public void createComment(Comentario c) {
        em.persist(c);
    }

    @Override
    public void setComentario(Comentario comentario) {
        ///////////////////////////
    }*/

    @Override
    public void insertarComentario(Comentario c) throws DiarioException {
        
        Usuario u = em.find(Usuario.class, c.getUsuario());

        compruebaLogin(u);

        em.persist(c);
        
        
    }

    @Override
    public Comentario refrescarUsuario(Comentario c) throws DiarioException {
        
        Comentario com = em.find(Comentario.class, c.getId());

        em.refresh(com);

        return com;
        
    }

    @Override
    public void modificarComentario(Comentario c) throws DiarioException {
       
         Usuario u = em.find(Usuario.class, c.getUsuario());

        compruebaLogin(u);

        em.merge(c);
        
        
        
        
    }

    @Override
    public void borrarComentario(Comentario c)  throws DiarioException{
       
        Usuario u = em.find(Usuario.class, c.getUsuario());

        compruebaLogin(u);

        em.remove(c);
        
    }

    private void compruebaLogin(Usuario u) throws DiarioException{
        
        
        Usuario us = em.find(Usuario.class, u.getCorreoE());

        boolean encontrado = false;

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

    @Override
    public List<Comentario> getComentarios() {
        TypedQuery query = em.createQuery("Select c from Comentario c", Comentario.class);
        return query.getResultList();
    }
 }



    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

