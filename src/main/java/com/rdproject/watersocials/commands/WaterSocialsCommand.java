package com.rdproject.watersocials.commands;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.plugin.*;

@SuppressWarnings("ALL")
public class WaterSocialsCommand extends Command {

    public WaterSocialsCommand() {
        super("watersocials", "WaterSocials.DevCommand", "watersoc, dev");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer player = (ProxiedPlayer) sender;

        TextComponent system = new TextComponent("");
        system.setText("§8• §bWSystem §8× §7This server using §bWaterSocials §8× §bRDProject!");
        system.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/RDProjectOfficial"));
        system.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§8• §bClick to Open URL!").create()));

        if (sender != null) {
            player.sendMessage(system);
        }
    }
}

