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

import ayd.managment.store.servicio.Interface.ServicioGenerarHoras;


//Heredo de VentanaGenerica
public class VentanaGenerarHoras extends VentanaGenerica{
	private ServicioGenerarHoras servicioGeneraHoras;

	private JButton btnCalcularSalario = new JButton("Calcular Salario");
	private DefaultTableModel modeloDiasLaborados = new DefaultTableModel(){
		public boolean isCellEditable(int rowIndex,int columnIndex){return false;} 
	}; 
	//Etiquetas
	private JLabel lblCodigoEmpleado = new JLabel("Ingrese el código del empleado:");
	private JLabel lblDiasLaborados = new JLabel("Ingrese el número de días anteriores al actual:");
	private JLabel lblSueldo = new JLabel("Ingrese el salario por hora del empleado: $");
	private JLabel lblSalarioTotal = new JLabel("Salario total por los días laborados: $");
	//Campos te texto
	private JTextField txtCodigoEmpleado = new JTextField("");
	private JTextField txtDiasLaborados = new JTextField("");
	private JTextField txtSueldo = new JTextField("");
	private JTextField txtSalarioTotal = new JTextField("");
	
	//Tablas	
	private JTable tblDiasLaborados = new JTable(modeloDiasLaborados);
	//Scrolls
	private JScrollPane scrollDiasLaborados = new JScrollPane(tblDiasLaborados);
	//Paneles
	private JPanel panel21 = new JPanel();
	private JPanel panel22 = new JPanel();
	private JPanel panel23 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private int tecla;
	private int punto = 0;
	private int limite = 0;
	
	private ArrayList<String[]> datos;

	public VentanaGenerarHoras(ServicioGenerarHoras control){
		super("Generar horas","Regresar a ventana \"Empleados\"");
		servicioGeneraHoras = control;
		
		btnCalcularSalario.setFont(new Font("Dialog", Font.BOLD, 30));
		panel21.setBackground(UIManager.getColor("Button.focus"));
		panel22.setBackground(UIManager.getColor("Button.focus"));
		panel23.setBackground(UIManager.getColor("Button.focus"));
		panel3.setBackground(UIManager.getColor("Button.focus"));
		panel4.setBackground(UIManager.getColor("Button.focus"));
		lblCodigoEmpleado.setFont(new Font("Dialog", Font.BOLD, 28));
		lblDiasLaborados.setFont(new Font("Dialog", Font.BOLD, 28));
		lblSueldo.setFont(new Font("Dialog", Font.BOLD, 28));
		lblSalarioTotal.setFont(new Font("Dialog", Font.BOLD, 28));
		txtCodigoEmpleado.setFont(new Font("Dialog", Font.BOLD, 28));
		txtDiasLaborados.setFont(new Font("Dialog", Font.BOLD, 28));
		txtSueldo.setFont(new Font("Dialog", Font.BOLD, 28));
		txtSalarioTotal.setFont(new Font("Dialog", Font.BOLD, 28));
		tblDiasLaborados.setFont(new Font("Dialog", Font.BOLD, 28));
		tblDiasLaborados.setRowHeight(30);
		modeloDiasLaborados.addColumn("Fecha");
		modeloDiasLaborados.addColumn("Hora de entrada");
		modeloDiasLaborados.addColumn("Hora de Salida");
		
		panel2.setLayout(new BorderLayout(0, 20));
		panel2.add(panel21, BorderLayout.NORTH);
		panel2.add(panel22, BorderLayout.CENTER);
		panel2.add(panel23, BorderLayout.SOUTH);
		panel21.setLayout(new GridLayout(2, 1, 10, 10));
		panel21.add(panel3);
		panel21.add(panel4);
		panel3.setLayout(new GridLayout(3, 2, 10, 10));
		panel3.add(lblCodigoEmpleado);
		panel3.add(txtCodigoEmpleado);
		panel3.add(lblDiasLaborados);
		panel3.add(txtDiasLaborados);
		panel3.add(lblSueldo);
		panel3.add(txtSueldo);
		panel4.add(btnCalcularSalario);
		
		panel22.setLayout(new BorderLayout(0, 20));
		panel22.add(scrollDiasLaborados, BorderLayout.CENTER);	
		panel23.setLayout(new GridLayout(1, 2, 10, 10));
		panel23.add(lblSalarioTotal);
		panel23.add(txtSalarioTotal);
		txtSalarioTotal.setEditable(false);
		btnCalcularSalario.setEnabled(false);
		
		
		txtCodigoEmpleado.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				validaCadenaConEntero(txtCodigoEmpleado.getText(), e);
				activaBoton();
			}
		});
		
		txtDiasLaborados.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				validaEntero(txtDiasLaborados.getText(), e);
				activaBoton();
			}
		});
		
		txtSueldo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				validaFlotante(txtSueldo.getText(), e);
				activaBoton();
			}
		});
		
		txtCodigoEmpleado.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				activaBoton();
			}
		});
		
		txtDiasLaborados.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				activaBoton();
			}
		});
		
		txtSueldo.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				activaBoton();
			}
		});
		
		btnCalcularSalario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				while(modeloDiasLaborados.getRowCount()>0)
					modeloDiasLaborados.removeRow(0);
				generarHoras();
				
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCampos();
			}
		});
	}
	
	private void  validaCadenaConEntero(String anterior, KeyEvent e){
		tecla = (int) e.getKeyChar();
    	if(tecla >= 32 && tecla <= 47 || tecla >=58 && tecla <= 96 || tecla >= 123 && tecla <= 255)
    		e.consume();
    }
	
	private void  validaEntero(String anterior, KeyEvent e){
		tecla = (int) e.getKeyChar();
		if(tecla >= 32 && tecla <= 47 || tecla >= 58 && tecla <= 255)
			e.consume();
	}
	 
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
	
	private boolean camposNoVacios(){
		if(txtCodigoEmpleado.getText().isEmpty() || txtDiasLaborados.getText().isEmpty() || txtSueldo.getText().isEmpty())
			return false;
		else
			return true;
	}
	
	private void generarHoras(){
		if(servicioGeneraHoras.buscarUsuario(txtCodigoEmpleado.getText())){
			if( servicioGeneraHoras.buscarDiasLaborados(txtCodigoEmpleado.getText(), txtDiasLaborados.getText()) ){
				datos = servicioGeneraHoras.muestraDiasLaborados(txtCodigoEmpleado.getText(), txtDiasLaborados.getText());
				for(int i = 0; i < datos.size(); i++)
					modeloDiasLaborados.addRow(new String [] {datos.get(i)[0], datos.get(i)[1],datos.get(i)[2]});
				txtSalarioTotal.setText( servicioGeneraHoras.calculaSalario(txtSueldo.getText())+"" );
				datos = null;	
			}
		}
		else
			JOptionPane.showMessageDialog(ventana,"No hay registros de dias laborados para ese usuario.","Error",JOptionPane.ERROR_MESSAGE);
			
	}
	
	private void activaBoton(){
		if(camposNoVacios())
			btnCalcularSalario.setEnabled(true);
		else
			btnCalcularSalario.setEnabled(false);
	}
	
	private void limpiarCampos(){
		while(modeloDiasLaborados.getRowCount()>0)
			modeloDiasLaborados.removeRow(0);
		txtCodigoEmpleado.setText("");
		txtDiasLaborados.setText("");
		txtSalarioTotal.setText("");
		txtSueldo.setText("");
	}
}
