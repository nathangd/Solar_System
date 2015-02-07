import javax.swing.JFrame;

import Vector.Vector;
import Vector.Vector3D;


public class SolarSystem {

	/*
	 * 3D
	 */

	public static final double G = (6.67300E-11)*(3600*24)/(149597870700.0*149597870700.0*149597870700.0);
	public static final int windowSize = 1000;

	private static void intialise(){
		CelestialBody.SUN.setR(new Vector3D());
		CelestialBody.SUN.setV(new Vector3D());

		CelestialBody.MERCURY.setR(new Vector3D(-2.503321047836E-01, 1.873217481656E-01, 1.260230112145E-01));
		CelestialBody.MERCURY.setV(new Vector3D(-2.438808424736E-02, -1.850224608274E-02, -7.353811537540E-03));

		CelestialBody.VENUS.setR(new Vector3D(1.747780055994E-02,-6.624210296743E-01, -2.991203277122E-01));
		CelestialBody.VENUS.setV(new Vector3D(2.008547034175E-02, 8.365454832702E-04, -8.947888514893E-04));
		
		CelestialBody.EARTH.setR(new Vector3D(-9.091916173950E-01, 3.592925969244E-01, 1.557729610506E-01));
		CelestialBody.EARTH.setV(new Vector3D(-7.085843239142E-03, -1.455634327653E-02, -6.310912842359E-03));
		
		CelestialBody.MARS.setR(new Vector3D(1.203018828754E+00, 7.270712989688E-01, 3.009561427569E-01));
		CelestialBody.MARS.setV(new Vector3D(-7.124453943885E-03, 1.166307407692E-02, 5.542098698449E-03));
		
		CelestialBody.JUPITER.setR(new Vector3D(3.733076999471E+00, 3.052424824299E+00, 1.217426663570));
		CelestialBody.JUPITER.setV(new Vector3D(-5.086540617947E-03, 5.493643783389E-03, 2.478685100749E-03));
		
		CelestialBody.SATURN.setR(new Vector3D(6.164433062913E+00, 6.366775402981E+00, 2.364531109847));
		CelestialBody.SATURN.setV(new Vector3D(-4.426823593779E-03, 3.394060157503E-03, 1.592261423092));
		
		CelestialBody.URANUS.setR(new Vector3D(+1.457964661868E+01,-1.236891078519E+01, -5.623617280033));
		CelestialBody.URANUS.setV(new Vector3D(+2.647505630327E-03, +2.487457379099E-03, 1.052000252243E-03));
		
		CelestialBody.NEPTUNE.setR(new Vector3D(+1.695491139909E+01,-2.288713988623E+01, -9.789921035251));
		CelestialBody.NEPTUNE.setV(new Vector3D(+2.568651772461E-03, +1.681832388267E-03, 6.245613982833E-04));
		
		CelestialBody.PLUTO.setR(new Vector3D(-9.707098450131E+00,-2.804098175319E+01, -5.823808919246));
		CelestialBody.PLUTO.setV(new Vector3D(3.034112963576E-03, -1.111317562971E-03, -1.261841468083));

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
			//System.out.println("R: " + me.getR().toString());
		}

		for (CelestialBody me : CelestialBody.values()){
			findAcceleration(me);
			//System.out.println("A: " + me.getA().toString());
			me.setV(Integrate.dv(me, dt));
			//System.out.println("V: " + me.getV().toString());

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
		f.setSize(windowSize, windowSize);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		SpacePanel p = new SpacePanel();
		f.add(p);

		while(true){
			update(1e-1);														//~a few hours???
			p.update();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		}
	}

}