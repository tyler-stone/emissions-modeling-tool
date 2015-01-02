/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.simple.visual.warehouse;

import javax.swing.JList;

import sa.shpi.advanced.model.Strings;
import sa.shpi.simple.model.industrial.Industrial;
import sa.shpi.simple.model.warehouse.Warehouse;
import sa.shpi.simple.visual.EmissionsSummaryForm;

public class WarehouseEmissionsSummaryForm extends EmissionsSummaryForm {

	public WarehouseEmissionsSummaryForm(Warehouse model) {
		super(model);
	}

	@Override
	public void generateSummary() {
		String[] summary = {
				"Bodega ----------------------------------------------------------------------------------------------",
				Strings.AREA_TOTAL.toString() + ": " + model.getTotalArea(),
				Strings.AREA_BURNED.toString() + ": " + model.getAreaBurned(),
				Strings.STRUCTURE.toString()
						+ " -----------------------------------------------------------------------------------------------",
				((Warehouse) model).getStructureMaterial().toString(),
				"Propósito -------------------------------------------------------------------------------------------------",
				((Warehouse) model).getPurpose().toString(),
				"Estantería ------------------------------------------------------------------------------------------------",
				"# de estantes: " + ((Warehouse) model).getNumShelves(),
				"# niveles por estante: "
						+ ((Warehouse) model).getNumShelfLevels() };

		summaryList = new JList<String>(summary);
	}

}
