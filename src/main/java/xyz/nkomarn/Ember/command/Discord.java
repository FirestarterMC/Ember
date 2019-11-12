package xyz.nkomarn.Ember.command;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import xyz.nkomarn.Ember.util.Config;

public class Discord extends Command {

    public Discord() {
        super("discord");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        final String message = Config.getString("discord.message");
        final String link = Config.getString("discord.link");
        final TextComponent textComponent = new TextComponent(ChatColor
                .translateAlternateColorCodes('&', message));
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, link));
        textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.GOLD
                + "Click to use the Discord invite.").create()));
        sender.sendMessage(textComponent);
    }
}