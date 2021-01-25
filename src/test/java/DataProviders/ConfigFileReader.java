package DataProviders;

import Data.DriverType;
import Data.EnvironmentType;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;

    public ConfigFileReader() {
        properties = new Properties();
        String propertyFilePath = "Configs/Configuration.properties";
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(propertyFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public EnvironmentType getEnvironment() {
        String environment = properties.getProperty("environment");
        if(environment == null || environment.trim().equalsIgnoreCase("localweb")){
            return EnvironmentType.LOCALWeb;
        }

        else throw new RuntimeException("'environment' not specified correctly in Configuration.properties. Expected [local|saucelabs] and got " + environment);
    }


    public String getChromeDriverPath(){
        String chromeDriverPath = properties.getProperty("chromeDriverPath");
        if(chromeDriverPath!= null) {
            return chromeDriverPath.trim();
        }else {
            throw new RuntimeException("'chromeDriverPath' not specified in the Configuration.properties file.");
        }
    }


    public String getFirefoxDriverPath(){
        String firefoxDriverPath = properties.getProperty("firefoxDriverPath");
        if(firefoxDriverPath!= null) {
            return firefoxDriverPath.trim();
        }else {
            throw new RuntimeException("'firefoxDriverPath' not specified in the Configuration.properties file.");
        }
    }

    public String getIeDriverPath(){
        String ieDriverPath = properties.getProperty("ieDriverPath");
        if(ieDriverPath!= null) {
            return ieDriverPath.trim();
        }else {
            throw new RuntimeException("'ieDriverPath' not specified in the Configuration.properties file.");
        }
    }

    private DriverType getDriverType(String browserName){
        if(browserName == null || browserName.trim().equalsIgnoreCase("firefox")){
            return DriverType.FIREFOX;
        }
        else if(browserName.trim().equalsIgnoreCase("chrome")){
            return DriverType.CHROME;
        }
        else if(browserName.trim().equalsIgnoreCase("ie")) {
            return DriverType.IE;
        }
        else throw new RuntimeException("'browser name' has an invalid value in Configuration.properties. Expected [chrome|firefox|ie]");
    }

    public DriverType getLocalBrowserName()
    {
        return getDriverType(properties.getProperty("localBrowserName"));
    }


    public Integer getImplicitlyWait(){
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait!= null) {
            return Integer.parseInt(implicitlyWait.trim());
        }else {
            System.out.println("'implicitlyWait' not specified in the Configuration.properties file.");
            return 10;
        }
    }

    public String getURL(){
        String url = properties.getProperty("url");
        if(url!= null) {
            return url.trim();
        }else {
            throw new RuntimeException("'url' not specified in the Configuration.properties file.");
        }
    }


    }
