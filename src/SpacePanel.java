import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class SpacePanel extends JPanel{

	private double scale = 5e-5;
	
	public SpacePanel(){
		setBackground(Color.BLACK);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (CelestialBody me : CelestialBody.values()){
			g.setColor(Color.RED);
			g.fillOval((int)(scale*(me.getR().getX()-0.5*me.radius)+200), (int)(scale*(me.getR().getY()-0.5*me.radius)+200), (int)me.radius, (int)me.radius);
			g.setColor(Color.GREEN);
			g.drawString(me.toString(), (int)(scale*(me.getR().getX()-0.5*me.radius)+200), (int)(scale*(me.getR().getY()-0.5*me.radius)+200));
		}
	}
	ghfdf
	public void update(){
		this.repaint();
	}
	
}
