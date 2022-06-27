
import java.text.SimpleDateFormat;
import java.util.Random;
import model.ClienteMQTT;
import model.Ouvinte;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author KLEYN
 */
public class main {

    static float capacidade = 1000;
    static float armazenado = 0;
    static boolean disponivel = true;
    private static int local;
    static ClienteMQTT clienteMQTT = new ClienteMQTT("tcp://broker.hivemq.com:1883", null, null);
    static Ouvinte ouvinteMQTT;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        clienteMQTT.iniciar();
        Random random = new Random();
        float aux;
        local = random.nextInt((1000000 - 1) + 1) + 1;
        ouvinteMQTT = new Ouvinte(clienteMQTT, "aloisio/pblRedes/servidor1/"+local, 0);
        while (true) {
            Thread.sleep(1000);
            if (disponivel) {
                aux = armazenado + random.nextInt((50 - 10) + 1) + 10;
                if (aux < capacidade) {
                    armazenado = aux;
                    String msgAux;
                    if (aux == capacidade) {
                        disponivel = false;
                        msgAux = local + ";" + "0" + armazenado;
                        clienteMQTT.publicar("aloisio/pblRedes/servidor1/", msgAux.getBytes(), 0);
                    } else {
                        msgAux = local + ";" + "1" + armazenado;
                        clienteMQTT.publicar("aloisio/pblRedes/servidor1/", msgAux.getBytes(), 0);
                    }
                }
            }
            if (ouvinteMQTT.getMsgAux() == 1) {
                String auxString = ouvinteMQTT.getAux();
                String auxResp = local + ";";
                if (auxString.contains(auxResp)) {
                    ouvinteMQTT.setMsgAux(0);
                    if (auxString.equals(auxResp + "1")) {
                        armazenado = 0;
                        disponivel = true;
                        System.out.println("\tLixeira coletada!");
                    }
                }
            }
        }
    }

    /**
     * @return the local
     */
    public static int getLocal() {
        return local;
    }

    /**
     * @param aLocal the local to set
     */
    public static void setLocal(int aLocal) {
        local = aLocal;
    }

}
