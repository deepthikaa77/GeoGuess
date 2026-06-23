package org.example.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class QuestionView {
    private JFrame frame;
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton;

    public QuestionView() {
        frame = new JFrame("Country and Capital");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        questionLabel = new JLabel("Loading Question...");
        questionLabel.setBounds(50, 40, 300, 30);
        frame.add(questionLabel);

        answerField = new JTextField();
        answerField.setBounds(50, 90, 200, 30);
        frame.add(answerField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(260, 90, 90, 30);
        frame.add(submitButton);
    }

    public void showView(){
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public String getUserInput(){
        return answerField.getText().trim();
    }

    public void clearInputField(){
        answerField.setText("");
    }

    public void updateQuestionText(String country){
        questionLabel.setText("Enter the Captial of " + country + "?");
    }

    public void addSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

}
