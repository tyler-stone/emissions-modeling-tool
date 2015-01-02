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
 * A section describes a specific structural area of a residential building
 * @author Tyler
 *
 */
public class Section {
	private SectionCategory sectionCategory;
	private MaterialList materialList;

	public Section(SectionCategory sectionCategory) {
		this.sectionCategory = sectionCategory;
		materialList = new MaterialList();
	}

	public Section(SectionCategory sectionCategory, MaterialList materialList) {
		this.sectionCategory = sectionCategory;
		this.materialList = materialList;
	}

	public SectionCategory getSectionCategory() {
		return sectionCategory;
	}

	public MaterialList getMaterialList() {
		return materialList;
	}

	public void addMaterial(EmissionsItem material, int percent) {
		materialList.add(material, percent);
	}

	public void addMaterial(UsedMaterial uMaterial) {
		materialList.add(uMaterial);
	}

	public void deleteMaterial(EmissionsItem material) {
		materialList.remove(material);
	}

	public boolean hasMaterials() {
		if (materialList.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getPercentRemaining() {
		return (100 - materialList.percentSum());
	}

	public boolean isComplete() {
		if (getPercentRemaining() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public double calculateEmissions(double areaBurned) {
		double emissions = 0.0;

		if (!materialList.isEmpty()) {
			//for each material
			for (int count = 0; count < materialList.size(); count++) {
				//add the emissions result from the material
				emissions += materialList.get(count).calculateEmissions(
						areaBurned);
			}
		}

		return emissions;
	}

	@Override
	public String toString() {
		return sectionCategory.toString();
	}
}
