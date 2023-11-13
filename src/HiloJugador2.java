
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alejo
 */
public class HiloJugador2 extends Thread{
    private int dado;
    private int turno=1;
    StringBuffer buffer =new StringBuffer();
    private boolean estaVivo= true;
    Ventana v;
    
    public HiloJugador2(Ventana v){
        this.v=v;
    }
    public void run(){
        while(estaVivo){
            if(turno<=2){
                buffer.append("Tiro"+turno+":\n");
                dado=(int)(Math.random()*6+1);
                v.jugador2+=dado;
                buffer.append("dado1: "+dado+"\n");
                dado=(int)(Math.random()*6+1);
                v.jugador2+=dado;
                buffer.append("dado2: "+dado+"\n");
                turno++;
            }else{
                try{
                    v.Ganador.setText(v.cad+=".");
                    sleep(1000);
                }catch (InterruptedException ex) {
                    Logger.getLogger(HiloJugador1.class.getName()).log(Level.SEVERE, null, ex);
                }
                v.jTextArea2.setText(buffer.toString());
                HiloJugador3 h = new HiloJugador3(v);
                h.start();
                
                break;
            }
        }
        estaVivo=true;
    }
}
