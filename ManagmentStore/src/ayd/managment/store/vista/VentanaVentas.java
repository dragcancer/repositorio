package ayd.managment.store.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import ayd.managment.store.servicio.Interface.ServicioVentas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//HEREDADO DE VentanaGenerica
public class VentanaVentas extends VentanaGenerica{
	private static final long serialVersionUID = 1L;
	//VARIABLES DE LA CLASE
	private ServicioVentas servicioVentas;
	//BOTONOS DE LA CLASE
	private JButton btnAgregar = new JButton("Agregar");
	private JButton btnEliminar = new JButton("Eliminar");
	private JButton btnConfirmarVenta = new JButton("Confirmar venta");
	private JButton btnImprimirTicket = new JButton("Imprimir Ticket");
	private JButton btnCancelar = new JButton("Cancelar");
	//Etiquetas
	private JLabel lblBusquedaNombre = new JLabel("Ingrese el nombre del producto:");
	private JLabel lblBusquedaCodigo = new JLabel("Ingrese el código del producto:");
	private JLabel lblTotal = new JLabel("Total: $");
	private JLabel label = new JLabel();
	//Campos de texto
	private JTextField txtBusquedaNombre = new JTextField("");
	private JTextField txtBusquedaCodigo = new JTextField("");
	private JTextField txtTotal = new JTextField("");
	//Modelos de tablas
	private DefaultTableModel modeloNombre = new DefaultTableModel(){
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int rowIndex,int columnIndex){return false;} 
		}; 
	private DefaultTableModel modeloVenta = new DefaultTableModel(){
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int rowIndex,int columnIndex){if (columnIndex==4) return true; 
		else 
			return false;} 
		}; 
	//Tablas	
	private JTable tblProductosNombre = new JTable(modeloNombre);
	private JTable tblProductosVenta = new JTable(modeloVenta);
	private TableColumn columnaNombre = new TableColumn();
	private TableColumn columnaVenta = new TableColumn();
	private TableColumn columnaVenta1 = new TableColumn();
	private TableColumn columnaVenta2 = new TableColumn();
	private TableColumn columnaVenta3 = new TableColumn();
	private TableColumn columnaVenta4 = new TableColumn();
	//Scrolls
	private JScrollPane scrollProductosNombre = new JScrollPane(tblProductosNombre);
	private JScrollPane scrollProductosVenta = new JScrollPane(tblProductosVenta);
	//Paneles
	private JPanel panel21 = new JPanel();
	private JPanel panel22 = new JPanel();
	private JPanel panel23 = new JPanel();
	private JPanel panel31 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel5 = new JPanel();
	//Variables de la clase
	private int tecla;
	private int indice;
	private int indice2;
	private int indice3;
	private float preciom, precioM, cantidadM, cantidadV;
	private String nombre;
	private String pMenudeo;
	private String pMayoreo;
	private String cMayoreo;
	private String cVenta;
	private String datosC[] = new String[6];
	private ArrayList<String[]> datosL = new ArrayList<String[]>();
	
	public VentanaVentas(ServicioVentas control){
		super("Ventas","Regresar a ventana \"Principal\"");
		servicioVentas = control;
		colocaFormato();
		ordenaElementos();
		deshabilitaCampos();
		
		//activa el boton agregar si se selecciona un producto mostrado en la tabla
		tblProductosNombre.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				btnAgregar.setEnabled(true);
			}
		});
		
		//activa el boton eliminar si se selecciona un producto mostrado en la tabla
		tblProductosVenta.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				btnEliminar.setEnabled(true);
			}
		});
		
		//realiza una venta y calcula su precio solo si la tabla tiene al menos un producto para vender
		tblProductosVenta.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(tblProductosVenta.getRowCount() > 0)
					realizaVenta();
				if(tblProductosVenta.getSelectedRow() >= 0)
					calculaPrecio();
			}
		});
		
		//omite caracteres invalidos
		//realiza una busqueda con el nombre de un producto para su venta
		txtBusquedaNombre.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				validaCadenayEntero(txtBusquedaNombre.getText(), e);
				if(!txtBusquedaNombre.getText().isEmpty()){
					while(modeloNombre.getRowCount()>0)
						modeloNombre.removeRow(0);
					buscarNombre();	
					btnCancelar.setEnabled(true);
				}	
			}
		});
		
		//omite caracteres invalidos
		//realiza una busqueda con el codigo de un producto para su venta
		txtBusquedaCodigo.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				validaEntero(txtBusquedaCodigo.getText(), e);
				if(!txtBusquedaCodigo.getText().isEmpty())
					buscarCodigo();
				btnCancelar.setEnabled(true);
			}
		});
		
		//agrega un producto mostrado en busqueda a la venta y realiza los calculos correspondientes
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambiaTabla();
				realizaVenta();
			}
		});
		
		//elimina un producto de una posible venta
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=tblProductosVenta.getSelectedRow();
				if(i>=0){
					modeloVenta.removeRow(tblProductosVenta.getSelectedRow());
					realizaVenta();
				}
				if(tblProductosVenta.getRowCount() == 0){
					btnConfirmarVenta.setEnabled(false);
					realizaVenta();
				}
				btnEliminar.setEnabled(false);
			}
		});
		
		//una vez realizada una venta confirma una venta
		btnConfirmarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmaVenta();
			}
		});
		
		btnImprimirTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confiTicket();
			}
		});
		
		//cancela una posible venta, deja limpia la pantalla
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiaCampos();
			}
		});
		
		//boton salir, deja limpia la pantalla
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiaCampos();
			}
		});
	}
	
	//coloca el formato a la ventana
	private void colocaFormato(){
		btnAgregar.setFont(new Font("Dialog", Font.BOLD, 30));
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 30));
		btnConfirmarVenta.setFont(new Font("Dialog", Font.BOLD, 30));
		btnImprimirTicket.setFont(new Font("Dialog", Font.BOLD, 30));
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 30));
		panel21.setBackground(UIManager.getColor("Button.focus"));
		panel22.setBackground(UIManager.getColor("Button.focus"));
		panel23.setBackground(UIManager.getColor("Button.focus"));
		panel31.setBackground(UIManager.getColor("Button.focus"));
		panel4.setBackground(UIManager.getColor("Button.focus"));
		panel5.setBackground(UIManager.getColor("Button.focus"));
		tblProductosNombre.setFont(new Font("Dialog", Font.BOLD, 28));
		tblProductosVenta.setFont(new Font("Dialog", Font.BOLD, 28));
		lblBusquedaNombre.setFont(new Font("Dialog", Font.BOLD, 28));
		lblBusquedaCodigo.setFont(new Font("Dialog", Font.BOLD, 28));
		lblTotal.setFont(new Font("Dialog", Font.BOLD, 34));
		label.setFont(new Font("Dialog", Font.BOLD, 34));
		txtBusquedaNombre.setFont(new Font("Dialog", Font.BOLD, 28));
		txtBusquedaCodigo.setFont(new Font("Dialog", Font.BOLD, 28));
		txtTotal.setFont(new Font("Dialog", Font.BOLD, 34));
		tblProductosNombre.setRowHeight(30);
		tblProductosVenta.setRowHeight(30);
		modeloNombre.addColumn("Producto");
		modeloNombre.addColumn("Precio");
		modeloNombre.addColumn("Disponible");
		modeloVenta.addColumn("Producto");
		modeloVenta.addColumn("Precio menudeo");
		modeloVenta.addColumn("Precio mayoreo");
		modeloVenta.addColumn("Cantidad mayoreo");
		modeloVenta.addColumn("Cantidad venta");
		modeloVenta.addColumn("Total");
		columnaNombre = tblProductosNombre.getColumn("Producto");
		columnaVenta = tblProductosVenta.getColumn("Producto");
		columnaVenta1 = tblProductosVenta.getColumn("Precio menudeo");
		columnaVenta2 = tblProductosVenta.getColumn("Precio mayoreo");
		columnaVenta3 = tblProductosVenta.getColumn("Cantidad mayoreo");
		columnaVenta4 = tblProductosVenta.getColumn("Cantidad venta");
		columnaNombre.setPreferredWidth(900);
		columnaVenta.setPreferredWidth(600);
		columnaVenta1.setPreferredWidth(30);
		columnaVenta2.setPreferredWidth(30);
		columnaVenta3.setPreferredWidth(30);
		columnaVenta4.setPreferredWidth(60);
	}
	
	//ordena todos los elementos en la ventana
	public void ordenaElementos(){
		panel2.setLayout(new BorderLayout(0, 20));
		panel2.add(panel21, BorderLayout.NORTH);
		panel2.add(panel22, BorderLayout.CENTER);
		panel2.add(panel23, BorderLayout.SOUTH);
		panel21.setLayout(new GridLayout(1, 2, 0, 0));
		panel21.add(lblBusquedaNombre);
		panel21.add(txtBusquedaNombre);	
		panel22.setLayout(new GridLayout(0, 1, 0, 0));
		panel22.add(panel31);	
		panel23.setLayout(new GridLayout(1, 4, 10, 0));
		panel23.add(btnConfirmarVenta);
		panel23.add(btnImprimirTicket);
		panel23.add(label);
		panel23.add(lblTotal);
		panel23.add(txtTotal);	
		panel31.setLayout(new BorderLayout(0, 5));
		panel31.add(scrollProductosNombre, BorderLayout.CENTER);
		panel31.add(btnAgregar, BorderLayout.EAST);
		panel31.add(panel4, BorderLayout.SOUTH);
		panel4.setLayout(new BorderLayout(0, 5));
		panel4.add(panel5, BorderLayout.NORTH);
		panel4.add(scrollProductosVenta, BorderLayout.CENTER);	
		panel4.add(btnEliminar, BorderLayout.EAST);
		panel5.setLayout(new GridLayout(1, 2, 0, 0));
		panel5.add(lblBusquedaCodigo);
		panel5.add(txtBusquedaCodigo);
		panel3.add(btnCancelar, BorderLayout.WEST);
	}
	
	//deshabilita campos que no se deben editar, especificado en reglas de negocio	
	private void deshabilitaCampos(){
		btnAgregar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnConfirmarVenta.setEnabled(false);
		btnCancelar.setEnabled(false);
		txtTotal.setEditable(false);
		
	}
	
	//deja la ventana limpia
	private void limpiaCampos(){
		while(modeloNombre.getRowCount()>0)
			modeloNombre.removeRow(0);
		while(modeloVenta.getRowCount()>0)
			modeloVenta.removeRow(0);
		btnAgregar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnConfirmarVenta.setEnabled(false);
		btnCancelar.setEnabled(false);
		txtBusquedaCodigo.setText("");
		txtBusquedaNombre.setText("");
		txtTotal.setText("");
	}
	
	//Omite caracteres invalidos
	private void  validaCadenayEntero(String anterior, KeyEvent e){
		tecla = (int) e.getKeyChar();
		if(tecla >= 33 && tecla <= 45 || tecla == 47 || tecla >= 58 && tecla <= 96 || tecla >= 123 && tecla <= 255)
	    	e.consume();
	}
	
	//Omite caracteres invalidos
	private void  validaEntero(String anterior, KeyEvent e){
		tecla = (int) e.getKeyChar();
	    if(tecla >= 32 && tecla <= 47 || tecla >= 58 && tecla <= 255)
	    	e.consume();
	}
	
	//busca un producto por nombre si lo encuentra despliega sus datos
	private void buscarNombre(){
		if(servicioVentas.buscarProductoNombre(txtBusquedaNombre.getText()))
			//Producto encontrado, se imprimen los datos en pantalla
			despliegaDatosNombre();
	}
	
	//busca un producto por codigo si lo encuentra despliega sus datos
	private void buscarCodigo(){
		if(servicioVentas.buscarProductoCodigo(txtBusquedaCodigo.getText())){
			//Producto encontrado, se imprimen los datos en pantalla
			despliegaDatosVenta();
			realizaVenta();
		}
	}
	
	//muestra en pantalla todos los productos que tengan concidencia con el nombre buscado
	private void despliegaDatosNombre(){
		datosL = servicioVentas.mostrarDatosLista();
		for(indice = 0; indice < datosL.size(); indice++){
			if(Float.parseFloat(datosL.get(indice)[4]) > 0.0)
				modeloNombre.addRow(new String [] {datosL.get(indice)[0],datosL.get(indice)[1],"Si"});
			else
				modeloNombre.addRow(new String [] {datosL.get(indice)[0],datosL.get(indice)[1],"No"});
		}
	}
	
	//muestra en pantalla un producto que tenga coincidencia con el codigo buscado
	private void despliegaDatosVenta(){
		datosC = servicioVentas.mostrarDatos();
		boolean band = false;
		
		//busca u producto en la tabla
		//si un nuevo producto a agregar ya esta en la tabla solo lo actualiza
		for(indice = 0; indice < modeloVenta.getRowCount(); indice++){
			if(datosC[0].equals(""+modeloVenta.getValueAt(indice,0))){
				nombre = modeloVenta.getValueAt(indice, 0)+"";
				pMenudeo = modeloVenta.getValueAt(indice,1)+"";
				pMayoreo = modeloVenta.getValueAt(indice,2)+"";
				cMayoreo = modeloVenta.getValueAt(indice,3)+"";
				cVenta = modeloVenta.getValueAt(indice,4)+"";
				try{
					preciom = Float.parseFloat(pMenudeo);
					precioM = Float.parseFloat(pMayoreo);
					cantidadM = Float.parseFloat(cMayoreo);
					cantidadV = Float.parseFloat(cVenta);
				}catch(NumberFormatException ex){
					band = false;
					break;
				}
				cantidadV++;
				modeloVenta.removeRow(indice);
				
				//calcula el precio para cada producto en lista y lo muestra en pantalla
				if(cantidadV < cantidadM)
					modeloVenta.addRow(new String [] {nombre+"",preciom+"",precioM+"",+cantidadM+"",cantidadV+"",(cantidadV*preciom)+""});
				else
					modeloVenta.addRow(new String [] {nombre+"",preciom+"",precioM+"",+cantidadM+"",cantidadV+"",(cantidadV*precioM)+""});
				band = true;	
				break;
			}
		}
		//si la existencia de un producto no cubre la demanda de venta lo elimina de la lista
		if(!band){
			if(Float.parseFloat(datosC[4]) > 0.0)
				modeloVenta.addRow(new String [] {datosC[0],datosC[1],datosC[2],datosC[3],"1",datosC[1]});
			else
				modeloVenta.addRow(new String [] {datosC[0],datosC[1],datosC[2],"No","No disponible"});
		}
		datosC = null;
	}
	
	//agrega un producto que se encuentra en la tabla de busqueda a la tabla de ventas
	//si el producto ya se encuentra en la tabla de ventas solo lo actualiza
	private void cambiaTabla(){
		int aux=0;
		boolean band=false;
		indice=tblProductosNombre.getSelectedRow();
		if(indice >= 0)
			for(indice2 = 0; indice2 < datosL.size(); indice2++)
				if(datosL.get(indice2)[0].equals(modeloNombre.getValueAt(indice, 0))){
					nombre = datosL.get(indice2)[0];
					for(indice3 = 0; indice3 < tblProductosVenta.getRowCount(); indice3++){
						if(nombre.equals(modeloVenta.getValueAt(indice3, 0))){
							band = true;
							aux = indice3;
							break;
						}
					}
					if(!band){
						if("Si".equals(modeloNombre.getValueAt(indice, 2)))
							modeloVenta.addRow(new String [] {nombre, datosL.get(indice2)[1], datosL.get(indice2)[2], datosL.get(indice2)[3], "1.0",datosL.get(indice2)[1]});
						else
							modeloVenta.addRow(new String [] {nombre, datosL.get(indice2)[1], datosL.get(indice2)[2],"No","No Disponible"});
					}
					else{
						nombre = modeloVenta.getValueAt(aux, 0)+"";
						pMenudeo = modeloVenta.getValueAt(aux,1)+"";
						pMayoreo = modeloVenta.getValueAt(aux,2)+"";
						cMayoreo = modeloVenta.getValueAt(aux,3)+"";
						cVenta = modeloVenta.getValueAt(aux,4)+"";
						try{
							preciom = Float.parseFloat(pMenudeo);
							precioM = Float.parseFloat(pMayoreo);
							cantidadM = Float.parseFloat(cMayoreo);
							cantidadV = Float.parseFloat(cVenta);
							cantidadV++;
							modeloVenta.removeRow(aux);
							if(cantidadV < cantidadM)
								modeloVenta.addRow(new String [] {nombre+"",preciom+"",precioM+"",+cantidadM+"",cantidadV+"",(cantidadV*preciom)+""});
							else
								modeloVenta.addRow(new String [] {nombre+"",preciom+"",precioM+"",+cantidadM+"",cantidadV+"",(cantidadV*precioM)+""});
						}catch(NumberFormatException ex){
						}
					}
					modeloNombre.removeRow(indice);
					break;
				}
		while(modeloNombre.getRowCount()>0)
			modeloNombre.removeRow(0);
		btnAgregar.setEnabled(false);
	}
	
	//calcula el precio de un producto para su venta, a partir de los precios de venta (segun sea el caso)
	//y la cantidad solocitada
	private void calculaPrecio(){
		indice = tblProductosVenta.getSelectedRow();
		nombre = modeloVenta.getValueAt(indice, 0)+"";
		pMenudeo = modeloVenta.getValueAt(indice,1)+"";
		pMayoreo = modeloVenta.getValueAt(indice,2)+"";
		cMayoreo = modeloVenta.getValueAt(indice,3)+"";
		cVenta = modeloVenta.getValueAt(indice,4)+"";
		indice3 = 0;
		try{
			preciom = Float.parseFloat(pMenudeo);
			precioM = Float.parseFloat(pMayoreo);
			cantidadM = Float.parseFloat(cMayoreo);
			cantidadV = Float.parseFloat(cVenta);
			modeloVenta.removeRow(indice);
			if(cantidadV < cantidadM)
				modeloVenta.addRow(new String [] {nombre+"",preciom+"",precioM+"",+cantidadM+"",cantidadV+"",(cantidadV*preciom)+""});
			else
				modeloVenta.addRow(new String [] {nombre+"",preciom+"",precioM+"",+cantidadM+"",cantidadV+"",(cantidadV*precioM)+""});
		}catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(ventana,"Cantidad no valida para el producto:\n"+nombre,"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//realiza la venta temporal de los productos, aun se pueden hacer cambios en la venta en este momento
	//verifica que se tenga la existencia para cubrir la venta de los productos
	private void realizaVenta(){
		ArrayList<String[]> productosVenta = new ArrayList<String[]>();
		for(indice = 0; indice < tblProductosVenta.getRowCount(); indice++){
			String p[] = new String[6];
			p[0] = modeloVenta.getValueAt(indice, 0)+"";
			p[1] = modeloVenta.getValueAt(indice, 1)+"";
			p[2] = modeloVenta.getValueAt(indice, 2)+"";
			p[3] = modeloVenta.getValueAt(indice, 3)+"";
			p[4] = modeloVenta.getValueAt(indice, 4)+"";
			p[5] = modeloVenta.getValueAt(indice, 5)+"";
			productosVenta.add(indice, p);
		}
		int resp = servicioVentas.realizarVenta(productosVenta);
		if (resp == -1){
			txtTotal.setText(servicioVentas.muestraTotal()+"");
			btnConfirmarVenta.setEnabled(true);
		}
		else{
			JOptionPane.showMessageDialog(ventana,"No se tiene la cantidad suficiente de:\n"+productosVenta.get(resp)[0]+"\npara realizar la venta.","Error",JOptionPane.ERROR_MESSAGE);
			modeloVenta.removeRow(resp);
		}
	}
	
	//realiza la venta de forma permanente, es decir la guarda
	//esta accion no se puede revertir
	private void confirmaVenta(){
		if(servicioVentas.guardarVenta()){
			JOptionPane.showMessageDialog(ventana,"Venta realizada con exito.");
			limpiaCampos();
		}
		else
			JOptionPane.showMessageDialog(ventana,"No se pudo confirmar la venta.","Error",JOptionPane.ERROR_MESSAGE);
	}
	
	private void confiTicket(){
		if(servicioVentas.guardarVentaPDF()){
			JOptionPane.showMessageDialog(ventana,"Guardado Con Exito.");
			limpiaCampos();
		}
		else
			JOptionPane.showMessageDialog(ventana,"No Se Puedo Guardar El Archivo.","Error",JOptionPane.ERROR_MESSAGE);
	}
}
