import Vector.Vector;


public class Integrate {

	public static void dr(CelestialBody me, double dt){
		Vector newR = me.getR().add(me.getV().scale(dt)).add(me.getA().scale(0.5*dt*dt));		
		me.setR(newR);
		return ;
	}

	public static void dv(CelestialBody me, Vector oldA, double dt){
		Vector newV = me.getV().add((me.getA().add(oldA)).scale(0.5*dt));		
		me.setV(newV);
		return ;
	}
	
}
