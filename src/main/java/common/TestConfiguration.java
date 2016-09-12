package common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by rgolovatyi on 9/12/2016.
 */
public class TestConfiguration {
    public static String getProperty(String property){
        try {
            Properties properties = new Properties();
            InputStream config = TestConfiguration.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(config);
            return properties.getProperty(property);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
