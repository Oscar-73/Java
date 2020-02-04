import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class controls extends JPanel implements KeyListener, ActionListener { // Amb aquestes dues implementacions, fem que el programa pugui rebre per teclat
	
	private static final String EXIT_ON_CLOSE = null;
	String color; // Variable que rep el seu valor per par�metre desde opcions i amb la qual seleccionem el color de la serp
	boolean carnivora = false, vegetariana = false, omnivora = false; // Variables boolean que determinar�n el menjar que sortir�
	
	int num = 0; // Valor random que har� apar�ixer un menjar o altre	
	
	private BufferedImage img = null; // Variable amb la que agafem la imatge
	private Image imgres; // Variable amb la que redimensionem la imatge
	
	private int puntuacio = 0; // Variable que controla la puntuaci� del jugador
	private String nomjugador; // Variable que cont� el nom del jugador
	
	private static Clip clip; // Fem la variable clip global perque aix�, al reiniciar la partida, poguem parar la m�sica des d'un altre m�tode 
	private static Clip clipfi;
	
	// Mida serp
	private int[] longXserp = new int[750];
	private int[] longYserp = new int[750];
	
	// Longitut inicial de la serp
	private int serplong = 3;
	
	// Moviments que fem
	private int moviments = 0;
	
	// Controls
	private boolean esquerra = false;
	private boolean dreta = false;
	private boolean amunt = false;
	private boolean avall = false;
	
	// Gr�fics de moviment
	private ImageIcon serpesquerra;
	private ImageIcon serpdreta;
	private ImageIcon serpamunt;
	private ImageIcon serpavall;
	
	private Timer timer;
	private int velocitatserp = 100;
	private ImageIcon serp;
	
	private int[] posXmenjar= {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, // Posicions horizontals on podr� apar�ixer aleatoriament el menjar 
							   350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625,
							   650, 675, 700, 725, 750, 775, 800, 825, 850};
	
	private int[] posYmenjar= {75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, // Posicions verticals on podr� apar�ixer aleatoriament el menjar
			   				   350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 
			   				   625};
	
	private ImageIcon menjar;
	
	private Random rand = new Random();
	private int menjarx = rand.nextInt(34); // Random entre les 34 posicions horizontals
	private int menjary = rand.nextInt(23); // Random entre les 23 posicions verticals
	
	
	public controls(String nomjugador, boolean verd, boolean blau, boolean vermell, boolean carnivora, boolean vegetariana, boolean omnivora) {
		
		this.musica(); // Amb aix� fem que al iniciar-se el joc, comenci la m�sica
		
		
		// Llegim la imatge i la redimensionem
		try {
		    img = ImageIO.read(new File("src/grafics/fons.jpg"));
		    imgres = img.getScaledInstance(905, 700, Image.SCALE_DEFAULT);
		    
		} catch (IOException e) {
		    e.printStackTrace();
		}

		
		this.nomjugador = nomjugador;
		
		if(verd == true) {
			color = "verd";
		}
		
		else if(blau == true) {
			color = "blau";
		}
		
		else if(vermell == true) {
			color = "vermell";
		}
		
		
		if(carnivora == true) {
			this.carnivora = true;
			num = 6; // Menjar inicial si �s carn�vora
		}
		
		else if(vegetariana == true) {
			this.vegetariana = true;
			num = 1; // Menjar inicial si �s vegetariana
		}
		
		else if(omnivora == true) {
			this.omnivora = true;
			num = rand.nextInt(10)+1; // El menjar inicial �s qualsevol
		}
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(velocitatserp, this);
		timer.start();
	}
	
	
	@Override
	public void paintComponent(Graphics g) { // M�tode amb el que imprimim per pantalla els diferents components dels que est� fet la serp. Ha d'anomenar-se "paintComponent", o si no, no funcionar�
		
		super.paintComponent(g); // Cridem al m�tode super per a que els gr�fics de la serp al moure's, es vagin actualitzant i no deixi un rastre
		
		g.drawImage(imgres, 0, 0, this); // Rebem la imatge redimensionada 
		
		if(moviments == 0) {
			
			longXserp[2] = 50;
			longXserp[1] = 75;
			longXserp[0] = 100;
			
			longYserp[2] = 100;
			longYserp[1] = 100;
			longYserp[0] = 100;
		}
		
		
		// Amb aix� mostrem el nom del jugador per pantalla
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Jugador: "+nomjugador, 50, 50);
		
		
		// Amb aix� mostrem la puntuaci� per pantalla
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Puntuaci�: "+puntuacio, 400, 50);
		
		// Amb aix� mostrem la longitud de la serp per pantalla
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Longitud: "+serplong, 600, 50);
		
		serpdreta = new ImageIcon("src/grafics/serpdreta"+color+".png");
		serpdreta.paintIcon(this, g, longXserp[0], longYserp[0]);
		
		for(int a = 0; a < serplong; a++) {
			
			if(a == 0 && esquerra) {
				
				serpesquerra = new ImageIcon("src/grafics/serpesquerra"+color+".png");
				serpesquerra.paintIcon(this, g, longXserp[a], longYserp[a]);
			}
			
			if(a == 0 && dreta) {
				
				serpdreta = new ImageIcon("src/grafics/serpdreta"+color+".png");
				serpdreta.paintIcon(this, g, longXserp[a], longYserp[a]);
			}
			
			if(a == 0 && amunt) {
				
				serpamunt = new ImageIcon("src/grafics/serpamunt"+color+".png");
				serpamunt.paintIcon(this, g, longXserp[a], longYserp[a]);
			}
			
			if(a == 0 && avall) {
				
				serpavall = new ImageIcon("src/grafics/serpavall"+color+".png");
				serpavall.paintIcon(this, g, longXserp[a], longYserp[a]);
			}
			
			if(a != 0) {
				serp = new ImageIcon("src/grafics/serp"+color+".png");
				serp.paintIcon(this, g, longXserp[a], longYserp[a]);
			}
			

			
			if((posXmenjar[menjarx]) == longXserp[0] && posYmenjar[menjary] == longYserp[0]) { // Si la serp toca menjar, la seva mida aumenta en 1 i es torna a generar una posici� aleatoria per al menjar
				
				this.menjarso(); // Amb aix� fem que al menjar, es reprodueixi un so
				
				serplong++;
				
				if(carnivora == true) {
					
					if(num == 6) {
						puntuacio++;
					}
					
					else if(num == 7) {
						puntuacio += 2;
					}
					
					else if(num == 8) {
						puntuacio += 3;
					}
					
					else if(num == 9) {
						puntuacio += 4;
					}
					
					else if(num == 10) {
						puntuacio += 5;
					}
					
					num = rand.nextInt(5)+6; // Fem que al menjar, el seguent gr�fic sigui aleatori
					
				}
				
				else if(vegetariana == true) {
					
					if(num == 1) { 
						puntuacio += 1;
					}
					
					else if(num == 2) {
						puntuacio += 2;
					}
					
					else if(num == 3) {
						puntuacio += 3;
					}
					
					else if(num == 4) {
						puntuacio += 4;
					}
					
					else if(num == 5) {
						puntuacio += 5;
					}
					
					num = rand.nextInt(5)+1;
					
				}
				
				else if(omnivora == true) {
					
					if(num == 1) { 
						puntuacio++;
					}
					
					else if(num == 2) {
						puntuacio += 2;
					}
					
					else if(num == 3) {
						puntuacio += 3;
					}
					
					else if(num == 4) {
						puntuacio += 4;
					}
					
					else if(num == 5) {
						puntuacio += 5;
					}
					
					else if(num == 6) {
						puntuacio++;
					}
					
					else if(num == 7) {
						puntuacio += 2;
					}
					
					else if(num == 8) {
						puntuacio += 3;
					}
					
					else if(num == 9) {
						puntuacio += 4;
					}
					
					else if(num == 10) {
						puntuacio += 5;
					}
					
					num = rand.nextInt(10)+1;
				}
				
				menjarx = rand.nextInt(34);
				menjary = rand.nextInt(23);
			}
			
			menjar = new ImageIcon("src/grafics/menjar"+num+".png");
			menjar.paintIcon(this, g, posXmenjar[menjarx], posYmenjar[menjary]);
			
			for(int b = 1; b < serplong; b++) {
				
				if(longXserp[b] == longXserp[0] && longYserp[b] == longYserp[0]) {
				
					amunt = false;
					avall = false;
					dreta = false;
					esquerra = false;
					
					clip.stop();
					
					try {
						clipfi.stop();
					}catch(NullPointerException aa) {
						
					}
					
					fideljocso();
					
					g.setColor(Color.WHITE);
					g.setFont(new Font("Arial", Font.BOLD, 50));
					g.drawString("Fi del joc", 350, 300);
					
					
					g.setFont(new Font("Arial", Font.BOLD, 20));
					g.drawString("Prem espai per reiniciar.", 350, 340);
					
				}
			}
			
		}
	
		g.dispose();
	}

	
	@Override
	public void keyPressed(KeyEvent ke) {
		
		if(ke.getKeyCode() == KeyEvent.VK_SPACE){ // Prement espai es reinicia el joc
			moviments = 0;
			puntuacio = 0;
			serplong = 3;
			repaint();
			
			try {
				clipfi.stop(); // D'aquesta forma, fem que si l'usuari reinicia abans de morir, no peti aquesta variable
				
			}catch(NullPointerException a) {
				
			}
			
			clip.stop();
			
			musica();
			menjarx = rand.nextInt(34);
			menjary = rand.nextInt(23);
		}
		
		if(ke.getKeyCode() == KeyEvent.VK_RIGHT){ // Si polses la tecla X, la seva variable boolean es posa en true
			moviments++;
			dreta = true;
			
			if(!esquerra) {
				dreta = true;
			}
			
			else {
				dreta = false;
				esquerra = true;
			}
		
			amunt = false;
			avall = false;
		}
		
		if(ke.getKeyCode() == KeyEvent.VK_LEFT){
			moviments++;
			esquerra = true;
			
			if(!dreta) {
				esquerra = true;
			}
			
			else {
				esquerra = false;
				dreta = true;
			}
		
			amunt = false;
			avall = false;
		}
		
		if(ke.getKeyCode() == KeyEvent.VK_UP){
			moviments++;
			amunt = true;
			
			if(!avall) {
				amunt = true;
			}
			
			else {
				amunt = false;
				avall = true;
			}
		
			esquerra = false;
			dreta = false;
		}
		
		if(ke.getKeyCode() == KeyEvent.VK_DOWN){
			moviments++;
			avall = true;
			
			if(!amunt) {
				avall = true;
			}
			
			else {
				amunt = true;
				avall = false;
			}
		
			esquerra = false;
			dreta = false;
		}

	}
	@Override
	public void keyReleased(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		timer.start();
		
		if(dreta) {
			
			for(int d = serplong-1; d>=0; d--) {
				longYserp[d+1] = longYserp[d];
			}
			
			for(int e = serplong; e>= 0; e--) {
				if(e==0) {
					longXserp[e] = longXserp[e] + 25;
				}
				
				else {
					longXserp[e] = longXserp[e-1];
				}
				
				if(longXserp[e] > 850) {
					longXserp[e] = 25;
					
				}
			}
			
			repaint(); // M�tode per refrescar els gr�fics tornant a cridar al m�tode paintComponent(). Es usa quan es realitzan canvis sobre els gr�fics
		}
		
		if(esquerra) {
			
			for(int d = serplong-1; d>=0; d--) {
				longYserp[d+1] = longYserp[d];
			}
			
			for(int d = serplong; d>= 0; d--) {
				if(d==0) {
					longXserp[d] = longXserp[d] - 25;
				}
				
				else {
					longXserp[d] = longXserp[d-1];
				}
				
				if(longXserp[d] < 25) {
					longXserp[d] = 850;
					
				}
			}
			
			repaint();
		}
		
		if(amunt) {
			
			for(int d = serplong-1; d>=0; d--) {
				longXserp[d+1] = longXserp[d];
			}
			
			for(int d = serplong; d>= 0; d--) {
				if(d==0) {
					longYserp[d] = longYserp[d] - 25;
				}
				
				else {
					longYserp[d] = longYserp[d-1];
				}
				
				if(longYserp[d] < 75) {
					longYserp[d] = 625;
					
				}
			}
			
			repaint();
		}
		
		if(avall) {
			
			for(int d = serplong-1; d>=0; d--) {
				longXserp[d+1] = longXserp[d];
			}
			
			for(int d = serplong; d>= 0; d--) {
				if(d==0) {
					longYserp[d] = longYserp[d] + 25;
				}
				
				else {
					longYserp[d] = longYserp[d-1];
				}
				
				if(longYserp[d] > 625) {
					longYserp[d] = 75;
					
				}
			}
			
			repaint();
		}
		
	}
	
	public static void musica() { // M�tode que reprodueix la m�sica
		  try {
			   File file = new File("src/so/musica.wav");
			   clip = AudioSystem.getClip();
			   clip.open(AudioSystem.getAudioInputStream(file));
			   clip.start();
		  
		  } catch (Exception e) {
		   
			  System.err.println(e.getMessage());
		  }
	}
	
	public static void menjarso() { // M�tode que reprodueix el so de menjar
		  try {
			   File file = new File("src/so/menjar.wav");
			   Clip clip = AudioSystem.getClip();
			   clip.open(AudioSystem.getAudioInputStream(file));
			   clip.start();
		  
		  } catch (Exception e) {
		   
			  System.err.println(e.getMessage());
		  }
	}
	
	public static void fideljocso() { // M�tode que reprodueix un so al morir
		  try {
			   File file = new File("src/so/fideljoc.wav");
			   clipfi = AudioSystem.getClip();
			   clipfi.open(AudioSystem.getAudioInputStream(file));
			   clipfi.start();
		  
		  } catch (Exception e) {
		   
			  System.err.println(e.getMessage());
		  }
	}

}

