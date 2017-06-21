package Hud;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mandel on 21/06/2017.
 */
public class Score extends JLabel {

    private int score;

    public Score(){
        this.score = 0;

        //this.setFont(new Font("Arial", Font.PLAIN, 20));
        this.refreshScore();
    }
    public Score(final int score){
        this.score = score;

       // this.setFont(new Font("Arial", Font.PLAIN, 20));
        this.refreshScore();
    }

    private void refreshScore(){
        this.setText("Score : " + this.score);
    }
    public void incrementScore(){
        this.score++;
        this.refreshScore();
    }
    public void decrementScore(){
        this.score--;
        this.refreshScore();
    }

    public void setScore(int score) {
        this.score = score;
        this.refreshScore();
    }

    public int getScore() {
        return this.score;

    }
}
