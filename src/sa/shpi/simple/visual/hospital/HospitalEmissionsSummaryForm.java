/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.simple.visual.hospital;

import javax.swing.JList;

import sa.shpi.advanced.model.Strings;
import sa.shpi.simple.model.hospital.Hospital;
import sa.shpi.simple.model.hospital.rooms.GeneralStorage;
import sa.shpi.simple.model.hospital.rooms.Office;
import sa.shpi.simple.model.hospital.rooms.PTRoom;
import sa.shpi.simple.model.hospital.rooms.RecordsStorage;
import sa.shpi.simple.visual.EmissionsSummaryForm;

public class HospitalEmissionsSummaryForm extends EmissionsSummaryForm {

	public HospitalEmissionsSummaryForm(Hospital model) {
		super(model);
	}

	@Override
	public void generateSummary() {
		String[] summary = {
				"Hospital ------------------------------------------------------------------------------------------------",
				Strings.AREA_TOTAL.toString() + ": " + model.getTotalArea(),
				Strings.AREA_BURNED.toString() + ": " + model.getAreaBurned(),
				Strings.STRUCTURE.toString()
						+ " -----------------------------------------------------------------------------------------------",
				"No combustible",
				Strings.CONTENT.toString()
						+ " -------------------------------------------------------------------------------------------------",
				"Almacenamiento general: "
						+ model.getRoomList().countRooms(GeneralStorage.class),
				"Oficina: " + model.getRoomList().countRooms(Office.class),
				"Habitaciónes para pacientes: "
						+ model.getRoomList().countRooms(PTRoom.class),
				"Almacenamiento de registros escritos: "
						+ model.getRoomList().countRooms(RecordsStorage.class) };

		summaryList = new JList<String>(summary);
	}

}
