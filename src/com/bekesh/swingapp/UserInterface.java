/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bekesh.swingapp;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author bekesh
 */
public class UserInterface extends JFrame {

    private JLabel lblFileName;
    private JTextField txtFileName;
    private JTextArea txtNotepad;
    private JButton btnCreate;

    public UserInterface() {
        setTitle("JFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new FlowLayout(FlowLayout.CENTER));
       initComponents();
        setVisible(true);
    }

private void initComponents(){
    lblFileName=new JLabel("Enter file name:");
    txtFileName=new JTextField(30);
    txtNotepad=new JTextArea(20, 40);
    btnCreate=new JButton("Create file");
    btnCreate.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            try{
                String fileName=txtFileName.getText();
                FileWriter writer=new FileWriter(fileName);
                writer.write(txtNotepad.getText());
                writer.close();
                txtNotepad.setText("");
                txtFileName.setText("");
                }
            catch(IOException ioe){
            JOptionPane.showMessageDialog(null,ioe.getMessage());
        }
            }
    });
            
    add(txtNotepad, 0);
        add(lblFileName, 1);
    add(txtFileName, 2);
    
    add(btnCreate);
  
}
}

