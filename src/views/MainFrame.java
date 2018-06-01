package views;

import Client.ClientMessageListener;
import Client.ConnectionController;
import Client.DisplayThread;
import dao.User;
import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import service.AnalizeMessage;

/**
 * Observer Pattern = ma ajuta sa mentin decuplat fereastra noastra este un
 * listener ( a se vedea Display Thread)
 *
 * => o sa implementeze ClientMessagListener care o sa apeleze messageReceived
 * ce afiseaza mesajul primit
 *
 * @author CeachiBogdan
 */
public class MainFrame extends javax.swing.JFrame implements ClientMessageListener {

    // private String nume;
    private DisplayThread displayThread;

    public MainFrame() {

        //this.nume = nume;
        setTitle("HOME");
        initComponents();

        jTextArea1.setEditable(false);
        // jButton1.addActionListener(ev -> sendMessage());

        displayThread = new DisplayThread();

        // mutam fereastra ca ascultator pentur acest thread
        displayThread.addClientMessageListener(this);

        // vreau sa si primesc mesaje
        setLocationRelativeTo(null);
        setVisible(true);
    }

//    private void sendMessage() {
//        String mesaj = jTextArea2.getText();
//        // trimit mesaj
//
//        ConnectionController.getInstance().sendMessage(mesaj);
//        jTextArea2.setText(null);
//    }
    private void sendRequestForImbox(String subject) {
        String mesaj = "GET" + " " + subject;
        ConnectionController.getInstance().sendMessage(mesaj);
    }

    public void startDisplayThread() {
        displayThread.start();
    }

//    public void showInbox(AnalizeMessage analizedMessage) {
//        try {
//            int count = 1;
//            for (String token : analizedMessage.tokens) {
//                if (count == 1) {
//                    continue;
//                }
//                if (count % 3 != 0) {
//                    SwingUtilities.invokeAndWait(() -> jTextArea1.append(token + " "));
//                } else {
//                    SwingUtilities.invokeAndWait(() -> jTextArea1.append("\n"));
//                }
//            }
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }
    // pune mesajul primit in text Area
    @Override
    public void messageReceived(String message) {
        try {
//            AnalizeMessage am = new AnalizeMessage();
//            am.breakMessage(message);
//            if (AnalizeMessage.MESSAGE_TYPE.equals(("INBOX"))) {
//                // daca mesajul e inboxul clientului spargem mesajul
//                showInbox(am);
//            }

            System.out.println("am primit: " + message);
            SwingUtilities.invokeAndWait(() -> jTextArea1.append(message + "\n"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setText("COMPOSE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("GET IMBOX");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        SendEmailPageFrame emailPage = new SendEmailPageFrame();

        emailPage.setVisible(true);
        emailPage.setTitle("Send Email Service");
        //close mainFrame window
        dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        sendRequestForImbox("GET_IMBOX");

//        String receiveMessage = ConnectionController.getInstance().receiveMessage();
//        
//        System.out.println(receiveMessage);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
