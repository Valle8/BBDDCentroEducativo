package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Panel;

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
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		toolBar.add(btnGuardar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vaciarCampos();
			}
		});
		toolBar.add(btnNuevo);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrar();
			}
		});
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
			pEj.setImagen(this.actual.getImagen());
		}
	}
	
	/**
	 * 
	 */
	private void cargarDesdePantalla() {
			this.actual.setId(pEj.getId());
			this.actual.setApellido1(pEj.getPrimerApellido());
			this.actual.setApellido2(pEj.getSegundoApellido());
			this.actual.setDireccion(pEj.getDireccion());
			this.actual.setDni(pEj.getDni());
			this.actual.setEmail(pEj.getEmail());
			this.actual.setTelefono(pEj.getTelefono());
			this.actual.setNombre(pEj.getNombre());
			this.actual.setTipologiaSexo(pEj.getSexo());
			this.actual.setImagen(pEj.getImagen());
	}
	

	/**
	 * 
	 */
	private void vaciarCampos() {
		pEj.jtfId.setText("0");
		pEj.jtfPrimerApellido.setText("");
		pEj.jtfSegundoApellido.setText("");
		pEj.jtfDireccion.setText("");
		pEj.jtfDNI.setText("");
		pEj.jtfEmail.setText("");
		pEj.jtfNombre.setText("");
		pEj.jtfTelefono.setText("");
		pEj.jcbSexo.setSelectedIndex(0);
		pEj.setImagen(null);
	}
	

	/**
	 * 
	 */
	private void guardar () {
		cargarDesdePantalla();
		boolean resultado = ControladorEstudiante.getInstance().guardar(this.actual);
		if (resultado == true && this.actual != null && this.actual.getId() > 0) {
			pEj.jtfId.setText("" + this.actual.getId());
			JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "Error al guardar");
		}
	}
	

	/**
	 * 
	 */
	private void borrar() {
		String posiblesRespuestas[] = {"Sí","No"};
		// En esta opci�n se utiliza un showOptionDialog en el que personalizo el icono mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Desea eliminar?", "Gestión venta de coches", 
		        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas, posiblesRespuestas[1]);
	    if(opcionElegida == 0) {
	    	ControladorEstudiante.getInstance().borrar(this.actual);
	    }
	}
	
	

}
