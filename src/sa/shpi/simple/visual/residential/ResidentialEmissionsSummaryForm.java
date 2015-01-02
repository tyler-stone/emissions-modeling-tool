/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.simple.visual.residential;

import javax.swing.JList;

import sa.shpi.simple.model.residential.Residential;
import sa.shpi.simple.model.residential.rooms.Bathroom;
import sa.shpi.simple.model.residential.rooms.Bedroom;
import sa.shpi.simple.model.residential.rooms.DiningRoom;
import sa.shpi.simple.model.residential.rooms.Kitchen;
import sa.shpi.simple.model.residential.rooms.LaundryRoom;
import sa.shpi.simple.model.residential.rooms.LivingSpace;
import sa.shpi.simple.model.residential.rooms.Other;
import sa.shpi.simple.visual.EmissionsSummaryForm;

public class ResidentialEmissionsSummaryForm extends EmissionsSummaryForm {

	public ResidentialEmissionsSummaryForm(Residential model) {
		super(model);
	}

	public void generateSummary() {
		String[] summary = {
				"Edificio Residencial ------------------------------------------------------------------------------------",
				"Área Total: " + model.getTotalArea(),
				"Área Quemado: " + model.getAreaBurned(),
				"Estructura ----------------------------------------------------------------------------------------------",
				"Las Paredes Externas: "
						+ ((Residential) model).getExternalWalls(),
				"Las Paredes Internas: "
						+ ((Residential) model).getInternalWalls(),
				"Cielo: " + ((Residential) model).getCeiling(),
				"Piso: " + ((Residential) model).getFlooring(),
				"Techo: " + ((Residential) model).getRoofing(),
				"Los Contenidos ------------------------------------------------------------------------------------------",
				"Cocinas: " + model.getRoomList().countRooms(Kitchen.class),
				"Cuartos: " + model.getRoomList().countRooms(Bedroom.class),
				"Baños: " + model.getRoomList().countRooms(Bathroom.class),
				"Comedores: "
						+ model.getRoomList().countRooms(DiningRoom.class),
				"Salas de Estar: "
						+ model.getRoomList().countRooms(LivingSpace.class),
				"Lavanderos: "
						+ model.getRoomList().countRooms(LaundryRoom.class),
				"Otros: " + model.getRoomList().countRooms(Other.class) };

		summaryList = new JList<String>(summary);
	}
}
