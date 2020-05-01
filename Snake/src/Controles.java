import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.Timer;

// Implementando estas dos interfaces, hacemos que el programa detecte pulsaciones por teclado
public class Controles extends JPanel implements KeyListener, ActionListener {
	private static final String EXIT_ON_CLOSE = null;
	
	// Variables que recibirán su valor con lo configurado en OpcionesIniciales
	String color, nombreJugador;
	boolean carnivora = false, vegetariana = false, omnivora = false;
	
	int num = 0; // Valor aleatorio que decidirá la comida	
	
	private BufferedImage imgFondo = null; // Imagen de fondo
	private Image imgFondoRes; // Imagen de fondo redimensionada
	
	private int puntuacion = 0; // Variable que controla la puntuación del jugador	
	
	private static Clip clip; // Fem la variable clip global perque així, al reiniciar la partida, poguem parar la música des d'un altre mètode 
	private static Clip clipfi;
	
	// Medidas serpiente
	private int[] longXserp = new int[750];
	private int[] longYserp = new int[750];
	
	// Longitud inicial de la serpiente
	private int serplong = 3;
	
	// Variable que almacena el número de movimientos que hagamos
	private int moviments = 0;
	
	// Controles
	private boolean izquierda = false;
	private boolean derecha = false;
	private boolean arriba = false;
	private boolean abajo = false;
	
	// Gráficos de movimiento
	private ImageIcon serpIzquierda;
	private ImageIcon serpDerecha;
	private ImageIcon serpArriba;
	private ImageIcon serpAbajo;
	
	private Timer timer; // Variable que funciona como "background thread" y usaremos para refrescar los gráficos de la serpiente, logrando que esta se mueva
	private int velocidadSerp = 100; // Usaremos esta variable para ajustar la velocidad de refresco del Timer y a su vez, la velocidad de movimiento de la serpiente
	private ImageIcon serp;
	
	// Posiciones horizontales en las que podrá aparecer aleatoriamente la comida
	private int[] posXcomida= {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 
							   350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625,
							   650, 675, 700, 725, 750, 775, 800, 825, 850};
	
	// Posiciones verticals en las que podrá aparecer aleatoriamente la comida
	private int[] posYcomida= {75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325,
			   				   350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 
			   				   625};
	
	private ImageIcon comida;
	
	private Random rand = new Random();
	private int comidaX = rand.nextInt(34); // Random entre les 34 posiciones horizontales
	private int comidaY = rand.nextInt(23); // Random entre les 23 posiciones verticales
	
	// Método inicial al cual llamamos en OpcionesIniciales
	public Controles(String nombreJugador, boolean verde, boolean azul, boolean rojo, boolean carnivora, boolean vegetariana, boolean omnivora) {
		musica(); // Hacemos que se reproduzca la música en cuanto inicia la partida
		
		// Leemos la imagen de fondo y la redimensionamos
		try {
			imgFondo = ImageIO.read(new File("src/graficos/fondo.jpg"));
			imgFondoRes = imgFondo.getScaledInstance(905, 700, Image.SCALE_DEFAULT);
		    
		} catch (IOException e) {
		    e.printStackTrace();
		}

		// Recogemos los valores enviados desde OpcionesIniciales
		this.nombreJugador = nombreJugador;
		
		if(verde == true)
			color = "verde";
		else if(azul == true)
			color = "azul";
		else if(rojo == true)
			color = "rojo";
		
		if(carnivora == true) {
			this.carnivora = true;
			num = 6; // Comida inicial si es carnívora
		}
		else if(vegetariana == true) {
			this.vegetariana = true;
			num = 1; // Comida inicial si es vegetariana
		}
		else if(omnivora == true) {
			this.omnivora = true;
			num = rand.nextInt(10)+1; // Si es omnívora, la comida inicial es aleatoria
		}
		
		// Añadimos el Listener para que detecte las pulsaciones por teclado
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(velocidadSerp, this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) { // Mètode amb el que imprimim per pantalla els diferents components dels que està fet la serp. Ha d'anomenar-se "paintComponent", o si no, no funcionarà
		
		super.paintComponent(g); // Cridem al mètode super per a que els gràfics de la serp al moure's, es vagin actualitzant i no deixi un rastre
		
		g.drawImage(imgFondoRes, 0, 0, this); // Rebem la imatge redimensionada 
		
		if(moviments == 0) {
			longXserp[2] = 50;
			longXserp[1] = 75;
			longXserp[0] = 100;
			
			longYserp[2] = 100;
			longYserp[1] = 100;
			longYserp[0] = 100;
		}
		
		// Amb això mostrem el nom del jugador per pantalla
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Jugador: "+nombreJugador, 50, 50);
		
		// Amb això mostrem la puntuació per pantalla
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Puntuació: "+puntuacion, 400, 50);
		
		// Amb això mostrem la longitud de la serp per pantalla
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Longitud: "+serplong, 600, 50);
		
		serpDerecha = new ImageIcon("src/grafics/serpDerecha"+color+".png");
		serpDerecha.paintIcon(this, g, longXserp[0], longYserp[0]);
		
		for(int a = 0; a < serplong; a++) {
			
			if(a == 0 && izquierda) {
				
				serpIzquierda = new ImageIcon("src/grafics/serpIzquierda"+color+".png");
				serpIzquierda.paintIcon(this, g, longXserp[a], longYserp[a]);
			}
			
			if(a == 0 && derecha) {
				
				serpDerecha = new ImageIcon("src/grafics/serpDerecha"+color+".png");
				serpDerecha.paintIcon(this, g, longXserp[a], longYserp[a]);
			}
			
			if(a == 0 && arriba) {
				
				serpArriba = new ImageIcon("src/grafics/serpArriba"+color+".png");
				serpArriba.paintIcon(this, g, longXserp[a], longYserp[a]);
			}
			
			if(a == 0 && abajo) {
				
				serpAbajo = new ImageIcon("src/grafics/serpAbajo"+color+".png");
				serpAbajo.paintIcon(this, g, longXserp[a], longYserp[a]);
			}
			
			if(a != 0) {
				serp = new ImageIcon("src/grafics/serp"+color+".png");
				serp.paintIcon(this, g, longXserp[a], longYserp[a]);
			}
			

			
			if((posXcomida[comidaX]) == longXserp[0] && posYcomida[comidaY] == longYserp[0]) { // Si la serp toca menjar, la seva mida aumenta en 1 i es torna a generar una posició aleatoria per al menjar
				sonidoComer(); // Amb això fem que al menjar, es reprodueixi un so
				serplong++;
				
				if(carnivora == true) {					
					if(num == 6)
						puntuacion++;
					else if(num == 7)
						puntuacion += 2;
					else if(num == 8)
						puntuacion += 3;
					else if(num == 9)
						puntuacion += 4;
					else if(num == 10)
						puntuacion += 5;

					num = rand.nextInt(5)+6; // Fem que al menjar, el seguent gràfic sigui aleatori
				}
				
				else if(vegetariana == true) {
					if(num == 1) 
						puntuacion += 1;
					else if(num == 2)
						puntuacion += 2;
					else if(num == 3)
						puntuacion += 3;
					else if(num == 4)
						puntuacion += 4;
					else if(num == 5)
						puntuacion += 5;
					
					num = rand.nextInt(5)+1;
				}
				
				else if(omnivora == true) {
					if(num == 1) 
						puntuacion++;
					else if(num == 2)
						puntuacion += 2;
					else if(num == 3)
						puntuacion += 3;
					else if(num == 4)
						puntuacion += 4;
					else if(num == 5)
						puntuacion += 5;
					else if(num == 6)
						puntuacion++;
					else if(num == 7)
						puntuacion += 2;
					else if(num == 8)
						puntuacion += 3;
					else if(num == 9)
						puntuacion += 4;
					else if(num == 10)
						puntuacion += 5;
					
					num = rand.nextInt(10)+1;
				}
				comidaX = rand.nextInt(34);
				comidaY = rand.nextInt(23);
			}
			
			comida = new ImageIcon("src/grafics/menjar"+num+".png");
			comida.paintIcon(this, g, posXcomida[comidaX], posYcomida[comidaY]);
			
			for(int b = 1; b < serplong; b++) {
				
				if(longXserp[b] == longXserp[0] && longYserp[b] == longYserp[0]) {
				
					arriba = false;
					abajo = false;
					derecha = false;
					izquierda = false;
					
					clip.stop();
					
					try {
						clipfi.stop();
					}catch(NullPointerException aa) {
						
					}
					
					sonidoGameOver();
					
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
			puntuacion = 0;
			serplong = 3;
			repaint();
			
			try {
				clipfi.stop(); // D'aquesta forma, fem que si l'usuari reinicia abans de morir, no peti aquesta variable
				
			}catch(NullPointerException a) {
				
			}
			
			clip.stop();
			
			musica();
			comidaX = rand.nextInt(34);
			comidaY = rand.nextInt(23);
		}
		
		if(ke.getKeyCode() == KeyEvent.VK_RIGHT){ // Si polses la tecla X, la seva variable boolean es posa en true
			moviments++;
			derecha = true;
			
			if(!izquierda) {
				derecha = true;
			}
			
			else {
				derecha = false;
				izquierda = true;
			}
		
			arriba = false;
			abajo = false;
		}
		
		if(ke.getKeyCode() == KeyEvent.VK_LEFT){
			moviments++;
			izquierda = true;
			
			if(!derecha) {
				izquierda = true;
			}
			
			else {
				izquierda = false;
				derecha = true;
			}
		
			arriba = false;
			abajo = false;
		}
		
		if(ke.getKeyCode() == KeyEvent.VK_UP){
			moviments++;
			arriba = true;
			
			if(!abajo) {
				arriba = true;
			}
			
			else {
				arriba = false;
				abajo = true;
			}
		
			izquierda = false;
			derecha = false;
		}
		
		if(ke.getKeyCode() == KeyEvent.VK_DOWN){
			moviments++;
			abajo = true;
			
			if(!arriba) {
				abajo = true;
			}
			
			else {
				arriba = true;
				abajo = false;
			}
		
			izquierda = false;
			derecha = false;
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
		
		if(derecha) {
			
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
			
			repaint(); // Mètode per refrescar els gràfics tornant a cridar al mètode paintComponent(). Es usa quan es realitzan canvis sobre els gràfics
		}
		
		if(izquierda) {
			
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
		
		if(arriba) {
			
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
		
		if(abajo) {
			
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
	
	// Método que reproduce la música de fondo
	public static void musica() { 
		  try {
			   File file = new File("src/sonido/musica.wav");
			   clip = AudioSystem.getClip();
			   clip.open(AudioSystem.getAudioInputStream(file));
			   clip.start();
		  
		  } catch (Exception e) {
			  System.err.println(e.getMessage());
		  }
	}
	
	// Método que reproduce el sonido al comer
	public static void sonidoComer() { 
		  try {
			   File file = new File("src/sonido/comer.wav");
			   Clip clip = AudioSystem.getClip();
			   clip.open(AudioSystem.getAudioInputStream(file));
			   clip.start();
		  
		  } catch (Exception e) {
		   
			  System.err.println(e.getMessage());
		  }
	}
	
	// Método que reproduce el sonido de fin de la partida
	public static void sonidoGameOver() {
		try {
			File file = new File("src/sonido/gameover.wav");
			clipfi = AudioSystem.getClip();
			clipfi.open(AudioSystem.getAudioInputStream(file));
			clipfi.start();
			
		} catch (Exception e) {
			  System.err.println(e.getMessage());
		}
	}
}