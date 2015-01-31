import Vector.Vector;


public class Integrate {

	public static void dr(CelestialBody me, double dt){
		Vector newR = me.getR().add((me.getV().scale(dt)).add(me.getA().scale(0.5*dt*dt)));		
		me.setR(newR);
		return ;
	}

	public static void dv(CelestialBody me, double dt){
		Vector newV = me.getV().add((((me.getA().add(me.getOldA()))).scale(0.5*dt)));	
	//	System.out.println("Vi+1 - Vi = " + (newV.sub(me.getV())).toString());
		System.out.println("BOB " + (((me.getA().add(me.getOldA())))).toString());
		me.setV(newV);
		return ;
	}
	
}
