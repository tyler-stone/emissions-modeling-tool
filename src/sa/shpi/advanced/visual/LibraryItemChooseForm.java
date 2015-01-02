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

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import sa.shpi.advanced.model.EmissionsItem;
import sa.shpi.advanced.model.Library;
import sa.shpi.advanced.model.Strings;

import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Dialog.ModalityType;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;

/**
 * Base class for selecting a material or furnishing from a list
 * or creating a custom material/furnishing
 * @author Tyler
 *
 */
public abstract class LibraryItemChooseForm extends JDialog {
	private static final int LIST = 0;
	private static final int CUSTOM = 1;
	private int matChoice = LIST;

	private Library lib;
	protected EmissionsItemRequesterForm requester;

	private JButton selectButton = new JButton(Strings.SELECT.toString());
	private JList<EmissionsItem> libraryList = new JList<EmissionsItem>();
	private JTextField nameLabel;
	private JTextField emissionsFactorLabel;
	private JTextField massLabel;

	public LibraryItemChooseForm(EmissionsItemRequesterForm requester,
			Library lib) {
		super(requester);
		this.lib = lib;
		this.requester = requester;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle(Strings.SELECT.toString() + " " + getLibraryType());
		setType(Type.UTILITY);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setAlwaysOnTop(true);
		setResizable(false);
		setBounds(100, 100, 371, 487);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 30, 27, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 0;
		panel.add(verticalStrut_2, gbc_verticalStrut_2);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 1;
		panel.add(horizontalStrut, gbc_horizontalStrut);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, Strings.SELECT.toString()
				+ " una " + getLibraryType(), TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		final ButtonGroup group = new ButtonGroup();
		JRadioButton rdbtnNewRadioButton = new JRadioButton(
				Strings.CHOOSE_FROM_LIST + ":");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				matChoice = LIST;
				libraryList.setEnabled(true);
				selectButton.setEnabled(false);

				nameLabel.setEditable(false);
				emissionsFactorLabel.setEditable(false);
				massLabel.setEditable(false);
			}
		});
		rdbtnNewRadioButton.setSelected(true);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 0;
		group.add(rdbtnNewRadioButton);
		panel_1.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(
				Strings.CUSTOM.toString());
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				matChoice = CUSTOM;
				libraryList.setEnabled(false);
				libraryList.clearSelection();

				selectButton.setEnabled(true);

				nameLabel.setEditable(true);
				emissionsFactorLabel.setEditable(true);
				massLabel.setEditable(true);
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);

		DefaultListModel<EmissionsItem> defaultListModel = new DefaultListModel<EmissionsItem>();
		for (int count = 0; count < lib.getLib().size(); count++) {
			defaultListModel.addElement(lib.getLib().get(count));
		}
		libraryList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!libraryList.isSelectionEmpty()) {
					selectButton.setEnabled(true);
					nameLabel.setText(libraryList.getSelectedValue().getName());
					emissionsFactorLabel.setText(String.valueOf(libraryList
							.getSelectedValue().getEmissionsFactor()));
					massLabel.setText(String.valueOf(libraryList
							.getSelectedValue().getMass()));
				}
			}
		});
		libraryList.setModel(defaultListModel);

		scrollPane.setViewportView(libraryList);
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_1.gridx = 0;
		gbc_rdbtnNewRadioButton_1.gridy = 2;
		group.add(rdbtnNewRadioButton_1);
		panel_1.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_2.gridx = 2;
		gbc_horizontalStrut_2.gridy = 1;
		panel.add(horizontalStrut_2, gbc_horizontalStrut_2);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 2;
		panel.add(verticalStrut, gbc_verticalStrut);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, getLibraryType() + " "
				+ Strings.DETAILS.toString(), TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 3;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblName = new JLabel(Strings.NAME.toString() + ":");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 0;
		panel_2.add(lblName, gbc_lblName);

		nameLabel = new JTextField();
		nameLabel.setEditable(false);
		nameLabel.setText(Strings.NONE.toString());
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameLabel.gridx = 2;
		gbc_nameLabel.gridy = 0;
		panel_2.add(nameLabel, gbc_nameLabel);
		nameLabel.setColumns(10);

		JLabel lblEmissionsFactor = new JLabel(
				Strings.EMISSIONS_FACTOR.toString() + ":");
		GridBagConstraints gbc_lblEmissionsFactor = new GridBagConstraints();
		gbc_lblEmissionsFactor.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmissionsFactor.anchor = GridBagConstraints.EAST;
		gbc_lblEmissionsFactor.gridx = 1;
		gbc_lblEmissionsFactor.gridy = 1;
		panel_2.add(lblEmissionsFactor, gbc_lblEmissionsFactor);

		emissionsFactorLabel = new JTextField();
		emissionsFactorLabel.setEditable(false);
		emissionsFactorLabel.setText("0.00");
		GridBagConstraints gbc_emissionsFactorLabel = new GridBagConstraints();
		gbc_emissionsFactorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emissionsFactorLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_emissionsFactorLabel.gridx = 2;
		gbc_emissionsFactorLabel.gridy = 1;
		panel_2.add(emissionsFactorLabel, gbc_emissionsFactorLabel);
		emissionsFactorLabel.setColumns(10);

		JLabel dwLabel = new JLabel(Strings.MASS.toString() + ":");
		GridBagConstraints gbc_dwLabel = new GridBagConstraints();
		gbc_dwLabel.insets = new Insets(0, 0, 0, 5);
		gbc_dwLabel.anchor = GridBagConstraints.EAST;
		gbc_dwLabel.gridx = 1;
		gbc_dwLabel.gridy = 2;
		panel_2.add(dwLabel, gbc_dwLabel);

		massLabel = new JTextField();
		massLabel.setEditable(false);
		massLabel.setText("0.00");
		GridBagConstraints gbc_massLabel = new GridBagConstraints();
		gbc_massLabel.insets = new Insets(0, 0, 0, 5);
		gbc_massLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_massLabel.gridx = 2;
		gbc_massLabel.gridy = 2;
		panel_2.add(massLabel, gbc_massLabel);
		massLabel.setColumns(10);

		JLabel unitsLabel = new JLabel(lib.getUnits());
		GridBagConstraints gbc_unitsLabel = new GridBagConstraints();
		gbc_unitsLabel.gridx = 3;
		gbc_unitsLabel.gridy = 2;
		panel_2.add(unitsLabel, gbc_unitsLabel);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 4;
		panel.add(verticalStrut_1, gbc_verticalStrut_1);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 5;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 0;
		panel_3.add(horizontalStrut_1, gbc_horizontalStrut_1);

		JButton cancelButton = new JButton(Strings.CANCEL.toString());
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.insets = new Insets(0, 0, 0, 5);
		gbc_cancelButton.gridx = 1;
		gbc_cancelButton.gridy = 0;
		panel_3.add(cancelButton, gbc_cancelButton);

		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (matChoice == LIST) {
					requester.addEmissionsItem(libraryList.getSelectedValue());
					setVisible(false);
					dispose();
				} else if (matChoice == CUSTOM) {
					EmissionsItem newEmissionsItem = new EmissionsItem();
					if (validate(newEmissionsItem)) {
						lib.getLib().add(newEmissionsItem);
						requester.addEmissionsItem(newEmissionsItem);
						setVisible(false);
						dispose();
					}
				}
			}
		});
		selectButton.setEnabled(false);
		GridBagConstraints gbc_selectButton = new GridBagConstraints();
		gbc_selectButton.gridx = 2;
		gbc_selectButton.gridy = 0;
		panel_3.add(selectButton, gbc_selectButton);

		setVisible(true);
	}

	protected boolean validate(EmissionsItem newEmissionsItem) {
		//validate all input
		String regex = "(^[0-9]+.[0-9]+$)|(^[0-9]+$)";

		newEmissionsItem.setName(nameLabel.getText());

		if (emissionsFactorLabel.getText().matches(regex)) {
			newEmissionsItem.setEmissionsFactor(Double
					.valueOf(emissionsFactorLabel.getText()));
		} else {
			JOptionPane.showMessageDialog(this, Strings.ERROR_BASE.toString()
					+ Strings.EMISSIONS_FACTOR.toString());
			return false;
		}

		if (massLabel.getText().matches(regex)) {
			newEmissionsItem.setMass(Double.valueOf(massLabel.getText()));
		} else {
			JOptionPane.showMessageDialog(this, Strings.ERROR_BASE.toString()
					+ Strings.MASS.toString());
			return false;
		}

		return true;
	}

	public void setLibrary(Library lib) {
		this.lib = lib;

	}

	public Library getLibrary() {
		return lib;
	}

	protected abstract String getLibraryType();
}
