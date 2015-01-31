import Vector.Vector;


public class Integrate {

	public static Vector dr(CelestialBody me, double dt){
		return me.getR().add((me.getV().scale(dt)).add(me.getA().scale(0.5*dt*dt)));		
	}

	public static Vector dv(CelestialBody me, double dt){
		return me.getV().add((((me.getA().add(me.getOldA()))).scale(0.5*dt)));		
	}
	
}
