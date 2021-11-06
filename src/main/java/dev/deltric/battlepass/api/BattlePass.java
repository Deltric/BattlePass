package dev.deltric.battlepass.api;

import dev.deltric.battlepass.api.inventory.BattlePassPageAdapter;
import net.minecraft.entity.player.EntityPlayerMP;

import java.time.LocalDateTime;

public interface BattlePass {

    /**
     * Gets the id of this battle pass
     * @return battle pass id
     */
    String getId();

    /**
     * Gets the name of this battle pass
     * @return battle pass name
     */
    String getName();

    /**
     * Is this battle pass always running
     * @return true if it doesn't expire
     */
    boolean isAlwaysActive();

    /**
     * The expiration date of this battle pass
     * @return null if it doesn't expire, otherwise expiration date time
     */
    LocalDateTime getExpiration();

    /**
     * Gets the inventory page adapter for this battle pass
     * @return the battle pass inventory page adapter
     */
    BattlePassPageAdapter getPageAdapter();

    /**
     * Is the premium track enabled
     * @return premium track enabled
     */
    boolean isPremiumTrackEnabled();

    /**
     * Checks if a player has access to the premium track
     * @param player - player to check
     * @return true if they can access the premium track, otherwise false
     */
    boolean hasPremiumTrack(EntityPlayerMP player);

}
