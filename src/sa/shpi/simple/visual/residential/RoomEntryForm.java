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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import sa.shpi.simple.model.residential.Residential;
import sa.shpi.simple.model.residential.ResidentialRoom;
import sa.shpi.simple.model.residential.rooms.Bathroom;
import sa.shpi.simple.model.residential.rooms.Bedroom;
import sa.shpi.simple.model.residential.rooms.DiningRoom;
import sa.shpi.simple.model.residential.rooms.Kitchen;
import sa.shpi.simple.model.residential.rooms.LaundryRoom;
import sa.shpi.simple.model.residential.rooms.LivingSpace;
import sa.shpi.simple.model.residential.rooms.Other;
import sa.shpi.simple.visual.EmissionsSummaryForm;
import sa.shpi.simple.visual.Form;
import sa.shpi.simple.visual.RoomDamageForm;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class RoomEntryForm extends Form {

	// private JFrame frame;
	private JTextField kitchenTextField;
	private JTextField bedroomTextField;
	private JTextField bathroomTextField;
	private JTextField diningRoomTextField;
	private JTextField livingSpaceTextField;
	private JTextField laundryRoomTextField;
	private JTextField otherTextField;

	private Residential model;

	/**
	 * Create the form.
	 */
	public RoomEntryForm() {
		initialize();
	}

	public RoomEntryForm(Residential model) {
		this.model = model;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("La Calculadora de las Emisiones de Incendios Estructurales");
		frame.setBounds(100, 100, 405, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						ColumnSpec.decode("left:13dlu"),
						ColumnSpec.decode("right:236dlu"),
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						RowSpec.decode("max(7dlu;default)"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("max(150dlu;default)"),
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("bottom:default:grow"), }));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null,
				"Las Salas Afectadas por el Incendio", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel, "2, 3, fill, fill");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 33, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_4.gridx = 0;
		gbc_horizontalStrut_4.gridy = 0;
		panel.add(horizontalStrut_4, gbc_horizontalStrut_4);

		kitchenTextField = new JTextField();
		kitchenTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		kitchenTextField.setText("0");
		GridBagConstraints gbc_kitchenTextField = new GridBagConstraints();
		gbc_kitchenTextField.anchor = GridBagConstraints.WEST;
		gbc_kitchenTextField.insets = new Insets(0, 0, 5, 5);
		gbc_kitchenTextField.gridx = 1;
		gbc_kitchenTextField.gridy = 0;
		panel.add(kitchenTextField, gbc_kitchenTextField);
		kitchenTextField.setColumns(3);

		JLabel lblNewLabel = new JLabel("# Cocina(s)");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
		gbc_horizontalStrut_5.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_5.gridx = 3;
		gbc_horizontalStrut_5.gridy = 0;
		panel.add(horizontalStrut_5, gbc_horizontalStrut_5);

		livingSpaceTextField = new JTextField();
		livingSpaceTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		livingSpaceTextField.setText("0");
		GridBagConstraints gbc_livingSpaceTextField = new GridBagConstraints();
		gbc_livingSpaceTextField.insets = new Insets(0, 0, 5, 5);
		gbc_livingSpaceTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_livingSpaceTextField.gridx = 4;
		gbc_livingSpaceTextField.gridy = 0;
		panel.add(livingSpaceTextField, gbc_livingSpaceTextField);
		livingSpaceTextField.setColumns(3);

		JLabel lblNewLabel_1 = new JLabel("# Sala(s) de Estar");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 1;
		panel.add(verticalStrut_3, gbc_verticalStrut_3);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 0;
		gbc_horizontalStrut_3.gridy = 2;
		panel.add(horizontalStrut_3, gbc_horizontalStrut_3);

		bedroomTextField = new JTextField();
		bedroomTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		bedroomTextField.setText("0");
		GridBagConstraints gbc_bedroomTextField = new GridBagConstraints();
		gbc_bedroomTextField.anchor = GridBagConstraints.WEST;
		gbc_bedroomTextField.insets = new Insets(0, 0, 5, 5);
		gbc_bedroomTextField.gridx = 1;
		gbc_bedroomTextField.gridy = 2;
		panel.add(bedroomTextField, gbc_bedroomTextField);
		bedroomTextField.setColumns(3);

		JLabel lblBedrooms = new JLabel("# Cuarto(s)");
		GridBagConstraints gbc_lblBedrooms = new GridBagConstraints();
		gbc_lblBedrooms.anchor = GridBagConstraints.WEST;
		gbc_lblBedrooms.insets = new Insets(0, 0, 5, 5);
		gbc_lblBedrooms.gridx = 2;
		gbc_lblBedrooms.gridy = 2;
		panel.add(lblBedrooms, gbc_lblBedrooms);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_6 = new GridBagConstraints();
		gbc_horizontalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_6.gridx = 3;
		gbc_horizontalStrut_6.gridy = 2;
		panel.add(horizontalStrut_6, gbc_horizontalStrut_6);

		laundryRoomTextField = new JTextField();
		laundryRoomTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		laundryRoomTextField.setText("0");
		GridBagConstraints gbc_laundryRoomTextField = new GridBagConstraints();
		gbc_laundryRoomTextField.insets = new Insets(0, 0, 5, 5);
		gbc_laundryRoomTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_laundryRoomTextField.gridx = 4;
		gbc_laundryRoomTextField.gridy = 2;
		panel.add(laundryRoomTextField, gbc_laundryRoomTextField);
		laundryRoomTextField.setColumns(3);

		JLabel lblNewLabel_2 = new JLabel("# Lavandero(s)");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 3;
		panel.add(verticalStrut_2, gbc_verticalStrut_2);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 4;
		panel.add(horizontalStrut_1, gbc_horizontalStrut_1);

		bathroomTextField = new JTextField();
		bathroomTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		bathroomTextField.setText("0");
		GridBagConstraints gbc_bathroomTextField = new GridBagConstraints();
		gbc_bathroomTextField.anchor = GridBagConstraints.WEST;
		gbc_bathroomTextField.insets = new Insets(0, 0, 5, 5);
		gbc_bathroomTextField.gridx = 1;
		gbc_bathroomTextField.gridy = 4;
		panel.add(bathroomTextField, gbc_bathroomTextField);
		bathroomTextField.setColumns(3);

		JLabel lblBathrooms = new JLabel("# Baño(s)");
		GridBagConstraints gbc_lblBathrooms = new GridBagConstraints();
		gbc_lblBathrooms.anchor = GridBagConstraints.WEST;
		gbc_lblBathrooms.insets = new Insets(0, 0, 5, 5);
		gbc_lblBathrooms.gridx = 2;
		gbc_lblBathrooms.gridy = 4;
		panel.add(lblBathrooms, gbc_lblBathrooms);

		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_7 = new GridBagConstraints();
		gbc_horizontalStrut_7.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_7.gridx = 3;
		gbc_horizontalStrut_7.gridy = 4;
		panel.add(horizontalStrut_7, gbc_horizontalStrut_7);

		otherTextField = new JTextField();
		otherTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		otherTextField.setText("0");
		GridBagConstraints gbc_otherTextField = new GridBagConstraints();
		gbc_otherTextField.insets = new Insets(0, 0, 5, 5);
		gbc_otherTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_otherTextField.gridx = 4;
		gbc_otherTextField.gridy = 4;
		panel.add(otherTextField, gbc_otherTextField);
		otherTextField.setColumns(3);

		JLabel lblNewLabel_3 = new JLabel("# Otro(s)");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 5;
		gbc_lblNewLabel_3.gridy = 4;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 5;
		panel.add(verticalStrut_1, gbc_verticalStrut_1);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_2.gridx = 0;
		gbc_horizontalStrut_2.gridy = 6;
		panel.add(horizontalStrut_2, gbc_horizontalStrut_2);

		diningRoomTextField = new JTextField();
		diningRoomTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		diningRoomTextField.setText("0");
		GridBagConstraints gbc_diningRoomTextField = new GridBagConstraints();
		gbc_diningRoomTextField.anchor = GridBagConstraints.WEST;
		gbc_diningRoomTextField.insets = new Insets(0, 0, 0, 5);
		gbc_diningRoomTextField.gridx = 1;
		gbc_diningRoomTextField.gridy = 6;
		panel.add(diningRoomTextField, gbc_diningRoomTextField);
		diningRoomTextField.setColumns(3);

		JLabel lblDiningRooms = new JLabel("# Comedor(es)");
		GridBagConstraints gbc_lblDiningRooms = new GridBagConstraints();
		gbc_lblDiningRooms.insets = new Insets(0, 0, 0, 5);
		gbc_lblDiningRooms.anchor = GridBagConstraints.WEST;
		gbc_lblDiningRooms.gridx = 2;
		gbc_lblDiningRooms.gridy = 6;
		panel.add(lblDiningRooms, gbc_lblDiningRooms);

		Component verticalStrut = Box.createVerticalStrut(20);
		frame.getContentPane().add(verticalStrut, "2, 4");

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "2, 6, fill, fill");
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 178 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 0;
		panel_1.add(horizontalStrut, gbc_horizontalStrut);

		JButton btnNewButton = new JButton("< Anterior");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPreviousForm();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		panel_1.add(btnNewButton, gbc_btnNewButton);

		JButton btnNext = new JButton("Próximo >");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (saveToModel()) {
					// go to next
					frame.setVisible(false);
					model.getRoomList().getNextRoom().getDamageForm().show();
				}
			}
		});
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.anchor = GridBagConstraints.EAST;
		gbc_btnNext.gridx = 2;
		gbc_btnNext.gridy = 0;
		panel_1.add(btnNext, gbc_btnNext);
	}

	protected boolean saveToModel() {
		//validate all input
		String regex = "^[0-9]+$";
		int numRooms = 0;

		model.getRoomList().clearRooms();

		if (kitchenTextField.getText().matches(regex)) {
			numRooms += Integer.parseInt(kitchenTextField.getText());
			generateRoomSet(Kitchen.class,
					Integer.parseInt(kitchenTextField.getText()));
		} else {
			JOptionPane
					.showMessageDialog(frame,
							"Por favor use los números para describir el número de cocinas.");
			return false;
		}

		if (bedroomTextField.getText().matches(regex)) {
			numRooms += Integer.parseInt(bedroomTextField.getText());
			generateRoomSet(Bedroom.class,
					Integer.parseInt(bedroomTextField.getText()));
		} else {
			JOptionPane
					.showMessageDialog(frame,
							"Por favor use los números para describir el número de cuartos.");
			return false;
		}

		if (bathroomTextField.getText().matches(regex)) {
			numRooms += Integer.parseInt(bathroomTextField.getText());
			generateRoomSet(Bathroom.class,
					Integer.parseInt(bathroomTextField.getText()));
		} else {
			JOptionPane
					.showMessageDialog(frame,
							"Por favor use los números para describir el número de baños.");
			return false;
		}

		if (diningRoomTextField.getText().matches(regex)) {
			numRooms += Integer.parseInt(diningRoomTextField.getText());
			generateRoomSet(DiningRoom.class,
					Integer.parseInt(diningRoomTextField.getText()));
		} else {
			JOptionPane
					.showMessageDialog(frame,
							"Por favor use los números para describir el número de comedores.");
			return false;
		}

		if (livingSpaceTextField.getText().matches(regex)) {
			numRooms += Integer.parseInt(livingSpaceTextField.getText());
			generateRoomSet(LivingSpace.class,
					Integer.parseInt(livingSpaceTextField.getText()));
		} else {
			JOptionPane
					.showMessageDialog(frame,
							"Por favor use los números para describir el número de salas de estar.");
			return false;
		}

		if (laundryRoomTextField.getText().matches(regex)) {
			numRooms += Integer.parseInt(laundryRoomTextField.getText());
			generateRoomSet(LaundryRoom.class,
					Integer.parseInt(laundryRoomTextField.getText()));
		} else {
			JOptionPane
					.showMessageDialog(frame,
							"Por favor use los números para describir el número de lavanderos.");
			return false;
		}

		if (otherTextField.getText().matches(regex)) {
			numRooms += Integer.parseInt(otherTextField.getText());
			generateRoomSet(Other.class,
					Integer.parseInt(otherTextField.getText()));
		} else {
			JOptionPane
					.showMessageDialog(frame,
							"Por favor use los números para describir el número de otros.");
			return false;
		}

		if (numRooms <= 0) {
			JOptionPane.showMessageDialog(frame,
					"Se necesita por lo menos un área en una residencial.");
			return false;
		}

		return true;
	}

	private void generateRoomSet(Class<?> roomType, int numRooms) {
		//sort each room and assign previous and next forms to new form
		if (numRooms >= 1) {
			//create summary form
			EmissionsSummaryForm summaryForm = new ResidentialEmissionsSummaryForm(
					model);

			//for each room in the set to generate
			for (int count = 1; count <= numRooms; count++) {
				try {
					//create a new room to add
					ResidentialRoom roomToAdd = (ResidentialRoom) roomType
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
