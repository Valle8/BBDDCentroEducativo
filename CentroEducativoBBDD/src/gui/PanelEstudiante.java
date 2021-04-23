package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JToolBar;

import model.controllers.ControladorEstudiante;
import model.controllers.ControladorTipologia;
import model.entities.Estudiante;
import model.entities.TipologiaSexo;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PanelEstudiante extends JPanel {
	Estudiante actual = new Estudiante();
	PanelEjemplo pEj = new PanelEjemplo();
	

	/**
	 * Create the panel.
	 */
	public PanelEstudiante() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_toolBar.insets = new Insets(0, 0, 5, 0);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		add(toolBar, gbc_toolBar);
		
		JButton btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actual=ControladorEstudiante.getInstance().findPrimero();
				 cargarActualEnPantalla();
			}
		});
		toolBar.add(btnPrimero);
		
		JButton btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actual=ControladorEstudiante.getInstance().findAnterior(actual.getId());
				 cargarActualEnPantalla();
			}
		});
		toolBar.add(btnAnterior);
		
		JButton btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actual=ControladorEstudiante.getInstance().findSiguiente(actual.getId());
				 cargarActualEnPantalla();
			}
		});
		toolBar.add(btnSiguiente);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actual=ControladorEstudiante.getInstance().findUltimo();
				 cargarActualEnPantalla();
			}
		});
		btnUltimo.setIcon(new ImageIcon(PanelEstudiante.class.getResource("/gui/img/next_29420.png")));
		toolBar.add(btnUltimo);
		
		JButton btnGuardar = new JButton("Guardar");
		toolBar.add(btnGuardar);
		
		JButton btnNuevo = new JButton("Nuevo");
		toolBar.add(btnNuevo);
		
		JButton btnBorrar = new JButton("Borrar");
		toolBar.add(btnBorrar);
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(pEj, gbc_lblNewLabel);
		
		this.actual = ControladorEstudiante.getInstance().findPrimero();
		cargarActualEnPantalla();

	}
	
	
	/**
	 * 
	 */
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			pEj.setId(this.actual.getId());
			pEj.setPrimerApellido(this.actual.getApellido1());
			pEj.setSegundoApellido(this.actual.getApellido2());
			pEj.setDireccion(this.actual.getDireccion());
			pEj.setDni(this.actual.getDni());
			pEj.setEmail(this.actual.getEmail());
			pEj.setNombre(this.actual.getNombre());
			pEj.setTelefono(this.actual.getTelefono());
			pEj.setSexo(this.actual.getTipologiaSexo());
		}
	}
	
	

}
