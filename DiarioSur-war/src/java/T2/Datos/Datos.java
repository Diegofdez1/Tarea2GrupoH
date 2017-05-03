/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package T2.Datos;


import Entidades.Comentario;
import Entidades.Evento;
import Entidades.Evento.TipoEvento;
import Entidades.Foto;
import Entidades.Rol;
import Entidades.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author GrupoH
 */
/*
@ApplicationScoped
public class Datos implements Serializable {

    private List<Usuario> allusuarios;
    private List<Evento> alleventos;
    private List <Evento> eventos1;
    private List <Evento> eventos2;
    private List <Evento> eventos3;
    private List <Evento> eventos4;
    private List<Comentario> allcomentarios;
    private List<Comentario> comentarios1;
    private List<Comentario> comentarios2;
    private List<Comentario> comentarios3;
    private List<Comentario> comentarios4;
    private List<Foto> allfotos;
    private List<Foto> fotos1;
    private List<Foto> fotos2;
    private List<Foto> fotos3;
    private List<Foto> fotos4;
    
    
    public Datos()
            {
               allusuarios=new ArrayList<>();
               eventos1=new ArrayList<>();
               eventos2=new ArrayList<>();
               eventos3=new ArrayList<>();
               eventos4=new ArrayList<>();
               alleventos=new ArrayList<>(); 
               comentarios1=new ArrayList<>(); 
               comentarios2=new ArrayList<>(); 
               comentarios3=new ArrayList<>(); 
               comentarios4=new ArrayList<>(); 
               allcomentarios=new ArrayList<>(); 
               fotos1=new ArrayList<>(); 
               fotos2=new ArrayList<>(); 
               fotos3=new ArrayList<>(); 
               fotos4=new ArrayList<>(); 
               allfotos=new ArrayList<>(); 
            }
    
    public void fill(){
    Usuario u1=new Usuario();
    u1.setNombre("Jesus");
    u1.setApellidos("Rodriguez Garcia");
    u1.setComentarios(comentarios1);
    u1.setCorreoE("JesRodGar@gmail.com");
    u1.setEventos(eventos1);
    u1.setFotos(fotos1);
    u1.setPassword("idjsi");
    u1.setRol(Rol.administrador);
    u1.setTelefono(691223455);
    allusuarios.add(u1);
    
    Usuario u2=new Usuario();
    u2.setNombre("José");
    u2.setApellidos("Rodriguez Mendez");
    u2.setComentarios(comentarios2);
    u2.setCorreoE("JesRodMen@gmail.com");
    u2.setEventos(eventos2);
    u2.setFotos(fotos2);
    u2.setPassword("id4jsi");
    u2.setRol(Rol.periodista);
    u2.setTelefono(698233445);
    allusuarios.add(u2);

    Usuario u3=new Usuario();
    u3.setNombre("Pepe");
    u3.setApellidos("Muñoz Mendez");
    u3.setComentarios(comentarios3);
    u3.setCorreoE("PepMunMen@gmail.com");
    u3.setEventos(eventos3);
    u3.setFotos(fotos3);
    u3.setPassword("id44jsi");
    u3.setRol(Rol.superusuario);
    u3.setTelefono(692873926);
    allusuarios.add(u3);
    
    Usuario u4=new Usuario();
    u4.setNombre("Paco");
    u4.setApellidos("Jurado Lopez");
    u4.setComentarios(comentarios3);
    u4.setCorreoE("PacJurLop@gmail.com");
    u4.setEventos(eventos4);
    u4.setFotos(fotos4);
    u4.setPassword("id44jsi");
    u4.setRol(Rol.usuario_registrado);
    u4.setTelefono(93729873);
    allusuarios.add(u4);
    
    //// Deberíamos quitar el rol usuario anónimo... no sirve para nada porque no tiene que tener datos!! (Hind) 
    
    /////////Comentarios////////////
    
    Comentario com1= new Comentario();
    com1.setCuerpo("Evento Interesante");
    com1.setUsuario(u1);
    com1.setTitulo("Interesante");
    comentarios1.add(com1);
    
    Comentario com2= new Comentario();
    com2.setCuerpo("No está mal");
    com2.setUsuario(u2);
    com2.setTitulo("Not bad");
    comentarios2.add(com2);
    
    Comentario com3= new Comentario();
    com3.setCuerpo("No está nada mal");
    com3.setUsuario(u3);
    com3.setTitulo("bien");
    comentarios3.add(com3);
    
    Comentario com4= new Comentario();
    com3.setCuerpo("El evento me encantó");
    com3.setUsuario(u4);
    com3.setTitulo("Genial");
    comentarios4.add(com4);
    
    allcomentarios.add(com1);
    allcomentarios.add(com2);
    allcomentarios.add(com3);
    allcomentarios.add(com4);
    
    
    Foto f1= new Foto();
    f1.setNombre("foto1");
    f1.setPath("path/path1");
    f1.setUsuario(u1);
    fotos1.add(f1);
    
    Foto f2= new Foto();
    f2.setNombre("foto2");
    f2.setPath("path/path2");
    f2.setUsuario(u2);    
    fotos2.add(f2);
    
    Foto f3= new Foto();
    f3.setNombre("foto3");
    f3.setPath("path/path3");
    f3.setUsuario(u3);
    fotos3.add(f3);
    
    Foto f4= new Foto();
    f4.setNombre("foto4");
    f4.setPath("path/path4");
    f4.setUsuario(u4);
    fotos4.add(f4);
    
    allfotos.add(f1);
    allfotos.add(f2);
    allfotos.add(f3);
    allfotos.add(f4);
    
   
    Evento e1=new Evento();
    e1.setComentarios(comentarios1);
    e1.setContacto("contacto1");
    e1.setDescripcion("Sport");
    e1.setFecha_inicio(WED 12-11-2017); luego miro el formato y lo añado
    e1.setFecha_fin(fecha_fin);
    e1.setFotos(fotos1);
    e1.setLocalizacion("Malaga");
    e1.setTipo_evento(TipoEvento.deporte);
    e1.setUsuario(u1);
    
    Evento e2=new Evento();
    e2.setComentarios(comentarios2);
    e2.setContacto("contacto2");
    e2.setDescripcion("Musica");
    e2.setFecha_inicio(WED 12-11-2017); luego miro el formato 
   e2.setFecha_fin(fecha_fin);
    e2.setFotos(fotos2);
    e2.setLocalizacion("Malaga");
    e2.setTipo_evento(TipoEvento.musica);
    e2.setUsuario(u2);
    
    Evento e2bis=new Evento();
    e2.setComentarios(comentarios2);
    e2.setContacto("contacto2");
    e2.setDescripcion("Musica2");
    e2.setFecha_inicio(WED 12-11-2017); luego miro el formato 
    e2.setFecha_fin(fecha_fin);
    e2.setFotos(fotos2);
    e2.setLocalizacion("Malaga");
    e2.setTipo_evento(TipoEvento.musica);
    e2.setUsuario(u2);
    
    
    Evento e3=new Evento();
    e3.setComentarios(comentarios3);
    e3.setContacto("contacto3");
    e3.setDescripcion("Culture meeting");
    //e3.setFecha_inicio(WED 12-11-2017); luego miro el formato 
    //e3.setFecha_fin(fecha_fin);
    e3.setFotos(fotos3);
    e3.setLocalizacion("Malaga");
    e3.setTipo_evento(TipoEvento.cultura);
    e3.setUsuario(u3);
    
    Evento e4=new Evento();
    e4.setComentarios(comentarios4);
    e4.setContacto("contacto4");
    e4.setDescripcion("Restaurante");
    //e4.setFecha_inicio(WED 12-11-2017); luego miro el formato 
    //e4.setFecha_fin(fecha_fin);
    e4.setFotos(fotos4);
    e4.setLocalizacion("Malaga");
    e4.setTipo_evento(TipoEvento.restaurantes);
    e4.setUsuario(u4);
    
    alleventos.add(e4);
    alleventos.add(e3);
    alleventos.add(e2);
    alleventos.add(e1);

    


    
    }

    public List<Usuario> getAllusuarios() {
        return allusuarios;
    }

    public void setAllusuarios(List<Usuario> allusuarios) {
        this.allusuarios = allusuarios;
    }

    public List<Evento> getAlleventos() {
        return alleventos;
    }

    public void setAlleventos(List<Evento> alleventos) {
        this.alleventos = alleventos;
    }

    public List<Evento> getEventos1() {
        return eventos1;
    }

    public void setEventos1(List<Evento> eventos1) {
        this.eventos1 = eventos1;
    }

    public List<Evento> getEventos2() {
        return eventos2;
    }

    public void setEventos2(List<Evento> eventos2) {
        this.eventos2 = eventos2;
    }

    public List<Evento> getEventos3() {
        return eventos3;
    }

    public void setEventos3(List<Evento> eventos3) {
        this.eventos3 = eventos3;
    }

    public List<Evento> getEventos4() {
        return eventos4;
    }

    public void setEventos4(List<Evento> eventos4) {
        this.eventos4 = eventos4;
    }

    public List<Comentario> getAllcomentarios() {
        return allcomentarios;
    }

    public void setAllcomentarios(List<Comentario> allcomentarios) {
        this.allcomentarios = allcomentarios;
    }

    public List<Comentario> getComentarios1() {
        return comentarios1;
    }

    public void setComentarios1(List<Comentario> comentarios1) {
        this.comentarios1 = comentarios1;
    }

    public List<Comentario> getComentarios2() {
        return comentarios2;
    }

    public void setComentarios2(List<Comentario> comentarios2) {
        this.comentarios2 = comentarios2;
    }

    public List<Comentario> getComentarios3() {
        return comentarios3;
    }

    public void setComentarios3(List<Comentario> comentarios3) {
        this.comentarios3 = comentarios3;
    }

    public List<Comentario> getComentarios4() {
        return comentarios4;
    }

    public void setComentarios4(List<Comentario> comentarios4) {
        this.comentarios4 = comentarios4;
    }

    public List<Foto> getAllfotos() {
        return allfotos;
    }

    public void setAllfotos(List<Foto> allfotos) {
        this.allfotos = allfotos;
    }

    public List<Foto> getFotos1() {
        return fotos1;
    }

    public void setFotos1(List<Foto> fotos1) {
        this.fotos1 = fotos1;
    }

    public List<Foto> getFotos2() {
        return fotos2;
    }

    public void setFotos2(List<Foto> fotos2) {
        this.fotos2 = fotos2;
    }

    public List<Foto> getFotos3() {
        return fotos3;
    }

    public void setFotos3(List<Foto> fotos3) {
        this.fotos3 = fotos3;
    }

    public List<Foto> getFotos4() {
        return fotos4;
    }

    public void setFotos4(List<Foto> fotos4) {
        this.fotos4 = fotos4;
    }
    
    

    
}*/