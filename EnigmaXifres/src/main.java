import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.SwingConstants;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField txtObjectiu;
	private JButton btnNum1;
	private JButton btnNum2;
	private JButton btnNum3;
	private JButton btnNum5;
	private JButton btnNum6;
	private JButton btnNum4;
	private JTextField txtOperacio1;
	private JTextField txtResultat;
	private JButton btnNumEscollit1;
	private JButton btnNumEscollit2;
	private JButton btnNumEscollit3;
	private JButton btnNumEscollit4;
	private JButton btnNumEscollit5;
	private JButton btnSuma;
	private JButton btnResta;
	private JButton btnMulti;
	private JButton btnDiv;

	// Añadido por mí
	private Random rand = new Random();
	private int objectiu = 0;
	private int num1, num2 = 0;
	private int numbtn1 = 0, numbtn2 = 0, numbtn3 = 0, numbtn4 = 0, numbtn5 = 0, numbtn6 = 0;
	private int numResu1 = 0, numResu2 = 0, numResu3 = 0, numResu4 = 0, numResu5 = 0;
	private boolean numbtn1act = false, numbtn2act = false, numbtn3act = false, numbtn4act = false, numbtn5act = false, numbtn6act = false;
	private boolean numResu1act = false,  numResu2act = false,  numResu3act = false,  numResu4act = false,  numResu5act = false;
	private int pasOperacio = 0;
	private int numOperacio = 1;
	private char operador;
	private int operacio = 0;
	private JTextField txtOperacio2;
	private JTextField txtOperacio3;
	private JTextField txtOperacio4;
	private JTextField txtOperacio5;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setResizable(false);
		
		setTitle("Xifres");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		txtObjectiu = new JTextField();
		txtObjectiu.setHorizontalAlignment(SwingConstants.CENTER);
		txtObjectiu.setEditable(false);
		txtObjectiu.setForeground(Color.BLACK);
		txtObjectiu.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtObjectiu.setText("Objectiu: ");
		txtObjectiu.setBorder(null);
		txtObjectiu.setColumns(10);
		
		
		objectiu = rand.nextInt(899) + 100;
		
		txtObjectiu.setText("Objectiu: "+objectiu);
		
		JButton btnNouEnigme = new JButton("Nou enigma");
		
		btnNouEnigme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				objectiu = rand.nextInt(899) + 100;
				
				txtObjectiu.setText("Objectiu: "+objectiu);
				
				btnNum1.setEnabled(true);
				btnNum2.setEnabled(true);
				btnNum3.setEnabled(true);
				btnNum4.setEnabled(true);
				btnNum5.setEnabled(true);
				btnNum6.setEnabled(true);
				
				num1 = 0;
				num2 = 0;
				operador = ' ';
				
				numbtn1 = numbtnrand(numbtn1);
				btnNum1.setText(""+numbtn1);
				
				numbtn2 = numbtnrand(numbtn2);
				btnNum2.setText(""+numbtn2);
				
				numbtn3 = numbtnrand(numbtn3);
				btnNum3.setText(""+numbtn3);
				
				numbtn4 = numbtnrand(numbtn4);				
				btnNum4.setText(""+numbtn4);
				
				numbtn5 = numbtnrand(numbtn5);
				btnNum5.setText(""+numbtn5);
				
				numbtn6 = numbtnrand(numbtn6);
				btnNum6.setText(""+numbtn6);
				
				numResu1 = 0;
				numResu2 = 0;
				numResu3 = 0;
				numResu4 = 0;
				numResu5 = 0;
				
				pasOperacio = 0;
				numOperacio = 1;
				operacio = 0;
				
				btnNumEscollit1.setText("?");
				btnNumEscollit1.setEnabled(false);
				
				btnNumEscollit2.setText("?");
				btnNumEscollit2.setEnabled(false);
				
				btnNumEscollit3.setText("?");
				btnNumEscollit3.setEnabled(false);
				
				btnNumEscollit4.setText("?");
				btnNumEscollit4.setEnabled(false);
				
				btnNumEscollit5.setText("?");
				btnNumEscollit5.setEnabled(false);
				
				txtOperacio1.setText("-");
				txtOperacio2.setText("-");
				txtOperacio3.setText("-");
				txtOperacio4.setText("-");
				txtOperacio5.setText("-");
				
			}
		});		
		
		JButton btnNetejaOperacions = new JButton("Neteja operacions");
		btnNetejaOperacions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtObjectiu.setText("Objectiu: "+objectiu);
				
				btnNum1.setEnabled(true);
				btnNum2.setEnabled(true);
				btnNum3.setEnabled(true);
				btnNum4.setEnabled(true);
				btnNum5.setEnabled(true);
				btnNum6.setEnabled(true);
				
				num1 = 0;
				num2 = 0;
				operador = ' ';
				
				numResu1 = 0;
				numResu2 = 0;
				numResu3 = 0;
				numResu4 = 0;
				numResu5 = 0;
				
				pasOperacio = 0;
				numOperacio = 1;
				operacio = 0;
				
				btnNumEscollit1.setText("?");
				btnNumEscollit1.setEnabled(false);
				
				btnNumEscollit2.setText("?");
				btnNumEscollit2.setEnabled(false);
				
				btnNumEscollit3.setText("?");
				btnNumEscollit3.setEnabled(false);
				
				btnNumEscollit4.setText("?");
				btnNumEscollit4.setEnabled(false);
				
				btnNumEscollit5.setText("?");
				btnNumEscollit5.setEnabled(false);
				
				txtOperacio1.setText("-");
				txtOperacio2.setText("-");
				txtOperacio3.setText("-");
				txtOperacio4.setText("-");
				txtOperacio5.setText("-");
			}
		});
		
	
		
		
		// BOTÓN NÚMERO 1
		btnNum1 = new JButton("");
		
		numbtn1 = numbtnrand(numbtn1);
		
		btnNum1.setText(""+numbtn1);
		
		btnNum1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				if (btnNum1.isEnabled()==false) {
		
					return;
				}
				
				if(pasOperacio == 0) {
				
					numbtn1act = true;
					
					pasOperacio0(btnNum1, numbtn1, numOperacio);
					
				}
				
				if(pasOperacio == 2) {
					
					numbtn1act = true;
					
					pasOperacio2(btnNum1, numbtn1, operador, numOperacio);
					
				}
			}
		});
		
		
		// BOTÓN NÚMERO 2
		btnNum2 = new JButton("");
		
		numbtn2 = numbtnrand(numbtn2);
		
		btnNum2.setText(""+numbtn2);
		
		btnNum2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (btnNum2.isEnabled()==false) {
					
					return;
				}
				
				if(pasOperacio == 0) {
					
					numbtn2act = true;
					
					pasOperacio0(btnNum2, numbtn2, numOperacio);
					
				}
				
				
				if(pasOperacio == 2) {
				
					numbtn2act = true;
					
					pasOperacio2(btnNum2, numbtn2, operador, numOperacio);
					
				}
			}
		});
		
		
		// BOTÓN NÚMERO 3
		btnNum3 = new JButton("");
		
		numbtn3 = numbtnrand(numbtn3);
		
		btnNum3.setText(""+numbtn3);
		
		btnNum3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (btnNum3.isEnabled()==false) {
					
					return;
				}
				
				if(pasOperacio == 0) {
					
					numbtn3act = true;
					
					pasOperacio0(btnNum3, numbtn3, numOperacio);
					
				}
				
				
				if(pasOperacio == 2) {
					
					numbtn3act = true;
				
					pasOperacio2(btnNum3, numbtn3, operador, numOperacio);
					
				}
			}
		});
		
		// BOTÓN NÚMERO 4
		btnNum4 = new JButton("");
		
		numbtn4 = numbtnrand(numbtn4);
		
		btnNum4.setText(""+numbtn4);
		
		btnNum4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (btnNum4.isEnabled()==false) {
					
					return;
				}
				
				if(pasOperacio == 0) {
					
					numbtn4act = true;
					
					pasOperacio0(btnNum4, numbtn4, numOperacio);
					
				}
				
				
				if(pasOperacio == 2) {
				
					numbtn4act = true;
					
					pasOperacio2(btnNum4, numbtn4, operador, numOperacio);
			
				}
			}
		});
		
		
		// BOTÓN NÚMERO 5
		btnNum5 = new JButton("");
		
		numbtn5 = numbtnrand(numbtn5);
		
		btnNum5.setText(""+numbtn5);
		
		btnNum5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (btnNum5.isEnabled()==false) {
					
					return;
				}
				
				if(pasOperacio == 0) {
					
					numbtn5act = true;
					
					pasOperacio0(btnNum5, numbtn5, numOperacio);
					
				}
				
				
				if(pasOperacio == 2) {
				
					numbtn5act = true;
					
					pasOperacio2(btnNum5, numbtn5, operador, numOperacio);
					
				}
			}
		});
		
		
		// BOTÓN NÚMERO 6
		btnNum6 = new JButton("");
		
		numbtn6 = numbtnrand(numbtn6);
		
		btnNum6.setText(""+numbtn6);
		
		btnNum6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (btnNum6.isEnabled()==false) {
					
					return;
				}
				
				if(pasOperacio == 0) {
					
					numbtn6act = true;
					
					pasOperacio0(btnNum6, numbtn6, numOperacio);
					
				}
				
				
				if(pasOperacio == 2) {
				
					numbtn6act = true;
					
					pasOperacio2(btnNum6, numbtn6, operador, numOperacio);
					
				}
			}
		});
		
		
		 
		txtOperacio1 = new JTextField();
		txtOperacio1.setHorizontalAlignment(SwingConstants.CENTER);
		txtOperacio1.setText("-");
		txtOperacio1.setForeground(Color.BLACK);
		txtOperacio1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtOperacio1.setEditable(false);
		txtOperacio1.setColumns(10);
		txtOperacio1.setBorder(null);
		
		txtResultat = new JTextField();
		txtResultat.setForeground(Color.BLACK);
		txtResultat.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtResultat.setEditable(false);
		txtResultat.setColumns(10);
		txtResultat.setBorder(null);
		
		
		// BOTÓN RESULTAT 1
		btnNumEscollit1 = new JButton("?");
		btnNumEscollit1.setEnabled(false);
					
		btnNumEscollit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				if (btnNumEscollit1.isEnabled()==false) {
					
					return;
				}
				
				if(pasOperacio == 0) {
					
					numResu1act = true;
					
					pasOperacio0(btnNumEscollit1, numResu1, numOperacio);
				}
				
				
				if(pasOperacio == 2) {
					
					numResu1act = true;
					
					pasOperacio2(btnNumEscollit1, numResu1, operador, numOperacio);
					
				}
				
				btnNumEscollit1.setEnabled(false);
			}
		});
		
		
		
		// BOTÓN RESULTAT 2
		btnNumEscollit2 = new JButton("?");
		btnNumEscollit2.setEnabled(false);
		
		btnNumEscollit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(pasOperacio == 0) {
					
					numResu2act = true;
					
					pasOperacio0(btnNumEscollit2, numResu2, numOperacio);
					
				}
				
				
				if(pasOperacio == 2) {
					
					numResu2act = true;
				
					pasOperacio2(btnNumEscollit2, numResu2, operador, numOperacio);			
				}
			}
		});
		
		
		// BOTÓN RESULTAT 3
		btnNumEscollit3 = new JButton("?");
		btnNumEscollit3.setEnabled(false);
		
		btnNumEscollit3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(pasOperacio == 0) {
					
					numResu3act = true;
					
					pasOperacio0(btnNumEscollit3, numResu3, numOperacio);
					
				}
				
				
				if(pasOperacio == 2) {
				
					numResu3act = true;
					
					pasOperacio2(btnNumEscollit3, numResu3, operador, numOperacio);			
				}
			}
		});
		
		
		// BOTÓN RESULTAT 4
		btnNumEscollit4 = new JButton("?");
		btnNumEscollit4.setEnabled(false);
		
		btnNumEscollit4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(pasOperacio == 0) {
					
					numResu4act = true;
					
					pasOperacio0(btnNumEscollit4, numResu4, numOperacio);
					
				}
				
				
				if(pasOperacio == 2) {
				
					numResu4act = true;
					
					pasOperacio2(btnNumEscollit4, numResu4, operador, numOperacio);			
				}
			}
		});
		
		
		// BOTÓN RESULTAT 5
		btnNumEscollit5 = new JButton("?");
		btnNumEscollit5.setEnabled(false);
		
		btnNumEscollit5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(pasOperacio == 0) {
					
					numResu5act = true;
					
					pasOperacio0(btnNumEscollit5, numResu5, numOperacio);
				}
				
				
				if(pasOperacio == 2) {
				
					numResu5act = true;
					
					pasOperacio2(btnNumEscollit5, numResu5, operador, numOperacio);			
				}
			}
		});
		
		
		// BOTÓN SUMA
		btnSuma = new JButton("+");
		
		btnSuma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(pasOperacio == 0) {
				
				}
				
				else if(pasOperacio == 1) {
					
					operador = '+';
					
					numOperacio(num1, operador, 0, pasOperacio, numOperacio);
					
					pasOperacio = 2;
					
				}
			}
		});
		
		
		// BOTÓN RESTA
		btnResta = new JButton("-");
		
		btnResta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(pasOperacio == 0) {
				
				}
				
				else if(pasOperacio == 1) {
					
					operador = '-';
					
					numOperacio(num1, operador, 0, pasOperacio, numOperacio);
					
					pasOperacio = 2;
					
				}
			}
		});
		
		
		// BOTÓN MULTI
		btnMulti = new JButton("*");
		
		btnMulti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(pasOperacio == 0) {
				
				}
				
				else if(pasOperacio == 1) {
					
					operador = '*';
					
					numOperacio(num1, operador, 0, pasOperacio, numOperacio);
					
					pasOperacio = 2;
					
				}
			}
		});
		
		// BOTÓN DIVI
		btnDiv = new JButton("/");
		
		btnDiv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(pasOperacio == 0) {
				
				}
				
				else if(pasOperacio == 1) {
					
					operador = '/';
					
					numOperacio(num1, operador, 0, pasOperacio, numOperacio);
					
					pasOperacio = 2;
					
				}
			}
		});
		
		txtOperacio2 = new JTextField();
		txtOperacio2.setHorizontalAlignment(SwingConstants.CENTER);
		txtOperacio2.setText("-");
		txtOperacio2.setForeground(Color.BLACK);
		txtOperacio2.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtOperacio2.setEditable(false);
		txtOperacio2.setColumns(10);
		txtOperacio2.setBorder(null);
		
		txtOperacio3 = new JTextField();
		txtOperacio3.setHorizontalAlignment(SwingConstants.CENTER);
		txtOperacio3.setText("-");
		txtOperacio3.setForeground(Color.BLACK);
		txtOperacio3.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtOperacio3.setEditable(false);
		txtOperacio3.setColumns(10);
		txtOperacio3.setBorder(null);
		
		txtOperacio4 = new JTextField();
		txtOperacio4.setHorizontalAlignment(SwingConstants.CENTER);
		txtOperacio4.setText("-");
		txtOperacio4.setForeground(Color.BLACK);
		txtOperacio4.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtOperacio4.setEditable(false);
		txtOperacio4.setColumns(10);
		txtOperacio4.setBorder(null);
		
		txtOperacio5 = new JTextField();
		txtOperacio5.setHorizontalAlignment(SwingConstants.CENTER);
		txtOperacio5.setText("-");
		txtOperacio5.setForeground(Color.BLACK);
		txtOperacio5.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtOperacio5.setEditable(false);
		txtOperacio5.setColumns(10);
		txtOperacio5.setBorder(null);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addComponent(btnSuma, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnResta, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnMulti, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDiv, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addComponent(btnNouEnigme, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNetejaOperacions, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addGap(8))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNum1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNum2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNum3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNum4, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNum5, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNum6, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
							.addGap(55)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(txtOperacio1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(27)
											.addComponent(txtResultat, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtOperacio4, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtOperacio2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtOperacio3, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNumEscollit2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNumEscollit1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNumEscollit3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNumEscollit4, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNumEscollit5, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
								.addComponent(txtOperacio5, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(152, Short.MAX_VALUE)
					.addComponent(txtObjectiu, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(123))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNouEnigme)
						.addComponent(btnNetejaOperacions))
					.addGap(18)
					.addComponent(txtObjectiu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNum1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtResultat, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtOperacio1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNum2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtOperacio2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNum3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNum4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtOperacio3, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
									.addGap(39)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNum5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNum6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtOperacio5, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
								.addComponent(txtOperacio4, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNumEscollit1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNumEscollit2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNumEscollit3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNumEscollit4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNumEscollit5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDiv, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMulti, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnResta, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSuma, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public int numbtnrand(int num) {
		
		int numopcio = rand.nextInt(5) + 1;
		
		switch(numopcio) {
		
			case 1:
				num = rand.nextInt(10) + 1;
				break;
		
			case 2:
				num = 25;
				break;
		
			case 3:
				num = 50;
				break;
		
			case 4:
				num = 75;
				break;
			
			case 5:
				num = 100;
				break;
		
		}
		
		return num;
	}
	
	public void pasOperacio0(JButton btnNum, int numbtn, int numOperacio) {
		
		num1 = numbtn;
		
		numOperacio(num1, ' ', 0, pasOperacio, numOperacio);
			
		btnNum.setEnabled(false);
			
		pasOperacio = 1;
		
		
	}


	public void pasOperacio2(JButton btnNum, int numbtn, char operador, int numOperacio) {
		
		num2 = numbtn;
		
		if(operador == '+') {
			operacio = num1 + num2;
		}
		
		else if(operador == '-') {
			operacio = num1 - num2;
		}
		
		else if(operador == '*') {
			operacio = num1 * num2;
		}
		
		else if(operador == '/') {
			operacio = num1 / num2;
		}
		
		if(operacio < 0 || operador == '/' && num1 % num2 != 0) {
			pasOperacio = 3;
			numOperacio(num1, operador, num2, pasOperacio, numOperacio);
			
			if(numbtn1act == true) {
				btnNum1.setEnabled(true);
			}
			
			if(numbtn2act == true) {
				btnNum2.setEnabled(true);
			}
			
			if(numbtn3act == true) {
				btnNum3.setEnabled(true);
			}
			
			if(numbtn4act == true) {
				btnNum4.setEnabled(true);
			}
			
			if(numbtn5act == true) {
				btnNum5.setEnabled(true);
			}
			
			if(numbtn6act == true) {
				btnNum6.setEnabled(true);
			}

			if(numResu1act == true) {
				btnNumEscollit1.setEnabled(true);
			}
			
			if(numResu2act == true) {
				btnNumEscollit2.setEnabled(true);
			}
			
			if(numResu3act == true) {
				btnNumEscollit3.setEnabled(true);
			}
			
			if(numResu4act == true) {
				btnNumEscollit4.setEnabled(true);
			}
			
			if(numResu5act == true) {
				btnNumEscollit5.setEnabled(true);
			}
			
			num1 = 0;
			num2 = 0;
			
			pasOperacio = 0;
		}
		
		else if(operacio == objectiu) {
			txtObjectiu.setText("S'ha assolit l'objectiu!");
			
			numOperacio(num1, operador, num2, pasOperacio, numOperacio);
			
			btnNum1.setEnabled(false);
			btnNum2.setEnabled(false);
			btnNum3.setEnabled(false);
			btnNum4.setEnabled(false);
			btnNum5.setEnabled(false);
			btnNum6.setEnabled(false);
			btnNumEscollit1.setEnabled(false);
			btnNumEscollit2.setEnabled(false);
			btnNumEscollit3.setEnabled(false);
			btnNumEscollit4.setEnabled(false);
			btnNumEscollit5.setEnabled(false);
			btnSuma.setEnabled(false);
			btnResta.setEnabled(false);
			btnMulti.setEnabled(false);
			btnDiv.setEnabled(false);
		}
		
		else {
		
		numOperacio(num1, operador, num2, pasOperacio, numOperacio);
		
		btnNum.setEnabled(false);

		pasOperacio = 0;
		
		}
		
	}
	
	public void numOperacio(int num1, char operador, int num2, int pasOperacio, int numOperacio) {
		
		if(numOperacio == 1) {
			
			if(pasOperacio == 0) {
				txtOperacio1.setText(num1 + " ");
			}
			
			else if(pasOperacio == 1) {
				txtOperacio1.setText(num1 +" "+ operador+" ");
			}
			
			else if(pasOperacio == 2) {
				
				txtOperacio1.setText(num1 +" "+ operador+" "+num2+" = "+operacio);
				
				numResu1 = operacio;
				
				btnNumEscollit1.setText(""+numResu1);
				
				btnNumEscollit1.setEnabled(true);
				
				this.pasOperacio = 0;
				
				this.numOperacio = 2;
			
				numbtn1act = false;				
				numbtn2act = false;
				numbtn3act = false;
				numbtn4act = false;
				numbtn5act = false;
				numbtn6act = false;
				
			}
			
			else if(pasOperacio == 3) {
				txtOperacio1.setText("Operació no vàlida.");
			}
		}
		
		
		else if(numOperacio == 2) {
			
			if(pasOperacio == 0) {
				txtOperacio2.setText(num1 + " ");
			}
			
			else if(pasOperacio == 1) {
				txtOperacio2.setText(num1 +" "+ operador+" ");
			}
			
			else if(pasOperacio == 2) {
				
				txtOperacio2.setText(num1 +" "+ operador+" "+num2+" = "+operacio);
				
				numResu2 = operacio;
				
				btnNumEscollit2.setText(""+numResu2);
				
				btnNumEscollit2.setEnabled(true);
				
				this.pasOperacio = 0;
				
				this.numOperacio = 3;
				
				numbtn1act = false;				
				numbtn2act = false;
				numbtn3act = false;
				numbtn4act = false;
				numbtn5act = false;
				numbtn6act = false;
				
				numResu1act = false;
			}
			
			else if(pasOperacio == 3) {
				txtOperacio2.setText("Operació no vàlida.");
			}
		}
		
		else if(numOperacio == 3) {
			
			if(pasOperacio == 0) {
				txtOperacio3.setText(num1 + " ");
			}
			
			else if(pasOperacio == 1) {
				txtOperacio3.setText(num1 +" "+ operador+" ");
			}
			
			else if(pasOperacio == 2) {
				txtOperacio3.setText(num1 +" "+ operador+" "+num2+" = "+operacio);
				
				numResu3 = operacio;
				
				btnNumEscollit3.setText(""+numResu3);
				
				btnNumEscollit3.setEnabled(true);
				
				this.pasOperacio = 0;
				
				this.numOperacio = 4;
				
				numbtn1act = false;				
				numbtn2act = false;
				numbtn3act = false;
				numbtn4act = false;
				numbtn5act = false;
				numbtn6act = false;
				
				numResu1act = false;
				numResu2act = false;
			}
			
			else if(pasOperacio == 3) {
				txtOperacio3.setText("Operació no vàlida.");
			}
		}
		
		else if(numOperacio == 4) {
			
			if(pasOperacio == 0) {
				txtOperacio4.setText(num1 + " ");
			}
			
			else if(pasOperacio == 1) {
				txtOperacio4.setText(num1 +" "+ operador+" ");
			}
			
			else if(pasOperacio == 2) {
				txtOperacio4.setText(num1 +" "+ operador+" "+num2+" = "+operacio);
				
				numResu4 = operacio;
				
				btnNumEscollit4.setText(""+numResu4);
				
				btnNumEscollit4.setEnabled(true);
				
				this.pasOperacio = 0;
				
				this.numOperacio = 5;
				
				numbtn1act = false;				
				numbtn2act = false;
				numbtn3act = false;
				numbtn4act = false;
				numbtn5act = false;
				numbtn6act = false;
				
				numResu1act = false;
				numResu2act = false;
				numResu3act = false;
			}
			
			else if(pasOperacio == 3) {
				txtOperacio4.setText("Operació no vàlida.");
			}
		}
		
		else if(numOperacio == 5) {
	
			if(pasOperacio == 0) {
				txtOperacio5.setText(num1 + " ");
			}
			
			else if(pasOperacio == 1) {
				txtOperacio5.setText(num1 +" "+ operador+" ");
			}
			
			else if(pasOperacio == 2) {
				txtOperacio5.setText(num1 +" "+ operador+" "+num2+" = "+operacio);
				
				numResu5 = operacio;
				
				btnNumEscollit5.setText(""+numResu5);
				
				txtObjectiu.setText("S'han esgotat els números...");
				
				btnNumEscollit5.setEnabled(true);
				
				this.pasOperacio = 0;
				
				this.numOperacio = 6;
				
				numbtn1act = false;				
				numbtn2act = false;
				numbtn3act = false;
				numbtn4act = false;
				numbtn5act = false;
				numbtn6act = false;
				
				numResu1act = false;
				numResu2act = false;
				numResu3act = false;
				numResu4act = false;
			}
			
			else if(pasOperacio == 3) {
				txtOperacio5.setText("Operació no vàlida.");
			}
		}
		
	}
}
