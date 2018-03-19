package tris;

import java.io.FileInputStream;
import java.util.Properties;

public class Tris {

	public static void main(String[] args) throws Exception {
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/main/resources/tris.properties"));
			
			Match match = TrisFactory.getMatchInstance(properties);
			match.play();

		} catch (Exception e) {
			throw e;

		}
	}
}
