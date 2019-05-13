import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class Persona implements Serializable {

    private String nombre, nameVehiculo;
    private int edad;
    private ArrayList<Vehiculo> listaVehiculo;
    private JButton alPressBoton;
    private JTextArea txtArea;
    private String imagenVehiculo;

    public Persona (Vehiculo newVehiculo){

        //this.nombre = nombre;

        this.edad = edad;
        this.txtArea = txtArea;
        this.alPressBoton = alPressBoton;

        agregarVehiculo();
    }

    public Persona (String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
        listaVehiculo = new ArrayList<Vehiculo>();
    }


    public Persona (String nombre, int edad, JButton alPressBoton, JTextArea txtArea){
        this.nombre = nombre;
        this.edad = edad;
        this.txtArea = txtArea;
        this.alPressBoton = alPressBoton;
        alPressBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPersona();
            }
        });

    }

    public void agregarPersona(){

    }

    public void agregarVehiculo(){

    }

    public void mostrarVehiculo(){
        String matris[][] = new String[listaVehiculo.size()][7];

        for (int i = 0; i<listaVehiculo.size(); i++){

            matris[i][0] = listaVehiculo.get(i).getNombre();
            matris[i][1] = Integer.toString(listaVehiculo.get(i).getArmas());
            matris[i][2] = Integer.toString(listaVehiculo.get(i).getAtaque());
            matris[i][3] = Integer.toString(listaVehiculo.get(i).getDefensa());
            matris[i][4] = Integer.toString(listaVehiculo.get(i).getExp());
            matris[i][5] = Integer.toString(listaVehiculo.get(i).getNivel());
            matris[i][6] = Integer.toString(listaVehiculo.get(i).getPp());
            matris[i][7] = Integer.toString(listaVehiculo.get(i).getVida());
        }

    }
    public void mostrarPersona(){

    }

    public String getNombre() {
        return nombre;
    }

    public String getNameVehiculo() {
        return nameVehiculo;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNameVehiculo(String nameVehiculo) {
        this.nameVehiculo = nameVehiculo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
