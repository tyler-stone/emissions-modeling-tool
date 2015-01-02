/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.advanced.model.structure;

import sa.shpi.advanced.model.EmissionsItem;
import sa.shpi.advanced.model.Library;

/**
 * Dynamic material library with presets to add to structural components
 * @author Tyler
 *
 */
public class MaterialsLibrary extends Library {

	public MaterialsLibrary() {
		initialize();
	}

	@Override
	public void initialize() {
		lib.add(new EmissionsItem("Concreto", 0.00, 0.00));
		lib.add(new EmissionsItem("Madera (2x4)", 1.27, 18.75));
		lib.add(new EmissionsItem("Madera (2x6)", 1.27, 29.29));
		lib.add(new EmissionsItem("Madera contrachapada (5/8)", 1.27, 8.64));
		lib.add(new EmissionsItem("Hierro", 0.00, 0.00));
		lib.add(new EmissionsItem("Cerámica", 0.00, 0.00));
	}

	@Override
	public String getUnits() {
		return "kg/m^2";
	}

}
