package com.example.rockpaperscissors;

public class RockPaperScissors {

    private int playerScore = 0;
    private int computerScore = 0;
    private String scores;
    private String playerWeapon;
    private String computerWeapon;
    private String results;

    public void setScores() {
        scores = "Player: " + playerScore + ", Computer: " + computerScore;
    }

    public String getScores() {
        return scores;
    }

    public String getPlayerWeapon() {
        return playerWeapon;
    }

    public String getComputerWeapon() {
        return computerWeapon;
    }

    public String getResults() {
        return results;
    }

    public void evalMatch(String playerChoice) {
        String message = null;
        String computerChoice = String.valueOf(Weapon.values() [(int) Math.floor(Math.random() *(Weapon.values().length))]).toUpperCase();

        playerWeapon = "Your Weapon: " + Weapon.valueOf(playerChoice);

        computerWeapon = "Computer's Weapon: " + Weapon.valueOf(computerChoice);

        if (Weapon.valueOf(playerChoice).ordinal() == Weapon.valueOf(computerChoice).ordinal()) {
            message = "You both chose the same weapon! Please choose again.";
        }
        else {
            switch (Weapon.valueOf(playerChoice)) {

                //If the user chooses Rock
                case ROCK:
                    switch (Weapon.valueOf(computerChoice)) {

                        case PAPER:
                            message = "Computer wins... Paper covers rock!";
                            computerScore++;
                            break;

                        case SCISSORS:
                            message = "You win... Rock blunts scissors!";
                            playerScore++;
                            break;

                        default:
                            break;
                    }
                    break;

                //If the user chooses Paper
                case PAPER:
                    switch (Weapon.valueOf(computerChoice)) {

                        case ROCK:
                            message = "You win... Paper covers rock!";
                            playerScore++;
                            break;

                        case SCISSORS:
                            message = "Computer wins... Scissors cuts paper!";
                            computerScore++;
                            break;

                        default:
                            break;
                    }
                    break;

                //If the user picks Scissors
                case SCISSORS:
                    switch (Weapon.valueOf(computerChoice)) {

                        case ROCK:
                            message = "Computer wins... Rock blunts scissors!";
                            computerScore++;
                            break;

                        case PAPER:
                            message = "You win... Scissors cuts paper!";
                            playerScore++;
                            break;

                        default:
                            break;
                    }
                    break;
            }

        }
        setScores();
        results = message;
    }
    public void reset() {
        results = scores = playerWeapon = computerWeapon = "";
        playerScore = computerScore = 0;
    }
}
