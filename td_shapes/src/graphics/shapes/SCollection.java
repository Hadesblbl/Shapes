package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SCollection extends Shape {
	
	private List<Shape> shapes;
	
	public SCollection() {
		this.shapes = new ArrayList<Shape>();
	}
	
	public Iterator<Shape> iterator() {
		return shapes.iterator();
	}
	
	public void add(Shape s) {
		this.shapes.add(s);
	}
	
	@Override
	public Point getLoc() throws Exception {
		return this.getBounds().getLocation();
	}

	@Override
	public void setLoc(Point p) {
		for (Iterator<Shape> it = this.iterator(); it.hasNext();)
			it.next().setLoc(p);
	}

	@Override
	public void translate(int x, int y) {
		for (Iterator<Shape> it = this.iterator(); it.hasNext();)
			it.next().setLoc(new Point(x,y));
	}
	
	@Override
	public Rectangle getBounds() throws Exception {
		Rectangle r = new Rectangle();
		
		for (Iterator<Shape> it = this.iterator(); it.hasNext();) {
			r.setLocation(it.next().getLoc());
			r = r.union(it.next().getBounds());
		}
		return r;
	}

	@Override
	public void accept(ShapeVisitor v) throws Exception {
		v.visitCollection(this);
	}

}
