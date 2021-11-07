package dev.deltric.battlepass.impl.progression;

import dev.deltric.battlepass.BattlePassMod;
import dev.deltric.battlepass.api.progression.ExperienceHandler;
import net.minecraft.nbt.NBTTagCompound;

public class SetProgressionHandler implements ExperienceHandler {

    private int totalExperience;

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        this.totalExperience = compound.getInteger("BPTotalExperience");
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        compound.setInteger("BPTotalExperience", totalExperience);
    }

    @Override
    public int getTier() {
        if(totalExperience == 0) {
            return 0;
        }
        int experiencePerTier = BattlePassMod.getInstance().getConfig().experiencePerTier;
        return Math.floorDiv(totalExperience, experiencePerTier);
    }

    @Override
    public int getExperience() {
        return totalExperience;
    }

    @Override
    public void setTier(int tier) {
        int experiencePerTier = BattlePassMod.getInstance().getConfig().experiencePerTier;
        this.totalExperience = experiencePerTier * tier;
    }

    @Override
    public void addExperience(int experience) {

    }

}
