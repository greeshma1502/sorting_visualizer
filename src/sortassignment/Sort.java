package sortassignment;

import java.awt.*;

public interface Sort {
    public void sort(int[] input) throws InterruptedException;

    public String sortName();

    public void run();

    public void setInput(int[] input);

    public int[] getInput();

    public void paintComponent(Graphics g);
}
