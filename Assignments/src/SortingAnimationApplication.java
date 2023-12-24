import javax.swing.JFrame;
import java.awt.GridLayout;

public class SortingAnimationApplication extends JFrame
{
    private SortPanel leftPanel;
    private SortPanel rightPanel;

    public SortingAnimationApplication()
    {
        super("Sorting Animation");
        setLayout(new GridLayout(1, 2));

        leftPanel = new SortPanel();
        rightPanel = new SortPanel();

        add(leftPanel);
        add(rightPanel);
    }

    public static void main(String[] args)
    {
        SortingAnimationApplication sortingApp = new SortingAnimationApplication();
        sortingApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sortingApp.setSize(900, 500);
        sortingApp.setVisible(true);
    }
}
