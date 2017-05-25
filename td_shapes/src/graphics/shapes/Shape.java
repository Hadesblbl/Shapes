package graphics.shapes;

import graphics.shapes.attributes.Attributes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;
import java.util.TreeMap;

public abstract class Shape {
	
	public enum AttributesID {
		COLOR("ColorAttributes"),
		FONT("FontAttributes"),
		SELECT("SelectionAttributes");
		
		private String id;
		
		AttributesID (String id) {
			this.id = id;
		}
		
		public String toString() {
			return this.id;
		}
	}
	
	private TreeMap<String, Attributes> attributeList = new TreeMap<>();
	
	public void addAttributes(Attributes a) {
		this.attributeList.put(a.getId(), a);
	}
	
	public Attributes getAttributes(AttributesID id) throws Exception {
		for (Map.Entry<String, Attributes> entry : attributeList.entrySet()) {
			if ( id.toString().equals(entry.getKey()) ) {
				return entry.getValue();
			}
		}
		throw new Exception("Attributes not valid");
	}
	
	public abstract Point getLoc() throws Exception;
	public abstract void setLoc(Point p);
	public abstract void translate(int x, int y);
	public abstract Rectangle getBounds() throws Exception;
	public abstract void accept(ShapeVisitor v) throws Exception;
	
}
