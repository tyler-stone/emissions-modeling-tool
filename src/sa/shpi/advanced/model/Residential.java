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

import sa.shpi.advanced.model.content.Room;
import sa.shpi.advanced.model.structure.Section;
import sa.shpi.advanced.model.structure.SectionCategory;

/**
 * Class for the residential building. 
 * This class stores all information about the building and its components
 * @author Tyler
 *
 */
public class Residential {

	private String name;
	private ArrayList<Room> rooms;
	private Section internalWalls = new Section(SectionCategory.INTERNAL_WALLS);
	private Section externalWalls = new Section(SectionCategory.EXTERNAL_WALLS);
	private Section ceiling = new Section(SectionCategory.CEILING);
	private Section flooring = new Section(SectionCategory.FLOORING);
	private Section roofing = new Section(SectionCategory.ROOFING);

	private double areaTotal;
	private double areaBurned;

	public Residential() {
		name = Strings.RESIDENTIAL.toString();
		rooms = new ArrayList<Room>();
	}

	public Residential(String name) {
		this.name = name;
		rooms = new ArrayList<Room>();
	}

	public Section getInternalWalls() {
		return internalWalls;
	}

	public void setInternalWalls(Section internalWalls) {
		this.internalWalls = internalWalls;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}

	public void addRoom(Room room) {
		rooms.add(room);
	}

	public Section getExternalWalls() {
		return externalWalls;
	}

	public void setExternalWalls(Section externalWalls) {
		this.externalWalls = externalWalls;
	}

	public Section getCeiling() {
		return ceiling;
	}

	public void setCeiling(Section ceiling) {
		this.ceiling = ceiling;
	}

	public Section getFlooring() {
		return flooring;
	}

	public void setFlooring(Section flooring) {
		this.flooring = flooring;
	}

	public Section getRoofing() {
		return roofing;
	}

	public void setRoofing(Section roofing) {
		this.roofing = roofing;
	}

	public double getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(double areaTotal) {
		this.areaTotal = areaTotal;
	}

	public double getAreaBurned() {
		return areaBurned;
	}

	public void setAreaBurned(double areaBurned) {
		this.areaBurned = areaBurned;
	}

	public double getTotalEmissions() {
		return getContentEmissions() + getStructureEmissions();
	}

	public double getContentEmissions() {
		double emissions = 0.0;

		//for each room
		for (int count = 0; count < rooms.size(); count++) {
			//add the emissions from the room together
			emissions += rooms.get(count).calculateEmissions();
		}

		return emissions;
	}

	public double getStructureEmissions() {
		double emissions = 0.0;
		
		//for each structural component
		for (int count = 0; count < getSections().size(); count++) {
			//add the emissions from each section together
			emissions += getSections().get(count)
					.calculateEmissions(areaBurned);
		}

		return emissions;
	}

	@Override
	public String toString() {
		return name + String.format(" (%.2f kg CO2)", getTotalEmissions());
	}

	public Section getSection(SectionCategory section) {
		if (section == SectionCategory.CEILING) {
			return ceiling;
		} else if (section == SectionCategory.EXTERNAL_WALLS) {
			return externalWalls;
		} else if (section == SectionCategory.INTERNAL_WALLS) {
			return internalWalls;
		} else if (section == SectionCategory.FLOORING) {
			return flooring;
		} else if (section == SectionCategory.ROOFING) {
			return roofing;
		} else {
			return null;
		}
	}

	public ArrayList<Section> getSections() {
		ArrayList<Section> sectionList = new ArrayList<Section>();
		sectionList.add(internalWalls);
		sectionList.add(externalWalls);
		sectionList.add(ceiling);
		sectionList.add(roofing);
		sectionList.add(flooring);
		return sectionList;
	}

	public ArrayList<Section> getIncompleteSections() {
		//if a section is not completed (100% coverage by a material), add to list
		ArrayList<Section> fullSectionList = getSections();
		ArrayList<Section> incompleteSectionList = new ArrayList<Section>();

		for (int count = 0; count < fullSectionList.size(); count++) {
			if (fullSectionList.get(count).getPercentRemaining() > 0) {
				incompleteSectionList.add(fullSectionList.get(count));
			}
		}

		return incompleteSectionList;
	}
}
