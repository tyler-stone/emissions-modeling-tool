/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.advanced;

import java.util.ArrayList;

import sa.shpi.advanced.model.Residential;
import sa.shpi.advanced.model.content.FurnishingLibrary;
import sa.shpi.advanced.model.structure.MaterialsLibrary;
import sa.shpi.advanced.visual.AdvancedMainForm;

/**
 * Main entry point for the advanced model
 * @author Tyler
 *
 */
public class AdvancedTool {

	private AdvancedMainForm mainForm;
	private Residential residential;

	private MaterialsLibrary materialsLibrary;
	private FurnishingLibrary furnishingsLibrary;

	public AdvancedTool() {
		mainForm = new AdvancedMainForm(this);
		residential = new Residential();

		setMaterialsLibrary(new MaterialsLibrary());
		setFurnishingsLibrary(new FurnishingLibrary());
	}

	public void setResidential(Residential res) {
		this.residential = res;
	}

	public Residential getResidential() {
		return residential;
	}

	public AdvancedMainForm getForm() {
		return mainForm;
	}

	public void startAdvancedTool() {
		mainForm.getFrame().setVisible(true);
	}

	public FurnishingLibrary getFurnishingsLibrary() {
		return furnishingsLibrary;
	}

	public void setFurnishingsLibrary(FurnishingLibrary furnishingsLibrary) {
		this.furnishingsLibrary = furnishingsLibrary;
	}

	public MaterialsLibrary getMaterialsLibrary() {
		return materialsLibrary;
	}

	public void setMaterialsLibrary(MaterialsLibrary materialsLibrary) {
		this.materialsLibrary = materialsLibrary;
	}
}
