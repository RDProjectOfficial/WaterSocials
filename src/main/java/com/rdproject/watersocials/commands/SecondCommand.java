package com.rdproject.watersocials.commands;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.plugin.*;

import static com.rdproject.watersocials.WaterSocials.*;

@SuppressWarnings("ALL")
public class SecondCommand extends Command {

    public SecondCommand() {
        super(cg.getString("SocialCommands.two"), cg.getString("Permissions.two"), cg.getString("SocialAliases.two"));
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer player = (ProxiedPlayer) sender;

        TextComponent system = new TextComponent("");
        system.setText(cg.getString("Prefix") + cg.getString("SocialMessages.two"));
        system.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, cg.getString("SocialURLs.two")));
        system.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§8• §bClick to Open URL!").create()));

        if (sender != null) {
            player.sendMessage(system);
        }
    }
}
