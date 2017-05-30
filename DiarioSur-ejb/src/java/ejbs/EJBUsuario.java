/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.Usuario.Rol;
import Entidades.Usuario;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hind
 */
@Stateless
@LocalBean
public class EJBUsuario implements EJBUsuarioLocal{

    //private static final int TAM_CADENA_VALIDACION = 20;

    @PersistenceContext(unitName = "DiarioSur1PU")
    private EntityManager em;
    boolean Registrado = false;

    public EJBUsuario() {
    }


    @Override
    public void registrarUsuario(Usuario u) throws DiarioException{
        System.out.println("EJBUSUARIOOOOOOOO  " + u.toString());
        Usuario user = em.find(Usuario.class, u.getCorreoE());
        if (user != null) {
            // El usuario ya existe
            throw new DiarioException("El Usuario ya existe");
        } 
        
        Registrado = true;

        u.setRol(Rol.usuario_registrado);
        em.persist(u);
        
    }

    @Override
    public void borrarUsuario(Usuario u) throws DiarioException{
        Usuario us = em.find(Usuario.class, u);

        compruebaLogin(us);

        em.remove(us);
    }

    @Override
    public void modificarUsuario(Usuario u) throws DiarioException {
        
        Usuario us = em.find(Usuario.class, u);

        compruebaLogin(us);

        em.merge(us);
    }

 
    @Override
    public List<Usuario> getUsuarios() {
        return em.createQuery("SELECT u FROM Usuario u").getResultList();
    }

    @Override
    public void validarCuenta(String cuenta, String rol) throws DiarioException {
        
        Usuario u = em.find(Usuario.class, cuenta);

        if (u == null) {
            throw new CuentaInexistenteException();
        }

        if (u.getRol()== Rol.usuario_registrado) {
            // la cuenta ya está activa

             // Eliminamos la cadena de validación, indicando que ya está activa la cuenta
            u.setRol(Rol.usuario_registrado);
            return;
        } else if (u.getRol() == Rol.administrador){
            
            u.setRol(Rol.administrador);
            return;
        }else if (u.getRol() == Rol.periodista){
        
            u.setRol(Rol.periodista);
            return;
        }

        if (!u.getRol().equals(rol)) {
            throw new ValidacionIncorrectaException();

        }//else{

        u.setRol(Rol.usuario_anonimo);
        // }
       
    }

        
    
   
    @Override
    public Usuario compruebaLogin(Usuario u)  throws DiarioException{
        
       Usuario us = em.find(Usuario.class, u.getCorreoE());

       System.out.println("COMPRUEBA LOGINNNNNNN   " + us.toString());
       
       
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
        
        return us;

    }

    /*@Override
    public Usuario refrescarUsuario(Usuario u)  throws DiarioException{ // creo que no hace falta, estas 2 clases irian en comentarios y eventos

        List<Usuario> usuarios = u.ge();
        boolean encontrado = false;

        compruebaLogin(u);

        Usuario usu = em.find(Usuario.class, u.getCuenta());

        em.refresh(usu);

        return usu;
        
        
        return null;
    }
    
      public void insertarUsuario(Usuario u)throws DiarioException{ //creo que no hacer falta
          
        Usuario us = em.find(Usuario.class, u);

        compruebaLogin(us);

        em.persist(us);
      }*/

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
