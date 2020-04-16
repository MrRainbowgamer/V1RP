package de.rainbow.chunk.cmd;

import de.rainbow.chunk.api.City;
import de.rainbow.main.Roleplay;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class InfoCommand implements CommandExecutor {


	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String lable, String[] strings) {
		Player p = (Player) commandSender;

		City c = Roleplay.getCityAtChunk(p.getLocation().getChunk());
		if(c == null || c == Roleplay.SPAWN) {
			p.sendMessage(Roleplay.PREFIX + "§cDu befindest dich gerade in keiner Stadt!");
			return true;
		}
		c.sendInfo(p, Roleplay.getOnlinePlayer(p.getUniqueId()).getCity() == c);
		return true;
	}

}
