/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.advanced.visual.structure;

import sa.shpi.advanced.model.Strings;
import sa.shpi.advanced.model.structure.MaterialsLibrary;
import sa.shpi.advanced.visual.EmissionsItemRequesterForm;
import sa.shpi.advanced.visual.LibraryItemChooseForm;

/**
 * Allows a user to choose from the existing list of materials
 * or create a custom material.
 * @author Tyler
 *
 */
public class MaterialChooseForm extends LibraryItemChooseForm {

	public MaterialChooseForm(EmissionsItemRequesterForm requester,
			MaterialsLibrary materialsLibrary) {
		super(requester, materialsLibrary);
	}

	@Override
	protected String getLibraryType() {
		return Strings.MATERIAL.toString();
	}

}
