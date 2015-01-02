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

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SHPIImagePanel extends JPanel {

	/**
	 * This class is the panel that displays the SHPI logo on the simple and
	 * advanced models.
	 */

	private BufferedImage image;

	public SHPIImagePanel() {
		try {
			// get image from assets folder
			image = ImageIO.read(this.getClass().getClassLoader()
					.getResourceAsStream("sa/shpi/assets/shpi.jpg"));
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, ex.toString());
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null); // draw SHPI logo to screen
	}

}
