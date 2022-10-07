package fr.lernejo.guessgame;

import java.security.SecureRandom;
public class Launcher {
    public static void main(String[] args){
        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        SecureRandom random = new SecureRandom();


        if(args[0].equals("-interactive")){
            long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
            System.out.println("Le nombre a deviné est "+randomNumber);
            Simulation simulation = new Simulation(humanPlayer);
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);

        }else if(args[0].equals("-auto")){
            try {
                Long long_value = Long.parseLong(args[1]);
                Simulation simulation = new Simulation(computerPlayer);
                simulation.initialize(long_value);
                simulation.loopUntilPlayerSucceed(1000L);

            } catch (NumberFormatException e) {
                System.out.println("Input String cannot be parsed to Long.");
            }
        }else {
            System.out.println("Erreur d'arguments");
            System.out.println("Entrer :\n-interactive (pour lancer une partie solo)\n-auto nb (avec un nombre à la place de nb pour lancer une partie gérer par l'ordinateur)");
        }

    }
}
