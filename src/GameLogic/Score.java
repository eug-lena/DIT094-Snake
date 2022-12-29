package GameLogic;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Score {
    private static ArrayList<Double> scoreList = new ArrayList<>();
    private double score;

    public Score(double score) { // could add name or date
        scoreList.add(score);
        sortHighScores();
        this.score = score;
    }

    public void sortHighScores() {
        for (int i = 0; i < scoreList.size(); i++) {
            System.out.println(scoreList.get(i));
        }
    }
    /*
     * public double getScore() {
     * return score;
     * }
     * 
     * public void setScore(double score) {
     * this.score = score;
     * }
     * 
     */

}
