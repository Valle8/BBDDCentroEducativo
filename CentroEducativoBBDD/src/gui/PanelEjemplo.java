package gui;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import model.controllers.ControladorTipologia;
import model.entities.TipologiaSexo;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;

public class PanelEjemplo extends JPanel {
	public JTextField jtfId;
	public JTextField jtfNombre;
	public JTextField jtfPrimerApellido;
	public JTextField jtfSegundoApellido;
	public JTextField jtfDNI;
	public JTextField jtfDireccion;
	public JTextField jtfEmail;
	public JTextField jtfTelefono;
	private JPanel panel;
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnBorrar;
	private JLabel lblSexo;
	public JComboBox<TipologiaSexo> jcbSexo;
	public JScrollPane scrollPane;
	public JLabel lblFoto;
	private JButton btnCambiaImagen;
	private byte[] imagenByte;
	JFileChooser jfileChooser;
	private JButton btnCambiaColor;
	JColorChooser jColorChooser;
	private JLabel lblColor;
	public JTextField jtfColor;
	JPopupMenu jpopupmenu;




	/**
	 * Create the panel.
	 */
	public PanelEjemplo() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0,1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("Id: ");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 0;
		gbc_scrollPane.gridheight = 5;
		add(scrollPane, gbc_scrollPane);
		
		lblFoto = new JLabel("");
		scrollPane.setViewportView(lblFoto);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 1;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido: ");
		GridBagConstraints gbc_lblPrimerApellido = new GridBagConstraints();
		gbc_lblPrimerApellido.anchor = GridBagConstraints.EAST;
		gbc_lblPrimerApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimerApellido.gridx = 0;
		gbc_lblPrimerApellido.gridy = 2;
		add(lblPrimerApellido, gbc_lblPrimerApellido);
		
		jtfPrimerApellido = new JTextField();
		GridBagConstraints gbc_jtfPrimerApellido = new GridBagConstraints();
		gbc_jtfPrimerApellido.insets = new Insets(0, 0, 5, 5);
		gbc_jtfPrimerApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPrimerApellido.gridx = 1;
		gbc_jtfPrimerApellido.gridy = 2;
		add(jtfPrimerApellido, gbc_jtfPrimerApellido);
		jtfPrimerApellido.setColumns(10);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido: ");
		GridBagConstraints gbc_lblSegundoApellido = new GridBagConstraints();
		gbc_lblSegundoApellido.anchor = GridBagConstraints.EAST;
		gbc_lblSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblSegundoApellido.gridx = 0;
		gbc_lblSegundoApellido.gridy = 3;
		add(lblSegundoApellido, gbc_lblSegundoApellido);
		
		jtfSegundoApellido = new JTextField();
		GridBagConstraints gbc_jtfSegundoApellido = new GridBagConstraints();
		gbc_jtfSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSegundoApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSegundoApellido.gridx = 1;
		gbc_jtfSegundoApellido.gridy = 3;
		add(jtfSegundoApellido, gbc_jtfSegundoApellido);
		jtfSegundoApellido.setColumns(10);
		
		JLabel lblDNI = new JLabel("DNI: ");
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 0;
		gbc_lblDNI.gridy = 4;
		add(lblDNI, gbc_lblDNI);
		
		jtfDNI = new JTextField();
		GridBagConstraints gbc_jtfDNI = new GridBagConstraints();
		gbc_jtfDNI.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDNI.gridx = 1;
		gbc_jtfDNI.gridy = 4;
		add(jtfDNI, gbc_jtfDNI);
		jtfDNI.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Dirección: ");
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.EAST;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 0;
		gbc_lblDireccion.gridy = 5;
		add(lblDireccion, gbc_lblDireccion);
		
		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 5;
		add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email: ");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		add(lblEmail, gbc_lblEmail);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 6;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Teléfono ");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 7;
		add(lblTelefono, gbc_lblTelefono);
		
		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 7;
		add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);
		
		lblSexo = new JLabel("Sexo: ");
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.EAST;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 0;
		gbc_lblSexo.gridy = 8;
		add(lblSexo, gbc_lblSexo);
		
		jcbSexo = new JComboBox();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 8;
		add(jcbSexo, gbc_jcbSexo);
		
		btnCambiaColor = new JButton("Color preferido: ");
		btnCambiaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionaColor();
			}
		});
		
		btnCambiaImagen = new JButton("Cambiar Imagen");
		btnCambiaImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionaFichero();
			}
		});
		GridBagConstraints gbc_btnCambiaImagen = new GridBagConstraints();
		gbc_btnCambiaImagen.insets = new Insets(0, 0, 5, 0);
		gbc_btnCambiaImagen.gridx = 2;
		gbc_btnCambiaImagen.gridy = 8;
		add(btnCambiaImagen, gbc_btnCambiaImagen);
		
		lblColor = new JLabel("Color: ");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.EAST;
		gbc_lblColor.insets = new Insets(0, 0, 0, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 9;
		add(lblColor, gbc_lblColor);
		
		jtfColor = new JTextField();
		jtfColor.setColumns(10);
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 0, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 9;
		add(jtfColor, gbc_jtfColor);
		GridBagConstraints gbc_btnCambiaColor = new GridBagConstraints();
		gbc_btnCambiaColor.gridx = 2;
		gbc_btnCambiaColor.gridy = 9;
		add(btnCambiaColor, gbc_btnCambiaColor);
		
		cargarDatosTipologia();
		
		
	}



	public int getId() {
		return Integer.parseInt(this.jtfId.getText());
	}



	public void setId(int id) {
		this.jtfId.setText("" + id);
	}



	public String getNombre() {
		return this.jtfNombre.getText();
	}



	public void setNombre(String nombre) {
		this.jtfNombre.setText(nombre);
	}



	public String getPrimerApellido() {
		return this.jtfPrimerApellido.getText();
	}



	public void setPrimerApellido(String primerApellido) {
		this.jtfPrimerApellido.setText(primerApellido);
	}



	public String getSegundoApellido() {
		return this.jtfSegundoApellido.getText();
	}



	public void setSegundoApellido(String segundoApellido) {
		this.jtfSegundoApellido.setText(segundoApellido);
	}



	public String getDni() {
		return this.jtfDNI.getText();
	}



	public void setDni(String dni) {
		this.jtfDNI.setText(dni);
	}



	public String getDireccion() {
		return this.jtfDireccion.getText();
	}



	public void setDireccion(String direccion) {
		this.jtfDireccion.setText(direccion);
	}



	public String getEmail() {
		return this.jtfEmail.getText();
	}



	public void setEmail(String email) {
		this.jtfEmail.setText(email);
	}



	public String getTelefono() {
		return this.jtfTelefono.getText();
	}



	public void setTelefono(String telefono) {
		this.jtfTelefono.setText(telefono);
	}



	public TipologiaSexo getSexo() {
		return  (TipologiaSexo) this.jcbSexo.getSelectedItem();
	}



	public void setSexo(TipologiaSexo sexo) {
        for (int i = 0; i < this.jcbSexo.getItemCount(); i++) {
            if (sexo.getId() == this.jcbSexo.getItemAt(i).getId()) {
                this.jcbSexo.setSelectedIndex(i);
            }
        }
        this.jcbSexo.setSelectedItem(sexo);
    }
	
	public byte[] getImagen() {
		return imagenByte;
	}
	
	public void setImagen(byte[] imagen) {
		JLabel lblN = new JLabel();
		this.imagenByte=imagen;
		if(imagen != null) {
			ImageIcon image = new ImageIcon(imagen);
			JLabel lbl = new JLabel(image);
			scrollPane.setViewportView(lbl);
			scrollPane.revalidate();
			scrollPane.repaint();
		} else {
			scrollPane.setViewportView(lblN);
			scrollPane.revalidate();
			scrollPane.repaint();
		}
		
	}
	

	public String getColor() {
		return this.jtfColor.getText();
	}



	public void setColor(String Color) {
		if(Color != null) {
			this.jtfColor.setText(Color);
		} else {
			this.jtfColor.setText("");
		}
	}
	
	/**
	 * 
	 */
	private void cargarDatosTipologia() {
		List<TipologiaSexo> sexo = ControladorTipologia.getInstance().findAll();
		for (TipologiaSexo f : sexo) {
			this.jcbSexo.addItem(f);
		}
	}
	
	
	/**
	 * 
	 */
	private void seleccionaFichero () {
		this.jfileChooser = new JFileChooser();
		
		// Configurando el componente
		
		// Establecimiento de la carpeta de inicio
		this.jfileChooser.setCurrentDirectory(new File("C:\\"));
		
		// Tipo de selecci�n que se hace en el di�logo
//		this.jfileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // S�lo selecciona ficheros
		//this.jfileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // S�lo selecciona ficheros
		this.jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Selecciona ficheros y carpetas
		
		// Filtro del tipo de ficheros que puede abrir
		this.jfileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Archivos de texto *.jpg *.png ";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isFile() &&(f.getAbsolutePath().endsWith(".jpg") || f.getAbsolutePath().endsWith(".png"))) 
					return true;
				return false;
			}
		});
		
		// Abro el di�logo para la elecci�n del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);
		
		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = this.jfileChooser.getSelectedFile();
			this.setImagen(leerContenidoFicheroBinario(fichero));
		}
	}
	

	/**
	 * 
	 * @param f
	 * @return
	 */
	private byte[] leerContenidoFicheroBinario (File f) {
		try {
			return Files.readAllBytes(f.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new byte[] {};
	}
	
	/**
	 * 
	 */
	private void seleccionaColor () {
		Color color = jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no ser� nulo
		if (color != null) {
			String strColor = "#"+Integer.toHexString(color.getRGB()).substring(2);
			this.jtfColor.setText(strColor);
			this.setBackground(color);
		}
	}
	
	public void popUp(){
		jpopupmenu  = getPopUpMenu();
		
		
		// Evento para mostrar el men� en las coordenadas que correspondan
		scrollPane.addMouseListener(new MouseAdapter() {

	        @Override
	        public void mousePressed(MouseEvent e) {
	            showPopup(e);
	        }

	        @Override
	        public void mouseReleased(MouseEvent e) {
	            showPopup(e);
	        }

	        /**
	         * M�todo llamado cuando se detecta el evento de rat�n, mostrar� el men�
	         * @param e
	         */
	        private void showPopup(MouseEvent e) {
	            if (e.isPopupTrigger()) {
	            	jpopupmenu.show(e.getComponent(),
	                        e.getX(), e.getY());
	            }
	        }
	    });
	}
	
	
	private JPopupMenu getPopUpMenu() {
        JPopupMenu menu = new JPopupMenu();
        
        menu.add(itemCambiarImagen());
        menu.addSeparator();
        menu.add(itemDimensiones());        
        return menu;
    }
    
    private JMenuItem itemCambiarImagen() {
        JMenuItem item = new JMenuItem("Cambiar Imagen");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionaFichero();                
            }
        });
        return item;
    }

    
    private JMenuItem itemDimensiones() {
        String texto ="";
        ImageIcon imgIcon;
        if(this.imagenByte != null) {
             imgIcon = new ImageIcon(imagenByte);
             texto ="Dimension: " + imgIcon.getIconHeight() + " x " + imgIcon.getIconWidth();
        } else
             texto ="No hay imagen";    
        
       JMenuItem item = new JMenuItem(texto);
       return item;
    }


}
