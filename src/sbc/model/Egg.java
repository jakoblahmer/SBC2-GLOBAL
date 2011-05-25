package sbc.model;

import java.util.ArrayList;
import java.util.List;

public class Egg extends Product {

	private static final long serialVersionUID = 8436930076543223209L;
	
	private int colorCount = -1;
	
	private boolean colored;
	private List<String> color = null;
	
	
	private int colorer_id;
	
	public Egg()	{
		super();
		colored = false;
	}
	
	public Egg(int producer)	{
		super(producer);
	}
	
	public Egg(int producer, int colorCount)	{
		super(producer);
		this.color = new ArrayList<String>(colorCount);
		this.colorCount = colorCount;
	}
	
	public boolean isColored() {
		return colored;
	}

	public void setColored(boolean colored) {
		this.colored = colored;
	}

	public void setColorer_id(int colorer_id) {
		this.colorer_id = colorer_id;
	}

	public int getColorer_id() {
		return colorer_id;
	}

	public void setColorCount(int colorCount) {
		this.colorCount = colorCount;
		color = new ArrayList<String>(colorCount);
	}

	public int getColorCount() {
		return colorCount;
	}
	
	public List<String> getColor() {
		return color;
	}

	public void addColor(String color)	{
		if(this.color == null)
			this.color = new ArrayList<String>();
		
		if(this.color.size() >= this.colorCount || this.colored)	{
			return;
		}
		
		this.color.add(color);
		if(this.color.size() >= this.colorCount)	{
			this.colored = true;
		}
	}
	
	private String colorToString()	{
		String ret = "[";
		for (String s : color)	{
			ret += s + "|";
		}
		return ret.substring(0, ret.length()-1) + "]";
	}
	
	public String toString()	{
		return "EGG: [id: " + id + ", producer_id: " + producer_id + ", colorCount: " + this.colorCount + ", colors: " + colorToString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + colorCount;
		result = prime * result + (colored ? 1231 : 1237);
		result = prime * result + colorer_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Egg other = (Egg) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (colorCount != other.colorCount)
			return false;
		if (colored != other.colored)
			return false;
		if (colorer_id != other.colorer_id)
			return false;
		return true;
	}

}
