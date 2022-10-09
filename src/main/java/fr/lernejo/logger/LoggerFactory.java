package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name){
        //Logger logger = LoggerFactory.getLogger(name);
        //Logger logger;

        Logger log = new ConsoleLogger();
        return new ContextualLogger(name,log);
        //return new FileLogger("logs.txt");
        //return file;
    }
}
