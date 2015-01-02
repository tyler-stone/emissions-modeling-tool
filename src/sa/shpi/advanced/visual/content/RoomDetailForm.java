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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import sa.shpi.advanced.model.EmissionsItem;
import sa.shpi.advanced.model.Strings;
import sa.shpi.advanced.model.content.FurnishingList;
import sa.shpi.advanced.model.content.Room;
import sa.shpi.advanced.model.content.RoomType;
import sa.shpi.advanced.model.content.UsedFurnishing;
import sa.shpi.advanced.visual.AdvancedMainForm;
import sa.shpi.advanced.visual.EmissionsItemRequesterForm;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * Form for a room
 * Allows a user to add multiple furniture items to a room
 * @author Tyler
 *
 */
public class RoomDetailForm extends JDialog {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JList furnishingList = new JList();
	private JLabel damageLabel = new JLabel("100%");
	private JSlider damageSlider = new JSlider();

	private Room room;

	private AdvancedMainForm parent;

	/**
	 * Create the dialog.
	 */
	public RoomDetailForm(AdvancedMainForm parent) {
		super(parent.getFrame());

		room = new Room();
		room.setRoomType(RoomType.KITCHEN);

		setTitle(Strings.ROOM.toString());
		setType(Type.UTILITY);
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.parent = parent;

		setBounds(100, 100, 380, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null,
					Strings.ROOM_TYPE.toString(), TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0 };
			gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				final JComboBox roomTypeComboBox = new JComboBox();
				roomTypeComboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						room.setRoomType((RoomType) roomTypeComboBox
								.getSelectedItem());
					}
				});
				roomTypeComboBox.setModel(new DefaultComboBoxModel(RoomType
						.values()));
				GridBagConstraints gbc_roomTypeComboBox = new GridBagConstraints();
				gbc_roomTypeComboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_roomTypeComboBox.gridx = 0;
				gbc_roomTypeComboBox.gridy = 0;
				panel.add(roomTypeComboBox, gbc_roomTypeComboBox);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(
					EtchedBorder.LOWERED, null, null), Strings.FURNISHING
					.toString(), TitledBorder.LEADING, TitledBorder.TOP, null,
					null));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 1;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 0;
				gbc_scrollPane.gridy = 0;
				panel.add(scrollPane, gbc_scrollPane);
				{
					furnishingList = new JList();
					scrollPane.setViewportView(furnishingList);
				}
			}
			{
				JButton newItemButton = new JButton(Strings.ADD.toString()
						+ " " + Strings.FURNITURE_ITEM.toString() + "...");
				newItemButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FurnishingDetailForm furnishingForm = new FurnishingDetailForm(
								RoomDetailForm.this);
					}
				});
				newItemButton.setHorizontalAlignment(SwingConstants.LEFT);
				GridBagConstraints gbc_newItemButton = new GridBagConstraints();
				gbc_newItemButton.anchor = GridBagConstraints.WEST;
				gbc_newItemButton.gridx = 0;
				gbc_newItemButton.gridy = 1;
				panel.add(newItemButton, gbc_newItemButton);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(
					EtchedBorder.LOWERED, null, null), Strings.DAMAGE
					.toString(), TitledBorder.LEADING, TitledBorder.TOP, null,
					null));
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 2;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				JLabel lblNewLabel = new JLabel(
						Strings.PERCENT_DAMAGE.toString() + ":");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 0;
				panel.add(lblNewLabel, gbc_lblNewLabel);
			}
			{

				GridBagConstraints gbc_damageLabel = new GridBagConstraints();
				gbc_damageLabel.anchor = GridBagConstraints.WEST;
				gbc_damageLabel.insets = new Insets(0, 0, 5, 0);
				gbc_damageLabel.gridx = 1;
				gbc_damageLabel.gridy = 0;
				panel.add(damageLabel, gbc_damageLabel);
			}
			{
				damageSlider.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent arg0) {
						damageLabel.setText(String.valueOf(damageSlider
								.getValue()) + "%");
						room.setDamage(damageSlider.getValue());
					}
				});
				damageSlider.setValue(100);
				damageSlider.setMajorTickSpacing(10);
				damageSlider.setPaintTicks(true);
				damageSlider.setPaintLabels(true);
				GridBagConstraints gbc_damageSlider = new GridBagConstraints();
				gbc_damageSlider.anchor = GridBagConstraints.NORTH;
				gbc_damageSlider.gridx = 1;
				gbc_damageSlider.gridy = 1;
				panel.add(damageSlider, gbc_damageSlider);
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
						getParentForm().addRoom(room);
						setVisible(false);
						dispose();
					}
				});
				buttonPane.add(addButton);
			}
		}

		setVisible(true);
	}

	public AdvancedMainForm getParentForm() {
		return parent;
	}

	public void addFurnitureItem(UsedFurnishing uFurnishing) {
		//get furnishing item from the furnishing detail form and add it to the room
		room.addFurnishing(uFurnishing);

		DefaultListModel<UsedFurnishing> defaultListModel = new DefaultListModel<UsedFurnishing>();
		FurnishingList roomFurnishingList = room.getFurnishingList();
		for (int count = 0; count < roomFurnishingList.size(); count++) {
			defaultListModel.addElement(roomFurnishingList.get(count));
		}

		furnishingList.setModel(defaultListModel);
	}

}
