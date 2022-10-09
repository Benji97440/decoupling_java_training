package fr.lernejo.logger;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger{
    private final String callerClass;
    private final Logger delegateLogger;
    public ContextualLogger(String class_name, Logger logger){
        this.callerClass = class_name;
        this.delegateLogger = logger;
    }
    @Override

    public void log(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        delegateLogger.log(LocalDateTime.now().format(formatter) + " " + callerClass + " " + message);
    }
}
