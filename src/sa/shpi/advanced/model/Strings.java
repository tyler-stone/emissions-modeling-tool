/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.advanced.model;

/**
 * All Spanish strings used by the advanced model.
 * @author Tyler
 *
 */
public enum Strings {
	NEXT("Próximo"), BACK("Anterior"), NUEVO("Nuevo"), NUEVA("Nueva"), INSTRUCTION_TREE(
			"Haga click en \"Nueva residencial\" para empezar a medir las emisiones"), RESIDENTIAL(
			"Residencial"), STRUCTURE_ITEM("Material estructural"), AFFECTED_ROOM(
			"Área afectada"), CONTENT_ITEM("Muebles"), KITCHEN("Cocina"), BEDROOM(
			"Cuarto"), BATHROOM("Baño"), LIVING_SPACE("Sala de estar"), LAUNDRY_ROOM(
			"Lavandero"), DINING_ROOM("Comedor"), OTHER("Otro"), EXTERNAL_WALLS(
			"Paredes externas"), INTERNAL_WALLS("Paredes internas"), CEILING(
			"Cielo"), FLOORING("Piso"), ROOFING("Techo"), AREA_TOTAL(
			"Área total (m^2)"), AREA_BURNED("Área quemada (m^2)"), ADD(
			"Añadir"), CANCEL("Cancelar"), NEW_RESIDENTIAL("Nueva residencial"), NONE(
			"Ninguno"), ERROR_BASE("Por favor use los números para describir "), ERROR_BURNED_BIGGER(
			"Área quemada no puede ser más larga que la área total."), STRUCTURE(
			"La estructura"), CONTENT("El contenido"), PERCENT_OF_LOCATION(
			"El porcentaje de la ubicación"), DENSITY("La densidad"), EMISSIONS_FACTOR(
			"El factor de emisiones"), DETAILS("Los detalles"), CHOOSE("Escoja"), MATERIAL(
			"El material"), MATERIAL_LOCATION("La ubicación del material"), SELECT(
			"Elija"), MASS("La masa"), FURNISHING("Muebles"), NAME("Tipo"), NO_DATA(
			"No hay datos"), CHOOSE_FROM_LIST("Escoja de la lista"), CUSTOM(
			"Otro material"), PLEASE_CHOOSE("Por favor escoja"), ROOM("El área"), FURNITURE_ITEM(
			"El mueble"), ROOM_TYPE("Tipo de área"), QUANTITY_OF_ITEM(
			"La cantidad de muebles"), QUANTITY("Cantidad"), PERCENT_DAMAGE(
			"Porcentaje de daño"), DAMAGE("Daño"), RESET("Reiniciar"), EXIT(
			"Salir"), RUN("Ejecutar"), HELP("Ayuda"), ABOUT("Acerca de"), CREATE(
			"Crear"), EMISSIONS_TOTAL("Total de emisiones"), GENERATE_REPORT(
			"Generar reporte"), FILE("Archivo"), SUCCESSFUL_REPORT(
			"Reporte de las emisiones generado exitosamente"), RESIDENTIAL_EMISSIONS_CALCULATOR(
			"La calculadora de las emisiones de una residencia");

	private String displayString;

	private Strings(String displayString) {
		this.displayString = displayString;
	}

	@Override
	public String toString() {
		return displayString;
	}
}
