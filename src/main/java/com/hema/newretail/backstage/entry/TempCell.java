package com.hema.newretail.backstage.entry;

import org.apache.poi.ss.usermodel.CellStyle;

public class TempCell {
    private int row;
    private int column;
    private CellStyle cellStyle;
    private Object data;
    //用于列表合并,表示几列合并
//    private int columnSize = -1;

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public CellStyle getCellStyle() {
        return cellStyle;
    }

    public void setCellStyle(CellStyle cellStyle) {
        this.cellStyle = cellStyle;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

//    public int getColumnSize() {
//        return columnSize;
//    }
//
//    public void setColumnSize(int columnSize) {
//        this.columnSize = columnSize;
//    }
}
