package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.entities.Estudiante;

public class PanelScrollEstudiante extends JPanel {
	private JTextField jtfNota;

	/**
	 * Create the panel.
	 */
	public PanelScrollEstudiante(Estudiante estudiante) {
		
		JLabel lblAlumno = new JLabel(estudiante.getApellido1() + " " + estudiante.getApellido2() + "," + estudiante.getNombre());
		add(lblAlumno);
		
		jtfNota = new JTextField();
		add(jtfNota);
		jtfNota.setColumns(10);
	}

}
