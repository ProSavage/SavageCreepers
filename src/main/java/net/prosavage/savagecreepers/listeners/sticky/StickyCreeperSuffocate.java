package net.prosavage.savagecreepers.listeners.sticky;

import net.prosavage.savagecreepers.Enable;
import net.prosavage.savagecreepers.Storage;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class StickyCreeperSuffocate implements Listener {

    @EventHandler
    public void onStickySuffocate(EntityDamageEvent e) {


        if (e.getCause() != EntityDamageEvent.DamageCause.SUFFOCATION
                || e.getEntityType() != EntityType.CREEPER) {
            return;
        }
        Entity entity = e.getEntity();


        if (entity.getCustomName() == null
                || !Enable.pl().color(Storage.StickyConfiguration.getString("Nametag.Format")).equals(entity.getCustomName())) {
            return;
        }


        e.setCancelled(true);


    }


}
