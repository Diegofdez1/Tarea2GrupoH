/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import Entidades.Comentario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Hind
 */
@Local
public interface EJBComentarioLocal {
    
    
    public void insertarComentario(Comentario c)throws DiarioException;
    public Comentario refrescarUsuario(Comentario c)throws DiarioException;
    public void borrarComentario (Comentario c) throws DiarioException;
    public void modificarComentario(Comentario c) throws DiarioException;
    public List<Comentario> getComentarios();
   // public void createComment(Comentario c);
   // public void setComentario(Comentario comentario);
    
}
