package dev.deltric.battlepass.api.data;

import dev.deltric.battlepass.api.progression.ExperienceHandler;
import net.minecraft.nbt.NBTTagCompound;

public abstract class BattlePassData {

    private ExperienceHandler experienceHandler;

    public BattlePassData(ExperienceHandler experienceHandler) {
        this.experienceHandler = experienceHandler;
    }

    /**
     * Reads data from NBT
     * @param compound - nbt compound to read from
     */
    public abstract void readFromNBT(NBTTagCompound compound);

    /**
     * Writes data to NBT
     * @param compound - nbt compound to write to
     */
    public abstract void writeToNBT(NBTTagCompound compound);

    /**
     * Gets the experience handler for this data
     * @return experience handler instance
     */
    public ExperienceHandler getExperienceHandler() {
        return experienceHandler;
    }

    /**
     * Has the player claimed rewards for this tier
     * @param tier - tier to check claim
     * @return true if reward is already claimed, otherwise false
     */
    public abstract boolean hasClaimed(int tier);

    /**
     * Claims the reward(s) for this tier
     * @param tier - tier to claim
     */
    public abstract void claimReward(int tier);

    /**
     * Resets all battle data to defaults
     */
    public abstract void reset();

}
