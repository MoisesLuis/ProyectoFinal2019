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

    private int aleaPosX,aleaPosY,numCuadrosX,numCuadrosY;
    private Cuadro matrizCuadros[][];
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
        vehiculosIniciales();
    }


    public Persona (String nombre, int edad, JButton alPressBoton, JTextArea txtArea){
        this.nombre = nombre;
        this.edad = edad;
        this.txtArea = txtArea;
        this.alPressBoton = alPressBoton;
        alPressBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVehiculo();
            }
        });

    }


    public void usarVehiculo(int j){
        for (int i = 0; i<3; i++){
            if (j==i){
                listaVehiculo.get(i);
            }
        }
    }

    public void vehiculosIniciales(){
        for (int i = 0; i<3; i++){
            nameVehiculo = "Tanq"+i+2+i+"MBLV";
            Vehiculo tanques = new MVehiculo(nameVehiculo);
            listaVehiculo.add(tanques);
        }
        for (int j = 0; j<3; j++){
            nameVehiculo = "Avion"+j+2+j+"MBLV";
            Vehiculo aviones = new Avion(nameVehiculo);
            listaVehiculo.add(aviones);
        }
    }

    public void agregarVehiculo(){
        Vehiculo vehiculo = new MVehiculo(nameVehiculo);
        listaVehiculo.add(vehiculo);
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

    public ArrayList<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(ArrayList<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNameVehiculo(int i) {
        for (int j = 0; i<listaVehiculo.size(); i++){
            if (j==i){
                nameVehiculo = listaVehiculo.get(i).getNombre();
            }
        }
        return nameVehiculo;
    }

    public void setNameVehiculo(String name, int j) {
        for (int i = 0; i<listaVehiculo.size(); i++) {
            if (j==i)
            this.nameVehiculo = name;
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
