public class libro {
    private String titulo;
    private String autor;
    private String codigo;
    private String genero;
    private int anioPublicacion;
    private int copiasDisponible;

    public  libro(String titulo,String autor,String codigo,String genero, int anioPublicacion,int copiasDisponible){
        this.titulo=titulo;
        this.autor=autor;
        this.codigo=codigo;
        this.genero=genero;
        this.anioPublicacion=anioPublicacion;
        this.copiasDisponible=copiasDisponible;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor=autor;

    }
    public String getCodigo(){
        return codigo;
    }
    public void  setCodigo(String codigo){
        this.codigo=codigo;
    }
    public String getGenero(){
        return genero;
    }
    public void setGenero(String genero){
        this.genero=genero;
    }
    public int getAnioPublicacion(){
        return anioPublicacion;
    }
    public void setAnioPublicacion(int anioPublicacion){
        this.anioPublicacion=anioPublicacion;
    }
    public int getCopiasDisponible(){
        return copiasDisponible;
    }
    public void setCopiasDisponible(int copiasDisponible){
        this.copiasDisponible=copiasDisponible;
    }
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Codigo: " + codigo + ", Genero: "+ genero
                + ", Año de publicacion: " + anioPublicacion + ", Copias disponible: " + copiasDisponible;

    }
}
