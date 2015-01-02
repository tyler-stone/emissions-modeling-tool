/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.simple.model;

import java.util.ArrayList;
import java.util.Iterator;

public class RoomList extends ArrayList<Room> {
	private static final long serialVersionUID = 1L;

	public void addRoom(Room room) {
		add(room);
	}

	public Room getNextRoom() {
		return get(0);
	}

	public Room getLastRoom() {
		return get(size() - 1);
	}

	public int getNumRooms() {
		return size();
	}

	public void clearRooms() {
		clear();
	}

	public int countRooms(Class<?> roomType) {
		int count = 0;
		Iterator<Room> iter = iterator();
		while (iter.hasNext()) {
			if (iter.next().getClass() == roomType) {
				count++;
			}
		}
		return count;
	}

	public double getDamageScaler() {
		// scaler for damage factors to normalize to 100%
		double damageFactors = 0;
		Iterator<Room> iter = iterator();

		//add damage percent for each room
		while (iter.hasNext()) {
			Room currentRoom = iter.next();
			damageFactors += currentRoom.getPercentDamage();
		}

		//divide 1 by that result to get the scaler
		return 1 / damageFactors;
	}
}
