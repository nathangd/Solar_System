import Vector.Vector;
import Vector.Vector3D;


public class AccelerationThread implements Runnable {

	CelestialBody me;
	Vector a;
	public AccelerationThread(CelestialBody me){
		this.me = me;
		Vector a = new Vector3D();
	}
	//This can be optimised further
	public void run() {
		for (CelestialBody them : CelestialBody.values()){
			if(me != them){
				Vector gravVector = (me.getR().sub(them.getR())).normalise();
				a.addTo(gravVector.scale((-SolarSystem.G*them.getMass())/(gravVector.length()*gravVector.length())));
				//System.out.println(force.toString());
			}
		}
		//System.out.println(force.toString());
	}
	public Vector getA(){
		return a;
	}
}
