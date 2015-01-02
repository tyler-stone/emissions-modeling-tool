/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.advanced.model.structure;

import sa.shpi.advanced.model.EmissionsItem;

/**
 * This class wraps a material and stores the percent of the structural area with that material
 * @author Tyler
 *
 */
public class UsedMaterial {

	private int percent;
	private EmissionsItem material;

	public UsedMaterial(int percent, EmissionsItem material) {
		this.percent = percent;
		this.material = material;
	}

	public int getPercent() {
		return percent;
	}

	public double getPercentFraction() {
		return percent * 0.01;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public EmissionsItem getMaterial() {
		return material;
	}

	public void setMaterial(EmissionsItem material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return material.toString() + " - " + percent + "%";
	}

	public double calculateEmissions(double areaBurned) {
		return areaBurned * getPercentFraction() * material.getMass()
				* material.getEmissionsFactor();
	}
}
