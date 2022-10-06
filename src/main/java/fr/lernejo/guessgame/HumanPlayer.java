package fr.lernejo.guessgame;

import fr.lernejo.logger.ConsoleLogger;
import fr.lernejo.logger.Logger;

import java.util.Scanner;

public class HumanPlayer implements Player{
    private final ConsoleLogger log= new Logger();
    @Override
    public long askNextGuess() {
        Scanner scanner = new Scanner(System.in);
         return scanner.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {

    }
}
