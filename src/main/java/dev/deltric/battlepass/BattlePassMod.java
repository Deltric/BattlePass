package dev.deltric.battlepass;

import com.pixelmonmod.pixelmon.Pixelmon;
import dev.deltric.battlepass.config.BattlePassConfig;
import dev.deltric.battlepass.impl.listener.PixelmonListener;
import dev.deltric.battlepass.util.GConfig;
import dev.deltric.battlepass.util.ServerMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
        modid = "battlepass",
        name = "Battle Pass",
        version = "1.0.0",
        acceptableRemoteVersions = "*"
)
public class BattlePassMod extends ServerMod {

    private static BattlePassMod instance;
    private BattlePassConfig config;

    @Mod.EventHandler
    public void onInitialization(FMLInitializationEvent event) {
        instance = this;

        // Config
        this.config = GConfig.load(this, "battlepass", BattlePassConfig.class);

        // Listeners
        Pixelmon.EVENT_BUS.register(new PixelmonListener());

        this.getLogger().info("Finished loading {} version {}", this.getName(), this.getVersion());
    }

    @Override
    public String getId() {
        return "battlepass";
    }

    @Override
    public String getName() {
        return "Battle Pass";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    /**
     * Main battle pass config
     * @return main config instance
     */
    public BattlePassConfig getConfig() {
        return config;
    }

    /**
     * Gets the main instance for the mod
     * @return main instance
     */
    public static BattlePassMod getInstance() {
        return instance;
    }
}
