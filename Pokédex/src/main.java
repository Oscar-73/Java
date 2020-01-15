import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextPane;

// A�adido por m�
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Color;

public class main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNombre;
	private JLabel lblDescripcin;
	private JLabel lblFoto;
	private JLabel foto;
	private JTextField txtEncontrado;
	
	
	// A�adido por m�	
	private int id = 0;
	private String Idconv;
	private String nombre;
	private JTextPane txtDescripcion;

	Map<Integer, String> Pokedex = new HashMap<Integer, String>();
	
	int[] idpoke = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	String[] nombrepoke = {"Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard", "Squirtle", "Wartortle", "Blastoise"};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
					frame.pack(); // Con esto hacemos que la ventana se adapte al tama�o del contenido que contiene
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public main() {
		setForeground(Color.WHITE);
		setResizable(false);
		setTitle("Pok\u00E9dex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 397);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBuscaUnPokmon = new JLabel("Busca un Pok\u00E9mon por ID o nombre.");
		
		JLabel lblId = new JLabel("ID: ");
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		txtId = new JTextField();
		txtId.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		lblDescripcin = new JLabel("Descripci\u00F3n:");
		
		lblFoto = new JLabel("Foto");
		
		foto = new JLabel("");
		
		JButton btnBuscar = new JButton("Buscar Pok\u00E9mon");
		
		txtEncontrado = new JTextField();
		txtEncontrado.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtEncontrado.setEditable(false);
		txtEncontrado.setHorizontalAlignment(SwingConstants.CENTER);
		txtEncontrado.setColumns(10);
		txtEncontrado.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		txtDescripcion = new JTextPane();
		txtDescripcion.setEditable(false);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDescripcin)
							.addPreferredGap(ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
							.addComponent(lblFoto, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(115))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNombre)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblId)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(70)
									.addComponent(foto, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
									.addGap(41))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
									.addGap(66))))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBuscaUnPokmon)
					.addGap(18)
					.addComponent(txtEncontrado, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBuscaUnPokmon)
						.addComponent(txtEncontrado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblId)
								.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescripcin)
						.addComponent(lblFoto))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtDescripcion, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
						.addComponent(foto, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		
		for (int i=0; i<nombrepoke.length; i++) { // Esto recorre el Map a�adi�ndole los valores
			Pokedex.put(idpoke[i], nombrepoke[i]);
		}
		
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Idconv = txtId.getText();
				nombre = txtNombre.getText();
				
				if(Idconv.length() != 0) {
					id = Integer.parseInt(Idconv);
					
					if(Pokedex.containsKey(id)) {
						txtEncontrado.setText("Pok�mon encontrado.");
						
						PokemonEncontrado(id);
					}
					
					else {
						
						txtEncontrado.setText("Pok�mon no encontrado.");
						
						txtDescripcion.setText("");
						
						foto.setIcon(null);
					}
				}
				
				else if (nombre.length() != 0) {
					
					if(Pokedex.containsValue(nombre)) {
						txtEncontrado.setText("Pok�mon encontrado.");
						
						 for (Integer o : Pokedex.keySet()) { // Con esta vaina saco la key de un value (saco el ID del nombre del Pok�mon)
						      if (Pokedex.get(o).equals(nombre)) {
						        id = o;
						      }
						 }
						      
						PokemonEncontrado(id);
					}
					
				}
				
				else {
					
					txtEncontrado.setText("Introduce un Pok�mon, por favor.");
					
					txtDescripcion.setText("");
					
					foto.setIcon(null);
				}
					
					
			}	
			
		});
		
	}
	
	public void PokemonEncontrado(int id) {

		
		switch(id) {
		
			case 001:
				
				txtDescripcion.setText("A Bulbasaur es f�cil verle ech�ndose una siesta al sol. La semilla que tiene en el lomo va creciendo cada vez m�s a medida que absorbe los rayos del sol.");
				
				ImagenPokemon(Pokedex.get(id));
				
				SonidoPokemon(Pokedex.get(id));
				
				break;
				
		

			case 002:
			
				txtDescripcion.setText("Este Pok�mon lleva un bulbo en el lomo y, para poder con su peso, tiene unas patas y un tronco gruesos y fuertes. Si empieza a pasar m�s tiempo al sol, ser� porque el bulbo est� a punto de hacerse una flor grande.");
			
				ImagenPokemon(Pokedex.get(id));
				
				SonidoPokemon(Pokedex.get(id));
				
				break;
		
		
			case 003:
			
				txtDescripcion.setText("Venusaur tiene una flor enorme en el lomo que, seg�n parece, adquiere unos colores muy vivos si est� bien nutrido y le da mucho el sol. El aroma delicado de la flor tiene un efecto relajante en el �nimo de las personas.");
			
				ImagenPokemon(Pokedex.get(id));
				
				SonidoPokemon(Pokedex.get(id));
				
				break;
				
				
			case 004:
				
				txtDescripcion.setText("La llama que tiene en la punta de la cola arde seg�n sus sentimientos. Llamea levemente cuando est� alegre y arde vigorosamente cuando est� enfadado.");
			
				ImagenPokemon(Pokedex.get(id));
				
				SonidoPokemon(Pokedex.get(id));
				
				break;
				
				
			case 005:
				
				txtDescripcion.setText("Charmeleon no tiene reparo en acabar con su rival usando las afiladas garras que tiene. Si su enemigo es fuerte, se vuelve agresivo, y la llama que tiene en el extremo de la cola empieza a arder con mayor intensidad torn�ndose azulada.");
			
				ImagenPokemon(Pokedex.get(id));
				
				SonidoPokemon(Pokedex.get(id));
				
				break;
				
				
			case 006:
				
				txtDescripcion.setText("Charizard se dedica a volar por los cielos en busca de oponentes fuertes. Echa fuego por la boca y es capaz de derretir cualquier cosa. No obstante, si su rival es m�s d�bil que �l, no usar� este ataque.");
			
				ImagenPokemon(Pokedex.get(id));
				
				SonidoPokemon(Pokedex.get(id));
				
				break;
				
			case 007:
				
				txtDescripcion.setText("El caparaz�n de Squirtle no le sirve de protecci�n �nicamente. Su forma redondeada y las hendiduras que tiene le ayudan a deslizarse en el agua y le permiten nadar a gran velocidad.");
			
				ImagenPokemon(Pokedex.get(id));
				
				SonidoPokemon(Pokedex.get(id));
				
				break;
				
			case 8:
	
				txtDescripcion.setText("Tiene una cola larga y cubierta de un pelo abundante y grueso que se torna m�s oscuro a medida que crece. Los ara�azos que tiene en el caparaz�n dan fe de lo buen guerrero que es.");

				ImagenPokemon(Pokedex.get(id));
	
				SonidoPokemon(Pokedex.get(id));
	
				break;
	
			case 9:
	
				txtDescripcion.setText("Blastoise lanza chorros de agua con gran precisi�n por los tubos que le salen del caparaz�n que tiene en la espalda. Puede disparar chorros de agua con tanta punter�a que no fallar�a al tirar contra una lata peque�a a 50 m.");

				ImagenPokemon(Pokedex.get(id));
	
				SonidoPokemon(Pokedex.get(id));
	
				break;
		}
			
		
	}		
		
	private void ImagenPokemon(String nombre) {
		
		ImageIcon PokeImg = new ImageIcon("src/Imatges/"+nombre+".png");
		
		Image image = PokeImg.getImage();
		
		Image newimg = image.getScaledInstance(foto.getWidth(), foto.getHeight(),  java.awt.Image.SCALE_SMOOTH);
		
		PokeImg = new ImageIcon(newimg);
		
		foto.setIcon(PokeImg);
	}
	
	private void SonidoPokemon(String nombre) {
		
		try {
				File file = new File("src/Sons/"+nombre+".wav");
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(file));
				clip.start();
				  
		}catch (Exception e) {
			   System.err.println(e.getMessage());
	    }
	}
}
