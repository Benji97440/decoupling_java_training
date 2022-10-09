package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;
public class Launcher {
    public static void main(String[] args){
        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        SecureRandom random = new SecureRandom();
        Logger logger = LoggerFactory.getLogger("- Launcher -");
        logger.log("Lancement du Launcher");

        if(args[0].equals("-interactive")){
            long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
            logger.log("Le nombre a deviné est "+randomNumber);
            Simulation simulation = new Simulation(humanPlayer);
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);

        }else if(args[0].equals("-auto") && args.length == 2){
            try {
                    Long long_value = Long.parseLong(args[1]);
                    Simulation simulation = new Simulation(computerPlayer);
                    simulation.initialize(long_value);
                    simulation.loopUntilPlayerSucceed(1000);

            } catch (NumberFormatException e) {
                logger.log("Input String cannot be parsed to Long.");
            }
        }else {
            logger.log("Erreur d'argument avec les modes");
            logger.log("Entrer :\n -interactive (pour lancer une partie solo)\n ou -auto nb (avec un nombre à la place de nb pour lancer une partie gérer par l'ordinateur)");
        }
    }
}
