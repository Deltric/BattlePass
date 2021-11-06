package dev.deltric.battlepass.api.task;

import net.minecraftforge.fml.common.eventhandler.Event;

public interface Task {

    /**
     * Gets the task id
     * @return task id
     */
    String getId();

    /**
     * Processes a forge event
     * @param event - event to process
     */
    void processEvent(Event event);

}
