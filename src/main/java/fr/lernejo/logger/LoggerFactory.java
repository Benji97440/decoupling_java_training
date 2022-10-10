package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name){

        Logger log = new ConsoleLogger();
        Logger log1 = new ContextualLogger(name,log);

        Logger log2 = new FileLogger("logs.txt");
        Logger log3 = new FilteredLogger(log2,i -> i.contains("Simulation"));
        Logger log4 = new ContextualLogger(name,log3);
        Logger log5 = new CompositeLogger(log1,log4);
        return log5;
    }
}
