import javax.swing.*;

abstract public class Vehiculo {

    protected JButton area;
    protected JPanel panel;
    protected int ataque;
    protected int defensa;
    protected int punteria;
    protected int movimientoEspecial;
    protected int vida;
    protected int pp;
    protected int exp;
    protected String nombre;
    protected int nivel;
    protected int armas;
/*
    public Vehiculo(int ataque,int defensa,int punteria, int movimiento,int vida, int disparo, JButton area){
        this.ataque = ataque;
        this.area = area;
        this.defensa = defensa;
        this.punteria = punteria;
        this.movimiento = movimiento;
        this.vida = vida;
        this.disparo = disparo;
    }
*/

    abstract JButton getArea();
    abstract int getAtaque();
    abstract int getDefensa();
    abstract int getPunteria();
    abstract int getMovimientoEspecial();
    abstract int getVida();

    abstract void setArea(JButton area);
    abstract void setAtaque(int ataque);
    abstract void setDefensa(int defensa);
    abstract void setPunteria(int punteria);
    abstract void setMovimientoEspecial(int movimiento);
    abstract void setVida(int vida);
    abstract JPanel getPanel();
    abstract void setPanel(JPanel panel);

    abstract int getPp();
    abstract int getExp();
    abstract String getNombre();
    abstract int getNivel();
    abstract int getArmas();
    abstract void setPp(int pp);
    abstract void setExp(int exp);
    abstract void setNombre(String nombre);
    abstract void setNivel(int nivel);
    abstract void setArmas(int armas);
}
