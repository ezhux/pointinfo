package lt.ezz.pointinfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(App.class);
		log.info("Starting");
	}
}
