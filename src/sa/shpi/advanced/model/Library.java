/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.advanced.model;

import java.util.ArrayList;

/**
 * Library base class that is used by MaterialsLibrary and FurnishingLibrary
 * @author Tyler
 *
 */
public abstract class Library {

	protected ArrayList<EmissionsItem> lib;

	public Library() {
		lib = new ArrayList<EmissionsItem>();
	}

	public ArrayList<EmissionsItem> getLib() {
		return lib;
	}

	public void setLib(ArrayList<EmissionsItem> lib) {
		this.lib = lib;
	}

	public abstract void initialize();

	public abstract String getUnits();
}
