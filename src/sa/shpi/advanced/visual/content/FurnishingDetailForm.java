/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.advanced.visual.content;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sa.shpi.advanced.model.EmissionsItem;
import sa.shpi.advanced.model.Strings;
import sa.shpi.advanced.model.content.UsedFurnishing;
import sa.shpi.advanced.model.structure.SectionCategory;
import sa.shpi.advanced.model.structure.UsedMaterial;
import sa.shpi.advanced.visual.EmissionsItemRequesterForm;
import sa.shpi.advanced.visual.structure.MaterialDetailForm;

import java.awt.Dialog.ModalityType;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

/**
 * Furnishing detail form
 * Allows a user to choose the quantity of the item and then add it to a room
 * @author Tyler
 *
 */
public class FurnishingDetailForm extends EmissionsItemRequesterForm {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private RoomDetailForm parent;
	private EmissionsItem furnishing;
	private JTextField furnishingNameLabel;
	private JLabel massLabel;
	private JTextField quantityTextField;
	private JLabel emissionsFactorLabel;

	/**
	 * Create the dialog.
	 */
	public FurnishingDetailForm(RoomDetailForm parent) {
		furnishing = new EmissionsItem(Strings.NONE.toString(), 0.00, 0.00);

		setTitle(Strings.FURNISHING.toString());
		setModalityType(ModalityType.APPLICATION_MODAL);
		this.parent = parent;

		setBounds(100, 100, 295, 205);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, Strings.CHOOSE.toString()
					+ " " + Strings.FURNISHING.toString(),
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0 };
			gbl_panel.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				furnishingNameLabel = new JTextField();
				furnishingNameLabel.setEditable(false);
				furnishingNameLabel.setText(Strings.NONE.toString());
				GridBagConstraints gbc_furnishingNameLabel = new GridBagConstraints();
				gbc_furnishingNameLabel.insets = new Insets(0, 0, 0, 5);
				gbc_furnishingNameLabel.fill = GridBagConstraints.HORIZONTAL;
				gbc_furnishingNameLabel.gridx = 0;
				gbc_furnishingNameLabel.gridy = 0;
				panel.add(furnishingNameLabel, gbc_furnishingNameLabel);
				furnishingNameLabel.setColumns(10);
			}
			{
				JButton chooseButton = new JButton(Strings.CHOOSE.toString()
						+ "...");
				chooseButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FurnishingChooseForm newFurnishingForm = new FurnishingChooseForm(
								FurnishingDetailForm.this, getParentForm()
										.getParentForm().getTool()
										.getFurnishingsLibrary());
					}
				});
				GridBagConstraints gbc_chooseButton = new GridBagConstraints();
				gbc_chooseButton.gridx = 1;
				gbc_chooseButton.gridy = 0;
				panel.add(chooseButton, gbc_chooseButton);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(
					EtchedBorder.LOWERED, null, null), Strings.DETAILS
					.toString(), TitledBorder.LEADING, TitledBorder.TOP, null,
					null));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 1;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0,
					Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				JLabel lblQuantityOfItem = new JLabel(
						Strings.QUANTITY_OF_ITEM.toString() + ":");
				GridBagConstraints gbc_lblQuantityOfItem = new GridBagConstraints();
				gbc_lblQuantityOfItem.insets = new Insets(0, 0, 5, 5);
				gbc_lblQuantityOfItem.anchor = GridBagConstraints.EAST;
				gbc_lblQuantityOfItem.gridx = 0;
				gbc_lblQuantityOfItem.gridy = 0;
				panel.add(lblQuantityOfItem, gbc_lblQuantityOfItem);
			}
			{
				quantityTextField = new JTextField();
				quantityTextField.setText("1");
				GridBagConstraints gbc_quantityTextField = new GridBagConstraints();
				gbc_quantityTextField.insets = new Insets(0, 0, 5, 0);
				gbc_quantityTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_quantityTextField.gridx = 1;
				gbc_quantityTextField.gridy = 0;
				panel.add(quantityTextField, gbc_quantityTextField);
				quantityTextField.setColumns(10);
			}
			{
				JLabel lblNewLabel = new JLabel(
						Strings.EMISSIONS_FACTOR.toString() + ":");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 1;
				panel.add(lblNewLabel, gbc_lblNewLabel);
			}
			{
				emissionsFactorLabel = new JLabel("0.00");
				GridBagConstraints gbc_emissionsFactorLabel = new GridBagConstraints();
				gbc_emissionsFactorLabel.anchor = GridBagConstraints.WEST;
				gbc_emissionsFactorLabel.insets = new Insets(0, 0, 5, 0);
				gbc_emissionsFactorLabel.gridx = 1;
				gbc_emissionsFactorLabel.gridy = 1;
				panel.add(emissionsFactorLabel, gbc_emissionsFactorLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel(Strings.MASS.toString() + ":");
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel_1.gridx = 0;
				gbc_lblNewLabel_1.gridy = 2;
				panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			}
			{
				massLabel = new JLabel("0.00 kg");
				GridBagConstraints gbc_massLabel = new GridBagConstraints();
				gbc_massLabel.anchor = GridBagConstraints.WEST;
				gbc_massLabel.gridx = 1;
				gbc_massLabel.gridy = 2;
				panel.add(massLabel, gbc_massLabel);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton(Strings.CANCEL.toString());
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				buttonPane.add(cancelButton);
				getRootPane().setDefaultButton(cancelButton);
			}
			{
				JButton addButton = new JButton(Strings.ADD.toString());
				addButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						UsedFurnishing uFurnishing = new UsedFurnishing();

						if (!(furnishing.getName() == Strings.NONE.toString())) {
							if (validate(uFurnishing)) {
								getParentForm().addFurnitureItem(uFurnishing);
								setVisible(false);
								dispose();
							}
						} else {
							JOptionPane.showMessageDialog(
									FurnishingDetailForm.this,
									Strings.PLEASE_CHOOSE.toString() + " "
											+ Strings.FURNISHING.toString());
						}
					}
				});
				buttonPane.add(addButton);
			}
		}

		setVisible(true);
	}

	protected boolean validate(UsedFurnishing uFurnishing) {
		//validate all input
		String regex = "^[1-9][0-9]*$";

		if (quantityTextField.getText().matches(regex)) {
			uFurnishing
					.setQuantity(Integer.valueOf(quantityTextField.getText()));
		} else {
			JOptionPane.showMessageDialog(this, Strings.ERROR_BASE.toString()
					+ Strings.QUANTITY.toString());
			return false;
		}

		uFurnishing.setFurnishing(furnishing);

		return true;
	}

	@Override
	public void addEmissionsItem(EmissionsItem eItem) {
		//get result from furnishing choose form and set it as the furnishing
		furnishing = eItem;
		furnishingNameLabel.setText(furnishing.getName());
		emissionsFactorLabel.setText(String.valueOf(furnishing
				.getEmissionsFactor()));
		massLabel.setText(String.valueOf(furnishing.getMass()) + " kg");
	}

	public RoomDetailForm getParentForm() {
		return parent;
	}

}
