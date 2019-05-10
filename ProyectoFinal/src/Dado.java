import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Dado extends JButton{


    JPanel panel;
    Random aleatorio;
    int matrizLogic[][];
    int tamañoX,tamañoY,posX,posY;


    private int movimiento,daño;

    public Dado(int matrizLogic[][],int tamañoX,int tamañoY,int posX, int posY){
        aleatorio = new Random();
        this.matrizLogic = matrizLogic;
        this.tamañoX = tamañoX;
        this.tamañoY = tamañoY;
        this.posX = posX;
        this.posY = posY;

    }

    public int iniciarDado6x6(){
        movimiento = 1 + aleatorio.nextInt(6);
        System.out.println(movimiento);
        return movimiento;
    }

    public int iniciarDadoDaño(){
        daño = 1+ aleatorio.nextInt(100);
        System.out.println(daño);
        return daño;
    }

    public void caminoLibre(int direccion,int distancia){
        if (direccion != 0){
            if (direccion == 1){//1 es igual a arriba

            }
            if (direccion ==2){//2 es igual hacia abajo

            }
            if (direccion ==3){//3 es igual hacia derecha

            }
            if (direccion == 4){//4 es igual hacia izquierda

            }
        }else {
            JOptionPane.showInputDialog("Dirección erronea");
        }
    }
    public void verificarCaminoVacio(){
        for (int i = 0; i<tamañoX; i++){
            for(int j = 0; j<tamañoY; j++){
                if (matrizLogic[i][j] == 0){

                }
            }
        }
    }

    public boolean movimientoValido(int x, int y, int m, int mover){
        if (m == 1){
            y-=mover;
            if ((x>=0) && (x<= tamañoX) && (y>=0 ) && (y<=tamañoY)) {
                return true;
            }
        }
        else if (m ==2){
            y+=mover;
            if ((x>=0) && (x<= tamañoX) && (y>=0 ) && (y<=tamañoY)) {
                return true;
            }
        }
        else if (m ==3){
            x-=mover;
            if ((x>=0) && (x<= tamañoX) && (y>=0 ) && (y<=tamañoY)) {
                return true;
            }
        }
        else{
            x+=mover;
            if ((x>=0) && (x<= tamañoX) && (y>=0 ) && (y<=tamañoY)) {
                return true;
            }
        }

        return false;
    }
}
