package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RootSettings extends JPanel implements ActionListener {
    JLabel UrlLabel = new JLabel("Url na ten czas: " + Database.getUrl());     //create Label for url
    JLabel UserLabel = new JLabel("User na ten czas: " + Database.getUser());     //create Label for User
    JLabel PasswordLabel = new JLabel("Password na ten czas: " + Database.getPassword());     //create Label for Password
    private final JTextField UrlField = new JTextField();   //create text Field for Url
    private final JTextField UserField = new JTextField();   //create text Field for User
    private final JTextField PasswordField = new JTextField();   //create text Field for Password
    private final JButton WhatDoComeBackButton = new JButton("Wroc do Menu"); //declarate What Do Come Back Button
    private final JButton UrlButton = new JButton("zmien url"); //add button
    private final JButton UserButton = new JButton("zmien url"); //add button
    private final JButton PasswordButton = new JButton("zmien url"); //add button
    RootSettings(){
        Main.viewMain.dispose();    //dispose viewMain in Main

        JPanel inputPanelUrl = new JPanel();   //initialization JPanel
        inputPanelUrl.add(UrlField);
        UrlField.setText("jdbc:mysql://[nazwa hosta]:[port]/[baza danych]");
        inputPanelUrl.add(UrlButton);
        inputPanelUrl.setLayout(new GridLayout(1,2));

        JPanel inputPanelUser = new JPanel();   //initialization JPanel
        inputPanelUser.add(UserField);
        inputPanelUser.add(UserButton);
        inputPanelUser.setLayout(new GridLayout(1,2));

        JPanel inputPanelPassword = new JPanel();   //initialization JPanel
        inputPanelPassword.add(PasswordField);
        inputPanelPassword.add(PasswordButton);
        inputPanelPassword.setLayout(new GridLayout(1,2));

        add(UrlLabel);
        add(inputPanelUrl);

        add(UserLabel);
        add(inputPanelUser);

        add(PasswordLabel);
        add(inputPanelPassword);

        add(WhatDoComeBackButton);
        setLayout(new GridLayout(7,1)); // set layout

        UrlButton.addActionListener(this);
        UserButton.addActionListener(this);
        PasswordButton.addActionListener(this);
        WhatDoComeBackButton.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == UrlButton){
            Database.setUrl(UrlField.getText());
        }else if(source == UserButton){
            Database.setUser(UserField.getText());
        }else if(source == PasswordButton){
            Database.setPassword(PasswordField.getText());
        }else if(source == WhatDoComeBackButton){
            Main.viewMain = new View("WhatDo"); //back to What Do viewMain
            Action.view.dispose();  //dispose this window
        }
    }
}