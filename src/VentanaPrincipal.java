import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
    public class VentanaPrincipal extends JFrame {
        private Biblioteca biblioteca;
        private DefaultTableModel modelo;
        private JTable tabla;
        private JTextField campoTitulo, campoAutor, campoCodigo, campoGenero, campoAnioPublicacion, campoCopiasDisponible;
        private JTextField campoFiltroAutor;

        public VentanaPrincipal(Biblioteca biblioteca) {

            setTitle("Sistema de Gestión de Biblioteca");
            setSize(700, 450);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String[] columnas = {"Título", "Autor", "Código", "Género", "Año", "Copias"};
            DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
            JTable tabla = new JTable(modelo);
            for (Libro libro: biblioteca.obtenerTodos()){
                modelo.addRow(new Object[]{libro.getTitulo(), libro.getAutor(), libro.getCodigo(), libro.getGenero(), libro.getAnioPublicacion(), libro.getCopiasDisponible()});}
            JTextField campoTitulo=new JTextField(10); JTextField campoAutor=new JTextField(10); JTextField campoCodigo=new JTextField(10); JTextField campoGenero=new JTextField(10); JTextField campoAnioPublicacion=new JTextField(10); JTextField campoCopiasDisponible=new JTextField(10);
            JButton botonAgregar = new JButton("Agregar");
            JPanel panelFormulario = new JPanel();
            add(panelFormulario, BorderLayout.NORTH);
            add(new JScrollPane(tabla), BorderLayout.CENTER);
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





            setVisible(true);
        }
    }

