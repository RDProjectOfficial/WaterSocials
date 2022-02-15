package com.rdproject.watersocials.commands;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.plugin.*;

import static com.rdproject.watersocials.WaterSocials.*;

@SuppressWarnings("ALL")
public class SocialsCommand extends Command {

    public SocialsCommand() {
        super("socials", cg.getString("Permissions.socials"), cg.getString("SocialAliases.socials"));
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer player = (ProxiedPlayer) sender;

        TextComponent one = new TextComponent("");
        one.setText(cg.getString("SocialsCommandDesign") + cg.getString("SocialMessages.one"));
        one.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, cg.getString("SocialURLs.one")));
        one.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§8• §bClick to Open URL!").create()));

        TextComponent four = new TextComponent("");
        four.setText(cg.getString("SocialsCommandDesign") + cg.getString("SocialMessages.four"));
        four.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, cg.getString("SocialURLs.four")));
        four.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§8• §bClick to Open URL!").create()));

        TextComponent three = new TextComponent("");
        three.setText(cg.getString("SocialsCommandDesign") + cg.getString("SocialMessages.three"));
        three.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, cg.getString("SocialURLs.three")));
        three.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§8• §bClick to Open URL!").create()));

        TextComponent five = new TextComponent("");
        five.setText(cg.getString("SocialsCommandDesign") + cg.getString("SocialMessages.five"));
        five.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, cg.getString("SocialURLs.five")));
        five.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§8• §bClick to Open URL!").create()));

        TextComponent two = new TextComponent("");
        two.setText(cg.getString("SocialsCommandDesign") + cg.getString("SocialMessages.two"));
        two.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, cg.getString("SocialURLs.two")));
        two.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§8• §bClick to Open URL!").create()));

        if (sender != null) {
            player.sendMessage(cg.getString("SocialsCommandTitle"));
            player.sendMessage("");
            player.sendMessage(one);
            player.sendMessage(two);
            player.sendMessage(three);
            player.sendMessage(four);
            player.sendMessage(five);
            player.sendMessage("");
        }
    }
}