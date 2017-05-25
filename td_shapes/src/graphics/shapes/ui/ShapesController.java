package graphics.shapes.ui;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.Shape.AttributesID;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.Controller;

public class ShapesController extends Controller {
	
	private ShapesView view;
	private SCollection model;
	private SelectionAttributes shape;
	
	private Shape s;
	private Point loc;
	private Boolean shift = false;
	
	public ShapesController(Object model) {
		super(model);
		this.model = (SCollection) this.getModel();
		this.shape = null;
	}

	public void setView(ShapesView view) {
		this.view = view;
	}
	
	public void toggleShift(Boolean shift) {
		this.shift = !shift;
	}
	
	public Boolean shiftDown() {
		return this.shift;
	}

	public void translateSelected(int x, int y) throws Exception {
		for (Iterator<Shape> it = model.iterator(); it.hasNext();) {
			s = it.next();
			shape = (SelectionAttributes) s.getAttributes(AttributesID.SELECT);
			
			if (shape.isSelected())
				s.translate(x, y);
			
			System.out.println(s.getLoc());
		}
		System.out.println("\n");
	}
	
	public Shape getTarget() throws Exception {
		for (Iterator<Shape> it = model.iterator(); it.hasNext();) {
			Shape s = it.next();

			if ( s.getBounds().contains(this.loc) )
				return s;
		}

		return null;
	}
	
	public void unselectAll() throws Exception {
		for (Iterator<Shape> it = model.iterator(); it.hasNext();) {
			Shape s = it.next();
			shape = (SelectionAttributes) s.getAttributes(AttributesID.SELECT);
			shape.unselect();
		}
	}
	
	@Override
	public Object getModel() {
		return super.getModel();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseReleased(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		this.loc = e.getPoint();
		
		try { s = getTarget(); } 
		catch (Exception ex) { ex.printStackTrace(); }
		
		if (s != null) {
			// Enable selection
			try {
				unselectAll();
			    shape = (SelectionAttributes) s.getAttributes(AttributesID.SELECT);
			    shape.toggleSelection(); 
			} catch (Exception ex) { ex.printStackTrace(); }
			
			// Enable shift
			if (!shiftDown())
				toggleShift(shift);
			
		} else {
			// Disable selection
			try { unselectAll(); }
			catch (Exception ex) { ex.printStackTrace(); }
			
			// Disable shift
			if (shiftDown())
				toggleShift(shift);
			
		}
		
		this.view.updateUI();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseExited(e);
	}

	@Override
	public void mouseMoved(MouseEvent evt) {
		// TODO Auto-generated method stub
		super.mouseMoved(evt);
	}

	@Override
	public void mouseDragged(MouseEvent evt) {	
		try { translateSelected( evt.getX(), evt.getY() ); }
		catch (Exception e) { e.printStackTrace(); }
		System.err.println(evt.getX() + "," + evt.getY());
		this.view.updateUI();
	}

	@Override
	public void keyTyped(KeyEvent evt) {
		// TODO Auto-generated method stub
		super.keyTyped(evt);
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		super.keyPressed(evt);
	}

	@Override
	public void keyReleased(KeyEvent evt) {
		// TODO Auto-generated method stub
		super.keyReleased(evt);
	}
	
	
	
}
