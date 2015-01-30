package Vector;

public class Vector3D extends Vector{

	private double z;
	public static final Vector xUnit = new Vector3D(1,0,0);
	public static final Vector yUnit = new Vector3D(0,1, 1);
	public static final Vector zUnit = new Vector3D(0,0,1);
	public static final Vector zero = new Vector3D();

	public Vector3D(){
		x = 0.0;
		y = 0.0;
		z = 0.0;
	}
	
	public Vector3D(int xIn, int yIn, int zIn){
		x = xIn;
		y = yIn;
		z = zIn;
	}
	
	public Vector3D(double xIn, double yIn, double zIn){
		x = xIn;
		y = yIn;
		z = zIn;
	}

	public String toString(){
		return String.format("(%g, %g, %g)\n", x, y, z);
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}

	public double getZ(){
		return z;
	}		
	
	public double length(){
		return Math.sqrt(x*x+y*y+z*z);
	}

	public double zAngle(){
		double theta = 0.0;
		if(z == 0){
			theta = Math.PI/2;
		} else {
		theta = z/this.length();
		}
		return Math.acos(theta);
	}
	
	public double zAngleDeg(){
		double theta = 0.0;
		if(z == 0){
			theta = Math.PI/2;
		} else {
		theta = z/this.length();
		}
		return Math.toDegrees(theta);
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
	
	public void setZ(int zNew){
		z = zNew;
	}
	
	public void setZ(double zNew){
		z = zNew;
	}
	
	public void setLength(int l){
		x = Math.sqrt(l*l - x*x - y*y);
		y = Math.sqrt(l*l - x*x - z*z);
		z = Math.sqrt(l*l - x*x - y*y);
	}
	
	public void setLength(double l){
		x = Math.sqrt(l*l - x*x - y*y);
		y = Math.sqrt(l*l - x*x - z*z);
		z = Math.sqrt(l*l - x*x - y*y);
	}
	
	public void setXAngle(int angle){
		x = this.length()*Math.sin(this.zAngle())*Math.cos(angle);
		y = this.length()*Math.sin(this.zAngle())*Math.sin(angle);
	}
	
	public void setXAngle(double angle){
		x = this.length()*Math.sin(this.zAngle())*Math.cos(angle);
		y = this.length()*Math.sin(this.zAngle())*Math.sin(angle);
	}
	
	public void setXAngleDeg(int degrees){
		double angle = Math.toRadians((double)degrees);
		x = this.length()*Math.sin(this.zAngle())*Math.cos(angle);
		y = this.length()*Math.sin(this.zAngle())*Math.sin(angle);
	}
	
	public void setXAngleDeg(double degrees){
		double angle = Math.toRadians(degrees);
		x = this.length()*Math.sin(this.zAngle())*Math.cos(angle);
		y = this.length()*Math.sin(this.zAngle())*Math.sin(angle);
	}
	
	public void setZAngle(int angle){
		x = this.length()*Math.sin(angle)*Math.cos(this.xAngle());
		y = this.length()*Math.sin(angle)*Math.sin(this.xAngle());
		z = this.length()*Math.cos(angle);
	}
	
	public void setZAngle(double angle){
		x = this.length()*Math.sin(angle)*Math.cos(this.xAngle());
		y = this.length()*Math.sin(angle)*Math.sin(this.xAngle());
		z = this.length()*Math.cos(angle);
	}
	
	public void setZAngleDeg(int degrees){
		double angle = Math.toRadians((double)degrees);
		x = this.length()*Math.sin(angle)*Math.cos(this.xAngle());
		y = this.length()*Math.sin(angle)*Math.sin(this.xAngle());
		z = this.length()*Math.cos(angle);
	}
	
	public void setZAngleDeg(double degrees){
		double angle = Math.toRadians((double)degrees);
		x = this.length()*Math.sin(angle)*Math.cos(this.xAngle());
		y = this.length()*Math.sin(angle)*Math.sin(this.xAngle());
		z = this.length()*Math.cos(angle);
	}
	
	public Vector add(Vector b){
		double newX = this.getX() + b.getX();
		double newY = this.getY() + b.getY();
		double newZ = this.getZ() + b.getZ();
		return new Vector3D(newX, newY, newZ);
	}
	
	public double dot(Vector b){
		return this.x*b.getX() + this.y*b.getY() + this.z*b.getZ();
	}
	
	public Vector cross(Vector b){		
		double newX = this.y*b.getZ() - this.z*b.getY(); 
		double newY = this.z*b.getX() - this.x*b.getZ(); 			//THIS IS BROKEN!!!!!!!!!!! - WHY????
		double newZ = this.x*b.getY() - this.y*b.getX(); 
		return new Vector3D(newX, newY, newZ);
	}
	
	public Vector scale(int s){
		double newX = this.x*s;
		double newY = this.y*s;
		double newZ = this.z*s;
		return new Vector3D(newX, newY, newZ);
	}
	
	public Vector scale(double s){
		double newX = this.x*s;
		double newY = this.y*s;
		double newZ = this.z*s;
		return new Vector3D(newX, newY, newZ);
	}

	public Vector normalise() {
		return this.scale((1/this.length()));
	}
}
