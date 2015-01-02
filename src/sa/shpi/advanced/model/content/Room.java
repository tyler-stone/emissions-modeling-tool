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
 * A basic room in a residential building.
 * @author Tyler
 *
 */
public class Room {
	private RoomType roomType;
	private FurnishingList furnishingList;
	private int damage;

	public Room() {
		this.furnishingList = new FurnishingList();
	}

	public Room(RoomType roomType) {
		this.roomType = roomType;
		this.furnishingList = new FurnishingList();
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void addFurnishing(UsedFurnishing furnishing) {
		furnishingList.add(furnishing);
	}

	public void setFurnishingList(FurnishingList furnishingList) {
		this.furnishingList = furnishingList;
	}

	public FurnishingList getFurnishingList() {
		return furnishingList;
	}

	public double calculateEmissions() {
		double emissions = 0.0;

		if (!furnishingList.isEmpty()) {
			//for each furnishing
			for (int count = 0; count < furnishingList.size(); count++) {
				//get each item and add it to the emissions total
				emissions += furnishingList.get(count).calculateEmissions();
			}
		}
		
		//multiply the result by the damage percentage
		return emissions * getDamageFraction();
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public double getDamageFraction() {
		return damage * 0.01;
	}

	@Override
	public String toString() {
		return roomType.toString() + " (" + getDamage() + "% "
				+ Strings.DAMAGE.toString() + ")";
	}
}
