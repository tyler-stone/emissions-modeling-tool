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

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sa.shpi.simple.model.Room;

/**
 * Room damage form used by residences and hospitals
 */
public class RoomDamageForm extends Form {

	// private JFrame frame;

	JTextArea damageLabel = new JTextArea();
	private JLabel nameLabel = new JLabel("No Data 1");
	private String[] damageDescription = {
			"(0%) Ninguna pérdida material a causa del incendio",
			"(20%) 20 por ciento del material disponible (la estructura y los contenidos conjuntos) está perdido",
			"(40%) 40 por ciento (un poco menos de un medio) del material disponible (la estructura y los contenidos conjuntos) está perdido",
			"(60%) 60 por ciento (un poco más de un medio) del material disponible (la estructura y los contenidos conjuntos) está perdido",
			"(80%) 80 por ciento del material disponible (la estructura y los contenidos conjuntos) está perdido",
			"(100%) Perdida completa a causa del incendio" };

	private Room parent;

	/**
	 * Create the form.
	 */
	public RoomDamageForm() {
		initialize();
	}

	public RoomDamageForm(Room parent) {
		this.parent = parent;
		this.nameLabel.setText(parent.getName());

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("La Calculadora de las Emisiones de Incendios Estructurales");
		frame.setBounds(100, 100, 405, 315);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 310, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 174, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 0;
		frame.getContentPane().add(verticalStrut, gbc_verticalStrut);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 0;
		gbc_horizontalStrut_2.gridy = 1;
		frame.getContentPane().add(horizontalStrut_2, gbc_horizontalStrut_2);

		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.anchor = GridBagConstraints.WEST;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 0);
		gbc_nameLabel.gridx = 1;
		gbc_nameLabel.gridy = 1;
		frame.getContentPane().add(nameLabel, gbc_nameLabel);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 2;
		frame.getContentPane().add(horizontalStrut_1, gbc_horizontalStrut_1);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Daño", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 46, 241, 0, 0 };
		gbl_panel.rowHeights = new int[] { 64, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		Component horizontalGlue = Box.createHorizontalGlue();
		GridBagConstraints gbc_horizontalGlue = new GridBagConstraints();
		gbc_horizontalGlue.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalGlue.gridx = 0;
		gbc_horizontalGlue.gridy = 0;
		panel.add(horizontalGlue, gbc_horizontalGlue);

		damageLabel.setLineWrap(true);
		damageLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		damageLabel.setWrapStyleWord(true);
		damageLabel.setEditable(false);
		damageLabel.setBackground(UIManager.getColor("menu"));
		damageLabel.setText("No Data");
		GridBagConstraints gbc_damageLabel = new GridBagConstraints();
		gbc_damageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_damageLabel.fill = GridBagConstraints.BOTH;
		gbc_damageLabel.gridx = 1;
		gbc_damageLabel.gridy = 0;
		panel.add(damageLabel, gbc_damageLabel);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		GridBagConstraints gbc_horizontalGlue_1 = new GridBagConstraints();
		gbc_horizontalGlue_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalGlue_1.gridx = 2;
		gbc_horizontalGlue_1.gridy = 0;
		panel.add(horizontalGlue_1, gbc_horizontalGlue_1);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 1;
		panel.add(verticalStrut_2, gbc_verticalStrut_2);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 0;
		gbc_horizontalStrut_3.gridy = 2;
		panel.add(horizontalStrut_3, gbc_horizontalStrut_3);

		final JSlider damageSlider = new JSlider();
		damageSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				damageLabel.setText(damageDescription[damageSlider.getValue()]);
			}
		});
		damageSlider.setValue(parent.getDamage());
		damageSlider.setSnapToTicks(true);
		damageSlider.setPaintLabels(true);
		damageSlider.setPaintTicks(true);
		damageSlider.setMajorTickSpacing(1);
		damageSlider.setMaximum(5);
		GridBagConstraints gbc_damageSlider = new GridBagConstraints();
		gbc_damageSlider.anchor = GridBagConstraints.WEST;
		gbc_damageSlider.insets = new Insets(0, 0, 5, 5);
		gbc_damageSlider.gridx = 1;
		gbc_damageSlider.gridy = 2;
		panel.add(damageSlider, gbc_damageSlider);

		Component verticalGlue = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue = new GridBagConstraints();
		gbc_verticalGlue.insets = new Insets(0, 0, 0, 5);
		gbc_verticalGlue.gridx = 1;
		gbc_verticalGlue.gridy = 3;
		panel.add(verticalGlue, gbc_verticalGlue);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 3;
		frame.getContentPane().add(verticalStrut_1, gbc_verticalStrut_1);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 4;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 165, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 0;
		panel_1.add(horizontalStrut, gbc_horizontalStrut);

		JButton backButton = new JButton("< Anterior");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showPreviousForm();
			}
		});
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.insets = new Insets(0, 0, 0, 5);
		gbc_backButton.gridx = 1;
		gbc_backButton.gridy = 0;
		panel_1.add(backButton, gbc_backButton);

		JButton nextButton = new JButton("Próximo >");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.setDamage(damageSlider.getValue());
				showNextForm();
			}
		});
		GridBagConstraints gbc_nextButton = new GridBagConstraints();
		gbc_nextButton.gridx = 2;
		gbc_nextButton.gridy = 0;
		panel_1.add(nextButton, gbc_nextButton);
	}

}
