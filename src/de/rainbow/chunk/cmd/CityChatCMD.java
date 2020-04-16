package de.rainbow.chunk.cmd;

import de.rainbow.chunk.api.CityRang;
import de.rainbow.main.Roleplay;
import de.rainbow.manager.SkyPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CityChatCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String lable, String[] args) {
        Player p = (Player) commandSender;
        SkyPlayer cp = Roleplay.getOnlinePlayer(p.getUniqueId());
        if(cp.hasCity() == false) {
            p.sendMessage(Roleplay.PREFIX + "§cDu bist in keiner Stadt!");
            return true;
        }
        StringBuilder sb = new StringBuilder("§8[§aCityChat§8] §6");
        if(cp.getCityrang() == CityRang.MAJOR) {
            sb.append("§aM §6");
        } else if(cp.getCityrang() == CityRang.STAFF) {
            sb.append("§aS §6");
        }
        sb.append(p.getName()).append("§7 § ");
        for(String s : args) {
            sb.append(s).append(' ');
        }
        String message = sb.toString();
        cp.getCity().broadcast(message);
        return true;
    }
}
