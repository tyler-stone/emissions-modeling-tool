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

import java.util.ArrayList;

import sa.shpi.advanced.model.EmissionsItem;

/**
 * Material list used to keep track of the number of used materials in a room
 * @author Tyler
 *
 */
public class MaterialList extends ArrayList<UsedMaterial> {
	private static final long serialVersionUID = 1L;

	public MaterialList() {

	}

	public String getUnits() {
		return "kg/m^2";
	}

	public int percentSum() {
		int total = 0;

		for (UsedMaterial m : this) {
			total += m.getPercent();
		}

		return total;
	}

	public void add(EmissionsItem mat, int percentage) {
		this.add(new UsedMaterial(percentage, mat));
	}
}
