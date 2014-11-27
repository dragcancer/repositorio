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
import javax.swing.JTextField;

import ayd.managment.store.servicio.Interface.ServicioAltaProducto;

// Hereda de VentanaGenerica
public class VentanaAltaProducto extends VentanaGenerica{
	// Variables de la clase
	private ServicioAltaProducto servicioAltaProducto;
	// Botones de la clase
	private JButton btnAlta = new JButton("Dar de alta");
	// Etiquetas
	private JLabel lblNombre = new JLabel("Nombre:");
	private JLabel lblCodigo = new JLabel("Código:");
	private JLabel lblPrecioCompra = new JLabel("Precio compra:");
	private JLabel lblPrecioMenudeo = new JLabel("Precio menudeo:");
	private JLabel lblPrecioMayoreo = new JLabel("Precio mayoreo:");
	private JLabel lblCantidadMayoreo = new JLabel("Cantidad mayoreo:");
	private JLabel lblProveedor = new JLabel("Proveedor:");
	private JLabel lblExistenciaActual = new JLabel("Existencia actual:");
	private JLabel lblExistenciaMinima = new JLabel("Existencia mínima:");
	private JLabel lblExistenciaMaxima = new JLabel("Existencia máxima:");
	private JLabel lblTipo = new JLabel("Tipo:");
	// Campos de texto
	private JTextField txtCodigo = new JTextField("");
	private JTextField txtNombre = new JTextField("");
	private JTextField txtPrecioCompra = new JTextField("");
	private JTextField txtPrecioMenudeo = new JTextField("");
	private JTextField txtPrecioMayoreo = new JTextField("");
	private JTextField txtCantidadMayoreo = new JTextField("");
	private JTextField txtProveedor = new JTextField("");
	private JTextField txtExistenciaActual = new JTextField("");
	private JTextField txtExistenciaMinima = new JTextField("");
	private JTextField txtExistenciaMaxima = new JTextField("");
	// ComboBox
	private JComboBox<String> cbxTipo = new JComboBox<String>(new javax.swing.DefaultComboBoxModel<String>(new String[] {"A granel","Pieza"}));
	// Variables de la clase
	private int tecla;
	private int punto = 0;
	private int limite = 0;
	private int seleccionar;
	
	public VentanaAltaProducto(ServicioAltaProducto control){
		super("Alta de producto","Regresar a ventana \"Productos\"");
		servicioAltaProducto = control;
	
		// Asigna formato a los componentes de la ventana
		colocaFormato();
		// Inserta los elementos a los paneles
		InsertaEnPanel();
		
		// Valida que los datos ingresados sean numericos solamente
		txtCodigo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				validaEntero(txtCodigo.getText(), e);
			}
		});
		
		// Valida que los datos ingresados sean letras minusculas o numeros
		txtNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				validaCadenayEntero(txtNombre.getText(), e);
			}
		});
		
		// Valida que sea flotante
		txtPrecioCompra.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				validaFlotante(txtPrecioCompra.getText(), e);
				//Calcula precios menudeo/mayoreo a partir del precio de compra
				asignaPrecios();
			}
		});
		
		// Omite caracteres invalidos
		txtCantidadMayoreo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				validaFlotante(txtCantidadMayoreo.getText(), e);
			}
		});
		
		// Omite caracteres invalidos
		txtProveedor.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				validaCadenaConEspacio(txtProveedor.getText(), e);
			}
		});
		
		// Omite caracteres invalidos
		txtExistenciaActual.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				validaFlotante(txtExistenciaActual.getText(), e);
			}
		});
		
		// Omite caracteres invalidos
		txtExistenciaMinima.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				validaFlotante(txtExistenciaMinima.getText(), e);
			}
		});
		
		// Omite caracteres invalidos
		txtExistenciaMaxima.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				validaFlotante(txtExistenciaMaxima.getText(), e);
			}
		});
		
		// Selecciona el tipo de producto
		cbxTipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	seleccionar = cbxTipo.getSelectedIndex();                    
            }
        });
		
		// Accion del boton Alta
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				darDeAlta();
			}
		});
		
		// Accion del boton Salir
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiaCampos();
			}
		});
	}
	
	// Asigna formato a los componentes de la ventana
	private void colocaFormato(){
		btnAlta.setFont(new Font("Dialog", Font.BOLD, 30));
		lblCodigo.setFont(new Font("Dialog", Font.BOLD, 28));
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPrecioCompra.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPrecioMenudeo.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPrecioMayoreo.setFont(new Font("Dialog", Font.BOLD, 28));
		lblCantidadMayoreo.setFont(new Font("Dialog", Font.BOLD, 28));
		lblProveedor.setFont(new Font("Dialog", Font.BOLD, 28));
		lblExistenciaActual.setFont(new Font("Dialog", Font.BOLD, 28));
		lblExistenciaMinima.setFont(new Font("Dialog", Font.BOLD, 28));
		lblExistenciaMaxima.setFont(new Font("Dialog", Font.BOLD, 28));
		lblTipo.setFont(new Font("Dialog", Font.BOLD, 28));
		txtCodigo.setFont(new Font("Dialog", Font.BOLD, 28));
		txtNombre.setFont(new Font("Dialog", Font.BOLD, 28));
		txtPrecioCompra.setFont(new Font("Dialog", Font.BOLD, 28));
		txtPrecioMenudeo.setFont(new Font("Dialog", Font.BOLD, 28));	
		txtPrecioMayoreo.setFont(new Font("Dialog", Font.BOLD, 28));
		txtCantidadMayoreo.setFont(new Font("Dialog", Font.BOLD, 28));
		txtProveedor.setFont(new Font("Dialog", Font.BOLD, 28));
		txtExistenciaActual.setFont(new Font("Dialog", Font.BOLD, 28));
		txtExistenciaMinima.setFont(new Font("Dialog", Font.BOLD, 28));
		txtExistenciaMaxima.setFont(new Font("Dialog", Font.BOLD, 28));
		cbxTipo.setFont(new Font("Dialog", Font.BOLD, 28));
	}

	// Vacia campos
	private void limpiaCampos(){
		txtCodigo.setText("");
		txtNombre.setText("");	
		txtPrecioCompra.setText("");	
		txtPrecioMenudeo.setText("");
		txtPrecioMayoreo.setText("");	
		txtCantidadMayoreo.setText("");	
		txtProveedor.setText("");
		txtExistenciaActual.setText("");
		txtExistenciaMinima.setText("");
		txtExistenciaMaxima.setText("");
	}
	
	// Inserta los componentes en la ventana
	private void InsertaEnPanel(){
		panel2.setLayout(new GridLayout(0, 2, 20, 10));
		panel2.add(lblCodigo);
		panel2.add(txtCodigo);	
		panel2.add(lblNombre);
		panel2.add(txtNombre);
		panel2.add(lblPrecioCompra);
		panel2.add(txtPrecioCompra);
		panel2.add(lblPrecioMenudeo);
		panel2.add(txtPrecioMenudeo);
		panel2.add(lblPrecioMayoreo);
		panel2.add(txtPrecioMayoreo);
		panel2.add(lblCantidadMayoreo);
		panel2.add(txtCantidadMayoreo);
		panel2.add(lblProveedor);
		panel2.add(txtProveedor);
		panel2.add(lblExistenciaActual);
		panel2.add(txtExistenciaActual);
		panel2.add(lblExistenciaMinima);
		panel2.add(txtExistenciaMinima);
		panel2.add(lblExistenciaMaxima);
		panel2.add(txtExistenciaMaxima);
		panel2.add(lblTipo);
		panel2.add(cbxTipo);
		panel3.add(btnAlta, BorderLayout.WEST);
	}
	
	//Omite caracteres invalidos
	private void  validaCadenayEntero(String anterior, KeyEvent e){
		tecla = (int) e.getKeyChar();
		if(tecla >= 33 && tecla <= 45 || tecla == 47 || tecla >= 58 && tecla <= 96 || tecla >= 123 && tecla <= 255)
	    	e.consume();
	}
	
	//Omite caracteres invalidos
	private void  validaCadenaConEspacio(String anterior, KeyEvent e){
		tecla = (int) e.getKeyChar();
		if(tecla >= 33 && tecla <= 96 || tecla >= 123 && tecla <= 255)
	    	e.consume();
	}
	
	//Omite caracteres invalidos
	private void  validaFlotante(String anterior, KeyEvent e){
		tecla = (int) e.getKeyChar();
		if(!anterior.contains(".")){
	          punto = 0;
	          limite = 0;
		}
		else
			limite++;
	    if(tecla == 46){
	    	punto++;
	        if(punto>1)
	        	e.consume();
	    }
	    if(tecla >= 32 && tecla <= 45 || tecla == 47 || tecla >= 58 && tecla <= 255 || limite > 2)
	    	e.consume();
	}
	
	private void  validaEntero(String anterior, KeyEvent e){
		tecla = (int) e.getKeyChar();
		if(tecla >= 32 && tecla <= 47 || tecla >= 58 && tecla <= 255)
			e.consume();
	}
	
	//calcula el precio de menudeo/mayoreo a partir del precio de compra
	//efectua los redondeos especificados en las reglas de negocio
	private void asignaPrecios(){
		float precio=0,precioMenudeo,precioMayoreo;
		int pMenudeo,pMayoreo;
		try{
			precio = Float.parseFloat(txtPrecioCompra.getText());		
			precioMenudeo = (float) (precio*1.2);
			precioMayoreo = (float) (precio*1.1);
			pMenudeo = (int) precioMenudeo;
			pMayoreo = (int) precioMayoreo;
			//Realiza el redondeo para cada caso especificado en las reglas de negocio
			if(precioMenudeo-pMenudeo < 0.25)
				precioMenudeo = (float) (pMenudeo);
			else{
				if(precioMenudeo-pMenudeo >= 0.25 && precioMenudeo-pMenudeo < 0.75)
					precioMenudeo = (float) (pMenudeo+0.5);
				else
					if(precioMenudeo-pMenudeo >= 0.75 && precioMenudeo-pMenudeo < 1)
						precioMenudeo = (float) (pMenudeo+1);	
			}
			txtPrecioMenudeo.setText((precioMenudeo)+"");
			
			if(precioMayoreo-pMayoreo < 0.25)
				precioMayoreo = (float) (pMayoreo);
			else{
				if(precioMayoreo-pMayoreo >= 0.25 && precioMayoreo-pMayoreo < 0.75)
					precioMenudeo = (float) (pMenudeo+0.5);
				else
					if(precioMayoreo-pMayoreo >= 0.75 && precioMayoreo-pMayoreo < 1)
						precioMayoreo = (float) (pMayoreo+1);	
			}
			txtPrecioMayoreo.setText((precioMayoreo)+"");
		}catch(NumberFormatException ex){
		}
	}
	
	private String[] mandaDatos(){
		String datos[] = new String[11];
		datos[0] = txtCodigo.getText();
		datos[1] = txtNombre.getText();
		datos[2] = txtPrecioCompra.getText();
		datos[3] = txtPrecioMenudeo.getText();
		datos[4] = txtPrecioMayoreo.getText();
		datos[5] = txtCantidadMayoreo.getText();
		datos[6] = txtProveedor.getText();
		datos[7] = txtExistenciaActual.getText();
		datos[8] = txtExistenciaMinima.getText();
		datos[9] = txtExistenciaMaxima.getText();
		datos[10] = seleccionar+"";
		return datos;
	}
	
	//valida que todos los campos esten con datos
	private boolean camposLlenos(){
		if(txtCodigo.getText().isEmpty() || txtNombre.getText().isEmpty() || txtPrecioCompra.getText().isEmpty() || txtPrecioMenudeo.getText().isEmpty() || txtPrecioMayoreo.getText().isEmpty() || txtCantidadMayoreo.getText().isEmpty() || txtProveedor.getText().isEmpty() || txtExistenciaActual.getText().isEmpty() || txtExistenciaMinima.getText().isEmpty() || txtExistenciaMaxima.getText().isEmpty())
			return false;
		else
			return true;
	}
	
	private void darDeAlta(){
		//Valida si hay campos vacios
		if(camposLlenos())
			//Valida que los datos cumplan las reglas de negocio
			if(servicioAltaProducto.validarValores(mandaDatos())){
				//Verifica que el c󤩧o no pertenezca a otro producto
				if(servicioAltaProducto.codigoRepetido(txtCodigo.getText())==false)
					// Si el c󤩧o no pertenece a otro producto entonces manda a llamar al m굯do para dar de alta
					if(servicioAltaProducto.darDeAltaProducto()){
						// Mensaje de exito al dar de alta
						JOptionPane.showMessageDialog(ventana,"Producto dado de alta exitosamente.");
						limpiaCampos();
						ventana.dispose();
					}
					//los datos del producto no pasaron alguna validacion
					else
						//error al dar de alta
						JOptionPane.showMessageDialog(ventana,"No se pudo dar de alta al producto.","Error",JOptionPane.ERROR_MESSAGE);	
				else
					// error de c󤩧o repetido
					JOptionPane.showMessageDialog(ventana,"El código ya fue ingresado anteriormente.","Error",JOptionPane.ERROR_MESSAGE);	
			}	
			else
				//error de datos invalidos
				JOptionPane.showMessageDialog(ventana,"Los nuevos datos no son validos.","Error",JOptionPane.ERROR_MESSAGE);	
		else
			//error por campos vacios
			JOptionPane.showMessageDialog(ventana,"Hay campos vacios.","Error",JOptionPane.ERROR_MESSAGE);
	}	
}
