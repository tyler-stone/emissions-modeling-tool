/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.simple.visual.residential;

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
import javax.swing.border.TitledBorder;

import sa.shpi.simple.model.Material;
import sa.shpi.simple.model.residential.Residential;
import sa.shpi.simple.visual.Form;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class StructureForm extends Form {

	// private JFrame frame;
	private JTextField totalAreaTextField;
	private JTextField areaBurnedTextField;

	JComboBox externalWallsComboBox = new JComboBox();
	JComboBox roofingComboBox = new JComboBox();
	JComboBox internalWallsComboBox = new JComboBox();
	JComboBox floorComboBox = new JComboBox();
	JComboBox ceilingComboBox = new JComboBox();

	private Residential model;

	/**
	 * Create the form.
	 */
	public StructureForm() {
		initialize();
	}

	public StructureForm(Residential model) {
		this.model = model;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("La Calculadora de las Emisiones de Incendios Estructurales");
		frame.setResizable(false);
		frame.setBounds(100, 100, 465, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] { FormFactory.DEFAULT_COLSPEC,
						ColumnSpec.decode("279dlu:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						ColumnSpec.decode("right:50dlu"), }, new RowSpec[] {
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("max(150dlu;default)"),
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"), }));

		Component verticalStrut = Box.createVerticalStrut(20);
		frame.getContentPane().add(verticalStrut, "2, 1");

		Component horizontalStrut = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut, "1, 3");

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null,
				"Los Materiales de la Estructura", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel, "2, 3, fill, fill");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 19, 150, 30, 150, 30, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_6 = new GridBagConstraints();
		gbc_horizontalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_6.gridx = 0;
		gbc_horizontalStrut_6.gridy = 0;
		panel.add(horizontalStrut_6, gbc_horizontalStrut_6);

		JLabel lblExternalWalls = new JLabel("Las Paredes Externas");
		GridBagConstraints gbc_lblExternalWalls = new GridBagConstraints();
		gbc_lblExternalWalls.anchor = GridBagConstraints.WEST;
		gbc_lblExternalWalls.insets = new Insets(0, 0, 5, 5);
		gbc_lblExternalWalls.gridx = 1;
		gbc_lblExternalWalls.gridy = 0;
		panel.add(lblExternalWalls, gbc_lblExternalWalls);

		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_11 = new GridBagConstraints();
		gbc_horizontalStrut_11.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_11.gridx = 2;
		gbc_horizontalStrut_11.gridy = 0;
		panel.add(horizontalStrut_11, gbc_horizontalStrut_11);

		JLabel lblNewLabel_1 = new JLabel("Techo");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_5.gridx = 0;
		gbc_horizontalStrut_5.gridy = 1;
		panel.add(horizontalStrut_5, gbc_horizontalStrut_5);

		externalWallsComboBox.setModel(new DefaultComboBoxModel(
				model.ExternalWalls.toArray()));
		GridBagConstraints gbc_externalWallsComboBox = new GridBagConstraints();
		gbc_externalWallsComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_externalWallsComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_externalWallsComboBox.gridx = 1;
		gbc_externalWallsComboBox.gridy = 1;
		panel.add(externalWallsComboBox, gbc_externalWallsComboBox);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 2;
		gbc_horizontalStrut_4.gridy = 1;
		panel.add(horizontalStrut_4, gbc_horizontalStrut_4);

		roofingComboBox.setModel(new DefaultComboBoxModel(model.Roofing
				.toArray()));
		GridBagConstraints gbc_roofingComboBox = new GridBagConstraints();
		gbc_roofingComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_roofingComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_roofingComboBox.gridx = 3;
		gbc_roofingComboBox.gridy = 1;
		panel.add(roofingComboBox, gbc_roofingComboBox);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 2;
		panel.add(verticalStrut_2, gbc_verticalStrut_2);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 3;
		gbc_verticalStrut_3.gridy = 2;
		panel.add(verticalStrut_3, gbc_verticalStrut_3);

		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_7 = new GridBagConstraints();
		gbc_horizontalStrut_7.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_7.gridx = 0;
		gbc_horizontalStrut_7.gridy = 3;
		panel.add(horizontalStrut_7, gbc_horizontalStrut_7);

		JLabel lblInternalWalls = new JLabel("Las Paredes Internas");
		GridBagConstraints gbc_lblInternalWalls = new GridBagConstraints();
		gbc_lblInternalWalls.anchor = GridBagConstraints.WEST;
		gbc_lblInternalWalls.insets = new Insets(0, 0, 5, 5);
		gbc_lblInternalWalls.gridx = 1;
		gbc_lblInternalWalls.gridy = 3;
		panel.add(lblInternalWalls, gbc_lblInternalWalls);

		Component horizontalStrut_12 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_12 = new GridBagConstraints();
		gbc_horizontalStrut_12.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_12.gridx = 2;
		gbc_horizontalStrut_12.gridy = 3;
		panel.add(horizontalStrut_12, gbc_horizontalStrut_12);

		JLabel lblNewLabel_2 = new JLabel("Piso");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_8 = new GridBagConstraints();
		gbc_horizontalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_8.gridx = 0;
		gbc_horizontalStrut_8.gridy = 4;
		panel.add(horizontalStrut_8, gbc_horizontalStrut_8);

		internalWallsComboBox.setModel(new DefaultComboBoxModel(
				model.InternalWalls.toArray()));
		GridBagConstraints gbc_internalWallsComboBox = new GridBagConstraints();
		gbc_internalWallsComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_internalWallsComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_internalWallsComboBox.gridx = 1;
		gbc_internalWallsComboBox.gridy = 4;
		panel.add(internalWallsComboBox, gbc_internalWallsComboBox);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 2;
		gbc_horizontalStrut_3.gridy = 4;
		panel.add(horizontalStrut_3, gbc_horizontalStrut_3);

		floorComboBox.setModel(new DefaultComboBoxModel(model.Flooring
				.toArray()));
		GridBagConstraints gbc_floorComboBox = new GridBagConstraints();
		gbc_floorComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_floorComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_floorComboBox.gridx = 3;
		gbc_floorComboBox.gridy = 4;
		panel.add(floorComboBox, gbc_floorComboBox);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 5;
		panel.add(verticalStrut_1, gbc_verticalStrut_1);

		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_9 = new GridBagConstraints();
		gbc_horizontalStrut_9.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_9.gridx = 0;
		gbc_horizontalStrut_9.gridy = 6;
		panel.add(horizontalStrut_9, gbc_horizontalStrut_9);

		JLabel lblNewLabel = new JLabel("Cielo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 6;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_10 = new GridBagConstraints();
		gbc_horizontalStrut_10.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_10.gridx = 0;
		gbc_horizontalStrut_10.gridy = 7;
		panel.add(horizontalStrut_10, gbc_horizontalStrut_10);

		ceilingComboBox.setModel(new DefaultComboBoxModel(model.Ceiling
				.toArray()));
		GridBagConstraints gbc_ceilingComboBox = new GridBagConstraints();
		gbc_ceilingComboBox.insets = new Insets(0, 0, 0, 5);
		gbc_ceilingComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_ceilingComboBox.gridx = 1;
		gbc_ceilingComboBox.gridy = 7;
		panel.add(ceilingComboBox, gbc_ceilingComboBox);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		frame.getContentPane().add(horizontalStrut_1, "1, 6");

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Área del edificio",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel_1, "2, 6, fill, fill");
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 30, 150, 0, 150, 30, 30 };
		gbl_panel_1.rowHeights = new int[] { 10, 0, 15 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0 };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel_3 = new JLabel("Área Total (m^2)");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 0;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblAreaBurned = new JLabel("Área Quemado (m^2)");
		GridBagConstraints gbc_lblAreaBurned = new GridBagConstraints();
		gbc_lblAreaBurned.anchor = GridBagConstraints.WEST;
		gbc_lblAreaBurned.insets = new Insets(0, 0, 5, 5);
		gbc_lblAreaBurned.gridx = 3;
		gbc_lblAreaBurned.gridy = 0;
		panel_1.add(lblAreaBurned, gbc_lblAreaBurned);

		totalAreaTextField = new JTextField();
		totalAreaTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_totalAreaTextField = new GridBagConstraints();
		gbc_totalAreaTextField.insets = new Insets(0, 0, 5, 5);
		gbc_totalAreaTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_totalAreaTextField.gridx = 1;
		gbc_totalAreaTextField.gridy = 1;
		panel_1.add(totalAreaTextField, gbc_totalAreaTextField);
		totalAreaTextField.setColumns(10);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 2;
		gbc_horizontalStrut_2.gridy = 1;
		panel_1.add(horizontalStrut_2, gbc_horizontalStrut_2);

		areaBurnedTextField = new JTextField();
		areaBurnedTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_areaBurnedTextField = new GridBagConstraints();
		gbc_areaBurnedTextField.insets = new Insets(0, 0, 5, 5);
		gbc_areaBurnedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_areaBurnedTextField.gridx = 3;
		gbc_areaBurnedTextField.gridy = 1;
		panel_1.add(areaBurnedTextField, gbc_areaBurnedTextField);
		areaBurnedTextField.setColumns(10);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		frame.getContentPane().add(verticalStrut_4, "2, 7");

		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, "2, 9, fill, fill");
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 246, 67, 69, 0 };
		gbl_panel_2.rowHeights = new int[] { 23, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		Component horizontalStrut_13 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_13 = new GridBagConstraints();
		gbc_horizontalStrut_13.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_13.gridx = 0;
		gbc_horizontalStrut_13.gridy = 0;
		panel_2.add(horizontalStrut_13, gbc_horizontalStrut_13);

		JButton backButton = new JButton("< Anterior");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPreviousForm();
			}
		});
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_backButton.insets = new Insets(0, 0, 0, 5);
		gbc_backButton.gridx = 1;
		gbc_backButton.gridy = 0;
		panel_2.add(backButton, gbc_backButton);

		JButton nextButton = new JButton("Próximo >");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (saveToModel()) {
					RoomEntryForm roomEntryForm = new RoomEntryForm(model);

					frame.setVisible(false);
					roomEntryForm.setPreviousForm(StructureForm.this);
					roomEntryForm.show();
				}
			}
		});
		GridBagConstraints gbc_nextButton = new GridBagConstraints();
		gbc_nextButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_nextButton.gridx = 2;
		gbc_nextButton.gridy = 0;
		panel_2.add(nextButton, gbc_nextButton);
	}

	protected boolean saveToModel() {
		//validate all inputs
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

		if (model.getAreaBurned() > model.getTotalArea()) {
			JOptionPane.showMessageDialog(frame,
					"Área quemada no puede ser más larga que la área total.");
			return false;
		}

		model.setExternalWalls((Material) externalWallsComboBox
				.getSelectedItem());
		model.setInternalWalls((Material) internalWallsComboBox
				.getSelectedItem());
		model.setRoofing((Material) roofingComboBox.getSelectedItem());
		model.setFlooring((Material) floorComboBox.getSelectedItem());
		model.setCeiling((Material) ceilingComboBox.getSelectedItem());

		return true;
	}

}
