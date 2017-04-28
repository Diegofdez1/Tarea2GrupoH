/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Usuario;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Grupo H
 */
@Named(value = "gestionarPerfil")
@Dependent
public class GestionarPerfil {
    private Usuario usuario;
    //private List<Usuario> usuarios;
    

    /**
     * Creates a new instance of GestionarPerfil
     */
    public GestionarPerfil() {
    }
    
    
    public String modificarPerfil(Usuario u,String nom, String App, Long tel)
    { //vista perfil.xhtml (Modificar perfil button)-->  a vista registrarse.xhtml modificarPerfil(...)->perfil.xhtml
        usuario=u;
        usuario.setNombre(nom);
        usuario.setApellidos(App);
        usuario.setTelefono(tel);
        return "perfil.xhtml";
    }
    
    
    
}
