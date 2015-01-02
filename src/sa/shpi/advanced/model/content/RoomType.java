/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.advanced.model.content;

import sa.shpi.advanced.model.Strings;

/**
 * The options to choose from for a type of room
 * @author Tyler
 *
 */
public enum RoomType {
	KITCHEN(Strings.KITCHEN.toString()), DINING_ROOM(Strings.DINING_ROOM
			.toString()), BEDROOM(Strings.BEDROOM.toString()), BATHROOM(
			Strings.BATHROOM.toString()), LIVING_SPACE(Strings.LIVING_SPACE
			.toString()), LAUNDRY_ROOM(Strings.LAUNDRY_ROOM.toString()), OTHER(
			Strings.OTHER.toString());

	private String displayName;

	private RoomType(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return displayName;
	}
}
