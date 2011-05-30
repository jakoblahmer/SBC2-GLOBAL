package sbc.gui.tablemodels;

import sbc.model.Nest;

public class ErrorTableModel extends DefaultNestTableModel {
	private static final long serialVersionUID = 3991453504010360535L;

	/**
	 * adds or updates a nest in the error table
	 * @param nest
	 */
	@Override
	public void addRow(Nest nest)	{
		String status = "defect";
		if(!nestInfo.containsKey(nest.getId()))	{
			nestInfo.put(nest.getId(), nest);
			this.addRow(new Object[]{nest.getId(), status});
			return;
		}
		
		int row = -1;
		for(int i = this.getRowCount() -1; i>= 0; i--)	{
			if((Integer)this.getValueAt(i, 0) == nest.getId())	{
				row = i;
				break;
			}
		}
		
		if(row == -1)	{
			System.out.println("ERROR: element not found! (should be present)");
			return;
		}
		
		// status
		setValueAt(status, row, 1);
		
		nestInfo.put(nest.getId(), nest);
	}

}