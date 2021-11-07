package dev.deltric.battlepass.impl.data;

import dev.deltric.battlepass.api.data.BattlePassData;
import dev.deltric.battlepass.api.progression.ExperienceHandler;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.logging.log4j.util.Strings;

import java.util.HashSet;
import java.util.Set;

public class BattlePassDataImpl extends BattlePassData {

    private Set<Integer> claimedTiers;

    public BattlePassDataImpl(ExperienceHandler experienceHandler) {
        super(experienceHandler);
        this.claimedTiers = new HashSet<>();
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        this.claimedTiers.clear();

        // Read claimed tiers
        String claimed = compound.getString("BPClaimedTiers");
        if(!claimed.isEmpty()) {
            String[] tiers = claimed.split(",");
            for(String tier : tiers) {
                claimedTiers.add(Integer.parseInt(tier));
            }
        }

        // Read experience
        this.getExperienceHandler().readFromNBT(compound);
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        // Write claimed tiers
        if(!claimedTiers.isEmpty()) {
            String claimed = Strings.join(claimedTiers.iterator(), ',');
            compound.setString("BPClaimedTiers", claimed);
        }

        // Write experience
        this.getExperienceHandler().writeToNBT(compound);
    }

    @Override
    public boolean hasClaimed(int tier) {
        return claimedTiers.contains(tier);
    }

    @Override
    public void claimReward(int tier) {
        this.claimedTiers.add(tier);
    }

    @Override
    public void reset() {
        this.claimedTiers.clear();
        this.getExperienceHandler().setTier(0);
    }
}
