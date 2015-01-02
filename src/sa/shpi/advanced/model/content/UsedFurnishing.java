/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.advanced.model.content;

import sa.shpi.advanced.model.EmissionsItem;

/**
 * This class wraps a furnishing from the furnishing library and adds a quantity to the item
 * @author Tyler
 *
 */
public class UsedFurnishing {

	private int quantity;
	private EmissionsItem furnishing;

	public UsedFurnishing(int quantity, EmissionsItem furnishing) {
		this.quantity = quantity;
		this.furnishing = furnishing;
	}

	public UsedFurnishing() {
		furnishing = new EmissionsItem();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public EmissionsItem getFurnishing() {
		return furnishing;
	}

	public void setFurnishing(EmissionsItem furnishing) {
		this.furnishing = furnishing;
	}

	@Override
	public String toString() {
		return furnishing.getName() + " (" + quantity + ")";
	}

	public double calculateEmissions() {
		return quantity * furnishing.getMass()
				* furnishing.getEmissionsFactor();
	}
}
