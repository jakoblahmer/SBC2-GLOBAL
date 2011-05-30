package sbc.gui.tablemodels;

public class DefaultTableModel extends javax.swing.table.DefaultTableModel {
	private static final long serialVersionUID = 3991453504010360535L;

	public boolean isCellEditable(int row, int column)	{
		return false;
	}
}