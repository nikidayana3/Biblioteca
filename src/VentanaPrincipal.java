import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {
    private Biblioteca biblioteca;
    private DefaultTableModel modelo;
    private JTable tabla;
    private JTextField campoTitulo, campoAutor, campoCodigo, campoGenero, campoAnioPublicacion, campoCopiasDisponible;
    private JTextField campoFiltroAutor;

    public VentanaPrincipal(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        setTitle("Sistema de Gestión de Biblioteca");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] columnas = {"Título", "Autor", "Código", "Género", "Año", "Copias"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);

        campoTitulo = new JTextField(10);
        campoAutor = new JTextField(10);
        campoCodigo = new JTextField(10);
        campoGenero = new JTextField(10);
        campoAnioPublicacion = new JTextField(10);
        campoCopiasDisponible = new JTextField(10);
        JButton botonAgregar = new JButton("Agregar");

        JPanel panelFormulario = new JPanel();
        panelFormulario.add(new JLabel("Título:"));
        panelFormulario.add(campoTitulo);
        panelFormulario.add(new JLabel("Autor:"));
        panelFormulario.add(campoAutor);
        panelFormulario.add(new JLabel("Código:"));
        panelFormulario.add(campoCodigo);
        panelFormulario.add(new JLabel("Género:"));
        panelFormulario.add(campoGenero);
        panelFormulario.add(new JLabel("Año:"));
        panelFormulario.add(campoAnioPublicacion);
        panelFormulario.add(new JLabel("Copias:"));
        panelFormulario.add(campoCopiasDisponible);
        panelFormulario.add(botonAgregar);

        campoFiltroAutor = new JTextField(12);
        JButton botonFiltrar = new JButton("Filtrar por autor");
        JButton botonVerTodos = new JButton("Ver todos");
        JButton botonEliminar = new JButton("Eliminar seleccionado");
        JPanel panelInferior = new JPanel();
        panelInferior.add(new JLabel("Autor:"));
        panelInferior.add(campoFiltroAutor);
        panelInferior.add(botonFiltrar);
        panelInferior.add(botonVerTodos);
        panelInferior.add(botonEliminar);

        add(panelFormulario, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        botonAgregar.addActionListener(this::agregarLibroDesdeFormulario);
        botonVerTodos.addActionListener(e -> mostrarLibros(biblioteca.obtenerTodos()));
        botonFiltrar.addActionListener(e -> mostrarLibros(biblioteca.filtrarAutor(campoFiltroAutor.getText())));
        botonEliminar.addActionListener(this::eliminarLibroSeleccionado);
        mostrarLibros(biblioteca.obtenerTodos());

        setVisible(true);
    }

    private void agregarLibroDesdeFormulario(ActionEvent e) {
        try {
            String titulo = campoTitulo.getText();
            String autor = campoAutor.getText();
            String codigo = campoCodigo.getText();
            String genero = campoGenero.getText();
            int anio = Integer.parseInt(campoAnioPublicacion.getText());
            int copias = Integer.parseInt(campoCopiasDisponible.getText());

            Libro libro = new Libro(titulo, autor, codigo, genero, anio, copias);
            boolean exito = biblioteca.agregarLibro(libro);

            if (exito) {
                mostrarLibros(biblioteca.obtenerTodos());
                campoTitulo.setText("");
                campoAutor.setText("");
                campoCodigo.setText("");
                campoGenero.setText("");
                campoAnioPublicacion.setText("");
                campoCopiasDisponible.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar. Revisa que no falten campos o que el código no esté repetido.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Año y Copias deben ser números.");
        }
    }

    private void eliminarLibroSeleccionado(ActionEvent e) {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un libro de la tabla primero.");
            return;
        }
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Eliminar este libro?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            String codigo = (String) modelo.getValueAt(fila, 2);
            for (Libro libro : biblioteca.obtenerTodos()) {
                if (libro.getCodigo().equalsIgnoreCase(codigo)) {
                    biblioteca.eliminarLibro(libro);
                    break;
                }
            }
            mostrarLibros(biblioteca.obtenerTodos());
        }
    }

    private void mostrarLibros(ArrayList<Libro> libros) {
        modelo.setRowCount(0);
        for (Libro libro : libros) {
            modelo.addRow(new Object[]{
                    libro.getTitulo(), libro.getAutor(), libro.getCodigo(),
                    libro.getGenero(), libro.getAnioPublicacion(), libro.getCopiasDisponible()
            });
        }
    }
}
