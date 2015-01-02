/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.simple.visual.industrial;

import javax.swing.JList;

import sa.shpi.advanced.model.Strings;
import sa.shpi.simple.model.industrial.Industrial;
import sa.shpi.simple.visual.EmissionsSummaryForm;

public class IndustrialEmissionsSummaryForm extends EmissionsSummaryForm {

	public IndustrialEmissionsSummaryForm(Industrial model) {
		super(model);
	}

	@Override
	public void generateSummary() {
		String[] summary = {
				"Sitio Industrial ----------------------------------------------------------------------------------------------",
				Strings.AREA_TOTAL.toString() + ": " + model.getTotalArea(),
				Strings.AREA_BURNED.toString() + ": " + model.getAreaBurned(),
				"Número de pisos: " + ((Industrial) model).getNumFloors(),
				Strings.STRUCTURE.toString()
						+ " -----------------------------------------------------------------------------------------------",
				((Industrial) model).getStructureMaterial().toString(),
				"Propósito -------------------------------------------------------------------------------------------------",
				((Industrial) model).getPurpose().toString() };

		summaryList = new JList<String>(summary);
	}

}
