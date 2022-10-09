package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name){
        //Logger logger = LoggerFactory.getLogger(name);
        //Logger logger;
        Logger log = new ConsoleLogger();
        Logger log1 = new ContextualLogger(name,log);
        Logger log2 = new FileLogger("logs.txt");
        return new CompositeLogger(log1,log2);
        //return log2;
        //return file;
    }
}
