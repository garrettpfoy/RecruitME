package org.edgegamers.picklez.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.edgegamers.picklez.Storage.RecruitMEPlayerCache;

public class onPlayerLogin implements Listener {

    @EventHandler
    public void onPlayerLogin(PlayerJoinEvent event) {
        //Load a player's playerCache into the system :)
        RecruitMEPlayerCache cache = RecruitMEPlayerCache.getCache(event.getPlayer().getUniqueId());
    }
}
