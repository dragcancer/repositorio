package ayd.managment.store.vista;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import ayd.managment.store.servicio.Interface.ServicioLogin;
import ayd.managment.store.servicio.clase.ServicioLoginClase;

public class VentanaLogin extends JFrame {
	private ServicioLoginClase servicioLogin;
	private JPanel contentPane;
	private JFrame ventana=this;
	private JTextField usuario;
	private JPasswordField contraseña;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VentanaLogin(ServicioLoginClase control) {
		servicioLogin=control;
		setIconImage(Toolkit.getDefaultToolkit().getImage("..\\ManagmentStore\\Iconos\\Places-user-identity-icon.png"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton entrar = new JButton("");
		entrar.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\Login-in-icon.png"));
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(validadatos())                               
					JOptionPane.showMessageDialog(ventana,"Hay campos vacios", "Aviso",JOptionPane.WARNING_MESSAGE);                               
				else{
					String usuarioid=usuario.getText();
					@SuppressWarnings("deprecation")
					String usuariopass=contraseña.getText();
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
		entrar.setBounds(20, 21, 134, 64);
	
		contentPane.add(entrar);
		
		JButton salir = new JButton("");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		salir.setIcon(new ImageIcon("..\\ManagmentStore\\Iconos\\Login-out-icon.png"));
		salir.setBounds(20, 91, 134, 64);
		
		salir.setToolTipText("Entrar");
		contentPane.add(salir);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(176, 36, 428, 107);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(23, 31, 86, 14);
		panel.add(lblUsuario);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasea.setBounds(23, 56, 113, 14);
		panel.add(lblContrasea);
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		
		usuario = new JTextField();
		usuario.setBounds(186, 24, 202, 20);
		panel.add(usuario);
		usuario.setToolTipText("Ingrese clave de usuario");
		usuario.setColumns(10);
		
		contraseña = new JPasswordField();
		contraseña.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyChar()=='\n'){
				if(validadatos())                               
					JOptionPane.showMessageDialog(ventana,"Hay campos vacios", "Aviso",JOptionPane.WARNING_MESSAGE);                               
				else{
					String usuarioid=usuario.getText();
					@SuppressWarnings("deprecation")
					String usuariopass=contraseña.getText();
					limpia();
					int resp = servicioLogin.Login(usuarioid,usuariopass);
					if(resp == 0){
						servicioLogin.desbloqueaVentanaPrincipal();
						servicioLogin.setIntentos(0);
						setVisible(false);
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
							JOptionPane.showMessageDialog(getContentPane(),"El sistema ha sido bloqueado.");
							timer(servicioLogin);
							getContentPane().setVisible(false);
						}
					}
				}
			}
			
		}
			
		});
		contraseña.setBounds(186, 55, 202, 20);
		panel.add(contraseña);
		contraseña.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 156, 159);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
	}

	private void limpia(){
		usuario.setText("");
		contraseña.setText("");
	}

	@SuppressWarnings("deprecation")
	private boolean validadatos(){
		if(usuario.getText().isEmpty() || contraseña.getText().isEmpty())
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

