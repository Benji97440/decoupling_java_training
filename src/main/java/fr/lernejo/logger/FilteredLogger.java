package fr.lernejo.logger;

import java.util.function.Predicate;

public class FilteredLogger implements Logger{
    private final Logger logger;
    private Predicate<String> condition;
    public FilteredLogger(Logger delegate, Predicate<String> condition) {
        //TODO assign arguments to fields
        this.logger = delegate;
        this.condition = condition;
    }
    public void log(String message) {
        if(this.condition.test(message)){
            logger.log(message);
        }
    }
}
