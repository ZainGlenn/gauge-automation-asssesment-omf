package org.gauge.omf.utils;

import org.gauge.omf.exception.OMFRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class TestSettings {

    private static final String COMMON_PROPERTIES_FILE_NAME = "common.properties";
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    private final Properties properties = new Properties();

    private TestSettings() {
        try {
            properties.putAll(loadProperties(getPropertiesFileName()));
            properties.putAll(loadProperties(COMMON_PROPERTIES_FILE_NAME));
            properties.putAll(loadSystemProperties());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new OMFRuntimeException(e.getMessage(), e);
        }
    }

    public static TestSettings getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private Properties loadProperties(String propertiesFile) throws IOException {
        log.info("Loading properties for: [" + propertiesFile + "].");
        Properties properties = new Properties();
        InputStream resourceAsStream = TestSettings.class.getClassLoader().getResourceAsStream(propertiesFile);
        properties.load(Objects.requireNonNull(resourceAsStream));
        return properties;
    }

    private Properties loadSystemProperties() {
        log.info("Loading system properties:");
        return System.getProperties();
    }

    private String getPropertiesFileName() {
        String propertiesFile = System.getProperty("env.properties");
        if (propertiesFile == null) {
            propertiesFile = "default";
        }
        propertiesFile = propertiesFile + ".properties";
        return propertiesFile;
    }

    public int getMaxWaitTimeSeconds() {
        String maxWaitTime = properties.getProperty("element.max.wait.time", "10");
        return Integer.parseInt(maxWaitTime);
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    public String getLocale() {
        return properties.getProperty("browser.localisation", "en");
    }

    public boolean isJenkins() {
        String jenkins = properties.getProperty("jenkins.headless", "false");
        return Boolean.parseBoolean(jenkins);
    }

    public boolean isHolderBrowserOpen() {
        String jenkins = properties.getProperty("browser.open", "false");
        return Boolean.parseBoolean(jenkins);
    }

    public boolean isRemote() {
        String isRemote = properties.getProperty("browser.isRemote", "false");
        return Boolean.parseBoolean(isRemote);
    }

    public String remoteUrl() {
        return properties.getProperty("browser.remoteUrl", null);
    }

    public String getBrowserType(){
        return properties.getProperty("browser.type", "chrome");
    }

    private static class SingletonHolder {
        public static final TestSettings INSTANCE = new TestSettings();
    }


}
