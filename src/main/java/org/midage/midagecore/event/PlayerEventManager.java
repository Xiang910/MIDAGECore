package org.midage.midagecore.event;

import org.allaymc.api.block.dto.Block;
import org.allaymc.api.entity.interfaces.EntityPlayer;
import org.allaymc.api.eventbus.EventHandler;
import org.allaymc.api.eventbus.event.entity.EntityDamageEvent;
import org.allaymc.api.eventbus.event.player.PlayerInteractBlockEvent;
import org.allaymc.api.eventbus.event.player.PlayerJoinEvent;
import org.allaymc.api.eventbus.event.player.PlayerLoginEvent;
import org.allaymc.api.eventbus.event.player.PlayerQuitEvent;
import org.allaymc.papi.PlaceholderAPI;
import org.midage.midagecore.Loader;

public class PlayerEventManager {

    // TODO: 做一个分类，用于lobby处理的world，给与Lobby 的TAG

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        EntityPlayer player = event.getPlayer();
        String playerName = player.getDisplayName();

    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        EntityPlayer player = event.getPlayer();
        String playerName = player.getDisplayName();
        String raw = Loader.INSTANCE.CONFIG.pem().joined();
        String joinMessage = PlaceholderAPI.getAPI().setPlaceholders(player, raw);

        event.setJoinMessage(joinMessage);
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        EntityPlayer player = event.getPlayer();
        String playerName = player.getDisplayName();

        String raw = Loader.INSTANCE.CONFIG.pem().leaving();
        String leaveMessage = PlaceholderAPI.getAPI().setPlaceholders(player, raw);

        event.setQuitMessage(leaveMessage);
    }

    @EventHandler
    public void onPlayerHurting(EntityDamageEvent event) {
        EntityPlayer player = event.getEntity().asPlayer();

        //todo : 同样，根据玩家给予Lobby tag，或in game还是什么

        if (event.getEntity() instanceof EntityPlayer) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteractItem(PlayerInteractBlockEvent event){
        EntityPlayer player = event.getPlayer();
        Block block = event.getInteractInfo().getClickedBlock();

        if (event.getAction().equals(PlayerInteractBlockEvent.Action.RIGHT_CLICK)) {
            //if (block.getBlock)
        }

    }


}
