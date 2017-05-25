package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class SRectangle extends Shape {

	private Rectangle rect;
	
	public SRectangle(int width, int height) {
		setLoc(new Point(10, 10));
		this.rect = new Rectangle(width, height);
	}
	
	public SRectangle(Point p, int width, int height) {
		setRect(new Rectangle(width, height));
		setLoc(p);
	}

	public Rectangle getRect() {
		return this.rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
	
	@Override
	public Point getLoc() {
		return this.rect.getLocation();
	}

	@Override
	public void setLoc(Point p) {
		this.rect.setLocation(p);
	}

	@Override
	public void translate(int x, int y) {
		this.setLoc(new Point(x, y));
	}

	@Override
	public Rectangle getBounds() {
		return this.rect;
	}

	@Override
	public void accept(ShapeVisitor v) throws Exception {
		v.visitRectangle(this);
	}
}
