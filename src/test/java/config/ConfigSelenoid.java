package config;


import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${environment}.properties"
})

public interface ConfigSelenoid extends Config {

    String url();

    String deviceName();

    String version();
}
