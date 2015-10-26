package velociraptor;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panel extends JPanel {
	private Double posX = -50.0;
	private Double posY = -50.0;
	private int multiplier = 5;
	private ArrayList<Predator> predators;
	
	public Panel(ArrayList<Predator> predators){
		this.predators = predators;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.red);
		g.fillOval(multiplier*(posX.intValue()), multiplier*(posY.intValue()), 10, 10);
		g.setColor(Color.green);
		for(Predator pred: predators){
			g.fillOval(multiplier*(pred.xPos.intValue()), multiplier*(pred.yPos.intValue()), 10, 10);
		}
	}

	public Double getPosX() {
		return posX;
	}

	public void setPosX(Double posX) {
		this.posX = posX;
	}

	public Double getPosY() {
		return posY;
	}

	public void setPosY(Double posY) {
		this.posY = posY;
	}
}
