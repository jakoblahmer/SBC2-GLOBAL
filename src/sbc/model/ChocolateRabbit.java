package sbc.model;

public class ChocolateRabbit extends Product {

	private static final long serialVersionUID = 1101338789645290893L;
	
	public ChocolateRabbit()	{
		super();
	}
	
	public ChocolateRabbit(int producer)	{
		super(producer);
	}

	public String toString()	{
		return "ChocolateRabbit: [id: " + id + ", producer_id: " + producer_id + ", failure: " + this.error + "]";
	}
	
}
