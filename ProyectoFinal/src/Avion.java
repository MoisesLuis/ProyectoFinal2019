import javax.swing.*;
import java.awt.*;

public class Avion extends Vehiculo {
/*
    public Avion(JPanel panel, JButton area){
        ImageIcon areaBoton = new ImageIcon("src/imagenes/aviones/Air.gif");
        this.area = area;
        area.setIcon(new ImageIcon(areaBoton.getImage().getScaledInstance(200,200, Image.SCALE_SMOOTH)));
        area.setBorderPainted(true);
        area.setContentAreaFilled(false);
        area.setBorder(null);

        this.panel = panel;
        ataque = 10;
        defensa = 6;
        punteria = 60;
        movimientoEspecial = ataque*2;
        vida = 25;
        disparo = 0;
    }
*/

    private int aleaPosX,aleaPosY,numCuadrosX,numCuadrosY;
    private Cuadro matrizCuadros[][];

    public Avion(String imagenBoto,int x , int y){
        matrizRecorridoInsertarImg(imagenBoto,x,y);
    }
    public Avion(Cuadro matrizCuadros[][],String imagenBoton,int aleaPX,int aleaPY,int numCuadrosX,int numCuadorsY){
        this.aleaPosX = aleaPX;
        this.aleaPosY = aleaPY;
        this.numCuadrosX = numCuadrosX;
        this.numCuadrosY = numCuadorsY;
        this.matrizCuadros = matrizCuadros;
        matrizRecorridoInsertarImagen(imagenBoton);
        ataque = 10;
        defensa = 6;
        punteria = 60;
        movimientoEspecial = ataque*2;
        vida = 25;
        disparo = 0;

    }

    public void matrizRecorridoInsertarImg(String direct,int x,int y){
        ImageIcon imagen = new ImageIcon(direct);
        for (int i = 0; i<numCuadrosX; i++){
            for (int j = 0; j<numCuadrosY; j++){
                matrizCuadros[x][y].setIcon(new ImageIcon());
                matrizCuadros[x][y].setContentAreaFilled(false);
                matrizCuadros[x][y].setBorderPainted(true);
                matrizCuadros[x][y].setIcon(imagen);
            }
        }

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

    void setQuitarVida(int vida){
        this.vida -= vida;
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
