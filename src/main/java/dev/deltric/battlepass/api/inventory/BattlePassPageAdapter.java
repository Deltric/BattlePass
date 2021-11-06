package dev.deltric.battlepass.api.inventory;

import ca.landonjw.gooeylibs2.api.page.Page;
import dev.deltric.battlepass.api.data.BattlePassData;
import net.minecraft.entity.player.EntityPlayerMP;

public interface BattlePassPageAdapter {

    /**
     * Creates the battle pass inventory for the player
     * @param data - players battle pass data
     * @param player - player
     * @return inventory for the battle pass
     */
    Page create(BattlePassData data, EntityPlayerMP player);

}
