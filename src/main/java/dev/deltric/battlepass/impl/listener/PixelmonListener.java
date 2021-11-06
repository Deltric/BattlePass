package dev.deltric.battlepass.impl.listener;

import com.pixelmonmod.pixelmon.api.events.CaptureEvent;
import dev.deltric.battlepass.api.task.TaskKeys;
import dev.deltric.battlepass.api.task.TaskManager;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PixelmonListener {

    @SubscribeEvent
    public void onPokemonCapture(CaptureEvent.SuccessfulCapture event) {
        TaskManager.getInstance().processEvent(TaskKeys.CAPTURE_POKEMON, event);
    }

}
