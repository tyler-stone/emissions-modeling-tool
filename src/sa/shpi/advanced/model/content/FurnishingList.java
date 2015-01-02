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

import java.util.ArrayList;

import sa.shpi.advanced.model.EmissionsItem;

/**
 * Furnishing list used to keep track of the number of used furnishings in a room
 * @author Tyler
 *
 */
public class FurnishingList extends ArrayList<UsedFurnishing> {
	private static final long serialVersionUID = 1L;

	public FurnishingList() {

	}

	public String getUnits() {
		return "kg";
	}

	public void add(EmissionsItem furnishing, int quantity) {
		this.add(new UsedFurnishing(quantity, furnishing));
	}
}
