/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.ViewDesign;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Bhop
 */
public class Table extends JTable{

    public Table() {
        
        
        setShowGrid(true);
        setGridColor(Color.white);
        setRowHeight(40);
        //setEnabled(true);
        //getTableHeader().setReorderingAllowed(false);
        setFocusable(false);
        getTableHeader().setDefaultRenderer(new TableDarkHeader());
        setDefaultRenderer(Object.class, new TableDarkCell());
        setForeground(Color.white);
        
        
        
        /*
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(value+"");
                if(column == 4){
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                
                
                return header;
            }
            
        });
        */
        /*
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if(column != 4){
                    Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    //com.setBackground(Color.white);
                    //setBorder(noFocusBorder);
                    if(isSelected){
                        com.setForeground(Color.green);
                    }else{
                        com.setForeground(Color.black);
                    }
                    return com;
                }
                return new JLabel("Test");
            }
            
        });
        */
        
    }
    private class TableDarkHeader extends DefaultTableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            com.setBackground(new Color(30,30,30));
            com.setForeground(Color.white);
            com.setFont(com.getFont().deriveFont(Font.BOLD, 12));
            
            return com;
        }
            
        }
    
    private class TableDarkCell extends DefaultTableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
            if(isCellSelected(row, column)){
                if(row %2 == 0){
                    com.setBackground(new Color(33,103,153));
                }else{
                    com.setBackground(new Color(29,86,127));
                }
            }else{
                if(row %2 == 0){
                    com.setBackground(new Color(50,50,50));
                }else{
                    com.setBackground(new Color(30,30,30));
                }
                setGridColor(Color.white);
                setShowGrid(true);
            }
            setGridColor(Color.white);
            setShowGrid(true);
            return com;
        }
        
    }
    public void fixTable(JScrollPane scrollPane){
        scrollPane.setVerticalScrollBar(new ScrollBar());
    }
    
}
