package graphics.shapes.attributes;

public class SelectionAttributes extends Attributes {

	private final String ID_SELECT = "SelectionAttributes";
	
	private Boolean selected = false;
	
	@Override
	public String getId() {
		return ID_SELECT;
	}
	
	public Boolean isSelected() {
		return this.selected;
	}

	public void select() {
		this.selected = true;
	}
	
	public void unselect() {
		this.selected = false;
	}
	
	public void toggleSelection() {
		this.selected = !(this.selected);
	}
}
