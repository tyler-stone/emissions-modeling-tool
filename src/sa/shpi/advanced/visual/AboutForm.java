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

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

import sa.shpi.advanced.model.Strings;

/**
 * Simple about dialog that discusses the project
 * @author Tyler
 *
 */
public class AboutForm extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AboutForm() {
		setType(Type.POPUP);
		setTitle(Strings.ABOUT.toString());
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 356, 270);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			Component verticalStrut = Box.createVerticalStrut(20);
			GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
			gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
			gbc_verticalStrut.gridx = 0;
			gbc_verticalStrut.gridy = 0;
			contentPanel.add(verticalStrut, gbc_verticalStrut);
		}
		{
			JLabel lblTheResidentialFire = new JLabel(
					Strings.RESIDENTIAL_EMISSIONS_CALCULATOR.toString() + " v2");
			lblTheResidentialFire.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_lblTheResidentialFire = new GridBagConstraints();
			gbc_lblTheResidentialFire.insets = new Insets(0, 0, 5, 0);
			gbc_lblTheResidentialFire.gridx = 0;
			gbc_lblTheResidentialFire.gridy = 1;
			contentPanel.add(lblTheResidentialFire, gbc_lblTheResidentialFire);
		}
		{
			Component verticalStrut = Box.createVerticalStrut(20);
			GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
			gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
			gbc_verticalStrut.gridx = 0;
			gbc_verticalStrut.gridy = 2;
			contentPanel.add(verticalStrut, gbc_verticalStrut);
		}
		{
			JLabel lblPartOfThe = new JLabel(
					"Parte de un Interactive Qualifying Project patrocinado por:");
			lblPartOfThe.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_lblPartOfThe = new GridBagConstraints();
			gbc_lblPartOfThe.insets = new Insets(0, 0, 5, 0);
			gbc_lblPartOfThe.gridx = 0;
			gbc_lblPartOfThe.gridy = 3;
			contentPanel.add(lblPartOfThe, gbc_lblPartOfThe);
		}
		{
			JLabel lblWorcesterPolytechnicInstitute = new JLabel(
					"Worcester Polytechnic Institute");
			GridBagConstraints gbc_lblWorcesterPolytechnicInstitute = new GridBagConstraints();
			gbc_lblWorcesterPolytechnicInstitute.insets = new Insets(0, 0, 5, 0);
			gbc_lblWorcesterPolytechnicInstitute.gridx = 0;
			gbc_lblWorcesterPolytechnicInstitute.gridy = 4;
			contentPanel.add(lblWorcesterPolytechnicInstitute,
					gbc_lblWorcesterPolytechnicInstitute);
		}
		{
			JLabel lblShpiIngenieriaSa = new JLabel("SHPI Ingenieria S.A.");
			GridBagConstraints gbc_lblShpiIngenieriaSa = new GridBagConstraints();
			gbc_lblShpiIngenieriaSa.insets = new Insets(0, 0, 5, 0);
			gbc_lblShpiIngenieriaSa.gridx = 0;
			gbc_lblShpiIngenieriaSa.gridy = 5;
			contentPanel.add(lblShpiIngenieriaSa, gbc_lblShpiIngenieriaSa);
		}
		{
			Component verticalStrut = Box.createVerticalStrut(20);
			GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
			gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
			gbc_verticalStrut.gridx = 0;
			gbc_verticalStrut.gridy = 6;
			contentPanel.add(verticalStrut, gbc_verticalStrut);
		}
		{
			JLabel lblBy = new JLabel("Creado de:");
			lblBy.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_lblBy = new GridBagConstraints();
			gbc_lblBy.insets = new Insets(0, 0, 5, 0);
			gbc_lblBy.gridx = 0;
			gbc_lblBy.gridy = 7;
			contentPanel.add(lblBy, gbc_lblBy);
		}
		{
			JLabel lblAlexandraHardinEric = new JLabel(
					"Alexandra Hardin, Eric Schattshneider, Tyler Stone, Kristina Walker");
			GridBagConstraints gbc_lblAlexandraHardinEric = new GridBagConstraints();
			gbc_lblAlexandraHardinEric.gridx = 0;
			gbc_lblAlexandraHardinEric.gridy = 8;
			contentPanel
					.add(lblAlexandraHardinEric, gbc_lblAlexandraHardinEric);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}

		setVisible(true);
	}

}
