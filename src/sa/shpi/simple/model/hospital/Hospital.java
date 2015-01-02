/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.simple.model.hospital;

import java.util.Iterator;

import sa.shpi.simple.model.Model;
import sa.shpi.simple.model.Room;
import sa.shpi.simple.visual.Form;
import sa.shpi.simple.visual.hospital.DataEntryForm;

public class Hospital extends Model {

	/**
	 * Hospital model class
	 */

	private DataEntryForm dataForm;

	public Hospital() {
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

		double result = 0.0;

		// area burned is divided by the number of rooms to get equal area per
		// room
		double areaPerRoom = areaBurned / rooms.size();
		// scaler to normalize the damage percentage to the rest of the model
		double scaler = rooms.getDamageScaler();

		Iterator<Room> iter = rooms.iterator();

		// go through each room
		while (iter.hasNext()) {
			HospitalRoom currentRoom = (HospitalRoom) iter.next();

			// calculate the fuel loading
			// (kg/m^2) * (m^2) * scaler * % = kg fuel loading
			double fuelLoading = currentRoom.getWeight() * areaPerRoom * scaler
					* currentRoom.getPercentDamage();

			// kg fuel loading * kg CO2/kg material = kg CO2
			result += fuelLoading * currentRoom.getEmissionsFactor();
		}

		return result;
	}
}
