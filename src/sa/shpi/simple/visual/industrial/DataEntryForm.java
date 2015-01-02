/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.simple.visual.industrial;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import sa.shpi.advanced.model.Strings;
import sa.shpi.simple.model.Material;
import sa.shpi.simple.model.industrial.Industrial;
import sa.shpi.simple.model.warehouse.Purpose;
import sa.shpi.simple.visual.Form;

public class DataEntryForm extends Form {

	//private JFrame frame;

	private JTextField totalAreaTextField;
	private JTextField areaBurnedTextField;

	JComboBox purposeComboBox = new JComboBox();
	JComboBox structureComboBox = new JComboBox();

	private Industrial model;
	private JTextField numFloorsTextField;

	/**
	 * Create the application.
	 */
	public DataEntryForm() {
		initialize();
	}

	public DataEntryForm(Industrial model) {
		this.model = model;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 379);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 445, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 145, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 0;
		frame.getContentPane().add(verticalStrut_1, gbc_verticalStrut_1);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Área del edificio",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 56, 29, 0, 0, 55, 0, 22, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 0;
		panel.add(horizontalStrut_1, gbc_horizontalStrut_1);

		JLabel lblWidth = new JLabel(Strings.AREA_TOTAL.toString() + ":");
		GridBagConstraints gbc_lblWidth = new GridBagConstraints();
		gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
		gbc_lblWidth.anchor = GridBagConstraints.EAST;
		gbc_lblWidth.gridx = 1;
		gbc_lblWidth.gridy = 0;
		panel.add(lblWidth, gbc_lblWidth);

		totalAreaTextField = new JTextField();
		totalAreaTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		totalAreaTextField.setText("0");
		GridBagConstraints gbc_totalAreaTextField = new GridBagConstraints();
		gbc_totalAreaTextField.anchor = GridBagConstraints.WEST;
		gbc_totalAreaTextField.insets = new Insets(0, 0, 5, 5);
		gbc_totalAreaTextField.gridx = 2;
		gbc_totalAreaTextField.gridy = 0;
		panel.add(totalAreaTextField, gbc_totalAreaTextField);
		totalAreaTextField.setColumns(5);

		JLabel lblM = new JLabel("m^2");
		lblM.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblM = new GridBagConstraints();
		gbc_lblM.anchor = GridBagConstraints.WEST;
		gbc_lblM.insets = new Insets(0, 0, 5, 5);
		gbc_lblM.gridx = 3;
		gbc_lblM.gridy = 0;
		panel.add(lblM, gbc_lblM);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 4;
		gbc_horizontalStrut_2.gridy = 0;
		panel.add(horizontalStrut_2, gbc_horizontalStrut_2);

		JLabel lblHeight = new JLabel(Strings.AREA_BURNED.toString() + ":");
		GridBagConstraints gbc_lblHeight = new GridBagConstraints();
		gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeight.anchor = GridBagConstraints.EAST;
		gbc_lblHeight.gridx = 5;
		gbc_lblHeight.gridy = 0;
		panel.add(lblHeight, gbc_lblHeight);

		areaBurnedTextField = new JTextField();
		areaBurnedTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		areaBurnedTextField.setText("0");
		GridBagConstraints gbc_areaBurnedTextField = new GridBagConstraints();
		gbc_areaBurnedTextField.anchor = GridBagConstraints.WEST;
		gbc_areaBurnedTextField.insets = new Insets(0, 0, 5, 5);
		gbc_areaBurnedTextField.gridx = 6;
		gbc_areaBurnedTextField.gridy = 0;
		panel.add(areaBurnedTextField, gbc_areaBurnedTextField);
		areaBurnedTextField.setColumns(5);

		JLabel lblNewLabel = new JLabel("m^2");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 7;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_3.gridx = 8;
		gbc_horizontalStrut_3.gridy = 0;
		panel.add(horizontalStrut_3, gbc_horizontalStrut_3);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.anchor = GridBagConstraints.WEST;
		gbc_verticalStrut_3.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_3.gridx = 2;
		gbc_verticalStrut_3.gridy = 1;
		panel.add(verticalStrut_3, gbc_verticalStrut_3);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 2;
		frame.getContentPane().add(verticalStrut, gbc_verticalStrut);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_6 = new GridBagConstraints();
		gbc_horizontalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_6.gridx = 0;
		gbc_horizontalStrut_6.gridy = 3;
		frame.getContentPane().add(horizontalStrut_6, gbc_horizontalStrut_6);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Específicos del edificio",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 3;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_5.gridx = 0;
		gbc_horizontalStrut_5.gridy = 0;
		panel_1.add(horizontalStrut_5, gbc_horizontalStrut_5);

		JLabel lblPrimaryPurpose = new JLabel("Propósito principal:");
		GridBagConstraints gbc_lblPrimaryPurpose = new GridBagConstraints();
		gbc_lblPrimaryPurpose.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimaryPurpose.anchor = GridBagConstraints.EAST;
		gbc_lblPrimaryPurpose.gridx = 1;
		gbc_lblPrimaryPurpose.gridy = 0;
		panel_1.add(lblPrimaryPurpose, gbc_lblPrimaryPurpose);

		purposeComboBox.setModel(new DefaultComboBoxModel(Purpose.values()));
		GridBagConstraints gbc_purposeComboBox = new GridBagConstraints();
		gbc_purposeComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_purposeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_purposeComboBox.gridx = 2;
		gbc_purposeComboBox.gridy = 0;
		panel_1.add(purposeComboBox, gbc_purposeComboBox);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 1;
		panel_1.add(verticalStrut_4, gbc_verticalStrut_4);

		JLabel lblStructure = new JLabel(Strings.STRUCTURE.toString() + ":");
		GridBagConstraints gbc_lblStructure = new GridBagConstraints();
		gbc_lblStructure.anchor = GridBagConstraints.EAST;
		gbc_lblStructure.insets = new Insets(0, 0, 5, 5);
		gbc_lblStructure.gridx = 1;
		gbc_lblStructure.gridy = 2;
		panel_1.add(lblStructure, gbc_lblStructure);

		structureComboBox.setModel(new DefaultComboBoxModel(model.Structure
				.toArray()));
		GridBagConstraints gbc_structureComboBox = new GridBagConstraints();
		gbc_structureComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_structureComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_structureComboBox.gridx = 2;
		gbc_structureComboBox.gridy = 2;
		panel_1.add(structureComboBox, gbc_structureComboBox);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_5.gridx = 2;
		gbc_verticalStrut_5.gridy = 3;
		panel_1.add(verticalStrut_5, gbc_verticalStrut_5);

		JLabel lblNewLabel_2 = new JLabel("# de pisos:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		numFloorsTextField = new JTextField();
		numFloorsTextField.setText("1");
		GridBagConstraints gbc_numFloorsTextField = new GridBagConstraints();
		gbc_numFloorsTextField.anchor = GridBagConstraints.WEST;
		gbc_numFloorsTextField.insets = new Insets(0, 0, 0, 5);
		gbc_numFloorsTextField.gridx = 2;
		gbc_numFloorsTextField.gridy = 4;
		panel_1.add(numFloorsTextField, gbc_numFloorsTextField);
		numFloorsTextField.setColumns(4);

		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_7 = new GridBagConstraints();
		gbc_horizontalStrut_7.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_7.gridx = 2;
		gbc_horizontalStrut_7.gridy = 3;
		frame.getContentPane().add(horizontalStrut_7, gbc_horizontalStrut_7);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 4;
		frame.getContentPane().add(verticalStrut_2, gbc_verticalStrut_2);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 5;
		frame.getContentPane().add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JButton backButton = new JButton("< Anterior");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPreviousForm();
			}
		});

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_4.gridx = 0;
		gbc_horizontalStrut_4.gridy = 0;
		panel_2.add(horizontalStrut_4, gbc_horizontalStrut_4);
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.insets = new Insets(0, 0, 0, 5);
		gbc_backButton.gridx = 1;
		gbc_backButton.gridy = 0;
		panel_2.add(backButton, gbc_backButton);

		JButton nextButton = new JButton("Próximo >");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (saveToModel()) {
					IndustrialEmissionsSummaryForm summaryForm = new IndustrialEmissionsSummaryForm(
							model);

					frame.setVisible(false);
					summaryForm.setPreviousForm(DataEntryForm.this);
					summaryForm.show();
				}
			}
		});
		GridBagConstraints gbc_nextButton = new GridBagConstraints();
		gbc_nextButton.gridx = 2;
		gbc_nextButton.gridy = 0;
		panel_2.add(nextButton, gbc_nextButton);
	}

	protected boolean saveToModel() {
		//validate all input
		String regex = "^[0-9]+$";

		if (totalAreaTextField.getText().matches(regex)) {
			model.setTotalArea(Integer.parseInt(totalAreaTextField.getText()));
		} else {
			JOptionPane.showMessageDialog(frame,
					"Por favor use los números para describir la Área total.");
			return false;
		}

		if (areaBurnedTextField.getText().matches(regex)) {
			model.setAreaBurned(Integer.parseInt(areaBurnedTextField.getText()));
		} else {
			JOptionPane
					.showMessageDialog(frame,
							"Por favor use los números para describir la Área quemada.");
			return false;
		}

		if (numFloorsTextField.getText().matches(regex)) {
			model.setNumFloors(Integer.parseInt(numFloorsTextField.getText()));
		} else {
			JOptionPane
					.showMessageDialog(frame,
							"Por favor use los números para describir el número de pisos.");
			return false;
		}

		if (model.getAreaBurned() > model.getTotalArea()) {
			JOptionPane.showMessageDialog(frame,
					"Área quemada no puede ser más larga que la área total.");
			return false;
		}

		model.setPurpose((Purpose) purposeComboBox.getSelectedItem());
		model.setStructureMaterial((Material) structureComboBox
				.getSelectedItem());

		return true;
	}

}
