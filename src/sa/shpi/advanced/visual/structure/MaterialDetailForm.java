/*******************************************************************************
 * This application was developed as a part of an Interactive
 * Qualifying Project for Worcester Polytechnic Institute
 * and our sponsor, SHPI Ingenieria.
 * 
 * Developer: Tyler Stone
 * Authors: Alexandra Hardin, Eric Schattschneider,
 *                Tyler Stone, Kristina Walker
 ******************************************************************************/
package sa.shpi.advanced.visual.structure;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Window.Type;

import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.DefaultComboBoxModel;

import sa.shpi.advanced.model.EmissionsItem;
import sa.shpi.advanced.model.Strings;
import sa.shpi.advanced.model.structure.Section;
import sa.shpi.advanced.model.structure.SectionCategory;
import sa.shpi.advanced.model.structure.UsedMaterial;
import sa.shpi.advanced.visual.AdvancedMainForm;
import sa.shpi.advanced.visual.EmissionsItemRequesterForm;

import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSlider;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpringLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Dialog.ModalityType;
import java.util.ArrayList;
import java.util.EnumSet;

/**
 * Material Detail Form receives a material and allows the user
 * to adjust the percent of the selected structural location that is 
 * comprised of that material
 * @author Tyler
 *
 */
public class MaterialDetailForm extends EmissionsItemRequesterForm {
	private static final long serialVersionUID = 1L;

	AdvancedMainForm parent;

	private JTextField materialText;
	private JSlider percentSlider;
	private JComboBox<SectionCategory> sectionComboBox;

	private EmissionsItem material;

	private JLabel densityLabel;
	private JLabel emissionsFactorLabel;

	public MaterialDetailForm(AdvancedMainForm parent) {
		super(parent.getFrame());
		this.parent = parent;
		this.material = new EmissionsItem(Strings.NONE.toString(), 0.00, 0.00);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle(Strings.MATERIAL.toString());
		setType(Type.UTILITY);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setBounds(100, 100, 388, 360);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 130, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		densityLabel = new JLabel(Double.toString(material.getMass())
				+ " kg/m^2");
		emissionsFactorLabel = new JLabel(Double.toString(material
				.getEmissionsFactor()));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, Strings.MATERIAL_LOCATION
				.toString(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 94, 0 };
		gbl_panel_1.rowHeights = new int[] { 22, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		sectionComboBox = new JComboBox<SectionCategory>();
		sectionComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSliderMax();
			}
		});

		EnumSet<SectionCategory> incompleteSectionCategories = EnumSet
				.noneOf(SectionCategory.class);
		ArrayList<Section> incompleteSections = parent.getTool()
				.getResidential().getIncompleteSections();

		for (int count = 0; count < incompleteSections.size(); count++) {
			if (!(incompleteSections.get(count).isComplete())) {
				incompleteSectionCategories.add(incompleteSections.get(count)
						.getSectionCategory());
			}
		}

		sectionComboBox.setModel(new DefaultComboBoxModel(
				incompleteSectionCategories.toArray()));
		GridBagConstraints gbc_sectionComboBox = new GridBagConstraints();
		gbc_sectionComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_sectionComboBox.anchor = GridBagConstraints.NORTH;
		gbc_sectionComboBox.gridx = 0;
		gbc_sectionComboBox.gridy = 0;
		panel_1.add(sectionComboBox, gbc_sectionComboBox);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, Strings.MATERIAL.toString(),
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 0;
		panel_2.add(verticalStrut_1, gbc_verticalStrut_1);

		materialText = new JTextField();
		materialText.setEditable(false);
		materialText.setText(material.getName());
		GridBagConstraints gbc_materialText = new GridBagConstraints();
		gbc_materialText.insets = new Insets(0, 0, 5, 5);
		gbc_materialText.fill = GridBagConstraints.HORIZONTAL;
		gbc_materialText.gridx = 0;
		gbc_materialText.gridy = 1;
		panel_2.add(materialText, gbc_materialText);
		materialText.setColumns(10);

		JButton materialSelectionButton = new JButton(Strings.CHOOSE.toString()
				+ "...");
		materialSelectionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaterialChooseForm matForm = new MaterialChooseForm(
						MaterialDetailForm.this, parent.getTool()
								.getMaterialsLibrary());
			}
		});
		GridBagConstraints gbc_materialSelectionButton = new GridBagConstraints();
		gbc_materialSelectionButton.insets = new Insets(0, 0, 5, 0);
		gbc_materialSelectionButton.gridx = 1;
		gbc_materialSelectionButton.gridy = 1;
		panel_2.add(materialSelectionButton, gbc_materialSelectionButton);

		Component verticalStrut_7 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7 = new GridBagConstraints();
		gbc_verticalStrut_7.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_7.gridx = 0;
		gbc_verticalStrut_7.gridy = 2;
		panel_2.add(verticalStrut_7, gbc_verticalStrut_7);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, Strings.DETAILS.toString(),
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.NORTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 115, 80, 0 };
		gbl_panel_3.rowHeights = new int[] { 14, 14, 14, 18, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel lblEmissionsFactor = new JLabel(
				Strings.EMISSIONS_FACTOR.toString() + ":");
		lblEmissionsFactor.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblEmissionsFactor = new GridBagConstraints();
		gbc_lblEmissionsFactor.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblEmissionsFactor.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmissionsFactor.gridx = 0;
		gbc_lblEmissionsFactor.gridy = 0;
		panel_3.add(lblEmissionsFactor, gbc_lblEmissionsFactor);

		GridBagConstraints gbc_emissionsFactorLabel = new GridBagConstraints();
		gbc_emissionsFactorLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_emissionsFactorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emissionsFactorLabel.gridx = 1;
		gbc_emissionsFactorLabel.gridy = 0;
		panel_3.add(emissionsFactorLabel, gbc_emissionsFactorLabel);

		JLabel lblNewLabel_1 = new JLabel(Strings.MASS.toString() + ":");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);

		densityLabel = new JLabel(Double.toString(material.getMass())
				+ " kg/m^2");
		GridBagConstraints gbc_densityLabel = new GridBagConstraints();
		gbc_densityLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_densityLabel.insets = new Insets(0, 0, 5, 5);
		gbc_densityLabel.gridx = 1;
		gbc_densityLabel.gridy = 1;
		panel_3.add(densityLabel, gbc_densityLabel);

		JLabel lblPercentOfLocation = new JLabel(
				Strings.PERCENT_OF_LOCATION.toString() + ":");
		lblPercentOfLocation.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblPercentOfLocation = new GridBagConstraints();
		gbc_lblPercentOfLocation.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblPercentOfLocation.insets = new Insets(0, 0, 5, 5);
		gbc_lblPercentOfLocation.gridx = 0;
		gbc_lblPercentOfLocation.gridy = 2;
		panel_3.add(lblPercentOfLocation, gbc_lblPercentOfLocation);

		final JLabel percentLabel = new JLabel("100%");
		GridBagConstraints gbc_percentLabel = new GridBagConstraints();
		gbc_percentLabel.anchor = GridBagConstraints.WEST;
		gbc_percentLabel.insets = new Insets(0, 0, 5, 5);
		gbc_percentLabel.gridx = 1;
		gbc_percentLabel.gridy = 2;
		panel_3.add(percentLabel, gbc_percentLabel);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_3.gridx = 0;
		gbc_verticalStrut_3.gridy = 3;
		panel_3.add(verticalStrut_3, gbc_verticalStrut_3);

		percentSlider = new JSlider();
		percentSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				percentLabel.setText(String.valueOf(percentSlider.getValue())
						+ "%");
			}
		});
		percentSlider.setMajorTickSpacing(10);
		percentSlider.setValue(100);
		percentSlider.setPaintTicks(true);
		percentSlider.setPaintLabels(true);
		GridBagConstraints gbc_percentSlider = new GridBagConstraints();
		gbc_percentSlider.fill = GridBagConstraints.HORIZONTAL;
		gbc_percentSlider.anchor = GridBagConstraints.NORTH;
		gbc_percentSlider.gridwidth = 2;
		gbc_percentSlider.gridx = 1;
		gbc_percentSlider.gridy = 3;
		panel_3.add(percentSlider, gbc_percentSlider);
		updateSliderMax();

		Component verticalStrut_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_6.gridx = 0;
		gbc_verticalStrut_6.gridy = 3;
		panel.add(verticalStrut_6, gbc_verticalStrut_6);

		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 4;
		panel.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		JButton cancelButton = new JButton(Strings.CANCEL.toString());
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_2.gridx = 0;
		gbc_horizontalStrut_2.gridy = 0;
		panel_4.add(horizontalStrut_2, gbc_horizontalStrut_2);
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.insets = new Insets(0, 0, 0, 5);
		gbc_cancelButton.gridx = 1;
		gbc_cancelButton.gridy = 0;
		panel_4.add(cancelButton, gbc_cancelButton);

		JButton addButton = new JButton(Strings.ADD.toString());
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(material.getName() == Strings.NONE.toString())) {
					UsedMaterial uMaterial = new UsedMaterial(percentSlider
							.getValue(), material);
					parent.addStructureItem(((SectionCategory) sectionComboBox
							.getSelectedItem()), uMaterial);
					setVisible(false);
					dispose();
				} else {
					JOptionPane.showMessageDialog(MaterialDetailForm.this,
							Strings.PLEASE_CHOOSE.toString() + " "
									+ Strings.MATERIAL.toString());
				}
			}
		});
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.gridx = 2;
		gbc_addButton.gridy = 0;
		panel_4.add(addButton, gbc_addButton);

		setVisible(true);
	}

	protected void updateSliderMax() {
		//change the slider max value depending on the structural component chosen
		SectionCategory section = (SectionCategory) sectionComboBox
				.getSelectedItem();
		percentSlider.setMaximum(parent.getTool().getResidential()
				.getSection(section).getPercentRemaining());
	}

	@Override
	public void addEmissionsItem(EmissionsItem eItem) {
		//add chosen material that was selected
		this.material = eItem;
		materialText.setText(material.getName());
		emissionsFactorLabel.setText(String.valueOf(material
				.getEmissionsFactor()));
		densityLabel.setText(String.valueOf(material.getMass()) + " kg/m^2");
	}
}
