package graphics.shapes;

import graphics.shapes.attributes.FontAttributes;

import java.awt.Point;
import java.awt.Rectangle;

public class SText extends Shape {
	
	private String text;
	private Point loc;
	
	public SText(Point p, String text) {
		this.text = text;
		setLoc(p);
	}

	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public Point getLoc() {
		return this.loc;
	}

	@Override
	public void setLoc(Point p) {
		this.loc = p.getLocation();
	}

	@Override
	public void translate(int x, int y) {
		this.setLoc(new Point(x, y));
	}

	@Override
	public Rectangle getBounds() throws Exception {
		Rectangle bounds = ( (FontAttributes)this.getAttributes(AttributesID.FONT) ).getBounds(this.text);
		return new Rectangle(loc.x, loc.y, bounds.width, bounds.height);
	}

	@Override
	public void accept(ShapeVisitor v) throws Exception {
		v.visitText(this);
	}

}
