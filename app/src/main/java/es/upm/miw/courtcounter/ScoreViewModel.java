package es.upm.miw.courtcounter;

import android.arch.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    public int getScoreTeamA() {
        return scoreTeamA;
    }

    public void setScoreTeamA(int scoreTeamA) {
        this.scoreTeamA = scoreTeamA;
    }

    public int getScoreTeamB() {
        return scoreTeamB;
    }

    public void setScoreTeamB(int scoreTeamB) {
        this.scoreTeamB = scoreTeamB;
    }
}
