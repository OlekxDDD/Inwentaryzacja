package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel implements ActionListener {
    private final JPasswordField PasswordField = new JPasswordField(); //field for Password
    private final JTextField LoginField = new JTextField(); //field for Login
    private final JButton LoginButton = new JButton("Zaloguj");    //initialization Login button
    final JButton ExitButton= new JButton("Wyjdz");  //initialization Exit Button


    LoginPanel(){
        Main.view.dispose();    //dispose view in Main

        JLabel loginLabel = new JLabel("Login: ");     //create Lebel for Login
        JLabel passwordLabel = new JLabel("Hasło: ");     //create Lebel for Password

        //create panel for input data
        JPanel inputPanel = new JPanel();   //initialization JPanel
        inputPanel.setLayout(new GridLayout(2,2));  //create grid for input panel
        inputPanel.add(loginLabel);
        inputPanel.add(LoginField);
        inputPanel.add(passwordLabel);
        inputPanel.add(PasswordField);

        add(inputPanel);    //add input Panel

        LoginButton.addActionListener(this);    //listing button
        add(LoginButton);   //add login button

        setLayout(new GridLayout(3,1)); // set layout

        ExitButton.addActionListener(this);   //listing button
        add(ExitButton);  //add Exit Button
    }

    //Admin User Root

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();  //get Source
        if(source == ExitButton){
            System.exit(0); //exit with status
        }else if(source == LoginButton){
            String loginForm = LoginField.getText();
            String passwordForm = PasswordField.getText();

            if(loginForm.equals("Admin") && passwordForm.equals("Admin1")){
                View.setTypeOfUser("Admin");
                Main.view = new View("WhatDo"); //back to What Do view
                Main.view2.dispose();
            }else if(loginForm.equals("User") && passwordForm.equals("User1")){
                View.setTypeOfUser("User");
                Main.view = new View("WhatDo"); //back to What Do view
                Main.view2.dispose();
            } else if(loginForm.equals("Root") && passwordForm.equals("Root1")){
                View.setTypeOfUser("Root");
                Main.view = new View("WhatDo"); //back to What Do view
                Main.view2.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Niepoprawny Login lub haslo");  // show message ot user
            }

        }
    }
}
