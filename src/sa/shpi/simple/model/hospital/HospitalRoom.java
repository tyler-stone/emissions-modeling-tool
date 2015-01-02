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

import sa.shpi.simple.model.Room;
import sa.shpi.simple.visual.Form;

public class HospitalRoom extends Room {

	/**
	 * Base class for a Hospital room
	 */

	protected double emissionsFactor;

	public HospitalRoom() {
	}

	public HospitalRoom(String name, int damage, Form damageForm) {
		super(name, damage, damageForm);
	}

	public double getEmissionsFactor() {
		return emissionsFactor;
	}
}
