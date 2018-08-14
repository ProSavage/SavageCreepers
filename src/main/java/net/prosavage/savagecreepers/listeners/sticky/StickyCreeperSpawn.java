package net.prosavage.savagecreepers.listeners.sticky;

import net.prosavage.savagecreepers.Enable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class StickyCreeperSpawn implements Listener {

    @EventHandler
    public void onCreeperSpawn(EntitySpawnEvent e) {
        Entity entity = e.getEntity();
        if (entity.getType() != EntityType.CREEPER) {
            return;
        }


        Enable.pl().doStickyCreeperEffect(entity);
    }


}
