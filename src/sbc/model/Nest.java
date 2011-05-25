package sbc.model;

public class Nest extends MessageObject {

	private static final long serialVersionUID = 1644743739476877L;

	private int builder_id;
	
	private int shipper_id;
	
	private Egg egg1 = null;
	
	private Egg egg2 = null;
	
	private ChocolateRabbit rabbit;
	
	private boolean shipped;
	
	public Nest()	{
		super();
		this.shipped = false;
	}
	
	public Nest(int builder_id)	{
		super();
		this.shipped = false;
		this.builder_id = builder_id;
	}
	
//	public Nest(int builder_id, Egg egg1, Egg egg2, ChocolateRabbit rabbit)	{
//		super(id);
//		this.shipped = false;
//		this.builder_id = builder_id;
//		this.egg1 = egg1;
//		this.egg2 = egg2;
//		this.rabbit = rabbit;
//	}
	
	public int getBuilder_id() {
		return builder_id;
	}

	public void setBuilder_id(int builder_id) {
		this.builder_id = builder_id;
	}

	public int getShipper_id() {
		return shipper_id;
	}

	public void setShipper_id(int shipper_id) {
		this.shipper_id = shipper_id;
	}

	public Egg getEgg1() {
		return egg1;
	}

	public void setEgg1(Egg egg1) {
		this.egg1 = egg1;
	}

	public Egg getEgg2() {
		return egg2;
	}

	public void setEgg2(Egg egg2) {
		this.egg2 = egg2;
	}

	public ChocolateRabbit getRabbit() {
		return rabbit;
	}

	public void setRabbit(ChocolateRabbit rabbit) {
		this.rabbit = rabbit;
	}

	public boolean isShipped() {
		return shipped;
	}

	public void setShipped(boolean shipped) {
		this.shipped = shipped;
	}

	public void addEgg(Egg egg)	{
		if(egg1 == null)
			egg1 = egg;
		else if(egg2 == null)
			egg2 = egg;
	}
	
	public boolean isComplete()	{
		return (this.egg1 != null && this.egg1.isColored() && this.egg1.hasId() &&
			this.egg2 != null && this.egg2.isColored() && this.egg2.hasId() &&
			this.rabbit != null && this.rabbit.hasId());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + builder_id;
		result = prime * result + ((egg1 == null) ? 0 : egg1.hashCode());
		result = prime * result + ((egg2 == null) ? 0 : egg2.hashCode());
		result = prime * result + ((rabbit == null) ? 0 : rabbit.hashCode());
		result = prime * result + (shipped ? 1231 : 1237);
		result = prime * result + shipper_id;
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
		Nest other = (Nest) obj;
		if (builder_id != other.builder_id)
			return false;
		if (egg1 == null) {
			if (other.egg1 != null)
				return false;
		} else if (!egg1.equals(other.egg1))
			return false;
		if (egg2 == null) {
			if (other.egg2 != null)
				return false;
		} else if (!egg2.equals(other.egg2))
			return false;
		if (rabbit == null) {
			if (other.rabbit != null)
				return false;
		} else if (!rabbit.equals(other.rabbit))
			return false;
		if (shipped != other.shipped)
			return false;
		if (shipper_id != other.shipper_id)
			return false;
		return true;
	}

	public String toString()	{
		return "NEST: [id: " + id + ", builder_id: " + builder_id + ", logistic_id: " + builder_id + 
				",\nEGG1: \n" + egg1 + ", \nEGG2: \n" + egg2 + ", \nChocoRabbit: \n" + rabbit + "]";
	}
	
}
