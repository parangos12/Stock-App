package inventario;

import java.util.*;
/**
 * PROGRAMA PARA EL CALCULO Y MANEJO DE INVENTARIO.
 * Clase que el vendedor del producto desea ejecutar.
 * @author PedroArango
 *ANY COMMENTS OR SUGGESTIONS, PLEASE CONTACT ME.sss
 */
public class Main {
	
	private static Scanner reader=new Scanner(System.in);
	private static int opcion=0;

	public static void main(String[] args) {
		menu();
	}
	
	/**
	 * Despliega el Menú al vendedor.
	 */
	public static void menu() {
		CalculosVentas ventas=new CalculosVentas();
		while(opcion!=7) {
			System.out.println("-----------------MENÚ--------------");
			System.out.println("(Opción 1) Ingresar nuevas unidades existentes por producto");
			System.out.println("(Opción 2) Ingresar ventas por producto");
			System.out.println("(Opción 3) Imprimir listado de existencias actuales superiores a 10 productos");
			System.out.println("(Opción 4) Imprimir listado de productos agotados");
			System.out.println("(Opción 5) Imprimir listado total de ventas");
			System.out.println("(Opción 6) Imprimir producto con mayor venta y menor venta");
			System.out.println("(Opción 7) Salir del Menú");
			System.out.println("Ingrese el número de la opción que desea acceder: ");
			digitarOpcion();
			if(opcion==1) {ventas.ingresarUnidadesExistentes();}
			else if(opcion==2) {ventas.ingresarVentasXProducto();}
			else if(opcion==3) {ventas.listadoExistenciasMayoraN();}
			else if(opcion==4) {ventas.listadoProductosAgotados();}
			else if(opcion==5) {ventas.listadoTotalVentas();}
			else if(opcion==6) {ventas.productoMayorMenorVenta();}
			else if(opcion==7) {System.out.println("Fue un placer!!! ");break;		}
			System.out.println("¿Desea continuar navegando en el menú? Digite 0 para Si o 1 para No: ");
			digitarOpcionContinuar();
			}
	}
	/**
	 * Para validar las opciones que tiene para escoger el usuario.
	 */
	public static void digitarOpcion() {
		while(true) {
		try {
			opcion=reader.nextInt();
			if(opcion<1 ||opcion>6) System.out.println("Haz ingresado una opción fuera del alcance. Ingresa nuevamente ");
			else break;
		}catch(Exception e) {
			System.out.println("Haz ingresado caracteres invalidos, por favor ingresa el número de la Opción que quieres ingresa (1-7)");
			reader.nextLine();}}}
		
	
/**
 * Para validar las opciones que tiene para escoger el usuario.
 */
	public static void digitarOpcionContinuar() {
		while(true) {
		try {
			opcion=reader.nextInt();
			if(opcion<1 ||opcion>2) System.out.println("Haz ingresado una opción fuera del alcance. Ingresa nuevamente entre 1 y 2");
			if(opcion==1) {opcion=7; System.out.println("Fue un placer!!!. Hasta la próxima"); break;}
			else break;
		}catch(Exception e) {
			System.out.println("Haz ingresado caracteres invalidos, por favor ingresa el número de la Opción que quieres ingresa (1-7)");
			reader.nextLine();
		}
	}
}
	
}
