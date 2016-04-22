package ohtu;

public class TennisGame {
    
    private int player1Score;
    private int player2Score;
    private final String player1Name;
    private final String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        player1Score = 0;
        player2Score = 0;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1Score++;
        else if (playerName.equals(player2Name))
            player2Score++;
    }

    public String getScore() {
        if (player1Score==player2Score) return evenScore(player1Score);
        else if (player1Score>=4 && player1Score>player2Score) return endGameScore(player1Name, player1Score-player2Score);
        else if (player2Score>=4 && player2Score>player1Score) return endGameScore(player2Name, player2Score-player1Score);
        else return regularScore();
    }
    
    private String endGameScore(String gameLeader, int lead) {
        switch (lead) {
            case 1: return "Advantage " + gameLeader;
            default: return "Win for " + gameLeader;
        }
    }
    
    private String evenScore(int commonScore) {
        if (commonScore < 4) return score(commonScore) + "-All";
        else return "Deuce";
    }
    
    private String regularScore() {
        return score(player1Score) + "-" + score(player2Score);
    }
    
    private String score(int score) {
        switch(score) {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            default: return "Forty";
        }
    }
    
}