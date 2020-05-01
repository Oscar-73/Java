

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class OpcionesIniciales extends JFrame {
	static OpcionesIniciales frame;
	private JPanel opciones;
	private JTextField lblNombreJugador;
	private JLabel lblIntroduceNombre;
	private JLabel lblSeleccionarColor;
	private JButton btnColorRojo;
	private JButton btnColorVerde;
	private JButton btnColorAzul;
	private JLabel lblSeleccionaAlimentacion;
	private JButton btnCarnivora;
	private JButton btnVegetariana;
	private JButton btnOmnivora;
	private JButton btnGuardar;
	private JLabel lblMensajeError;
	
	private String nombreJugador;
	boolean verde = false, rojo = false, azul = false, carnivora = false, vegetariana = false, omnivora = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new OpcionesIniciales();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setTitle("Opciones iniciales");
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(OpcionesIniciales.class.getResource("/graficos/opciones.png")));
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(730, 300, 450, 420);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OpcionesIniciales() {
		opciones = new JPanel();
		opciones.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(opciones);
		
		lblIntroduceNombre = new JLabel("Introduce tu nombre:");
		lblIntroduceNombre.setBounds(20, 21, 174, 19);
		lblIntroduceNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblNombreJugador = new JTextField();
		lblNombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombreJugador.setBounds(20, 49, 317, 34);
		lblNombreJugador.setColumns(10);
		
		lblSeleccionarColor = new JLabel("Selecciona el color de la serpiente:");
		lblSeleccionarColor.setBounds(20, 100, 290, 19);
		lblSeleccionarColor.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnColorRojo = new JButton("Rojo");
		btnColorRojo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnColorRojo.setBounds(20, 125, 120, 40);
		btnColorRojo.setBackground(Color.RED);
		btnColorRojo.setForeground(Color.WHITE);
		
		btnColorVerde = new JButton("Verde");
		btnColorVerde.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnColorVerde.setForeground(Color.WHITE);
		btnColorVerde.setBounds(155, 125, 120, 40);
		btnColorVerde.setBackground(Color.GREEN);
		
		btnColorAzul = new JButton("Azul");
		btnColorAzul.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnColorAzul.setBounds(290, 125, 120, 40);
		btnColorAzul.setForeground(Color.WHITE);
		btnColorAzul.setBackground(Color.BLUE);

		// Si pulsamos cualquiera de los botones que asignan un color a la serpiente, este se oscurece y cambia el color del texto
		btnColorRojo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnColorRojo.setBackground(new Color(0xcc0000));
				btnColorVerde.setBackground(Color.GREEN);
				btnColorAzul.setBackground(Color.BLUE);
				
				btnColorRojo.setForeground(Color.YELLOW);
				btnColorVerde.setForeground(Color.WHITE);
				btnColorAzul.setForeground(Color.WHITE);
				
				rojo = true;
				verde = false;
				azul = false;
			}
		});
		
		btnColorVerde.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnColorRojo.setBackground(Color.RED);
				btnColorVerde.setBackground(new Color(0x009900));
				btnColorAzul.setBackground(Color.BLUE);
				
				btnColorVerde.setForeground(Color.YELLOW);
				btnColorRojo.setForeground(Color.WHITE);
				btnColorAzul.setForeground(Color.WHITE);
				
				rojo = false;
				verde = true;
				azul = false;
			}
		});
		
		btnColorAzul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnColorRojo.setBackground(Color.RED);
				btnColorVerde.setBackground(Color.GREEN);
				btnColorAzul.setBackground(new Color(0x000066));
				
				btnColorAzul.setForeground(Color.YELLOW);
				btnColorRojo.setForeground(Color.WHITE);
				btnColorVerde.setForeground(Color.WHITE);
				
				rojo = false;
				verde = false;
				azul = true;
			}
		});
		
		lblSeleccionaAlimentacion = new JLabel("Selecciona la alimentación de la serpiente:");
		lblSeleccionaAlimentacion.setBounds(20, 185, 349, 19);
		lblSeleccionaAlimentacion.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnCarnivora = new JButton("Carnívora");
		btnCarnivora.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCarnivora.setBounds(20, 220, 120, 40);
		btnCarnivora.setForeground(Color.BLACK);
		btnCarnivora.setBackground(Color.LIGHT_GRAY);
		
		btnVegetariana = new JButton("Vegetariana");
		btnVegetariana.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVegetariana.setBounds(155, 220, 120, 40);
		btnVegetariana.setBackground(Color.LIGHT_GRAY);
		
		btnOmnivora = new JButton("Omnívora");
		btnOmnivora.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOmnivora.setBounds(290, 220, 120, 40);
		btnOmnivora.setForeground(Color.BLACK);
		btnOmnivora.setBackground(Color.LIGHT_GRAY);
		
		// Si pulsamos cualquiera de los botones que asignan una alimentación a la serpiente, este se oscurece y cambia el color del texto
		btnCarnivora.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCarnivora.setBackground(Color.DARK_GRAY);
				btnVegetariana.setBackground(Color.LIGHT_GRAY);
				btnOmnivora.setBackground(Color.LIGHT_GRAY);
				
				btnCarnivora.setForeground(Color.WHITE);
				btnVegetariana.setForeground(Color.BLACK);
				btnOmnivora.setForeground(Color.BLACK);
				
				carnivora = true;
				vegetariana = false;
				omnivora = false;
			}
		});

		btnVegetariana.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnCarnivora.setBackground(Color.LIGHT_GRAY);
				btnVegetariana.setBackground(Color.DARK_GRAY);
				btnOmnivora.setBackground(Color.LIGHT_GRAY);
				
				btnCarnivora.setForeground(Color.BLACK);
				btnVegetariana.setForeground(Color.WHITE);
				btnOmnivora.setForeground(Color.BLACK);
				
				carnivora = false;
				vegetariana = true;
				omnivora = false;
			}
		});
		
		btnOmnivora.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnCarnivora.setBackground(Color.LIGHT_GRAY);
				btnVegetariana.setBackground(Color.LIGHT_GRAY);
				btnOmnivora.setBackground(Color.DARK_GRAY);
				
				btnCarnivora.setForeground(Color.BLACK);
				btnVegetariana.setForeground(Color.BLACK);
				btnOmnivora.setForeground(Color.WHITE);
				
				carnivora = false;
				vegetariana = false;
				omnivora = true;
			}
		});
		
		lblMensajeError = new JLabel("");
		lblMensajeError.setForeground(Color.BLACK);
		lblMensajeError.setBounds(20, 285, 390, 19);
		lblMensajeError.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnGuardar = new JButton("Guardar y empezar partida");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setBounds(66, 320, 293, 32);
		
		// Comprobamos que estén todas las opciones iniciales configuradas y empezamos la partida
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nombreJugador = lblNombreJugador.getText();
				
				if(nombreJugador.isEmpty()) {
					lblMensajeError.setFont(new Font("Tahoma", Font.BOLD, 17));
					lblMensajeError.setText("Introduce un nombre.");
				}
				
				else if(nombreJugador.length() > 20) {
					lblMensajeError.setFont(new Font("Tahoma", Font.BOLD, 15));
					lblMensajeError.setText("Nombre demasiado largo. (Máximo 20 caracteres)");
				}
				
				else if(rojo == false && verde == false && azul == false) {
					lblMensajeError.setFont(new Font("Tahoma", Font.BOLD, 17));
					lblMensajeError.setText("Selecciona un color.");
				}
				
				else if(carnivora == false && vegetariana == false && omnivora == false) {
					lblMensajeError.setFont(new Font("Tahoma", Font.BOLD, 17));
					lblMensajeError.setText("Selecciona una alimentación.");
				}
				
				else {
					try {
						// Cerramos la ventana de opciones iniciales con "dispose()"
						dispose();

						// Creamos un nuevo JFrame el cual contendrá la partida y configuramos sus propiedades
						JFrame partida = new JFrame();
						partida.setTitle("Snake");
						partida.setIconImage(Toolkit.getDefaultToolkit().getImage(OpcionesIniciales.class.getResource("graficos/serpdretaverd.png"))); // Icono del nuevo JFrame
						partida.setBounds(550, 200, 905, 700);
						partida.setResizable(false);
						partida.setVisible(true);
						partida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
						// Le añadimos todas las opciones iniciales a la partida y los controles
						Controles controles = new Controles(nombreJugador, verde, azul, rojo, carnivora, vegetariana, omnivora);
						partida.getContentPane().add(controles);
					} catch(Exception e2) {

					}
				}
			}
		});
		opciones.setLayout(null);
		opciones.add(lblMensajeError);
		opciones.add(lblNombreJugador);
		opciones.add(lblIntroduceNombre);
		opciones.add(lblSeleccionarColor);
		opciones.add(lblSeleccionaAlimentacion);
		opciones.add(btnColorRojo);
		opciones.add(btnColorVerde);
		opciones.add(btnColorAzul);
		opciones.add(btnCarnivora);
		opciones.add(btnGuardar);
		opciones.add(btnVegetariana);
		opciones.add(btnOmnivora);
	}
}
