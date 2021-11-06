package dev.deltric.battlepass;

import com.pixelmonmod.pixelmon.Pixelmon;
import dev.deltric.battlepass.impl.listener.PixelmonListener;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
        modid = "battlepass",
        name = "Battle Pass",
        version = "1.0.0",
        acceptableRemoteVersions = "*"
)
public class BattlePassMod {

    @Mod.EventHandler
    public void onInitialization(FMLInitializationEvent event) {
        Pixelmon.EVENT_BUS.register(new PixelmonListener());
    }

}
