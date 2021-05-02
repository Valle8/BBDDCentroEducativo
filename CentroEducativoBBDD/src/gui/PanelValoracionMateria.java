package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.controllers.ControladorEstudiante;
import model.controllers.ControladorMateria;
import model.controllers.ControladorProfesor;
import model.controllers.ControladorTipologia;
import model.controllers.ControladorValoracionMateria;
import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.TipologiaSexo;
import model.entities.ValoracionMateria;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelValoracionMateria extends JPanel {

	JComboBox<Materia> jcbMateria = new JComboBox();
	JComboBox<Profesor> jcbProfesor = new JComboBox();
	JScrollPane scrollPaneEstudiantes = new JScrollPane();
	private Profesor actualProf;
	private Materia actualMat;
	private List<PanelScrollEstudiante> listaEstudiantes;
	
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
		btnRefresca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarFichasAlumnos();
			}
		});
		GridBagConstraints gbc_btnRefresca = new GridBagConstraints();
		gbc_btnRefresca.anchor = GridBagConstraints.EAST;
		gbc_btnRefresca.insets = new Insets(0, 0, 5, 5);
		gbc_btnRefresca.gridx = 1;
		gbc_btnRefresca.gridy = 2;
		add(btnRefresca, gbc_btnRefresca);
		
		scrollPaneEstudiantes = new JScrollPane();
		GridBagConstraints gbc_scrollPaneEstudiantes = new GridBagConstraints();
		gbc_scrollPaneEstudiantes.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneEstudiantes.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneEstudiantes.gridx = 0;
		gbc_scrollPaneEstudiantes.gridy = 3;
		gbc_scrollPaneEstudiantes.gridwidth = 2;
		add(scrollPaneEstudiantes, gbc_scrollPaneEstudiantes);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
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

	
	private void cargarFichasAlumnos() {
		listaEstudiantes = new ArrayList<PanelScrollEstudiante>();
		actualMat = (Materia) jcbMateria.getSelectedItem();		
		actualProf = (Profesor) jcbProfesor.getSelectedItem();	
		JPanel Tarjetas = new JPanel();

		for(int i =0 ;i < ControladorEstudiante.getInstance().findAll().size(); i++) {
			Estudiante est = ControladorEstudiante.getInstance().findAll().get(i);	
			PanelScrollEstudiante fichaEst = new PanelScrollEstudiante(est,actualMat, actualProf);
			GridBagConstraints gbc_panelFichas = new GridBagConstraints();
			gbc_panelFichas.gridx = 0;
			gbc_panelFichas.gridy = i;
			add(fichaEst,gbc_panelFichas);
			
			if (ControladorValoracionMateria.getInstance().findByEstudianteAndProfesorAndMateria(actualProf,actualMat, est) != null) {
				fichaEst.jtfNota.setText("" + ControladorValoracionMateria.getInstance().findByEstudianteAndProfesorAndMateria(actualProf,actualMat, est).getValoracion());
			} else {
				fichaEst.jtfNota.setText("" + 0);
			}
			
			Tarjetas.add(fichaEst); 
			listaEstudiantes.add(fichaEst);	
			scrollPaneEstudiantes.setViewportView(Tarjetas);
			scrollPaneEstudiantes.revalidate();
			scrollPaneEstudiantes.repaint();	
		}
		
		

	}
	
	private void guardar() {
		for (int i = 0; i < listaEstudiantes.size(); i++) {
			ValoracionMateria valM = new ValoracionMateria();
			valM = ControladorValoracionMateria.getInstance().findByEstudianteAndProfesorAndMateria((Profesor) jcbProfesor.getSelectedItem(), (Materia) jcbMateria.getSelectedItem(), listaEstudiantes.get(i).getEstudiante()) ;
			if (valM == null) {
				valM = new ValoracionMateria();
				valM.setId(0);
				valM.setEstudiante(listaEstudiantes.get(i).getEstudiante());
				valM.setMateria((Materia) jcbMateria.getSelectedItem());
				valM.setProfesor((Profesor) jcbProfesor.getSelectedItem());
				valM.setValoracion(Float.parseFloat(listaEstudiantes.get(i).getJtfNota().getText()));
			} else {
				valM.getId();
				
			}
			ControladorValoracionMateria.getInstance().guardar(valM);
		}
	}
}
