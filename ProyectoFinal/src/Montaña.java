import javax.swing.*;

public class Montaña {

    private int vidaMontaña;
    private int aleaPosX,aleaPosY,numCuadrosX,numCuadrosY;
    private Cuadro matrizCuadros[][];
    private String imagenMontaña;

    public Montaña(Cuadro matrizCuadros[][],int aleaPX,int aleaPY,int numCuadrosX,int numCuadorsY){
        imagenMontaña ="src/imagenes/montaña/Montaña.jpg";
        this.aleaPosX = aleaPX;
        this.aleaPosY = aleaPY;
        this.numCuadrosX = numCuadrosX;
        this.numCuadrosY = numCuadorsY;
        this.matrizCuadros = matrizCuadros;
        matrizRecorridoInsertarImagen(imagenMontaña);
        vidaMontaña = 30;
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

    public String getImagenMontaña() {
        return imagenMontaña;
    }

    public void setImagenMontaña(String imagenMontaña) {
        this.imagenMontaña = imagenMontaña;
    }

    public void setQuitarVidaMontaña(int a){
        vidaMontaña -= a;
    }
    public void setVidaMontañaReanudada(int a){
        vidaMontaña += a;
    }
    public int getVidaMontaña(){
        return vidaMontaña;
    }
}
