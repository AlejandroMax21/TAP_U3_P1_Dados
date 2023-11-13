
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
public class HiloJugador1 extends Thread{
    private int dado;
    private int turno=1;
    StringBuffer buffer =new StringBuffer();
    private boolean estaVivo= true;
    Ventana v;
    
    public HiloJugador1(Ventana v){
        this.v=v;
    }
    public void run(){
        while(estaVivo){
            if(turno<=2){
                buffer.append("Tiro"+turno+":\n");
                dado=(int)(Math.random()*6+1);
                v.jugador1+=dado;
                buffer.append("dado1: "+dado+"\n");
                dado=(int)(Math.random()*6+1);
                v.jugador1+=dado;
                buffer.append("dado2: "+dado+"\n");
                turno++;
            }else{
                v.Ganador.setText(v.cad+=".");
                try{
                sleep(1000);
                }catch (InterruptedException ex) {
                    Logger.getLogger(HiloJugador1.class.getName()).log(Level.SEVERE, null, ex);
                }
                v.jTextArea3.setText(buffer.toString());
                HiloJugador2 h = new HiloJugador2(v);
                h.start();
                setEstaVivo();
                break;
            }
        }
        
    }
    
    public boolean getEstaVivo(){
        return estaVivo;
    }
    public void setEstaVivo(){
        estaVivo=!estaVivo;
    }
    
}
