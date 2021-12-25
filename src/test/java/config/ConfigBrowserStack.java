package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack.properties"
})

public interface ConfigBrowserStack extends Config {

    String user();

    String key();

    String url();

}
