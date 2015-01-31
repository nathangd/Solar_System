
import javax.swing.JFrame;

import Vector.Vector;
import Vector.Vector2D;


public class SolarSystem {

	public static final double G = 6.67300E-11;

	
	private static void intialise(){
		//for (CelestialBody me : CelestialBody.values()){
		CelestialBody.FRED.setR(new Vector2D(200,200));
		CelestialBody.FRED.setV(Vector2D.xUnit.scale(100));
		
		CelestialBody.GEORGE.setR(new Vector2D(200,250));
		CelestialBody.GEORGE.setV(Vector2D.xUnit.scale(-100));
		
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
		Vector force = Vector2D.ZERO;													//2D only ATM!!!
		for (CelestialBody them : CelestialBody.values()){
			if(me != them){
				Vector gravVector = them.getR().sub(me.getR());
				force.add(gravVector.scale((-G*me.getMass()*them.getMass())/(gravVector.length()*gravVector.length()*gravVector.length())));
			}
		}
		me.setForce(force);
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
			System.out.println(i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		}
	}
	
}







	/*private static void findForces(){														//GAY ATM AS FINDS STUFF TWICE. NAIVE!!!. TODO NOT REPEAT STUFF!!!
		for (CelestialBody me : CelestialBody.values()){
			//if(me != CelestialBody.SUN){													//Can include moving sun
			Vector force = Vector2D.ZERO;													//2D only ATM!!!
			double mass = me.getMass();
			Vector r = me.getR();
			for (CelestialBody them : CelestialBody.values()){
				if(me != them){
					Vector gravVector = them.getR().sub(r);
					force.add(gravVector.scale((G*mass*them.getMass())/(gravVector.length()*gravVector.length()*gravVector.length())));
				}
			}
			me.setForce(force);
			//}
		}
	}*/