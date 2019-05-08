import javax.swing.*;

public class Lago {
    private int vidaLago;
    private int aleaPosX,aleaPosY,numCuadrosX,numCuadrosY;
    private Cuadro matrizCuadros[][];

    public Lago(Cuadro matrizCuadros[][],String areaBoton,int aleaPX,int aleaPY,int numCuadrosX,int numCuadorsY){
        this.aleaPosX = aleaPX;
        this.aleaPosY = aleaPY;
        this.numCuadrosX = numCuadrosX;
        this.numCuadrosY = numCuadorsY;
        this.matrizCuadros = matrizCuadros;
        matrizRecorridoInsertarImagen(areaBoton);
        vidaLago = 30;
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

    public void setVidaMontaña(int a){
        vidaLago -= a;
    }
    public void setVidaMontañaReanudada(int a){
        vidaLago += a;
    }
    public int getVidaMontaña(){
        return vidaLago;
    }
}
