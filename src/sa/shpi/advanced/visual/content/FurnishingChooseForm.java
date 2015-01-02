/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.advanced.visual.content;

import sa.shpi.advanced.model.Library;
import sa.shpi.advanced.model.Strings;
import sa.shpi.advanced.model.content.FurnishingLibrary;
import sa.shpi.advanced.visual.EmissionsItemRequesterForm;
import sa.shpi.advanced.visual.LibraryItemChooseForm;

/**
 * Allows a user to choose from the existing list of furnishings
 * or create a custom furnishing.
 * @author Tyler
 *
 */
public class FurnishingChooseForm extends LibraryItemChooseForm {

	public FurnishingChooseForm(EmissionsItemRequesterForm requester,
			FurnishingLibrary furnishingLibrary) {
		super(requester, furnishingLibrary);
	}

	@Override
	protected String getLibraryType() {
		return Strings.FURNISHING.toString();
	}
}
