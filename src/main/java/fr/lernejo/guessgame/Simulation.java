package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        long nb = player.askNextGuess();
        this.logger.log("Le joueur a choisit le nombre :"+nb);
        if (nb == this.numberToGuess){
            this.logger.log("Le joueur a deviné le nombre "+nb);
            return true;
        }
        this.logger.log("Le joueur n'a pas deviné le nombre");
        if(nb > this.numberToGuess){
            this.player.respond(true);
            this.logger.log("Le joueur doit deviné un nombre plus grand");
        }
        else{
            this.player.respond(false);
            this.logger.log("Le joueur doit deviné un nombre plus petit");
        }
        return false;
    }

    public void loopUntilPlayerSucceed() {
        //TODO implement me
        boolean fin_partie;
        do {fin_partie = nextRound();}while(fin_partie);
        this.logger.log("Fin de partie");
    }

}
