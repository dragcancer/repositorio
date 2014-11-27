package ayd.managment.store.vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;

import ayd.managment.store.servicio.Interface.ServicioActualizacionPorLotes;

//Heredo de VentanaGenerica
public class VentanaActualizacionPorLotes extends VentanaGenerica{

	//declaracion de atributos JComboBox
	private JComboBox JComboBoxProveedores;
	
	//declaracion de atributos JButton
	private JButton btnActualizar;
	
	//declaracion de atributos JLabel
	private JLabel lblProveedores;
	private JLabel lblResultadosBusqueda;
	
	//declaracion de atributos JPanel
	private JPanel panelBusqueda;
	private JPanel panelProducto;
	
	//declaracion de atributos DefaultTableModel
	private DefaultTableModel productosModel;
	
	//declaracion de atributos DefaultTableModel
	private JTable JTableProductos;
	
	//declaracion de atributos JScrollPane
	private JScrollPane scrollPane;
	
	//declaracion de atributos boolean
	private boolean despliega=true;
	
	//declaracion de atributos ServicioActualizacionPorLotesClase
	private ServicioActualizacionPorLotes servicioActualizacionPorLote;
	
	////declaracion de atributos String[][]
	private String[][] productosProveedor;
	
	
	public VentanaActualizacionPorLotes( ServicioActualizacionPorLotes actualizacionPorLotes){
		super("Actualizacion por lotes","Regresar a ventana \"Productos\"");
		this.servicioActualizacionPorLote=actualizacionPorLotes;

		//asignacion de propiedades panel2
		panel2.setLayout(new BorderLayout());
		//inicializacion y asignacion de propiedades panelBusqueda
		panelBusqueda= new JPanel();
		panelBusqueda.setBorder(BorderFactory.createLoweredBevelBorder());
		panelBusqueda.setBackground(UIManager.getColor("Button.focus"));
		panelBusqueda.setLayout(new	GridLayout(1,5));
		
		//inicializacion y asignacion de propiedades lblProveedores
		lblProveedores= new JLabel("Proveedores:");
		lblProveedores.setFont(new Font("Dialog", Font.BOLD, 25));
		panelBusqueda.add(lblProveedores);
		
		//inicializacion y asignacion de propiedades lblVacio
		JLabel lblVacio=new JLabel("  ");
		lblVacio.setFont(new Font("Dialog", Font.BOLD, 25));
		panelBusqueda.add(lblVacio);

		//inicializacion y asignacion de propiedades JComboBox
		JComboBoxProveedores=new JComboBox();
		JComboBoxProveedores.addItem("Seleccione");
		JComboBoxProveedores.setFont(new Font("Dialog", Font.BOLD, 25));
		panelBusqueda.add(JComboBoxProveedores);
		
		//asignacion de panelBusqueda a panel2 
		panel2.add(panelBusqueda,BorderLayout.NORTH);
		
		//inicializacion y asignacion de propiedades panelProducto
		panelProducto= new JPanel();
		panelProducto.setBorder(BorderFactory.createLoweredBevelBorder());
		panelProducto.setBackground(UIManager.getColor("Button.focus"));
		panelProducto.setLayout(new	GridLayout(3,1));
		
		//asignacion de panelProducto a panel2 
		panel2.add(panelProducto,BorderLayout.CENTER);
		
		//inicializacion y asignacion de propiedades lblResultadosBusqueda
		lblResultadosBusqueda = new JLabel("Resultados de Busqueda:");
		lblResultadosBusqueda.setFont(new Font("Dialog", Font.BOLD, 25));
		panelProducto.add(lblResultadosBusqueda);
		lblResultadosBusqueda.setVisible(true);
		
		//inicializacion y asignacion de propiedades btnActualizar
		btnActualizar= new JButton("Actualizar");
		btnActualizar.setFont(new Font("Dialog", Font.BOLD, 30));
		panel3.add(btnActualizar, BorderLayout.WEST);
		btnActualizar.setEnabled(false);

		//inicializacion y asignacion de propiedades productosModel
		productosModel= new DefaultTableModel(){
		    public boolean isCellEditable(int filaIndice, int columnaIndice) {
		    	if(columnaIndice<2){
		    		return false; 
		    	}else{
		    		return true;
		    	}	
		    }
		};
		
		//inicializacion y asignacion de propiedades JTableProductos
		JTableProductos=new JTable(productosModel);
		JTableProductos.setRowHeight(30);
		JTableProductos.setFont(new Font("Dialog", Font.BOLD, 20));
		
		//asignacion de JTableProductos a scrollPane
		scrollPane= new JScrollPane(JTableProductos);
		panelProducto.add(scrollPane);
		scrollPane.setVisible(false);

		//inicializacion y asignacion de propiedades lblVacio2
		JLabel lblVacio2=new JLabel(" ");
		lblVacio2.setFont(new Font("Dialog", Font.BOLD, 150));
		panelProducto.add(lblVacio2);
		lblVacio2.setVisible(false);
		
		//se agregan tips a los objetos
		JComboBoxProveedores.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Selecciona un proveedor</h4></div></body></html>");
		btnActualizar.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Actualizar</h4></div></body></html>");
		JTableProductos.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Cambie existencias</h4></div></body></html>");
		btnSalir.setToolTipText("<html><body><div style='BackGround-color:#80BFFF' ><h4>Regresar a ventana Productos</h4></div></body></html>");
		
		//asignacion de eventos para el JComboBoxProveedores de menu
		JComboBoxProveedores.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				if(despliega){
					int indice;
					String[] proveedores=servicioActualizacionPorLote.listaProveedores();
					for(indice=0;indice<proveedores.length;indice++){
						JComboBoxProveedores.addItem(proveedores[indice]);
					}
					despliega=false;
				}
			}
		});
		
		//asignacion de eventos para el JComboBoxProveedores de item
		JComboBoxProveedores.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {		
				if(JComboBoxProveedores.getSelectedIndex()==0){
					scrollPane.setVisible(false);
					btnActualizar.setEnabled(false);
				}else{
					productosProveedor=servicioActualizacionPorLote.mostrarDatos((String)JComboBoxProveedores.getItemAt(JComboBoxProveedores.getSelectedIndex()));
					Object[] columnas={"Codigo", "Nombre", "Existencia"};
					productosModel.setDataVector(productosProveedor,columnas);
					scrollPane.setVisible(true);
					btnActualizar.setEnabled(true);
				}
			}
		});

		
		//asignacion de eventos para el btnActualizar
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice,contador=0,contador2=0,contador3=0;
				boolean valor;
					float[] existencia = new float[productosModel.getRowCount()];
					if(JTableProductos.isEditing()){
						JTableProductos.getCellEditor().stopCellEditing();
					}
					for(indice=0;indice<productosModel.getRowCount();indice++){
						try{
							existencia[indice]=Float.parseFloat(productosModel.getValueAt(indice, 2).toString());
						}catch(Exception exception){
							contador++;
						}
					}
					//validacion para caracteres en celda
					if(contador>0){
						JOptionPane.showMessageDialog(ventana, "inserto caracteres en celda");
					}else{
						for(indice=0;indice<existencia.length;indice++){
							if(existencia[indice]<Float.parseFloat(productosProveedor[indice][2])){
								productosModel.setValueAt(productosProveedor[indice][2], indice, 2);
								contador2++;
							}
							//validacion para productos que son de tipo granel
							if(Float.parseFloat(productosProveedor[indice][3])!=0){
								 float auxiliar1=existencia[indice];
								 if(Math.floor((double)auxiliar1)!=existencia[indice] && Math.ceil((double)auxiliar1)!=existencia[indice] ){
									 productosModel.setValueAt(productosProveedor[indice][2], indice, 2);
									 contador3++;
								 }
							}
						}
						//mensajes de aceptacion o error
						if(contador3==0){
							if(contador2==0){
								valor=servicioActualizacionPorLote.cambiaExistencia(existencia);
								if(valor){
									JOptionPane.showMessageDialog(ventana, "Producto actualizado");
									ventana.dispose();
								}else{
									JOptionPane.showMessageDialog(ventana, "Producto no actualizado");
								}
							}else{
								JOptionPane.showMessageDialog(ventana, "las existencias son menores que antes y se han restablecido los campos errones");
							}
						}else{
							JOptionPane.showMessageDialog(ventana, "algunas existencias no pueden ser enteras y se restablecieron los campos erroneos");
						}
					}
			}});		

	}
}