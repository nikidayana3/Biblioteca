import java.util.ArrayList;
import java.util.HashMap;
    public class Biblioteca {
        private ArrayList<Libro> libros;
        private HashMap<String, ArrayList<Libro>>indiceAutor;
        private String[] generosValidos = {"Novela", "Ciencia", "Historia", "Infantil", "Tecnico"};

        public Biblioteca() {
            libros= new ArrayList<Libro>();
            indiceAutor=new HashMap<String, ArrayList<Libro>>();
        }
        public boolean agregarLibro(Libro libro) {
            if (libro.getTitulo() == null || libro.getTitulo().isEmpty()) {
                return false;
            }
            if (libro.getAutor() == null || libro.getAutor().isEmpty()) {
                return false;
            }
            if (libro.getCodigo() == null || libro.getCodigo().isEmpty()) {
                return false;
            }

            for (Libro l : libros) {
                if (l.getCodigo().equalsIgnoreCase(libro.getCodigo())) {
                    return false;
                }
            }

            libros.add(libro);

            String autor = libro.getAutor();
            if (!indiceAutor.containsKey(autor)) {
                indiceAutor.put(autor, new ArrayList<Libro>());
            }
            indiceAutor.get(autor).add(libro);

            return true;
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

