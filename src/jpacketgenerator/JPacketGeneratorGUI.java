/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacketgenerator;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author salvatore
 */
public class JPacketGeneratorGUI extends javax.swing.JFrame {

    private packetGenerator pGenerator;
    


    /**
     * Creates new form JPacketGeneratorGUI
     * @throws java.net.SocketException
     * @throws javax.swing.UnsupportedLookAndFeelException
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public JPacketGeneratorGUI() throws SocketException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        initComponents();
        initSourceAddress();

        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        UIManager.setLookAndFeel(new MetalLookAndFeel());

        //--- Make buttons and stuff look less crappy - this also allows background coloring
        String laf = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(laf);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CB_srcAddresses = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TB_dtsAddress = new javax.swing.JTextField();
        stopButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TB_dtsPort = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        S_packetSize_KB = new javax.swing.JSpinner();
        S_streamSpeed = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Packet Generator");
        setPreferredSize(new java.awt.Dimension(405, 170));
        setSize(new java.awt.Dimension(405, 170));
        getContentPane().setLayout(null);

        CB_srcAddresses.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        CB_srcAddresses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_srcAddressesActionPerformed(evt);
            }
        });
        getContentPane().add(CB_srcAddresses);
        CB_srcAddresses.setBounds(130, 10, 160, 20);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Source Address:");
        jLabel1.setRequestFocusEnabled(false);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 100, 20);

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Dest. Address & Port:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 40, 110, 20);

        TB_dtsAddress.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        TB_dtsAddress.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TB_dtsAddress.setText("127.0.0.1");
        getContentPane().add(TB_dtsAddress);
        TB_dtsAddress.setBounds(130, 40, 100, 20);

        stopButton.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        stopButton.setForeground(new java.awt.Color(204, 0, 0));
        stopButton.setText("STOP");
        stopButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopButtonMouseClicked(evt);
            }
        });
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        getContentPane().add(stopButton);
        stopButton.setBounds(300, 70, 77, 49);

        startButton.setFont(new java.awt.Font("Arial Unicode MS", 1, 11)); // NOI18N
        startButton.setForeground(new java.awt.Color(0, 102, 51));
        startButton.setText("START");
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startButtonMouseClicked(evt);
            }
        });
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        getContentPane().add(startButton);
        startButton.setBounds(300, 10, 77, 49);

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Packet Size (Bytes):");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 70, 110, 20);

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Stream Speed (Kbps):");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 100, 110, 20);

        TB_dtsPort.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        TB_dtsPort.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TB_dtsPort.setText("12345");
        getContentPane().add(TB_dtsPort);
        TB_dtsPort.setBounds(240, 40, 50, 20);

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText(":");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(230, 40, 10, 20);

        S_packetSize_KB.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        S_packetSize_KB.setValue(1324);
        getContentPane().add(S_packetSize_KB);
        S_packetSize_KB.setBounds(130, 70, 80, 22);

        S_streamSpeed.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        S_streamSpeed.setValue(500);
        getContentPane().add(S_streamSpeed);
        S_streamSpeed.setBounds(130, 100, 80, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startButtonActionPerformed

    private void startButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseClicked
        try {






            InetSocketAddress srcaddr = new InetSocketAddress(CB_srcAddresses.getSelectedItem().toString(), 0);
            InetSocketAddress dstaddr = new InetSocketAddress(TB_dtsAddress.getText(), new Integer(TB_dtsPort.getText()));

            if (pGenerator != null) {
                pGenerator.close();
            }
            pGenerator = new packetGenerator(srcaddr, dstaddr,
                    (Integer) S_packetSize_KB.getValue(),
                    ((Integer) S_streamSpeed.getValue()) * 1000);


        } catch (SocketException ex) {
            Logger.getLogger(packetGenerator.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_startButtonMouseClicked

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stopButtonActionPerformed

    private void stopButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopButtonMouseClicked
        if (pGenerator != null) {
            pGenerator.close();
        }
    }//GEN-LAST:event_stopButtonMouseClicked

    private void CB_srcAddressesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_srcAddressesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_srcAddressesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */


        if (args.length == 0) {

//            try {
//                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                    if ("Nimbus".equals(info.getName())) {
//                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                        break;
//                    }
//                }
//            } catch (ClassNotFoundException ex) {
//                java.util.logging.Logger.getLogger(JPacketGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//            } catch (InstantiationException ex) {
//                java.util.logging.Logger.getLogger(JPacketGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//            } catch (IllegalAccessException ex) {
//                java.util.logging.Logger.getLogger(JPacketGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//                java.util.logging.Logger.getLogger(JPacketGeneratorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//            }
            //</editor-fold>

            /*
             * Create and display the form
             */
            java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    try {
                        new JPacketGeneratorGUI().setVisible(true);
                    } catch (SocketException ex) {
                        Logger.getLogger(JPacketGeneratorGUI.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(JPacketGeneratorGUI.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(JPacketGeneratorGUI.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(JPacketGeneratorGUI.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(JPacketGeneratorGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } else {
            try {


                if (args.length < 3) {
                    System.out.println(" srcAddress srcPort dstAddress dstPort bitRate_bps");
                } else {


                    InetSocketAddress srcAddress = new InetSocketAddress(args[0], Integer.parseInt(args[1]));
                    InetSocketAddress dstAddress = new InetSocketAddress(args[2], Integer.parseInt(args[3]));
                    int birtate = Integer.parseInt(args[4]);

                    packetGenerator packetGenerator = new packetGenerator(srcAddress, dstAddress, 1324, birtate);
                }
            } catch (SocketException ex) {
                Logger.getLogger(JPacketGeneratorGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CB_srcAddresses;
    private javax.swing.JSpinner S_packetSize_KB;
    private javax.swing.JSpinner S_streamSpeed;
    private javax.swing.JTextField TB_dtsAddress;
    private javax.swing.JTextField TB_dtsPort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables

    private void initSourceAddress() throws SocketException {

        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();

        for (NetworkInterface netint : Collections.list(nets)) {


            Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();



            for (InetAddress addr : Collections.list(inetAddresses)) {
                if (addr instanceof java.net.Inet4Address) {
                    CB_srcAddresses.addItem((Object) addr.getHostAddress());
                }
            }

        }

        CB_srcAddresses.setSelectedItem("127.0.0.1");
    }
}