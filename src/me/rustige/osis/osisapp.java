package me.rustige.osis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class osisapp {
    private JPanel osisbasepanel;
    private JButton startBtn;
    private JButton helpBtn;
    private JCheckBox deadIPcheck;
    private JTextField subnetfield;
    private JTable resulttable;


    public static void main (String []args){
        JFrame osisframe = new JFrame("osisapp");
        osisframe.setContentPane(new osisapp().osisbasepanel);
        osisframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        osisframe.pack();
        osisframe.setVisible(true);
    }

    public osisapp() {
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
