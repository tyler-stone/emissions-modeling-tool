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

import sa.shpi.simple.visual.Form;

public abstract class Model {
	protected int totalArea;
	protected int areaBurned;

	public abstract void startModel(Form previousForm);

	public abstract double evaluateEmissions();

	protected RoomList rooms = new RoomList();

	public int getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(int totalArea) {
		this.totalArea = totalArea;
	}

	public int getAreaBurned() {
		return areaBurned;
	}

	public void setAreaBurned(int areaBurned) {
		this.areaBurned = areaBurned;
	}

	public RoomList getRoomList() {
		return rooms;
	}
}
