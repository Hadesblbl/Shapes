package graphics.shapes.ui;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.Shape.AttributesID;
import graphics.shapes.ShapeVisitor;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

public class ShapeDraftman implements ShapeVisitor {
	
	private Graphics g;
	
	public ColorAttributes DEFAULT_COLOR_ATTRIBUTES = new ColorAttributes(true, false, Color.blue, Color.blue);
	
	public ShapeDraftman (Graphics g) {
		this.g = g;
	}
	
	public void select(Shape s) throws Exception {
		SelectionAttributes shape = (SelectionAttributes) s.getAttributes(AttributesID.SELECT);
		
		if (shape.isSelected()) {
			g.setColor(Color.BLACK);
			g.drawRect(s.getBounds().x - 4, s.getBounds().y - 4, 4, 4);
			g.drawRect(s.getBounds().x + s.getBounds().width, s.getBounds().y + s.getBounds().height, 4, 4);
		}
	}
	
	@Override
	public void visitRectangle(SRectangle r) throws Exception {
		ColorAttributes color = (ColorAttributes) r.getAttributes(AttributesID.COLOR);
		
		if (color.filled) {
            g.setColor(color.filledColor);
            g.fillRect(r.getLoc().x, r.getLoc().y, r.getRect().width, r.getRect().height);
        }
		
        if (color.stroked) {
            g.setColor(color.strokedColor);
            g.drawRect(r.getLoc().x, r.getLoc().y, r.getRect().width, r.getRect().height);
        }

        select(r);
	}

	@Override
	public void visitCircle(SCircle c) throws Exception {
		ColorAttributes color = (ColorAttributes) c.getAttributes(AttributesID.COLOR);
		
		if (color.filled) {
            g.setColor(color.filledColor);
            g.fillOval(c.getLoc().x, c.getLoc().y, c.getBounds().width, c.getBounds().height);
        }
		
        if (color.stroked) {
            g.setColor(color.strokedColor);
            g.drawOval(c.getLoc().x, c.getLoc().y, c.getBounds().width, c.getBounds().height);
        }

        select(c);
	}

	@Override
	public void visitText(SText t) throws Exception {
		ColorAttributes color = (ColorAttributes) t.getAttributes(AttributesID.COLOR);
		FontAttributes font = (FontAttributes) t.getAttributes(AttributesID.FONT);
		int offset = 3;
		
		if (color.filled) {
			g.setColor(color.filledColor);
			g.fillRect(t.getLoc().x, t.getLoc().y, t.getBounds().width, t.getBounds().height);
			
		}
		
		if (color.stroked) {
			g.setColor(color.strokedColor);
			g.drawRect(t.getLoc().x, t.getLoc().y, t.getBounds().width, t.getBounds().height);
		}
		
		g.setFont(font.font());
		g.setColor(font.fontColor);
		g.drawString(t.getText(), t.getBounds().x + offset, t.getBounds().y + t.getBounds().height - offset);
		
		select(t);
	}

	@Override
	public void visitCollection(SCollection collection) throws Exception {
		for (Iterator<Shape> it = collection.iterator(); it.hasNext();) {
			it.next().accept(this);
		}
		
		select(collection);
	}
}
