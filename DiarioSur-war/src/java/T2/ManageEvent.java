/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T2;

import Entidades.Comentario;
import Entidades.Event;
import Entidades.Event.TipoEvento;
import Entidades.Rol;
import Entidades.Usuario;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Grupo H
 */
@Named(value = "manageEvent")
@RequestScoped
@ManagedBean
public class ManageEvent {


    private String titulo;
    private String contenido;
    private String localizacion;
    private Date fecha;
    private String fechaString;
    private java.sql.Time horaini;
    private String horainiString;
    private String telefono;
    private TipoEvento tipo;
    private String tipoNum;
    private String foto;
    private List<Usuario> usuarios;
    private List<Event> pendientes;
    private Event evento;
    private Usuario usuario;
    private UploadedFile file;
    private String fileName;
    private Comentario comentario;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
    private List<Event> eventos;
    private Control control;
    public String id;
    
    public ManageEvent(){
        eventos = new ArrayList<Event>();
    }

    @PostConstruct
    public void init() {
        eventos = new ArrayList<Event>();
        eventos.add(new Event(1, "Los Álamos Beach Festival", "ABONO FESTIVAL - Incluye: Acceso al Festival los días 13, 14, 15 y 16 de Julio de 2017.\n" + "ABONO FESTIVAL CON ACAMPADA - Incluye: Acceso al Festival los días 13, 14, 15 y 16 de Julio de 2017. Y acceso a la Zona de Camping.\n" + "ABONO VIP - Incluye: Acceso al Festival los días 13, 14, 15 y 16 de Julio de 2017. Y acceso VIP, Áreas VIP, Barras y WC VIP + 10 Consumiciones.\n" + "ABONO VIP CON ACAMPADA - Incluye: Acceso al Festival los días 13, 14, 15 y 16 de Julio de 2017. Acceso VIP, Áreas VIP, Barras y WC VIP + 10 Consumiciones. Y acceso a la Zona de Camping.", "Playa de Los Álamos, Torremolinos", new java.util.Date(2017, 7, 13), new java.sql.Time(20, 00, 00), new java.util.Date(2017, 7, 16), "607625489", TipoEvento.musica, 0, "alamos.jpg", ""));
        eventos.add(new Event(2, "Campaonato Mundial 2017 Vans Global BMX", "El Bowl del Skatepark Málaga Rubén Alcántara va a ser escenario de la competición europea del Campeonato Mundial de BMX 2017 Vans Global BMX. El BMX es un deporte de acrobacia con bicicleta, en el que los deportistas, conocidos como riders realizan diferentes acrobacias, denominadas trucos. A la  vista de que este deporte tiene cada vez más profesionales y seguidores, los organizadores han decidido hacer tres semifinales, siendo Málaga la sede elegida de la competición Europea.", "Skatepark Málaga Rubén Alcántara", new java.util.Date(2017, 5, 5), new java.sql.Time(10, 00, 00), new java.util.Date(2017, 5, 7), "607625489", TipoEvento.deporte, 0, "bmx.jpg", ""));
        eventos.add(new Event(3, "Menú a elegir, barra libre, regalo de spa y ¡más!", "Pack de celebración para despedidas o cumpleaños. ¿Se acerca tu despedida de solter@ o tu cumpleaños y quieres celebrarlo por todo lo alto?", "PSpa Sensara Costa del Sol, Málaga", new java.util.Date(2017, 6, 7), new java.sql.Time(10, 00, 00), new java.util.Date(2017, 6, 8), "607625489", TipoEvento.restaurantes, 0, "sensara.jpg", ""));
        eventos.add(new Event(4, "Alicia en el país de las marvillas", "Alicia en el país de las maravillas es un musical basado en la novela de Lewis Carroll. Es el cumpleaños de Alicia y durante su fiesta se aburre y se queda dormida. Durante su sueño ve a un Conejo Blanco, vestido de forma peculiar. Alicia le sigue y comienza a caer por una madriguera llegando así al país de las maravillas, un mundo donde todos están locos. Alicia topa con una puerta donde ve un jardín y del cual se ilusiona por ver pero no será tan fácil, tendrá que correr primero en una carrera en comité, conocer a la loca Duquesa y su cocinera, tomar té con el Sombrerero Loco y la Liebre de Marzo y seguir al Gato Risón que le ayudará a entrar al jardín. Es ahí donde conocerá a la Reina de Corazones la cual le pondrá a prueba y que acabará con el despertar de Alicia de su maravilloso sueño.", "Palacio de Congresos y Exposiciones, Marbella", new java.util.Date(2017, 5, 20), new java.sql.Time(17, 00, 00), new java.util.Date(2017, 5, 20), "607625489", TipoEvento.cultura, 0, "alicia.jpg", ""));
        eventos.add(new Event(5, "El Mago Pop", "Después del éxito arrollador del 2015 el famoso mago de Discovery Max repite experiencia para dejar, una vez más, al público con la boca abierta con sus juegos de magia e ilusiones. Un espectáculo que, con una increíble puesta en escena, combina humor, ternura, una excelente técnica en manipulación de objetos, una fantástica selección musical, y la magia original e impactante que caracteriza a uno de los jóvenes ilusionistas con más proyección del mundo. Una nueva oportunidad de vivir la magia que desprende La Gran Ilusión del Mago Pop en un escenario único, en plena naturaleza y bajo las estrellas.", "Auditorio Starlite, Marbella", new java.util.Date(2017, 8, 22), new java.sql.Time(22, 30, 00), new java.util.Date(2017, 8, 22), "607625489", TipoEvento.cultura, 0, "magoPop.jpg", ""));
        eventos.add(new Event(6, "Mitad del Trayecto", "DANZA CONTEMPORANEA: El Departamento de Danza Contemporánea del Conservatorio Profesional de Danza “Pepa Flores” de Málaga tiene el placer de presentar los Talleres Coreográficos de la especialidad correspondientes al curso 2016/2017. Cumplimos tres años desde la implantación de la especialidad de Danza Contemporánea en nuestro Conservatorio. Tres años prolíficos, intensos, llenos de trabajo y dificultades, pero a la vez ilusionados y orgullosos por los resultados hasta ahora obtenidos.", "Sala Gades, Málaga", new java.util.Date(2017, 9, 6), new java.sql.Time(20, 00, 00), new java.util.Date(2017, 9, 6), "607625489", TipoEvento.cultura, 0, "danza.jpg", ""));
        eventos.add(new Event(7, "Worl Transplant Games Málaga 2017", "Los Juegos Mundiales de Deportistas Trasplantados es un Evento Deportivo de carácter Internacional para atletas trasplantados. Su celebración demuestra el éxito de las operaciones de trasplante y la posibilidad que las personas receptoras de un trasplante tengan una vida plenamente saludable. Este evento tiene como objetivo mejorar significativamente la comprensión y aceptación de la donación de órganos.", "Málaga", new java.util.Date(2017, 6, 25), new java.sql.Time(2, 30, 00), new java.util.Date(2017, 7, 2), "607625489", TipoEvento.deporte, 0, "transplant.jpg", ""));
        eventos.add(new Event(8, "Ricardo Arjona - Gira Circo Soledad", "Ricardo Arjona regresa a los escenarios de nuestro país con Circo Soledad, una gira que le llevará a recorrer Latinoamérica, Canadá, Estados Unidos y parte de Europa, y con la que volverá, después de 8 años, a actuar en las principales ciudades de España.", "Auditorio Municipal Cortijo de Torres, Málaga", new java.util.Date(2017, 5, 24), new java.sql.Time(21, 30, 00), new java.util.Date(2017, 5, 24), "607625489", TipoEvento.cultura, 0, "circoSoledad.jpg", ""));
        eventos.add(new Event(9, "Robe Iniesta - Bienvenidos al Temporal", "Concierto de la nueva gira del aclamado cantante, compositor y guitarrista del grupo de rock nacional Extremoduro.", "Auditorio Municipal Cortijo de Torres, Málaga", new java.util.Date(2017, 5, 22), new java.sql.Time(20, 30, 00), new java.util.Date(2017, 5, 22), "607625489", TipoEvento.musica, 0, "robe.jpg", ""));
        eventos.add(new Event(10, "Fotografía y Emociones", "El objetivo del curso es aprender a expresar nuestras emociones a través de la fotografía de forma creativa e interpretar, mediante unas claves iconográficas, las emociones contenidas en las imágenes. Aprenderás los parámetros básicos en fotografía (luz, color, encuadre) y cómo sacarle el máximo partido a tu cámara reflex o compacta. Con la coach, conocerás las claves para comenzar a expresar y captar emociones a través del medio fotográfico.", "Benalmádena, Málaga", new java.util.Date(2017, 5, 3), new java.sql.Time(00, 00, 00), new java.util.Date(2017, 8, 3), "607625489", TipoEvento.cursos, 0, "cursoFotografia.jpg", ""));
        eventos.add(new Event(11, "Curso online: Community Manager y E-Commerce", "En este curso se tratan conceptos fundamentales de lo que es el comercio electrónico (e-comerce) pero con una característica especial que lo convierte en un curso realmente práctico. Nos referimos a que se incluye un programa concreto de comercio electrónico que permite manejar y poner en práctica los conceptos estudiados.", "Online", new java.util.Date(2017, 5, 3), new java.sql.Time(00, 00, 00), new java.util.Date(2017, 8, 3), "607625489", TipoEvento.cursos, 0, "cursoCM.jpg", ""));
        eventos.add(new Event(12, "Cursos inglés, alemán, francés, italiano + certificado", "En Funmedia están avalados por el prestigioso certificado de calidad \"Sello Europeo de las Lenguas\". Un premio que se otorga a las iniciativas más novedosas en el campo de la enseñanza y del aprendizaje de idiomas.", "Online", new java.util.Date(2017, 5, 3), new java.sql.Time(00, 00, 00), new java.util.Date(2017, 8, 3), "607625489", TipoEvento.cursos, 0, "cursoIdiomas.jpg", ""));
        eventos.add(new Event(13, "eCongress Málaga", "La mayor Feria y Congreso de e-commerce, Social Media y Marketing Digital del Sur de Europa. Conferencias, Networking, talleres formativos gratuitos, sorteos y muchas más sorpresas te esperan en eCongress Málaga ¿Te lo vas a perder?", "Diputación de Málaga", new java.util.Date(2017, 3, 26), new java.sql.Time(10, 00, 00), new java.util.Date(2017, 3, 27), "607625489", TipoEvento.tecnologia, 0, "eCongressV.jpg", ""));
        eventos.add(new Event(14, "Greencities", "8º Foro de Inteligencia y Sostenibilidad Urbana. Punto de encuentro entre profesionales, representantes institucionales y empresas para mostrar sus productos, servicios y experiencias entre los agentes involucrados en el desarrollo de las ciudades inteligentes y en la mejora de la calidad de vida del ciudadano.", "Palacio de Ferias y Congresos de Málaga", new java.util.Date(2017, 5, 7), new java.sql.Time(10, 00, 00), new java.util.Date(2017, 5, 8), "607625489", TipoEvento.tecnologia, 0, "greenCities.jpg", ""));
        eventos.add(new Event(15, "Hi!Drone Technology, la Feria Tecnológica de Drones de Andalucía", "Málaga celebrará el próximo mes de junio de 2017 la Semana de la Innovación en la que se enmarca la octava edición de Greencities. Además, coincidirá en espacio y tiempo en las instalaciones de FYCMA, con la primera edición de Hi!Drone Technology, el primer Salón de Tecnologías Drone 100% profesional de Andalucía, y con el congreso de EBAN, European Business Angel Network (Red de Inversores del Emprendimiento).", "Palacio de Ferias y Congresos de Málaga", new java.util.Date(2017, 6, 7), new java.sql.Time(10, 00, 00), new java.util.Date(2017, 6, 8), "607625489", TipoEvento.tecnologia, 0, "hiDrone.jpg", ""));
        eventos.add(new Event(16, "25 Piezas de sushi + vino ¡take away para 2 personas!", "Si eres un apasionado/a del sushi, disfruta del menú take away que te ofrecemos degustar, con descuento, en Sashimi Gastrobar. No te lo pienses más y aprovecha esta excelente oportunidad para degustar una bandeja de 25 piezas para recoger en el local y ¡disfrutar donde tú quieras!", "Sashimi Gastrobar, Teatinos-Universidad, Málaga", new java.util.Date(2017, 6, 7), new java.sql.Time(10, 00, 00), new java.util.Date(2017, 6, 8), "607625489", TipoEvento.restaurantes, 0, "sushi.jpg", ""));
    
    }
    
    
    //get value from "f:param"
    public String getIdParam(FacesContext fc){
            Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
            return params.get("id");
    }
    
    public void createComment(){
       comentario.setUsuario(usuario);
       List<Comentario> aux = evento.getComentarios();
       aux.add(comentario);
       evento.setComentarios(aux);  
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Comentario getComentario() {
        return comentario;
    }
    
    public String outcome(){

            FacesContext fc = FacesContext.getCurrentInstance();
            id = getIdParam(fc);
            for (Event e : eventos) {
                if(String.valueOf(e.getId()).equals(id)){
                    this.setEvento(e);
                }
            System.out.println(e.getTitulo());
        }
            System.out.println("hola");
            return "eventoInfo.xhtml";
    }
    
    public String getId(){
        return id;
    }
            

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public void setFechaString(String fechaString) {
        this.fechaString = fechaString;
    }

    public void setTipoNum(String tipoNum) {
        this.tipoNum = tipoNum;
    }

    public String getFechaString() {
        return fechaString;
    }

    public String getTipoNum() {
        return tipoNum;
    }

    public java.sql.Time getHoraini() {
        return horaini;
    }

    public void setHoraini(java.sql.Time horaini) {
        this.horaini = horaini;
    }
    
    public void setHorainiString(String horainiString) {
        this.horainiString = horainiString;
    }

    public String getHorainiString() {
        return horainiString;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    

    public ManageEvent(Event e) {
        evento = e;
    }

    public Event getEvento() {
        return evento;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Event> getEventos() {
        return eventos;
    }

    public void setEventos(List<Event> eventos) {
        this.eventos = eventos;
    }

    public List<Event> getPendientes() {
        return pendientes;
    }

    public void setPendientes(List<Event> pendientes) {
        this.pendientes = pendientes;
    }

    public String modificarEvento(Usuario u, Event e) {
        if ((u.getRol().equals(Rol.superusuario)) || u.getRol().equals(Rol.administrador)) { //Control usuario aaquí?? Modificar
            evento = e;

        } else if (u.equals(e.getUsuario())) {

            pendientes.add(e);

        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "No tiene permiso para modificar el evento.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        return "eventos.xhtml";
    }

    public String nuevoEvento() throws Exception{
        Random rnd = new Random();
        tipo = TipoEvento.valueOf(tipoNum);
        String[] parts = fechaString.split("-");
        fecha = new java.util.Date(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        String[] parts1 = horainiString.split(":");
        horaini = new java.sql.Time(Integer.parseInt(parts1[0]), Integer.parseInt(parts1[1]), 00);
        Event e;
        if(file==null){
            e = new Event(rnd.nextInt(), titulo, contenido, localizacion, fecha, horaini, telefono, tipo, "noimage.jpg");
        }else{
            fileName = file.getFileName();
            byte[] contents = file.getContents();
            FileOutputStream fos = new FileOutputStream("/resources/"+fileName);
            try{
                fos.write(contents);
            }catch(Exception exc){
                System.out.println(exc);
            }finally{
                fos.close();
            }
            e = new Event(rnd.nextInt(), titulo, contenido, localizacion, fecha, horaini, telefono, tipo, fileName);
        }
        setEvento(e);
        eventos.add(e);
        
        return "eventoInfo.xhtml";
     
    }
    
    /*public void uploadFile(FileUploadEvent event) throws Exception{
        UploadedFile uploadedFile = event.getFile();
        fileName = uploadedFile.getFileName();
        String contentType = uploadedFile.getContentType();
        byte[] contents = uploadedFile.getContents();
        FileOutputStream fos = new FileOutputStream("/resources/"+fileName);
        try{
        fos.write(contents);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            fos.close();
        }    
    }*/
    
    public void upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void comentarEvento(Event e, Comentario com) {
        evento = e;
        List<Comentario> comentarios = evento.getComentarios();
        comentarios.add(com);
        //Si salimos de la vista, un retutn "Evento.xhtml"
    }

    public int valorarEvento(Event e) {
        return e.getValoracion();
    }

    public List<String> tiposeventos(){
        List<String> res = new ArrayList<String>();
        for(TipoEvento aux :  Event.TipoEvento.values()){
            res.add( aux.toString());
        }
        
        return res;
    }
    public List<Event> eventosRelacionados(Event e) {
        List<Event> res = new ArrayList<Event>();
        for (Event x : res) {
            if (e.getTipo_evento().equals(x.getTipo_evento())) {
                res.add(e);
            } else if (e.getLocalizacion().equalsIgnoreCase(x.getLocalizacion())) {
                res.add(e);
            }
        }
        return res;

    }


    public List<Event> buscarEvento(String busqueda, String filtro) {
        List<Event> res = new ArrayList<Event>();
        if (filtro.equalsIgnoreCase("titulo")) {
            for (Event e : eventos) {
                if (e.getTitulo().equalsIgnoreCase(busqueda)) {
                    res.add(e);
                }
            }

        } else if (filtro.equalsIgnoreCase("tipo")) {
            for (Event e : eventos) {
                for (TipoEvento te : TipoEvento.values()) {
                    if (te.toString().equalsIgnoreCase(busqueda)) {
                        res.add(e);
                    }
                    res.add(e);
                }
            }
        }
        return res;
    }

    public List<Event> todosEventos() {
        List<Event> res = new ArrayList<Event>();
        for (Event e : eventos) {
            res.add(e);
            System.out.println(e.getTitulo());
        }
        return res;
    }
    
    public List<Event> eventosTipo(TipoEvento te) {
        List<Event> res = new ArrayList<Event>();
        for (Event e : eventos) {
            if(te.equals(e.getTipo_evento())){
              res.add(e);  
            }
            
        }
        return res;
    }
    
    public List<Event> eventosDeportivos(){
        return eventosTipo(TipoEvento.deporte);
    }
    
    public List<Event> eventosMusicales(){
        return eventosTipo(TipoEvento.musica);
    }
    
    public List<Event> eventosCulturales(){
        return eventosTipo(TipoEvento.cultura);
    }
    
    public List<Event> eventosViajes(){
        return eventosTipo(TipoEvento.viajes);
    }
    
    public List<Event> eventosCursos(){
        return eventosTipo(TipoEvento.cursos);
    }
    
    public List<Event> eventosRestaurantes(){
        return eventosTipo(TipoEvento.restaurantes);
    }
    
    public List<Event> eventosTecnologia(){
        return eventosTipo(TipoEvento.tecnologia);
    }
        
    
    
    
}
