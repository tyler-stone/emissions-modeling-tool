/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.simple.model.hospital.rooms;

import sa.shpi.simple.model.Material;
import sa.shpi.simple.model.hospital.HospitalRoom;

public class GeneralStorage extends HospitalRoom {

	public GeneralStorage() {
		this.weight = 46.5;
		this.emissionsFactor = Material.PLASTIC.getEmissionsFactor();
	}

	@Override
	public String toString() {
		return "Almacenamiento general";
	}
}
