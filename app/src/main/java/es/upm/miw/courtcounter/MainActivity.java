package es.upm.miw.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private static final String TEAM_A = "A";
    private static final String TEAM_B = "B";
    private TextView teamAscoreView;
    private TextView teamBscoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamAscoreView = findViewById(R.id.teamAscore);
        teamBscoreView = findViewById(R.id.teamBscore);
        displayScoreTeamA();
        displayScoreTeamB();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(TEAM_A, scoreTeamA);
        savedInstanceState.putInt(TEAM_B, scoreTeamB);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null) {
            scoreTeamA = savedInstanceState.getInt(TEAM_A);
            scoreTeamB = savedInstanceState.getInt(TEAM_B);
            displayScoreTeamA();
            displayScoreTeamB();
        }
    }

    public void pointsTeamA(View v) {
        updateTeamScore ("A", (String)((Button) v).getText());
    }

    public void pointsTeamB(View v) {
        updateTeamScore ("B", (String)((Button) v).getText());
    }

    public void resetScores(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayScoreTeamA();
        displayScoreTeamB();
    }

    private void updateTeamScore(String team, String buttonLabel) {
        if(team.equals("A")) {
            scoreTeamA += getButtonPoint(buttonLabel);
            displayScoreTeamA();
        } else if(team.equals("B")) {
            scoreTeamB += getButtonPoint(buttonLabel);
            displayScoreTeamB();
        }
    }

    private void displayScoreTeamA() {
        teamAscoreView.setText(String.valueOf(scoreTeamA));
    }

    private void displayScoreTeamB() {
        teamBscoreView.setText(String.valueOf(scoreTeamB));

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
