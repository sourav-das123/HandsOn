package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static String projectdirectory = System.getProperty("user.dir");
    public static String ReadEnvironmentParameters(String key) throws IOException
    {
        Properties environmentparameters = new Properties();
        FileInputStream filepath = new FileInputStream
                (new File(projectdirectory+"\\EnvironmentParameters.properties"));
        environmentparameters.load(filepath);
        String value = environmentparameters.getProperty(key);
        return value;
    }


}
