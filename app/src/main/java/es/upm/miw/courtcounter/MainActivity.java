package es.upm.miw.courtcounter;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ScoreViewModel scoreViewModel;
    private TextView teamAscoreView;
    private TextView teamBscoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);

        teamAscoreView = findViewById(R.id.teamAscore);
        teamBscoreView = findViewById(R.id.teamBscore);
        displayScoreTeamA();
        displayScoreTeamB();
    }

    public void pointsTeamA(View v) {
        updateTeamScore ("A", (String)((Button) v).getText());
    }

    public void pointsTeamB(View v) {
        updateTeamScore ("B", (String)((Button) v).getText());
    }

    public void resetScores(View v) {
        scoreViewModel.setScoreTeamA(0);
        scoreViewModel.setScoreTeamB(0);
        displayScoreTeamA();
        displayScoreTeamB();
    }

    private void updateTeamScore(String team, String buttonLabel) {
        if(team.equals("A")) {
            scoreViewModel.setScoreTeamA(
                    scoreViewModel.getScoreTeamA() + getButtonPoint(buttonLabel));
            displayScoreTeamA();
        } else if(team.equals("B")) {
            scoreViewModel.setScoreTeamB(
                    scoreViewModel.getScoreTeamB() + getButtonPoint(buttonLabel));
            displayScoreTeamB();
        }
    }

    private void displayScoreTeamA() {
        teamAscoreView.setText(String.valueOf(scoreViewModel.getScoreTeamA()));
    }

    private void displayScoreTeamB() {
        teamBscoreView.setText(String.valueOf(scoreViewModel.getScoreTeamB()));

    }

    private int getButtonPoint(String buttonLabel) {
        switch(buttonLabel) {
            case "+3 Points":
                return 3;
            case "+2 Points":
                return 2;
            case "+1 Points":
                return 1;
        }
        return 0;
    }
}
