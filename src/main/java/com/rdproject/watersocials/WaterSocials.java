package com.rdproject.watersocials;

import com.rdproject.watersocials.commands.*;
import com.rdproject.watersocials.listeners.*;
import com.rdproject.watersocials.utils.*;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.plugin.*;
import net.md_5.bungee.config.*;

import java.io.*;
import java.nio.file.*;

@SuppressWarnings("ALL")
public class WaterSocials extends Plugin {

    public static Configuration cg;
    private static WaterSocials plugin;
    public static final String DEV = "ArtemYTO";
    public static final String DEV_COMPANY = "RDProject";
    public static final String VERSION = "1.0";
    public static final String PLUGIN_NAME = "WaterSocials";
    public static final String LIST = "§8§l----------------------------";
    public static final String STARTUP_MESSAGE = "\n" + " \\ \\        /       |                 ___|               _)         |       \n" +
            "  \\ \\  \\   /  _` |  __|   _ \\   __| \\___ \\    _ \\    __|  |   _` |  |   __| \n" +
            "   \\ \\  \\ /  (   |  |     __/  |          |  (   |  (     |  (   |  | \\__ \\ \n" +
            "    \\_/\\_/  \\__,_| \\__| \\___| _|    _____/  \\___/  \\___| _| \\__,_| _| ____/ " + "Version " + VERSION;
    public static final String NON_LOADED_COMMANDS = "Sorry, you set All Commands to False, Plugin Disabling...";

    @Override
    public void onEnable() {
        new Metrics(this, 14321);
        plugin = this;

        getConfigs();
        LoadConfigs();
        LoadListeners();
        LoadCustomCommands();
        LoadCMDs();
        getLogger().info(STARTUP_MESSAGE);

        UpdateChecker updateChecker = new UpdateChecker(this, 99826);
        try {
            if (updateChecker.checkForUpdates()) {
                getLogger().info(LIST);
                getLogger().info("    §8• §bWaterSocials §8•");
                getLogger().info("");
                getLogger().info("§8× §7Update Available!");
                getLogger().info("§8× §7Download it from Spigot!");
                getLogger().info("");
                getLogger().info(LIST);
            } else {
                getLogger().info(LIST);
                getLogger().info("    §8• §bWaterSocials §8•");
                getLogger().info("");
                getLogger().info("§8× §7You are using the Latest Version!");
                getLogger().info("");
                getLogger().info(LIST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getConfigs() {
        if (!getDataFolder().exists())
            getDataFolder().mkdir();
        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists())
            try {
                InputStream in = getResourceAsStream("config.yml");
                Files.copy(in, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static void LoadConfigs() {
        try {
            cg = ConfigurationProvider.getProvider(YamlConfiguration.class)
                    .load(new File(plugin.getDataFolder(), "config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void LoadListeners() {
        ProxyServer.getInstance().getPluginManager().registerListener(this, new WaterListener());
    }

    public void LoadCustomCommands() {
        if (cg.getBoolean("ToggleCommands.one") == true) {
            getProxy().getPluginManager().registerCommand(this, new FirstCommand());
            getProxy().getPluginManager().registerCommand(this, new SocialsCommand());
        } else {
            getProxy().getPluginManager().registerCommand(this, new SecondCommand());
            getProxy().getPluginManager().registerCommand(this, new FifthCommand());
            getProxy().getPluginManager().registerCommand(this, new FourthCommand());
            getProxy().getPluginManager().registerCommand(this, new ThirdCommand());
            getProxy().getPluginManager().registerCommand(this, new SocialsCommand());

            if (cg.getBoolean("ToggleCommands.two") == true) {
                getProxy().getPluginManager().registerCommand(this, new SecondCommand());
                getProxy().getPluginManager().registerCommand(this, new SocialsCommand());
            } else {
                getProxy().getPluginManager().registerCommand(this, new FirstCommand());
                getProxy().getPluginManager().registerCommand(this, new FifthCommand());
                getProxy().getPluginManager().registerCommand(this, new FourthCommand());
                getProxy().getPluginManager().registerCommand(this, new ThirdCommand());
                getProxy().getPluginManager().registerCommand(this, new SocialsCommand());

                if (cg.getBoolean("ToggleCommands.three") == true) {
                    getProxy().getPluginManager().registerCommand(this, new ThirdCommand());
                    getProxy().getPluginManager().registerCommand(this, new SocialsCommand());
                } else {
                    getProxy().getPluginManager().registerCommand(this, new FirstCommand());
                    getProxy().getPluginManager().registerCommand(this, new SecondCommand());
                    getProxy().getPluginManager().registerCommand(this, new FourthCommand());
                    getProxy().getPluginManager().registerCommand(this, new FifthCommand());
                    getProxy().getPluginManager().registerCommand(this, new SocialsCommand());

                    if (cg.getBoolean("ToggleCommands.four") == true) {
                        getProxy().getPluginManager().registerCommand(this, new FourthCommand());
                        getProxy().getPluginManager().registerCommand(this, new SocialsCommand());
                    } else {
                        getProxy().getPluginManager().registerCommand(this, new FirstCommand());
                        getProxy().getPluginManager().registerCommand(this, new SecondCommand());
                        getProxy().getPluginManager().registerCommand(this, new FifthCommand());
                        getProxy().getPluginManager().registerCommand(this, new ThirdCommand());
                        getProxy().getPluginManager().registerCommand(this, new SocialsCommand());

                        if (cg.getBoolean("ToggleCommands.five") == true) {
                            getProxy().getPluginManager().registerCommand(this, new FifthCommand());
                            getProxy().getPluginManager().registerCommand(this, new SocialsCommand());
                        } else {
                            getProxy().getPluginManager().registerCommand(this, new FirstCommand());
                            getProxy().getPluginManager().registerCommand(this, new SecondCommand());
                            getProxy().getPluginManager().registerCommand(this, new FourthCommand());
                            getProxy().getPluginManager().registerCommand(this, new ThirdCommand());
                            getProxy().getPluginManager().registerCommand(this, new SocialsCommand());
                        }
                    }
                }
            }
        }
    }

    public void LoadCMDs() {
        getProxy().getPluginManager().registerCommand(this, new ReloadCommand());
        getProxy().getPluginManager().registerCommand(this, new WaterSocialsCommand());
    }
}