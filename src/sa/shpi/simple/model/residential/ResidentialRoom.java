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

import sa.shpi.simple.model.Room;
import sa.shpi.simple.visual.Form;

public abstract class ResidentialRoom extends Room {

	/**
	 * Base class for a residential room
	 */

	protected double percentWood;

	public ResidentialRoom() {

	}

	public ResidentialRoom(String name, int damage, Form damageForm) {
		super(name, damage, damageForm);
	}

	public double getKgWood() {
		return weight * percentWood;
	}
}
