package com.rdproject.watersocials.commands;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.plugin.*;

import static com.rdproject.watersocials.WaterSocials.*;

@SuppressWarnings("ALL")
public class ReloadCommand extends Command {
    public ReloadCommand() {
        super("socialsreload", "WaterSocials.Reload");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer player = (ProxiedPlayer) sender;
        if (sender != null) {
            player.sendMessage(cg.getString("Prefix") + "§bConfiguration successfully reloaded!");
            LoadConfigs();
        }
    }
}
