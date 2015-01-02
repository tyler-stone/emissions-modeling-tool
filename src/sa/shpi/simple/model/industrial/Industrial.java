/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.simple.model.industrial;

import java.util.EnumSet;

import sa.shpi.simple.model.Material;
import sa.shpi.simple.model.Model;
import sa.shpi.simple.model.warehouse.Purpose;
import sa.shpi.simple.visual.Form;
import sa.shpi.simple.visual.industrial.DataEntryForm;

public class Industrial extends Model {

	/**
	 * Industrial model class
	 */

	// possible structural materials
	public static EnumSet<Material> Structure = EnumSet.of(Material.CONCRETE,
			Material.WOOD, Material.GALVANIZED_IRON, Material.OTHER);

	private DataEntryForm dataForm;

	private static final double heightPerFloor = 3.0; // meters

	private Material structureMaterial;
	private Purpose purpose;
	private int numFloors;

	public Industrial() {
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
		return calculateStructure() + calculateContents();
	}

	private double calculateStructure() {
		double result = 0.0;

		// if structure is wood or other, add the wood density
		// (wood is the only material that burns in this case)
		// (other overestimates by using wood)
		if (structureMaterial == Material.WOOD) {
			result += 29.29;
		} else if (structureMaterial == Material.OTHER) {
			result += 29.29;
		}

		// (kg/m^2) * (kg CO2/kg material) * (m^2) = kg CO2
		return result * Material.WOOD.getEmissionsFactor() * areaBurned;
	}

	private double calculateContents() {
		double totalHeight = heightPerFloor * numFloors; // height of building
		double volume = totalHeight * areaBurned;
		// (kg/m^3) * (kg CO2/kg material) * (m^3) = kg CO2
		return purpose.getDensity() * purpose.getEmissionsFactor() * volume;
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

	public int getNumFloors() {
		return numFloors;
	}

	public void setNumFloors(int numFloors) {
		this.numFloors = numFloors;
	}

}
