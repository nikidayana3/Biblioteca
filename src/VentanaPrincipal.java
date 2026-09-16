import javax.swing.*;
import javax.swing.table.DefaultTableModel;

    public class VentanaPrincipal extends JFrame {

        public VentanaPrincipal(Biblioteca biblioteca) {
            setTitle("Sistema de Gestión de Biblioteca");
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String[] columnas = {"Título", "Autor", "Código", "Género", "Año", "Copias"};
            DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
            JTable tabla = new JTable(modelo);
            add(new JScrollPane(tabla));
            for (Libro libro: biblioteca.obtenerTodos()){
                modelo.addRow(new Object[]{libro.getTitulo(), libro.getAutor(), libro.getCodigo(), libro.getGenero(), libro.getAnioPublicacion(), libro.getCopiasDisponible()});}

            setVisible(true);
        }
    }

