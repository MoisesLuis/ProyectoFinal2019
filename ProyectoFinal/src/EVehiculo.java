import javax.swing.*;
import java.awt.*;

public class EVehiculo extends Vehiculo{

    private int aleaPosX,aleaPosY,numCuadrosX,numCuadrosY;
    private Cuadro matrizCuadros[][];

    public EVehiculo(Cuadro matrizCuadros[][],String areaBoton,int aleaPX,int aleaPY,int numCuadrosX,int numCuadorsY,String nameVehiculo){
        this.aleaPosX = aleaPX;
        this.aleaPosY = aleaPY;
        this.numCuadrosX = numCuadrosX;
        this.numCuadrosY = numCuadorsY;
        this.matrizCuadros = matrizCuadros;
        matrizRecorridoInsertarImagen(areaBoton);
        ataque = 10;
        defensa = 6;
        punteria = 60;
        movimientoEspecial = ataque*2;

        nombre = nameVehiculo;
        vida = 25;
        pp = 5;
        nivel = 1;
        exp = 0;
        armas = 1;
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
    int getPp() {
        return pp;
    }

    @Override
    int getExp() {
        return exp;
    }

    @Override
    String getNombre() {
        return nombre;
    }

    @Override
    int getNivel() {
        return nivel;
    }

    @Override
    int getArmas() {
        return armas;
    }

    @Override
    void setPp(int pp) {
        this.pp = pp;
    }

    @Override
    void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    void setArmas(int armas) {
        this.armas = armas;
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
    JPanel getPanel() {
        return null;
    }

    @Override
    void setPanel(JPanel panel) {
        this.panel = panel;
    }

}
