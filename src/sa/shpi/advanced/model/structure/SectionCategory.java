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

import sa.shpi.advanced.model.Strings;

/**
 * Possible structural areas to choose from
 * @author Tyler
 *
 */
public enum SectionCategory {
	EXTERNAL_WALLS(Strings.EXTERNAL_WALLS.toString()), INTERNAL_WALLS(
			Strings.INTERNAL_WALLS.toString()), ROOFING(Strings.ROOFING
			.toString()), CEILING(Strings.CEILING.toString()), FLOORING(
			Strings.FLOORING.toString());

	private String displayName;

	private SectionCategory(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return displayName;
	}
}
