package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{
    private long borneInf = 0;
    private long borneSup = Long.MAX_VALUE;
    private long temp;
    Logger log = LoggerFactory.getLogger("- ComputerPlayer -");
    @Override
    public long askNextGuess() {
        this.temp = (this.borneInf + this.borneSup)/2;
        return this.temp;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater){
            this.borneSup = this.temp;
            this.log.log("Le nombre à deviner est plus petit");// true if greater and false if lower
        }
        else
        {
            this.borneInf = this.temp;
            this.log.log("Le nombre à deviner est plus grand");// true if greater and false if lower
        }
    }
}
