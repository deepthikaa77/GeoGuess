package org.example;

import org.example.controller.QuestionController;
import org.example.model.QuestionModel;
import org.example.view.QuestionView;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int score = 0;
    static int currentIndex = 0;
    public static void main(String[] args) {
        QuestionView view = new QuestionView();
        QuestionController controller = new QuestionController(view);
        view.showView();
    }
}