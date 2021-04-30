package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import model.controllers.ControladorMateria;
import model.controllers.ControladorProfesor;
import model.controllers.ControladorTipologia;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.TipologiaSexo;

public class PanelValoracionMateria extends JPanel {

	JComboBox<Materia> jcbMateria = new JComboBox();
	JComboBox<Profesor> jcbProfesor = new JComboBox();
	
	/**
	 * Create the panel.
	 */
	public PanelValoracionMateria() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblProfesor = new JLabel("Profesor");
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 0;
		add(lblProfesor, gbc_lblProfesor);
		
		jcbProfesor = new JComboBox();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 0;
		add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblMateria = new JLabel("Materia");
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.anchor = GridBagConstraints.EAST;
		gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 1;
		add(lblMateria, gbc_lblMateria);
		
		jcbMateria = new JComboBox();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 1;
		add(jcbMateria, gbc_jcbMateria);
		
		JButton btnRefresca = new JButton("Refrescar estudiantes");
		GridBagConstraints gbc_btnRefresca = new GridBagConstraints();
		gbc_btnRefresca.anchor = GridBagConstraints.EAST;
		gbc_btnRefresca.insets = new Insets(0, 0, 5, 5);
		gbc_btnRefresca.gridx = 1;
		gbc_btnRefresca.gridy = 2;
		add(btnRefresca, gbc_btnRefresca);
		
		JScrollPane scrollPaneEstudiantes = new JScrollPane();
		GridBagConstraints gbc_scrollPaneEstudiantes = new GridBagConstraints();
		gbc_scrollPaneEstudiantes.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneEstudiantes.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneEstudiantes.gridx = 0;
		gbc_scrollPaneEstudiantes.gridy = 3;
		gbc_scrollPaneEstudiantes.gridwidth = 2;
		add(scrollPaneEstudiantes, gbc_scrollPaneEstudiantes);
		
		JButton btnGuardar = new JButton("Guardar");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 4;
		add(btnGuardar, gbc_btnGuardar);
		
		cargarDatosMateria();
		cargarDatosProfesor();
	}
	
	public Materia getMateria() {
		return  (Materia) this.jcbMateria.getSelectedItem();
	}



	public void setMateria(Materia materia) {
        for (int i = 0; i < this.jcbMateria.getItemCount(); i++) {
            if (materia.getId() == this.jcbMateria.getItemAt(i).getId()) {
                this.jcbMateria.setSelectedIndex(i);
            }
        }
        this.jcbMateria.setSelectedItem(materia);
    }
	
	/**
	 * 
	 */
	private void cargarDatosMateria() {
		List<Materia> materias = ControladorMateria.getInstance().findAll();
		for (Materia f : materias) {
			this.jcbMateria.addItem(f);
		}
	}
	
	public Profesor getProfesor() {
		return  (Profesor) this.jcbProfesor.getSelectedItem();
	}



	public void setProfesor(Profesor profesor) {
        for (int i = 0; i < this.jcbProfesor.getItemCount(); i++) {
            if (profesor.getId() == this.jcbProfesor.getItemAt(i).getId()) {
                this.jcbProfesor.setSelectedIndex(i);
            }
        }
        this.jcbProfesor.setSelectedItem(profesor);
    }
	
	/**
	 * 
	 */
	private void cargarDatosProfesor() {
		List<Profesor> profesores = ControladorProfesor.getInstance().findAll();
		for (Profesor f : profesores) {
			this.jcbProfesor.addItem(f);
		}
	}

}
