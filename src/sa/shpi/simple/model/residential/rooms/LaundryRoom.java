/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.simple.model.residential.rooms;

import sa.shpi.simple.model.residential.ResidentialRoom;

public class LaundryRoom extends ResidentialRoom {

	public LaundryRoom() {
		this.weight = 104;
		this.percentWood = 0.0;
	}

	@Override
	public String toString() {
		return "Lavandero";
	}
}
