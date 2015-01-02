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
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JTree;
import java.awt.GridBagLayout;
import javax.swing.JToolBar;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.JButton;

import sa.shpi.SHPIImagePanel;
import sa.shpi.advanced.AdvancedTool;
import sa.shpi.advanced.model.Residential;
import sa.shpi.advanced.model.Strings;
import sa.shpi.advanced.model.content.FurnishingList;
import sa.shpi.advanced.model.content.Room;
import sa.shpi.advanced.model.structure.MaterialList;
import sa.shpi.advanced.model.structure.Section;
import sa.shpi.advanced.model.structure.SectionCategory;
import sa.shpi.advanced.model.structure.UsedMaterial;
import sa.shpi.advanced.pdf.PdfGenerator;
import sa.shpi.advanced.visual.content.RoomDetailForm;
import sa.shpi.advanced.visual.structure.MaterialDetailForm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;

/**
 * Main landing form for the advanced model
 * @author Tyler
 *
 */
public class AdvancedMainForm {
	private JFrame frame;
	JTree tree = new JTree();

	JMenuItem mntmResidential = new JMenuItem(Strings.RESIDENTIAL.toString()
			+ "...");
	JMenuItem mntmStructureItem = new JMenuItem(
			Strings.STRUCTURE_ITEM.toString() + "...");
	JMenuItem mntmAffectedRoom = new JMenuItem(Strings.AFFECTED_ROOM.toString()
			+ "...");

	private AdvancedTool tool;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JMenu mnNew_1 = new JMenu(Strings.NUEVO.toString());
	private final JMenuItem resetButton = new JMenuItem(
			Strings.RESET.toString());
	private final JMenuItem exitButton = new JMenuItem(Strings.EXIT.toString());
	private final JPanel panel_1 = new JPanel();
	private final JButton newStructureMaterialButton = new JButton(
			Strings.NUEVO.toString() + " " + Strings.STRUCTURE_ITEM.toString()
					+ "...");
	private final JButton newAffectedRoomButton = new JButton(
			Strings.NUEVA.toString() + " " + Strings.AFFECTED_ROOM.toString()
					+ "...");
	private final JMenu mnRun = new JMenu(Strings.RUN.toString());
	private final JMenuItem generateReportButton = new JMenuItem(
			Strings.GENERATE_REPORT.toString());
	private final JPanel panel_2 = new JPanel();
	private final JLabel emissionsTotalLabel = new JLabel("0.00 kg CO2");
	private final JButton newResidentialButton = new JButton(
			Strings.NEW_RESIDENTIAL.toString() + "...");
	private final SHPIImagePanel shpiSplashPanel = new SHPIImagePanel();
	private final Component horizontalStrut = Box.createHorizontalStrut(20);
	private final JMenu mnHelp = new JMenu(Strings.HELP.toString());
	private final JMenuItem mntmAbout = new JMenuItem(Strings.ABOUT.toString()
			+ "...");

	/**
	 * @wbp.parser.constructor
	 */
	public AdvancedMainForm() {
		initialize();
	}

	public AdvancedMainForm(AdvancedTool tool) {
		this.tool = tool;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle(Strings.RESIDENTIAL_EMISSIONS_CALCULATOR.toString());
		frame.setBounds(100, 100, 570, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 297, 234, 0 };
		gridBagLayout.rowHeights = new int[] { 376, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		scrollPane.setViewportView(tree);

		DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree
				.getCellRenderer();
		renderer.setLeafIcon(null);
		renderer.setClosedIcon(null);
		renderer.setOpenIcon(null);

		tree.setCellRenderer(renderer);
		tree.setRootVisible(true);
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode(
				Strings.INSTRUCTION_TREE) {
			{
			}
		}));

		scrollPane.setColumnHeaderView(horizontalStrut);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel_1.setBorder(new TitledBorder(null, Strings.CREATE.toString(),
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		GridBagConstraints gbc_newResidentialButton = new GridBagConstraints();
		gbc_newResidentialButton.insets = new Insets(0, 0, 5, 0);
		gbc_newResidentialButton.gridx = 0;
		gbc_newResidentialButton.gridy = 0;
		newResidentialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmResidential.doClick();
			}
		});
		panel_1.add(newResidentialButton, gbc_newResidentialButton);

		GridBagConstraints gbc_newStructureMaterialButton = new GridBagConstraints();
		gbc_newStructureMaterialButton.insets = new Insets(0, 0, 5, 0);
		gbc_newStructureMaterialButton.gridx = 0;
		gbc_newStructureMaterialButton.gridy = 1;
		newStructureMaterialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmStructureItem.doClick();
			}
		});
		newStructureMaterialButton.setEnabled(false);
		panel_1.add(newStructureMaterialButton, gbc_newStructureMaterialButton);

		GridBagConstraints gbc_newAffectedRoomButton = new GridBagConstraints();
		gbc_newAffectedRoomButton.gridx = 0;
		gbc_newAffectedRoomButton.gridy = 2;
		newAffectedRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmAffectedRoom.doClick();
			}
		});
		newAffectedRoomButton.setEnabled(false);
		panel_1.add(newAffectedRoomButton, gbc_newAffectedRoomButton);

		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel_2.setBorder(new TitledBorder(null, Strings.EMISSIONS_TOTAL
				.toString(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2, gbc_panel_2);
		emissionsTotalLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

		panel_2.add(emissionsTotalLabel);

		GridBagConstraints gbc_shpiSplashPanel = new GridBagConstraints();
		gbc_shpiSplashPanel.fill = GridBagConstraints.BOTH;
		gbc_shpiSplashPanel.gridx = 0;
		gbc_shpiSplashPanel.gridy = 2;
		panel.add(shpiSplashPanel, gbc_shpiSplashPanel);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNew = new JMenu(Strings.FILE.toString());
		menuBar.add(mnNew);

		mnNew.add(mnNew_1);
		mnNew_1.add(mntmResidential);
		mnNew_1.add(mntmStructureItem);

		mntmStructureItem.setEnabled(false);
		mnNew_1.add(mntmAffectedRoom);
		mntmAffectedRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomDetailForm newRoomForm = new RoomDetailForm(
						AdvancedMainForm.this);
			}
		});

		mntmAffectedRoom.setEnabled(false);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool.setResidential(new Residential());

				mntmResidential.setEnabled(true);
				mntmStructureItem.setEnabled(false);
				mntmAffectedRoom.setEnabled(false);
				generateReportButton.setEnabled(false);

				newResidentialButton.setEnabled(true);
				newStructureMaterialButton.setEnabled(false);
				newAffectedRoomButton.setEnabled(false);

				resetAll();
			}
		});

		mnNew.add(resetButton);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});

		mnNew.add(exitButton);

		menuBar.add(mnRun);
		generateReportButton.setEnabled(false);
		generateReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PdfGenerator generate = new PdfGenerator(tool.getResidential());
				JOptionPane.showMessageDialog(frame,
						Strings.SUCCESSFUL_REPORT.toString());
			}
		});

		mnRun.add(generateReportButton);

		menuBar.add(mnHelp);
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutForm aboutForm = new AboutForm();
			}
		});

		mnHelp.add(mntmAbout);
		mntmStructureItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaterialDetailForm newMatForm = new MaterialDetailForm(
						AdvancedMainForm.this);
			}
		});

		mntmResidential.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResidentialDetailForm newResForm = new ResidentialDetailForm(
						AdvancedMainForm.this);
			}
		});

	}

	public void addResidentialItem(Residential res) {
		// update visual components
		mntmResidential.setEnabled(false);
		mntmStructureItem.setEnabled(true);
		mntmAffectedRoom.setEnabled(true);
		generateReportButton.setEnabled(true);

		newResidentialButton.setEnabled(false);
		newStructureMaterialButton.setEnabled(true);
		newAffectedRoomButton.setEnabled(true);

		//set the new residential model
		tool.setResidential(res);

		refreshAll();
	}

	public void addStructureItem(SectionCategory section, UsedMaterial uMaterial) {
		//add a material to the structural area chosen
		tool.getResidential().getSection(section).addMaterial(uMaterial);
		if (tool.getResidential().getIncompleteSections().isEmpty()) {
			mntmStructureItem.setEnabled(false);
			newStructureMaterialButton.setEnabled(false);
		}
		refreshAll();
	}

	public void addRoom(Room room) {
		//add a room to the residential building
		tool.getResidential().addRoom(room);
		refreshAll();
	}

	public void resetAll() {
		//remove all nodes in the tree and update the emissions label
		tree.removeAll();
		refreshEmissionsLabel();
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(
				Strings.INSTRUCTION_TREE.toString());
		tree.setModel(new DefaultTreeModel(top));
	}

	public void refreshAll() {
		refreshEmissionsLabel();
		refreshTree();
	}

	public void refreshEmissionsLabel() {
		emissionsTotalLabel.setText(String.format("%.2f kg CO2", tool
				.getResidential().getTotalEmissions()));
	}

	public void refreshTree() {
		//dynamically create tree for the residential building
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(
				tool.getResidential());

		DefaultMutableTreeNode structure = new DefaultMutableTreeNode(
				Strings.STRUCTURE.toString()
						+ String.format(" (%.2f kg CO2)", tool.getResidential()
								.getStructureEmissions()));

		DefaultMutableTreeNode internalWalls = new DefaultMutableTreeNode(tool
				.getResidential().getInternalWalls());
		DefaultMutableTreeNode externalWalls = new DefaultMutableTreeNode(tool
				.getResidential().getExternalWalls());
		DefaultMutableTreeNode ceiling = new DefaultMutableTreeNode(tool
				.getResidential().getCeiling());
		DefaultMutableTreeNode flooring = new DefaultMutableTreeNode(tool
				.getResidential().getFlooring());
		DefaultMutableTreeNode roofing = new DefaultMutableTreeNode(tool
				.getResidential().getRoofing());

		addTreeMaterials(tool.getResidential().getCeiling(), ceiling);
		addTreeMaterials(tool.getResidential().getExternalWalls(),
				externalWalls);
		addTreeMaterials(tool.getResidential().getInternalWalls(),
				internalWalls);
		addTreeMaterials(tool.getResidential().getFlooring(), flooring);
		addTreeMaterials(tool.getResidential().getRoofing(), roofing);

		structure.add(internalWalls);
		structure.add(externalWalls);
		structure.add(ceiling);
		structure.add(flooring);
		structure.add(roofing);

		DefaultMutableTreeNode content = new DefaultMutableTreeNode(
				Strings.CONTENT.toString()
						+ String.format(" (%.2f kg CO2)", tool.getResidential()
								.getContentEmissions()));
		addRooms(tool.getResidential().getRooms(), content);

		top.add(structure);
		top.add(content);

		TreeModel treeModel = new DefaultTreeModel(top);

		tree.removeAll();
		tree.setModel(treeModel);

		for (int count = 0; count < tree.getRowCount(); count++) {
			tree.expandRow(count);
		}
	}

	private void addRooms(ArrayList<Room> rooms,
			DefaultMutableTreeNode contentNode) {
		//add room nodes to the content node
		//loop through each room
		if (rooms.size() > 0) {
			for (int count = 0; count < rooms.size(); count++) {
				//create a new node
				DefaultMutableTreeNode roomNode = new DefaultMutableTreeNode(
						rooms.get(count));
				//add furnishings to the node
				addFurnishings(rooms.get(count).getFurnishingList(), roomNode);
				//add room to the content node
				contentNode.add(roomNode);
			}
		} else {
			//no rooms, add (none)
			contentNode.add(new DefaultMutableTreeNode("("
					+ Strings.NONE.toString() + ")"));
		}
	}

	private void addFurnishings(FurnishingList furnishingList,
			DefaultMutableTreeNode roomNode) {
		//for each furnishing in the room
		if (furnishingList.size() > 0) {
			for (int count = 0; count < furnishingList.size(); count++) {
				DefaultMutableTreeNode furnishingNode = new DefaultMutableTreeNode(
						furnishingList.get(count));
				//add a furnishing node
				roomNode.add(furnishingNode);
			}
		} else {
			//no furnishings, add (none)
			roomNode.add(new DefaultMutableTreeNode("("
					+ Strings.NONE.toString() + ")"));
		}
	}

	private void addTreeMaterials(Section section,
			DefaultMutableTreeNode sectionNode) {
		if (section.hasMaterials()) {
			MaterialList mList = section.getMaterialList();

			//for each material in the list
			for (int count = 0; count < mList.size(); count++) {
				DefaultMutableTreeNode matNode = new DefaultMutableTreeNode(
						mList.get(count));
				//add the material to the structural location
				sectionNode.add(matNode);
			}
		} else {
			//no materials, add (none)
			sectionNode.add(new DefaultMutableTreeNode("("
					+ Strings.NONE.toString() + ")"));
		}
	}

	public AdvancedTool getTool() {
		return tool;
	}

	public JFrame getFrame() {
		return frame;
	}
}
