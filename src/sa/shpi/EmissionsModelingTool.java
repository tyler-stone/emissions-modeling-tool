/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import sa.shpi.advanced.AdvancedTool;
import sa.shpi.simple.visual.SimpleMainForm;

/**
 * 
 * Window Builder Pro Download Site
 * 
 * http://download.eclipse.org/windowbuilder/WB/release/R201309271200/4.2/
 * 
 * E-Mail: tjstone@wpi.edu
 *
 */

public class EmissionsModelingTool {

	/**
	 * The entry point for the application.
	 */
	public static void main(String[] args) {
		// toggle between simple and advanced model
		boolean simple = false;

		try {
			// Set system look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		try {
			if (simple) {
				// launch simple model
				SimpleMainForm main = new SimpleMainForm();
				main.show();
			} else {
				// launch advanced model
				AdvancedTool tool = new AdvancedTool();
				tool.startAdvancedTool();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
