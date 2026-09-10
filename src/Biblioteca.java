import java.util.ArrayList;
    public class Biblioteca {
        private ArrayList<Libro> libros;

        public Biblioteca() {
            libros= new ArrayList<Libro>();
        }
        public void agregarLibro(Libro libro){
            libros.add(libro);
        }
        public ArrayList<Libro> obtenerTodos(){
            return libros;
        }
        public void eliminarLibro(Libro libro) {
            libros.remove(libro);
        }
        public ArrayList<Libro> filtrarAutor(String autor){
            ArrayList<Libro> resultado = new ArrayList<Libro>();
            for (Libro libro : libros) {
                if (libro.getAutor().equalsIgnoreCase(autor)) {
                    resultado.add(libro);
                }
            }
            return resultado;
        }
    }

