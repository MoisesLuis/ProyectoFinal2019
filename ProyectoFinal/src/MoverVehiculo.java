import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MoverVehiculo extends JFrame implements ActionListener, ItemListener {

    JButton boton;
    JComboBox combo;
    JPanel panel;
    JLabel label1,label2;
    int tamañoX,tamañoY,posX,posY;
    int direccion;
    int cuantoMover,cuantoQuitarVida;
    Cuadro matriz[][];
    private Dado classDado;
    private int botonSeleccionado;
    private VentanaPrincipal ventana;
    int posMaxX,posMaxY;
    int posObjetoX,posObjtoY;

    Montaña montaña;
    Lago lago;
    Avion miAvion;
    EVehiculo tanqueEnemigo;
    MVehiculo miTanque;


    public MoverVehiculo(int posX, int posY,int tamañoX,int tamañoY,Cuadro matriz[][],JPanel panel,int botonSeleccionado, int matrizLogic[][],VentanaPrincipal ventana
    , Montaña montaña, Lago lago,Avion miAvion, EVehiculo tanqueEnemigo, MVehiculo miTanque){
        this.tamañoX = tamañoX;
        this.tamañoY = tamañoY;
        this.panel = panel;
        this.posX = posX;
        this.posY = posY;
        this.matriz = matriz;
        this.ventana = ventana;
        this.botonSeleccionado = botonSeleccionado;
        this.montaña = montaña;
        this.lago = lago;
        this.miAvion = miAvion;
        this.tanqueEnemigo = tanqueEnemigo;
        this.miTanque = miTanque;

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        classDado = new Dado(matrizLogic,tamañoX,tamañoY,posX,posY);

     //setLayout(null);
     setBounds(0,0,420,200);
     setVisible(true);
     this.setLocationRelativeTo(null);

     panel = new JPanel();
     panel.setLayout(null);
     panel.setVisible(true);
     add(panel);

     boton = new JButton("Aceptar");
     boton.setBounds(170,80,100,30);
     boton.setVisible(true);
     panel.add(boton);
     boton.addActionListener(this);


     label2 = new JLabel("Dirección: ");
     label2.setBounds(120,50,200,20);
     panel.add(label2);


     combo = new JComboBox();
     combo.setBounds(250,50,150,20);
     panel.add(combo);

     combo.addItem("");
     combo.addItem("Norte");
     combo.addItem("Sur");
     combo.addItem("Este");
     combo.addItem("Oeste");
     combo.addItemListener(this);

    }

    public void itemStateChanged(ItemEvent e){
        if (e.getSource() == combo){
            String opcion = combo.getSelectedItem().toString();
            if (opcion.equals("Norte")){
                direccion = 1;
                setTitle(opcion);
            }
            if (opcion.equals("Sur")){
                direccion = 2;
                setTitle(opcion);
            }
            if (opcion.equals("Este")){
                direccion = 3;
                setTitle(opcion);

            }
            if (opcion.equals("Oeste")){
                direccion = 4;
                setTitle(opcion);

            }
        }
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == boton){
            if (botonSeleccionado == 1){
                cuantoMover = classDado.iniciarDado6x6();
                obtenerMovimientoMaximo(posX, posY);
                System.out.println(posMaxX+"]["+posMaxY);
                moverVehiculo();
            }
            if (botonSeleccionado == 2){
                cuantoQuitarVida = classDado.iniciarDadoDaño();
                encontrarObjetoParaDisparar(posX,posY);
                disparar();
                siDestruyenTerrenoColocarTierra();
            }
            this.setVisible(false);
        }
    }

    public void moverVehiculo(){
        int temp=0;

        if (direccion == 1){
            if (((posX-cuantoMover)>=0)){
                //ventana.matrizCuadros[posX][posY].removeAll();
                //ventana.matrizCuadros[posX][posY] = null;
                if (ventana.matrizLogicaE[posX][posY]==4)
                    ventana.alMoverMTanque(posX-cuantoMover,posY);
                if (ventana.matrizLogicaE[posX][posY]==5)
                    ventana.alMoverMAvion(posX-cuantoMover,posY);

                ventana.quitarMTanqueAlMover(posX,posY);
            }
            if (posX-cuantoMover < posMaxX){
                //ventana.matrizCuadros[posX][posY].removeAll();
                //ventana.matrizCuadros[posX][posY] = null;
                if (ventana.matrizLogicaE[posX][posY]==4)
                    ventana.alMoverMTanque(posMaxX,posY);
                if (ventana.matrizLogicaE[posX][posY]==5)
                    ventana.alMoverMAvion(posMaxX,posY);

                ventana.quitarMTanqueAlMover(posX,posY);
            }
            else temp++;
        }
        if (direccion == 2){
            if (((posX+cuantoMover)<=posMaxX)){
                if (ventana.matrizLogicaE[posX][posY]==4)
                    ventana.alMoverMTanque(posX+cuantoMover,posY);
                if (ventana.matrizLogicaE[posX][posY]==5)
                    ventana.alMoverMAvion(posX+cuantoMover,posY);

                ventana.quitarMTanqueAlMover(posX,posY);
            }
            if ((posX+cuantoMover) > posMaxX){
                if (ventana.matrizLogicaE[posX][posY]==4)
                    ventana.alMoverMTanque(posMaxX,posY);
                if (ventana.matrizLogicaE[posX][posY]==5)
                    ventana.alMoverMAvion(posMaxX,posY);

                ventana.quitarMTanqueAlMover(posX,posY);
            }
            else temp++;

        }
        if (direccion == 3){
            if (((posY+cuantoMover)<=posMaxY)){
                if (ventana.matrizLogicaE[posX][posY]==4)
                    ventana.alMoverMTanque(posX,posY+cuantoMover);
                if (ventana.matrizLogicaE[posX][posY]==5)
                    ventana.alMoverMAvion(posX,posY+cuantoMover);

                ventana.quitarMTanqueAlMover(posX,posY);
            }
            if ((posY+cuantoMover) > posMaxY){
                if (ventana.matrizLogicaE[posX][posY]==4)
                    ventana.alMoverMTanque(posX,posMaxY);
                if (ventana.matrizLogicaE[posX][posY]==5)
                    ventana.alMoverMAvion(posX,posMaxY);

                ventana.quitarMTanqueAlMover(posX,posY);
            }
            else temp++;

        }
        if (direccion == 4){
            if (((posY-cuantoMover)>=0)){
                if (ventana.matrizLogicaE[posX][posY]==4)
                    ventana.alMoverMTanque(posX,posY-cuantoMover);
                if (ventana.matrizLogicaE[posX][posY]==5)
                    ventana.alMoverMAvion(posX,posY-cuantoMover);

                ventana.quitarMTanqueAlMover(posX,posY);
            }
            if ((posY-cuantoMover) < posMaxY){
                if (ventana.matrizLogicaE[posX][posY]==4)
                    ventana.alMoverMTanque(posX,posMaxY);
                if (ventana.matrizLogicaE[posX][posY]==5)
                    ventana.alMoverMAvion(posX,posMaxY);

                ventana.quitarMTanqueAlMover(posX,posY);
            }
            else temp++;

        }
    }

    public boolean hayObstaculo(int x, int y){
        if (ventana.matrizLogicaE[x][y]!=0)
            return true;
        return false;
    }

    public boolean movimientoValido(int x, int y){
        if (direccion == 1){
            x-=cuantoMover;
            if ((x>=0)) {
                return true;
            }
        }
        else if (direccion ==2){
            x+=cuantoMover;
            if ((x<= tamañoX)) {
                return true;
            }
        }
        else if (direccion ==3){
            y-=cuantoMover;
            if ( (y>=0 )) {
                return true;
            }
        }
        else if (direccion == 4){
            y+=cuantoMover;
            if ((y<=tamañoY)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param x
     * Este parámetro es para ingresar la posición
     * en x del vehiculo del usuario
     * @param y
     *Este parámetro es para ingresar la posición
     * en y que tiene el vehiculo del usuario
     * @return
     *
     * Los dos metodos siguientes son para saber
     * el rango máximo que  el vehículo puede
     * moverse
     */
    public boolean rangoNorthLibre(int x, int y) {
        if (direccion == 1) {
            for (int i = 1; x - i >= 0; i++) {
                if (ventana.matrizLogicaE[x - i][y] == 0) {
                    return true;
                } else
                    break;
            }
        }
        if (direccion == 2) {
            for (int i = 1; x + i < tamañoX; i++) {
                if (ventana.matrizLogicaE[x + i][y] == 0) {
                    return true;
                } else
                    break;
            }
        }
        if (direccion == 3) {
            for (int i = 1; y + i < tamañoY; i++) {
                if (ventana.matrizLogicaE[x][y + i] == 0) {
                    return true;
                } else
                    break;
            }
        }
        if (direccion == 4) {
            for (int i = 1; y - i >= 0; i++) {
                if (ventana.matrizLogicaE[x][y - i] == 0) {
                    return true;
                } else
                    break;
            }
        }
        return false;
    }

    public void obtenerMovimientoMaximo(int x, int y){
        if (rangoNorthLibre(x, y)==true) {
            if (direccion == 1){
                for (int i = 1; x - i >= 0; i++) {
                    if (hayObstaculo(x-i,y)==false){
                        posMaxX = x-i;
                        posMaxY = y;
                    } else break;
                }
            }
            if (direccion == 2){
                for (int i = 1; x+i<tamañoX; i++) {
                    if (hayObstaculo(x+i,y)==false){
                        posMaxX = x+i;
                        posMaxY = y;
                    } else break;
                }
            }
            if (direccion == 3){
                for (int i = 1; y + i<tamañoY; i++) {
                    if (hayObstaculo(x,y+i)==false){
                        posMaxX = x;
                        posMaxY = y+i;
                    } else break;
                }
            }
            if (direccion == 4){
                for (int i = 1; y - i >= 0; i++) {
                    if (hayObstaculo(x,y-i)==false){
                        posMaxX = x;
                        posMaxY = y-i;
                    } else break;
                }
            }
        }
    }

    /**
     * metodoo para disparar
     */
    public void disparar(){
        if (ventana.matrizLogicaE[posObjetoX][posObjtoY] != 0){
            System.out.println("estas en disparar");
            System.out.println("Posición del objeto encontrado en X: "+posObjetoX);
            System.out.println("Posición del objeto encontrado en Y: "+posObjtoY);

            if (ventana.matrizLogicaE[posObjetoX][posObjtoY] == 1){
                if (tanqueEnemigo.getDefensa() < cuantoQuitarVida){
                    tanqueEnemigo.setQuitarVida(cuantoQuitarVida);
                    System.out.println("Vida restante del tanque enemigo: "+tanqueEnemigo.getVida());
                }
            } else if (ventana.matrizLogicaE[posObjetoX][posObjtoY] == 2){
                lago.setQuitarVidaLago(cuantoQuitarVida);
                System.out.println("Vida restante del lago: "+lago.getVidaLago());

            } else if (ventana.matrizLogicaE[posObjetoX][posObjtoY] == 3){
                montaña.setQuitarVidaMontaña(cuantoQuitarVida);
                System.out.println("Vida restante de la montaña: "+montaña.getVidaMontaña());
            }
        }
    }
    public boolean encontrarObjetoParaDisparar(int x, int y) {
        if (direccion == 1) {
            for (int i = 1; x - i >= 0; i++) {
                if (ventana.matrizLogicaE[x - i][y] != 0) {
                    posObjetoX = x-i;
                    posObjtoY = y;
                    break;
                }
            }
        }
        if (direccion == 2) {
            for (int i = 1; x + i < tamañoX; i++) {
                if (ventana.matrizLogicaE[x + i][y] == 0) {
                    posObjetoX = x + i;
                    posObjtoY = y;
                    break;
                }
            }
        }
        if (direccion == 3) {
            for (int i = 1; y + i < tamañoY; i++) {
                if (ventana.matrizLogicaE[x][y + i] == 0) {
                    posObjetoX = x;
                    posObjtoY = y+i;
                    break;
                }
            }
        }
        if (direccion == 4) {
            for (int i = 1; y - i >= 0; i++) {
                if (ventana.matrizLogicaE[x][y - i] == 0) {
                    posObjetoX = x;
                    posObjtoY = y-i;
                    break;
                }
            }
        }
        return false;
    }

    public void siDestruyenTerrenoColocarTierra(){
        for (int i = 0; i<tamañoX; i++){
            for (int j = 0; j<tamañoY; j++){
                if (lago != null){
                    if (lago.getVidaLago()<0){
                        if (ventana.matrizLogicaE[i][j] == 2)
                            lago = null;
                    }
                }
                if ( miTanque != null){
                    if (miTanque.getVida()<0){
                        if (ventana.matrizLogicaE[i][j] == 4)
                            miTanque = null;
                    }
                }
                if (miAvion != null){
                    if (miAvion.getVida() < 0){
                        if (ventana.matrizLogicaE[i][j] == 5)
                            miAvion = null;
                    }
                }
                if (montaña != null){
                    if (montaña.getVidaMontaña()<0){
                        if (ventana.matrizLogicaE[i][j] == 3)
                            montaña = null;
                    }
                }
                if (tanqueEnemigo != null){
                    if (tanqueEnemigo.getVida()<0){
                        if (ventana.matrizLogicaE[i][j] == 1)
                            tanqueEnemigo = null;
                    }
                }
            }
        }
    }

}



