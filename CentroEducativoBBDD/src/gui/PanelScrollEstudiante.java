package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.controllers.ControladorValoracionMateria;
import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;

public class PanelScrollEstudiante extends JPanel {
	public JTextField jtfNota;
	private Estudiante estudiante;


	/**
	 * Create the panel.
	 */
	public PanelScrollEstudiante(Estudiante estudiante,Materia materia, Profesor profesor) {
		
		JLabel lblAlumno = new JLabel(estudiante.getApellido1() + " " + estudiante.getApellido2() + "," + estudiante.getNombre());
		add(lblAlumno);
		
		jtfNota = new JTextField();
		add(jtfNota);
		jtfNota.setColumns(10);
	}

	public JTextField getJtfNota() {
		return jtfNota;
	}

	public void setJtfNota(JTextField jtfNota) {
		this.jtfNota = jtfNota;
	}
	
	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	
	
	


	

}
