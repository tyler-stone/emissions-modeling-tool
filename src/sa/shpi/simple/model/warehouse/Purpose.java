/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.simple.model.warehouse;

import sa.shpi.simple.model.Material;

/**
 * Possible general purposes for warehouse and industrial sites
 */
public enum Purpose {
	ELECTRONICS("Electrodomésticos", 2.29, 1360), 
	FURNITURE("Muebles", 1.5, 630), 
	CLOTHING("Ropa", 2.2, 1540), 
	CONSTRUCTION("Materiales de construcción", Material.WOOD.getEmissionsFactor(), 630), // , , kg/m^3
	FOOD("Comida", 1.33, 870), 
	MIXED_PURPOSE("Propósito mixto", 1.72, 1100), 
	OTHER("Otro", 2.29, 1540);

	private String displayName;
	private double emissionsFactor;
	private double density;

	Purpose(String displayName, double emissionsFactor, double density) {
		this.displayName = displayName;
		this.emissionsFactor = emissionsFactor;
		this.density = density;
	}

	@Override
	public String toString() {
		return displayName;
	}

	public double getEmissionsFactor() {
		return emissionsFactor;
	}

	public double getDensity() {
		return density;
	}
}
