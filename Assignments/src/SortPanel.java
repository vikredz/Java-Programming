import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

public class SortPanel extends JPanel
{
    private JButton populateArray;
    private JButton startSort;
    private JComboBox<String> sortAlgorithm;
    private SortAnimationPanel animationPanel;
    private static final String[] names = {"Heap Sort", "Quick Sort", "Merge Sort"};
    private int[] array;
    private String selection;
    private static final int width = 500;
    private static final int height = 500;
    private Thread t;

    public SortPanel()
    {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(width, height));

        populateArray = new JButton("Populate Array");
        populateArray.setPreferredSize(new Dimension(150, 30));

        startSort = new JButton("Sort");
        startSort.setPreferredSize(new Dimension(150, 30));

        sortAlgorithm = new JComboBox<String>(names);
        sortAlgorithm.setPreferredSize(new Dimension(150, 30));

        animationPanel = new SortAnimationPanel();
        animationPanel.setPreferredSize(new Dimension(width, 400));

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.ipady = 400;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        add(animationPanel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.ipady = 0;
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 0;
        c.gridy = 1;
        add(populateArray, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(10, 10, 0, 10);
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 1;
        c.gridy = 1;
        add(startSort, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 2;
        c.gridy = 1;
        add(sortAlgorithm, c);

        startSort.setEnabled(false);

        populateArray.addActionListener(e -> {
            array = new int[getSize().width-1];
            for(int i = 0; i < array.length; i++)
            {
                Random random = new Random();
                array[i] = random.nextInt((getSize().height)-1);
            }
            animationPanel.repaint();
            populateArray.setEnabled(false);
            startSort.setEnabled(true);
        });

        sortAlgorithm.addActionListener(e -> {
            JComboBox combo = (JComboBox)e.getSource();
            String selectedString = (String)combo.getSelectedItem();
            selection = selectedString;

            startSort.addActionListener(event -> {
                startSort.setEnabled(false);
                t = new Thread(animationPanel);
                t.start();
                populateArray.setEnabled(true);
            });
        });
    }
    class SortAnimationPanel extends JPanel implements Runnable
    {
        private static final int BAR_WIDTH = 5;
        private static final int margin = 1;
        private int speed = 1;
        private int number = 0;
        private final int[] values;
        private final Color[] colorIndexes;

        public SortAnimationPanel()
        {
            values = new int[getSize().width/BAR_WIDTH];
            colorIndexes = new Color[values.length];
            populateArray();
        }

        private void populateArray()
        {
            Random rand = new Random();
            for(int i = 0; i < values.length; i++)
            {
                values[i] = rand.nextInt(getSize().height);
                colorIndexes[i] = Color.BLUE;
            }
            number = values.length;
        }

        private void resetColors()
        {
            for(int i = 0; i < colorIndexes.length; i++)
            {
                colorIndexes[i] = Color.BLUE;
            }
        }

        private void swap(int first, int second)
        {
            int temp = values[first];
            values[first] = values[second];
            values[second] = temp;
        }

        private void repaintAndSleep(int first, int second)
        {
            colorIndexes[first] = Color.GREEN;
            colorIndexes[second] = Color.RED;
            repaint();
            try
            {
                Thread.sleep(speed);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, getWidth(), getHeight());
            for(int i = 0; i < number; i++)
            {
                g2.setColor(colorIndexes[i]);
                g2.fillRect(i*BAR_WIDTH, getHeight() - values[i], BAR_WIDTH, values[i]);
            }
        }

        public void run()
        {
            resetColors();

            if(selection.equals("Quick Sort"))
            {
                quickSort(0, number - 1);
            }
            else if(selection.equals("Heap Sort"))
            {
                heapSort();
            }
            else if(selection.equals("Merge Sort"))
            {
                mergeSort(0, number - 1);
            }
            resetColors();
        }

        public void quickSort(int low, int high) {
            if (low < high) {
                int pi = partition(low, high);

                // Animate after partitioning
                SwingUtilities.invokeLater(() -> repaint());
                try {
                    Thread.sleep(50);  // Adjust delay as needed
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                quickSort(low, pi-1);
                quickSort(pi+1, high);
            }
        }

        private int partition(int low, int high) {
            int pivot = values[high];
            int i = (low - 1); // index of smaller element
            for (int j = low; j < high; j++) {
                if (values[j] < pivot) {
                    i++;

                    int temp = values[i];
                    values[i] = values[j];
                    values[j] = temp;
                }
            }

            int temp = values[i+1];
            values[i+1] = values[high];
            values[high] = temp;

            return i+1;
        }

        public void heapSort() {
            int n = values.length;

            // Build heap
            for (int i = n / 2 - 1; i >= 0; i--)
                heapify(n, i);

            // One by one extract an element from heap
            for (int i=n-1; i>=0; i--) {
                int temp = values[0];
                values[0] = values[i];
                values[i] = temp;

                heapify(i, 0);
            }
        }

        void heapify(int n, int i) {
            int largest = i;  // Initialize largest as root
            int left = 2*i + 1;  // left = 2*i + 1
            int right = 2*i + 2;  // right = 2*i + 2

            // If left child is larger than root
            if (left < n && values[left] > values[largest])
                largest = left;

            // If right child is larger than largest so far
            if (right < n && values[right] > values[largest])
                largest = right;

            // If largest is not root
            if (largest != i) {
                int swap = values[i];
                values[i] = values[largest];
                values[largest] = swap;

                // Recursively heapify the affected sub-tree
                heapify(n, largest);
            }
        }

        void mergeSort(int left, int right) {
            if (left < right) {
                // Find the middle point
                int mid = (left+right)/2;

                // Sort first and second halves
                mergeSort(left, mid);
                mergeSort(mid+1, right);

                // Merge the sorted halves
                merge(left, mid, right);
            }
        }

        void merge(int left, int mid, int right) {
            // Find sizes of two subarrays to be merged
            int n1 = mid - left + 1;
            int n2 = right - mid;

            /* Create temp arrays */
            int leftArr[] = new int [n1];
            int rightArr[] = new int [n2];

            /*Copy data to temp arrays*/
            for (int i=0; i<n1; ++i)
                leftArr[i] = values[left + i];
            for (int j=0; j<n2; ++j)
                rightArr[j] = values[mid + 1+ j];


            /* Merge the temp arrays */

            // Initial indexes of first and second subarrays
            int i = 0, j = 0;

            // Initial index of merged subarry array
            int k = left;
            while (i < n1 && j < n2) {
                if (leftArr[i] <= rightArr[j]) {
                    values[k] = leftArr[i];
                    i++;
                } else {
                    values[k] = rightArr[j];
                    j++;
                }
                k++;
            }

            /* Copy remaining elements of leftArr[] if any */
            while (i < n1) {
                values[k] = leftArr[i];
                i++;
                k++;
            }

            /* Copy remaining elements of rightArr[] if any */
            while (j < n2) {
                values[k] = rightArr[j];
                j++;
                k++;
            }
        }
    }

}
