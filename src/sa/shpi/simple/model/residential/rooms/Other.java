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

public class Other extends ResidentialRoom {

	public Other() {
		this.weight = 104;
		this.percentWood = 0.3240;
	}

	@Override
	public String toString() {
		return "Otro";
	}
}
