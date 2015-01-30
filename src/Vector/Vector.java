package Vector;
	
public abstract class Vector{
	
	//class members
	protected double x, y;
	
	//class methods
	public abstract String toString();
	public abstract double getX();
	public abstract double getY();	
	public abstract double getZ();	
	public abstract double length();
	public abstract double xAngle();
	public abstract double xAngleDeg();
	public abstract void setX(double d);
	public abstract void setY(double d);
	public abstract void setLength(double d);
	public abstract void setXAngle(double d);
	public abstract void setXAngleDeg(double d);
	public abstract void setX(int i);
	public abstract void setY(int i);
	public abstract void setLength(int i);
	public abstract void setXAngle(int i);
	public abstract void setXAngleDeg(int i);
	public abstract Vector add(Vector b);
	public abstract Vector sub(Vector b);
	public abstract double dot(Vector b);
	public abstract Vector cross(Vector b);		
	public abstract Vector scale(int s);		
	public abstract Vector scale(double s);
	public abstract Vector normalise();
}

