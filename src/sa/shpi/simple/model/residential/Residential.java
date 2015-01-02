/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.simple.model.residential;

import java.util.EnumSet;
import java.util.Iterator;

import sa.shpi.simple.model.Material;
import sa.shpi.simple.model.Model;
import sa.shpi.simple.model.Room;
import sa.shpi.simple.visual.Form;
import sa.shpi.simple.visual.residential.StructureForm;

public class Residential extends Model {

	/**
	 * Residential model class
	 */

	// define available materials for various structural areas

	public static EnumSet<Material> ExternalWalls = EnumSet.of(
			Material.CONCRETE, Material.WOOD, Material.GYPSUM,
			Material.GALVANIZED_IRON, Material.OTHER, Material.NO_DATA);

	public static EnumSet<Material> InternalWalls = EnumSet.of(
			Material.CONCRETE, Material.WOOD, Material.GYPSUM,
			Material.GALVANIZED_IRON, Material.OTHER, Material.NO_DATA);

	public static EnumSet<Material> Ceiling = EnumSet.of(
			Material.GALVANIZED_IRON, Material.WOOD, Material.GYPSUM,
			Material.OTHER, Material.NO_DATA);

	public static EnumSet<Material> Roofing = EnumSet.of(
			Material.GALVANIZED_IRON, Material.WOOD, Material.GYPSUM,
			Material.OTHER, Material.NO_DATA);

	public static EnumSet<Material> Flooring = EnumSet.of(Material.CERAMIC,
			Material.WOOD, Material.CONCRETE, Material.OTHER, Material.NO_DATA);

	private StructureForm structureForm;

	private Material externalWalls;
	private Material internalWalls;
	private Material ceiling;
	private Material roofing;
	private Material flooring;

	public Residential() {
		try {
			structureForm = new StructureForm(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void startModel(Form previousForm) {
		structureForm.setPreviousForm(previousForm);
		structureForm.show();
	}

	public Material getExternalWalls() {
		return externalWalls;
	}

	public void setExternalWalls(Material externalWalls) {
		this.externalWalls = externalWalls;
	}

	public StructureForm getStructureForm() {
		return structureForm;
	}

	public void setStructureForm(StructureForm structureForm) {
		this.structureForm = structureForm;
	}

	public Material getInternalWalls() {
		return internalWalls;
	}

	public void setInternalWalls(Material internalWalls) {
		this.internalWalls = internalWalls;
	}

	public Material getCeiling() {
		return ceiling;
	}

	public void setCeiling(Material ceiling) {
		this.ceiling = ceiling;
	}

	public Material getRoofing() {
		return roofing;
	}

	public void setRoofing(Material roofing) {
		this.roofing = roofing;
	}

	public Material getFlooring() {
		return flooring;
	}

	public void setFlooring(Material flooring) {
		this.flooring = flooring;
	}

	public double evaluateEmissions() {
		// calculate kg burned for contents and structure
		double totalContents = calculateContents()
				* Material.WOOD.getEmissionsFactor();

		double totalStrucutre = calculateStructure()
				* Material.WOOD.getEmissionsFactor();
		// multiply that by the emissions factor
		return totalContents + totalStrucutre;
	}

	private double calculateContents() {

		double result = 0.0;

		double areaPerRoom = totalArea / rooms.size();
		double scaler = rooms.getDamageScaler();

		Iterator<Room> iter = rooms.iterator();

		while (iter.hasNext()) {
			ResidentialRoom currentRoom = (ResidentialRoom) iter.next();
			// (kg material) * scalar * % damage
			result += (currentRoom.getWeight()) * scaler
					* currentRoom.getPercentDamage();
		}

		return result;
	}

	private double calculateStructure() {
		double result = 0.0;

		// density for wood in different structural locations (kg/m^2)
		if (externalWalls == Material.WOOD) {
			result += 18.75;
		}

		if (internalWalls == Material.WOOD) {
			result += 18.75;
		}

		if (ceiling == Material.WOOD) {
			result += 29.29;
		}

		if (roofing == Material.WOOD) {
			result += 8.642;
		}

		if (flooring == Material.WOOD) {
			result += 8.642;
		}

		return result * areaBurned;
	}
}
