package fr.lernejo.guessgame;

import fr.lernejo.logger.ConsoleLogger;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player{
    Logger log = LoggerFactory.getLogger("player");
    @Override
    public long askNextGuess() {
        Scanner scanner = new Scanner(System.in);
         return scanner.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        this.log.log(String.valueOf(lowerOrGreater));// true if greater and false if lower
    }
}
