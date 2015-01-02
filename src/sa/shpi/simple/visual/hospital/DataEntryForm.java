/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.simple.visual.hospital;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import sa.shpi.simple.model.hospital.Hospital;
import sa.shpi.simple.model.hospital.HospitalRoom;
import sa.shpi.simple.model.hospital.rooms.GeneralStorage;
import sa.shpi.simple.model.hospital.rooms.Office;
import sa.shpi.simple.model.hospital.rooms.PTRoom;
import sa.shpi.simple.model.hospital.rooms.RecordsStorage;
import sa.shpi.simple.visual.EmissionsSummaryForm;
import sa.shpi.simple.visual.Form;
import sa.shpi.simple.visual.RoomDamageForm;

public class DataEntryForm extends Form {

	// private JFrame frame;
	private JTextField totalAreaTextField;
	private JTextField areaBurnedTextField;
	private JTextField patientRoomTextField;
	private JTextField genStorageTextField;
	private JTextField recordsStorageTextField;
	private JTextField officeTextField;

	private Hospital model;

	/**
	 * Create the form.
	 */
	public DataEntryForm() {
		initialize();
	}

	public DataEntryForm(Hospital model) {
		this.model = model;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Hospital Fire");
		frame.setBounds(100, 100, 474, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 30, 420, 0, 30, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 62, 0, 113, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 0;
		frame.getContentPane().add(verticalStrut_3, gbc_verticalStrut_3);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 0;
		gbc_horizontalStrut_3.gridy = 1;
		frame.getContentPane().add(horizontalStrut_3, gbc_horizontalStrut_3);

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
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 113, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblTotalArea = new JLabel("Área Total:");
		GridBagConstraints gbc_lblTotalArea = new GridBagConstraints();
		gbc_lblTotalArea.anchor = GridBagConstraints.WEST;
		gbc_lblTotalArea.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalArea.gridx = 1;
		gbc_lblTotalArea.gridy = 0;
		panel.add(lblTotalArea, gbc_lblTotalArea);

		JLabel lblAreaBurned = new JLabel("Área Quemado:");
		GridBagConstraints gbc_lblAreaBurned = new GridBagConstraints();
		gbc_lblAreaBurned.anchor = GridBagConstraints.WEST;
		gbc_lblAreaBurned.insets = new Insets(0, 0, 5, 5);
		gbc_lblAreaBurned.gridx = 4;
		gbc_lblAreaBurned.gridy = 0;
		panel.add(lblAreaBurned, gbc_lblAreaBurned);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 0;
		gbc_horizontalStrut_4.gridy = 1;
		panel.add(horizontalStrut_4, gbc_horizontalStrut_4);

		totalAreaTextField = new JTextField();
		totalAreaTextField.setText("0");
		totalAreaTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_totalAreaTextField = new GridBagConstraints();
		gbc_totalAreaTextField.insets = new Insets(0, 0, 5, 5);
		gbc_totalAreaTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_totalAreaTextField.gridx = 1;
		gbc_totalAreaTextField.gridy = 1;
		panel.add(totalAreaTextField, gbc_totalAreaTextField);
		totalAreaTextField.setColumns(10);

		JLabel lblMCo = new JLabel("m^2");
		GridBagConstraints gbc_lblMCo = new GridBagConstraints();
		gbc_lblMCo.insets = new Insets(0, 0, 5, 5);
		gbc_lblMCo.gridx = 2;
		gbc_lblMCo.gridy = 1;
		panel.add(lblMCo, gbc_lblMCo);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_5.gridx = 3;
		gbc_horizontalStrut_5.gridy = 1;
		panel.add(horizontalStrut_5, gbc_horizontalStrut_5);

		areaBurnedTextField = new JTextField();
		areaBurnedTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		areaBurnedTextField.setText("0");
		GridBagConstraints gbc_areaBurnedTextField = new GridBagConstraints();
		gbc_areaBurnedTextField.insets = new Insets(0, 0, 5, 5);
		gbc_areaBurnedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_areaBurnedTextField.gridx = 4;
		gbc_areaBurnedTextField.gridy = 1;
		panel.add(areaBurnedTextField, gbc_areaBurnedTextField);
		areaBurnedTextField.setColumns(10);

		JLabel lblM = new JLabel("m^2");
		GridBagConstraints gbc_lblM = new GridBagConstraints();
		gbc_lblM.insets = new Insets(0, 0, 5, 0);
		gbc_lblM.gridx = 5;
		gbc_lblM.gridy = 1;
		panel.add(lblM, gbc_lblM);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
		gbc_verticalStrut_5.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_5.gridx = 1;
		gbc_verticalStrut_5.gridy = 2;
		panel.add(verticalStrut_5, gbc_verticalStrut_5);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 2;
		frame.getContentPane().add(verticalStrut_1, gbc_verticalStrut_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null,
				"Las Salas Afectadas por el Incendio", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 3;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 19, 32, 0, 0, 37, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		Component verticalStrut_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_6.gridx = 1;
		gbc_verticalStrut_6.gridy = 0;
		panel_1.add(verticalStrut_6, gbc_verticalStrut_6);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 1;
		panel_1.add(horizontalStrut, gbc_horizontalStrut);

		patientRoomTextField = new JTextField();
		patientRoomTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		patientRoomTextField.setText("0");
		GridBagConstraints gbc_patientRoomTextField = new GridBagConstraints();
		gbc_patientRoomTextField.insets = new Insets(0, 0, 5, 5);
		gbc_patientRoomTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_patientRoomTextField.gridx = 1;
		gbc_patientRoomTextField.gridy = 1;
		panel_1.add(patientRoomTextField, gbc_patientRoomTextField);
		patientRoomTextField.setColumns(3);

		JLabel lblNewLabel = new JLabel("Habitación(es) para pacientes");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 3;
		gbc_horizontalStrut_2.gridy = 1;
		panel_1.add(horizontalStrut_2, gbc_horizontalStrut_2);

		recordsStorageTextField = new JTextField();
		recordsStorageTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		recordsStorageTextField.setText("0");
		GridBagConstraints gbc_recordsStorageTextField = new GridBagConstraints();
		gbc_recordsStorageTextField.insets = new Insets(0, 0, 5, 5);
		gbc_recordsStorageTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_recordsStorageTextField.gridx = 4;
		gbc_recordsStorageTextField.gridy = 1;
		panel_1.add(recordsStorageTextField, gbc_recordsStorageTextField);
		recordsStorageTextField.setColumns(3);

		JLabel lblNewLabel_2 = new JLabel(
				"Almacenamiento de registros escritos");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 1;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_7 = new GridBagConstraints();
		gbc_horizontalStrut_7.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_7.gridx = 6;
		gbc_horizontalStrut_7.gridy = 1;
		panel_1.add(horizontalStrut_7, gbc_horizontalStrut_7);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 2;
		panel_1.add(verticalStrut_4, gbc_verticalStrut_4);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 3;
		panel_1.add(horizontalStrut_1, gbc_horizontalStrut_1);

		genStorageTextField = new JTextField();
		genStorageTextField.setText("0");
		genStorageTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_genStorageTextField = new GridBagConstraints();
		gbc_genStorageTextField.insets = new Insets(0, 0, 5, 5);
		gbc_genStorageTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_genStorageTextField.gridx = 1;
		gbc_genStorageTextField.gridy = 3;
		panel_1.add(genStorageTextField, gbc_genStorageTextField);
		genStorageTextField.setColumns(3);

		JLabel lblNewLabel_1 = new JLabel("Almacenamiento general");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 3;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_6 = new GridBagConstraints();
		gbc_horizontalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_6.gridx = 3;
		gbc_horizontalStrut_6.gridy = 3;
		panel_1.add(horizontalStrut_6, gbc_horizontalStrut_6);

		officeTextField = new JTextField();
		officeTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		officeTextField.setText("0");
		GridBagConstraints gbc_officeTextField = new GridBagConstraints();
		gbc_officeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_officeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_officeTextField.gridx = 4;
		gbc_officeTextField.gridy = 3;
		panel_1.add(officeTextField, gbc_officeTextField);
		officeTextField.setColumns(3);

		JLabel lblOffices = new JLabel("Oficina(s)");
		GridBagConstraints gbc_lblOffices = new GridBagConstraints();
		gbc_lblOffices.anchor = GridBagConstraints.WEST;
		gbc_lblOffices.insets = new Insets(0, 0, 5, 5);
		gbc_lblOffices.gridx = 5;
		gbc_lblOffices.gridy = 3;
		panel_1.add(lblOffices, gbc_lblOffices);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 4;
		panel_1.add(verticalStrut, gbc_verticalStrut);

		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_8 = new GridBagConstraints();
		gbc_horizontalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_8.gridx = 2;
		gbc_horizontalStrut_8.gridy = 3;
		frame.getContentPane().add(horizontalStrut_8, gbc_horizontalStrut_8);

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
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.anchor = GridBagConstraints.EAST;
		gbc_backButton.insets = new Insets(0, 0, 0, 5);
		gbc_backButton.gridx = 1;
		gbc_backButton.gridy = 0;
		panel_2.add(backButton, gbc_backButton);

		JButton nextButton = new JButton("Próximo >");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (saveToModel()) {
					frame.setVisible(false);
					model.getRoomList().getNextRoom().getDamageForm().show();
				}
			}
		});
		GridBagConstraints gbc_nextButton = new GridBagConstraints();
		gbc_nextButton.anchor = GridBagConstraints.EAST;
		gbc_nextButton.gridx = 2;
		gbc_nextButton.gridy = 0;
		panel_2.add(nextButton, gbc_nextButton);
	}

	protected boolean saveToModel() {
		//go through validation of each input
		String regex = "^[0-9]+$";
		int numRooms = 0;

		model.getRoomList().clearRooms();

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

		if (patientRoomTextField.getText().matches(regex)) {
			numRooms += Integer.parseInt(patientRoomTextField.getText());
			generateRoomSet(PTRoom.class,
					Integer.parseInt(patientRoomTextField.getText()));
		} else {
			JOptionPane
					.showMessageDialog(
							frame,
							"Por favor use los números para describir el número de habitaciónes para pacientes.");
			return false;
		}

		if (genStorageTextField.getText().matches(regex)) {
			numRooms += Integer.parseInt(genStorageTextField.getText());
			generateRoomSet(GeneralStorage.class,
					Integer.parseInt(genStorageTextField.getText()));
		} else {
			JOptionPane
					.showMessageDialog(frame,
							"Por favor use los números para describir el número de almacenamiento general.");
			return false;
		}

		if (recordsStorageTextField.getText().matches(regex)) {
			numRooms += Integer.parseInt(recordsStorageTextField.getText());
			generateRoomSet(RecordsStorage.class,
					Integer.parseInt(recordsStorageTextField.getText()));
		} else {
			JOptionPane
					.showMessageDialog(
							frame,
							"Por favor use los números para describir el número de almacenamiento de registros escritos.");
			return false;
		}

		if (officeTextField.getText().matches(regex)) {
			numRooms += Integer.parseInt(officeTextField.getText());
			generateRoomSet(Office.class,
					Integer.parseInt(officeTextField.getText()));
		} else {
			JOptionPane
					.showMessageDialog(frame,
							"Por favor use los números para describir el número de oficinas.");
			return false;
		}

		if (numRooms <= 0) {
			JOptionPane.showMessageDialog(frame,
					"Se necesita por lo menos un área en una hospital.");
			return false;
		}

		if (model.getAreaBurned() > model.getTotalArea()) {
			JOptionPane.showMessageDialog(frame,
					"Área quemada no puede ser más larga que la área total.");
			return false;
		}

		return true;
	}

	private void generateRoomSet(Class<?> roomType, int numRooms) {
		//sort each room and assign previous and next forms to new form
		if (numRooms >= 1) {
			//create summary form
			EmissionsSummaryForm summaryForm = new HospitalEmissionsSummaryForm(
					model);

			//for each room in the set to generate
			for (int count = 1; count <= numRooms; count++) {
				try {
					//create a new room to add
					HospitalRoom roomToAdd = (HospitalRoom) roomType
							.newInstance();
					
					//set defaults for the room
					String name = roomToAdd.toString() + " " + count;
					roomToAdd.setName(name);
					roomToAdd.setDamage(0);

					Form prevForm;
					//create damage form for the new room
					RoomDamageForm damageForm = new RoomDamageForm(roomToAdd);
					
					//if there exists one or more rooms already
					if (model.getRoomList().getNumRooms() > 0) {
						//set the previous form equal to the last room's damage form
						prevForm = model.getRoomList().getLastRoom()
								.getDamageForm();
						//set the previous form's next form to the new room's damage form
						prevForm.setNextForm(damageForm);
					} else {
						//otherwise, set the previous form to be this form
						prevForm = this;
					}

					damageForm.setPreviousForm(prevForm);
					roomToAdd.setDamageForm(damageForm);
					
					//add room to the room list
					model.getRoomList().addRoom(roomToAdd);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}

			//generate a summary
			summaryForm.generateSummary();
			//set the most recently added room's next form to be the summary form
			model.getRoomList().getLastRoom().getDamageForm()
					.setNextForm(summaryForm);
		}
	}

}
