import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ToDoSwingApp {
    private JFrame frame;
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField inputField;
    private java.util.List<String> tasks = new ArrayList<>();

    public ToDoSwingApp() {
        frame = new JFrame("To-Do List");
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        inputField = new JTextField();

        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Selected");
        JButton clearButton = new JButton("Clear All");

        addButton.addActionListener(e -> {
            String task = inputField.getText().trim();
            if (!task.isEmpty()) {
                tasks.add(task);
                listModel.addElement(task);
                inputField.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            int selected = taskList.getSelectedIndex();
            if (selected != -1) {
                tasks.remove(selected);
                listModel.remove(selected);
            }
        });

        clearButton.addActionListener(e -> {
            tasks.clear();
            listModel.clear();
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(deleteButton);
        bottomPanel.add(clearButton);

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoSwingApp::new);
    }
}
