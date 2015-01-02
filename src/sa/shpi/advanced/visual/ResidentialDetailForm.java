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
import java.awt.Window.Type;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;

import sa.shpi.advanced.model.Strings;
import sa.shpi.advanced.model.Residential;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;

/**
 * When creating a new residential building, this form allows
 * the user to input the total area and area affected
 * @author Tyler
 *
 */
public class ResidentialDetailForm extends JDialog {
	private static final long serialVersionUID = 1L;

	// private JFrame frame;
	private AdvancedMainForm parent;
	private JTextField totalAreaTextField;
	private JTextField areaBurnedTextField;

	public ResidentialDetailForm(AdvancedMainForm parent) {
		super(parent.getFrame());
		this.parent = parent;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle(Strings.NEW_RESIDENTIAL.toString());
		setLocationRelativeTo(parent.getFrame());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 255, 229);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 70, 100, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 0;
		panel.add(verticalStrut, gbc_verticalStrut);

		JLabel lblNewLabel = new JLabel(Strings.AREA_TOTAL.toString());
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 2;
		panel.add(horizontalStrut, gbc_horizontalStrut);

		totalAreaTextField = new JTextField();
		totalAreaTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		totalAreaTextField.setText("0");
		GridBagConstraints gbc_totalAreaTextField = new GridBagConstraints();
		gbc_totalAreaTextField.insets = new Insets(0, 0, 5, 5);
		gbc_totalAreaTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_totalAreaTextField.gridx = 1;
		gbc_totalAreaTextField.gridy = 2;
		panel.add(totalAreaTextField, gbc_totalAreaTextField);
		totalAreaTextField.setColumns(10);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 3;
		panel.add(verticalStrut_1, gbc_verticalStrut_1);

		JLabel lblNewLabel_1 = new JLabel(Strings.AREA_BURNED.toString());
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 5;
		panel.add(horizontalStrut_1, gbc_horizontalStrut_1);

		areaBurnedTextField = new JTextField();
		areaBurnedTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		areaBurnedTextField.setText("0");
		GridBagConstraints gbc_areaBurnedTextField = new GridBagConstraints();
		gbc_areaBurnedTextField.insets = new Insets(0, 0, 5, 5);
		gbc_areaBurnedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_areaBurnedTextField.gridx = 1;
		gbc_areaBurnedTextField.gridy = 5;
		panel.add(areaBurnedTextField, gbc_areaBurnedTextField);
		areaBurnedTextField.setColumns(10);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 6;
		panel.add(verticalStrut_2, gbc_verticalStrut_2);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_2.gridx = 0;
		gbc_horizontalStrut_2.gridy = 7;
		panel.add(horizontalStrut_2, gbc_horizontalStrut_2);

		JButton cancelButton = new JButton(Strings.CANCEL.toString());
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.anchor = GridBagConstraints.EAST;
		gbc_cancelButton.insets = new Insets(0, 0, 0, 5);
		gbc_cancelButton.gridx = 1;
		gbc_cancelButton.gridy = 7;
		panel.add(cancelButton, gbc_cancelButton);

		JButton addButton = new JButton(Strings.ADD.toString());
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Residential res = new Residential();
				if (saveToModel(res)) {
					parent.addResidentialItem(res);
					setVisible(false);
					dispose();
				}
			}
		});
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.gridx = 2;
		gbc_addButton.gridy = 7;
		panel.add(addButton, gbc_addButton);

		this.setVisible(true);
	}

	public boolean saveToModel(Residential res) {
		//validate all inputs
		String regex = "^[1-9][0-9]*$";

		if (totalAreaTextField.getText().matches(regex)) {
			res.setAreaTotal(Integer.parseInt(totalAreaTextField.getText()));
		} else {
			JOptionPane.showMessageDialog(this, Strings.ERROR_BASE.toString()
					+ Strings.AREA_TOTAL);
			return false;
		}

		if (areaBurnedTextField.getText().matches(regex)) {
			res.setAreaBurned(Integer.parseInt(areaBurnedTextField.getText()));
		} else {
			JOptionPane.showMessageDialog(this, Strings.ERROR_BASE.toString()
					+ Strings.AREA_BURNED);
			return false;
		}

		if (res.getAreaBurned() > res.getAreaTotal()) {
			JOptionPane.showMessageDialog(this,
					Strings.ERROR_BURNED_BIGGER.toString());
			return false;
		}

		return true;
	}

}
