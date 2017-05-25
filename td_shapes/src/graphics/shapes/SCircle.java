package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class SCircle extends Shape {
	
	private int radius;
	private Point loc;

	public SCircle(Point p, int radius) {
		setLoc(p);
		setRadius(radius);
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	public int setRadius(int radius) {
		return this.radius = radius;
	}
	
	@Override
	public Point getLoc() {
		return this.loc;
	}

	@Override
	public void setLoc(Point p) {
		this.loc = p;
	}

	@Override
	public void translate(int x, int y) {
		this.setLoc(new Point (x, y));
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(loc.x, loc.y, 2*radius, 2*radius);
	}

	@Override
	public void accept(ShapeVisitor v) throws Exception {
		v.visitCircle(this);
	}

}
