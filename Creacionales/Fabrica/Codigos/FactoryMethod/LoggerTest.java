public class LoggerTest {
  public static void main(String[] args) {
 //  crea un objecto factory basado en la clase loggerfactory
    LoggerFactory factory = new LoggerFactory();
//   llama la función getlogger de factory
    Logger logger = factory.getLogger();
    logger.log("Mgffggf");
  }
}
