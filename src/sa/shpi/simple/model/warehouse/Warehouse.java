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

import java.util.EnumSet;

import sa.shpi.simple.model.Material;
import sa.shpi.simple.model.Model;
import sa.shpi.simple.visual.Form;
import sa.shpi.simple.visual.warehouse.DataEntryForm;

public class Warehouse extends Model {
	
	/**
	 * Warehouse model class
	 */

	public static EnumSet<Material> Structure = EnumSet.of(Material.CONCRETE,
			Material.WOOD, Material.GALVANIZED_IRON, Material.OTHER,
			Material.NO_DATA);

	private static final double doublePaletteWidth = 1.8; // meters
	private static final double shelfHeight = 1.2; // meters
	private static final double stdFloorHeight = 3; // meters

	private DataEntryForm dataForm;

	private Purpose purpose;
	private Material structureMaterial;

	private int numShelves = 1;
	private int numShelfLevels = 1;

	public Warehouse() {
		try {
			dataForm = new DataEntryForm(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void startModel(Form previousForm) {
		dataForm.setPreviousForm(previousForm);
		dataForm.show();
	}

	@Override
	public double evaluateEmissions() {
		//length of shelf with default calculations to 
		// account for space between shelves
		// to make things easier, the building dimensions are treated as totalArea meters * 1 meter = m^2
		double lengthOfShelf = totalArea
				- ((2 * doublePaletteWidth) * numShelves);

		//calculate volume of the shelves
		double totalVolume = lengthOfShelf * doublePaletteWidth
				* numShelfLevels * numShelves;

		//multiply the density (kg/m^3) * (m^3)
		double totalWeight = purpose.getDensity() * totalVolume;

		double percentBurned = (double) areaBurned / totalArea;

		// total CO2
		return totalWeight * purpose.getEmissionsFactor() * percentBurned;
	}

	public Purpose getPurpose() {
		return purpose;
	}

	public void setPurpose(Purpose purpose) {
		this.purpose = purpose;
	}

	public Material getStructureMaterial() {
		return structureMaterial;
	}

	public void setStructureMaterial(Material structureMaterial) {
		this.structureMaterial = structureMaterial;
	}

	public int getNumShelves() {
		return numShelves;
	}

	public void setNumShelves(int numShelves) {
		this.numShelves = numShelves;
	}

	public int getNumShelfLevels() {
		return numShelfLevels;
	}

	public void setNumShelfLevels(int numShelfLevels) {
		this.numShelfLevels = numShelfLevels;
	}
}
