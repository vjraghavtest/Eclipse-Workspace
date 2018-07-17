import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TestLogger {

	public static void main(String[] args) throws SecurityException, IOException {
		Logger log=Logger.getLogger(TestLogger.class.getName());
		LogManager.getLogManager().reset();
		FileHandler fileHandler=new FileHandler("C:\\Users\\Administrator\\Desktop\\New Text Document.txt");
		fileHandler.setFormatter(new SimpleFormatter());
		log.addHandler(fileHandler);
		
		log.log(Level.INFO, "MSG");
		log.log(Level.INFO, "MSG");
		log.log(Level.INFO, "MSG");
		log.log(Level.INFO, "MSG");
	}

}
