package dev.deltric.battlepass.api.task;

import net.minecraftforge.fml.common.eventhandler.Event;

public interface Task<T extends Event> {

    /**
     * Gets the task id
     * @return task id
     */
    String getId();

    /**
     * Gets the event class for this task
     * @return task event class
     */
    Class<T> getEventClass();

    /**
     * Processes a forge event
     * @param event - event to process
     */
    void processEvent(T event);

}
