package view;

import controller.AStarAlgorithm;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;

/**
 * Created by Han on 2016-11-14.
 */
public class AStarPanel extends Panel {
	private AStarAlgorithm algorithm;

	public AStarPanel(MouseAdapter mouseListener) {
		super(mouseListener);
		algorithm = new AStarAlgorithm();
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(20, 20, 20, 20));
	}

	@Override
	public void setStartNode(int x, int y) {
		algorithm.setStart(x, y);
	}

	@Override
	public void setEndNode(int x, int y) {
		algorithm.setEnd(x, y);
	}

	@Override
	public void setObstacleNode(int x, int y) {
		algorithm.setObstacle(x, y);
	}

	@Override
	public void start() {
		algorithm.start();
		repaint();
	}

	@Override
	public void next() {
		if (algorithm.next()) System.out.println("FINISH");
		repaint();
	}

	@Override
	public void clear() {
		algorithm.clear();
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		algorithm.getMap().draw(g);
	}
}
