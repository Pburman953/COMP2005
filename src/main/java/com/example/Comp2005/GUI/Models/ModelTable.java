package com.example.Comp2005.GUI.Models;

import javax.swing.table.DefaultTableModel;

public class ModelTable extends DefaultTableModel {
    public ModelTable(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Make all cells non-editable
    }
}