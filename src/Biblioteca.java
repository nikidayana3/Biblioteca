import java.util.ArrayList;
    public class Biblioteca {
        private ArrayList<Libro> libros;

        public Biblioteca() {
            libros= new ArrayList<Libro>();
        }
        public void agregarLibro(Libro libro){
            libros.add(libro);
        }
    }

