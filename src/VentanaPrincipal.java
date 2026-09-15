import javax.swing.*;
import javax.swing.table.DefaultTableModel;

    public class VentanaPrincipal extends JFrame {

        public VentanaPrincipal() {
            setTitle("Sistema de Gestión de Biblioteca");
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String[] columnas = {"Título", "Autor", "Código", "Género", "Año", "Copias"};
            DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
            JTable tabla = new JTable(modelo);
            add(new JScrollPane(tabla));

            setVisible(true);
        }
    }

