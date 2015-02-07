import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class SpacePanel extends JPanel{

	//private double scale = SolarSystem.windowSize/70.0;
	private double scale = SolarSystem.windowSize/30.0;
	
	public SpacePanel(){
		setBackground(Color.BLACK);
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.translate((int)(SolarSystem.windowSize/2.0),(int)(SolarSystem.windowSize/2.0));
		for (CelestialBody me : CelestialBody.values()){
			g.setColor(Color.RED);
			g.fillOval((int)(scale*(me.getR().getX()-0.5*me.radius)), (int)(scale*(me.getR().getY()-0.5*me.radius)), (int)(100*scale*me.radius), (int)(100*scale*me.radius));
			g.setColor(Color.GREEN);
			g.drawString(me.toString(), (int)(scale*(me.getR().getX()-0.5*me.radius)), (int)(scale*(me.getR().getY()-0.5*me.radius)));
		}
	}

	public void update(){
		this.repaint();
	}
	
}
