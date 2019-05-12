
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearVehiculoArmas extends JFrame implements ActionListener, ChangeListener {

    private JPanel panelFondo,panelCrearVehiculo,panelCrearArmas;
    private JLabel labelFondo,labelCrearArmas,labelCrearVehiculo;
    private JButton guardarCambios;
    private String nombreVehiculo;
    private int posX,posY;
    private CuadroArmasVehiculos arrayCuadrosArmas[][],arrayCuadroVehiculo[][];

    private JLabel labelAgregarCambio;
    private JButton botonAgregar;
    private JRadioButton radioSi,radioNo;
    private ButtonGroup grupo;
    private JTextArea txtArea;
    private JLabel imagen;

    private VentanaUsuario ventanaU;

    public CrearVehiculoArmas(String nombreVehiculo,VentanaUsuario ventanaU){
        //this.setLayout(null);
        setBounds(0,0,800,800);
        setLocationRelativeTo(null);
        this.setVisible(false);
        setTitle("Crear/Modificar Vehículo");

        this.ventanaU = ventanaU;

        this.nombreVehiculo = nombreVehiculo;
        this.posX = posX;
        this.posY = posY;

        panelFondo = new JPanel();
        panelFondo.setLayout(null);
        panelFondo.setBounds(0,0,800,825);
        this.setContentPane(panelFondo);

        labelCrearArmas = new JLabel("Crear Armas...");
        labelCrearArmas.setBounds(50,20,200,20);
        labelCrearArmas.setForeground(new Color(250,20,20));
        labelCrearArmas.setFont(new Font("News706 BT",Font.ROMAN_BASELINE,20));
        panelFondo.add(labelCrearArmas);

        panelCrearArmas = new JPanel();
        panelCrearArmas.setLayout(null);
        panelCrearArmas.setBounds(50,45,200,100);
        panelCrearArmas.setBackground(new Color(0,0,0,64));
        panelFondo.add(panelCrearArmas);

        labelCrearVehiculo = new JLabel("Crear Vehiculo...");
        labelCrearVehiculo.setBounds(50,375,200,20);
        labelCrearVehiculo.setForeground(new Color(255,20,20));
        labelCrearVehiculo.setFont(new Font("News706 BT",Font.ROMAN_BASELINE,20));
        panelFondo.add(labelCrearVehiculo);

        panelCrearVehiculo = new JPanel();
        panelCrearVehiculo.setLayout(null);
        panelCrearVehiculo.setBounds(50,400,200,100);
        panelCrearVehiculo.setBackground(new Color(0,0,0,64));
        panelFondo.add(panelCrearVehiculo);


        labelFondo = new JLabel();
        ImageIcon imagenFon = new ImageIcon("src/imagenes/aviones/fondoPanelEast.jpg" );
        labelFondo.setBounds(0,0,800,800);
        labelFondo.setIcon(new ImageIcon(imagenFon.getImage().getScaledInstance(labelFondo.getWidth(),labelFondo.getHeight(),Image.SCALE_SMOOTH)));
        panelFondo.add(labelFondo);

        guardarCambios = new JButton("Guardar");
        guardarCambios.setBounds(640,700,125,40);
        guardarCambios.setFont(new Font("News706 BT",1,20));
        guardarCambios.setForeground(new Color(5,0,0));
        labelFondo.add(guardarCambios);
        guardarCambios.addActionListener(this);

        /**
         *
         */

        txtArea = new JTextArea();
        //txtArea.setEditable(false);
        txtArea.setOpaque(false);
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setBounds(420,160,240,230);
        txtArea.setFont(new Font("News706 BT",1,20));
        txtArea.setForeground(new Color(200,20,0));
        txtArea.setBackground(new Color(0,0,0,104));
        labelFondo.add(txtArea);

        ImageIcon icono = new ImageIcon("src/imagenes/tanques/tanq1.gif");
        imagen = new JLabel();
        imagen.setBounds(50,200,228,160);
        imagen.setIcon(icono);
        labelFondo.add(imagen);

        grupo = new ButtonGroup();

        labelAgregarCambio = new JLabel("Deseas agregar este cambio...");
        labelAgregarCambio.setHorizontalAlignment(SwingConstants.CENTER);
        labelAgregarCambio.setOpaque(true);
        labelAgregarCambio.setBounds(360,420,340,30);
        labelAgregarCambio.setFont(new Font("News706 BT",Font.ROMAN_BASELINE,20));
        labelAgregarCambio.setForeground(new Color(250,20,20));
        labelAgregarCambio.setBackground(new Color(0,0,0,154));
        labelFondo.add(labelAgregarCambio);

        radioSi = new JRadioButton("Si");
        radioSi.setOpaque(false);
        radioSi.setBounds(450,470,50,25);
        radioSi.setFont(new Font("News706 BT",Font.ROMAN_BASELINE,20));
        radioSi.setForeground(new Color(250,20,20));
        radioSi.setBackground(new Color(0,0,0,64));
        grupo.add(radioSi);
        radioSi.addChangeListener(this);
        labelFondo.add(radioSi);

        radioNo = new JRadioButton("No");
        radioNo.setOpaque(false);
        radioNo.setBounds(520,470,55,25);
        radioNo.setFont(new Font("News706 BT",Font.ROMAN_BASELINE,20));
        radioNo.setForeground(new Color(250,20,20));
        radioNo.setBackground(new Color(0,0,0,64));
        grupo.add(radioNo);
        radioNo.addChangeListener(this);
        labelFondo.add(radioNo);

        botonAgregar = new JButton("Agregar");
        botonAgregar.setBounds(452,500,120,40);
        botonAgregar.setFont(new Font("News706 BT",1,20));
        botonAgregar.setForeground(new Color(5,0,0));
        labelFondo.add(botonAgregar);
        botonAgregar.addActionListener(this);


        addPanelCrearArmas();
        addPanelCrearVehiculo();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == botonAgregar){
            System.out.println("boton agregar presionado");
        }
        if (e.getSource() == guardarCambios){
            ventanaU.setVisible(true);
            this.setVisible(false);
        }
    }

    public void stateChanged(ChangeEvent e){
        if (radioSi.isSelected()){

        }
        if (radioNo.isSelected()){

        }
    }


    public void addPanelCrearArmas(){
        int img = 1;
        this.arrayCuadrosArmas = new CuadroArmasVehiculos[2][4];
        panelCrearArmas.setLayout(new GridLayout(2, 4));
        for (int i = 0; i<2; i++){
            for (int j = 0; j<4; j++){
                this.arrayCuadrosArmas[i][j] = new CuadroArmasVehiculos(i,j,panelCrearArmas,this);
                this.arrayCuadrosArmas[i][j].setIcon(new ImageIcon("src/imagenes/imgParaArmas/"+img+".jpg"));
                img++;
            }
        }
        this.setVisible(true);
    }

    public void addPanelCrearVehiculo(){
        int ig = 1;
        this.arrayCuadroVehiculo = new CuadroArmasVehiculos[2][4];
        this.panelCrearVehiculo.setLayout(new GridLayout(2, 4));
        for (int i = 0; i<2; i++){
            for (int j = 0; j<4; j++){
                this.arrayCuadroVehiculo[i][j] = new CuadroArmasVehiculos(i,j,panelCrearVehiculo,this);
                this.arrayCuadroVehiculo[i][j].setIcon(new ImageIcon("src/imagenes/imgsTanqs/"+ig+".jpg"));
                ig++;
            }
        }
        this.setVisible(true);
    }
}
