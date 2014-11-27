package ayd.managment.store.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ayd.managment.store.modelo.Gasto;
import ayd.managment.store.servicio.Interface.ServicioRegistroGastos;

public class VentanaRegistroGastos extends VentanaGenerica{
	
	private java.util.Calendar calendario;
	private int dia, mes, anio;

    //Variables de la clase
    private ServicioRegistroGastos servicioRegistroGastos;
    //Botones de la clase
    private JButton btnRegistro = new JButton("Registra");
    //Etiquetas
    private JLabel lblNombre = new JLabel("Nombre:");
    private JLabel lblFecha = new JLabel("Fecha:");
    private JLabel lblDescripcion = new JLabel("Descripción:");
    private JLabel lblAbono = new JLabel("Abono: $");
    private JLabel label1 = new JLabel();
    private JLabel label2 = new JLabel();
   
    
    //Campos de texto
    private JTextField txtNombre = new JTextField("");
    private JTextField txtFecha = new JTextField("");
    private JTextField txtDescripcion = new JTextField("");
    private JTextField txtAbono = new JTextField("");

    
    private int tecla;
    private int limite = 10;
    private int seleccionar;
    
    private String codigo;
    
    public VentanaRegistroGastos (ServicioRegistroGastos control){
        super("Registrar Gastos","Regresar a ventana \"Registros\"");
        servicioRegistroGastos = control;
        fecha();
        //Asigna formato a los componentes de la ventana
        colocaFormato();
        //Inserta los elementos a los paneles
        InsertaEnPanel();
        panel3.add(btnRegistro, BorderLayout.WEST);
        //Omite caracteres invalidos
        txtNombre.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                validaCadenaConEspacio(txtNombre.getText(), e);
            }
        });
        
        //Omite caracteres invalidos
        txtFecha.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                validaCadenaConEspacio(txtFecha.getText(), e);
            }
        });
        
        //Omite caracteres invalidos
        txtDescripcion.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                validaCadenaConEspacio(txtDescripcion.getText(), e);
            }
        });
        
        //Omite caracteres invalidos
        txtAbono.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                validaReal(txtAbono.getText(), e);
            }
        });
        
       
        
        //Alta de Usuario
        btnRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	Gasto ogasto= new Gasto(txtNombre.getText(),generarFecha(),txtDescripcion.getText(),Float.parseFloat(txtAbono.getText()));
            	
            	if(servicioRegistroGastos.agregaGasto(ogasto)){
            		JOptionPane.showMessageDialog(ventana, "se pudo dar de alta el gasto");
            		limpiaCampos();
            		ventana.dispose();
            	}else{
            		JOptionPane.showMessageDialog(ventana, "ya existe el registro");
            	}
            }
        });

        //boton salir o cancelar
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

            }
        });
    }
    
    //asigna formato a los componentes de la ventana
    private void colocaFormato(){
    	//Botones
    	btnRegistro.setFont(new Font("Dialog", Font.BOLD, 30));
    	
    	//Etiquetas
        lblNombre.setFont(new Font("Dialog", Font.BOLD, 28));
        lblFecha.setFont(new Font("Dialog", Font.BOLD, 28));
        lblDescripcion.setFont(new Font("Dialog", Font.BOLD, 28));
        lblAbono.setFont(new Font("Dialog", Font.BOLD, 28));
        label1.setFont(new Font("Dialog", Font.BOLD, 28));
        label2.setFont(new Font("Dialog", Font.BOLD, 28));
  
        
        //Campos de texto
        txtNombre.setFont(new Font("Dialog", Font.BOLD, 28));
        txtFecha.setFont(new Font("Dialog", Font.BOLD, 28));
        txtDescripcion.setFont(new Font("Dialog", Font.BOLD, 28));
        txtAbono.setFont(new Font("Dialog", Font.BOLD, 28));
       
    }        

    //deja la ventana limpia
    private void limpiaCampos(){
        txtNombre.setText("");
        txtFecha.setText("");
        txtDescripcion.setText("");
        txtAbono.setText("");

    }
       
    //inserta los componentes en la ventana
    private void InsertaEnPanel(){
    	panel2.setLayout( new GridLayout(0, 2, 0, 0));//Aqui 
        panel2.add(lblNombre);
        panel2.add(txtNombre);
        panel2.add(lblFecha);
        panel2.add(txtFecha);
        panel2.add(lblDescripcion);
        panel2.add(txtDescripcion);
        panel2.add(lblAbono);
        panel2.add(txtAbono);
        panel2.add(label1);
        panel2.add(label2);

        

    }
        
    
    //Omite caracteres invalidos
    private void  validaCadenaConEspacio(String anterior, KeyEvent e){
    	tecla = (int) e.getKeyChar();
    	if(tecla >= 33 && tecla <= 96 || tecla >= 123 && tecla <= 255)
    		e.consume();
    }
        
    //Omite caracteres invalidos
    private void  validaReal(String anterior, KeyEvent e){
    	tecla = (int) e.getKeyChar();
    	if(tecla >= 32 && tecla <= 45|| tecla ==47 || tecla >= 58 && tecla <= 255)
    		e.consume();
    }
    
    //Verifica que todos los campos obligatorios esten llenos    
    @SuppressWarnings("deprecation")
	private boolean validaCampos() {
    	String nombre = txtNombre.getText();
    	String fecha = txtFecha.getText();
    	String descripcion = txtDescripcion.getText();
    	String abono = txtAbono.getText();	  
    	if(nombre.isEmpty() || fecha.isEmpty() || descripcion.isEmpty() || abono.isEmpty()  ){
    		JOptionPane.showMessageDialog(ventana,"Hay uno o más campos obligatorios vacios.","Error",JOptionPane.WARNING_MESSAGE);
    		return false;
        }
    	else 
    		return true;
    }
    
	private String generarFecha(){
		//funcion para obtener l fecha del sistema
		Date fecha = new Date();
		String Date;
		Date = String.format("%04d-%02d-%02d",fecha.getYear()+1900,fecha.getMonth()+1,fecha.getDate()); 
		return Date;
	}
	
	private void fecha(){
		calendario = new java.util.GregorianCalendar();
			javax.swing.Timer timer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
			@ Override
			public void actionPerformed(java.awt.event.ActionEvent ae) {
				java.util.Date actual = new java.util.Date();
				calendario.setTime(actual);
				dia = calendario.get(Calendar.DAY_OF_MONTH);
				mes = calendario.get(Calendar.MONTH);
				anio = calendario.get(Calendar.YEAR);
				String hour = String.format(""+"%02d-%02d-%02d",dia,mes+1,anio);
				txtFecha.setText(hour);
			}
		});
		timer.start();
	}
        
 
	private boolean realizaRegistro(){
    	return true;
    }

}
