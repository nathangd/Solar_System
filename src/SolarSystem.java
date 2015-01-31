
import javax.swing.JFrame;

import Vector.Vector;
import Vector.Vector2D;


public class SolarSystem {

	public static final double G = 6.67300E-11;

	
	private static void intialise(){
		//for (CelestialBody me : CelestialBody.values()){
		CelestialBody.FRED.setR(new Vector2D(200,200));
		CelestialBody.FRED.setV(Vector2D.ZERO);
		
		CelestialBody.GEORGE.setR(new Vector2D(200,250));
		CelestialBody.GEORGE.setV(Vector2D.ZERO);
		
		findForce(CelestialBody.FRED);
		findForce(CelestialBody.GEORGE);
		//}	
	}
	
	
	
	private static void update(double dt){
		for (CelestialBody me : CelestialBody.values()){
			Integrate.dr(me, dt);
			me.setOldA(me.getA());
		}

		for (CelestialBody me : CelestialBody.values()){
			findForce(me);
			Integrate.dv(me, me.getOldA(), dt);
		}
	}

	private static void findForce(CelestialBody me){									//GAY ATM AS FINDS STUFF TWICE. NAIVE!!!. TODO NOT REPEAT STUFF!!!
		//if(me != CelestialBody.SUN){													//Includes moving sun
		Vector2D force = new Vector2D();													//2D only ATM!!!
		for (CelestialBody them : CelestialBody.values()){
			if(me != them){
				Vector gravVector = them.getR().sub(me.getR());
				force.iAdd(gravVector.scale((-G*me.getMass()*them.getMass())/(gravVector.length()*gravVector.length()*gravVector.length())));
				System.out.println(force.toString());

			}
		}
		me.setForce(force);
	//	System.out.println(force.toString());

		//}
	}

	
	public static void main(String args[]){
		intialise();
		JFrame f = new JFrame("GAY");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		SpacePanel p = new SpacePanel();
		f.add(p);
		
		for(int i = 0; i < 10000; i++){
			update(1e-2);														//~a few hours???
			p.update();
		//	System.out.println(i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
		}
	}
	
}