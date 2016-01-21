/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jchatleggi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrea
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
         jLabel2.setVisible(false);
         jTextFieldMex.setVisible(false);
         jButtonInvio.setVisible(false);
         jTextAreaChat.setEditable(false);
    }

   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaChat = new javax.swing.JTextArea();
        jButtonRefresh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonInvio = new javax.swing.JButton();
        jTextFieldMex = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username:");

        jTextAreaChat.setColumns(20);
        jTextAreaChat.setRows(5);
        jScrollPane1.setViewportView(jTextAreaChat);

        jButtonRefresh.setText("Refresh");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        jLabel2.setText("Rispondi");

        jButtonInvio.setText("Invio");
        jButtonInvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInvioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jButtonRefresh))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldMex)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonInvio))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(46, 46, 46)
                                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButtonInvio)
                    .addComponent(jTextFieldMex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButtonRefresh)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        lettura();
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jButtonInvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInvioActionPerformed
        // TODO add your handling code here:
         String name, text;
        
        try
        {
            name = jTextFieldUsername.getText();
            text = jTextFieldMex.getText();
            
            FileWriter fileWriter = new FileWriter("//INFO01-DOC/shared folder/unicoBeggio.txt", true);
            fileWriter.append(name + ":" + text + "\r\n");
            fileWriter.flush();
            fileWriter.close();
            
        }
        catch(Exception E)
        {
             System.out.println("Errore nella scrittura!");
        }
        lettura();
    }//GEN-LAST:event_jButtonInvioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInvio;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaChat;
    private javax.swing.JTextField jTextFieldMex;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
    private int sizeFile=0;
   
    
    public void lettura() //è la lunghezza del file
    {
         List <String> lista = new ArrayList();
        
        try{
            FileReader f;
            f= new FileReader("//INFO01-DOC/shared folder/unicoBeggio.txt");

            BufferedReader b;
            b=new BufferedReader(f);
                    	
                String riga;
                while(true)
                {
                    riga = b.readLine();
                    if(riga==null)
                        break;
                    
                    lista.add(riga);
                }   

            }
            catch(Exception E)
            {

            }
        
        
        if(sizeFile!=lista.size()) //serve per non STAMPARE ogni volta il file sull'area
        {
            jTextAreaChat.setText("");
            for(int i=0; i< lista.size(); i++)
            {
                 jTextAreaChat.append(lista.get(i)+"\n");
            }
            sizeFile=lista.size();
        }
        
            if("tizio".equals(lista.get(lista.size()-1).substring(0, 5)))
            {
                jLabel2.setVisible(true);
                jTextFieldMex.setVisible(true);
                jButtonInvio.setVisible(true);
            }
            else
            {
                 jLabel2.setVisible(false);
                 jTextFieldMex.setVisible(false);
                 jButtonInvio.setVisible(false);
            }
        
        }
    
}//end class

