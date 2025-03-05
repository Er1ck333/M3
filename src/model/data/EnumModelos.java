/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model.data;

/**
 *
 * @author erickpaugar
 */
public enum EnumModelos {
    BOEING_737(31, 6),
    AIRBUS_A320(30, 6),
    AIRBUS_A330(46, 6),
    AIRBUS_A350(54, 6),
    BOEING_757(34, 6),
    BOEING_747(52, 8),
    AIRBUS_A380(52, 8);

    
    private final int rows;
    private final int columns;

    EnumModelos(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }


}
