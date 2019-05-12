import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.acl.Group;

public class CuadroArmasVehiculos extends JButton {

    CrearVehiculoArmas ventana;
    Tienda ventana1;
    int posX,posY;


    public CuadroArmasVehiculos(int posX, int posY, JPanel panel, Tienda tmpVentana){
        panel.add(this);
        this.posX = posX;
        this.posY = posY;
        this.setVisible(true);
        this.ventana1 = tmpVentana;

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                push();
            }
        });
    }

    public CuadroArmasVehiculos(int posX, int posY, JPanel panel, CrearVehiculoArmas tmpVentana){
        panel.add(this);
        this.posX = posX;
        this.posY = posY;
        this.setVisible(true);
        this.ventana = tmpVentana;

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                push();
            }
        });
    }

    public void push(){
        System.out.println("posición X: "+posX+"  posición Y: "+posY);
        System.out.println("Presiono el array de botones");
    }
}