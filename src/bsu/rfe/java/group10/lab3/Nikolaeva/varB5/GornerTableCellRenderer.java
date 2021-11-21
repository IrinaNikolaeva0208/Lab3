	package bsu.rfe.java.group10.lab3.Nikolaeva.varB5;
	
	import java.awt.Color;
	import java.awt.Component;
	import java.awt.FlowLayout;
	import java.text.DecimalFormat;
	import java.text.DecimalFormatSymbols;
	import java.text.NumberFormat;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTable;
	import javax.swing.table.TableCellRenderer;
	
	public class GornerTableCellRenderer implements TableCellRenderer {
	
		private JPanel panel = new JPanel();
		private JLabel label = new JLabel();
		private String needle = null;
		private DecimalFormat formatter = (DecimalFormat)NumberFormat.getInstance();
		
		public GornerTableCellRenderer() {
			
			formatter.setMaximumFractionDigits(5);
			formatter.setGroupingUsed(false);
			DecimalFormatSymbols dottedDouble =	formatter.getDecimalFormatSymbols();
			dottedDouble.setDecimalSeparator('.');
			formatter.setDecimalFormatSymbols(dottedDouble);
			panel.add(label);
			panel.setLayout(new FlowLayout(FlowLayout.LEFT));
				   
		}
		
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
			
			if (col==2) {
				String str = value.toString();
                label.setText(str);
				panel.setBackground(Color.WHITE);
			}
			
			else {
				String formattedDouble = formatter.format(value);
			Double a = Double.parseDouble(formattedDouble);
			label.setText(formattedDouble);
			if (col==1 && needle!=null && needle.equals(formattedDouble)) {
				panel.setBackground(Color.RED);
			} else if (col == 1 && Digits(a))
				panel.setBackground(Color.GREEN);
			else panel.setBackground(Color.WHITE);
			}
			return panel;
			
		}
		
		private boolean Digits(Double a) {
			boolean noOtherDigits = true;
			boolean prevZero = true;
			int i = 0, m, n;
			a *= Math.pow(10, 5);
			n = a.intValue();
			while (i!=5) {
				m = n % 10;
				if (m == 0 && prevZero) {
					n/=10;
					i++;
					continue;
				}
				
				if (m != 1 && m != 3 && m != 5) {
					noOtherDigits = false;
					break;
				}
				
				n/=10;
				i++;
				prevZero = false;
			}
			
			if (prevZero) return false;
			return noOtherDigits;		
		}
		
		public void setNeedle(String needle) {
			this.needle = needle;
		}
		
	
	}
