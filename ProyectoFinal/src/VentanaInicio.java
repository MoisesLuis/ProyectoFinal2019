import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame implements ActionListener {

    JLabel labelBienv,labelIngrese,labelNombre,labelEdad,labelCrearJ,imagenFondo;
    JTextField textField1,textfield2,textField3;
    JButton botonAceptar,botonCrear;
    JPanel panel1;
    private String nombre;
    public VentanaInicio(String titulo){
        //super(titulo);
        //this.setTitle(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(800,800);
        //setLocationRelativeTo(null);
        setLayout(null);
        panel1 = new JPanel();
        panel1.setLayout(null);
       // panel1.setBackground(new Color(0,0,0));
        this.setContentPane(panel1);

        labelBienv = new JLabel("Bienvenido");
        labelBienv.setBounds(320,35,350,50);
        labelBienv.setForeground(Color.white);
        labelBienv.setFont(new Font("Goudy Stout",Font.BOLD,25));
        panel1.add(labelBienv);

        labelIngrese = new JLabel("Ingrese su nombre: ");
        labelIngrese.setBounds(150,80,178,25);
        labelIngrese.setFont(new Font("Andale Mono",Font.BOLD,18));
        labelIngrese.setForeground(Color.yellow);
        panel1.add(labelIngrese);

        ImageIcon imagen = new ImageIcon("src/imagenes/botAceptar.png");
        botonAceptar = new JButton();
        botonAceptar.setContentAreaFilled(false);
        botonAceptar.setBorderPainted(true);
        botonAceptar.setBounds(370,120,120,30);
        botonAceptar.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(botonAceptar.getWidth(),botonAceptar.getHeight(),Image.SCALE_SMOOTH)));
        //imagen.add(botonCrear);
        panel1.add(botonAceptar);
        botonAceptar.addActionListener(this);


        labelCrearJ = new JLabel("Crear Jugador");
        labelCrearJ.setBounds(200,200,490,25);
        labelCrearJ.setFont(new Font("Goudy Stout",Font.BOLD,30));
        labelCrearJ.setForeground(Color.WHITE);
        panel1.add(labelCrearJ);

        labelNombre = new JLabel("Nombre: ");
        labelNombre.setBounds(255,245,100,25);
        labelNombre.setFont(new Font("Andale Mono",Font.BOLD,20));
        labelNombre.setForeground(Color.orange);
        panel1.add(labelNombre);

        labelEdad = new JLabel("Edad: ");
        labelEdad.setBounds(255,285,100,25);
        labelEdad.setFont(new Font("Andale Mono",Font.BOLD,20));
        labelEdad.setForeground(Color.yellow);
        panel1.add(labelEdad);

        textField1 = new JTextField();
        textField1.setBounds(348,80,178,25);
        panel1.add(textField1);

        textfield2 = new JTextField();
        textfield2.setBounds(348,245,178,25);
        panel1.add(textfield2);

        textField3 = new JTextField();
        textField3.setBounds(348,285,100,25);
        panel1.add(textField3);

        ImageIcon imagenCrear = new ImageIcon("src/imagenes/botFinal1.png");
        botonCrear= new JButton();
        botonCrear.setContentAreaFilled(false);
        botonCrear.setBorderPainted(true);
        botonCrear.setBounds(375,330,120,30);
        botonCrear.setIcon(new ImageIcon(imagenCrear.getImage().getScaledInstance(botonCrear.getWidth(),botonCrear.getHeight(),Image.SCALE_SMOOTH)));
        panel1.add(botonCrear);
        botonCrear.addActionListener(this);

        imagenFondo = new JLabel();
        imagenFondo.setBounds(0,0,800,500);
        imagenFondo.setOpaque(true);
        ImageIcon tanque = new ImageIcon("src/imagenes/fondo.jpg");
        imagenFondo.setIcon(new ImageIcon(tanque.getImage().getScaledInstance(800,500,Image.SCALE_SMOOTH)));
        panel1.add(imagenFondo);



       // this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == botonAceptar){
            nombre = textField1.getText();
            VentanaUsuario ventana = new VentanaUsuario(nombre);
            ventana.setVisible(true);
            this.setVisible(false);
            System.out.println("press boton aceptar");
        }else if (e.getSource() == botonCrear){
            System.out.println("press boton Crear");

        }
    }

    public static void main(String args[]){
        VentanaInicio obj1 = new VentanaInicio("titulo");
        obj1.setBounds(0,0,800,500);
        obj1.setLocationRelativeTo(null);
        obj1.setResizable(false);
        obj1.setVisible(true);
    }
}
