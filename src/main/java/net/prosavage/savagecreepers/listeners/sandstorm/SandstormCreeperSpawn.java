package net.prosavage.savagecreepers.listeners.sandstorm;

import net.prosavage.savagecreepers.Enable;
import net.prosavage.savagecreepers.Storage;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class SandstormCreeperSpawn implements Listener {

    @EventHandler
    public void onCreeperSpawn(EntitySpawnEvent e) {
        Entity entity = e.getEntity();
        if (entity.getType() != EntityType.CREEPER) {
            return;
        }

        Bukkit.getScheduler().scheduleSyncDelayedTask(Enable.pl(), () -> {
            if (entity.getCustomName() == null
                    || !Enable.pl().color(Storage.SandstormConfiguration.getString("Item.Name")).equals(entity.getCustomName())) {
                return;
            }
            ConfigurationSection configuration = Storage.SandstormConfiguration;
            Enable.pl().applyNametag(entity, configuration.getString("Nametag.Format"), configuration.getBoolean("Nametag.Visible"));
        }, 3L);


    }

}
