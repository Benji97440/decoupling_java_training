package fr.lernejo.logger;

import java.io.IOException;
import java.nio.file.Files;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;


public class CompositeLogger implements Logger{
    private final Logger log1;
    private final Logger log2;
    public CompositeLogger(Logger log1, Logger log2){
        this.log1 = log1;
        this.log2 = log2;
    }
    public void log(String message) {
        this.log1.log(message);
        this.log2.log(message);
    }
}
