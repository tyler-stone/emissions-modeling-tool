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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import sa.shpi.SHPIImagePanel;
import sa.shpi.simple.model.hospital.Hospital;
import sa.shpi.simple.model.industrial.Industrial;
import sa.shpi.simple.model.residential.Residential;
import sa.shpi.simple.model.warehouse.Warehouse;
import javax.swing.JPanel;

/**
 * Starting class for the simple model
 */
public class SimpleMainForm extends Form {

	private JFrame frame;

	/**
	 * Create the form.
	 */
	public SimpleMainForm() {
		initialize();
	}

	public void show() {
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("La Calculadora de las Emisiones de Incendios Estructurales");
		frame.setResizable(false);
		frame.setBounds(100, 100, 344, 387);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 38, 257, 30, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 30, 27, 20, 0, 0, 10 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		SHPIImagePanel panel = new SHPIImagePanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(panel, gbc_panel);

		JLabel lblBuildingType = new JLabel("Tipo de Edificio");
		lblBuildingType.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblBuildingType = new GridBagConstraints();
		gbc_lblBuildingType.anchor = GridBagConstraints.SOUTH;
		gbc_lblBuildingType.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBuildingType.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuildingType.gridx = 1;
		gbc_lblBuildingType.gridy = 2;
		frame.getContentPane().add(lblBuildingType, gbc_lblBuildingType);

		final JComboBox<String> buildingTypeComboBox = new JComboBox<String>();
		buildingTypeComboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Edificio Residencial", "Hospital", "Bodega",
						"Sitio Industrial" }));
		GridBagConstraints gbc_buildingTypeComboBox = new GridBagConstraints();
		gbc_buildingTypeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_buildingTypeComboBox.fill = GridBagConstraints.BOTH;
		gbc_buildingTypeComboBox.gridx = 1;
		gbc_buildingTypeComboBox.gridy = 3;
		frame.getContentPane().add(buildingTypeComboBox,
				gbc_buildingTypeComboBox);

		JButton btnNewButton = new JButton("Próximo >");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				if (buildingTypeComboBox.getSelectedItem() == "Edificio Residencial") {
					Residential residential = new Residential();
					residential.startModel(SimpleMainForm.this);
				} else if (buildingTypeComboBox.getSelectedItem() == "Hospital") {
					Hospital hospital = new Hospital();
					hospital.startModel(SimpleMainForm.this);
				} else if (buildingTypeComboBox.getSelectedItem() == "Bodega") {
					Warehouse warehouse = new Warehouse();
					warehouse.startModel(SimpleMainForm.this);
				} else if (buildingTypeComboBox.getSelectedItem() == "Sitio Industrial") {
					Industrial industrial = new Industrial();
					industrial.startModel(SimpleMainForm.this);
				}

			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 5;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
	}

}
