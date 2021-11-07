package dev.deltric.battlepass.api.progression;

import net.minecraft.nbt.NBTTagCompound;

public interface ExperienceHandler {

    /**
     * Gets the battle pass tier
     * @return current battle pass tier
     */
    int getTier();

    /**
     * Gets the total battle pass experience
     * @return
     */
    int getExperience();

    /**
     * Sets the battle pass tier
     * @param tier - new tier
     */
    void setTier(int tier);

    /**
     * Adds battle pass experience
     * @param experience - amount of exp
     */
    void addExperience(int experience);

    /**
     * Reads data from NBT
     * @param compound - nbt compound to read from
     */
    void readFromNBT(NBTTagCompound compound);

    /**
     * Writes data to NBT
     * @param compound - nbt compound to write to
     */
    void writeToNBT(NBTTagCompound compound);

}
