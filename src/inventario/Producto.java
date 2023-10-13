package inventario;
/**
 * Entidad Producto que haga parte de un inventario cualquiera.
 * @author PedroArango
 *
 */
public class Producto {
	
	private String nombre;
	private double precioUnitario;
	private int unidadesExistentes;
	private int unidadesVendidas;
	private double valorVenta;
	
	public Producto(String nombre, double precioUnitario, int unidadesExistentes, int unidadesVendidas,
			double valorVenta) {
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
		this.unidadesExistentes = unidadesExistentes;
		this.unidadesVendidas = unidadesVendidas;
		this.valorVenta = valorVenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getUnidadesExistentes() {
		return unidadesExistentes;
	}

	public void setUnidadesExistentes(int unidadesExistentes) {
		this.unidadesExistentes = unidadesExistentes;
	}


	public int getUnidadesVendidas() {
		return unidadesVendidas;
	}

	public void setUnidadesVendidas(int unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}

	public double getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}


	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precioUnitario=" + precioUnitario + ", unidadesExistentes="
				+ unidadesExistentes + ", unidadesVendidas=" + unidadesVendidas + ", valorVenta=" + valorVenta + "]";
	}

}
