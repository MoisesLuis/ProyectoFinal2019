import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tienda extends JFrame implements ActionListener {

    private JPanel panelFondo,panelCuadros,panelBoot;
    private CuadroArmasVehiculos cuadro[][],cuadro1;
    private JTextArea txtArea;
    private JButton obtVehiculo,obtBoots, aceptar;
    private JLabel labelFondo,labelComVehiculo,labelComBoot;
    private VentanaUsuario ventana;

    public Tienda(VentanaUsuario ventana){
        this.setSize(1030,740);
        this.setEnabled(true);
        this.setLocationRelativeTo(null);

        this.ventana = ventana;

        panelFondo = new JPanel();
        panelFondo.setLayout(null);
        this.setContentPane(panelFondo);

        ImageIcon fondo = new ImageIcon("src/imagenes/fondoPantalla.jpg");
        labelFondo = new JLabel();
        labelFondo.setSize(1030,740);
        labelFondo.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(labelFondo.getWidth(),labelFondo.getHeight(),Image.SCALE_SMOOTH)));
        panelFondo.add(labelFondo);

        panelCuadros = new JPanel();
        panelCuadros.setLayout(null);
        panelCuadros.setBounds(20,50,650,400);
        labelFondo.add(panelCuadros);

        labelComVehiculo = new JLabel("Vehiculos: ");
        labelComVehiculo.setOpaque(true);
        labelComVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
        labelComVehiculo.setBounds(20,20,200,25);
        labelComVehiculo.setFont(new Font("News706 BT",1,20));
        labelComVehiculo.setForeground(new Color(200,0,0));
        labelComVehiculo.setBackground(new Color(0,0,0,64));
        labelFondo.add(labelComVehiculo);

        panelBoot = new JPanel();
        panelBoot.setLayout(null);
        panelBoot.setBounds(220,470,200,200);
        labelFondo.add(panelBoot);

        labelComBoot = new JLabel("Boots: ");
        labelComBoot.setOpaque(true);
        labelComBoot.setHorizontalAlignment(SwingConstants.CENTER);
        labelComBoot.setBounds(20,560,120,25);
        labelComBoot.setFont(new Font("News706 BT",1,20));
        labelComBoot.setForeground(new Color(200,0,0));
        labelComBoot.setBackground(new Color(0,0,0,64));
        labelFondo.add(labelComBoot);

        txtArea = new JTextArea();
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setBounds(680,50,200,300);
        txtArea.setOpaque(false);
        txtArea.setBackground(new Color(0,0,0,64));
        txtArea.setFont(new Font("News706 BT",1,20));
        txtArea.setForeground(new Color(200,0,0));
        labelFondo.add(txtArea);

        obtVehiculo = new JButton("Obtener vehículo");
        obtVehiculo.setBounds(680,380,220,40);
        obtVehiculo.setOpaque(false);
        obtVehiculo.setBackground(new Color(0,0,0,64));
        obtVehiculo.setFont(new Font("News706 BT",1,22));
        obtVehiculo.setForeground(new Color(255,0,0));
        labelFondo.add(obtVehiculo);
        obtVehiculo.addActionListener(this);

        obtBoots = new JButton("Añadir Boot");
        obtBoots.setBounds(700,450,180,40);
        obtBoots.setOpaque(false);
        obtBoots.setBackground(new Color(0,0,0,64));
        obtBoots.setFont(new Font("News706 BT",1,20));
        obtBoots.setForeground(new Color(255,0,0));
        labelFondo.add(obtBoots);
        obtBoots.addActionListener(this);

        aceptar = new JButton("Aceptar");
        aceptar.setBounds(700,600,150,40);
        aceptar.setOpaque(false);
        aceptar.setBackground(new Color(0,0,0,64));
        aceptar.setFont(new Font("News706 BT",1,20));
        aceptar.setForeground(new Color(255,0,0));
        labelFondo.add(aceptar);
        aceptar.addActionListener(this);

        addCuadros();
        addCuadroBoot();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == obtVehiculo){

        }
        if (e.getSource() == obtBoots){

        }
        if (e.getSource() == aceptar){
            ventana.setVisible(true);
            this.setVisible(false);
        }
    }

    public void addCuadros(){
        int img = 1;
        cuadro = new CuadroArmasVehiculos[2][3];
        panelCuadros.setLayout(new GridLayout(2,3));
        for (int i = 0; i<2; i++){
            for (int j = 0; j<3; j++){
                cuadro[i][j] = new CuadroArmasVehiculos(i,j,panelCuadros,this);
                cuadro[i][j].setBackground(Color.BLACK);
                cuadro[i][j].setIcon(new ImageIcon("src/imagenes/tanques/tnq"+img+".gif"));
                img++;
            }
        }
    }
    public void addCuadroBoot(){
        int img = 1;
        panelBoot.setLayout(new GridLayout(1,1));
        cuadro1 = new CuadroArmasVehiculos(1,1,panelBoot,this);
        cuadro1.setBackground(Color.BLACK);
        cuadro1.setIcon(new ImageIcon("src/imagenes/tanques/boot.gif"));

    }


}
