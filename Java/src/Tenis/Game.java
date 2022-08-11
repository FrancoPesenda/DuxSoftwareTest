package Tenis;

import java.util.Random;

public class Game {

    private Player player1 ;
    private Player player2 ;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player play( ){
        Integer diference = 1 ;
        while (true){
            //Juegan
            this.playGame();
            //Muestra el resultado parcial
            this.showMessage();
            if (player1.getPoints() == 3 && player2.getPoints() == 3 && diference == 1 ){
                diference ++ ;
            }

            if (player1.getPoints() == 6 && player2.getPoints() == 6 ){
                System.out.println("JUEGAN TIEBREACK");
                Player winner = playTieBreaks() ;
                winner.setPoints(winner.getPoints() + 1 );
                return winner ;
            }

            if ((Math.abs(player1.getPoints() - player2.getPoints()) >= diference) && (player1.getPoints() >= 6 || player2.getPoints() >= 6)){
                if ((player1.getPoints() - player2.getPoints()) > 0 ){
                    return player1 ;
                }
                else {
                    return player2 ;
                }
            }

        }
    }

    private Player playTieBreaks(){
        String playerToPullOut = player1.getName();
        while (true){
            //Juegan
            this.playTieBreak();
            //Muestra el resultado parcial
            this.showMessageTieBreack();
            if ((Math.abs(player1.getTieBreakPoints() - player2.getTieBreakPoints()) >= 2) && (player1.getTieBreakPoints() >= 7 || player2.getTieBreakPoints() >= 7)){
                if ((player1.getTieBreakPoints() - player2.getTieBreakPoints()) > 0 ){
                    return player1 ;
                }
                else {
                    return player2 ;
                }
            }
        }

    }

    private void showMessage(){
        System.out.println("||" + player1.getName() + " --- " + player2.getName() + "||");
        System.out.println( "||    " + player1.getPoints() + " --- " + player2.getPoints() + "    ||");
    }

    private void showMessageTieBreack(){
        System.out.println("||" + player1.getName() + " --- " + player2.getName() + "||");
        System.out.println( "||    " + player1.getTieBreakPoints() + " --- " + player2.getTieBreakPoints() + "    ||");
    }

    private void playTieBreak(){
        if (this.winingGame(player1.getProbabilityOfWining())){
            player1.setTieBreakPoints(player1.getTieBreakPoints() + 1 );
        }else {
            player2.setTieBreakPoints(player2.getTieBreakPoints() + 1 );
        }
    }

    private void playGame(){
        if (this.winingGame(player1.getProbabilityOfWining())){
            player1.setPoints(player1.getPoints() + 1 );
        }else {
            player2.setPoints(player2.getPoints() + 1 );
        }
    }

    private boolean winingGame ( Integer probability ){
        Random ran = new Random() ;
        int val = ran.nextInt(100) + 1;
        return val < ( probability - 1 ) ;
    }

}
