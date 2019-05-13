//import com.sun.deploy.panel.UpdatePanelFactory;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;


public class VentanaUsuario extends JFrame implements ActionListener, ChangeListener, ItemListener {
    private JButton botonCrear,botonJugar,botonAceptar,botonTienda,botonRegresar;
    private JLabel labelCrearArmas,labelCrearVehiculo,labelEscenario,labelTipoJuego,labelVehiculos,labelTienda,
            label1,label2,label3,label4,imagen1,imagen2;
    private JRadioButton radioButton4x4,radioButton6x4,radioButton8x9,radioButtonContraPC,radioButtonVS;
    private ButtonGroup botonGroup,botonGroup2;

    private JComboBox combo1;

    private int numMatrizX,numMatrizY;
    private String nombre;

    JPanel panelFondo;
    JLabel fondo;

    VentanaInicio ventanaInic;

    public VentanaUsuario(String nombre, VentanaInicio ventanaInic){
        setSize(830,500);
        setLocationRelativeTo(null);
        setBackground(Color.BLUE);
        setTitle(nombre);
        this.nombre = nombre;
        //setIconImage(new ImageIcon(getClass().getResource("src/imagenes/fondo.jpg")).getImage());

        this.ventanaInic = ventanaInic;

        panelFondo = new JPanel();
        panelFondo.setLayout(null);
        this.setContentPane(panelFondo);

        ImageIcon image = new ImageIcon("src/imagenes/fondoPantalla.jpg");
        fondo = new JLabel();
        fondo.setBounds(0,0,830,500);
        fondo.setIcon(new ImageIcon(image.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(),Image.SCALE_SMOOTH)));
        panelFondo.add(fondo);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**
         * Inicializando los atributos
         */

        botonCrear = new JButton("Crear");
        botonAceptar = new JButton("Aceptar");
        botonTienda = new JButton("Ir");
        botonJugar = new JButton("Jugar");
        botonRegresar = new JButton("Regresar");

        imagen1 = new JLabel();
        imagen2 = new JLabel();

        botonGroup = new ButtonGroup();
        botonGroup2 = new ButtonGroup();
        radioButton4x4 = new JRadioButton("4 x 4");
        radioButton6x4 = new JRadioButton("6 X 4");
        radioButton8x9 = new JRadioButton("8 x 9");
        radioButtonContraPC = new JRadioButton("Vs PC");
        radioButtonVS = new JRadioButton("Jugador 1 Vs. Jugador 2");

        combo1 = new JComboBox();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();


        /**
         * Configurando los atributos
         */

        ImageIcon imagenB = new ImageIcon("src/imagenes/botFinal1.png");
       // botonCrear.setContentAreaFilled(false);
        botonCrear.setBorderPainted(true);
        botonCrear.setBounds(110,335,140,50);
        //Color c = UIManager.getLookAndFeel().getDefaults().getColor("Panel.background");
        //botonCrear.setBackground(new Color(c.getRed(),c.getGreen(),c.getBlue()));
        botonCrear.setIcon(new ImageIcon(imagenB.getImage().getScaledInstance(botonCrear.getWidth(),botonCrear.getHeight(),Image.SCALE_SMOOTH)));
        botonCrear.addActionListener(this);
        fondo.add(botonCrear);


        labelCrearVehiculo = new JLabel("Crear Vehículo");
        labelCrearVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
        labelCrearVehiculo.setOpaque(true);
        labelCrearVehiculo.setBounds(50,250,250,25);
        labelCrearVehiculo.setFont(new Font("News706 BT",Font.ROMAN_BASELINE,20));
        labelCrearVehiculo.setForeground(new Color(250,20,20));
        labelCrearVehiculo.setBackground(new Color(0,0,0,154));
        fondo.add(labelCrearVehiculo);

        labelCrearArmas = new JLabel("Crear Armas");
        labelCrearArmas.setHorizontalAlignment(SwingConstants.CENTER);
        labelCrearArmas.setOpaque(true);
        labelCrearArmas.setBounds(50,290,250,25);
        labelCrearArmas.setFont(new Font("News706 BT",Font.ROMAN_BASELINE,20));
        labelCrearArmas.setForeground(new Color(250,20,20));
        labelCrearArmas.setBackground(new Color(0,0,0,154));
        fondo.add(labelCrearArmas);

        botonJugar.setBounds(650,70,140,50);
        ImageIcon imagenBoton2 = new ImageIcon("src/imagenes/botJugar.png");
        botonJugar.setContentAreaFilled(false);
        botonJugar.setBorderPainted(true);
        botonJugar.setIcon(new ImageIcon(imagenBoton2.getImage().getScaledInstance(botonJugar.getWidth(),botonJugar.getHeight(),Image.SCALE_SMOOTH)));
        botonJugar.addActionListener(this);
        fondo.add(botonJugar);

        radioButton4x4.setBounds(360,55,70,20);
        radioButton4x4.addChangeListener(this);
        botonGroup.add(radioButton4x4);
        fondo.add(radioButton4x4);

        radioButton6x4.setBounds(440,55,70,20);
        radioButton6x4.addChangeListener(this);
        //imagen2.add(radioButton6x4);
        botonGroup.add(radioButton6x4);
        fondo.add(radioButton6x4);

        radioButton8x9.setBounds(520,55,70,20);
        radioButton8x9.addChangeListener(this);
        //add(radioButton8x9);
        fondo.add(radioButton8x9);
        botonGroup.add(radioButton8x9);

        labelEscenario = new JLabel("Escenario: ");
        labelEscenario.setHorizontalAlignment(SwingConstants.CENTER);
        labelEscenario.setOpaque(true);
        labelEscenario.setBounds(50,55,250,25);
        labelEscenario.setFont(new Font("News706 BT",Font.ROMAN_BASELINE,20));
        labelEscenario.setForeground(new Color(250,20,20));
        labelEscenario.setBackground(new Color(0,0,0,154));
        fondo.add(labelEscenario);


        radioButtonContraPC.setBounds(360,90,70,20);
        botonGroup2.add(radioButtonContraPC);
        radioButtonContraPC.addChangeListener(this);
        fondo.add(radioButtonContraPC);

        radioButtonVS.setBounds(445,90,180,20);
        radioButtonVS.addChangeListener(this);
        botonGroup2.add(radioButtonVS);
        fondo.add(radioButtonVS);

        labelTipoJuego = new JLabel("Tipo de Juego: ");
        labelTipoJuego.setHorizontalAlignment(SwingConstants.CENTER);
        labelTipoJuego.setOpaque(true);
        labelTipoJuego.setBounds(50,90,250,25);
        labelTipoJuego.setFont(new Font("News706 BT",Font.ROMAN_BASELINE,20));
        labelTipoJuego.setForeground(new Color(250,20,20));
        labelTipoJuego.setBackground(new Color(0,0,0,154));
        fondo.add(labelTipoJuego);

        combo1.setBounds(360,125,200,20);
        fondo.add(combo1);
        combo1.addItem("");
        combo1.addItem("1 avión & 2 Tanques");
        combo1.addItem("2 aviones & 1 Tanque");
        combo1.addItem("3 aviones & 0 Tanques");
        combo1.addItem("0 aviones & 3 Tanques");
        combo1.addItemListener(this);

        labelVehiculos = new JLabel("Vehículos: ");
        labelVehiculos.setHorizontalAlignment(SwingConstants.CENTER);
        labelVehiculos.setOpaque(true);
        labelVehiculos.setBounds(50,125,250,25);
        labelVehiculos.setFont(new Font("News706 BT",Font.ROMAN_BASELINE,20));
        labelVehiculos.setForeground(new Color(250,20,20));
        labelVehiculos.setBackground(new Color(0,0,0,154));
        fondo.add(labelVehiculos);

        ImageIcon tiend = new ImageIcon("src/imagenes/ir.jpg");
        botonTienda.setBounds(540,315,70,50);
        botonTienda.setIcon(tiend);
        fondo.add(botonTienda);
        botonTienda.addActionListener(this);

        labelTienda = new JLabel("Tienda: ");
        labelTienda.setHorizontalAlignment(SwingConstants.CENTER);
        labelTienda.setOpaque(true);
        labelTienda.setBounds(450,250,250,25);
        labelTienda.setFont(new Font("News706 BT",Font.ROMAN_BASELINE,20));
        labelTienda.setForeground(new Color(250,20,20));
        labelTienda.setBackground(new Color(0,0,0,154));
        fondo.add(labelTienda);

        ImageIcon regresar = new ImageIcon("src/imagenes/regresar.jpg");
        botonRegresar.setBounds(500,380,170,50);
        botonRegresar.setIcon(regresar);
        fondo.add(botonRegresar);
        botonRegresar.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == botonCrear){
            this.setVisible(false);
            CrearVehiculoArmas ventana1 = new CrearVehiculoArmas(nombre,this);
            ventana1.setVisible(true);

            System.out.println("Ventana Usuario Presionó boton crear");

        }
        if (e.getSource() == botonJugar){
            VentanaPrincipal jugar = new VentanaPrincipal(nombre,numMatrizX,numMatrizY,ventanaInic);
            jugar.setVisible(true);
            this.setVisible(false);
            System.out.println("Press");
        }
        if (e.getSource() == botonTienda){
            Tienda tienda = new Tienda(this);
            tienda.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == botonRegresar){
            ventanaInic.setVisible(true);
            this.setVisible(false);
        }
    }
    public void stateChanged(ChangeEvent e){
        if (radioButton4x4.isSelected()){
            numMatrizX = 4;
            numMatrizY = 4;
            System.out.println("["+numMatrizX+"] ["+numMatrizY+"]");
        }if (radioButton6x4.isSelected()){
            numMatrizX = 4;
            numMatrizY = 6;
            System.out.println("["+numMatrizX+"] ["+numMatrizY+"]");
        }if (radioButton8x9.isSelected()){
            numMatrizX = 9;
            numMatrizY = 8;
            System.out.println("["+numMatrizX+"] ["+numMatrizY+"]");
        }
        if (radioButtonVS.isSelected()){
            System.out.println("VS");
        }
        if (radioButtonContraPC.isSelected()){
            System.out.println("Contra PC");
        }
    }
    public void itemStateChanged(ItemEvent e){

    }

    public int getNumMatrizX() {
        return numMatrizX;
    }

    public void setNumMatrizX(int numMatrizX) {
        this.numMatrizX = numMatrizX;
    }
    public int getNumMatrizY() {
        return numMatrizY;
    }

    public void setNumMatrizY(int numMatrizY) {
        this.numMatrizY = numMatrizY;
    }

}
