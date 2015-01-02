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

public class RecordsStorage extends HospitalRoom {

	public RecordsStorage() {
		this.weight = 292.55;
		this.emissionsFactor = Material.WOOD.getEmissionsFactor();
	}

	@Override
	public String toString() {
		return "Almacenamiento de registros escritos";
	}
}
