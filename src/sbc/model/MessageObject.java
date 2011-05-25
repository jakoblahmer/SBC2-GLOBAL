package sbc.model;

import java.io.Serializable;
import java.util.Date;

public abstract class MessageObject implements Serializable {
	
	protected int id = -1;
	protected Date created;
	
	public MessageObject()	{
		created = new Date();
	}
	
	public MessageObject(int id)	{
		created = new Date();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean hasId()	{
		return (id != -1);
	}
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageObject other = (MessageObject) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
