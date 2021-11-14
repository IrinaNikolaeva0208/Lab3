	package bsu.rfe.java.group10.lab3.Nikolaeva.varB5;
	
	import javax.swing.table.AbstractTableModel;
	
	@SuppressWarnings("serial")
	public class GornerTableModel extends AbstractTableModel {
		private Double[] coefficients;
		private Double from;
		private Double to;
		private Double step;
		public GornerTableModel(Double from, Double to, Double step,
		Double[] coefficients) {
			this.from = from;
			this.to = to;
			this.step = step;
			this.coefficients = coefficients;
		}
		
		public Double getFrom() {
			return from;
		}
		
		public Double getTo() {
			return to;
		}
		
		public Double getStep() {
			return step;
		}
		public int getColumnCount() {
			return 2;
		}
		
		public int getRowCount() {
			return new Double(Math.ceil((to-from)/step)).intValue()+1;
		}
		
		public Double getValueAt(int row, int col) {
			double x = from + step*row;
			if (col==0) {
				return x;
			} else {
				double r = 0;
				for(Double arg : coefficients) 
					r = r * x + arg;	
				return r;
			}
		}
		
		public String getColumnName(int col) {
			switch (col) {
			case 0:
				return "Значение X";
			default:
				return "Значение многочлена";
			}
		}
		
		public Class<?> getColumnClass(int col) {
			return Double.class;
		}
	
	}
