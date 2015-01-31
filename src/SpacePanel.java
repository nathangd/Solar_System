import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class SpacePanel extends JPanel{

	public SpacePanel(){
		setBackground(Color.BLACK);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		for (CelestialBody me : CelestialBody.values()){
		//	System.out.println(me);
			g.fillOval((int)(me.getR().getX()-0.5*me.radius), (int)(me.getR().getY()-0.5*me.radius), (int)me.radius, (int)me.radius);
		}
	}
	
	public void update(){
		this.repaint();
	}
	
}
