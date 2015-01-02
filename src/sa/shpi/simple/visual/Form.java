/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.simple.visual;

import javax.swing.JFrame;

/**
 * Base class for all forms used in the simple model
 */
public class Form {
	protected JFrame frame;
	protected Form previousForm;
	protected Form nextForm;

	public Form() {

	}

	public Form(Form previousForm) {
		this.previousForm = previousForm;
	}

	public void show() {
		frame.setVisible(true);
	}

	public void showPreviousForm() {
		frame.setVisible(false);
		previousForm.show();
	}

	public void showNextForm() {
		frame.setVisible(false);
		nextForm.show();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Form getPreviousForm() {
		return previousForm;
	}

	public void setPreviousForm(Form previousForm) {
		this.previousForm = previousForm;
	}

	public Form getNextForm() {
		return nextForm;
	}

	public void setNextForm(Form nextForm) {
		this.nextForm = nextForm;
	}
}
