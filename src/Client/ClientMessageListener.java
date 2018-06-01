
package Client;

import service.AnalizeMessage;

/**
 *
 * @author CeachiBogdan
 */
public interface ClientMessageListener {
    
    public void messageReceived(String message);
}
