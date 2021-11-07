package dev.deltric.battlepass.impl;

import dev.deltric.battlepass.api.BattlePass;
import dev.deltric.battlepass.api.inventory.BattlePassPageAdapter;
import net.minecraft.entity.player.EntityPlayerMP;

import java.time.LocalDateTime;

public class ConfigBattlePass implements BattlePass {

    private String id;
    private String name;
    private boolean alwaysActive;
    private boolean enablePremiumTrack;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isAlwaysActive() {
        return alwaysActive;
    }

    @Override
    public LocalDateTime getExpiration() {
        return null;
    }

    @Override
    public BattlePassPageAdapter getPageAdapter() {
        return null;
    }

    @Override
    public boolean isPremiumTrackEnabled() {
        return enablePremiumTrack;
    }

    @Override
    public boolean hasPremiumTrack(EntityPlayerMP player) {
        return false;
    }

}
