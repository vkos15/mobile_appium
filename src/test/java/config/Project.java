package config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static ConfigBrowserStack config = ConfigFactory.create(ConfigBrowserStack.class, System.getProperties());

    public static ConfigSelenoid configSelenoid = ConfigFactory.create(ConfigSelenoid.class, System.getProperties());
    public static ConfigLocal configLocal = ConfigFactory.create(ConfigLocal.class, System.getProperties());
    public static ConfigEmulator configEmulator = ConfigFactory.create(ConfigEmulator.class, System.getProperties());
}
