package sbc.gui.tablemodels;

import sbc.model.Nest;

public class AdminTableModel extends DefaultNestTableModel {
	private static final long serialVersionUID = 3991453504010360535L;

	/**
	 * adds or updates a nest to the table
	 * @param nest
	 */
	@Override
	public void addRow(Nest nest)	{
		if(nest.hasError())	{
			this.removeRow(nest);
			return;
		}
		String status = (nest.isTested() ? 
							(nest.isShipped() ? "completed" : "shipping")
							: "testing");
		
		if(!nestInfo.containsKey(nest.getIdAsString()))	{
			nestInfo.put(nest.getIdAsString(), nest);
			this.addRow(new Object[]{nest.getIdAsString(), nest.getEgg1().getIdAsString(), nest.getEgg2().getIdAsString(), nest.getRabbit().getIdAsString(), status});
			return;
		}
		
		int row = -1;
		for(int i = this.getRowCount() -1; i>= 0; i--)	{
			if(this.getValueAt(i, 0).equals(nest.getIdAsString()))	{
				row = i;
				break;
			}
		}
		
		if(row == -1)	{
			System.out.println("ERROR: element not found! (should be present)");
			return;
		}
		
		// egg1 id
		setValueAt(nest.getEgg1().getIdAsString(), row, 1);
		// egg2 id
		setValueAt(nest.getEgg2().getIdAsString(), row, 2);
		// choco id
		setValueAt(nest.getRabbit().getIdAsString(), row, 3);
		// status
		setValueAt(status, row, 4);
		
		nestInfo.put(nest.getIdAsString(), nest);
	}

}