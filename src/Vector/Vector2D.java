package Vector;

public class Vector2D extends Vector{

	public static final Vector xUnit = new Vector2D(1,0);
	public static final Vector yUnit = new Vector2D(0,1);
	public static final Vector ZERO = new Vector2D();

	//Constructors
	public Vector2D(){
		x = 0;
		y = 0;
	}
	
	public Vector2D(int xIn, int yIn){
		x = xIn;
		y = yIn;
	}
	
	public Vector2D(double xIn, double yIn){
		x = xIn;
		y = yIn;
	}

	public static Vector Polar(int r, int phi){
		return Polar((double) r, (double) phi);
	}
	
	public static Vector Polar(double r, double phi){
		double xNew = r*Math.cos(phi);
		double yNew = r*Math.sin(phi);
		return new Vector2D(xNew, yNew);
	}
	
	//returns a string.
	public String toString(){
		return String.format("(%g, %g)", x, y);
	}
	
	//Getters!
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}	
	
	public double getZ(){
		return 0.0;
	}	
	
	public double length(){
		return Math.sqrt(x*x+y*y);
	}
	
	public double xAngle(){
		double phi = 0.0;
		if(x == 0){
			phi = Math.PI/2;
		} else {
		phi = Math.atan(y/x);
		}
		return phi;
	}
	
	public double xAngleDeg(){
		double phi = 0.0;
		if(x == 0){
			phi = Math.PI/2;
		} else {
		phi = Math.atan(y/x);
		}
		return Math.toDegrees(phi);
	}
	
	//Setters!
	public void setX(int xNew){
		x = xNew;
	}
	
	public void setX(double xNew){
		x = xNew; 
	}
	
	public void setY(int yNew){
		y = yNew;
	}
	
	public void setY(double yNew){
		y = yNew;
	}
		
	public void setLength(int l){
		setLength((double)l);
	}
	
	public void setLength(double l){
		x = l*Math.cos(xAngle());
		y = l*Math.sin(xAngle());
	}
	
	public void setXAngle(int angle){
		setXAngle((double)angle);
	}
	
	public void setXAngle(double angle){
		x = this.length()*Math.cos(angle);
		y = this.length()*Math.sin(angle);
	}
	
	public void setXAngleDeg(int degrees){
		setXAngleDeg((double)degrees);
	}
	
	public void setXAngleDeg(double degrees){
		double angle = Math.toRadians(degrees);
		x = this.length()*Math.cos(angle);
		y = this.length()*Math.sin(angle);
	}
	
	//Adds vectors.
	public Vector add(Vector b){
		double newX = this.x + b.getX();
		double newY = this.y + b.getY();
		return new Vector2D(newX, newY);
	}
	
	public void addTo(Vector b){
		this.x += b.getX();
		this.y += b.getY();
	}
	
	//Subtracts vectors.
	public Vector sub(Vector b){
		return add(b.scale(-1));
	}
	
	public void subTo(Vector b){
		addTo(b.scale(-1));
	}
	
	//Takes the dot product with vector b.
	public double dot(Vector b){
		return this.x*b.getX() + this.y*b.getY();
	}
	
	//Takes the cross product with vector b.
	public Vector cross(Vector b){		
		double newX = this.y*b.getZ(); 
		double newY = - this.x*b.getZ(); 							
		double newZ = this.x*b.getY() - this.y*b.getX(); 
		return new Vector3D(newX, newY, newZ);
	}
	
	//Scales the vector
	public Vector scale(int s){
		return scale((double)s);
	}
	
	public Vector scale(double s){
		double newX = this.x*s;
		double newY = this.y*s;
		return new Vector2D(newX, newY);
	}
	
	//normalises the vector
	public Vector normalise(){
		return this.scale((1/this.length()));
	}
	
	//Rotates the vector about an angle theta
	public Vector rotate(int theta){
		double newX = this.x*Math.cos((double)theta) - this.y*Math.sin((double)theta);
		double newY = this.x*Math.sin((double)theta) + this.y*Math.cos((double)theta);
		return new Vector2D(newX, newY);
	}
	
	public Vector rotate(double theta){
		double newX = this.x*Math.cos(theta) - this.y*Math.sin(theta);
		double newY = this.x*Math.sin(theta) + this.y*Math.cos(theta);
		return new Vector2D(newX, newY);
	}
	
	public Vector rotateDeg(int angle){
		double theta = Math.toRadians((double)angle);
		double newX = this.x*Math.cos(theta) - this.y*Math.sin(theta);
		double newY = this.x*Math.sin(theta) + this.y*Math.cos(theta);
		return new Vector2D(newX, newY);
	}
	
	public Vector rotateDeg(double angle){
		double theta = Math.toRadians(angle);
		double newX = this.x*Math.cos(theta) - this.y*Math.sin(theta);
		double newY = this.x*Math.sin(theta) + this.y*Math.cos(theta);
		return new Vector2D(newX, newY);
	}

}
