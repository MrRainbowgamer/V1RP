package de.rainbow.chunk.cmd;

import de.rainbow.chunk.api.City;
import de.rainbow.main.Roleplay;
import de.rainbow.manager.SkyPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Debug implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player p = (Player) commandSender;
        SkyPlayer cp = Roleplay.getOnlinePlayer(p.getUniqueId());

        p.sendMessage("" + cp + " " + Roleplay.getCityAtChunk(p.getLocation().getChunk()));

        return false;
    }
}
