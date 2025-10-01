package org.midage.midagecore;

import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import lombok.extern.slf4j.Slf4j;
import org.allaymc.api.eventbus.event.player.PlayerEvent;
import org.allaymc.api.plugin.Plugin;
import org.allaymc.api.registry.Registries;
import org.allaymc.api.server.Server;
import org.midage.midagecore.event.PlayerEventManager;
import org.midage.midagecore.rank.RankCommand;

@Slf4j
public class Loader extends Plugin {

    //TODO: 新人加入 各种物品指令使用教学

    public static Loader INSTANCE;

    public Config CONFIG;
    public Config RANKCONFIG2;

    @Override
    public void onLoad() {
        INSTANCE = this;
        log.info("MIDAGECore loaded!");
        initConfig();
    }

    @Override
    public void onEnable() {
        log.info("MIDAGECore enabled!");
        registerEvent();
        registerCommand();
    }

    @Override
    public void onDisable() {
        log.info("MIDAGECore disabled!");
    }

    private void registerEvent(){
        Server.getInstance().getEventBus().registerListener(new PlayerEventManager());
        //其他的event
    }

    private void registerCommand(){
        Registries.COMMANDS.register(new RankCommand());
    }

    private void initConfig(){

        CONFIG = ConfigManager.create(Config.class, config -> {
            config.withConfigurer(new YamlSnakeYamlConfigurer());
            config.withBindFile(pluginContainer.dataFolder().resolve("config.yml"));
            config.withRemoveOrphans(true);
            config.saveDefaults();
            config.load(true);
        });

        /*
        RANKCONFIG2 = ConfigManager.create(Config.class, config -> {
            config.withConfigurer(new YamlSnakeYamlConfigurer());
            config.withBindFile(pluginContainer.dataFolder().resolve("rank-config.yml"));
            config.withRemoveOrphans(true);
            config.saveDefaults();
            config.load(true);
        });*/
    }
}