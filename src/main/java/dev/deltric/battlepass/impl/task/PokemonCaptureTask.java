package dev.deltric.battlepass.impl.task;

import com.pixelmonmod.pixelmon.api.events.CaptureEvent;
import dev.deltric.battlepass.api.task.Task;
import dev.deltric.battlepass.api.task.TaskKeys;

public class PokemonCaptureTask implements Task<CaptureEvent.SuccessfulCapture> {

    @Override
    public String getId() {
        return TaskKeys.CAPTURE_POKEMON;
    }

    @Override
    public Class<CaptureEvent.SuccessfulCapture> getEventClass() {
        return CaptureEvent.SuccessfulCapture.class;
    }

    @Override
    public void processEvent(CaptureEvent.SuccessfulCapture event) {

    }

}
