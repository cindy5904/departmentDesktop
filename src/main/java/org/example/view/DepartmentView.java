package org.example.view;

import org.example.controller.DepartmentController;
import org.example.model.Department;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartmentView {
    private DepartmentController departmentController = new DepartmentController();

    public DepartmentView() {

        JFrame frame = new JFrame("Gestion des Départements");
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


        JButton addButton = new JButton("Ajouter Département");
        addButton.setBounds(10, 60, 180, 25);
        panel.add(addButton);


        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 100, 450, 200);
        panel.add(textArea);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                Department department = new Department(name);
                departmentController.addDepartment(department);


                textArea.setText(departmentController.getAllDepartments().toString());
                nameText.setText("");
            }
        });


        JButton deleteButton = new JButton("Supprimer Département");
        deleteButton.setBounds(200, 60, 180, 25);
        panel.add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog(frame, "Entrez l'ID du département à supprimer:");
                if (idStr != null && !idStr.isEmpty()) {
                    try {
                        Long id = Long.parseLong(idStr);
                        departmentController.deleteDepartment(id);


                        textArea.setText(departmentController.getAllDepartments().toString());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "ID invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


        textArea.setText(departmentController.getAllDepartments().toString());


        frame.setVisible(true);
    }
}
