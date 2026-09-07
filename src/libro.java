public class Libro {
    private String titulo;
    private String autor;
    private String codigo;
    private String genero;
    private int anioPublicacion;
    private int copiasDisponible;

    public  Libro(String titulo,String autor,String codigo,String genero, int anioPublicacion,int copiasDisponible){
    this.titulo=titulo;
    this.autor=autor;
    this.codigo=codigo;
    this.genero=genero;
    this.anioPublicacion=anioPublicacion;
    this.copiasDisponible=copiasDisponible;
    }

}
