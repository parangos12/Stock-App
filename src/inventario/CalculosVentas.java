package inventario;

import java.util.Scanner;
/**
 * Clase que realiza diversos calculos para un inventario. El alcance de tiempo es diario.
 * @author PedroArango
 *
 */
public class CalculosVentas {

	//Simulamos una BBDD
	private  Producto[] productos= {
			new Producto("robot aspirador",1000,50,0,0),
			new Producto("robot cocina",2000,50,0,0),
			new Producto("localizador bluetooth",3000,50,0,0),
			new Producto("interruptor inteligente",4000,50,0,0),
			new Producto("asistente virtual",5000,50,0,0),
			new Producto("cámara de seguridad",6000,50,0,0),
			new Producto("smartwatch",7000,50,0,0)};
	
	public CalculosVentas() {  
	}
	/**
	 * Metodo para ingresar unidades extra a las ya existentes de un producto que haga parte del inventario.
	 * Este metodo solo puede recibir números enteros. No se aceptan decimales o caracteres extraños.
	 */
	public void ingresarUnidadesExistentes() {
		Scanner reader=new Scanner(System.in);
		System.out.println("Ingrese el nombre del producto: ");
		String producto=reader.nextLine();
		if(existeXNombre(producto)) {
			System.out.println("Ingrese unidades extra del producto");
			int unidadesExtra=digitarCantVendidas();
			for (int i = 0; i < productos.length; i++) {
				if(productos[i].getNombre().equalsIgnoreCase(producto)) {
					int unidadesNuevas=productos[i].getUnidadesExistentes()+unidadesExtra;
					productos[i].setUnidadesExistentes(unidadesNuevas);
					System.out.println("El producto "+producto+" tiene "+unidadesNuevas+" unidades nuevas");
					break; //ahorrar recursos.
				}
			}
		}else {
			System.out.println("El producto "+producto+" no existe.");
		}
	}
	
	/**
	 * Metodo para ingresar ventas de un producto que haga parte del inventario.
	 * Lanza una excepción si el producto está agotado o está tratando de sacar más unidades de las existentes.
	 * Este metodo solo puede recibir números enteros. No se aceptan decimales o caracteres extraños.
	 */
	public  void ingresarVentasXProducto() {
		Scanner reader=new Scanner(System.in);
		System.out.println("Ingrese el nombre del producto que quiere realizar las ventas: ");
		String producto=reader.nextLine();
		if(existeXNombre(producto)) {
			System.out.println("Ingrese ventas del producto "+producto);
			int ventas=digitarCantVendidas();
			for (int i = 0; i < productos.length; i++) {
				if(productos[i].getNombre().equalsIgnoreCase(producto)) {
					if(ventas>productos[i].getUnidadesExistentes()) {
						System.out.println("Lo sentimos, el producto "+producto+" solo tiene "+productos[i].getUnidadesExistentes()+
								" y estás tratando de sacar "+ventas);
					}else {
						int ventasNuevas=productos[i].getUnidadesVendidas()+ventas;
						productos[i].setUnidadesVendidas(ventasNuevas);
						int unidadesNuevas=productos[i].getUnidadesExistentes()-ventas;
						productos[i].setUnidadesExistentes(unidadesNuevas);
						double precioUnitarioProducto=productos[i].getPrecioUnitario();
						productos[i].setValorVenta(ventas*precioUnitarioProducto);
						System.out.println("Existencias actuales del producto "+productos[i].getNombre()+" : "+unidadesNuevas);
					}
				}
			}
		}else {
			System.out.println("EL producto "+producto+" no existe en el inventario papu");
		}
	}

	/**
	 * Metodo que lista los productos cuyas existencias sean mayores a 10.
	 */
	public void listadoExistenciasMayoraN() {
		System.out.println("--------LISTADO DE PRODUCTOS CUYAS EXISTENTAS ACTUALES SON MAYORES A 10-------");
		for (int i = 0; i < productos.length; i++) {
			if(productos[i].getUnidadesExistentes()>10) {
				System.out.println("Producto: "+productos[i].getNombre()+" Existencias: "+productos[i].getUnidadesExistentes());
			}
		}
	}
	
	/**
	 * Metodo que lista los productos agotados, es decir, cuyas unidades en el inventario sean inexistentes.
	 */
	public void listadoProductosAgotados() {
		int nProductosAgotados=0;
		System.out.println("------------LISTADO DE PRODUCTOS AGOTADOS----------");
		for (int i = 0; i < productos.length; i++) {
			if(productos[i].getUnidadesExistentes()==0) {
				System.out.println("Producto: "+productos[i].getNombre()+" Existencias: "+productos[i].getUnidadesExistentes());
				nProductosAgotados++;
			}
		}
		if(nProductosAgotados==0) {
			System.out.println("NO EXISTE PRODUCTOS AGOTADOS");
		}
	}

	/**
	 * Metodo que lista los productos, unidades existentes, ventas y el valor de las mismas.
	 */
	public void listadoTotalVentas() {
		System.out.println("----------LISTADO DE VENTAS DIARIAS X PRODUCTO----------");
		for (int i = 0; i < productos.length; i++) {
			System.out.println(productos[i].toString());
		}
	}
	
	/**
	 * Metodo que lista el producto que obtuvó la mayor y la menor venta.
	 */
	public void productoMayorMenorVenta() {
		Producto productoMayorVenta=productos[0];
		Producto productoMenorVenta=productos[0];
		//Ciclo para Mayor venta
		for (int i = 0; i < productos.length; i++) {
			if(productos[i].getValorVenta()>productoMayorVenta.getValorVenta()) {
				productoMayorVenta=productos[i];
			}else if(productos[i].getValorVenta()<productoMenorVenta.getValorVenta()) {
				productoMenorVenta=productos[i];
			}
		}
		System.out.println("PRODUCTO MÁS VENDIDO: "+productoMayorVenta.toString());
		System.out.println("PRODUCTO MENOS VENDIDO: "+productoMenorVenta.toString());

	}
	
	/**
	 * Metodo que valida que la cantidad de unidades vendidas o ingresadas de un producto sea valida.
	 * @return el numero correcto y validado de cantidades vendidas.
	 */
	public int digitarCantVendidas() {
		int numeroEntero;
		Scanner reader=new Scanner(System.in);
		while(true) {
		try {
			numeroEntero=reader.nextInt();
			if(numeroEntero<0) {System.out.println("Cantidad vendida no puede ser negativa. Ingresa nuevamente");}
			else break;
		}catch(Exception e) {
			System.out.println("Haz ingresado caracteres invalidos, por favor ingresa la cantidad vendida con números enteros");
			reader.nextLine();}}
		return numeroEntero;}
	
	/**
	 * Meotod que recibe como parametro el producto y verifica en la base de datos (en este caso un array) de que si exista
	 * antes de empezar a realizar cualquier modificacion.
	 * @param producto
	 * @return true si existe el producto en la BBDD, de lo contrario retorna false.
	 */
	public boolean existeXNombre(String producto) {
		for (int i = 0; i < productos.length; i++) {
			if(productos[i].getNombre().equalsIgnoreCase(producto)) {
				return true;
			}
		}
		return false;
	}


}
