package org.midage.midagecore;

import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import lombok.extern.slf4j.Slf4j;
import org.allaymc.api.plugin.Plugin;

@Slf4j
public class Loader extends Plugin {

    public static Loader INSTANCE;

    private Config CONFIG;

    @Override
    public void onLoad() {
        INSTANCE = this;
        log.info("MIDAGECore loaded!");
        CONFIG = ConfigManager.create(Config.class, config -> {
            config.withConfigurer(new YamlSnakeYamlConfigurer());
            config.withBindFile(pluginContainer.dataFolder().resolve("config.yml"));
            config.withRemoveOrphans(true);
            config.saveDefaults();
            config.load(true);
        });

    }

    @Override
    public void onEnable() {
        log.info("MIDAGECore enabled!");
    }

    @Override
    public void onDisable() {
        log.info("MIDAGECore disabled!");
    }
}