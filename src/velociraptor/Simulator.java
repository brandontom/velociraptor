package velociraptor;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Simulator {
	Prey prey;
	Double timeStep;
	private double timeLeft;
	JFrame frame;
	Panel pan;
	ArrayList<Predator> predators;
	private boolean showGraphics;

	public Simulator(Double timeStep, ArrayList<Predator> predators, Prey prey, boolean showGraphics) {
		this.prey = prey;
		this.timeStep = timeStep;
		this.timeLeft = 15;
		this.predators = predators;
		this.showGraphics = showGraphics;
		if(showGraphics){
			frame = new JFrame();
			pan = new Panel(predators);
			frame.setContentPane(pan);
			frame.setSize(1000, 1000);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
	}

	public Result simulate() {
		while (!chaseIsOver()) {
			prey.move(predators);
			for(Predator pred : predators){
				pred.move(prey,timeLeft);
			}
			timeLeft -= timeStep;
		    if(showGraphics){
	//			System.out.println(prey.xPos + " " + prey.yPos);
	//			System.out.println(predator.xPos + " " + predator.yPos);
	//			System.out.println();
			    pan.setPosX(prey.xPos);
			    pan.setPosY(prey.yPos);
				refreshWindow();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    }
		}
		// formulate result.
		Result result = new Result();
		result.predatorSuccess = true;
		if(timeLeft < 1){
			result.predatorSuccess = false;
		}
		return result;
	}

	private void refreshWindow() {
		frame.repaint();
	}

	private boolean chaseIsOver() {
		for(Predator pred : predators){
			if(Predator.distanceFormula(prey.xPos, prey.yPos, pred.xPos, pred.yPos) < Main.killRadius){
				return true;
			}
		}
		if(timeLeft < 0){
			return true;
		}
		return false;
	}

}
