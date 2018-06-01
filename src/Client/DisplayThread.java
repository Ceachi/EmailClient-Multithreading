package Client;

import java.util.ArrayList;
import java.util.List;
import service.AnalizeMessage;

/**
 * Am facut un Observer Pattern firul de executie devine subiect,
 *
 * subiectul are o lista de ascultatori
 *
 * @author CeachiBogdan
 */
/*
- asteapta sa primeasca mesaje
- cand primeste mesaj, notifica ca prin mesaj
- dar nu stie unde sa il duca, doar ne spune HEy, vedeti ca am primit mesajul!
- oricine asculta este un listener
 */
public class DisplayThread extends Thread {

    // el este listenerul clientului nostru, care asteapta sa primeasca mesaje
    ClientMessageListener listener;
    
    
    public void run() {
        while (true) {
            String message = ConnectionController.getInstance().receiveMessage();
            System.out.println("am primit mesajul: " + message);
                       
            listener.messageReceived(message);

        }
    }

    public void addClientMessageListener(ClientMessageListener client) {
        listener = client;
    }
}
