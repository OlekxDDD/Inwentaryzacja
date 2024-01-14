package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateColour extends JPanel implements ActionListener {

    private final JTextField ID_KField = new JTextField(); //field for ID_K
    private final JTextField NameField = new JTextField(); //field for Name
    private final JButton addButton = new JButton("Dodaj kolor");    //initialization JButton
    final JButton WhatDoComeBackButton= new JButton("Wroc do Menu");  //initialization What Do Come Back Button
    CreateColour(){
        Main.view.dispose();    //dispose view in Main

        JLabel ID_KLabel = new JLabel("ID_K: ");     //create Lebel for ID_K
        JLabel nameLabel = new JLabel("Name: ");     //create Lebel for Name

        //create panel for input data
        JPanel inputPanel = new JPanel();   //initialization JPanel
        inputPanel.setLayout(new GridLayout(2,2));  //create grid for input panel
        inputPanel.add(ID_KLabel);
        inputPanel.add(ID_KField);
        inputPanel.add(nameLabel);
        inputPanel.add(NameField);

        add(inputPanel);    //add input Panel

        addButton.addActionListener(this);    //listing button
        add(addButton);   //add login button

        setLayout(new GridLayout(3,1)); // set layout for Create colour

        WhatDoComeBackButton.addActionListener(this);   //listing button
        add(WhatDoComeBackButton);  //add What Do Come Back Button
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();  //get Source
        if(source == WhatDoComeBackButton){ //if click on What Do come back Button
            Main.view = new View("WhatDo"); //back to What Do view
            Action.view.dispose();  //dispose this window
        }else if(source == addButton){//if click on Login button

            String ID_KString = ID_KField.getText();     //declare variable for check their value
            String nameString = NameField.getText();

            boolean isID_K = Action.isDigitString(ID_KString);    // checking Strings are with only numbers/int
            boolean isName = Action.isLessThanMaxText(nameString);   // checking Strings are Less than Max text

            boolean isID_KNull = !ID_KString.isEmpty();    //checking ID_k and Name aren't null
            boolean isNameNull = !nameString.isEmpty();

            if(isName && isID_K && isNameNull && isID_KNull) {

                String ID_K = "\"" + ID_KField.getText() + "\"";    // add "" to Strings
                String name = "\"" + NameField.getText() + "\"";

                Action.addColour(ID_K, name); //send this input to addItem

                ID_KField.setText(" "); //clear input field
                NameField.setText(" ");
            }else{
                String MessegaToShowInAlert = "";   // declare variable for message
                if (!isName){
                    MessegaToShowInAlert += "Nazwa moze zawierac maksymalnie 65 535 znaków\n";
                }
                if(!isID_K){
                    MessegaToShowInAlert += "ID_K moze zawierac tylko liczby\n";
                }
                if(!isNameNull){
                    MessegaToShowInAlert += "Nazwa musi byc wypelniona\n";
                }
                if(!isID_KNull){
                    MessegaToShowInAlert += "ID_K musi byc wypelniona\n";
                }
                JOptionPane.showMessageDialog(null, MessegaToShowInAlert);  // show message ot user
            }
        }
    }
}
