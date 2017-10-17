	package figuras;
	
	public class Cuadrado extends Figura{
		private double lado;
	
		public Cuadrado(String titulo, Clor color, double lado) {
			super(titulo, color);
			this.lado = lado;
		}
	
		@Override
		public String toString() {
			return super.toString() + " [lado=" + lado + ", perimetro=" + perimetro() + ", area=" + area() + "]";
		}
	
		public double getLado() {
			return lado;
		}
	
		public void setLado(int lado) {
			this.lado = lado;
		}
	
		@Override
		public double area() {
			// TODO Auto-generated method stub
			return Math.pow(lado, 2);
		}
	
		@Override
		public double perimetro() {
			// TODO Auto-generated method stub
			return (lado * 4);
		}
	
	
	}
