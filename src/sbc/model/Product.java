package sbc.model;

import java.util.Date;

public abstract class Product extends MessageObject {

	protected int producer_id;
	
	protected boolean error = false;
	
	public Product()	{
		created = new Date();
	}
	
	public Product(int producer)	{
		super();
		producer_id = producer;
	}

	public int getProducer_id() {
		return producer_id;
	}

	public void setProducer_id(int producer_id) {
		this.producer_id = producer_id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (error ? 1231 : 1237);
		result = prime * result + producer_id;
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
		Product other = (Product) obj;
		if (error != other.error)
			return false;
		if (producer_id != other.producer_id)
			return false;
		return true;
	}

}
