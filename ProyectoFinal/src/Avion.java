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

    int Velocidad;
    private int aleaPosX,aleaPosY,numCuadrosX,numCuadrosY;
    private Cuadro matrizCuadros[][];

    public Avion(String imagenBoto,int x , int y){
        matrizRecorridoInsertarImg(imagenBoto,x,y);
    }
    public Avion(Cuadro matrizCuadros[][],String imagenBoton,int aleaPX,int aleaPY,int numCuadrosX,int numCuadorsY,String nameVehiculo){
        this.aleaPosX = aleaPX;
        this.aleaPosY = aleaPY;
        this.numCuadrosX = numCuadrosX;
        this.numCuadrosY = numCuadorsY;
        this.matrizCuadros = matrizCuadros;
        matrizRecorridoInsertarImagen(imagenBoton);
        ataque = 7;
        defensa = 3;
        punteria = 70;
        Velocidad = 1;
        movimientoEspecial = ataque*2;

        nombre = nameVehiculo;
        vida = 25;
        pp = 5;
        nivel = 1;
        exp = 0;
        armas = 1;

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

    }

    public int getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(int velocidad) {
        Velocidad = velocidad;
    }
}
