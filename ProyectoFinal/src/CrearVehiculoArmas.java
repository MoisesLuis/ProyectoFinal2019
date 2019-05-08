
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CrearVehiculoArmas extends JFrame {

    private JPanel panelFondo,panelCrearVehiculo,panelCrearArmas;
    private JLabel labelFondo;

    public CrearVehiculoArmas(){
        this.setLayout(null);
        setBounds(0,0,800,800);
        setLocationRelativeTo(null);
        this.setVisible(false);
        setTitle("Crear/Modificar Vehículo");

        panelFondo = new JPanel();
        panelFondo.setLayout(null);
        panelFondo.setBounds(0,0,800,800);
        add(panelFondo);
        this.setContentPane(panelFondo);

        panelCrearArmas = new JPanel();
        panelCrearArmas.setLayout(null);
        panelCrearArmas.setBounds(50,50,700,325);
        add(panelCrearArmas);
        panelFondo.add(panelCrearArmas);

        panelCrearVehiculo = new JPanel();
        panelCrearVehiculo.setLayout(null);
        panelCrearVehiculo.setBounds(50,400,700,325);
        panelCrearVehiculo.setBackground(Color.WHITE);
        add(panelCrearVehiculo);
        panelFondo.add(panelCrearVehiculo);


        labelFondo = new JLabel();
        ImageIcon imagenFon = new ImageIcon("src/imagenes/fondo.jpg" );
        labelFondo.setBounds(0,0,800,800);
        labelFondo.setIcon(new ImageIcon(imagenFon.getImage().getScaledInstance(labelFondo.getWidth(),labelFondo.getHeight(),Image.SCALE_SMOOTH)));
        panelFondo.add(labelFondo);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
