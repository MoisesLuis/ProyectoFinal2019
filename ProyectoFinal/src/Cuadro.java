import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

 public class Cuadro extends JButton {

    int posX,posY,numAleatorioX,numAleatorioY;
    int x,y;
    int rangoY;
    VentanaPrincipal ventana;
    Random posAleatorioX,posAleatorioY;

    public Cuadro(int posX, int posY, JPanel panel1, VentanaPrincipal tmpVentana){
        panel1.add(this);
        this.posX = posX;
        this.posY = posY;
        this.setVisible(true);
        panel1.setVisible(true);
        this.ventana = tmpVentana;

        posAleatorioX = new Random();
        posAleatorioY = new Random();
        x = ventana.numCuadrosX;
        y = ventana.numCuadrosY;

        numAleatorioX = posAleatorioX.nextInt(x);
        numAleatorioY = posAleatorioY.nextInt(y);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("x: "+posX+"  y: "+posY);
                System.out.println("");
                System.out.println("{<<"+x+">>>}"+", {<<<"+y+"}>>>");
                System.out.println("");
                System.out.println("{>"+numAleatorioX+">>>}{>"+numAleatorioY+"<}");
                System.out.println("");
                //gameAction();
            }
        });
    }
    public void gameAction(){
        ImageIcon imagenInicio = new ImageIcon("");
    }
    public void gameOver(){

    }

}
