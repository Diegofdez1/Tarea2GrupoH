/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Hind
 */
@Local
public interface EJBUsuarioLocal {
    public void registrarUsuario(Usuario u) throws DiarioException;
    public void borrarUsuario(Usuario u) throws DiarioException;
    
   // public void insertarUsuario(Usuario u)throws DiarioException;
    public void modificarUsuario(Usuario u) throws DiarioException;
   public List<Usuario> getUsuarios() throws DiarioException; //Para que lo quieres?? "Para el get en el login"
    //public void registrarUsuario(Usuario u)throws AgendaException;
    public void validarCuenta(String cuenta, String rol) throws DiarioException;
    public Usuario compruebaLogin(Usuario u) throws DiarioException;
   // public Usuario refrescarUsuario(Usuario u)throws DiarioException;
   // public void modificar(Contacto c) throws AgendaException;
}
