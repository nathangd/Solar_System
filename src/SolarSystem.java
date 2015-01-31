
import javax.swing.JFrame;

import Vector.Vector;
import Vector.Vector2D;


public class SolarSystem {

	public static final double G = 6.67300E-11;

	
	private static void intialise(){
		//for (CelestialBody me : CelestialBody.values()){
		CelestialBody.FRED.setR(new Vector2D(2000,1000));
		CelestialBody.FRED.setV(Vector2D.xUnit);
		
		CelestialBody.GEORGE.setR(new Vector2D(2000,3000));
		CelestialBody.GEORGE.setV(Vector2D.xUnit.scale(-1));
		
		findForce(CelestialBody.FRED);
		findForce(CelestialBody.GEORGE);
		//}	
	}
	
	
	
	private static void update(double dt){
		for (CelestialBody me : CelestialBody.values()){
			me.setOldA(me.getA());
			System.out.println("oldA: " + me.getOldA().toString());
			Integrate.dr(me, dt);
			System.out.println(me.getR().toString());
		}

		for (CelestialBody me : CelestialBody.values()){
			findForce(me);
			System.out.println("A: " + me.getA().toString());
			Integrate.dv(me, dt);
			System.out.println(me.getV().toString());
			
		}
	
	}

	private static void findForce(CelestialBody me){										//GAY ATM AS FINDS STUFF TWICE. NAIVE!!!. TODO NOT REPEAT STUFF!!!
		//if(me != CelestialBody.SUN){														//Includes moving sun
		Vector2D force = new Vector2D();													//2D only ATM!!!
		for (CelestialBody them : CelestialBody.values()){
			if(me != them){
				Vector gravVector = me.getR().sub(them.getR());
				force.addTo(gravVector.scale((-G*me.getMass()*them.getMass())/(gravVector.length()*gravVector.length()*gravVector.length())));
				//System.out.println(force.toString());
			}
		}
		//System.out.println(force.toString());
		me.setForce(force);
		//}
	}

	
	public static void main(String args[]){
		intialise();
		JFrame f = new JFrame("GAY");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 800);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		SpacePanel p = new SpacePanel();
		f.add(p);
		
		
		for(int i = 0; i < 10000; i++){
			System.out.println(i);
			update(1e-2);														//~a few hours???
			p.update();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
	
}