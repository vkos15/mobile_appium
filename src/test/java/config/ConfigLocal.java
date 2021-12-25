package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${environment}.properties"
})

public interface ConfigLocal extends Config {
    String deviceName();

    String version();

    String url();
}
