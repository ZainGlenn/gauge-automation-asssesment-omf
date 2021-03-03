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
    protected final Logger log;
    private final Properties properties;

    public TestSettings() {
        this.log = LoggerFactory.getLogger(this.getClass());
        this.properties = new Properties();
        loadAllProperties();
    }

    public static TestSettings getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String getProperty(String propertyName, String defaultValue) {
        return properties.getProperty(propertyName, defaultValue);
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    public int getMaxWaitTimeSeconds() {
        String maxWaitTime = getProperty("element.max.wait.time", "30");
        return Integer.parseInt(maxWaitTime);
    }

    private void loadAllProperties() {
        try {
            properties.putAll(loadProperties(getPropertiesFileName()));
            properties.putAll(loadProperties(COMMON_PROPERTIES_FILE_NAME));
            properties.putAll(loadSystemProperties());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new OMFRuntimeException(e.getMessage(), e);
        }

    }

    private Properties loadProperties(String propertiesFile) throws IOException {
        log.info("Loading properties for: [" + propertiesFile + "].");
        Properties properties = new Properties();
        InputStream resourceAsStream = TestSettings.class.getClassLoader().getResourceAsStream(propertiesFile);
        properties.load(Objects.requireNonNull(resourceAsStream));
        return properties;
    }

    private Properties loadSystemProperties() throws IOException {
        log.info("Loading system properties");
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

    private static class SingletonHolder {
        public static final TestSettings INSTANCE = new TestSettings();
    }


}
