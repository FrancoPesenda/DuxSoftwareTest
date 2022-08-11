package Tenis;

import Exceptions.TenisGameException;

import java.util.ArrayList;

public class Set {

    private ArrayList<Game> games ;
    private String totalPoints1 ;
    private String totalPoints2 ;
    private String nameTournament ;

    public Set( String nameTournament ){
        this.nameTournament = nameTournament ;
        games = new ArrayList<>() ;
        totalPoints1 = "" ;
        totalPoints2 = "" ;
    }

    public Player playGame( Player player1 , Player player2 , Double setToPlay) throws TenisGameException {

        Game game = new Game(player1,player2);

        boolean turnPullOut = true ;

        for (int i = 0; i < setToPlay ; i++) {

            if (turnPullOut){
                System.out.println("SACA: " + player1.getName());
            }else {
                System.out.println("SACA: " + player2.getName());
            }

            Player winner = game.play() ;

            totalPoints1 += player1.getPoints();

            totalPoints2 += player2.getPoints() ;

            winner.setSets(winner.getSets() + 1 );

            System.out.println("================================");
            System.out.println( "Ganador del Set: " + winner.getName());
            System.out.println( player1.getName() + "                  " + getTotalPoints1());
            System.out.println( player2.getName() + "                  " + getTotalPoints2());

            player1.resetPoints();

            player2.resetPoints();

            if (player1.getSets() == Math.ceil(setToPlay / 2 ) ){
                return player1 ;
            }
            else if(player2.getSets() == Math.ceil(setToPlay / 2 ) ) {
                return player2 ;
            }

            if (turnPullOut){
                turnPullOut = false ;
            }else {
                turnPullOut = true ;
            }

        }

        throw new TenisGameException("Se termino el programa por un error.") ;

    }

    public String getTotalPoints1() {
        return totalPoints1;
    }

    public void setTotalPoints1(String totalPoints1) {
        this.totalPoints1 = totalPoints1;
    }

    public String getTotalPoints2() {
        return totalPoints2;
    }

    public void setTotalPoints2(String totalPoints2) {
        this.totalPoints2 = totalPoints2;
    }

    public String getNameTournament() {
        return nameTournament;
    }

    public void setNameTournament(String nameTournament) {
        this.nameTournament = nameTournament;
    }
}
