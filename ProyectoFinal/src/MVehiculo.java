import javax.swing.*;
import java.awt.*;

public class MVehiculo extends Vehiculo {

    private int aleaPosX,aleaPosY,numCuadrosX,numCuadrosY;
    private Cuadro matrizCuadros[][];
    private String imagen;
   // public MVehiculo(JPanel panel, Cuadro area){}

    public MVehiculo(Cuadro matrizCuadros[][],String imagenBoton,int aleaPX,int aleaPY,int numCuadrosX,int numCuadorsY){
        this.aleaPosX = aleaPX;
        this.aleaPosY = aleaPY;
        this.numCuadrosX = numCuadrosX;
        this.numCuadrosY = numCuadorsY;
        this.matrizCuadros = matrizCuadros;
        matrizRecorridoInsertarImagen(imagenBoton);
        this.imagen = imagenBoton;
        ataque = 10;
        defensa = 6;
        punteria = 60;
        movimientoEspecial = ataque*2;
        vida = 25;
        disparo = 0;

    }
    public void matrizRecorridoInsertarImagen(String direct) {
        ImageIcon imagen = new ImageIcon(direct);
        for (int i = 0; i < numCuadrosX; i++) {
            for (int j = 0; j < numCuadrosY; j++) {
//                matrizCuadros[aleaPosX][aleaPosY].setIcon(new ImageIcon());
                matrizCuadros[aleaPosX][aleaPosY].setContentAreaFilled(false);
                matrizCuadros[aleaPosX][aleaPosY].setBorderPainted(true);
                matrizCuadros[aleaPosX][aleaPosY].setIcon(imagen);
            }
        }
    }

        public void matrizCambiarLaPosición(MVehiculo miTanque,int x,int y){
        ImageIcon imagen = new ImageIcon(miTanque.getImagen());
            matrizCuadros[x][y].setIcon(imagen);
        }

    public int getAleaPosX() {
        return aleaPosX;
    }

    public int getAleaPosY() {
        return aleaPosY;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    @Override
    JButton getArea() {
        return null;
    }

    @Override
    int getAtaque() {
        return ataque;
    }

    @Override
    int getDefensa() {
        return defensa;
    }

    @Override
    int getPunteria() {
        return punteria;
    }

    @Override
    int getMovimientoEspecial() {
        return movimientoEspecial;
    }

    @Override
    int getVida() {
        return vida;
    }

    @Override
    float getDisparo() {
        return disparo;
    }

    @Override
    void setArea(JButton area) {
        this.area = area;
    }

    @Override
    void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    @Override
    void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    void setPunteria(int punteria) {
        this.punteria = punteria;
    }

    @Override
    void setMovimientoEspecial(int movimiento) {
        this.movimientoEspecial = movimiento;
    }

    @Override
    void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    void setDisparo(int disparo) {
        this.disparo = disparo;
    }

    @Override
    JPanel getPanel() {
        return null;
    }

    @Override
    void setPanel(JPanel panel) {

    }
}
