package ayd.managment.store.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ayd.managment.store.modelo.Proveedor;
import ayd.managment.store.servicio.Interface.ServicioAltaProveedor;

public class VentanaAltaProveedor  extends VentanaGenerica{
	private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private ServicioAltaProveedor servicioAltaProveedor;
    private JButton btnAlta = new JButton("Dar de Alta");
    private JLabel lblNombre = new JLabel("Nombre:");
    private JLabel lblTelefono = new JLabel("Teléfono (a 10 digitos):");
    private JLabel lblTipo = new JLabel("Tipo:");
    private JLabel asistente = new JLabel("");
       
    //Campos de texto
    private JTextField txtNombre = new JTextField("");
    private JTextField txtTelefono = new JTextField("");
    private JTextField txtTipo = new JTextField("");
    
    private int tecla;
    private int limite = 10;
    @SuppressWarnings("unused")
	private int seleccionar;
    @SuppressWarnings("unused")
	private String codigo;
    
    public VentanaAltaProveedor(ServicioAltaProveedor control){
    	  super("Alta de Proveedor","Regresar a ventana \"Proveedores\"");
          servicioAltaProveedor = control;
          //Asigna formato a los componentes de la ventana
          colocaFormato();
          //Inserta los elementos a los paneles
          InsertaEnPanel();
          panel3.add(btnAlta, BorderLayout.WEST);
          
          //Omite caracteres invalidos
          
          txtTelefono.addKeyListener(new KeyAdapter() {
              public void keyTyped(KeyEvent e) {
                  validaEntero(txtTelefono.getText(), e);
              }
          });
          
          txtNombre.addKeyListener(new KeyAdapter() {
              public void keyTyped(KeyEvent e) {
                  validaCadenaConEspacio(txtNombre.getText(), e);
              }
          });
          
                    
          //Alta de Usuario
          btnAlta.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent arg0) {
            	btnAlta.setEnabled(false);
              	if(validaCampos()){
              		if(validaTelefono(txtTelefono.getText())){
              			Proveedor prov=new Proveedor(txtNombre.getText(), txtTelefono.getText(), txtTipo.getText());
              			if(servicioAltaProveedor.agregarProveedor(prov)){ 	
              				JOptionPane.showMessageDialog(ventana, "ALTA CON EXITO");
              				btnAlta.setEnabled(true);
              				txtNombre.setText("");
              				txtTelefono.setText("");
              				txtTipo.setText("");
              				ventana.dispose();
              			}else{
                  			JOptionPane.showMessageDialog(ventana, "NO SE PUDO DAR DE ALTA");
                  			btnAlta.setEnabled(true);
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
        lblTelefono.setFont(new Font("Dialog", Font.BOLD, 28));
        lblTipo.setFont(new Font("Dialog", Font.BOLD, 28));
        asistente.setFont(new Font("Dialog", Font.BOLD, 488));
        
        //Campos de texto
        txtNombre.setFont(new Font("Dialog", Font.BOLD, 28));
        txtTelefono.setFont(new Font("Dialog", Font.BOLD, 28));
        txtTipo.setFont(new Font("Dialog", Font.BOLD, 28));
    }        

    //deja la ventana limpia
    private void limpiaCampos(){
        txtNombre.setText("");
        txtTelefono.setText("");
        txtTipo.setText("");
    }
       
    //inserta los componentes en la ventana
    private void InsertaEnPanel(){
    	panel2.setLayout( new GridLayout(0, 2, 0, 0));//Aqui 
        panel2.add(lblNombre);
        panel2.add(txtNombre);
        panel2.add(lblTelefono);
        panel2.add(txtTelefono);
        panel2.add(lblTipo);
        panel2.add(txtTipo);
        panel2.add(asistente);
   }
        
    //validacion de reglas de negocio referentes a telefono
    //el telefono debe tener un tamanio de 10 caracteres
    private boolean validaTelefono(String telefono){
    	if(telefono.length() != limite){
    		JOptionPane.showMessageDialog(ventana,"Tamaño de teléfono incorrecto.","Error",JOptionPane.WARNING_MESSAGE);
    		btnAlta.setEnabled(true);
    		return false;
        }
    	else
    		return true;    
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
    private boolean validaCampos() {
    	String nombre = txtNombre.getText();
    	String telefono = txtTelefono.getText();
		String tipo = txtTipo.getText();
		  
    	if(nombre.isEmpty() || telefono.isEmpty() || tipo.isEmpty()){
    		JOptionPane.showMessageDialog(ventana,"Hay uno o más campos obligatorios vacios.","Error",JOptionPane.WARNING_MESSAGE);
    		return false;
        }
    	else 
    		return true;
    }
}