/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author KLEYN
 */
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Ouvinte implements IMqttMessageListener {
    private String aux;
    private int msgAux = 0;

    public Ouvinte(ClienteMQTT clienteMQTT, String topico, int qos) {
        clienteMQTT.subscribe(qos, this, topico);
    }

    @Override
    public void messageArrived(String topico, MqttMessage mm) throws Exception {
        setAux(new String(mm.getPayload()));
        System.out.println("Mensagem recebida:");
        System.out.println("\tTópico: " + topico);
        System.out.println("\tMensagem: " + getAux());
        System.out.println("");
        setMsgAux(1);
    }

    /**
     * @return the aux
     */
    public String getAux() {
        return aux;
    }

    /**
     * @param aux the aux to set
     */
    public void setAux(String aux) {
        this.aux = aux;
    }

    /**
     * @return the msgAux
     */
    public int getMsgAux() {
        return msgAux;
    }

    /**
     * @param msgAux the msgAux to set
     */
    public void setMsgAux(int msgAux) {
        this.msgAux = msgAux;
    }

}
