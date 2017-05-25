package graphics.shapes.ui;

import java.awt.Graphics;

import graphics.shapes.SCollection;
import graphics.ui.View;

public class ShapesView extends View {
private static final long serialVersionUID = 2648596808496468152L;

	private ShapesController controller;

	public ShapesView(Object model) {
		super(model);
		this.controller = new ShapesController(model);
		this.controller.setView(this);
		this.addMouseListener(this.controller);
		this.addMouseMotionListener(this.controller);
		this.addKeyListener(this.controller);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ShapeDraftman draftman = new ShapeDraftman(g);
		SCollection model = (SCollection) this.getModel();
		
		try { model.accept(draftman); }
		catch (Exception e) { e.printStackTrace(); }
		
		g.dispose();
	}

}
