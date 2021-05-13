package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.controllers.ControladorEstudiante;
import model.controllers.ControladorMateria;
import model.controllers.ControladorProfesor;
import model.controllers.ControladorTipologia;
import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.TipologiaSexo;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JMenuItem;

public class PanelValoracionMateriaList extends JPanel {

	JComboBox<Materia> jcbMateria = new JComboBox();
	JComboBox<Profesor> jcbProfesor = new JComboBox();
	JComboBox<Float> jcbNota = new JComboBox();
	JScrollPane scrollPaneEstudiantes = new JScrollPane();
	
	
	JList<Estudiante> listSinNota;
	JList<Estudiante> listConNota;
	private DefaultListModel<Estudiante> dlmSinNota = new DefaultListModel<Estudiante>();
	private DefaultListModel<Estudiante> dlmConNota = new DefaultListModel<Estudiante>();
	private List<Estudiante> estudiantes;

	
	
	/**
	 * Create the panel.
	 */
	public PanelValoracionMateriaList() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 0;
		add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblMateria = new JLabel("Materia");
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.anchor = GridBagConstraints.WEST;
		gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 1;
		add(lblMateria, gbc_lblMateria);
		
		jcbMateria = new JComboBox();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 1;
		add(jcbMateria, gbc_jcbMateria);
		
		JButton btnRefresca = new JButton("Refrescar estudiantes");
		btnRefresca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refrescarEstudiantes();
			}
		});
		
		JLabel lblNota = new JLabel("Nota");
		GridBagConstraints gbc_lblNota = new GridBagConstraints();
		gbc_lblNota.anchor = GridBagConstraints.WEST;
		gbc_lblNota.insets = new Insets(0, 0, 5, 5);
		gbc_lblNota.gridx = 0;
		gbc_lblNota.gridy = 2;
		add(lblNota, gbc_lblNota);
		
		jcbNota = new JComboBox();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		add(jcbNota, gbc_jcbNota);
		GridBagConstraints gbc_btnRefresca = new GridBagConstraints();
		gbc_btnRefresca.anchor = GridBagConstraints.EAST;
		gbc_btnRefresca.insets = new Insets(0, 0, 5, 0);
		gbc_btnRefresca.gridx = 1;
		gbc_btnRefresca.gridy = 3;
		add(btnRefresca, gbc_btnRefresca);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		gbc_panel.gridwidth = 2;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblEstudiantesS = new JLabel("Estudiantes sin nota");
		GridBagConstraints gbc_lblEstudiantesS = new GridBagConstraints();
		gbc_lblEstudiantesS.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstudiantesS.gridx = 0;
		gbc_lblEstudiantesS.gridy = 0;
		panel.add(lblEstudiantesS, gbc_lblEstudiantesS);
		
		JLabel lblEstudiantesC = new JLabel("Estudiantes con nota");
		GridBagConstraints gbc_lblEstudiantesC = new GridBagConstraints();
		gbc_lblEstudiantesC.insets = new Insets(0, 0, 5, 0);
		gbc_lblEstudiantesC.gridx = 2;
		gbc_lblEstudiantesC.gridy = 0;
		panel.add(lblEstudiantesC, gbc_lblEstudiantesC);
		
		JScrollPane scrollPaneSinNota = new JScrollPane();
		GridBagConstraints gbc_scrollPaneSinNota = new GridBagConstraints();
		gbc_scrollPaneSinNota.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneSinNota.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneSinNota.gridx = 0;
		gbc_scrollPaneSinNota.gridy = 1;
		panel.add(scrollPaneSinNota, gbc_scrollPaneSinNota);
		
		listSinNota = new JList(dlmSinNota);
		this.listSinNota.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
		scrollPaneSinNota.setViewportView(listSinNota);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.fill = GridBagConstraints.BOTH;
		gbc_panelBotones.insets = new Insets(0, 0, 0, 5);
		gbc_panelBotones.gridx = 1;
		gbc_panelBotones.gridy = 1;
		panel.add(panelBotones, gbc_panelBotones);
		GridBagLayout gbl_panelBotones = new GridBagLayout();
		gbl_panelBotones.columnWidths = new int[]{0, 0};
		gbl_panelBotones.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panelBotones.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelBotones.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelBotones.setLayout(gbl_panelBotones);
		
		JButton btnTodosI = new JButton("<<");
		btnTodosI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quitarTodosEstudiantes();
			}
		});
		GridBagConstraints gbc_btnTodosI = new GridBagConstraints();
		gbc_btnTodosI.insets = new Insets(0, 0, 5, 0);
		gbc_btnTodosI.gridx = 0;
		gbc_btnTodosI.gridy = 1;
		panelBotones.add(btnTodosI, gbc_btnTodosI);
		
		JButton btnUnoI = new JButton("<");
		btnUnoI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quitarEstudiantesSeleccionados();
			}
		});
		GridBagConstraints gbc_btnUnoI = new GridBagConstraints();
		gbc_btnUnoI.insets = new Insets(0, 0, 5, 0);
		gbc_btnUnoI.gridx = 0;
		gbc_btnUnoI.gridy = 2;
		panelBotones.add(btnUnoI, gbc_btnUnoI);
		
		JButton btnUnoD = new JButton(">");
		btnUnoD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarEstudiantesSeleccionados();
			}
		});
		GridBagConstraints gbc_btnUnoD = new GridBagConstraints();
		gbc_btnUnoD.insets = new Insets(0, 0, 5, 0);
		gbc_btnUnoD.gridx = 0;
		gbc_btnUnoD.gridy = 3;
		panelBotones.add(btnUnoD, gbc_btnUnoD);
		
		JButton btnTodosD = new JButton(">>");
		btnTodosD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarTodosEstudiantes();
			}
		});
		GridBagConstraints gbc_btnTodosD = new GridBagConstraints();
		gbc_btnTodosD.insets = new Insets(0, 0, 5, 0);
		gbc_btnTodosD.gridx = 0;
		gbc_btnTodosD.gridy = 4;
		panelBotones.add(btnTodosD, gbc_btnTodosD);
		
		JScrollPane scrollPaneConNota = new JScrollPane();
		GridBagConstraints gbc_scrollPaneConNota = new GridBagConstraints();
		gbc_scrollPaneConNota.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneConNota.gridx = 2;
		gbc_scrollPaneConNota.gridy = 1;
		panel.add(scrollPaneConNota, gbc_scrollPaneConNota);
		
		listConNota = new JList(dlmConNota);
		scrollPaneConNota.setViewportView(listConNota);
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 5;
		add(btnGuardar, gbc_btnGuardar);
		
		cargarDatosMateria();
		cargarDatosProfesor();
		cargarNota();
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
	
	/**
	 * 
	 */
	private void cargarNota() {
		List<Float> numeros = new ArrayList<Float>();
		 for (float i = 0; i < 11; i++) {
			 Float numero = i;
			 this.jcbNota.addItem(numero);
		 }
	}


	private void refrescarEstudiantes () {
		dlmSinNota.removeAllElements();
		dlmConNota.removeAllElements();
		estudiantes  = ControladorEstudiante.getInstance().findByProMatNot(((Profesor)jcbProfesor.getSelectedItem()).getId(),((Materia) jcbMateria.getSelectedItem()).getId(),(Float)jcbNota.getSelectedItem());
		dlmConNota.addAll(this.estudiantes);
		estudiantes.clear();
		estudiantes  = ControladorEstudiante.getInstance().findLeftJoin(((Profesor)jcbProfesor.getSelectedItem()).getId(),((Materia) jcbMateria.getSelectedItem()).getId(),(Float)jcbNota.getSelectedItem());
		dlmSinNota.addAll(this.estudiantes);
	}
	
	/**
     * 
     */
    private void agregarTodosEstudiantes() {
        for (int i = 0; i < this.dlmSinNota.size(); i++) {
            this.dlmConNota.addElement(this.dlmSinNota.elementAt(i));
        }
        dlmSinNota.clear();
    }
    
    /**
     * 
     */
    private void quitarTodosEstudiantes() {
        for (int i = 0; i < this.dlmConNota.size(); i++) {
            this.dlmSinNota.addElement(this.dlmConNota.elementAt(i));
        }
        dlmConNota.clear();
    }
    
    /**
     * 
     */
    private void quitarEstudiantesSeleccionados() {
    	for (int i = 0; i < this.listConNota.getSelectedIndices().length; i++) {
    		this.dlmSinNota.addElement(this.dlmConNota.getElementAt(this.listConNota.getSelectedIndices()[i]));
		}

    	for (int i = this.listConNota.getSelectedIndices().length - 1; i >= 0; i--) {
			this.dlmConNota.removeElementAt(this.listConNota.getSelectedIndices()[i]);
		}
    }
    
    private void agregarEstudiantesSeleccionados() {
    	for (int i = 0; i < this.listSinNota.getSelectedIndices().length; i++) {
    		this.dlmConNota.addElement(this.dlmSinNota.getElementAt(this.listSinNota.getSelectedIndices()[i]));
		}

    	for (int i = this.listSinNota.getSelectedIndices().length - 1; i >= 0; i--) {
			this.dlmSinNota.removeElementAt(this.listSinNota.getSelectedIndices()[i]);
		}
    }
    
    private void guardar() {
    	
    }


}
