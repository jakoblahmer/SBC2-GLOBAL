package sbc.gui.tablemodels;

import java.util.HashMap;

import sbc.model.Nest;

public abstract class DefaultNestTableModel extends DefaultTableModel {

	protected HashMap<Integer, Nest> nestInfo = new HashMap<Integer, Nest>();
	
	/**
	 * implemented by subclasses
	 * @param nest
	 */
	public abstract void addRow(Nest nest);
	
	
	/**
	 * removes a nest from the table
	 * @param nest
	 */
	public void removeRow(Nest nest)	{
		if(!nestInfo.containsKey(nest.getId()))	{
			return;
		}
		// find row
		int row = -1;
		for(int i = this.getRowCount() -1; i>= 0; i--)	{
			if((Integer)this.getValueAt(i, 0) == nest.getId())	{
				row = i;
				break;
			}
		}
		if(row != -1)
			this.removeRow(row);
	}
	
	/**
	 * returns a nest for a given row
	 * @param row
	 * @return
	 */
	public Nest getNestForRow(int row)	{
		return nestInfo.get(this.getValueAt(row, 0));
	}
	
}
