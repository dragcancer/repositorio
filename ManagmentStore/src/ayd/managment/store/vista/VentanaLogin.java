package ayd.managment.store.vista;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

import ayd.managment.store.servicio.Interface.ServicioLogin;

public class VentanaLogin extends JFrame{
	private ServicioLogin servicioLogin;
	private JFrame ventana = this;
	JPanel panel = new JPanel();
	JTextField id = new JTextField();
	JLabel iduser = new JLabel("Usuario:");
	JLabel passuser = new JLabel("Contrasena:");
	JPasswordField pass = new JPasswordField();
	JButton aceptar = new JButton("Ingresar");
	JButton btnSalir = new JButton("Cancelar");
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	JProgressBar pb = new JProgressBar();
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();
	
	//Metodo que inicia la vista del Login
	public  VentanaLogin(ServicioLogin control) {
		servicioLogin = control;
		this.setTitle("Autentificacion de encargado");
		
		panel.setLayout(new GridLayout(3,2));
        	
		//Implementacion del envento en el boton de salir
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpia();
				ventana.setVisible(false);
				servicioLogin.desbloqueaVentanaPrincipal();
			}
		});
		
		ventana.addWindowListener( new WindowAdapter() { 
			public void windowClosing( WindowEvent evt ) { 
				servicioLogin.desbloqueaVentanaPrincipal();
			} 
		}); 

		//Implementacion del envento en el boton de Ingresar
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				if(validadatos())                               
					JOptionPane.showMessageDialog(ventana,"Hay campos vacios", "Aviso",JOptionPane.WARNING_MESSAGE);                               
				else{
					String usuarioid=id.getText();
					@SuppressWarnings("deprecation")
					String usuariopass=pass.getText();
					limpia();
					int resp = servicioLogin.Login(usuarioid,usuariopass);
					if(resp == 0){
						servicioLogin.desbloqueaVentanaPrincipal();
						servicioLogin.setIntentos(0);
						ventana.setVisible(false);
					}
					else{
						servicioLogin.setIntentos(servicioLogin.getIntentos()+1);
						if(resp == 1)
							JOptionPane.showMessageDialog(ventana,"No tiene privilegios para entrar en esta seccion.\nQuedan "+(servicioLogin.getIntentospermitidos()-servicioLogin.getIntentos())+" intento(s).","Error",JOptionPane.ERROR_MESSAGE);
						if(resp == 2)
							JOptionPane.showMessageDialog(ventana,"Contrasena invalida.\nQuedan "+(servicioLogin.getIntentospermitidos()-servicioLogin.getIntentos())+" intento(s).","Error",JOptionPane.ERROR_MESSAGE);
						if(resp == 3)
							JOptionPane.showMessageDialog(ventana,"Usuario inexistente.\nQuedan "+(servicioLogin.getIntentospermitidos()-servicioLogin.getIntentos())+" intento(s).","Error",JOptionPane.ERROR_MESSAGE);					
						if(servicioLogin.getIntentos() == servicioLogin.getIntentospermitidos()){
							JOptionPane.showMessageDialog(ventana,"El sistema ha sido bloqueado.");
							timer(servicioLogin);
							ventana.setVisible(false);
						}
					}
				}
			}
		});

		ventana.setSize(700, 150);
		iduser.setFont(new Font("Dialog", Font.BOLD, 28));
		iduser.setForeground(Color.WHITE);
		iduser.setHorizontalAlignment( SwingConstants.CENTER );
		panel.add(iduser);
		id.setFont(new Font("Dialog", Font.BOLD, 28));
		panel.add(id);
		passuser.setFont(new Font("Dialog", Font.BOLD, 28));
		passuser.setForeground(Color.WHITE);
		passuser.setHorizontalAlignment( SwingConstants.CENTER );
		panel.add(passuser);
		pass.setFont(new Font("Dialog", Font.BOLD, 28));
		panel.add(pass);
		aceptar.setFont(new Font("Dialog", Font.BOLD, 28));
		panel.add(aceptar);
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 28));
		panel.add(btnSalir, BorderLayout.EAST);
		panel.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		ventana.add(panel);
		ventana.setResizable(false);
		ventana.setUndecorated(true);
		ventana.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
	}

	private void limpia(){
		id.setText("");
		pass.setText("");
	}

	@SuppressWarnings("deprecation")
	private boolean validadatos(){
		if(id.getText().isEmpty() || pass.getText().isEmpty())
			return true;
		else
			return false;
	}

    private void timer(final ServicioLogin sl) {
    	final Timer timer;
    	timer = new Timer();

    	TimerTask task = new TimerTask() {
    		int tic=0;

    		public void run(){
    			if(tic>9){
    				sl.setIntentos(0);
    				timer.cancel();
    				servicioLogin.desbloqueaVentanaPrincipal();
    			}
    			tic++;
    		}
    	};
    	timer.schedule(task,0,1000);
    }
}
