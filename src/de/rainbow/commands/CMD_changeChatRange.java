package de.rainbow.commands;

import de.rainbow.main.Roleplay;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_changeChatRange implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;

            if(Roleplay.crange.get(p) == 1) {
                Roleplay.crange.replace(p, 2);
                p.sendMessage(Roleplay.prefix + "Du hast die Sprachweite auf Normal geändert!");
            } else if(Roleplay.crange.get(p) == 2) {
                Roleplay.crange.replace(p, 3);
                p.sendMessage(Roleplay.prefix + "Du hast die Sprachweite auf Schreien geändert!");
            } else if(Roleplay.crange.get(p) == 3) {
                Roleplay.crange.replace(p, 1);
                p.sendMessage(Roleplay.prefix + "Du hast die Sprachweite auf Flüstern geändert!");
            }
        }
        return false;
    }
}
