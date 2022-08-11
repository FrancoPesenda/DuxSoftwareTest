package Main;

import Exceptions.TenisGameException;
import Tenis.Game;
import Tenis.Player;
import Tenis.Set;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws TenisGameException {

        Scanner scanner = new Scanner(System.in) ;

        Integer remach = 0 ;

        do {

            System.out.println();

            System.out.print("Nombre del torneo: ");

            String tournamentName = scanner.nextLine();

            System.out.println(" - Ingresa los datos del primer jugador - ");

            System.out.print("Nombre: ");

            String name = scanner.nextLine();

            System.out.print("Probabilidad de ganar: ");

            Integer probability = scanner.nextInt();

            scanner.nextLine();

            Player player1 = new Player(name, probability);

            System.out.println(" - Ingresa los datos del segundo jugador - ");

            System.out.print("Nombre: ");

            name = scanner.nextLine();

            System.out.println("Probabilidad de ganar: " + (100 - probability));

            probability = 100 - probability;

            Player player2 = new Player(name, probability);

            double bestOf;

            do {

                System.out.print("Selecciona el modo a mejor de 3 o 5: ");

                bestOf = scanner.nextDouble();

            } while (!(bestOf == 3 || bestOf == 5));

            Set tennisGame = new Set(tournamentName);

            Player winner = tennisGame.playGame(player1, player2, bestOf);
            System.out.println("================================");
            System.out.println("Semifinal - " + tennisGame.getNameTournament() + "     Finalizado");
            System.out.println(player1.getName() + "                  " + tennisGame.getTotalPoints1());
            System.out.println(player2.getName() + "                  " + tennisGame.getTotalPoints2());
            System.out.println("GANADOR: " + winner.getName());
            System.out.println("================================");

            do {
                try {
                    System.out.println(" QUIERE JUGAR LA REVANCHA? ");
                    System.out.println(" Ingrese 1 para volver a jugar ");
                    System.out.println(" ingrese 2 para salir ");
                    System.out.print(">");
                    remach = scanner.nextInt();
                    scanner.nextLine();
                }catch (Exception e ){
                    System.out.println("Tipo de dato no admitido");
                    return;
                }
            }while (!(remach == 1 || remach == 2)) ;

        }while (remach == 1) ;

    }
}
