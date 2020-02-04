

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.TargetDataLine;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class opcions extends JFrame {

	private JPanel opcions;
	private JTextField lblnomjugador;
	String nomjugador;
	boolean verd = false, vermell = false, blau = false,  carnivora = false, vegetariana = false, omnivora = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					opcions frame = new opcions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public opcions() {
		setResizable(false);

		setIconImage(Toolkit.getDefaultToolkit().getImage(opcions.class.getResource("/grafics/opcions.png")));
		setTitle("Opcions inicials");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 391);
		opcions = new JPanel();
		opcions.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(opcions);
		
		JLabel lblIntrodueixElTeu = new JLabel("Introdueix el teu nom:");
		lblIntrodueixElTeu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblnomjugador = new JTextField();
		lblnomjugador.setColumns(10);
		
		JLabel lblSeleccionaElColor = new JLabel("Selecciona el color de la serp:");
		lblSeleccionaElColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnvermell = new JButton("Vermell");
		btnvermell.setBackground(Color.RED);
		btnvermell.setForeground(Color.BLACK);
		
		JButton btnverd = new JButton("Verd");
		btnverd.setBackground(Color.GREEN);
		
		JButton btnblau = new JButton("Blau");
		btnblau.setForeground(Color.WHITE);
		btnblau.setBackground(Color.BLUE);
		
		btnvermell.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnvermell.setBackground(new Color(0xcc0000));
				btnverd.setBackground(Color.GREEN);
				btnblau.setBackground(Color.BLUE);
				
				btnvermell.setForeground(Color.YELLOW);
				btnverd.setForeground(Color.BLACK);
				btnblau.setForeground(Color.WHITE);
				
				vermell = true;
				verd = false;
				blau = false;
			}
		});
		
		btnverd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnvermell.setBackground(Color.RED);
				btnverd.setBackground(new Color(0x009900));
				btnblau.setBackground(Color.BLUE);
				
				btnverd.setForeground(Color.YELLOW);
				btnvermell.setForeground(Color.BLACK);
				btnblau.setForeground(Color.WHITE);
				
				vermell = false;
				verd = true;
				blau = false;
			}
		});
		
		btnblau.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnvermell.setBackground(Color.RED);
				btnverd.setBackground(Color.GREEN);
				btnblau.setBackground(new Color(0x000066));
				
				btnblau.setForeground(Color.YELLOW);
				btnvermell.setForeground(Color.BLACK);
				btnverd.setForeground(Color.BLACK);
				
				vermell = false;
				verd = false;
				blau = true;
			}
		});
		
		JLabel lblSeleccionaLaAlimentaci = new JLabel("Selecciona la alimentaci\u00F3 de la serp:");
		lblSeleccionaLaAlimentaci.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btncarnivora = new JButton("Carn\u00EDvora");
		btncarnivora.setForeground(Color.BLACK);
		btncarnivora.setBackground(Color.LIGHT_GRAY);
		
		JButton btnvegetariana = new JButton("Vegetariana");
		btnvegetariana.setBackground(Color.LIGHT_GRAY);
		
		JButton btnomnivora = new JButton("Omn\u00EDvora");
		btnomnivora.setForeground(Color.BLACK);
		btnomnivora.setBackground(Color.LIGHT_GRAY);
		
		btncarnivora.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btncarnivora.setBackground(Color.DARK_GRAY);
				btnvegetariana.setBackground(Color.LIGHT_GRAY);
				btnomnivora.setBackground(Color.LIGHT_GRAY);
				
				btncarnivora.setForeground(Color.WHITE);
				btnvegetariana.setForeground(Color.BLACK);
				btnomnivora.setForeground(Color.BLACK);
				
				carnivora = true;
				vegetariana = false;
				omnivora = false;
			}
		});

		btnvegetariana.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btncarnivora.setBackground(Color.LIGHT_GRAY);
				btnvegetariana.setBackground(Color.DARK_GRAY);
				btnomnivora.setBackground(Color.LIGHT_GRAY);
				
				btncarnivora.setForeground(Color.BLACK);
				btnvegetariana.setForeground(Color.WHITE);
				btnomnivora.setForeground(Color.BLACK);
				
				carnivora = false;
				vegetariana = true;
				omnivora = false;
			}
		});
		
		btnomnivora.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btncarnivora.setBackground(Color.LIGHT_GRAY);
				btnvegetariana.setBackground(Color.LIGHT_GRAY);
				btnomnivora.setBackground(Color.DARK_GRAY);
				
				btncarnivora.setForeground(Color.BLACK);
				btnvegetariana.setForeground(Color.BLACK);
				btnomnivora.setForeground(Color.WHITE);
				
				carnivora = false;
				vegetariana = false;
				omnivora = true;
			}
		});
		
		JButton btnguardar = new JButton("Guardar i comen\u00E7ar joc");
		
		JLabel lblmissatgeerror = new JLabel("");
		lblmissatgeerror.setHorizontalAlignment(SwingConstants.CENTER);
		lblmissatgeerror.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnguardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				nomjugador = lblnomjugador.getText();
				
				if(nomjugador.isEmpty()) {
					lblmissatgeerror.setText("Introdueix un nom.");
				}
				
				else if(vermell == false && verd == false && blau == false) {
					lblmissatgeerror.setText("Selecciona un color.");
				}
				
				else if(carnivora == false && vegetariana == false && omnivora == false) {
					lblmissatgeerror.setText("Selecciona una alimentació.");
				}
				
				else {
					
					try {
						dispose();
	
						JFrame finestra = new JFrame();
						controls controls = new controls(nomjugador, verd, blau, vermell, carnivora, vegetariana, omnivora);

	
						finestra.setTitle("Snake"); // Títol de la finestra
						
						finestra.setIconImage(Toolkit.getDefaultToolkit().getImage(opcions.class.getResource("grafics/serpdretaverd.png"))); // Icona de la finestra
						
						finestra.setBounds(10, 10, 905, 700); // Mida de la finestra
						
						finestra.setResizable(false); // A la finestra no se li pot modificar la mida
						finestra.setVisible(true); // Amb això fem que s'obri la finestra
						
						
						finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Amb això fem que quan es tanqui la finestra, el procès s'aturi
						finestra.getContentPane().add(controls);
						
					} catch(Exception aae) {
						
					}
						
				}

				
			}
		});
		
		
		
		GroupLayout gl_opcions = new GroupLayout(opcions);
		gl_opcions.setHorizontalGroup(
			gl_opcions.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_opcions.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_opcions.createParallelGroup(Alignment.LEADING)
						.addComponent(lblmissatgeerror, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(lblnomjugador, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIntrodueixElTeu)
						.addComponent(lblSeleccionaElColor)
						.addGroup(gl_opcions.createSequentialGroup()
							.addGroup(gl_opcions.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblSeleccionaLaAlimentaci, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_opcions.createSequentialGroup()
									.addComponent(btnvermell, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnverd, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnblau, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_opcions.createSequentialGroup()
							.addComponent(btncarnivora, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_opcions.createParallelGroup(Alignment.LEADING)
								.addComponent(btnguardar)
								.addGroup(gl_opcions.createSequentialGroup()
									.addComponent(btnvegetariana, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnomnivora, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_opcions.setVerticalGroup(
			gl_opcions.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_opcions.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIntrodueixElTeu)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblnomjugador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSeleccionaElColor, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_opcions.createParallelGroup(Alignment.LEADING)
						.addComponent(btnvermell, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnverd, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnblau, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblSeleccionaLaAlimentaci, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_opcions.createParallelGroup(Alignment.LEADING)
						.addComponent(btncarnivora, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnvegetariana, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnomnivora, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(btnguardar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblmissatgeerror, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		opcions.setLayout(gl_opcions);
	}
	
}
