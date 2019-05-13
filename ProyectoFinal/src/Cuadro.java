import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

 public class Cuadro extends JButton {

    int posX,posY,numAleatorioX,numAleatorioY;
    int rangoX,rangoY;
    VentanaPrincipal ventana;
    Random posAleatorioX,posAleatorioY;
    boolean verifi;
    boolean cambio = true;
    boolean cambioAvion = true;
     private JTextArea textArea;




     public Cuadro(int posX, int posY, JPanel panel1, VentanaPrincipal tmpVentana){
        panel1.add(this);
        this.posX = posX;
        this.posY = posY;
        this.setVisible(true);
        panel1.setVisible(true);
        this.ventana = tmpVentana;

        posAleatorioX = new Random();
        posAleatorioY = new Random();
        rangoX = ventana.numCuadrosX;
        rangoY = ventana.numCuadrosY;

        numAleatorioX = posAleatorioX.nextInt(rangoX);
        numAleatorioY = posAleatorioY.nextInt(rangoY);

         textArea = new JTextArea();
         textArea.setEditable(false);
         textArea.setBorder(null);
         textArea.setOpaque(false);
         textArea.setBackground(new Color(20,20,20,64));
         textArea.setBounds(10,600,280,300);
         textArea.setFont(new Font("News706 BT",Font.BOLD,18));
         textArea.setForeground(Color.RED);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(posX+"   "+posY);
                System.out.println(ventana.matrizLogicaE[posX][posY]);
                //gameAction();
                if (ventana.matrizLogicaE[posX][posY] == 4){
                    deshabilitarCampo();
                    if (cambio){
                        pintarCaminoTorre(posX,posY);
                        cambio = false;
                    }
                    else {
                        abilitarTCamino();
                        cambio = true;
                    }
                }
                if (ventana.matrizLogicaE[posX][posY] == 5){
                    deshabilitarCampo();
                    if (cambioAvion==true){
                        pintarCaminoTorreAvion(posX,posY);
                        cambioAvion = false;
                    }
                    else {
                        abilitarTCamino();
                        cambioAvion = true;
                    }
                }
                if (ventana.matrizLogicaE[posX][posY] ==1 || ventana.matrizLogicaE[posX][posY] ==2 || ventana.matrizLogicaE[posX][posY] == 3 ){
                    informacion();
                }

            }
        });
    }
    public void informacion(){
         if (ventana.matrizLogicaE[posX][posY] ==1){
             ventana.getTxtAreaReporte().setText("                                \n"+
                     "            Vehiculo:  Tanque Enemigo  \n"+
                     "                                \n"+
                     "   Nombre:  "+ventana.getTanqueEnemigo().getNombre()+"\n"+
                     "                              \n"+
                     "            Vida:      "+ventana.getTanqueEnemigo().getVida()+"           \n"+
                     "            PP:  "+ventana.getTanqueEnemigo().getPp()+"                   \n"+
                     "            Nivel:  "+ventana.getTanqueEnemigo().getNivel()+"             \n"+
                     "            Experiencia:  "+ventana.getTanqueEnemigo().getExp()+"         \n"+
                     "            Armas:  "+ventana.getTanqueEnemigo().getArmas()+"             \n"+
                     "                                                        \n"+
                     "                                                        \n"+
                     "            Ataque:    "+ventana.getTanqueEnemigo().getAtaque()+"         \n"+
                     "            Defensa:   "+ventana.getTanqueEnemigo().getDefensa()+"        \n"+
                     "            Puntería:  "+ventana.getTanqueEnemigo().getPunteria()+"       \n"+
                     " Movimiento Especial:  "+ventana.getTanqueEnemigo().getMovimientoEspecial()+" \n"+
                     "                                                         \n"+
                     "                                                         \n");
         }
         if (ventana.matrizLogicaE[posX][posY] ==2){

             ventana.getTxtAreaReporte().setText("                                \n"+
                     "                                \n"+
                     "                                \n"+
                     "                                \n"+
                     "                                \n"+
                     "                                \n"+
                     "         Terreno: Lago Pantanoso  \n"+
                     "                                \n"+
                     "   Nombre:  "+ventana.getLago().getVidaLago()+"\n"+
                     "                              \n"+
                     "                                                        \n"+
                     "                                                        \n"+
                     "                                                         \n"+
                     "                                                         \n");
         }
         if (ventana.matrizLogicaE[posX][posY] ==3){
             ventana.getTxtAreaReporte().setText("                                \n"+
                     "                                \n"+
                     "                                \n"+
                     "                                \n"+
                     "                                \n"+
                     "                                \n"+
                     "         Terreno: Montaña  \n"+
                     "                                \n"+
                     "   Nombre:  "+ventana.getMontaña().getVidaMontaña()+"\n"+
                     "                              \n"+
                     "                                                        \n"+
                     "                                                        \n"+
                     "                                                         \n"+
                     "                                                         \n");
         }
         if (ventana.matrizLogicaE[posX][posY] ==4){

             ventana.getTxtAreaReporte().setText("                                \n"+
                     "            Vehiculo: Tanque \n"+
                     "                                \n"+
                     "   Nombre:  "+ventana.getMiTanque().getNombre()+"\n"+
                     "                              \n"+
                     "            Vida:      "+ventana.getMiTanque().getVida()+"           \n"+
                     "            PP:  "+ventana.getMiTanque().getPp()+"                   \n"+
                     "            Nivel:  "+ventana.getMiTanque().getNivel()+"             \n"+
                     "            Experiencia:  "+ventana.getMiTanque().getExp()+"         \n"+
                     "            Armas:  "+ventana.getMiTanque().getArmas()+"             \n"+
                     "                                                        \n"+
                     "                                                        \n"+
                     "            Ataque:    "+ventana.getMiTanque().getAtaque()+"         \n"+
                     "            Defensa:   "+ventana.getMiTanque().getDefensa()+"        \n"+
                     "            Puntería:  "+ventana.getMiTanque().getPunteria()+"       \n"+
                     " Movimiento Especial:  "+ventana.getMiTanque().getMovimientoEspecial()+" \n"+
                     "                                                         \n"+
                     "                                                         \n");
         }
         if (ventana.matrizLogicaE[posX][posY] ==5){
             ventana.getTxtAreaReporte().setText("                                \n"+
                     "            Vehiculo: Avión \n"+
                     "                                \n"+
                     "   Nombre:  "+ventana.getMiAvion().getNombre()+"\n"+
                     "                              \n"+
                     "            Vida:      "+ventana.getMiAvion().getVida()+"           \n"+
                     "            PP:  "+ventana.getMiAvion().getPp()+"                   \n"+
                     "            Nivel:  "+ventana.getMiAvion().getNivel()+"             \n"+
                     "            Experiencia:  "+ventana.getMiAvion().getExp()+"         \n"+
                     "            Armas:  "+ventana.getMiAvion().getArmas()+"             \n"+
                     "                                                        \n"+
                     "                                                        \n"+
                     "            Ataque:    "+ventana.getMiAvion().getAtaque()+"         \n"+
                     "            Defensa:   "+ventana.getMiAvion().getDefensa()+"        \n"+
                     "            Puntería:  "+ventana.getMiAvion().getPunteria()+"       \n"+
                     " Movimiento Especial:  "+ventana.getMiAvion().getMovimientoEspecial()+" \n"+
                     "                                                         \n"+
                     "                                                         \n");
         }
    }


     public void abilitarTCamino(){
         for (int i = 0; i<rangoX; i++){
             for (int j = 0; j<rangoY; j++){
                 ventana.matrizCuadros[i][j].setEnabled(true);
             }
         }
     }
     public void deshabilitarCampo(){
         for (int i = 0; i<rangoX; i++){
             for (int j = 0; j<rangoY; j++){
                 ventana.matrizCuadros[i][j].setEnabled(false);
             }
         }
     }

    public void gameAction(){
        if (ventana.matrizLogicaE[posX][posY]!=0){
           // recorridoTR(1,rangoX,rangoY);
        }
        //recorridoTR(1,rangoX,rangoY);
    }
    public void gameOver() {

    }
    public void pintarCuadros(){

    }

     public boolean hayObstaculo(int x, int y){
         if (ventana.matrizLogicaE[x][y]!=0)
         return true;
         return false;
     }



     public void pintarCaminoTorre(int x,int y) {
         ventana.matrizCuadros[x][y].setEnabled(true);
         if (rangoWestLibre(x, y)==true) {
             for (int i = 1; y - i >= 0; i++) {
                 if (hayObstaculo(x,y-i)==false){
                     System.out.println("{"+ x +"}  {"+ (y-i) + "}");
                     ventana.matrizCuadros[x][y - i].setEnabled(true);
                 }else break;

             }
             //boton1[x][y].setBackground(new Color(150,150,150));
         }
         if (rangoEastLibre(x, y)==true) {
             for (int i = 1; y + i < rangoY; i++) {
                 if (hayObstaculo(x,y+i)==false){
                     System.out.println("{"+ x +"}  {"+ (y+i) + "}");
                     ventana.matrizCuadros[x][y + i].setEnabled(true);
                 }else break;

             }
             //boton1[x][y].setBackground(new Color(150,150,150));
         }
         if (rangoNorthLibre(x, y)==true) {
             for (int i = 1; x - i >= 0; i++) {
                 if (hayObstaculo(x-i,y)==false){
                     System.out.println("{"+ (x-i) +"}  {"+ (y) + "}");
                     ventana.matrizCuadros[x-i][y].setEnabled(true);
                 }else break;

             }
             //boton1[x][y].setBackground(new Color(150,150,150));
         }
         if (rangoSouthLibre(x, y)==true) {
             for (int i = 1; x+i<rangoX; i++) {
                 if (hayObstaculo(x+i,y)==false){
                     System.out.println("{"+ (x+i) +"}  {"+ y + "}");
                     ventana.matrizCuadros[x+i][y].setEnabled(true);
                 }else break;

             }
             //boton1[x][y].setBackground(new Color(150,150,150));
         }
     }


     public boolean rangoSouthLibre(int x, int y){
         for(int i=1;x+i<rangoX;i++){
             if(ventana.matrizLogicaE[x+i][y]==0){
                 return true;
             }else
                 break;
         }
         return false;
     }

     public boolean rangoNorthLibre(int x, int y){
         for(int i=1;x-i>=0;i++){
             if(ventana.matrizLogicaE[x-i][y]==0){
                 return true;
             }else
                 break;
         }
         return false;
     }

     public boolean rangoEastLibre(int x, int y){
         for(int i=1;y+i<rangoY;i++){
             if(ventana.matrizLogicaE[x][y+1]==0){
                 return true;
             }else
                 break;
         }
         return false;
     }

     public boolean rangoWestLibre(int x, int y){
         for(int i=1;y-i>=0;i++){
             if(ventana.matrizLogicaE[x][y-1]==0){
                 return true;
             }else
                 break;
         }
         return false;
     }

     /**
      * si es el avion el que está seleccionado
      */

     public void pintarCaminoTorreAvion(int x,int y) {
         ventana.matrizCuadros[x][y].setEnabled(true);
         if (rangoWestLibreAvion(x, y)==true) {
             for (int i = 1; y - i >= 0; i++) {
                 if (hayObstaculoAvion(x,y-i)==false){
                     System.out.println("{"+ x +"}  {"+ (y-i) + "}");
                     ventana.matrizCuadros[x][y - i].setEnabled(true);
                 }else break;

             }
             //boton1[x][y].setBackground(new Color(150,150,150));
         }
         if (rangoEastLibreAvion(x, y)==true) {
             for (int i = 1; y + i < rangoY; i++) {
                 if (hayObstaculoAvion(x,y+i)==false){
                     System.out.println("{"+ x +"}  {"+ (y+i) + "}");
                     ventana.matrizCuadros[x][y + i].setEnabled(true);
                 }else break;

             }
             //boton1[x][y].setBackground(new Color(150,150,150));
         }
         if (rangoNorthLibreAvion(x, y)==true) {
             for (int i = 1; x - i >= 0; i++) {
                 if (hayObstaculoAvion(x-i,y)==false){
                     System.out.println("{"+ x +"}  {"+ (x-i) + "}");
                     ventana.matrizCuadros[x-i][y].setEnabled(true);
                 }else break;

             }
             //boton1[x][y].setBackground(new Color(150,150,150));
         }
         if (rangoSouthLibreAvion(x, y)==true) {
             for (int i = 1; x+i<rangoX; i++) {
                 if (hayObstaculoAvion(x+i,y)==false){
                     System.out.println("{"+ (x+i) +"}  {"+ y + "}");
                     ventana.matrizCuadros[x+i][y].setEnabled(true);
                 }else break;

             }
             //boton1[x][y].setBackground(new Color(150,150,150));
         }
     }


     public boolean rangoSouthLibreAvion(int x, int y){
         for(int i=1;x+i<rangoX;i++){
             if(ventana.matrizLogicaE[x+i][y]==0 || ventana.matrizLogicaE[x+i][y] == 2){
                 return true;
             }else
                 break;
         }
         return false;
     }

     public boolean rangoNorthLibreAvion(int x, int y){
         for(int i=1;x-i>=0;i++){
             if(ventana.matrizLogicaE[x-i][y]==0 || ventana.matrizLogicaE[x-i][y] == 2){
                 return true;
             }else
                 break;
         }
         return false;
     }

     public boolean rangoEastLibreAvion(int x, int y){
         for(int i=1;y+i<rangoY;i++){
             if(ventana.matrizLogicaE[x][y+1]==0 || ventana.matrizLogicaE[x][y+1] == 2){
                 return true;
             }else
                 break;
         }
         return false;
     }

     public boolean rangoWestLibreAvion(int x, int y){
         for(int i=1;y-i>=0;i++){
             if(ventana.matrizLogicaE[x][y-1]==0 || ventana.matrizLogicaE[x][y-i] == 2){
                 return true;
             }else
                 break;
         }
         return false;
     }
     public boolean hayObstaculoAvion(int x, int y){
         if (ventana.matrizLogicaE[x][y]==0 || ventana.matrizLogicaE[x][y] == 2)
             return false;
         return true;
     }

 }
/*
     public void recorridoTR(int contador, int rangoX,int rangoY) {
         int tm = 0;
         int x = this.posX;
         int Y = this.posY;
         boolean a = true,b=true,c=true,d=true;
         System.out.println("Contador: " + contador);

         if (((posX - contador) >= 0) && verificandoSiHayObstaculosEnElCamino(posX - contador, Y) == false && a==true ) {
             //ventana.matrizCuadros[posX-contador][posY].setContentAreaFilled(true);
             //ventana.matrizCuadros[posX-contador][posY].setBorderPainted(false);
             //ventana.matrizCuadros[posX-contador][posY].requestFocus();
             //ventana.matrizCuadros[posX-contador][posY].setBackground(Color.green);
             ventana.matrizCuadros[posX - contador][posY].setEnabled(false);
         } else {
             tm++;
              a = false;
         }


         if (((posX + contador) < rangoX) && verificandoSiHayObstaculosEnElCamino(posX + contador, Y) == false && b==true) {
             //ventana.matrizCuadros[posX + contador][posY].setContentAreaFilled(true);
             //ventana.matrizCuadros[posX + contador][posY].setBorderPainted(false);
             //ventana.matrizCuadros[posX + contador][posY].requestFocus();
             ventana.matrizCuadros[posX + contador][posY].setEnabled(false);
         } else{
             tm++;
             b = false;
         }


         if (((posY + contador) < rangoY) && verificandoSiHayObstaculosEnElCamino(x, posY + contador) == false && c==true) {
             //ventana.matrizCuadros[posX][posY +contador].setContentAreaFilled(true);
             //ventana.matrizCuadros[posX][posY +contador].setBorderPainted(false);
             //ventana.matrizCuadros[posX][posY + contador].requestFocus();
             ventana.matrizCuadros[posX][posY + contador].setEnabled(false);
         } else{
             tm++;
             c = false;
         }

         if (((Y - contador) >= 0) && verificandoSiHayObstaculosEnElCamino(x, posY - contador) == false && d==true) {
             //ventana.matrizCuadros[posX][posY-contador].setContentAreaFilled(true);
             //ventana.matrizCuadros[posX][posY-contador].setBorderPainted(false);
             //ventana.matrizCuadros[posX][posY - contador].requestFocus();
             ventana.matrizCuadros[posX][posY - contador].setEnabled(false);

         } else {
             tm++;
             d = false;
         }
             ventana.setVisible(true);

         if (tm!=4)
             recorridoTR(contador+1,rangoX,rangoY);
         else
             return;
     }
*/