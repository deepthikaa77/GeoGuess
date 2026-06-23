package org.example.controller;

import org.example.model.QuestionModel;
import org.example.view.QuestionView;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionController {
    private QuestionView view;
    private List<QuestionModel> questions;
    private int score = 0;
    private int currentIndex;

    public QuestionController(QuestionView view){
        this.view = view;
        this.questions = new ArrayList<>();

        loadQuizData();
        Collections.shuffle(questions);

        if(!questions.isEmpty()){
            view.updateQuestionText(questions.get(currentIndex).getCountry());
        }
        this.view.addSubmitListener(e -> handleSubmit());
    }
    public void loadQuizData(){
        try(BufferedReader reader = new BufferedReader(new FileReader("src/quiz_data.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                if(line.trim().isEmpty()){
                    continue;
                }
                String[] parts = line.split(",");
                if(parts.length == 2){
                    questions.add(new QuestionModel(parts[1].trim(), parts[0].trim()));
                }
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(view.getFrame(), "Error Loading File. Retry");
        }
    }

    public void handleSubmit(){
        String userInput = view.getUserInput();
        QuestionModel currentQuestion = questions.get(currentIndex);

        if(userInput.equalsIgnoreCase(currentQuestion.getCapital())){
            JOptionPane.showMessageDialog(view.getFrame(), "Wow you are correct!");
            score++;
        } else{
            JOptionPane.showMessageDialog(view.getFrame(), "Wrong the Correct answer is " + currentQuestion.getCapital());
        }
        view.clearInputField();
        currentIndex++;
        if(currentIndex < questions.size()){
            view.updateQuestionText(questions.get(currentIndex).getCountry());
        } else{
            JOptionPane.showMessageDialog(view.getFrame(), "Quiz Completed! Your final score: " + score + "/" + questions.size());
            System.exit(0);
        }
    }
}
