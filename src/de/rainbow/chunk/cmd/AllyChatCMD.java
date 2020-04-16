package de.rainbow.chunk.cmd;

import de.rainbow.chunk.api.City;
import de.rainbow.chunk.api.CityRang;
import de.rainbow.main.Roleplay;
import de.rainbow.manager.SkyPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AllyChatCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String lable, String[] args) {
        Player p = (Player) commandSender; 
        SkyPlayer cp = Roleplay.getOnlinePlayer(p.getUniqueId());
       // p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_SWORD).setName("§6Whitwengruß").setLore("Test1, Test2").build());

        if(cp.hasCity() == false) {
            p.sendMessage(Roleplay.PREFIX + "§cDu bist in keiner Stadt!");
            return true;
        }
        StringBuilder sb = new StringBuilder("§8[§dAllyChat§8] §d");
        sb.append(cp.getCity().getAlias());
        if(cp.getCityrang() == CityRang.MAJOR) {
            sb.append("-M");
        } else if(cp.getCityrang() == CityRang.STAFF) {
            sb.append("-S");
        }
        sb.append("§6 ").append(p.getName()).append("§7 § ");
        for(String s : args) {
            sb.append(s).append(' ');
        }
        String message = sb.toString();
        cp.getCity().broadcast(message);
        for(City c : cp.getCity().getAllies()) {
            c.broadcast(message);
        }
        return false;
    }
}
