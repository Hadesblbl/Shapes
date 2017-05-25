package graphics.shapes;

public interface ShapeVisitor {
	public abstract void visitRectangle(SRectangle rect) throws Exception;
	public abstract void visitCircle(SCircle circle) throws Exception;
	public abstract void visitText(SText text) throws Exception;
	public abstract void visitCollection(SCollection collection) throws Exception;
}
