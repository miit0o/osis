package me.rustige.osis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;

public class osisapp {
    private JPanel osisbasepanel;
    private JButton startBtn;
    private JButton helpBtn;
    private JCheckBox deadIPcheck;
    private JTextField subnetfield;
    public JTextArea resultbox;
    public static InetAddress currHost;
    public static int rcount;
    public static int urcount;

    public static void main(String[] args) {
        JFrame osisframe = new JFrame("OSIS - Open Source IP Scanner");
        osisframe.setContentPane(new osisapp().osisbasepanel);
        osisframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        osisframe.setPreferredSize(new Dimension(400, 300));
        osisframe.setResizable(false);
        osisframe.pack();
        osisframe.setVisible(true);
    }

    public osisapp() {
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                resultbox.setText("I was able to scan the following IPs:");

                //Launch Scanner
                startBtn.setEnabled(false);
                startBtn.setText("Scanning... Please wait...");
                String subnet = subnetfield.getText();

                new Thread(new Runnable() {
                    public void run() {
                        try {
                            rcount = 0;
                            urcount = 0;
                            int timeout = 500;
                            for (int i = 1; i < 255; i++) {
                                String host = subnet + "." + i;
                                if (InetAddress.getByName(host).isReachable(timeout)) {
                                    currHost = InetAddress.getByName(host);
                                    resultbox.append("\n" + host + " | " + currHost.getHostName());
                                    System.out.println(host + " | " + currHost.getHostName());
                                    rcount++;
                                } else {
                                    urcount++;
                                }
                            }

                            resultbox.append("\nTotal scanned IPs: " + 254);
                            resultbox.append("\nTotal reachable IPs: " + rcount);
                            resultbox.append("\nTotal unreachable IPs: " + urcount);
                            startBtn.setText("Start scanning");
                            startBtn.setEnabled(true);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);

                        }
                    }
                }).start();

            }
        });
        helpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Enter your desired subnet and click start.");
            }
        });
    }
}
