/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.advanced.visual;

import javax.swing.JDialog;
import javax.swing.JFrame;

import sa.shpi.advanced.model.EmissionsItem;
import sa.shpi.advanced.model.Strings;

/**
 * A base class that allows a selection dialog to add an emissions item to the detail form
 * @author Tyler
 *
 */
public abstract class EmissionsItemRequesterForm extends JDialog {
	private static final long serialVersionUID = 1L;

	public EmissionsItemRequesterForm(JFrame frame) {
		super(frame);
	}

	public EmissionsItemRequesterForm() {
	}

	public abstract void addEmissionsItem(EmissionsItem eItem);
}
