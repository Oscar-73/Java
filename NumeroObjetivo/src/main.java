import java.awt.Color;
import java.awt.Font;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import java.util.Random;

public class main extends JFrame {

	private static JFrame frame;
	private JPanel contentPane;
	private JButton btnNuevoNumero;
	private JButton btnReiniciar;
	private JLabel lblObjetivo;
	private JButton btnNum1;
	private JButton btnNum2;
	private JButton btnNum3;
	private JButton btnNum5;
	private JButton btnNum6;
	private JButton btnNum4;
	private JButton btnSuma;
	private JButton btnResta;
	private JButton btnMulti;
	private JButton btnDiv;
	private JLabel lblOperacion1;
	private JLabel lblOperacion2;
	private JLabel lblOperacion3;
	private JLabel lblOperacion4;
	private JLabel lblOperacion5;
	private JButton btnNumEscogido1;
	private JButton btnNumEscogido2;
	private JButton btnNumEscogido3;
	private JButton btnNumEscogido4;
	private JButton btnNumEscogido5;

	private Random rand = new Random();
	private int numObjetivo = 0;
	private int num1, num2 = 0;
	private boolean btnNum1Act = false, btnNum2Act = false, btnNum3Act = false, btnNum4Act = false, btnNum5Act = false, btnNum6Act = false;
	private boolean btnNumResu1Act = false,  btnNumResu2Act = false,  btnNumResu3Act = false,  btnNumResu4Act = false,  btnNumResu5Act = false;
	private int pasoOperacion = 0; // Variable que nos servirá para determinar en qué punto de la operación nos encontramos
	private int numOperacion = 1; // Variable que nos servirá para determinar en qué operación estamos
	private char operador;
	private int resultado = 0; // Variable que almacenará los resultados de las operaciones que realicemos
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new main();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setTitle("Número objetivo");
					frame.setBounds(700, 200, 600, 600);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		// Inicializamos y asignamos el JPanel que va a contenerlo todo
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		// JLabel del número objetivo
		lblObjetivo = new JLabel();
		lblObjetivo.setText("Objetivo: ");
		lblObjetivo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblObjetivo.setForeground(Color.BLACK);
		lblObjetivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblObjetivo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblObjetivo.setBounds(73, 85, 444, 23);
		
		numObjetivo = rand.nextInt(900) + 100; // Generamos un número objetivo inicial entre 100 y 900
		lblObjetivo.setText("Objetivo: "+numObjetivo); // Se lo asignamos al JLabel anteriormente inicializado
		
		// JButton para generar un nuevo número objetivo
		btnNuevoNumero = new JButton("Nuevo número");
		btnNuevoNumero.setBounds(73, 21, 207, 29);
		btnNuevoNumero.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		// Método ligado al JButton anterior
		btnNuevoNumero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				numObjetivo = rand.nextInt(900) + 100; // Número aleatorio entre 100 y 900
				lblObjetivo.setText("Objetivo: "+numObjetivo);
				
				// Asignamos números aleatorios a los seis botones
				btnNum1 = btnNumRand(btnNum1);
				btnNum2 = btnNumRand(btnNum2);
				btnNum3 = btnNumRand(btnNum3);
				btnNum4 = btnNumRand(btnNum4);				
				btnNum5 = btnNumRand(btnNum5);
				btnNum6 = btnNumRand(btnNum6);
				
				limpiarAplicacion();
			}
		});
		
		// JButton que reinicia la partida sin cambiar el número objetivo
		btnReiniciar = new JButton("Reiniciar operaciones");
		btnReiniciar.setBounds(295, 21, 222, 29);
		btnReiniciar.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		// Método ligado al JButton anterior
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarAplicacion();
				lblObjetivo.setText("Objetivo: "+numObjetivo);
			}
		});
		
		// BOTÓN NÚMERO 1
		btnNum1 = new JButton("");
		btnNum1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNum1.setBounds(73, 139, 100, 40);
		
		btnNum1 = btnNumRand(btnNum1); // Número inicial aleatorio
		
		btnNum1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!btnNum1.isEnabled())
					return;

				else if(pasoOperacion == 0) {
					btnNum1Act = true;
					pasoOperacion0(btnNum1, numOperacion);
				}
				
				else if(pasoOperacion == 2) {
					btnNum1Act = true;
					pasoOperacion2(btnNum1, operador, numOperacion);
				}
			}
		});
		
		// BOTÓN NÚMERO 2
		btnNum2 = new JButton("");
		btnNum2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNum2.setBounds(73, 195, 100, 40);
		
		btnNum2 = btnNumRand(btnNum2);
		
		btnNum2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				if (!btnNum2.isEnabled())
					return;

				else if(pasoOperacion == 0) {
					btnNum2Act = true;
					pasoOperacion0(btnNum2, numOperacion);
				}
				
				else if(pasoOperacion == 2) {
					btnNum2Act = true;
					pasoOperacion2(btnNum2, operador, numOperacion);
				}
			}
		});
		
		// BOTÓN NÚMERO 3
		btnNum3 = new JButton("");
		btnNum3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNum3.setBounds(73, 251, 100, 40);
		
		btnNum3 = btnNumRand(btnNum3);
		
		btnNum3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!btnNum3.isEnabled())
					return;
				
				else if(pasoOperacion == 0) {
					btnNum3Act = true;
					pasoOperacion0(btnNum3, numOperacion);
				}
				
				else if(pasoOperacion == 2) {
					btnNum3Act = true;
					pasoOperacion2(btnNum3, operador, numOperacion);
				}
			}
		});
		
		// BOTÓN NÚMERO 4
		btnNum4 = new JButton("");
		btnNum4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNum4.setBounds(73, 307, 100, 40);
		
		btnNum4 = btnNumRand(btnNum4);
		
		btnNum4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!btnNum4.isEnabled())
					return;
				
				else if(pasoOperacion == 0) {
					btnNum4Act = true;
					pasoOperacion0(btnNum4, numOperacion);
				}
				
				else if(pasoOperacion == 2) {
					btnNum4Act = true;
					pasoOperacion2(btnNum4, operador, numOperacion);
				}
			}
		});
		
		// BOTÓN NÚMERO 5
		btnNum5 = new JButton("");
		btnNum5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNum5.setBounds(73, 363, 100, 40);
		
		btnNum5 = btnNumRand(btnNum5);
		
		btnNum5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!btnNum5.isEnabled())
					return;

				else if(pasoOperacion == 0) {
					btnNum5Act = true;
					pasoOperacion0(btnNum5, numOperacion);
				}
				
				else if(pasoOperacion == 2) {
					btnNum5Act = true;
					pasoOperacion2(btnNum5, operador, numOperacion);
				}
			}
		});
		
		// BOTÓN NÚMERO 6
		btnNum6 = new JButton("");
		btnNum6.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNum6.setBounds(73, 419, 100, 40);
		
		btnNum6 = btnNumRand(btnNum6);
		
		btnNum6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!btnNum6.isEnabled())
					return;

				if(pasoOperacion == 0) {
					btnNum6Act = true;
					pasoOperacion0(btnNum6, numOperacion);
				}
				
				if(pasoOperacion == 2) {
					btnNum6Act = true;
					pasoOperacion2(btnNum6, operador, numOperacion);
				}
			}
		});
		
		// JLabel en el que se ve la primera operación
		lblOperacion1 = new JLabel();
		lblOperacion1.setBounds(188, 154, 214, 14);
		lblOperacion1.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperacion1.setText("-");
		lblOperacion1.setForeground(Color.BLACK);
		lblOperacion1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOperacion1.setBorder(null);
		
		// BOTÓN RESULTADO 1 (Botón que adopta el valor del resultado de la primera operación)
		btnNumEscogido1 = new JButton("?");
		btnNumEscogido1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNumEscogido1.setBounds(417, 139, 100, 40);
		btnNumEscogido1.setEnabled(false);
					
		btnNumEscogido1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!btnNumEscogido1.isEnabled())
					return;

				else if(pasoOperacion == 0) {
					btnNumResu1Act = true;
					pasoOperacion0(btnNumEscogido1, numOperacion);
				}
				
				else if(pasoOperacion == 2) {
					btnNumResu1Act = true;
					pasoOperacion2(btnNumEscogido1, operador, numOperacion);
				}
				btnNumEscogido1.setEnabled(false);
			}
		});
		
		// JLabel en el que se ve la segunda operación
		lblOperacion2 = new JLabel();
		lblOperacion2.setBounds(188, 210, 214, 14);
		lblOperacion2.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperacion2.setText("-");
		lblOperacion2.setForeground(Color.BLACK);
		lblOperacion2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOperacion2.setBorder(null);
		
		// BOTÓN RESULTADO 2 (Botón que adopta el valor del resultado de la segunda operación)
		btnNumEscogido2 = new JButton("?");
		btnNumEscogido2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNumEscogido2.setBounds(417, 195, 100, 40);
		btnNumEscogido2.setEnabled(false);
		
		btnNumEscogido2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pasoOperacion == 0) {
					btnNumResu2Act = true;
					pasoOperacion0(btnNumEscogido2, numOperacion);
				}
				
				else if(pasoOperacion == 2) {
					btnNumResu2Act = true;
					pasoOperacion2(btnNumEscogido2, operador, numOperacion);			
				}
			}
		});
		
		// JLabel en el que se ve la tercera operación
		lblOperacion3 = new JLabel();
		lblOperacion3.setBounds(188, 266, 214, 14);
		lblOperacion3.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperacion3.setText("-");
		lblOperacion3.setForeground(Color.BLACK);
		lblOperacion3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOperacion3.setBorder(null);
		
		// BOTÓN RESULTADO 3 (Botón que adopta el valor del resultado de la tercera operación)
		btnNumEscogido3 = new JButton("?");
		btnNumEscogido3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNumEscogido3.setBounds(417, 251, 100, 40);
		btnNumEscogido3.setEnabled(false);
		
		btnNumEscogido3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pasoOperacion == 0) {
					btnNumResu3Act = true;
					pasoOperacion0(btnNumEscogido3, numOperacion);
				}
				
				else if(pasoOperacion == 2) {
					btnNumResu3Act = true;
					pasoOperacion2(btnNumEscogido3, operador, numOperacion);			
				}
			}
		});
		
		// JLabel en el que se ve la cuarta operación
		lblOperacion4 = new JLabel();
		lblOperacion4.setBounds(186, 322, 214, 14);
		lblOperacion4.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperacion4.setText("-");
		lblOperacion4.setForeground(Color.BLACK);
		lblOperacion4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOperacion4.setBorder(null);
		
		// BOTÓN RESULTADO 4 (Botón que adopta el valor del resultado de la cuarta operación)
		btnNumEscogido4 = new JButton("?");
		btnNumEscogido4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNumEscogido4.setBounds(417, 307, 100, 40);
		btnNumEscogido4.setEnabled(false);
		
		btnNumEscogido4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pasoOperacion == 0) {
					btnNumResu4Act = true;
					pasoOperacion0(btnNumEscogido4, numOperacion);
				}
				
				else if(pasoOperacion == 2) {
					btnNumResu4Act = true;
					pasoOperacion2(btnNumEscogido4, operador, numOperacion);			
				}
			}
		});
		
		// JLabel en el que se ve la quinta y última operación
		lblOperacion5 = new JLabel();
		lblOperacion5.setBounds(188, 378, 214, 14);
		lblOperacion5.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperacion5.setText("-");
		lblOperacion5.setForeground(Color.BLACK);
		lblOperacion5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOperacion5.setBorder(null);
		
		// BOTÓN RESULTADO 5 (Botón que adopta el valor del resultado de la quinta y última operación)
		btnNumEscogido5 = new JButton("?");
		btnNumEscogido5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNumEscogido5.setBounds(417, 363, 100, 40);
		btnNumEscogido5.setEnabled(false);
		
		btnNumEscogido5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pasoOperacion == 0) {
					btnNumResu5Act = true;
					pasoOperacion0(btnNumEscogido5, numOperacion);
				}
				
				else if(pasoOperacion == 2) {
					btnNumResu5Act = true;
					pasoOperacion2(btnNumEscogido5, operador, numOperacion);			
				}
			}
		});
		
		// Los operadores solo responden si "pasoOperacion == 1", es decir, si ya se ha seleccionado el primer número.
		// BOTÓN SUMA
		btnSuma = new JButton("+");
		btnSuma.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSuma.setBounds(73, 499, 100, 40);
		
		btnSuma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				if(pasoOperacion == 1) {
					operador = '+';
					numOperacion(num1, operador, 0, pasoOperacion, numOperacion);
					pasoOperacion = 2;
				}
			}
		});
		
		// BOTÓN RESTA
		btnResta = new JButton("-");
		btnResta.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnResta.setBounds(188, 499, 100, 40);
		
		btnResta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(pasoOperacion == 1) {
					operador = '-';
					numOperacion(num1, operador, 0, pasoOperacion, numOperacion);
					pasoOperacion = 2;
				}
			}
		});
		
		// BOTÓN MULTI
		btnMulti = new JButton("*");
		btnMulti.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMulti.setBounds(302, 499, 100, 40);
		
		btnMulti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(pasoOperacion == 1) {
					operador = '*';
					numOperacion(num1, operador, 0, pasoOperacion, numOperacion);
					pasoOperacion = 2;
				}
			}
		});
		
		// BOTÓN DIVI
		btnDiv = new JButton("/");
		btnDiv.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDiv.setBounds(417, 499, 100, 40);
		
		btnDiv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(pasoOperacion == 1) {
					operador = '/';
					numOperacion(num1, operador, 0, pasoOperacion, numOperacion);
					pasoOperacion = 2;
				}
			}
		});
		
		// Añadimos todos los elementos al JPanel
		contentPane.setLayout(null);
		contentPane.add(btnSuma);
		contentPane.add(btnResta);
		contentPane.add(btnMulti);
		contentPane.add(btnDiv);
		contentPane.add(btnNum1);
		contentPane.add(btnNum2);
		contentPane.add(btnNum3);
		contentPane.add(btnNum4);
		contentPane.add(btnNum5);
		contentPane.add(btnNum6);
		contentPane.add(lblOperacion1);
		contentPane.add(lblOperacion4);
		contentPane.add(lblOperacion2);
		contentPane.add(lblOperacion3);
		contentPane.add(btnNumEscogido2);
		contentPane.add(btnNumEscogido1);
		contentPane.add(btnNumEscogido3);
		contentPane.add(btnNumEscogido4);
		contentPane.add(btnNumEscogido5);
		contentPane.add(lblOperacion5);
		contentPane.add(lblObjetivo);
		contentPane.add(btnNuevoNumero);
		contentPane.add(btnReiniciar);
	}
	
	// Método con el que le asignamos un valor aleatorio al botón que enviemos por parámetro
	public JButton btnNumRand(JButton button) {
		int num = rand.nextInt(5) + 1;
		
		switch(num) {
			case 1:	button.setText(String.valueOf(rand.nextInt(10) + 1));
					break;
			case 2:	button.setText(String.valueOf(25));
					break;
			case 3:	button.setText(String.valueOf(50));				
					break;
			case 4: button.setText(String.valueOf(75));
					break;
			case 5:	button.setText(String.valueOf(100));
					break;
		}
		return button;
	}
	
	// Método al que llamamos tras seleccionar el primer número
	public void pasoOperacion0(JButton btnNum, int numOperacion) {
		num1 = Integer.parseInt(btnNum.getText()); // Recogemos el número del JButton enviado por parámetro
		
		numOperacion(num1, ' ', 0, pasoOperacion, numOperacion); // Enviamos el número y el paso al método "numOperacion()"
			
		btnNum.setEnabled(false); // Deshabilitamos el botón

		pasoOperacion = 1; // Ahora "pasoOperacion" pasa a tener valor "1" y queda a la espera del operador 
	}

	// Método al que llamamos tras seleccionar el segundo número
	public void pasoOperacion2(JButton btnNum, char operador, int numOperacion) {
		num2 = Integer.parseInt(btnNum.getText());
		
		// Según el operador que le pasemos por parámetro, realizaremos una operación u otra
		switch(operador) {
			case '+':	resultado = num1 + num2;
						break;
			case '-':	resultado = num1 - num2;
						break;
			case '*':	resultado = num1 * num2;
						break;
			case '/':	resultado = num1 / num2;
						break;
		}
		
		// Si el resultado es negativo o se trata de una división que no devuelve 0, se cancela operación
		if(resultado < 0 || operador == '/' && num1 % num2 != 0) {
			pasoOperacion = 3;
			numOperacion(num1, operador, num2, pasoOperacion, numOperacion);
			
			// Rehabilitamos aquellos botones que usamos para la operación
			if(btnNum1Act == true)
				btnNum1.setEnabled(true);
			if(btnNum2Act == true)
				btnNum2.setEnabled(true);
			if(btnNum3Act == true)
				btnNum3.setEnabled(true);
			if(btnNum4Act == true)
				btnNum4.setEnabled(true);
			if(btnNum5Act == true)
				btnNum5.setEnabled(true);
			if(btnNum6Act == true)
				btnNum6.setEnabled(true);
			if(btnNumResu1Act == true)
				btnNumEscogido1.setEnabled(true);			
			if(btnNumResu2Act == true)
				btnNumEscogido2.setEnabled(true);
			if(btnNumResu3Act == true)
				btnNumEscogido3.setEnabled(true);
			if(btnNumResu4Act == true)
				btnNumEscogido4.setEnabled(true);
			if(btnNumResu5Act == true)
				btnNumEscogido5.setEnabled(true);

			// Los números, operador y paso de la operación vuelven a su estado original
			num1 = 0;
			num2 = 0;
			this.operador = ' ';
			pasoOperacion = 0;
		}
		
		// Si alcanzamos el número objetivo, se deshabilitan todos los botones y la aplicación queda a la espera de que pulses "Nuevo número" o "Reiniciar aplicación"
		else if(resultado == numObjetivo) {
			lblObjetivo.setText("¡Has alcanzado el número objetivo!");
			
			numOperacion(num1, operador, num2, pasoOperacion, numOperacion);
			
			btnNum1.setEnabled(false);
			btnNum2.setEnabled(false);
			btnNum3.setEnabled(false);
			btnNum4.setEnabled(false);
			btnNum5.setEnabled(false);
			btnNum6.setEnabled(false);
			btnNumEscogido1.setEnabled(false);
			btnNumEscogido2.setEnabled(false);
			btnNumEscogido3.setEnabled(false);
			btnNumEscogido4.setEnabled(false);
			btnNumEscogido5.setEnabled(false);
			btnSuma.setEnabled(false);
			btnResta.setEnabled(false);
			btnMulti.setEnabled(false);
			btnDiv.setEnabled(false);
		}
		
		else {
			numOperacion(num1, operador, num2, pasoOperacion, numOperacion);
		
			btnNum.setEnabled(false);

			pasoOperacion = 0;
		}
		
	}
	
	// Método que gestiona la operación por la que vamos y según esta, imprime las operaciones en un JLabel u otro
	public void numOperacion(int num1, char operador, int num2, int pasoOperacion, int numOperacion) {
		if(numOperacion == 1) {
			if(pasoOperacion == 0) {
				lblOperacion1.setText(num1 + " ");
			}
			
			else if(pasoOperacion == 1) {
				lblOperacion1.setText(num1 +" "+ operador+" ");
			}
			
			else if(pasoOperacion == 2) {
				lblOperacion1.setText(num1 +" "+ operador+" "+num2+" = "+resultado);
				
				btnNumEscogido1.setText(String.valueOf(resultado));
				btnNumEscogido1.setEnabled(true);
				
				this.pasoOperacion = 0;
				this.numOperacion = 2;
			
				btnNum1Act = false;
				btnNum2Act = false;
				btnNum3Act = false;
				btnNum4Act = false;
				btnNum5Act = false;
				btnNum6Act = false;
			}
			
			else if(pasoOperacion == 3) {
				lblOperacion1.setText("Operación no válida.");
			}
		}
		
		else if(numOperacion == 2) {
			if(pasoOperacion == 0) {
				lblOperacion2.setText(num1 + " ");
			}
			
			else if(pasoOperacion == 1) {
				lblOperacion2.setText(num1 +" "+ operador+" ");
			}
			
			else if(pasoOperacion == 2) {
				lblOperacion2.setText(num1 +" "+ operador+" "+num2+" = "+resultado);
				
				btnNumEscogido2.setText(String.valueOf(resultado));
				btnNumEscogido2.setEnabled(true);
				
				this.pasoOperacion = 0;
				this.numOperacion = 3;
				
				btnNum1Act = false;				
				btnNum2Act = false;
				btnNum3Act = false;
				btnNum4Act = false;
				btnNum5Act = false;
				btnNum6Act = false;
				
				btnNumResu1Act = false;
			}
			
			else if(pasoOperacion == 3) {
				lblOperacion2.setText("Operación no válida.");
			}
		}
		
		else if(numOperacion == 3) {
			if(pasoOperacion == 0) {
				lblOperacion3.setText(num1 + " ");
			}
			
			else if(pasoOperacion == 1) {
				lblOperacion3.setText(num1 +" "+ operador+" ");
			}
			
			else if(pasoOperacion == 2) {
				lblOperacion3.setText(num1 +" "+ operador+" "+num2+" = "+resultado);
				
				btnNumEscogido3.setText(String.valueOf(resultado));
				btnNumEscogido3.setEnabled(true);
				
				this.pasoOperacion = 0;
				this.numOperacion = 4;
				
				btnNum1Act = false;				
				btnNum2Act = false;
				btnNum3Act = false;
				btnNum4Act = false;
				btnNum5Act = false;
				btnNum6Act = false;
				
				btnNumResu1Act = false;
				btnNumResu2Act = false;
			}
			
			else if(pasoOperacion == 3) {
				lblOperacion3.setText("Operación no válida.");
			}
		}
		
		else if(numOperacion == 4) {
			if(pasoOperacion == 0) {
				lblOperacion4.setText(num1 + " ");
			}
			
			else if(pasoOperacion == 1) {
				lblOperacion4.setText(num1 +" "+ operador+" ");
			}
			
			else if(pasoOperacion == 2) {
				lblOperacion4.setText(num1 +" "+ operador+" "+num2+" = "+resultado);
				
				btnNumEscogido4.setText(String.valueOf(resultado));
				btnNumEscogido4.setEnabled(true);
				
				this.pasoOperacion = 0;
				this.numOperacion = 5;
				
				btnNum1Act = false;				
				btnNum2Act = false;
				btnNum3Act = false;
				btnNum4Act = false;
				btnNum5Act = false;
				btnNum6Act = false;
				
				btnNumResu1Act = false;
				btnNumResu2Act = false;
				btnNumResu3Act = false;
			}
			
			else if(pasoOperacion == 3) {
				lblOperacion4.setText("Operación no válida.");
			}
		}
		
		else if(numOperacion == 5) {
			if(pasoOperacion == 0) {
				lblOperacion5.setText(num1 + " ");
			}
			
			else if(pasoOperacion == 1) {
				lblOperacion5.setText(num1 +" "+ operador+" ");
			}
			
			else if(pasoOperacion == 2) {
				lblOperacion5.setText(num1 +" "+ operador+" "+num2+" = "+resultado);
				
				btnNumEscogido5.setText(String.valueOf(resultado));
				
				lblObjetivo.setText("Te has quedado sin números...");
				
				this.pasoOperacion = 0;
				this.numOperacion = 6;
				
				btnNum1Act = false;				
				btnNum2Act = false;
				btnNum3Act = false;
				btnNum4Act = false;
				btnNum5Act = false;
				btnNum6Act = false;
				
				btnNumResu1Act = false;
				btnNumResu2Act = false;
				btnNumResu3Act = false;
				btnNumResu4Act = false;
				btnNumResu5Act = false;
			}
			
			else if(pasoOperacion == 3) {
				lblOperacion5.setText("Operación no válida.");
			}
		}
	}
	
	private void limpiarAplicacion() {
		// Habilita todos los números y operadores
		btnNum1.setEnabled(true);
		btnNum2.setEnabled(true);
		btnNum3.setEnabled(true);
		btnNum4.setEnabled(true);
		btnNum5.setEnabled(true);
		btnNum6.setEnabled(true);
		btnSuma.setEnabled(true);
		btnResta.setEnabled(true);
		btnMulti.setEnabled(true);
		btnDiv.setEnabled(true);
		
		// Limpia todas las variables y regresa al primer paso
		num1 = 0;
		num2 = 0;
		operador = ' ';
		
		pasoOperacion = 0;
		numOperacion = 1;
		resultado = 0;
		
		// Limpia todos los números resultantes
		btnNumEscogido1.setText("?");
		btnNumEscogido1.setEnabled(false);
		
		btnNumEscogido2.setText("?");
		btnNumEscogido2.setEnabled(false);
		
		btnNumEscogido3.setText("?");
		btnNumEscogido3.setEnabled(false);
		
		btnNumEscogido4.setText("?");
		btnNumEscogido4.setEnabled(false);
		
		btnNumEscogido5.setText("?");
		btnNumEscogido5.setEnabled(false);
		
		// Limpia todas las operaciones
		lblOperacion1.setText("-");
		lblOperacion2.setText("-");
		lblOperacion3.setText("-");
		lblOperacion4.setText("-");
		lblOperacion5.setText("-");
	}
}
