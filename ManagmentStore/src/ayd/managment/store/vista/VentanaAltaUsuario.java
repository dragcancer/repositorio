package ayd.managment.store.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ayd.managment.store.servicio.Interface.ServicioAltaUsuario;

//Heredo de VentanaGenerica
public class VentanaAltaUsuario extends VentanaGenerica{

    //Variables de la clase
    private ServicioAltaUsuario servicioAltaUsuario;
    //Botones de la clase
    private JButton btnAlta = new JButton("Dar de Alta");
    //Etiquetas
    private JLabel lblNombre = new JLabel("*Nombre:");
    private JLabel lblApellidoPaterno = new JLabel("*Apellido Paterno:");
    private JLabel lblApellidoMaterno = new JLabel("*Apellido Materno:");
    private JLabel lblDatosAdicionales = new JLabel("Datos Adicionales");
    private JLabel lblCalle = new JLabel("*Calle:");
    private JLabel lblNumeroExterior = new JLabel("*Número exterior:");
    private JLabel lblNumeroInterior = new JLabel(" Número interior:");
    private JLabel lblColonia = new JLabel(" Colonia:");
    private JLabel lblMunicipio = new JLabel("*Delegación/Municipio:");
    private JLabel lblCodigoPostal = new JLabel("*Código postal:");
    private JLabel lblTelefono = new JLabel("*Teléfono (a 10 digitos):");
    private JLabel lblTipo = new JLabel("*Tipo:");
    private JLabel lblPassword = new JLabel("*Contraseña:");
    private JLabel lblPasswordRepite = new JLabel("*Repita contraseña:");
    private JLabel lblNota = new JLabel("(*) Campos obligatorios");
    private JLabel label1 = new JLabel();
    private JLabel label2 = new JLabel();
    
    //Campos de texto
    private JTextField txtNombre = new JTextField("");
    private JTextField txtApellidoPaterno = new JTextField("");
    private JTextField txtApellidoMaterno = new JTextField("");
    private JTextField txtCalle = new JTextField("");
    private JTextField txtNumeroExterior = new JTextField("");
    private JTextField txtNumeroInterior = new JTextField("");
    private JTextField txtColonia = new JTextField("");
    private JTextField txtMunicipio = new JTextField("");
    private JTextField txtCodigoPostal = new JTextField("");
    private JTextField txtTelefono = new JTextField("");
    //para passwords
    private JPasswordField password = new JPasswordField();
    private JPasswordField confirmaPassword = new JPasswordField();
    //ComboBox
    private JComboBox cbxTipo = new JComboBox(new javax.swing.DefaultComboBoxModel(new String[] {"Empleado","Encargado"}));
    //Variables de la clase
    private int tecla;
    private int limite = 10;
    private int seleccionar;
    
    private String codigo;
    
    public VentanaAltaUsuario(ServicioAltaUsuario control){
        super("Alta de empleado","Regresar a ventana \"Empleados\"");
        servicioAltaUsuario = control;
        //Asigna formato a los componentes de la ventana
        colocaFormato();
        //Inserta los elementos a los paneles
        InsertaEnPanel();
        panel3.add(btnAlta, BorderLayout.WEST);
        //Omite caracteres invalidos
        txtNombre.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                validaCadenaConEspacio(txtNombre.getText(), e);
            }
        });
        
        //Omite caracteres invalidos
        txtApellidoPaterno.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                validaCadenaConEspacio(txtApellidoPaterno.getText(), e);
            }
        });
        
        //Omite caracteres invalidos
        txtApellidoMaterno.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                validaCadenaConEspacio(txtApellidoMaterno.getText(), e);
            }
        });
        
        //Omite caracteres invalidos
        txtCalle.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                validaCadenaConEnteroEspacio(txtCalle.getText(), e);
            }
        });
        
        //Omite caracteres invalidos
        txtNumeroExterior.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                validaEntero(txtNumeroExterior.getText(), e);
            }
        });
        
        //Omite caracteres invalidos
        txtNumeroInterior.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                validaEntero(txtNumeroInterior.getText(), e);
            }
        });
        
        //Omite caracteres invalidos
        txtColonia.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                validaCadenaConEspacio(txtColonia.getText(), e);
            }
        });
        
        //Omite caracteres invalidos
        txtMunicipio.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                validaCadenaConEspacio(txtMunicipio.getText(), e);
            }
        });
        
        //Omite caracteres invalidos
        txtCodigoPostal.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                validaEntero(txtCodigoPostal.getText(), e);
            }
        });
        
        //Omite caracteres invalidos
        txtTelefono.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                validaEntero(txtTelefono.getText(), e);
            }
        });
        
        //Omite caracteres invalidos
        password.addKeyListener(new KeyAdapter() {
            @SuppressWarnings("deprecation")
			public void keyTyped(KeyEvent e) {
                validaCadenaConEntero(password.getText(), e);
            }
        });
        
        //Omite caracteres invalidos
        confirmaPassword.addKeyListener(new KeyAdapter() {
            @SuppressWarnings("deprecation")
			public void keyTyped(KeyEvent e) {
                validaCadenaConEntero(confirmaPassword.getText(), e);
            }
        });
        
        //Selecciona el tipo de Usuario
        cbxTipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seleccionar = cbxTipo.getSelectedIndex();
            }
        });
        
        //Alta de Usuario
        btnAlta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if(validaCampos()){
            		if(validaTelefono(txtTelefono.getText())){
            			if(validaContrasena()){
            				generaCodigo();
            				if(realizaAltaUsuario()){
            					limpiaCampos();
            					ventana.dispose();
            				}
            			}
            		}
            	}
            }
        });

        //boton salir o cancelar
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //btnAlta.setEnabled(false);
                limpiaCampos();
            }
        });
    }
    
    //asigna formato a los componentes de la ventana
    private void colocaFormato(){
    	//Botones
    	btnAlta.setFont(new Font("Dialog", Font.BOLD, 30));
    	
    	//Etiquetas
        lblNombre.setFont(new Font("Dialog", Font.BOLD, 28));
        lblApellidoPaterno.setFont(new Font("Dialog", Font.BOLD, 28));
        lblApellidoMaterno.setFont(new Font("Dialog", Font.BOLD, 28));
        lblDatosAdicionales.setFont(new Font("Dialog", Font.BOLD, 28));
        lblCalle.setFont(new Font("Dialog", Font.BOLD, 28));
        lblNumeroExterior.setFont(new Font("Dialog", Font.BOLD, 28));
        lblNumeroInterior.setFont(new Font("Dialog", Font.BOLD, 28));
        lblColonia.setFont(new Font("Dialog", Font.BOLD, 28));
        lblMunicipio.setFont(new Font("Dialog", Font.BOLD, 28));
        lblCodigoPostal.setFont(new Font("Dialog", Font.BOLD, 28));
        lblTelefono.setFont(new Font("Dialog", Font.BOLD, 28));
        lblTipo.setFont(new Font("Dialog", Font.BOLD, 28));
        lblPassword.setFont(new Font("Dialog", Font.BOLD, 28));
        lblPasswordRepite.setFont(new Font("Dialog", Font.BOLD, 28));
        lblNota.setFont(new Font("Dialog", Font.BOLD, 20));
        
        //Campos de texto
        txtNombre.setFont(new Font("Dialog", Font.BOLD, 28));
        txtApellidoPaterno.setFont(new Font("Dialog", Font.BOLD, 28));
        txtApellidoMaterno.setFont(new Font("Dialog", Font.BOLD, 28));
        txtCalle.setFont(new Font("Dialog", Font.BOLD, 28));
        txtNumeroExterior.setFont(new Font("Dialog", Font.BOLD, 28));
        txtNumeroInterior.setFont(new Font("Dialog", Font.BOLD, 28));
        txtColonia.setFont(new Font("Dialog", Font.BOLD, 28));
        txtMunicipio.setFont(new Font("Dialog", Font.BOLD, 28));
        txtCodigoPostal.setFont(new Font("Dialog", Font.BOLD, 28));
        txtTelefono.setFont(new Font("Dialog", Font.BOLD, 28));
        password.setFont(new Font("Dialog", Font.BOLD, 28));
        confirmaPassword.setFont(new Font("Dialog", Font.BOLD, 28));
        cbxTipo.setFont(new Font("Dialog", Font.BOLD, 28));
    }        

    //deja la ventana limpia
    private void limpiaCampos(){
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtCalle.setText("");
        txtNumeroExterior.setText("");
        txtNumeroInterior.setText("");
        txtColonia.setText("");
        txtMunicipio.setText("");
        txtCodigoPostal.setText("");
        txtTelefono.setText("");
        password.setText("");
        confirmaPassword.setText("");
    }
       
    //inserta los componentes en la ventana
    private void InsertaEnPanel(){
    	panel2.setLayout( new GridLayout(0, 2, 0, 0));//Aqui 
        panel2.add(lblNombre);
        panel2.add(txtNombre);
        panel2.add(lblApellidoPaterno);
        panel2.add(txtApellidoPaterno);
        panel2.add(lblApellidoMaterno);
        panel2.add(txtApellidoMaterno);
        panel2.add(lblDatosAdicionales);
        panel2.add(label1);
        panel2.add(lblCalle);
        panel2.add(txtCalle);
        panel2.add(lblNumeroExterior);
        panel2.add(txtNumeroExterior);
        panel2.add(lblNumeroInterior);
        panel2.add(txtNumeroInterior);
        panel2.add(lblColonia);
        panel2.add(txtColonia);
        panel2.add(lblMunicipio);
        panel2.add(txtMunicipio);
        panel2.add(lblCodigoPostal);
        panel2.add(txtCodigoPostal);
        panel2.add(lblTelefono);
        panel2.add(txtTelefono);
        panel2.add(lblTipo);
        panel2.add(cbxTipo);
        panel2.add(lblPassword);
        panel2.add(password);
        panel2.add(lblPasswordRepite);
        panel2.add(confirmaPassword);
        panel2.add(lblNota);
        panel2.add(label2);
    }
        
    //validacion de reglas de negocio referentes a password
    //el password debe tener un tamanio de 10 a 20 caracteres
    @SuppressWarnings("deprecation")
	private boolean validaContrasena(){
    	if (!(password.getText().length()>=10 && password.getText().length() <= 20)){
    		JOptionPane.showMessageDialog(ventana,"La contraseña no cumple con la longitud requerida.","Error",JOptionPane.WARNING_MESSAGE);
    		return false;
    	}
    	else{
    		if (!(password.getText().equals(confirmaPassword.getText())) ){
    			JOptionPane.showMessageDialog(ventana,"La contraseña y su confirmación no son iguales.","Error",JOptionPane.WARNING_MESSAGE);
    			return false;
    		}
    		else
    			return true;
    	}
    }
    
    //validacion de reglas de negocio referentes a telefono
    //el telefono debe tener un tamanio de 10 caracteres
    private boolean validaTelefono(String telefono){
    	if(telefono.length() != limite){
    		JOptionPane.showMessageDialog(ventana,"Tamaño de teléfono incorrecto.","Error",JOptionPane.WARNING_MESSAGE);
    		return false;
        }
    	else
    		return true;    
    }
        
    //Omite caracteres invalidos
    private void  validaCadenaConEntero(String anterior, KeyEvent e){
    	tecla = (int) e.getKeyChar();
    	if(tecla >= 32 && tecla <= 47 || tecla >=58 && tecla <= 96 || tecla >= 123 && tecla <= 255)
    		e.consume();
    }
    
    //Omite caracteres invalidos
    private void  validaCadenaConEnteroEspacio(String anterior, KeyEvent e){
    	tecla = (int) e.getKeyChar();
    	if(tecla >= 33 && tecla <= 47 || tecla >=58 && tecla <= 96 || tecla >= 123 && tecla <= 255)
    		e.consume();
    }
        
    //Omite caracteres invalidos
    private void  validaCadenaConEspacio(String anterior, KeyEvent e){
    	tecla = (int) e.getKeyChar();
    	if(tecla >= 33 && tecla <= 96 || tecla >= 123 && tecla <= 255)
    		e.consume();
    }
        
    //Omite caracteres invalidos
    private void  validaEntero(String anterior, KeyEvent e){
    	tecla = (int) e.getKeyChar();
    	if(tecla >= 32 && tecla <= 47 || tecla >= 58 && tecla <= 255)
    		e.consume();
    }
    
    //Verifica que todos los campos obligatorios esten llenos    
    @SuppressWarnings("deprecation")
	private boolean validaCampos() {
    	String nombre = txtNombre.getText();
    	String apellidoPaterno = txtApellidoPaterno.getText();
    	String apellidoMaterno = txtApellidoMaterno.getText();
    	String calle = txtCalle.getText();
    	String numExte = txtNumeroExterior.getText();
    	String municipio = txtMunicipio.getText();
    	String codigoPos = txtCodigoPostal.getText();
    	String telefono = txtTelefono.getText();
		String pass = password.getText();
    	String passConfirm = confirmaPassword.getText();
		  
    	if(nombre.isEmpty() || apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty() || calle.isEmpty() || numExte.isEmpty() || municipio.isEmpty() || codigoPos.isEmpty() || telefono.isEmpty() || pass.isEmpty() || passConfirm.isEmpty() ){
    		JOptionPane.showMessageDialog(ventana,"Hay uno o más campos obligatorios vacios.","Error",JOptionPane.WARNING_MESSAGE);
    		return false;
        }
    	else 
    		return true;
    }
        
    //Genera un codigo para un usuario nuevo
    //a partir de las reglas de negocio
    private boolean generaCodigo(){
    	codigo = null;
    	String nombre = txtNombre.getText();
    	String apellidoPaterno = txtApellidoPaterno.getText();
    	String apellidoMaterno = txtApellidoMaterno.getText();
    	String telefono = txtTelefono.getText();
    	char[] nom = nombre.toCharArray();
    	char[] pat = apellidoPaterno.toCharArray();
    	char[] mat = apellidoMaterno.toCharArray();
    	char[] tel = telefono.toCharArray();
    	codigo  = ""+nom[0]+pat[0]+mat[0]+tel[tel.length-3]+tel[tel.length-2]+tel[tel.length-1];  
    	if(codigo.length() == 6)
    		return true;
    	else
    		return false;
    }
    
    //realiza la alta de un usuario nuevo
    //recibe todos los datos de este
    //si la alta es exitosa regresa un booleano = true y muestra el codigo del nuevo usuario
    //en otro caso regresa un booleano = false
    @SuppressWarnings("deprecation")
	private boolean realizaAltaUsuario(){
    	String datos[] = new String[13];
		datos[0] = codigo;
		datos[1] = txtNombre.getText();
		datos[2] = txtApellidoPaterno.getText();
		datos[3] = txtApellidoMaterno.getText();
		datos[4] = txtCalle.getText();
		datos[5] = txtNumeroExterior.getText();
		datos[6] = txtNumeroInterior.getText();
		datos[7] = txtColonia.getText();
		datos[8] = txtMunicipio.getText();
		datos[9] = txtCodigoPostal.getText();
		datos[10] = txtTelefono.getText();
		datos[11] = seleccionar+"";
		datos[12] = password.getText();
		int resp = servicioAltaUsuario.guardaUsuario(datos);
		if(resp == 1){
			JOptionPane.showMessageDialog(ventana,datos[1]+" "+datos[2]+" "+datos[3]+"\nSu código es: "+ codigo,"Alta exitosa",JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		else{
			if(resp == 0){
			JOptionPane.showMessageDialog(ventana,"No se pudo dar de alta, el usuario ya existe","Error",JOptionPane.WARNING_MESSAGE);
			return false;
			}
			else{
				JOptionPane.showMessageDialog(ventana,"No se pudo dar de alta, error en la base de datos","Error",JOptionPane.WARNING_MESSAGE);
				return true;
			}
		}
    }
}
