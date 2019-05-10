//import com.sun.deploy.panel.UpdatePanelFactory;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;


public class VentanaUsuario extends JFrame implements ActionListener, ChangeListener, ItemListener {
    private JButton botonCrear,botonJugar,botonAceptar,botonAtras;
    private JLabel labelCrear,labelCrearArmas,labelJugar,label1,label2,label3,label4;
    private JRadioButton radioButton4x4,radioButton6x4,radioButton8x9,radioButtonContraPC,radioButtonVS;
    private ButtonGroup botonGroup,botonGroup2;

    private JLabel imagen1,imagen2,boton,labelFondoJugar,labelFondoCrear;

    private JComboBox combo1;

    private int numMatrizX,numMatrizY;
    private String nombre;

    JPanel panelFondo;
    JLabel fondo;

    public VentanaUsuario(String nombre){
        setSize(800,800);
        setLocationRelativeTo(null);
        setBackground(Color.BLUE);
        setTitle(nombre);
        this.nombre = nombre;
        //setIconImage(new ImageIcon(getClass().getResource("src/imagenes/fondo.jpg")).getImage());

        panelFondo = new JPanel();
        panelFondo.setLayout(null);
        this.setContentPane(panelFondo);

        ImageIcon image = new ImageIcon("src/imagenes/fondoPantalla.jpg");
        fondo = new JLabel();
        fondo.setBounds(0,0,800,800);
        fondo.setIcon(new ImageIcon(image.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(),Image.SCALE_SMOOTH)));
        panelFondo.add(fondo);
/*
        ImageIcon imagenJugar = new ImageIcon("src/imagenes/fondoJugar.png");
        labelFondoJugar = new JLabel();
        labelFondoJugar.setBounds(40,400,700,350);
        labelFondoJugar.setIcon(new ImageIcon(imagenJugar.getImage().getScaledInstance(labelFondoJugar.getWidth(),labelFondoJugar.getHeight(),Image.SCALE_SMOOTH)));
        fondo.add(labelFondoJugar);

        ImageIcon imagenCrear = new ImageIcon("src/imagenes/fondoCrear.png");
        labelFondoCrear = new JLabel();
        labelFondoCrear.setBounds(40,20,700,350);
        labelFondoCrear.setIcon(new ImageIcon(imagenCrear.getImage().getScaledInstance(labelFondoCrear.getWidth(),labelFondoCrear.getHeight(),Image.SCALE_SMOOTH)));
        fondo.add(labelFondoCrear);
*/
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**
         * Inicializando los atributos
         */

        //botonCrear = new JButton("Crear");
        botonAceptar = new JButton("Aceptar");
        botonAtras = new JButton("Atrás");
        botonJugar = new JButton("Jugar");

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
        botonCrear = new JButton();
       // botonCrear.setContentAreaFilled(false);
        botonCrear.setBorderPainted(true);
        botonCrear.setBounds(270,20,240,40);
        //Color c = UIManager.getLookAndFeel().getDefaults().getColor("Panel.background");
        //botonCrear.setBackground(new Color(c.getRed(),c.getGreen(),c.getBlue()));
        botonCrear.setIcon(new ImageIcon(imagenB.getImage().getScaledInstance(botonCrear.getWidth(),botonCrear.getHeight(),Image.SCALE_SMOOTH)));
        botonCrear.addActionListener(this);
        fondo.add(botonCrear);

        botonJugar.setBounds(340,430,200,50);
        ImageIcon imagenBoton2 = new ImageIcon("src/imagenes/botJugar.png");
        botonJugar.setContentAreaFilled(false);
        botonJugar.setBorderPainted(true);
        botonJugar.setIcon(new ImageIcon(imagenBoton2.getImage().getScaledInstance(botonJugar.getWidth(),botonJugar.getHeight(),Image.SCALE_SMOOTH)));
        botonJugar.addActionListener(this);
        fondo.add(botonJugar);


        radioButton4x4.setBounds(360,505,70,20);
        radioButton4x4.addChangeListener(this);
        botonGroup.add(radioButton4x4);
        fondo.add(radioButton4x4);

        radioButton6x4.setBounds(440,505,70,20);
        radioButton6x4.addChangeListener(this);
        //imagen2.add(radioButton6x4);
        botonGroup.add(radioButton6x4);
        fondo.add(radioButton6x4);

        radioButton8x9.setBounds(520,505,70,20);
        radioButton8x9.addChangeListener(this);
        //add(radioButton8x9);
        fondo.add(radioButton8x9);
        botonGroup.add(radioButton8x9);

        radioButtonContraPC.setBounds(360,540,70,20);
        fondo.add(radioButtonContraPC);
        radioButtonContraPC.addChangeListener(this);

        radioButtonVS.setBounds(445,540,180,20);
        radioButtonVS.addChangeListener(this);
        botonGroup2.add(radioButtonVS);

        combo1.setBounds(360,575,200,20);
        fondo.add(combo1);
        combo1.addItem("");
        combo1.addItem("1 aviones & 2 Tanques");
        combo1.addItem("2 aviones & 1 Tanques");
        combo1.addItem("3 aviones & 0 Tanques");
        combo1.addItem("0 aviones & 3 Tanques");
        combo1.addItemListener(this);


    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == botonCrear){
            CrearVehiculoArmas ventana1 = new CrearVehiculoArmas();
            ventana1.setVisible(true);
            this.setVisible(false);
            System.out.println("Presionando");

        }else if (e.getSource() == botonJugar){
            VentanaPrincipal jugar = new VentanaPrincipal(nombre,numMatrizX,numMatrizY);
            jugar.setVisible(true);
            this.setVisible(false);
            System.out.println("Press");
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
