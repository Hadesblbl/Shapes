package graphics.shapes.attributes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;

public class FontAttributes extends Attributes {

	private final String ID_FONT = "FontAttributes";
	
	public Font font;
	public Color fontColor;
	
	public FontAttributes() {
		this.font = new Font("Helvetica", Font.PLAIN, 12);
		this.fontColor = Color.BLUE;
	}
	
	@Override
	public String getId() {
		return ID_FONT;
	}
	
	public Font font() {
		return this.font;
	}
	
	public Color fontColor() {
		return this.fontColor;
	}
	
	public Rectangle getBounds(String text) {
		FontRenderContext frc = new FontRenderContext(null, false, false);
		Rectangle r = this.font.getStringBounds(text, frc).getBounds();
		r.grow(3, 0);	// Width : +3 px
		return r;
	}

}