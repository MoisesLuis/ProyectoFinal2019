import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class VentanaPrincipal extends JFrame implements ActionListener {
    //private JPanel panelEscenario,panelElejir;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuArchivo, menuOpciones;
    private JMenuItem menuItemNuevo,menuItemNuevoRapido,menuItemGuardar,menuItemCargar,menuItemEstadisticas;
    private JLabel labelElejirVehiculo,labelTirarDados,labelTirarDados2,imagenPanelSouth;
    private JButton botonTanq,botonAvion,botonTirarDado,botonTirarDado2;

    Cuadro matrizCuadros[][];
    int matrizLogicaE[][];

    private Montaña montaña;
    private Lago lago;
    private Avion miAvion;
    private EVehiculo tanqueEnemigo;
    private MVehiculo miTanque;

    VentanaUsuario parametros;
    int numCuadrosX,numCuadrosY,posXDeMVeh,posYDeMVe;
    ImageIcon imagenTanque;

    private MoverVehiculo ventanaMoverVehiculo;

    protected Random aleatorio;
    protected int aleaPosX = 0,aleaPosY=0,contadorCantAleatorio,contadorAgua,contadorMontaña,contadorTanque,contadorAvion,contadorEnemigo;
    String nombre;


    JPanel panel,panelCenter,panelSouth,panelEast;

    private JTextArea txtAreaReporte,txtAreaInfo;
    private JLabel title1,title2,fondoPanelEast;

    VentanaInicio ventanaInicio;

    public VentanaPrincipal(String titulo,int numCuadrosX,int numCuadrosY,VentanaInicio ventanaInicio){
        super(titulo);
        setLayout(null);
        this.setTitle(titulo);
        this.setUndecorated(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1105,1005);
        //this.setVisible(true);
        this.setResizable(false);
        //this.getContentPane().setBackground(new Color(0,0,0,0));

        this.ventanaInicio = ventanaInicio;

        nombre = titulo;
        matrizLogicaE = new int[numCuadrosX][numCuadrosY];

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(100,0,0));
        this.setContentPane(panel);


        panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBackground(new Color(0,10,0));
        panelCenter.setBounds(0,0,800,800);
        panel.add(panelCenter);
        //contentPane.add(panelFondo);

        panelEast = new JPanel();
        panelEast.setLayout(null);
        panelEast.setBounds(800,0,300,1005);
        panelEast.setBackground(new Color(50,50,50));
        panel.add(panelEast);

        ImageIcon fondoPanelEas = new ImageIcon("src/imagenes/aviones/fondoPanelEast.jpg");
        fondoPanelEast = new JLabel();
        fondoPanelEast.setBounds(0,0,300,1005);
        fondoPanelEast.setIcon(new ImageIcon(fondoPanelEas.getImage().getScaledInstance(400,1005,Image.SCALE_SMOOTH)));
        panelEast.add(fondoPanelEast);

        panelSouth = new JPanel();
        panelSouth.setLayout(null);
        panelSouth.setBounds(0,800,800,150);
        panelSouth.setBackground(new Color(50,100,50));
        panel.add(panelSouth);

        ImageIcon fondPanelSouth = new ImageIcon("src/imagenes/center.png");
        imagenPanelSouth = new JLabel();
        imagenPanelSouth.setBounds(0,0,800,150);
        imagenPanelSouth.setIcon(new ImageIcon(fondPanelSouth.getImage().getScaledInstance(imagenPanelSouth.getWidth(),imagenPanelSouth.getHeight(),Image.SCALE_SMOOTH)));
        panelSouth.add(imagenPanelSouth);

        imagenTanque = new ImageIcon("src/imagenes/tanques/tanqEnemigoXDefecto.gif");

        this.numCuadrosX = numCuadrosX;
        this.numCuadrosY = numCuadrosY;

        aleatorio = new Random();
        contadorCantAleatorio = 0;
        contadorAgua = 0;
        contadorMontaña = 0;
        contadorAvion=0;
        contadorTanque=0;
        contadorEnemigo=0;


        labelElejirVehiculo = new JLabel("Elejir el vehículo: ");
        labelElejirVehiculo.setBounds(120,15,250,20);
        labelElejirVehiculo.setForeground(new Color(100,100,150));
        labelElejirVehiculo.setFont(new Font("Consolas",Font.ITALIC,20));
        //labelElejirVehiculo.setOpaque(true);
        //labelElejirVehiculo.setBackground(Color.BLACK);
        //labelElejirVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
        imagenPanelSouth.add(labelElejirVehiculo);

        labelTirarDados = new JLabel("Movimiento: ");
        labelTirarDados.setBounds(480,15,150,20);
        labelTirarDados.setFont(new Font("Consolas",Font.ITALIC,20));
        labelTirarDados.setForeground(new Color(100,100,150));
        imagenPanelSouth.add(labelTirarDados);

        labelTirarDados2 = new JLabel("Disparo: ");
        labelTirarDados2.setBounds(660,15,100,20);
        labelTirarDados2.setFont(new Font("Consolas",Font.ITALIC,20));
        labelTirarDados2.setForeground(new Color(100,100,150));
        imagenPanelSouth.add(labelTirarDados2);

        menuBar = new JMenuBar();
        menuBar.setOpaque(false);
        //menuBar.setForeground(new Color(200,200,200));
        menuBar.setBackground(new Color(255,255,255,200));
        setJMenuBar(menuBar);

        menuArchivo = new JMenu("Archivo");
        menuBar.add(menuArchivo);

        menuItemNuevo = new JMenuItem("Nuevo partida");
        menuItemNuevo.addActionListener(this);
        menuArchivo.add(menuItemNuevo);

        menuItemNuevoRapido = new JMenuItem("Nuevo partida rápida");
        menuItemNuevoRapido.addActionListener(this);
        menuArchivo.add(menuItemNuevoRapido);

        menuItemCargar = new JMenuItem("Cargar");
        menuItemCargar.addActionListener(this);
        menuArchivo.add(menuItemCargar);

        menuItemGuardar = new JMenuItem("Guardar");
        menuItemGuardar.addActionListener(this);
        menuArchivo.add(menuItemGuardar);

        menuOpciones = new JMenu("Opciones");
        menuBar.add(menuOpciones);

        menuItemEstadisticas = new JMenuItem("Estadisticas y Reportes");
        menuItemEstadisticas.addActionListener(this);
        menuOpciones.add(menuItemEstadisticas);
/*
        TitledBorder bordePanelEscenario = new TitledBorder("Escenario");
        bordePanelEscenario.setTitleJustification(TitledBorder.CENTER);
        bordePanelEscenario.setTitlePosition(TitledBorder.TOP);
        panelCenter.setBorder(bordePanelEscenario);
*/
        /*
        TitledBorder bordePanelElejir = new TitledBorder("");
        panelElejir.setBorder(bordePanelElejir);
*/

        botonAvion = new JButton();
        botonAvion.addActionListener(this);
        botonTanq = new JButton();
        botonTanq.addActionListener(this);
        botonTirarDado = new JButton();
        botonTirarDado.addActionListener(this);
        botonTirarDado2 = new JButton();
        botonTirarDado2.addActionListener(this);


        ImageIcon tanq = new ImageIcon("src/imagenes/tanques/bT.gif");
        botonTanq.setBounds(20,35,200,100);
        botonTanq.setIcon(tanq);
        botonTanq.setBorder(null);
        botonTanq.setContentAreaFilled(false);
        botonTanq.setBorderPainted(true);


        ImageIcon avion = new ImageIcon("src/imagenes/avion.png");
        botonAvion.setBounds(240,35,150,100);
        botonAvion.setIcon(new ImageIcon(avion.getImage().getScaledInstance(botonAvion.getWidth(),botonAvion.getHeight(),Image.SCALE_SMOOTH)));
        botonAvion.setBorderPainted(true);
        botonAvion.setContentAreaFilled(false);
        botonAvion.setBorder(null);

        ImageIcon dados = new ImageIcon("src/imagenes/dad.gif");
        botonTirarDado.setBounds(460,35,150,100);
        botonTirarDado.setIcon(dados);
        botonTirarDado.setContentAreaFilled(false);
        botonTirarDado.setBorderPainted(true);
        botonTirarDado.setBorder(null);

        ImageIcon dados2 = new ImageIcon("src/imagenes/tanques/ataq.gif");
        botonTirarDado2.setBounds(620,35,150,100);
        botonTirarDado2.setIcon(dados2);
        botonTirarDado2.setContentAreaFilled(false);
        botonTirarDado2.setBorderPainted(true);
        //botonTirarDado2.setBorder(null);

        colocarEscenario();
        imagenPanelSouth.add(labelElejirVehiculo);
        imagenPanelSouth.add(labelTirarDados);
        imagenPanelSouth.add(botonTanq);
        imagenPanelSouth.add(botonAvion);
        imagenPanelSouth.add(botonTirarDado);
        imagenPanelSouth.add(botonTirarDado2);
        //this.setContentPane(panel);

        txtAreaInfo = new JTextArea();
        txtAreaInfo.setEditable(false);
        txtAreaInfo.setBorder(null);
        txtAreaInfo.setOpaque(false);
        txtAreaInfo.setBackground(new Color(0,0,0,64));
        txtAreaInfo.setBounds(10,50,280,450);
        txtAreaInfo.setFont(new Font("News706 BT",Font.BOLD,18));
        txtAreaInfo.setForeground(Color.RED);
        fondoPanelEast.add(txtAreaInfo);

        txtAreaReporte = new JTextArea();
        txtAreaReporte.setEditable(false);
        txtAreaReporte.setBorder(null);
        txtAreaReporte.setOpaque(false);
        txtAreaReporte.setBackground(new Color(20,20,20,64));
        txtAreaReporte.setBounds(10,600,280,300);
        txtAreaReporte.setFont(new Font("News706 BT",Font.BOLD,18));
        txtAreaReporte.setForeground(Color.RED);
        fondoPanelEast.add(txtAreaReporte);

        title1 = new JLabel("Reportes");
        title1.setBounds(100,20,110,20);
        title1.setOpaque(false);
        title1.setFont(new Font("Algerian",Font.ROMAN_BASELINE,20));
        title1.setForeground(new Color(255,255,255));
        fondoPanelEast.add(title1);

        title2 = new JLabel("Información de los vehiculos");
        title2.setBounds(10,570,290,20);
        title2.setOpaque(false);
        title2.setFont(new Font("Algerian",Font.ROMAN_BASELINE,20));
        title2.setForeground(new Color(255,255,255));
        fondoPanelEast.add(title2);

        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     *
     * @param e
     * El metodo siguiente es el que nos servirá
     * para los eventos de cada boton
     */

    public void actionPerformed(ActionEvent e){
        int a=0,b=0;
        if (e.getSource() == botonTanq){
            encontrarMiVehiculoEnPos();
            abilitarTCamino();
            for (int i = 0; i<numCuadrosX; i++){
                for (int j = 0; j<numCuadrosY; j++){
                    if (matrizLogicaE[posXDeMVeh][posYDeMVe] == 5){
                        quitarMiVehiculoActual();
                        cambiarAvionATanque();
                    }
                }
            }
            txtAreaInfo.setLineWrap(true);
            txtAreaInfo.setWrapStyleWord(true);
            txtAreaInfo.setText("                                \n"+
                    "            Vehiculo:  \n"+
                    "                                \n"+
                    "   Nombre:  "+miTanque.getNombre()+"\n"+
                    "                              \n"+
                    "            Vida:      "+miTanque.getVida()+"           \n"+
                    "            PP:  "+miTanque.getPp()+"                   \n"+
                    "            Nivel:  "+miTanque.getNivel()+"             \n"+
                    "            Experiencia:  "+miTanque.getExp()+"         \n"+
                    "            Armas:  "+miTanque.getArmas()+"             \n"+
                    "                                                        \n"+
                    "                                                        \n"+
                    "            Ataque:    "+miTanque.getAtaque()+"         \n"+
                    "            Defensa:   "+miTanque.getDefensa()+"        \n"+
                    "            Puntería:  "+miTanque.getPunteria()+"       \n"+
                    " Movimiento Especial:  "+miTanque.getMovimientoEspecial()+" \n"+
                    "                                                         \n"+
                    "                                                         \n");
            System.out.println("Estas presionando el:  Tanque");
            System.out.println("["+posXDeMVeh+"]"+"["+posYDeMVe+"]");
            System.out.println(matrizLogicaE[posXDeMVeh][posYDeMVe]);
            System.out.println("/////////////////////////////////");
        }
        else if (e.getSource() == botonAvion){
            encontrarMiVehiculoEnPos();
            abilitarTCamino();
            for (int i = 0; i<numCuadrosX; i++){
                for (int j = 0; j<numCuadrosY; j++){
                    if (matrizLogicaE[posXDeMVeh][posYDeMVe] == 4){
                        quitarMiVehiculoActual();
                        cambiarTanqueAAvion();
                    }
                }
            }
            txtAreaInfo.setLineWrap(true);
            txtAreaInfo.setWrapStyleWord(true);
            txtAreaInfo.setText("                                                   \n"+
                    "            Vehiculo:        \n"+
                    "                                                   \n"+
                    "   Nombre:  "+miTanque.getNombre()+"  \n"+
                    "                                      \n"+
                    "            Vida:      "+miAvion.getVida()+"               \n"+
                    "            PP:  "+miAvion.getPp()+"                       \n"+
                    "            Nivel:  "+miAvion.getNivel()+"                 \n"+
                    "            Experiencia:  "+miAvion.getExp()+"             \n"+
                    "            Armas:  "+miAvion.getArmas()+"  \n"+
                    "                                                     \n"+
                    "                                                     \n"+
                    "            Ataque:    "+miAvion.getAtaque()+"              \n"+
                    "            Defensa:   "+miAvion.getDefensa()+"             \n"+
                    "            Puntería:  "+miAvion.getPunteria()+"            \n"+
                    "            Velocidad: "+miAvion.getVelocidad()+"           \n"+
                    "  Movimiento Especial:  "+miAvion.getMovimientoEspecial()+" \n"+
                    "                                                     \n"+
                    "                                                     \n");

            System.out.println("Estas presionando el: Avion");
            System.out.println("["+posXDeMVeh+"]"+"["+posYDeMVe+"]");
            System.out.println(matrizLogicaE[posXDeMVeh][posYDeMVe]);
            System.out.println("/////////////////////////////////");
        }
        else if (e.getSource() == botonTirarDado){
            System.out.println("Estas presionando el: Dado para moverte");
            encontrarMiVehiculoEnPos();
            ventanaMoverVehiculo = new MoverVehiculo(posXDeMVeh,posYDeMVe,numCuadrosX,numCuadrosY,matrizCuadros,panel,1,matrizLogicaE,this,
                    montaña,lago,miAvion,tanqueEnemigo,miTanque,txtAreaReporte);
            System.out.println("["+posXDeMVeh+"]["+posYDeMVe+"]");
        }
        else if (e.getSource() == botonTirarDado2){
            System.out.println("Estas presionando el: Dado para hacer Daño");
            encontrarMiVehiculoEnPos();
            ventanaMoverVehiculo = new MoverVehiculo(posXDeMVeh,posYDeMVe,numCuadrosX,numCuadrosY,matrizCuadros,panel,2,matrizLogicaE,this,
                    montaña,lago,miAvion,tanqueEnemigo,miTanque,txtAreaReporte);
        }
        else if (e.getSource() == menuItemNuevoRapido){
            limpiarEscenario();
            contadorAgua =0;
            contadorMontaña=0;
            contadorEnemigo=0;
            contadorTanque=0;
            contadorAvion=0;
            contadorCantAleatorio=0;
            colocarEscenario();
        }
        else if (e.getSource() == menuItemNuevo){
            VentanaUsuario regresar = new VentanaUsuario(nombre,ventanaInicio);
            regresar.setVisible(true);
            this.setVisible(false);
        }
        else if(e.getSource() == menuItemEstadisticas){
            Reporte report = new Reporte();
            report.setVisible(true);
            this.setVisible(false);
        }

    }

    /**
     *
     */

    public void colocarTierra(){
        String tierra = "src/imagenes/tierra/tierra.jpg";
        while (encontrarEnemigo()==false)
            numAleatorio();
        matrizRecorridoInsertarImagen(tierra);
    }

    public void colocarETanque(){
        String enemigo = "src/imagenes/tanques/Et.gif";
        while (matrizLogicaE[aleaPosX][aleaPosY] !=0) {
            aleaPosX = aleatorio.nextInt(this.numCuadrosX/2);
            aleaPosY = aleatorio.nextInt(this.numCuadrosY);
        }
        tanqueEnemigo = new EVehiculo(matrizCuadros,enemigo,aleaPosX,aleaPosY,numCuadrosX,numCuadrosY,nombre);
        //matrizRecorridoInsertarImagen(enemigo);
    }
    public void colocarEAvion(){
        String enemigo = "src/imagenes/tanques/Et.gif";
        numAleatorio();
        matrizRecorridoInsertarImagen(enemigo);
    }
    public void colocarAgua(){
        String agua = "src/imagenes/agua/aguaf.gif";
        while (matrizLogicaE[aleaPosX][aleaPosY]!=0)
            numAleatorio();
        lago = new Lago(matrizCuadros,agua,aleaPosX,aleaPosY,numCuadrosX,numCuadrosY);
    }

    public void colocarMontaña(){
        String montaña = "src/imagenes/montaña/Montaña.jpg";
        while (matrizLogicaE[aleaPosX][aleaPosY] !=0)
            numAleatorio();
        this.montaña = new Montaña(matrizCuadros,montaña,aleaPosX,aleaPosY,numCuadrosX,numCuadrosY);
    }

    public void colocarMTanque(){
        String tanque = "src/imagenes/tanques/Mt.gif";
        while (matrizLogicaE[aleaPosX][aleaPosY] !=0) {
            aleaPosX = 2+aleatorio.nextInt(this.numCuadrosX-2);
            aleaPosY = aleatorio.nextInt(this.numCuadrosY);
        }
        miTanque = new MVehiculo(matrizCuadros,tanque,aleaPosX,aleaPosY,numCuadrosX,numCuadrosY,nombre);
        matrizLogicaE[aleaPosX][aleaPosY] = 4;
    }
    public void alMoverMTanque(int posX, int posY){
        String tanque = "src/imagenes/tanques/Mt.gif";
        miTanque = new MVehiculo(matrizCuadros,tanque,posX,posY,numCuadrosX,numCuadrosY,nombre);
        matrizLogicaE[posX][posY] = 4;
    }
    public void alMoverMAvion(int posX, int posY){
        String tanque = "src/imagenes/aviones/mA.gif";
        miTanque = new MVehiculo(matrizCuadros,tanque,posX,posY,numCuadrosX,numCuadrosY,nombre);
        matrizLogicaE[posX][posY] = 5;
    }
    public void quitarMTanqueAlMover(int posX,int posY){
        ImageIcon imagen = new ImageIcon("src/imagenes/tierra/tierra.jpg");
        this.matrizCuadros[posX][posY].setIcon(imagen);
        matrizLogicaE[posX][posY] = 0;
        System.out.println("["+posX+"]["+posY+"]");
        System.out.println(matrizLogicaE[posX][posY]);
        //this.matrizCuadros[posX][posY] = null;

    }
    public void colocarMAvion(){
        String avion = "src/imagenes/aviones/mA.gif";
        while (matrizLogicaE[aleaPosX][aleaPosY] !=0) {
            aleaPosX = 2+aleatorio.nextInt(this.numCuadrosX-2);
            aleaPosY = aleatorio.nextInt(this.numCuadrosY);
        }
        miAvion = new Avion(matrizCuadros,avion,aleaPosX,aleaPosY,numCuadrosX,numCuadrosY,nombre);
        matrizLogicaE[aleaPosX][aleaPosY]= 5;
    }
    public void cambiarTanqueAAvion(){
        String avion = "src/imagenes/aviones/mA.gif";
        miAvion = new Avion(matrizCuadros,avion,posXDeMVeh,posYDeMVe,numCuadrosX,numCuadrosY,nombre);
        for (int i = 0; i<numCuadrosX; i++){
            for (int j = 0; j<numCuadrosY; j++){
                if (matrizLogicaE[i][j] == 4){
                    matrizLogicaE[i][j] = 5;
                }
            }
        }
        /*
        ImageIcon avion = new ImageIcon("src/imagenes/aviones/avion.gif");
        matrizCuadros[i][j].setIcon(new ImageIcon());
        matrizCuadros[i][j].setContentAreaFilled(false);
        matrizCuadros[i][j].setBorderPainted(true);
        matrizCuadros[i][j].setIcon(avion);*/
    }
    public void cambiarAvionATanque(){
        String tanque = "src/imagenes/tanques/Mt.gif";
        miTanque = new MVehiculo(matrizCuadros,tanque,posXDeMVeh,posYDeMVe,numCuadrosX,numCuadrosY,nombre);
        for (int i = 0; i<numCuadrosX; i++){
            for (int j = 0; j<numCuadrosY; j++){
                if (matrizLogicaE[i][j] == 5){
                    matrizLogicaE[i][j] = 4;
                }
            }
        }
        /*
        ImageIcon tanque = new ImageIcon("src/imagenes/tanques/Mt.gif");
        matrizCuadros[i][j].setIcon(new ImageIcon());
        matrizCuadros[i][j].setContentAreaFilled(false);
        matrizCuadros[i][j].setBorderPainted(true);
        matrizCuadros[i][j].setIcon(tanque);
        */
    }
    public void quitarMiVehiculoActual(){
        for (int i = 0; i<numCuadrosX; i++){
            for (int j = 0; j<numCuadrosY; j++){
                if (matrizLogicaE[i][j] == 5){
                    miTanque = null;
                    miAvion = null;
                }
            }
        }
    }

    public void colocarEscenario(){
        this.matrizCuadros = new Cuadro[numCuadrosX][numCuadrosY];
        panelCenter.setLayout(new GridLayout(numCuadrosX,numCuadrosY));
        for (int i = 0; i<numCuadrosX; i++){
            for (int j = 0; j<numCuadrosY; j++){
                this.matrizCuadros[i][j] = new Cuadro(i,j,panelCenter,this);
                ImageIcon imagen = new ImageIcon("src/imagenes/tierra/tierra.jpg");
                matrizCuadros[i][j].setIcon(new ImageIcon());
                matrizCuadros[i][j].setContentAreaFilled(false);
                matrizCuadros[i][j].setBorderPainted(true);
                matrizCuadros[i][j].setIcon(new ImageIcon(imagen.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH)));
            }
        }

        while (contadorCantAleatorio < 3){
            colocarETanque();
            matrizLogicaE [aleaPosX][aleaPosY] = 1;
            System.out.println(matrizLogicaE[aleaPosX][aleaPosY]);
            System.out.println("["+aleaPosX+"]  ["+aleaPosY+"]");
            contadorCantAleatorio++;
        }

        while (contadorAgua < 3){
            colocarAgua();
            matrizLogicaE[aleaPosX][aleaPosY] = 2;
            System.out.println(matrizLogicaE[aleaPosX][aleaPosY]);
            System.out.println("["+aleaPosX+"]  ["+aleaPosY+"]");
            contadorAgua++;
        }


        while (contadorMontaña < 3){
            colocarMontaña();
            matrizLogicaE[aleaPosX][aleaPosY] = 3;
            System.out.println(matrizLogicaE[aleaPosX][aleaPosY]);
            System.out.println("["+aleaPosX+"]  ["+aleaPosY+"]");
            contadorMontaña++;
        }

        colocarMTanque();


        this.setVisible(true);
    }

    public void limpiarEscenario(){
        for (int i = 0; i<numCuadrosX; i++){
            for (int j = 0; j<numCuadrosY; j++){
                matrizCuadros[i][j] = null;
                matrizLogicaE[i][j] = 0;
            }
            panelCenter.removeAll();
        }
        panelCenter.repaint();
    }

    public boolean encontrarEnemigo(){
        if (matrizLogicaE[aleaPosX][aleaPosY] == 1)
            return true;
        return false;
    }
    public int encontrarEnemigoPosicion(){
        for (int i = 0; i<numCuadrosX; i++){
            for (int j = 0; j<numCuadrosY; j++){
                if (matrizLogicaE[i][j] == 1)
                    return matrizLogicaE[i][j];
            }
        }
        return 0;
    }

    public boolean encontrarAgua(){
        if (matrizLogicaE[aleaPosX][aleaPosY] == 2)
            return true;
        return false;
    }
    public boolean encontrarMontaña(){
        if (matrizLogicaE[aleaPosX][aleaPosY] == 3)
            return true;

        return false;
    }
    public boolean encontrarComodin(){
        if (matrizLogicaE[aleaPosX][aleaPosY] == 6)
            return true;

        return false;
    }

    public void encontrarMiVehiculoEnPos(){
        for (int i = 0; i<numCuadrosX; i++){
            for (int j = 0; j<numCuadrosY; j++){
                if (matrizLogicaE[i][j] == 4 || matrizLogicaE[i][j] == 5){
                    posXDeMVeh = i;
                    posYDeMVe = j;
                    break;
                }
            }
        }
    }

    public void numAleatorio(){
        aleaPosX = aleatorio.nextInt(this.numCuadrosX);
        aleaPosY = aleatorio.nextInt(this.numCuadrosY);
    }
    public void matrizRecorridoInsertarImagen(String direct){
        ImageIcon imagen = new ImageIcon(direct);
        for (int i = 0; i<numCuadrosX; i++){
            for (int j = 0; j<numCuadrosY; j++){
                matrizCuadros[aleaPosX][aleaPosY].setIcon(new ImageIcon());
                matrizCuadros[aleaPosX][aleaPosY].setContentAreaFilled(false);
                matrizCuadros[aleaPosX][aleaPosY].setBorderPainted(true);
                matrizCuadros[aleaPosX][aleaPosY].setIcon(imagen);
            }
        }

    }
    public void abilitarTCamino(){
        for (int i = 0; i<numCuadrosX; i++){
            for (int j = 0; j<numCuadrosY; j++){
                matrizCuadros[i][j].setEnabled(true);
            }
        }
    }

    public void setTxtAreaReporte(JTextArea txtAreaReporte) {
        this.txtAreaReporte = txtAreaReporte;
    }

    public JTextArea getTxtAreaReporte() {
        return txtAreaReporte;
    }

    public Montaña getMontaña() {
        return montaña;
    }

    public Lago getLago() {
        return lago;
    }

    public Avion getMiAvion() {
        return miAvion;
    }

    public EVehiculo getTanqueEnemigo() {
        return tanqueEnemigo;
    }

    public MVehiculo getMiTanque() {
        return miTanque;
    }
}



















/*
    public void addCuadro1(){
        ImageIcon tanque2 = new ImageIcon("src/imagenes/tanques/t.gif");
        this.matrizCuadros = new Cuadro[numCuadrosX][numCuadrosY];
        panelCenter.setLayout(new GridLayout(numCuadrosY,numCuadrosX));
        for (int i = 0; i<numCuadrosX; i++){
            for (int j = 0; j<numCuadrosY; j++){
                this.matrizCuadros[i][j] = new Cuadro(i,j,panelCenter,this);
                ImageIcon imagen = new ImageIcon("src/imagenes/monte.jpg");
                matrizCuadros[i][j].setIcon(new ImageIcon());
                matrizCuadros[i][j].setContentAreaFilled(false);
                matrizCuadros[i][j].setBorderPainted(true);
                matrizCuadros[i][j].setIcon(new ImageIcon(imagen.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH)));
            }
        }
        Border a = matrizCuadros[0][0].getBorder();
        int b = matrizCuadros[0][0].getWidth();
        System.out.println(a+"}{"+b);

        while (contadorCantAleatorio < 3){

            aleaPosX = aleatorio.nextInt(this.numCuadrosX/2);
            aleaPosY = aleatorio.nextInt(this.numCuadrosY);
            matrizCuadros[aleaPosX][aleaPosY].setContentAreaFilled(false);
            matrizCuadros[aleaPosX][aleaPosY].setBorderPainted(true);
            matrizCuadros[aleaPosX][aleaPosY].setIcon(tanque2);

            contadorCantAleatorio++;
        }

        this.setVisible(true);
    }
    */