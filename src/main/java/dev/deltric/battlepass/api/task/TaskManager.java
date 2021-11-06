package dev.deltric.battlepass.api.task;

import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.HashMap;
import java.util.Optional;

public class TaskManager {

    private static TaskManager instance;
    private HashMap<String, Task> tasks;

    public TaskManager() {
        this.tasks = new HashMap<>();
        // TODO(Deltric): Add defaults to task manager
    }

    /**
     * Registers a new task handler
     * @param task - new task
     */
    public void registerTask(Task task) {
        this.tasks.put(task.getId(), task);
    }

    /**
     * Unregisters a task from the handler
     * @param id - task id
     * @return optional with a task value if found, otherwise empty
     */
    public Optional<Task> unregisterTask(String id) {
        return Optional.ofNullable(this.tasks.remove(id));
    }

    /**
     * Processes a forge event if it's a task event
     * @param id - task id
     * @param event - event to process
     */
    public void processEvent(String id, Event event) {
        // Return if the id is null or empty
        if(id == null || id.isEmpty()) {
            return;
        }

        // Return if the event is null or canceled
        if(event == null || event.isCanceled()) {
            return;
        }

        // If a task is found with that id, process event
        Task task = this.tasks.get(id);
        if(task != null) {
            task.processEvent(event);
        }
    }

    /**
     * Gets or creates a new instance of Task Manager
     * @return task manager instance
     */
    public static TaskManager getInstance() {
        if(instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

}
