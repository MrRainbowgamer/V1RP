package de.rainbow.shops;

import com.mysql.jdbc.Buffer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Event_AktivateVillager {

    public static void activate(Plugin p) {
        Bukkit.getPluginManager().registerEvents(new Shop_Schmied(), p);
        Bukkit.getPluginManager().registerEvents(new Shop_Steinmetz(), p);
        Bukkit.getPluginManager().registerEvents(new Shop_Jaeger(), p);
        Bukkit.getPluginManager().registerEvents(new Shop_Holzfaeller(), p);
    }
}
