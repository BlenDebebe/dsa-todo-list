public class ToDoListApplication {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        // Adds tasks to the ToDoList
        Task task1 = new Task("Workout", "Squat, Pushup, Situp");
        Task task2 = new Task("Study", "Read 'Data Structures'");
        Task task3 = new Task("What mom said to do", "Clean the house, Cook dinner and Make coffee");
        Task task4 = new Task("Watch videos", "How the CHATGPT4.0 communicate with each other");

        toDoList.addToDo(task1);
        toDoList.addToDo(task2);
        toDoList.addToDo(task3);
        toDoList.addToDo(task4);

        // View the initial To-Do List
        System.out.println("Initial To-Do List:");
        toDoList.viewToDoList();

        // Mark a task as completed
        toDoList.markToDoAsCompleted("Study");
        toDoList.markToDoAsCompleted("What mom said to do");
        toDoList.markToDoAsCompleted("Workout");
        toDoList.markToDoAsCompleted("Submit Assignment");

        // To add new task to the list
        Task task5 = new Task("Submit Assignment", "Data center report, DSA individual group and assignment");
        toDoList.addToDo(task5);

        // Displaying updated To-Do List
        System.out.println("\nUpdated To-Do List:");
        toDoList.viewToDoList();

        // View the final To-Do List
        System.out.println("\nFinal To-Do List:");
        toDoList.viewToDoList();
    }
}

class Task {
    private String title;
    private String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {

        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class ToDoList {
    private Node head;

    public ToDoList() {
        this.head = null;
    }

    public void addToDo(Task task) {
        Node newNode = new Node(task);
        // Checks whether the list is empty or not and adds the new task to the list
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void markToDoAsCompleted(String title) {
        Node current = head;
        // Checks whether is done or not and sets the next task as current task
        while (current != null) {
            if (current.task.getTitle().equals(title)) {
                current.task.markCompleted();
                return;
            }
            current = current.next;

        }
    }

    public void viewToDoList() {
        Node current = head;
        System.out.println("Tasks to be completed:");
        // Shows the incomplete task and describes them as not done
        while (current != null) {
            Task task = current.task;
            if (!task.isCompleted()) {
                System.out.println(
                        "Title: " + task.getTitle() + ", Description: " + task.getDescription()
                                + ", Completed: Not Done");
            }
            current = current.next;
        }
        // Shows the completed tasks separately
        current = head;
        System.out.println("\nCompleted tasks:");
        while (current != null) {
            Task task = current.task;
            if (task.isCompleted()) {
                System.out.println(
                        "Title: " + task.getTitle() + ", Description: " + task.getDescription() + ", Completed: Done");
            }
            current = current.next;
        }
    }

}