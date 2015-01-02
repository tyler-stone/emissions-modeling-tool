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
 * Class used by materials and furnishings
 * @author Tyler
 *
 */
public class EmissionsItem {

	String name;
	double emissionsFactor;
	double mass;

	public EmissionsItem() { }

	public EmissionsItem(String name, double emissionsFactor, double mass) {
		this.name = name;
		this.emissionsFactor = emissionsFactor;
		this.mass = mass;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmissionsFactor(double emissionsFactor) {
		this.emissionsFactor = emissionsFactor;
	}

	public double getEmissionsFactor() {
		return emissionsFactor;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public double getMass() {
		return mass;
	}

	@Override
	public String toString() {
		return name;
	}
}
