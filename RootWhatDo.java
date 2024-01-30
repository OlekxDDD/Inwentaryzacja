package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RootWhatDo extends JPanel implements ActionListener {
    private final JTextField sqlPromptField = new JTextField(); //field for Login
    private final JButton sqlPromptButton = new JButton("Wyslij Prompt sql"); //button for send sql prompt
    private final JButton WhatDoComeBackButton = new JButton("Wroc do Menu");    //initialization JButton
    RootWhatDo(){
        Main.viewMain.dispose();    //
        setLayout(new GridLayout(3,1)); //set Layout

        JLabel sqlPromptLabel = new JLabel("podaj Prompt Sql: ");   //create information for user
        JPanel sqlPromptPanel = new JPanel();   // create panel for get sql prompt
        sqlPromptPanel.add(sqlPromptLabel); //add label for Panel
        sqlPromptPanel.add(sqlPromptField); //add label for Panel
        sqlPromptPanel.setLayout(new GridLayout(1,2));  // set Layaout in Panel

        add(sqlPromptPanel);
        add(sqlPromptButton);
        add(WhatDoComeBackButton);
        WhatDoComeBackButton.addActionListener(this);
        sqlPromptButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();  //get Source

        if(source == WhatDoComeBackButton) { //if click on What Do come back Button
            Main.viewMain = new View("WhatDo"); //back to What Do viewMain
            Action.view.dispose();  //dispose this window

        }else if (source == sqlPromptButton){
            String sqlPrompt = sqlPromptField.getText();
            Action.ExecuteQuery(sqlPrompt);
            JOptionPane.showMessageDialog(null, "Prompt wykonany");  // show message ot user

        }
    }
}
