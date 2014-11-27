package ayd.managment.store.vista;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import ayd.managment.store.modelo.Usuario;
import ayd.managment.store.servicio.Interface.ServicioActualizacionUsuario;
import ayd.managment.store.servicio.clase.ServicioActualizacionUsuarioClase;


public class VentanaActualizacionUsuario extends VentanaGenerica{
	
	//declaracion de atributos JPanel
	private JPanel panelCodigo= new JPanel();
	private JPanel panelUsuario= new JPanel();
	//declaracion de atributos JButton
	private JButton JButtonActualizar;
	private JButton JButtonBuscar;
	//declaracion de atributos JTextField
	private JTextField JTextFieldCodigoEmpleado;
	private JTextField JTextFieldApellidoMaterno;
	private JTextField JTextFieldApellidoPaterno;
	private JTextField JTextFieldNombre;
	private JTextField JTextFieldCalle;
	private JTextField JTextFieldNumExterior;
	private JTextField JTextFieldNumInterior;
	private JTextField JTextFieldColonia;
	private JTextField JTextFieldMunicipio;
	private JTextField JTextFieldCP;
	private JTextField JTextFieldTelefono;
	private JTextField JTextFieldID;
	
	private JPasswordField JPasswordFieldContrasena;
	private JPasswordField JPasswordFieldConfirmacion;

	//declaracion de atributos JLabel
	private JLabel lblCodigo;
	private JLabel lblApellidoPaterno;
	private JLabel lblNombre;
	private JLabel lblApellidoMaterno;
	private JLabel lblCalle;
	private JLabel lblNumExterior;
	private JLabel lblNumInterior;
	private JLabel lblColonia;
	private JLabel lblMunicipio;
	private JLabel lblCP;
	private JLabel lblTelefono;
	private JLabel lblCargo;
	private JLabel lblContrasena;
	private JLabel lblConfirmacion;
	private JLabel lblID;
	private JLabel[] lblAsterisco= new JLabel[15];
	
	//declaracion de atributo JComboBox
	private JComboBox JComboBoxCargo;
	//declaracion de atributo de ServicioActualizacionUsuarioClase
	private ServicioActualizacionUsuario observiciousuario;

	//contructor
	public VentanaActualizacionUsuario(ServicioActualizacionUsuario serviciousuario){
		super("Actualizacion de usuario","Regresar a ventana \"Usuarios\"");
		this.observiciousuario=serviciousuario;
		
		//se agregan propiedades de color y borde a panelCodigo y panelUsuario
		panel2.setLayout(new BorderLayout());
		panelCodigo.setBorder(BorderFactory.createLoweredBevelBorder());
		panelCodigo.setBackground(UIManager.getColor("Button.focus"));
		panelUsuario.setBorder(BorderFactory.createLoweredBevelBorder());
		panelUsuario.setBackground(UIManager.getColor("Button.focus"));
		panel2.add(panelCodigo,BorderLayout.NORTH);
		panel2.add(panelUsuario,BorderLayout.CENTER);
		
		panelCodigo.setLayout(new GridBagLayout());
		
		//se agregan propiedades de GridBagLAyout a lblCodigo
		lblCodigo= new JLabel("Codigo Empleado:");
		lblCodigo.setFont(new Font("Dialog", Font.BOLD, 25));
		GridBagConstraints gbc_lblCodigo=new GridBagConstraints ();
		gbc_lblCodigo.insets = new Insets(0, 0, 0,0);
		gbc_lblCodigo.gridheight = 1;
		gbc_lblCodigo.gridwidth = 1;
		gbc_lblCodigo.gridx = 0; 
		gbc_lblCodigo.gridy = 0;
		gbc_lblCodigo.weightx = 0.0;
		gbc_lblCodigo.fill = GridBagConstraints.HORIZONTAL;
		panelCodigo.add(lblCodigo,gbc_lblCodigo);
		
		//se agregan propiedades de GridBagLAyout a JTextFieldCodigoEmpleado
		JTextFieldCodigoEmpleado= new JTextField(15);
		JTextFieldCodigoEmpleado.setFont(new Font("Dialog", Font.BOLD, 28));
		GridBagConstraints gbc_JTextFieldCodigoEmpleado=new GridBagConstraints ();
		gbc_JTextFieldCodigoEmpleado.insets = new Insets(0, 0, 0,0);
		gbc_JTextFieldCodigoEmpleado.gridheight = 1;
		gbc_JTextFieldCodigoEmpleado.gridwidth = 24;
		gbc_JTextFieldCodigoEmpleado.gridx = 1; 
		gbc_JTextFieldCodigoEmpleado.gridy = 0;
		gbc_JTextFieldCodigoEmpleado.weightx = 0.0;
		gbc_JTextFieldCodigoEmpleado.fill = GridBagConstraints.HORIZONTAL;
		panelCodigo.add(JTextFieldCodigoEmpleado,gbc_JTextFieldCodigoEmpleado);
		
		//se agregan propiedades de GridBagLAyout a panelCodigoError
		JPanel panelCodigoError= new JPanel();
		lblAsterisco[0]=inicizalizalbl(lblAsterisco[0]);
		panelCodigoError.setBackground(UIManager.getColor("Button.focus"));
		panelCodigoError.add(lblAsterisco[0]);
		GridBagConstraints gbc_panelCodigoError=new GridBagConstraints ();
		gbc_panelCodigoError.insets = new Insets(0, 0, 1,1);
		gbc_panelCodigoError.gridheight = 1;
		gbc_panelCodigoError.gridwidth = 1;
		gbc_panelCodigoError.gridx = 25; 
		gbc_panelCodigoError.gridy = 0;
		gbc_panelCodigoError.weightx = 0;
		gbc_panelCodigoError.fill = GridBagConstraints.HORIZONTAL;
		
		panelCodigo.add(panelCodigoError,gbc_panelCodigoError);
		
		//se agregan propiedades de GridBagLAyout a JButtonBuscar
		JButtonBuscar= new JButton("Buscar");
		JButtonBuscar.setFont(new Font("Dialog", Font.BOLD, 28));
		GridBagConstraints gbc_JButtonBuscar=new GridBagConstraints ();
		gbc_JButtonBuscar.insets = new Insets(0, 0, 1,1);
		gbc_JButtonBuscar.gridheight = 1;
		gbc_JButtonBuscar.gridwidth = 1;
		gbc_JButtonBuscar.gridx = 26; 
		gbc_JButtonBuscar.gridy = 0;
		gbc_JButtonBuscar.weightx = 0;
		gbc_JButtonBuscar.fill = GridBagConstraints.HORIZONTAL;
		
		panelCodigo.add(JButtonBuscar,gbc_JButtonBuscar);
		
		

		panelUsuario.setLayout(new GridBagLayout());
		
		//se agregan propiedades de GridBagLAyout a lblApellidoPaterno
		lblApellidoPaterno= new JLabel("Apellido Paterno:");
		lblApellidoPaterno.setFont(new Font("Dialog", Font.BOLD, 18));
		lblApellidoPaterno.doLayout();
		GridBagConstraints gbc_lblApellidoP=new GridBagConstraints ();
		gbc_lblApellidoP.insets = new Insets(0, 0, 1,1);
		gbc_lblApellidoP.gridheight = 1;
		gbc_lblApellidoP.gridwidth = 1;
		gbc_lblApellidoP.gridx = 0; 
		gbc_lblApellidoP.gridy = 0;
		gbc_lblApellidoP.weightx = 0.0;
		gbc_lblApellidoP.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(lblApellidoPaterno,gbc_lblApellidoP);
			
		//se agregan propiedades de GridBagLAyout a JTextFieldApellidoPaterno
		JTextFieldApellidoPaterno= new JTextField(11);
		JTextFieldApellidoPaterno.setFont(new Font("Dialog", Font.BOLD, 18));
		JTextFieldApellidoPaterno.doLayout();
		GridBagConstraints gbc_TextFieldApellidoPaterno=new GridBagConstraints ();
		gbc_TextFieldApellidoPaterno.insets = new Insets(0, 0, 1,1);
		gbc_TextFieldApellidoPaterno.gridheight = 1;
		gbc_TextFieldApellidoPaterno.gridwidth = 24;
		gbc_TextFieldApellidoPaterno.gridx = 1; 
		gbc_TextFieldApellidoPaterno.gridy = 0;
		gbc_TextFieldApellidoPaterno.weightx = 0.0;
		gbc_TextFieldApellidoPaterno.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(JTextFieldApellidoPaterno,gbc_TextFieldApellidoPaterno);
		
		//se agregan propiedades de GridBagLAyout a panelCodigoError1
		JPanel panelCodigoError1= new JPanel();
		lblAsterisco[1]=inicizalizalbl(lblAsterisco[1]);
		panelCodigoError1.setBackground(UIManager.getColor("Button.focus"));
		panelCodigoError1.add(lblAsterisco[1]);
		GridBagConstraints gbc_panelCodigoError1=new GridBagConstraints ();
		gbc_panelCodigoError1.insets = new Insets(0, 0, 1,1);
		gbc_panelCodigoError1.gridheight = 1;
		gbc_panelCodigoError1.gridwidth = 1;
		gbc_panelCodigoError1.gridx = 25; 
		gbc_panelCodigoError1.gridy = 0;
		gbc_panelCodigoError1.weightx = 0;
		gbc_panelCodigoError1.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add( panelCodigoError1,gbc_panelCodigoError1);
		
		//se agregan propiedades de GridBagLAyout a lblApellidoMaterno
		lblApellidoMaterno= new JLabel("Apellido Materno:");
		lblApellidoMaterno.setFont(new Font("Dialog", Font.BOLD, 18));
		lblApellidoMaterno.doLayout();
		GridBagConstraints gbc_lblApellidoM=new GridBagConstraints ();
		gbc_lblApellidoM.insets = new Insets(0, 0,1,1);
		gbc_lblApellidoM.gridheight = 1;
		gbc_lblApellidoM.gridwidth = 1;
		gbc_lblApellidoM.gridx = 0; 
		gbc_lblApellidoM.gridy = 1;
		gbc_lblApellidoM.weightx = 0.0;
		gbc_lblApellidoM.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(lblApellidoMaterno,gbc_lblApellidoM);
			
		//se agregan propiedades de GridBagLAyout a JTextFieldApellidoMaterno
		JTextFieldApellidoMaterno= new JTextField(11);
		JTextFieldApellidoMaterno.setFont(new Font("Dialog", Font.BOLD, 18));
		JTextFieldApellidoMaterno.doLayout();
		GridBagConstraints gbc_TextFieldApellidoMaterno=new GridBagConstraints ();
		gbc_TextFieldApellidoMaterno.insets = new Insets(0, 0, 1,1);
		gbc_TextFieldApellidoMaterno.gridheight = 1;
		gbc_TextFieldApellidoMaterno.gridwidth =24;
		gbc_TextFieldApellidoMaterno.gridx = 1; 
		gbc_TextFieldApellidoMaterno.gridy = 1;
		gbc_TextFieldApellidoMaterno.weightx = 0.0;
		gbc_TextFieldApellidoMaterno.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(JTextFieldApellidoMaterno,gbc_TextFieldApellidoMaterno);
		
		//se agregan propiedades de GridBagLAyout a panelCodigoError2
		JPanel panelCodigoError2= new JPanel();
		lblAsterisco[2]=inicizalizalbl(lblAsterisco[2]);
		panelCodigoError2.setBackground(UIManager.getColor("Button.focus"));
		panelCodigoError2.add(lblAsterisco[2]);
		GridBagConstraints gbc_panelCodigoError2=new GridBagConstraints ();
		gbc_panelCodigoError2.insets = new Insets(0, 0, 1,1);
		gbc_panelCodigoError2.gridheight = 1;
		gbc_panelCodigoError2.gridwidth = 1;
		gbc_panelCodigoError2.gridx = 25; 
		gbc_panelCodigoError2.gridy = 1;
		gbc_panelCodigoError2.weightx = 0;
		gbc_panelCodigoError2.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add( panelCodigoError2,gbc_panelCodigoError2);
		
		//se agregan propiedades de GridBagLAyout a lblNombre
		lblNombre= new JLabel("Nombre:");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNombre.doLayout();
		GridBagConstraints gbc_lblNombre=new GridBagConstraints ();
		gbc_lblNombre.insets = new Insets(0, 0, 1,1);
		gbc_lblNombre.gridheight = 1;
		gbc_lblNombre.gridwidth = 1;
		gbc_lblNombre.gridx = 0; 
		gbc_lblNombre.gridy = 2;
		gbc_lblNombre.weightx = 0;
		gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(lblNombre,gbc_lblNombre);
	
		//se agregan propiedades de GridBagLAyout a JTextFieldNombre
		JTextFieldNombre= new JTextField(11);
		JTextFieldNombre.setFont(new Font("Dialog", Font.BOLD, 18));
		JTextFieldNombre.doLayout();
		GridBagConstraints gbc_TextFieldNombre=new GridBagConstraints ();
		gbc_TextFieldNombre.insets = new Insets(0, 0, 5,5);
		gbc_TextFieldNombre.gridheight = 1;
		gbc_TextFieldNombre.gridwidth = 24;
		gbc_TextFieldNombre.gridx = 1; 
		gbc_TextFieldNombre.gridy = 2;
		gbc_TextFieldNombre.weightx = 0.0;
		gbc_TextFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(JTextFieldNombre,gbc_TextFieldNombre);
		
		//se agregan propiedades de GridBagLAyout a panelCodigoError3
		JPanel panelCodigoError3= new JPanel();
		lblAsterisco[3]=inicizalizalbl(lblAsterisco[3]);
		panelCodigoError3.setBackground(UIManager.getColor("Button.focus"));
		panelCodigoError3.add(lblAsterisco[3]);
		GridBagConstraints gbc_panelCodigoError3=new GridBagConstraints ();
		gbc_panelCodigoError3.insets = new Insets(0, 0, 1,1);
		gbc_panelCodigoError3.gridheight = 1;
		gbc_panelCodigoError3.gridwidth = 1;
		gbc_panelCodigoError3.gridx = 25; 
		gbc_panelCodigoError3.gridy = 2;
		gbc_panelCodigoError3.weightx = 0;
		gbc_panelCodigoError3.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add( panelCodigoError3,gbc_panelCodigoError3);
		
		//se agregan propiedades de GridBagLAyout a lblCalle
		lblCalle= new JLabel("Direccion: Calle: ");
		lblCalle.setFont(new Font("Dialog", Font.BOLD,18));
		lblCalle.doLayout();
		GridBagConstraints gbc_lblCalle=new GridBagConstraints ();
		gbc_lblCalle.insets = new Insets(0, 0, 1,1);
		gbc_lblCalle.gridheight = 1;
		gbc_lblCalle.gridwidth = 1;
		gbc_lblCalle.gridx = 0; 
		gbc_lblCalle.gridy = 3;
		gbc_lblCalle.weightx = 0;
		gbc_lblCalle.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(lblCalle,gbc_lblCalle);
		
		//se agregan propiedades de GridBagLAyout a JTextFieldCalle
		JTextFieldCalle= new JTextField(11);
		JTextFieldCalle.setFont(new Font("Dialog", Font.BOLD, 18));
		JTextFieldCalle.doLayout();
		GridBagConstraints gbc_TextFieldCalle=new GridBagConstraints ();
		gbc_TextFieldCalle.insets = new Insets(0, 0, 5,5);
		gbc_TextFieldCalle.gridheight = 1;
		gbc_TextFieldCalle.gridwidth = 24;
		gbc_TextFieldCalle.gridx = 1; 
		gbc_TextFieldCalle.gridy = 3;
		gbc_TextFieldCalle.weightx = 0.0;
		gbc_TextFieldCalle.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(JTextFieldCalle,gbc_TextFieldCalle);
		
		//se agregan propiedades de GridBagLAyout a panelCodigoError4
		JPanel panelCodigoError4= new JPanel();
		lblAsterisco[4]=inicizalizalbl(lblAsterisco[4]);
		panelCodigoError4.setBackground(UIManager.getColor("Button.focus"));
		panelCodigoError4.add(lblAsterisco[4]);
		GridBagConstraints gbc_panelCodigoError4=new GridBagConstraints ();
		gbc_panelCodigoError4.insets = new Insets(0, 0, 1,1);
		gbc_panelCodigoError4.gridheight = 1;
		gbc_panelCodigoError4.gridwidth = 1;
		gbc_panelCodigoError4.gridx = 25; 
		gbc_panelCodigoError4.gridy = 3;
		gbc_panelCodigoError4.weightx = 0;
		gbc_panelCodigoError4.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add( panelCodigoError4,gbc_panelCodigoError4);
		
		//se agregan propiedades de GridBagLAyout a lblNumExterior
		lblNumExterior= new JLabel("N° Exterior: ");
		lblNumExterior.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNumExterior.doLayout();
		GridBagConstraints gbc_lblNumExterior=new GridBagConstraints ();
		gbc_lblNumExterior.insets = new Insets(0, 0, 1,1);
		gbc_lblNumExterior.gridheight = 1;
		gbc_lblNumExterior.gridwidth = 1;
		gbc_lblNumExterior.gridx = 0; 
		gbc_lblNumExterior.gridy = 4;
		gbc_lblNumExterior.weightx = 0;
		gbc_lblNumExterior.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(lblNumExterior,gbc_lblNumExterior);
		
		//se agregan propiedades de GridBagLAyout a JTextFieldNumExterior
		JTextFieldNumExterior= new JTextField(5);
		JTextFieldNumExterior.setFont(new Font("Dialog", Font.BOLD, 18));
		JTextFieldNumExterior.doLayout();
		GridBagConstraints gbc_TextFieldNumExterior=new GridBagConstraints ();
		gbc_TextFieldNumExterior.insets = new Insets(0, 0, 5,5);
		gbc_TextFieldNumExterior.gridheight = 1;
		gbc_TextFieldNumExterior.gridwidth = 3;
		gbc_TextFieldNumExterior.gridx = 1; 
		gbc_TextFieldNumExterior.gridy = 4;
		gbc_TextFieldNumExterior.weightx = 0.0;
		gbc_TextFieldNumExterior.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(JTextFieldNumExterior,gbc_TextFieldNumExterior);
		
		//se agregan propiedades de GridBagLAyout a panelCodigoError5
		JPanel panelCodigoError5= new JPanel();
		lblAsterisco[5]=inicizalizalbl(lblAsterisco[5]);
		panelCodigoError5.setBackground(UIManager.getColor("Button.focus"));
		panelCodigoError5.add(lblAsterisco[5]);
		GridBagConstraints gbc_panelCodigoError5=new GridBagConstraints ();
		gbc_panelCodigoError5.insets = new Insets(0, 0, 1,1);
		gbc_panelCodigoError5.gridheight = 1;
		gbc_panelCodigoError5.gridwidth = 1;
		gbc_panelCodigoError5.gridx = 4; 
		gbc_panelCodigoError5.gridy = 4;
		gbc_panelCodigoError5.weightx = 0;
		gbc_panelCodigoError5.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add( panelCodigoError5,gbc_panelCodigoError5);
		
		//se agregan propiedades de GridBagLAyout a lblNumInterior
		lblNumInterior= new JLabel("N° Interior: ");
		lblNumInterior.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNumInterior.doLayout();
		GridBagConstraints gbc_lblNumInterior=new GridBagConstraints ();
		gbc_lblNumInterior.insets = new Insets(0, 0, 1,1);
		gbc_lblNumInterior.gridheight = 1;
		gbc_lblNumInterior.gridwidth = 1;
		gbc_lblNumInterior.gridx = 5; 
		gbc_lblNumInterior.gridy = 4;
		gbc_lblNumInterior.weightx = 0;
		gbc_lblNumInterior.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(lblNumInterior,gbc_lblNumInterior);
		
		//se agregan propiedades de GridBagLAyout a TextFieldNumInterior
		JTextFieldNumInterior= new JTextField(5);
		JTextFieldNumInterior.setFont(new Font("Dialog", Font.BOLD, 18));
		JTextFieldNumExterior.doLayout();
		GridBagConstraints gbc_TextFieldNumInterior=new GridBagConstraints ();
		gbc_TextFieldNumInterior.insets = new Insets(0, 0, 5,5);
		gbc_TextFieldNumInterior.gridheight = 1;
		gbc_TextFieldNumInterior.gridwidth = 3;
		gbc_TextFieldNumInterior.gridx = 6; 
		gbc_TextFieldNumInterior.gridy = 4;
		gbc_TextFieldNumInterior.weightx = 0.0;
		gbc_TextFieldNumInterior.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(JTextFieldNumInterior,gbc_TextFieldNumInterior);
		
		//se agregan propiedades de GridBagLAyout a panelCodigoError6
		JPanel panelCodigoError6= new JPanel();
		lblAsterisco[6]=inicizalizalbl(lblAsterisco[6]);
		panelCodigoError6.setBackground(UIManager.getColor("Button.focus"));
		panelCodigoError6.add(lblAsterisco[6]);
		GridBagConstraints gbc_panelCodigoError6=new GridBagConstraints ();
		gbc_panelCodigoError6.insets = new Insets(0, 0, 1,1);
		gbc_panelCodigoError6.gridheight = 1;
		gbc_panelCodigoError6.gridwidth = 1;
		gbc_panelCodigoError6.gridx = 9; 
		gbc_panelCodigoError6.gridy = 4;
		gbc_panelCodigoError6.weightx = 0;
		gbc_panelCodigoError6.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add( panelCodigoError6,gbc_panelCodigoError6);
		
		//se agregan propiedades de GridBagLAyout a lblColonia
		lblColonia= new JLabel("Colonia: ");
		lblColonia.setFont(new Font("Dialog", Font.BOLD, 18));
		lblColonia.doLayout();
		GridBagConstraints gbc_lblColonia=new GridBagConstraints ();
		gbc_lblColonia.insets = new Insets(0, 0, 1,1);
		gbc_lblColonia.gridheight = 1;
		gbc_lblColonia.gridwidth = 1;
		gbc_lblColonia.gridx = 10; 
		gbc_lblColonia.gridy = 4;
		gbc_lblColonia.weightx = 0;
		gbc_lblColonia.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(lblColonia,gbc_lblColonia);
		
		//se agregan propiedades de GridBagLAyout a JTextFieldColonia
		JTextFieldColonia= new JTextField(5);
		JTextFieldColonia.setFont(new Font("Dialog", Font.BOLD, 18));
		JTextFieldColonia.doLayout();
		GridBagConstraints gbc_TextFieldDelegacion=new GridBagConstraints ();
		gbc_TextFieldDelegacion.insets = new Insets(0, 0, 1,1);
		gbc_TextFieldDelegacion.gridheight = 1;
		gbc_TextFieldDelegacion.gridwidth = 11;
		gbc_TextFieldDelegacion.gridx = 11; 
		gbc_TextFieldDelegacion.gridy = 4;
		gbc_TextFieldDelegacion.weightx = 0.0;
		gbc_TextFieldDelegacion.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(JTextFieldColonia,gbc_TextFieldDelegacion);
		
		//se agregan propiedades de GridBagLAyout a panelCodigoError7
		JPanel panelCodigoError7= new JPanel();
		lblAsterisco[7]=inicizalizalbl(lblAsterisco[7]);
		panelCodigoError7.setBackground(UIManager.getColor("Button.focus"));
		panelCodigoError7.add(lblAsterisco[7]);
		GridBagConstraints gbc_panelCodigoError7=new GridBagConstraints ();
		gbc_panelCodigoError7.insets = new Insets(0, 0, 1,1);
		gbc_panelCodigoError7.gridheight = 1;
		gbc_panelCodigoError7.gridwidth = 1;
		gbc_panelCodigoError7.gridx = 25; 
		gbc_panelCodigoError7.gridy = 4;
		gbc_panelCodigoError7.weightx = 0;
		gbc_panelCodigoError7.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add( panelCodigoError7,gbc_panelCodigoError7);
		
		//se agregan propiedades de GridBagLAyout a lblMunicipio
		lblMunicipio= new JLabel("Municipio: ");
		lblMunicipio.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMunicipio.doLayout();
		GridBagConstraints gbc_lblMunicipio=new GridBagConstraints ();
		gbc_lblMunicipio.insets = new Insets(0, 0, 1,1);
		gbc_lblMunicipio.gridheight = 1;
		gbc_lblMunicipio.gridwidth = 1;
		gbc_lblMunicipio.gridx = 0; 
		gbc_lblMunicipio.gridy = 5;
		gbc_lblMunicipio.weightx = 0;
		gbc_lblMunicipio.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(lblMunicipio,gbc_lblMunicipio);
		
		//se agregan propiedades de GridBagLAyout a JTextFieldMunicipio
		JTextFieldMunicipio= new JTextField(5);
		JTextFieldMunicipio.setFont(new Font("Dialog", Font.BOLD, 18));
		JTextFieldMunicipio.doLayout();
		GridBagConstraints gbc_TextFieldMunicipio=new GridBagConstraints ();
		gbc_TextFieldMunicipio.insets = new Insets(0, 0, 1,1);
		gbc_TextFieldMunicipio.gridheight = 1;
		gbc_TextFieldMunicipio.gridwidth = 3;
		gbc_TextFieldMunicipio.gridx = 1; 
		gbc_TextFieldMunicipio.gridy = 5;
		gbc_TextFieldMunicipio.weightx = 0.0;
		gbc_TextFieldMunicipio.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(JTextFieldMunicipio,gbc_TextFieldMunicipio);
		
		//se agregan propiedades de GridBagLAyout a panelCodigoError8
		JPanel panelCodigoError8= new JPanel();
		lblAsterisco[8]=inicizalizalbl(lblAsterisco[8]);
		panelCodigoError8.setBackground(UIManager.getColor("Button.focus"));
		panelCodigoError8.add(lblAsterisco[8]);
		GridBagConstraints gbc_panelCodigoError8=new GridBagConstraints ();
		gbc_panelCodigoError8.insets = new Insets(0, 0, 1,1);
		gbc_panelCodigoError8.gridheight = 1;
		gbc_panelCodigoError8.gridwidth = 1;
		gbc_panelCodigoError8.gridx = 4; 
		gbc_panelCodigoError8.gridy = 5;
		gbc_panelCodigoError8.weightx = 0;
		gbc_panelCodigoError8.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add( panelCodigoError8,gbc_panelCodigoError8);
		
		//se agregan propiedades de GridBagLAyout a lblCP
		lblCP= new JLabel("Codigo Postal: ");
		lblCP.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCP.doLayout();
		GridBagConstraints gbc_lblCP=new GridBagConstraints ();
		gbc_lblCP.insets = new Insets(0, 0, 1,1);
		gbc_lblCP.gridheight = 1;
		gbc_lblCP.gridwidth = 1;
		gbc_lblCP.gridx = 5; 
		gbc_lblCP.gridy = 5;
		gbc_lblCP.weightx = 0;
		gbc_lblCP.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(lblCP,gbc_lblCP);
		
		//se agregan propiedades de GridBagLAyout a JTextFieldCP
		JTextFieldCP= new JTextField(5);
		JTextFieldCP.setFont(new Font("Dialog", Font.BOLD, 18));
		JTextFieldCP.doLayout();
		GridBagConstraints gbc_TextFieldCP=new GridBagConstraints ();
		gbc_TextFieldCP.insets = new Insets(0, 0, 5,5);
		gbc_TextFieldCP.gridheight = 1;
		gbc_TextFieldCP.gridwidth = 3;
		gbc_TextFieldCP.gridx = 6; 
		gbc_TextFieldCP.gridy = 5;
		gbc_TextFieldCP.weightx = 0.0;
		gbc_TextFieldCP.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(JTextFieldCP,gbc_TextFieldCP);
		
		//se agregan propiedades de GridBagLAyout a panelCodigoError9
		JPanel panelCodigoError9= new JPanel();
		lblAsterisco[9]=inicizalizalbl(lblAsterisco[9]);
		panelCodigoError9.setBackground(UIManager.getColor("Button.focus"));
		panelCodigoError9.add(lblAsterisco[9]);
		GridBagConstraints gbc_panelCodigoError9=new GridBagConstraints ();
		gbc_panelCodigoError9.insets = new Insets(0, 0, 1,1);
		gbc_panelCodigoError9.gridheight = 1;
		gbc_panelCodigoError9.gridwidth = 1;
		gbc_panelCodigoError9.gridx = 9; 
		gbc_panelCodigoError9.gridy = 5;
		gbc_panelCodigoError9.weightx = 0;
		gbc_panelCodigoError9.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add( panelCodigoError9,gbc_panelCodigoError9);
		
		//se agregan propiedades de GridBagLAyout a lblTelefono
		lblTelefono= new JLabel("Telefono: ");
		lblTelefono.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTelefono.doLayout();
		GridBagConstraints gbc_lblTelefono=new GridBagConstraints ();
		gbc_lblTelefono.insets = new Insets(0, 0, 1,1);
		gbc_lblTelefono.gridheight = 1;
		gbc_lblTelefono.gridwidth = 1;
		gbc_lblTelefono.gridx = 10; 
		gbc_lblTelefono.gridy = 5;
		gbc_lblTelefono.weightx = 0;
		gbc_lblTelefono.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(lblTelefono,gbc_lblTelefono);
		
		//se agregan propiedades de GridBagLAyout a JTextFieldTelefono
		JTextFieldTelefono= new JTextField(5);
		JTextFieldTelefono.setFont(new Font("Dialog", Font.BOLD, 18));
		JTextFieldTelefono.doLayout();
		GridBagConstraints gbc_TextFieldTelefono=new GridBagConstraints ();
		gbc_TextFieldTelefono.insets = new Insets(0, 0, 5,5);
		gbc_TextFieldTelefono.gridheight = 1;
		gbc_TextFieldTelefono.gridwidth =11;
		gbc_TextFieldTelefono.gridx = 11; 
		gbc_TextFieldTelefono.gridy = 5;
		gbc_TextFieldTelefono.weightx = 0.0;
		gbc_TextFieldTelefono.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(JTextFieldTelefono,gbc_TextFieldTelefono);
		
		//se agregan propiedades de GridBagLAyout a panelCodigoError10
		JPanel panelCodigoError10= new JPanel();
		lblAsterisco[10]=inicizalizalbl(lblAsterisco[10]);
		panelCodigoError10.setBackground(UIManager.getColor("Button.focus"));
		panelCodigoError10.add(lblAsterisco[10]);
		GridBagConstraints gbc_panelCodigoError10=new GridBagConstraints ();
		gbc_panelCodigoError10.insets = new Insets(0, 0, 1,1);
		gbc_panelCodigoError10.gridheight = 1;
		gbc_panelCodigoError10.gridwidth = 1;
		gbc_panelCodigoError10.gridx = 25; 
		gbc_panelCodigoError10.gridy = 5;
		gbc_panelCodigoError10.weightx = 0;
		gbc_panelCodigoError10.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add( panelCodigoError10,gbc_panelCodigoError10);
		
		//se agregan propiedades de GridBagLAyout a lblCargo
		lblCargo= new JLabel("Cargo: ");
		lblCargo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCargo.doLayout();
		GridBagConstraints gbc_lblCargo=new GridBagConstraints ();
		gbc_lblCargo.insets = new Insets(0, 0, 1,1);
		gbc_lblCargo.gridheight = 1;
		gbc_lblCargo.gridwidth = 1;
		gbc_lblCargo.gridx = 0; 
		gbc_lblCargo.gridy = 6;
		gbc_lblCargo.weightx = 0;
		gbc_lblCargo.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(lblCargo,gbc_lblCargo);
		
		//se agregan propiedades de GridBagLAyout a JComboBoxCargo
		JComboBoxCargo= new JComboBox();
		JComboBoxCargo.setFont(new Font("Dialog", Font.BOLD, 18));
		JComboBoxCargo.doLayout();
		GridBagConstraints gbc_ComboBoxCargo=new GridBagConstraints ();
		gbc_ComboBoxCargo.insets = new Insets(0, 0, 0,1);
		gbc_ComboBoxCargo.gridheight = 1;
		gbc_ComboBoxCargo.gridwidth = 3;
		gbc_ComboBoxCargo.gridx = 1; 
		gbc_ComboBoxCargo.gridy = 6;
		gbc_ComboBoxCargo.weightx = 0;
		gbc_ComboBoxCargo.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(JComboBoxCargo,gbc_ComboBoxCargo);
		JComboBoxCargo.addItem("");
		
		//se agregan propiedades de GridBagLAyout a panelCodigoError11
		JPanel panelCodigoError11= new JPanel();
		lblAsterisco[11]=inicizalizalbl(lblAsterisco[11]);
		panelCodigoError11.setBackground(UIManager.getColor("Button.focus"));
		panelCodigoError11.add(lblAsterisco[11]);
		GridBagConstraints gbc_panelCodigoError11=new GridBagConstraints ();
		gbc_panelCodigoError11.insets = new Insets(0, 0, 1,1);
		gbc_panelCodigoError11.gridheight = 1;
		gbc_panelCodigoError11.gridwidth = 1;
		gbc_panelCodigoError11.gridx = 4; 
		gbc_panelCodigoError11.gridy = 6;
		gbc_panelCodigoError11.weightx = 0;
		gbc_panelCodigoError11.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add( panelCodigoError11,gbc_panelCodigoError11);
		
		//se agregan propiedades de GridBagLAyout a lblID
		lblID= new JLabel("ID: ");
		lblID.setFont(new Font("Dialog", Font.BOLD, 18));
		lblID.doLayout();
		GridBagConstraints gbc_lblID=new GridBagConstraints ();
		gbc_lblID.insets = new Insets(0, 0, 1,1);
		gbc_lblID.gridheight = 1;
		gbc_lblID.gridwidth = 1;
		gbc_lblID.gridx = 5; 
		gbc_lblID.gridy = 6;
		gbc_lblID.weightx = 0;
		gbc_lblID.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(lblID,gbc_lblID);
		
		//se agregan propiedades de GridBagLAyout a JTextFieldID
		JTextFieldID= new JTextField(5);
		JTextFieldID.setFont(new Font("Dialog", Font.BOLD, 18));
		JTextFieldID.doLayout();
		GridBagConstraints gbc_TextFieldID=new GridBagConstraints ();
		gbc_TextFieldID.insets = new Insets(0, 0, 5,5);
		gbc_TextFieldID.gridheight = 1;
		gbc_TextFieldID.gridwidth = 3;
		gbc_TextFieldID.gridx = 6; 
		gbc_TextFieldID.gridy = 6;
		gbc_TextFieldID.weightx = 0.0;
		gbc_TextFieldID.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(JTextFieldID,gbc_TextFieldID);
		
		
		//se agregan propiedades de GridBagLAyout a panelVacio
		JPanel panelVacio= new JPanel();
		panelVacio.setBackground(UIManager.getColor("Button.focus"));
		GridBagConstraints gbc_panelVacio=new GridBagConstraints ();
		gbc_panelVacio.insets = new Insets(0, 0, 60,11);
		gbc_panelVacio.gridheight = 1;
		gbc_panelVacio.gridwidth = 1;
		gbc_panelVacio.gridx = 0; 
		gbc_panelVacio.gridy = 8;
		gbc_panelVacio.weightx = 0;
		gbc_panelVacio.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(panelVacio,gbc_panelVacio);
		
		
		//se agregan propiedades de GridBagLAyout a lblContraseña
		lblContrasena= new JLabel("Contrasena: ");
		lblContrasena.setFont(new Font("Dialog", Font.BOLD, 18));
		lblContrasena.doLayout();
		GridBagConstraints gbc_lblContrasena=new GridBagConstraints ();
		gbc_lblContrasena.insets = new Insets(0, 0, 1,1);
		gbc_lblContrasena.gridheight = 1;
		gbc_lblContrasena.gridwidth = 1;
		gbc_lblContrasena.gridx = 0; 
		gbc_lblContrasena.gridy = 9;
		gbc_lblContrasena.weightx = 0;
		gbc_lblContrasena.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(lblContrasena,gbc_lblContrasena);
		
		//se agregan propiedades de GridBagLAyout a JTextFieldContraseña
		JPasswordFieldContrasena= new JPasswordField(5);
		JPasswordFieldContrasena.setFont(new Font("Dialog", Font.BOLD, 18));
		JPasswordFieldContrasena.doLayout();
		GridBagConstraints gbc_TextFieldContrasena=new GridBagConstraints ();
		gbc_TextFieldContrasena.insets = new Insets(0, 0, 5,5);
		gbc_TextFieldContrasena.gridheight = 1;
		gbc_TextFieldContrasena.gridwidth = 3;
		gbc_TextFieldContrasena.gridx = 1; 
		gbc_TextFieldContrasena.gridy = 9;
		gbc_TextFieldContrasena.weightx = 0.0;
		gbc_TextFieldContrasena.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(JPasswordFieldContrasena,gbc_TextFieldContrasena);
		
		
		//se agregan propiedades de GridBagLAyout a panelCodigoError13
		JPanel panelCodigoError13= new JPanel();
		lblAsterisco[13]=inicizalizalbl(lblAsterisco[13]);
		panelCodigoError13.setBackground(UIManager.getColor("Button.focus"));
		panelCodigoError13.add(lblAsterisco[13]);
		GridBagConstraints gbc_panelCodigoError13=new GridBagConstraints ();
		gbc_panelCodigoError13.insets = new Insets(0, 0, 1,1);
		gbc_panelCodigoError13.gridheight = 1;
		gbc_panelCodigoError13.gridwidth = 1;
		gbc_panelCodigoError13.gridx = 4; 
		gbc_panelCodigoError13.gridy = 9;
		gbc_panelCodigoError13.weightx = 0;
		gbc_panelCodigoError13.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(panelCodigoError13,gbc_panelCodigoError13);
		
		//se agregan propiedades de GridBagLAyout a lblConfirmacion
		lblConfirmacion= new JLabel("Confirmar \n Contraseña: ");
		lblConfirmacion.setFont(new Font("Dialog", Font.BOLD, 18));
		lblConfirmacion.doLayout();
		GridBagConstraints gbc_lblConfirmacion=new GridBagConstraints ();
		gbc_lblConfirmacion.insets = new Insets(0, 0, 1,1);
		gbc_lblConfirmacion.gridheight = 1;
		gbc_lblConfirmacion.gridwidth = 1;
		gbc_lblConfirmacion.gridx = 0; 
		gbc_lblConfirmacion.gridy = 10;
		gbc_lblConfirmacion.weightx = 0;
		gbc_lblConfirmacion.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(lblConfirmacion,gbc_lblConfirmacion);
		
		//se agregan propiedades de GridBagLAyout a JTextFieldConfirmacion
		JPasswordFieldConfirmacion= new JPasswordField(5);
		JPasswordFieldConfirmacion.setFont(new Font("Dialog", Font.BOLD, 18));
		JPasswordFieldConfirmacion.doLayout();
		GridBagConstraints gbc_TextFieldConfirmacion=new GridBagConstraints ();
		gbc_TextFieldConfirmacion.insets = new Insets(0, 0, 5,5);
		gbc_TextFieldConfirmacion.gridheight = 1;
		gbc_TextFieldConfirmacion.gridwidth = 3;
		gbc_TextFieldConfirmacion.gridx = 1; 
		gbc_TextFieldConfirmacion.gridy = 10;
		gbc_TextFieldConfirmacion.weightx = 0.0;
		gbc_TextFieldConfirmacion.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(JPasswordFieldConfirmacion,gbc_TextFieldConfirmacion);
		
		//se agregan propiedades de GridBagLAyout a panelCodigoError14
		JPanel panelCodigoError14= new JPanel();
		lblAsterisco[14]=inicizalizalbl(lblAsterisco[14]);
		panelCodigoError14.setBackground(UIManager.getColor("Button.focus"));
		panelCodigoError14.add(lblAsterisco[14]);
		GridBagConstraints gbc_panelCodigoError14=new GridBagConstraints ();
		gbc_panelCodigoError14.insets = new Insets(0, 0, 1,11);
		gbc_panelCodigoError14.gridheight = 1;
		gbc_panelCodigoError14.gridwidth = 1;
		gbc_panelCodigoError14.gridx = 4; 
		gbc_panelCodigoError14.gridy = 10;
		gbc_panelCodigoError14.weightx = 0;
		gbc_panelCodigoError14.fill = GridBagConstraints.HORIZONTAL;
		panelUsuario.add(panelCodigoError14,gbc_panelCodigoError14);
		
		//se asignan propiedades al JButton
		JButtonActualizar= new JButton("Actualizar");
		JButtonActualizar.setFont(new Font("Dialog", Font.BOLD, 30));
		panel3.add(JButtonActualizar, BorderLayout.WEST);
		//se asignan propiedades al JComboBox
		JComboBoxCargo.addItem("Encargado");
		JComboBoxCargo.addItem("Empleado");
		
		//se agregan tips a los botones
		JButtonBuscar.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Buscar</h4></div></body></html>"); 
		JButtonActualizar.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Actualizar</h4></div></body></html>");
		btnSalir.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Regresar a ventana 'Usuario'</h4></div></body></html>"); 
		
		
		//se agregan tips a los objetos
		JComboBoxCargo.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Selecciona Cargo</h4></div></body></html>");
		JTextFieldCodigoEmpleado.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Introdusca Codigo Empleado</h4></div></body></html>");
		JTextFieldApellidoPaterno.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Modifica Apellido Paterno</h4></div></body></html>");
		JTextFieldApellidoMaterno.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Modifica Apellido Materno</h4></div></body></html>");
		JTextFieldNombre.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Modifica Nombre</h4></div></body></html>");
		JTextFieldCalle.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Modifica Calle</h4></div></body></html>");
		JTextFieldNumExterior.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Modifica Numero Exterior</h4></div></body></html>");
		JTextFieldNumInterior.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Modifica Numero Interior</h4></div></body></html>");
		JTextFieldColonia.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Modifica Colonia</h4></div></body></html>");
		JTextFieldMunicipio.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Modifica Municipio</h4></div></body></html>");
		JTextFieldCP.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Modifica Codigo Postal</h4></div></body></html>");
		JTextFieldTelefono.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Modifica Telefono</h4></div></body></html>");
		JPasswordFieldContrasena.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Contraseña</h4></div></body></html>");
		JPasswordFieldConfirmacion.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Confirmar contraseña</h4></div></body></html>");
		btnSalir.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Regresar a ventana Usuario</h4></div></body></html>");
		
		//metodo de visibilidad de objetos
		visibilidad(false,true);
		
		
		JButtonActualizar.setEnabled(false);
		JTextFieldID.setEditable(false);
		
		//borde del tooltip
		UIManager.put("ToolTip.border",BorderFactory.createEtchedBorder(BevelBorder.RAISED));
		
		//evento de JButtonActualizar
		JButtonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valor;
				valor=validaciones();
				if(valor){
					vaciaCampos();
					JTextFieldCodigoEmpleado.setText("");
					ventana.dispose();
				}
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					vaciaCampos();
					JTextFieldCodigoEmpleado.setText("");
					ventana.dispose();
			}
		});
		
		
		//se añade un evento del JButtonBuscar
		JButtonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] usuario=null;
				String identificador;
				if(JTextFieldCodigoEmpleado.getText().length()==0 || JTextFieldCodigoEmpleado.getText().contains(" ")){
					lblAsterisco[0].setForeground(Color.red);
					JOptionPane.showMessageDialog(ventana, "Inserte Codigo Empleado");
				}else{
					try{
						identificador=JTextFieldCodigoEmpleado.getText();
						usuario=observiciousuario.buscaId(identificador);
						vaciaCampos();
						if(usuario!=null){

							//añade los campos de usuario a los TextField
							JTextFieldApellidoPaterno.setText(usuario[0]);
							JTextFieldApellidoMaterno.setText(usuario[1]);
							JTextFieldNombre.setText(usuario[2]);
							JTextFieldCalle.setText(usuario[3]);
							JTextFieldNumExterior.setText(usuario[4]);
							JTextFieldNumInterior.setText(usuario[5]);
							JTextFieldColonia.setText(usuario[6]);
							JTextFieldMunicipio.setText(usuario[7]);
							JTextFieldCalle.setText(usuario[8]);
							JTextFieldCP.setText(usuario[9]);
							JTextFieldTelefono.setText(usuario[10]);
							JTextFieldID.setText(usuario[11]);
							JPasswordFieldContrasena.setText(usuario[12]);
							
							JPasswordFieldConfirmacion.setText(usuario[13]);
						
							visibilidad(true,Integer.parseInt(usuario[14])==1);
							JButtonActualizar.setEnabled(true);
							if(Integer.parseInt(usuario[14])==1){
								JComboBoxCargo.setSelectedIndex(1);
							}else{
								JComboBoxCargo.setSelectedIndex(2);
								JComboBoxCargo.setEnabled(false);
							}
						}else{
							JOptionPane.showMessageDialog(ventana, "usuario no encontrado");
						}
					}catch(Exception ex){
						lblAsterisco[0].setForeground(Color.red);
						JOptionPane.showMessageDialog(ventana,"Codigo Empleado invalido");
					}
				}
			}
		});
		//se añade evento a JTextFieldApellidoPaterno
		JTextFieldApellidoPaterno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(Character.isDigit(e.getKeyChar()) || e.getKeyChar()<'a' || e.getKeyChar()>'z'){
					e.consume();
				}
			}
		});
		//se añade evento a JTextFieldApellidoMaterno
		JTextFieldApellidoMaterno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(Character.isDigit(e.getKeyChar()) || e.getKeyChar()<'a' || e.getKeyChar()>'z'){
					e.consume();
				}
			}
		});
		
		//se añade evento a JTextFieldNombre
		JTextFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(Character.isDigit(e.getKeyChar()) || e.getKeyChar()<'a' || e.getKeyChar()>'z'){
					e.consume();
				}
			}
		});
					
		//se añade evento a JTextFieldNumInterior
		JTextFieldNumInterior.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){
					e.consume();
				}
			}
		});
		//se añade evento a JTextFieldNumExterior
		JTextFieldNumExterior.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){
					e.consume();
				}
			}
		});
		//se añade evento a JTextFieldCP
		JTextFieldCP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){
					e.consume();
				}
			}
		});
		//se añade evento a JTextFieldContraseña
		JPasswordFieldContrasena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JPasswordFieldContrasena.getText().length()>20){
					e.consume();
				}
			}
		});
		//se añade evento a JTextFieldConfirmacion
		JPasswordFieldConfirmacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JPasswordFieldConfirmacion.getText().length()>20){
					e.consume();
				}
			}
		});
		//se añade evento a JTextFieldTelefono
		JTextFieldTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()) || JTextFieldTelefono.getText().length()>10){
					e.consume();
				}
			}
		});
		//se añade evento a JTextFieldCodigoEmpleado
		JTextFieldCodigoEmpleado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(JTextFieldCodigoEmpleado.getText().length()>5){
					e.consume();
				}
			}
		});
		//se añade evento a JTextFieldColonia
		JTextFieldColonia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(Character.isDigit(e.getKeyChar()) || e.getKeyChar()<'a' || e.getKeyChar()>'z'){
					e.consume();
				}
			}
		});
		//se añade evento a JTextFieldMunicipio
		JTextFieldMunicipio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(Character.isDigit(e.getKeyChar()) || e.getKeyChar()<'a' || e.getKeyChar()>'z'){
					e.consume();
				}
			}
		});
	}
	
	//vacia campos JTextField
	public void vaciaCampos(){
		int indice;
		JTextFieldApellidoPaterno.setText("");
		JTextFieldApellidoMaterno.setText("");
		JTextFieldNombre.setText("");
		JTextFieldCalle.setText("");
		JTextFieldNumExterior.setText("");
		JTextFieldNumInterior.setText("");
		JTextFieldColonia.setText("");
		JTextFieldMunicipio.setText("");
		JTextFieldCalle.setText("");
		JTextFieldCP.setText("");
		JTextFieldTelefono.setText("");
		JTextFieldID.setText("");
		JPasswordFieldContrasena.setText("");
		JPasswordFieldConfirmacion.setText("");
		visibilidad(false,true);
		JButtonActualizar.setEnabled(false);
		JComboBoxCargo.setSelectedIndex(0);
		for(indice=0;indice<15;indice++){
			if(indice!=6 && indice!=12){
				lblAsterisco[indice].setForeground(UIManager.getColor("Button.focus"));
			}
		}
		
	}
	//metodo para la visibilidad de objetos
	public void visibilidad(boolean opcion, boolean tipo){
		JTextFieldApellidoPaterno.setVisible(opcion);
		JTextFieldApellidoMaterno.setVisible(opcion);
		JTextFieldNombre.setVisible(opcion);
		JTextFieldCalle.setVisible(opcion);
		JTextFieldNumExterior.setVisible(opcion);
		JTextFieldNumInterior.setVisible(opcion);
		JTextFieldColonia.setVisible(opcion);
		JTextFieldMunicipio.setVisible(opcion);
		JTextFieldCP.setVisible(opcion);
		JTextFieldTelefono.setVisible(opcion);
		lblApellidoPaterno.setVisible(opcion);
		lblApellidoMaterno.setVisible(opcion);
		lblNombre.setVisible(opcion);
		lblCalle.setVisible(opcion);
		lblNumExterior.setVisible(opcion);
		lblNumInterior.setVisible(opcion);
		lblColonia.setVisible(opcion);
		lblMunicipio.setVisible(opcion);
		lblCP.setVisible(opcion);
		lblTelefono.setVisible(opcion);
		JComboBoxCargo.setVisible(opcion);
		lblCargo.setVisible(opcion);
		JTextFieldID.setVisible(opcion);
		lblID.setVisible(opcion);
		if(tipo){
			JPasswordFieldContrasena.setVisible(opcion);
			JPasswordFieldConfirmacion.setVisible(opcion);
			lblContrasena.setVisible(opcion);
			lblConfirmacion.setVisible(opcion);
		}
	}
	//incializa los JLabel
	public JLabel inicizalizalbl(JLabel label){
		label=new JLabel("*");
		label.setFont(new Font("Dialog", Font.BOLD, 25));
		label.setForeground(UIManager.getColor("Button.focus"));
		return label;
	}
	
	//valida los capos JTextField
	public boolean validaciones(){
		int cont=0;
		if(JTextFieldApellidoPaterno.getText().length()<2){
			cont++;
			lblAsterisco[1].setForeground(Color.red);
		}
		if(JTextFieldApellidoMaterno.getText().length()<2){
			cont++;
			lblAsterisco[2].setForeground(Color.red);
		}
		if(JTextFieldNombre.getText().length()<2){
			cont++;
			lblAsterisco[3].setForeground(Color.red);
		}
		if(JTextFieldCalle.getText().length()==0){
			cont++;
			lblAsterisco[4].setForeground(Color.red);
		}
		if(JTextFieldNumExterior.getText().length()==0){
			cont++;
			lblAsterisco[5].setForeground(Color.red);
		}
		if(JTextFieldColonia.getText().length()==0){
			cont++;
			lblAsterisco[7].setForeground(Color.red);
		}
		
		if(JTextFieldMunicipio.getText().length()==0){
			cont++;
			lblAsterisco[8].setForeground(Color.red);
		}
		if(JTextFieldCP.getText().length()==0){
			cont++;
			lblAsterisco[9].setForeground(Color.red);
		}
		if(JTextFieldTelefono.getText().length()==0){
			cont++;
			lblAsterisco[10].setForeground(Color.red);
		}
		if(JComboBoxCargo.getSelectedIndex()==0){
			cont++;
			lblAsterisco[11].setForeground(Color.red);
		}
		if(JPasswordFieldContrasena.getText().length()>20 || JPasswordFieldContrasena.getText().length()<10){
			cont++;
			lblAsterisco[13].setForeground(Color.red);
		}
		
		if(!JPasswordFieldConfirmacion.getText().equals(JPasswordFieldContrasena.getText())){
			cont++;
			lblAsterisco[14].setForeground(Color.red);
		}
		if(cont==0){
			boolean opcion;
			int valor;
			if(JComboBoxCargo.getSelectedIndex()==1){
				 valor=1;
			}else{
				valor=0;
			}
			opcion=observiciousuario.actualizaEmpleado(JTextFieldCodigoEmpleado.getText(), JTextFieldNombre.getText(), JTextFieldApellidoPaterno.getText(), JTextFieldApellidoMaterno.getText(), JTextFieldCalle.getText(), Integer.parseInt(JTextFieldNumExterior.getText()),Integer.parseInt(JTextFieldNumInterior.getText()), JTextFieldColonia.getText(), JTextFieldMunicipio.getText(), Integer.parseInt(JTextFieldCP.getText()), JTextFieldTelefono.getText(), valor, JPasswordFieldContrasena.getText());
			if(!opcion){
				JOptionPane.showMessageDialog(ventana, "Usuario actualizado correctamente");
			}else{
				JOptionPane.showMessageDialog(ventana, "Usuario no se pudo actualizar");
			}
			return true;
		}else{
			JOptionPane.showMessageDialog(ventana, "Campos invalidos corrija campos señalados");
			return false;
		}
			
	}
	
}