import Vector.Vector;


public enum CelestialBody {

	SUN 	(1.989e30, 6.9634e8/149597870700.0),
	MERCURY (3.303e23, 2.4397e6/149597870700.0),
	VENUS 	(4.869e24, 6.0518e6/149597870700.0),
	EARTH	(5.976e24, 6.37814e6/149597870700.0),
	//MARS 	(6.421e23, 3.3972e6/149597870700.0),
	JUPITER (1.9e27,   7.1492e7/149597870700.0);
	//SATURN 	(5.688e26, 6.0268e7/149597870700.0),
	//URANUS 	(8.686e25, 2.5559e7/149597870700.0),
	//NEPTUNE (1.024e26, 2.4746e7/149597870700.0),
	//PLUTO 	(1.305e22, 1.184e6/149597870700.0);
	
	
	//TEST SUBJECTS!!!
	//FRED (1.989e23, 10),
	//FAT_FRED (1.989e25, 30),
	//GEORGE (1.989e23, 15);
	

	public final double mass, radius;
	private Vector r, v, a, oldA;

	CelestialBody(double mass, double radius) {
		this.mass = mass;
		this.radius = radius;
	}

	public double getMass() { 
		return mass;
	}

	public double getRadius() { 
		return radius;
	}
	
	public Vector getR(){
		return r;
	}
	
	public void setR(Vector setThis){
		r = setThis;
	}

	public Vector getV() {
		return v;
	}

	public Vector getA(){
		return a;
	}
	
	public void setA (Vector setThis){
		this.a = setThis;
	}
	
	public void setV(Vector setThis) {
		this.v = setThis;
	}
	
	public Vector getOldA() {
		return oldA;
	}

	public void setOldA(Vector setThis) {
		this.oldA = setThis;
	}
	
	public void setForce(Vector setThis){
		this.a = setThis.scale(1/mass);
	}
	

	
}
