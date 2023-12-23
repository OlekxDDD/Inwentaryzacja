package org.example;

import javax.swing.*;   //import library
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static java.awt.SystemColor.text;

public class ViewIt extends JPanel implements ActionListener {
    private Object source;  //create Object source
    final JButton WhatDoComeBackButton = new JButton("Wroc do Menu"); //declare button
    public ViewIt() {
        List<List<String>> LatestPrompt = Action.LatestPrompt;  //import LatestPrompt from Action
        if(!LatestPrompt.isEmpty()){
            DefaultTableModel model = new DefaultTableModel();  // initialization Default Table Model

            if (LatestPrompt.isEmpty()) {    //if LatestPrompt is empty
                model.addColumn("nie ma rekodow");  //add column to model
            } else if (LatestPrompt.get(0).size() == 6) {  //if Latest Prompt is equal 6
                model.addColumn(new TableColumn(1, 50)); //add column to model
                model.addColumn(new TableColumn(2, 50)); //add column to model
                model.addColumn(new TableColumn(3, 50)); //add column to model
                model.addColumn(new TableColumn(4, 50)); //add column to model
                model.addColumn(new TableColumn(5, 50)); //add column to model
                model.addColumn(new TableColumn(6, 50)); //add column to model
            } else if (LatestPrompt.get(0).size() == 2) {  //if Latest Prompt is equal 2
                model.addColumn(new TableColumn(1, 50)); //add column to model
                model.addColumn(new TableColumn(2, 50)); //add column to model
            }

            // wyciagniecie danych z LatestPrompt i wrzucenie do table
            for(int i = 0; i < LatestPrompt.size(); i++) { //itarate on LatestPrompt
                List<String> record = LatestPrompt.get(i);  //get record from LatestPrompt on i position
                if (record.size() == 6) { // if record equal 6
                    model.addRow(new Object[]{record.get(0), record.get(1), record.get(2), record.get(3), record.get(4), record.get(5)});    //add row
                } else if (record.size() == 2) { // if record equal 2
                    model.addRow(new Object[]{record.get(0), record.get(1)});    //add row
                }
            }
            if (LatestPrompt.get(0).size() == 6) {    //if LatestPrompt equal 6
                model.setColumnIdentifiers(new String[]{"ID_I", "Kolor", "Name", "Opis", "Wartosc", "Ilosc"});    //set names for columns
            } else if (LatestPrompt.get(0).size() == 2) {  //if LatestPrompt equal 2
                model.setColumnIdentifiers(new String[]{"ID_K", "Name"});    //set names for columns
            }
            JTable table = new JTable(model);   //create Table from model
            JScrollPane scrollPane = new JScrollPane(table);    //create ScrollPane and add Table for it
            add(scrollPane);    //add Scroll Pane
        }else{
           JLabel label = new JLabel("brak rekordow");
           add(label);
        }
        setLayout(new FlowLayout());    // set Flow Layout
        WhatDoComeBackButton.addActionListener(this);   //add listing on button
        add(WhatDoComeBackButton);  //add button

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();  //create object and get source
        if(WhatDoComeBackButton == source) {    // if button equal to source
            Main.view = new View("WhatDo"); //create view What Do
            Action.view.dispose();  //dispose this view
        }
    }
}
