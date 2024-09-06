package org.example.view;

import org.example.controller.EmployeController;
import org.example.model.Employe;
import org.example.model.Role;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeView {
     private EmployeController employeeController = new EmployeController();

    public EmployeView() {
        JFrame frame = new JFrame("Employee Management");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);


        JLabel nameLabel = new JLabel("Nom:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(10, 50, 80, 25);
        panel.add(roleLabel);

        JComboBox<Role> roleComboBox = new JComboBox<>(Role.values());
        roleComboBox.setBounds(100, 50, 165, 25);
        panel.add(roleComboBox);


        JButton addButton = new JButton("Ajouter");
        addButton.setBounds(10, 80, 100, 25);
        panel.add(addButton);


        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 110, 450, 200);
        panel.add(textArea);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                Role role = (Role) roleComboBox.getSelectedItem();
                Employe employe = new Employe(name, role, null);
                employeeController.addEmployee(employe);
                textArea.setText(employeeController.getAllEmployes().toString());
            }
        });

        frame.setVisible(true);
    }
}
