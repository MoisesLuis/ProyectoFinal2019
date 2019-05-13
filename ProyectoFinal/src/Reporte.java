import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reporte extends JFrame implements ActionListener {
    private JTextField textFieldNombre,textFieldEdad;
    private JButton agregarButton;
    private JButton botonGuardar;
    private JButton botonEliminar;
    private JButton botonAceptar;
    private JPanel panel;
    private JLabel labNombre,labEdad;
    //TablaVentana pan;
    DefaultTableModel table1;
    JTable tabla;

    public Reporte(){
        this.setSize(820,650);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setBackground(new Color(100,100,100));
        this.setContentPane(panel);

        labNombre = new JLabel("Nombre: ");
        labNombre.setHorizontalAlignment(SwingConstants.CENTER);
        labNombre.setOpaque(true);
        labNombre.setBounds(50,20,150,25);
        labNombre.setFont(new Font("News706 BT",1,20));
        labNombre.setForeground(new Color(200,0,0));
        labNombre.setBackground(new Color(0,0,0,164));
        panel.add(labNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(200,20,200,25);
        textFieldNombre.setVisible(true);
        panel.add(textFieldNombre);

        labEdad = new JLabel("Edad: ");
        labEdad.setBounds(430,20,100,25);
        labEdad.setHorizontalAlignment(SwingConstants.CENTER);
        labEdad.setOpaque(true);
        labEdad.setFont(new Font("News706 BT",1,20));
        labEdad.setForeground(new Color(200,0,0));
        labEdad.setBackground(new Color(0,0,0,164));
        panel.add(labEdad);

        textFieldEdad = new JTextField();
        textFieldEdad.setBounds(520,20,100,25);
        panel.add(textFieldEdad);

        agregarButton = new JButton("Agregar");
        agregarButton.setBounds(660,20,100,35);
        panel.add(agregarButton);
        agregarButton.addActionListener(this);

        botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(520,55,100,35);
        panel.add(botonGuardar);
        botonGuardar.addActionListener(this);

        botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(660,55,100,35);
        panel.add(botonEliminar);
        botonEliminar.addActionListener(this);

        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(660,540,100,35);
        panel.add(botonAceptar);
        botonAceptar.addActionListener(this);

       // pan = new TablaVentana();



        String cabecera[]={"Nombre","Edad","Nivel"};
        String datos[][]={};
        table1 = new DefaultTableModel(datos,cabecera);
        table1.setColumnCount(5);

        tabla = new JTable(5,3);
        tabla.setBackground(Color.green);
        tabla.setModel(table1);
        tabla.setVisible(true);
        panel.add(tabla);



        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == botonGuardar){

        }
        if (e.getSource() == botonEliminar){

        }
        if (e.getSource() == botonAceptar){

        }
    }

}
