import java.util.*;

public class TaskServicesImpl {
    private int taskId = 0;
    private final PriorityQueue<Task> pq = new PriorityQueue<>();
    private final Map<Integer, Task> taskMap = new HashMap<>();

    public void addTask(String desc, int priority) {
        Task task = new Task(++taskId, desc, priority);
        pq.offer(task);
        taskMap.put(task.getId(), task);
    }

    public void completeTask(int id) {
        if (taskMap.containsKey(id)) {
            taskMap.get(id).markComplete();
        }
    }

    public void deleteTask(int id) {
        Task task = taskMap.remove(id);
        if (task != null) pq.remove(task);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(pq); // not sorted but viewable
    }
}
