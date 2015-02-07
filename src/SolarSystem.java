import javax.swing.JFrame;

import Vector.Vector;
import Vector.Vector3D;


public class SolarSystem {

	/*
	 * 3D
	 */

	public static final double G = 6.67300E-11;


	private static void intialise(){


		CelestialBody.FAT_FRED.setR(new Vector3D(2000000,10000, 0));
		CelestialBody.FAT_FRED.setV(Vector3D.xUnit.scale(1e2));

		CelestialBody.GEORGE.setR(new Vector3D(2000000,2000000, 0));
		CelestialBody.GEORGE.setV(Vector3D.xUnit.scale(-1e11));

		//TO DO ALL OF THEM!!!
		/*for (CelestialBody me : CelestialBody.values()){
			me.
		}
		 */
		
		for (CelestialBody me : CelestialBody.values()){
			findAcceleration(me);
		}
	}

	private static void update(double dt){
		for (CelestialBody me : CelestialBody.values()){
			me.setOldA(me.getA());
			//System.out.println("oldA: " + me.getOldA().toString());
			me.setR(Integrate.dr(me, dt));
			System.out.println("R: " + me.getR().toString());
		}

		for (CelestialBody me : CelestialBody.values()){
			findAcceleration(me);
			//System.out.println("A: " + me.getA().toString());
			me.setV(Integrate.dv(me, dt));
			System.out.println("V: " + me.getV().toString());

		}

	}

	private static void findAcceleration(CelestialBody me){										//GAY ATM AS FINDS STUFF TWICE. NAIVE!!!. TODO NOT REPEAT STUFF!!!
		Vector a = new Vector3D();
		for (CelestialBody them : CelestialBody.values()){
			if(me != them){
				Vector gravVector = (me.getR().sub(them.getR())).normalise();
				a.addTo(gravVector.scale((-G*them.getMass())/(gravVector.length()*gravVector.length())));
				//System.out.println(force.toString());
			}
		}
		//System.out.println(force.toString());
		me.setA(a);
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

		for(int i = 0; i < 1000; i++){
			System.out.println(i);
			update(1e-6);														//~a few hours???
			p.update();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
		}
	}

}