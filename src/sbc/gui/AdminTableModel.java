package sbc.gui;

import java.util.HashMap;

import sbc.model.Nest;

class AdminTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 3991453504010360535L;

	private HashMap<Integer, Nest> nestInfo = new HashMap<Integer, Nest>();

	public void addRow(Nest nest)	{
		String status = (nest.isShipped() ? "shipped" : "shipping");
		if(!nestInfo.containsKey(nest.getId()))	{
			nestInfo.put(nest.getId(), nest);
			this.addRow(new Object[]{nest.getId(), nest.getEgg1().getId(), nest.getEgg2().getId(), nest.getBuilder_id(), nest.getShipper_id(), status});
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
		
		// egg1 id
		setValueAt(nest.getEgg1().getId(), row, 1);
		// egg2 id
		setValueAt(nest.getEgg2().getId(), row, 2);
		// builder id
		setValueAt(nest.getBuilder_id(), row, 3);
		// shipper id
		setValueAt(nest.getShipper_id(), row, 4);
		// status
		setValueAt(status, row, 5);
		
		nestInfo.put(nest.getId(), nest);
	}

	public Nest getNestForRow(int row)	{
		return nestInfo.get(this.getValueAt(row, 0));
	}

}