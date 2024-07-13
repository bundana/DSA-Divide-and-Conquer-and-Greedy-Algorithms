import algorithms.divideandconquer.MergeSort;
import algorithms.divideandconquer.QuickSort;
import algorithms.greedy.PrimMST;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private final JTextArea outputArea;
    private final JTextField inputField;
    private final JComboBox<String> algorithmSelector;

    public MainFrame() {
        setTitle("Algorithm Comparison Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu helpMenu = new JMenu("Help");
        JMenuItem howToUseItem = new JMenuItem("How to Use");
        howToUseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHelpDialog();
            }
        });
        helpMenu.add(howToUseItem);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        // Create components
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setMargin(new Insets(10, 10, 10, 10));
        inputField = new JTextField();
        algorithmSelector = new JComboBox<>(new String[]{"QuickSort", "MergeSort", "Prim's MST"});
        JButton runButton = new JButton("Run");
        runButton.setFont(new Font("Arial", Font.BOLD, 14));
        runButton.setBackground(new Color(0, 122, 204));
        runButton.setForeground(Color.WHITE);

        // Set up layout
        JPanel topPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.add(new JLabel("Select Algorithm:", JLabel.CENTER));
        topPanel.add(algorithmSelector);
        topPanel.add(new JLabel("Input Data (comma-separated):", JLabel.CENTER));
        topPanel.add(inputField);
        topPanel.add(runButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Add button listener
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runSelectedAlgorithm();
            }
        });
    }

    private void runSelectedAlgorithm() {
        String selectedAlgorithm = (String) algorithmSelector.getSelectedItem();
        String inputData = inputField.getText();

        if (selectedAlgorithm != null) {
            long startTime = System.nanoTime();
            switch (selectedAlgorithm) {
                case "QuickSort":
                    runQuickSort(inputData);
                    break;
                case "MergeSort":
                    runMergeSort(inputData);
                    break;
                case "Prim's MST":
                    runPrimMST(inputData);
                    break;
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // in milliseconds
            outputArea.append("\n\nTime taken: " + duration + " ms");
        }
    }

    private void runQuickSort(String inputData) {
        int[] arr = parseInputData(inputData);
        if (arr != null) {
            QuickSort quickSort = new QuickSort();
            quickSort.sort(arr);
            outputArea.setText("Sorted array:\n" + formatArray(arr));
            displayTimeComplexity("QuickSort");
        }
    }

    private void runMergeSort(String inputData) {
        int[] arr = parseInputData(inputData);
        if (arr != null) {
            MergeSort mergeSort = new MergeSort();
            mergeSort.sort(arr);
            outputArea.setText("Sorted array:\n" + formatArray(arr));
            displayTimeComplexity("MergeSort");
        }
    }

    private void runPrimMST(String inputData) {
        int[][] graph = parseGraphData(inputData);
        if (graph != null) {
            PrimMST primMST = new PrimMST();
            String result = primMST.primMST(graph);
            outputArea.setText(result);
            displayTimeComplexity("Prim's MST");
        }
    }

    private void displayTimeComplexity(String algorithm) {
        String complexity = switch (algorithm) {
            case "QuickSort" -> "Time Complexity: O(n log n) on average, O(n^2) in the worst case.";
            case "MergeSort" -> "Time Complexity: O(n log n) in all cases.";
            case "Prim's MST" -> "Time Complexity: O(V^2) for the adjacency matrix representation.";
            default -> "";
        };
        outputArea.append("\n" + complexity);
    }

    private int[] parseInputData(String inputData) {
        try {
            String[] tokens = inputData.split(",");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i].trim());
            }
            return arr;
        } catch (NumberFormatException e) {
            outputArea.setText("Invalid input format. Please enter comma-separated integers.");
            return null;
        }
    }

    private int[][] parseGraphData(String inputData) {
        try {
            String[] rows = inputData.split(";");
            int n = rows.length;
            int[][] graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] cols = rows[i].split(",");
                for (int j = 0; j < cols.length; j++) {
                    graph[i][j] = Integer.parseInt(cols[j].trim());
                }
            }
            return graph;
        } catch (NumberFormatException e) {
            outputArea.setText("Invalid input format. Please enter a semicolon-separated matrix of comma-separated integers.");
            return null;
        }
    }

    private String formatArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int value : arr) {
            sb.append(value).append(" ");
        }
        return sb.toString().trim();
    }

    private void showHelpDialog() {
        JOptionPane.showMessageDialog(this,
                "How to Use the Application:\n\n" +
                        "1. Select an algorithm from the dropdown menu.\n" +
                        "2. Enter the relevant data in the input field:\n" +
                        "   - For sorting algorithms, provide a comma-separated list of integers.\n" +
                        "   - For Prim's MST, provide a semicolon-separated matrix of comma-separated integers.\n" +
                        "3. Click the 'Run' button to execute the selected algorithm.\n" +
                        "4. View the results in the text area below.",
                "How to Use", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
