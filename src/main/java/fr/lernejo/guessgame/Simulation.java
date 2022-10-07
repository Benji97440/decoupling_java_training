package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.text.SimpleDateFormat;
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
        this.logger.log("Le joueur a choisit le nombre : "+nb);
        if (nb == this.numberToGuess){
            this.logger.log("Le joueur a bien deviné le nombre "+nb);
            return true;
        }
        this.logger.log("Le joueur n'a pas deviné le nombre");
        if(nb > this.numberToGuess){
            this.player.respond(true);
        }
        else{
            this.player.respond(false);
        }
        return false;
    }

    public void loopUntilPlayerSucceed(Long ite_max) {
        //TODO implement me
        boolean fin_partie;
        long startTime = System.currentTimeMillis();
        int i = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss.SSS");

        do {fin_partie = nextRound();i++;}while(!fin_partie && i <=ite_max);
        if(i>ite_max)
            this.logger.log("Le joueur à dépasser le nombre d'itération possible");
        long elapsedTimeNs = System.currentTimeMillis() - startTime;
        this.logger.log("Le robot à mit "+simpleDateFormat.format(elapsedTimeNs));
        this.logger.log("Fin de partie");
    }

}
