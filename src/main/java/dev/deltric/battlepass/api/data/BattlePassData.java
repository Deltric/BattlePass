package dev.deltric.battlepass.api.data;

public interface BattlePassData {

    /**
     * Gets the current battle pass tier
     * @return battle pass tier
     */
    int getTier();

    /**
     * Gets the total collected experience
     * @return collected experience
     */
    int getExperience();

    /**
     * Has the player claimed rewards for this tier
     * @param tier - tier to check claim
     * @return true if reward is already claimed, otherwise false
     */
    boolean hasClaimed(int tier);

    /**
     * Claims the reward(s) for this tier
     * @param tier - tier to claim
     */
    void claimReward(int tier);

}
