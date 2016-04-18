package sortassignment;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public abstract class AbstractSortComponent extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	private int[] input;

	public void setInput(int[] input) {
		this.input = input;
	}

	public int[] getInput() {
		return this.input;
	}
	
	/* Modified different colors for different data set*/
	
	public void paintComponent(Graphics g) {

		int height = getHeight();

		Graphics2D g2 = (Graphics2D) g;
		Insets insets = getInsets();

		int h = height - insets.top - insets.bottom;

		AffineTransform oldAT = g2.getTransform();
		g2.scale(1.0, -1.0);
		g2.translate(0, -h);

		super.paintComponent(g);

		for (int i = 0; i < input.length; i++) {
			g.setColor(Color.magenta);
			g.fill3DRect(i * 5, 0, 5, input[i] / 5, true);

			g.setColor(Color.blue);
			g.draw3DRect(i * 5, 0, 5, input[i] / 5, true);
		}

	}

	@Override
	public void run() {
		try {
			sort(getInput());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();
	}

	abstract void sort(int[] input) throws InterruptedException;

	abstract String sortName();
}
