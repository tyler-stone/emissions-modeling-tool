/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.simple.model;

/**
 * The possible materials and their corresponding emissions factors
 */
public enum Material {
	CONCRETE("Concreto", 0.0), WOOD("Madera", 1.27), GYPSUM("Yeso", 0.3), GALVANIZED_IRON(
			"Hierro", 0.0), CERAMIC("Ceramica", 0.0), PLASTIC("Plastico", 2.3), OTHER(
			"Otro", 0.0), NO_DATA("No Hay", 1.27);

	private String displayName;
	private double emissionsFactor;

	Material(String displayName, double emissionsFactor) {
		this.displayName = displayName;
		this.emissionsFactor = emissionsFactor;
	}

	@Override
	public String toString() {
		return displayName;
	}

	public double getEmissionsFactor() {
		return emissionsFactor;
	}
}
