package config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static ConfigBrowserStack config = ConfigFactory.create(ConfigBrowserStack.class, System.getProperties());
}
