import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
    public class VentanaPrincipal extends JFrame {

        public VentanaPrincipal(Biblioteca biblioteca) {
            setTitle("Sistema de Gestión de Biblioteca");
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String[] columnas = {"Título", "Autor", "Código", "Género", "Año", "Copias"};
            DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
            JTable tabla = new JTable(modelo);
            for (Libro libro: biblioteca.obtenerTodos()){
                modelo.addRow(new Object[]{libro.getTitulo(), libro.getAutor(), libro.getCodigo(), libro.getGenero(), libro.getAnioPublicacion(), libro.getCopiasDisponible()});}
            JTextField campoTitulo=new JTextField(10); JTextField campoAutor=new JTextField(10); JTextField campoCodigo=new JTextField(10); JTextField campoGenero=new JTextField(10); JTextField campoAnioPublicacion=new JTextField(10); JTextField campoCopiasDisponible=new JTextField(10);
            JButton botonAgregar = new JButton("Agregar");
            JPanel panelFormulario = new JPanel();
            panelFormulario.add(campoTitulo);
            panelFormulario.add(campoAutor);
            panelFormulario.add(campoCodigo);
            panelFormulario.add(campoGenero);
            panelFormulario.add(campoAnioPublicacion);
            panelFormulario.add(campoCopiasDisponible);
            panelFormulario.add(botonAgregar);

            add(panelFormulario, BorderLayout.NORTH);
            add(new JScrollPane(tabla), BorderLayout.CENTER);
            setVisible(true);
        }
    }

