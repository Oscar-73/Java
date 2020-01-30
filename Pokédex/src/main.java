import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Image;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;
import org.jfree.chart.renderer.category.CategoryItemRenderer;

public class main extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JFrame frame; // Variable Frame principal. Dentro de esta variable va el resto.
	private JPanel panelInfo;
	private JPanel panelBuscador;
	private JPanel panelLblNombreIDPoke;
	private JPanel panelTiposGenLeg;
	private JPanel panelLblBusca;
	private JPanel panelLblEncontrado;
	private GroupLayout groupLayout;
	private JTextField txtId;
	private JTextField txtNombre;
	private JLabel lblMonitorBuscador;
	private JLabel foto;
	private JLabel lblEncontrado;
	private JLabel lblBuscaUnPokemon;
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblNombreIDPoke;
	private JLabel lblTipo1;
	private JLabel lblTipo2;
	private JLabel botonAzul;
	private JLabel restoBotones;
	private JLabel bordeSuperior;
	private JLabel botonNegro;
	private JLabel botonesRojoAzulInferiores;
	private JLabel crucetaInferior;
	private JLabel lblMonitorImagenPokemon;
	private JLabel lblGeneracion;
	private JLabel lblRegion;
	private JLabel lblLegendario;
	private JButton btnBuscar;
	private JTextArea lblDescripcionPoke;
	private JScrollPane scrollDescripcion;
	private DefaultCategoryDataset datasetEstadisticas;
	private JFreeChart graficoBarras;
	private ChartPanel panelGraficoBarras;
	private CategoryItemRenderer renderer;
	private ItemLabelPosition position;
	private Image iconoPoke;
	private ImageIcon iconoPokedex;
	private ImageIcon imgRecurso;
	private JSeparator separator1;
	private JSeparator separator2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new main(); // Inicializamos el Frame
					frame.setVisible(true); // Lo hacemos visible (sin este método, la aplicación se ejecuta pero el Frame no aparece)
					frame.pack(); // Con esto hacemos que el Frame se adapte al tamaño del contenido que contiene
					frame.setBounds(550, 300, 1000, 500); // (x, y, ancho, alto) Con este método ajustamos la posición inicial del Frame y sus medidas
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
		getContentPane().setBackground(Color.decode("#c42a0e")); // Color de fondo entre los dos panels
		setResizable(false); // Hacemos que el Frame no sea redimensionable
		setTitle("Pokédex"); // Asignamos un título al Frame
		
		iconoPokedex = new ImageIcon("src/imagenes/recursos/icono.png"); // Obtenemos la imagen del icono del directorio siguiente		
		iconoPoke = iconoPokedex.getImage(); // Pasamos la variable ImageIcon a Image para así poder asignarla como icono
		setIconImage(iconoPoke); // Asignamos esa imagen como icono del Frame
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Con este comando, al cerrar el Frame se detiene el programa.

		// El Frame está dividido por dos paneles principales: el "panelBuscador" (izquierda) y el "panelInfo" (derecha)
		// Inicializamos el "panelBuscador"
		panelBuscador = new JPanel();
		panelBuscador.setLayout(null); // Le asignamos "AbsoluteLayout"
		panelBuscador.setBackground(Color.decode("#f33311"));
		
		// Inicializamos los elementos del "panelBuscador" y configuramos sus propiedades.		
		botonAzul = new JLabel("");
		botonAzul.setBounds(15, 5, 114, 93);
		imgRecurso = new ImageIcon("src/imagenes/recursos/botonAzul.png");		
		botonAzul.setIcon(imgRecurso);
		
		restoBotones = new JLabel("");
		restoBotones.setBounds(105, 5, 114, 34);
		imgRecurso = new ImageIcon("src/imagenes/recursos/restoBotones.png");		
		restoBotones.setIcon(imgRecurso);
		
		bordeSuperior = new JLabel("");
		bordeSuperior.setBounds(0, 55, 400, 66);
		imgRecurso = new ImageIcon("src/imagenes/recursos/bordeSuperior.png");		
		bordeSuperior.setIcon(imgRecurso);
		
		panelLblBusca = new JPanel();
		panelLblBusca.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelLblBusca.setBackground(Color.DARK_GRAY);
		panelLblBusca.setBounds(15, 112, 370, 40);
		
		lblBuscaUnPokemon = new JLabel("Busca un Pokémon por ID o por nombre.");
		lblBuscaUnPokemon.setForeground(Color.WHITE);
		lblBuscaUnPokemon.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblId = new JLabel("ID: ");
		lblId.setBounds(45, 200, 38, 25);		
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtId = new JTextField();
		txtId.setBackground(Color.DARK_GRAY);
		txtId.setBounds(157, 197, 176, 31);
		txtId.setForeground(Color.WHITE);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtId.setColumns(10);
		txtId.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(45, 249, 87, 25);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombre.setForeground(Color.BLACK);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(Color.DARK_GRAY);
		txtNombre.setBounds(157, 246, 176, 31);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNombre.setForeground(Color.WHITE);
		txtNombre.setColumns(10);
		txtNombre.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		lblMonitorBuscador = new JLabel("");
		lblMonitorBuscador.setBounds(20, 160, 400, 160);
		imgRecurso = new ImageIcon("src/imagenes/recursos/monitorBuscador.png");		
		lblMonitorBuscador.setIcon(imgRecurso);
		
		panelLblEncontrado = new JPanel();
		panelLblEncontrado.setForeground(Color.WHITE);
		panelLblEncontrado.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelLblEncontrado.setBackground(Color.DARK_GRAY);
		panelLblEncontrado.setBounds(15, 327, 365, 30);
		
		lblEncontrado = new JLabel();
		lblEncontrado.setForeground(Color.WHITE);
		lblEncontrado.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEncontrado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEncontrado.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		botonesRojoAzulInferiores = new JLabel("");
		botonesRojoAzulInferiores.setBounds(125, 365, 140, 7);
		imgRecurso = new ImageIcon("src/imagenes/recursos/botonesRojoAzulInferiores.png");		
		botonesRojoAzulInferiores.setIcon(imgRecurso);
		
		botonNegro = new JLabel("");
		botonNegro.setForeground(Color.WHITE);
		botonNegro.setBounds(15, 355, 400, 66);
		imgRecurso = new ImageIcon("src/imagenes/recursos/botonNegro.png");		
		botonNegro.setIcon(imgRecurso);
		
		btnBuscar = new JButton("Buscar Pokémon");
		btnBuscar.setBounds(70, 380, 205, 66);
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setBackground(Color.decode("#bbcd83"));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		crucetaInferior = new JLabel("");
		crucetaInferior.setBounds(292, 365, 87, 85);
		imgRecurso = new ImageIcon("src/imagenes/recursos/crucetaInferior.png");		
		crucetaInferior.setIcon(imgRecurso);
		
		// Asignamos los elementos anteriores al "panelBuscador" y al resto de paneles correspondientes.
		panelBuscador.add(botonAzul);
		panelBuscador.add(restoBotones);
		panelBuscador.add(bordeSuperior);
		panelBuscador.add(panelLblBusca);
		panelLblBusca.add(lblBuscaUnPokemon);
		panelBuscador.add(lblId);
		panelBuscador.add(txtId);
		panelBuscador.add(lblNombre);
		panelBuscador.add(txtNombre);
		panelBuscador.add(lblMonitorBuscador); 
		panelBuscador.add(panelLblEncontrado);
		panelLblEncontrado.add(lblEncontrado);
		panelBuscador.add(botonesRojoAzulInferiores);
		panelBuscador.add(botonNegro);
		panelBuscador.add(btnBuscar);
		panelBuscador.add(crucetaInferior);
		
		// Inicializamos el "panelInfo"
		panelInfo = new JPanel();
		panelInfo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null)); // Le asignamos un borde para diferenciarlo del primer panel
		panelInfo.setLayout(null);
		panelInfo.setBackground(Color.decode("#f33311"));
		
		// Inicializamos los elementos del "panelInfo" y configuramos sus propiedades.		
		foto = new JLabel("");
		foto.setBounds(15, 16, 215, 215);
		
		lblMonitorImagenPokemon = new JLabel("");
		lblMonitorImagenPokemon.setBounds(15, 16, 221, 220);
		imgRecurso = new ImageIcon("src/imagenes/recursos/MonitorImagenPokemon.png");		
		lblMonitorImagenPokemon.setIcon(imgRecurso);
		
		panelLblNombreIDPoke = new JPanel();
		panelLblNombreIDPoke.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelLblNombreIDPoke.setBackground(Color.DARK_GRAY);
		panelLblNombreIDPoke.setBounds(245, 16, 326, 35);
		panelLblNombreIDPoke.setLayout(null);
		
		lblNombreIDPoke = new JLabel("");
		lblNombreIDPoke.setForeground(Color.WHITE);
		lblNombreIDPoke.setBounds(0, 0, 326, 35);
		lblNombreIDPoke.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreIDPoke.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		panelTiposGenLeg = new JPanel();
		panelTiposGenLeg.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelTiposGenLeg.setBounds(245, 51, 326, 53);
		panelTiposGenLeg.setLayout(null);
						
		lblTipo1 = new JLabel("");
		lblTipo1.setBounds(5, 15, 69, 25);
		
		lblTipo2 = new JLabel("");
		lblTipo2.setBounds(60, 15, 69, 25);
		
		separator1 = new JSeparator();
		separator1.setOrientation(SwingConstants.VERTICAL);
		separator1.setForeground(Color.DARK_GRAY);
		separator1.setBackground(Color.DARK_GRAY);
		separator1.setBounds(115, 5, 15, 40);
		
		lblGeneracion = new JLabel("");
		lblGeneracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeneracion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGeneracion.setBounds(120, 9, 93, 17);
		
		lblRegion = new JLabel("");
		lblRegion.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegion.setBounds(120, 27, 93, 17);
		
		separator2 = new JSeparator();
		separator2.setOrientation(SwingConstants.VERTICAL);
		separator2.setForeground(Color.DARK_GRAY);
		separator2.setBackground(Color.DARK_GRAY);
		separator2.setBounds(217, 5, 15, 40);
		
		lblLegendario = new JLabel("");
		lblLegendario.setHorizontalAlignment(SwingConstants.CENTER);
		lblLegendario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLegendario.setBounds(222, 5, 99, 40);
		
		lblDescripcionPoke = new JTextArea("");
		lblDescripcionPoke.setEditable(false);
		lblDescripcionPoke.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDescripcionPoke.setForeground(Color.BLACK);
		lblDescripcionPoke.setBackground(Color.decode("#26bdcc"));
		lblDescripcionPoke.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblDescripcionPoke.setBounds(244, 131, 326, 110);
		lblDescripcionPoke.setLineWrap(true); // Con este método hacemos que el texto no quede en una sola línea dentro del JTextArea y haga un salto de línea al tocar el borde.
		lblDescripcionPoke.setWrapStyleWord(true); // Con este método hacemos que con los saltos de línea que realiza el método "setLineWrap" las palabras no queden a medias.
		
		scrollDescripcion = new JScrollPane(lblDescripcionPoke); // Dado que para instanciar un JScrollPane necesitamos un JTextArea, este último ya ha de estar definido e insertado en un frame/panel
		scrollDescripcion.setBounds(new Rectangle(245, 104, 326, 132)); // Le asignamos al JScrollPane las mismas medidas que el JTextArea
		
		datasetEstadisticas = new DefaultCategoryDataset(); // Creamos un dataset en el cual al llamar a "datosPokemon()", introduciremos todas las estadísticas del Pokémon
		graficoBarras = ChartFactory.createBarChart( // Creamos un gráfico de barras a partir del dataset anterior
                "Estadísticas",	// Título del gráfico
                "", // Categoría eje Y
                "", // Categoría eje X
                datasetEstadisticas, // Datos del gráfico
                PlotOrientation.HORIZONTAL, // Orientación del gráfico
                false, // Incluir leyenda
                false, // Generar tooltip al pasar el cursor por encima de una barra
                false // Generar URLs
        );
		
		graficoBarras.setBorderVisible(true);
		
		panelGraficoBarras = new ChartPanel(graficoBarras); // Instanciamos el gráfico de barras (aunque "graficoBarras" aún no contenga ningún valor)
        panelGraficoBarras.setBounds(15, 250, 556, 203);
        panelGraficoBarras.setPopupMenu(null); // Con este método deshabilitamos las propiedades al hacer clic derecho sobre una barra
        panelGraficoBarras.setRangeZoomable(false); // Con este método deshabilitamos la opción de zoomear en las barras y modificar el rango numeral
        
        renderer = ((CategoryPlot)graficoBarras.getPlot()).getRenderer(); // Con este objeto "CategoryItemRenderer", haremos que el valor exacto de la estadística de un Pokémon aparezca sobre la barra
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		position = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER); // Concretamos que el valor aparezca en mitad de la barra
		renderer.setBasePositiveItemLabelPosition(position);
        
		// Asignamos los elementos anteriores al "panelInfo" y al resto de paneles correspondientes.       
		panelInfo.add(foto);
		panelInfo.add(lblMonitorImagenPokemon);
		panelInfo.add(panelLblNombreIDPoke);
		panelLblNombreIDPoke.add(lblNombreIDPoke);
		panelInfo.add(panelTiposGenLeg);
		panelTiposGenLeg.add(lblTipo1);
		panelTiposGenLeg.add(lblTipo2);
		panelTiposGenLeg.add(separator1);
		panelTiposGenLeg.add(lblGeneracion);
		panelTiposGenLeg.add(lblRegion);
		panelTiposGenLeg.add(separator2);
		panelTiposGenLeg.add(lblLegendario);
		panelInfo.add(scrollDescripcion); // Solo añadimos "scrollDescripcion" porque técnicamente es un JPanel y al crearlo le asignamos el "lblDescripcionPoke", y este no puede estar asignado a dos JPanels distintos al mismo tiempo
		panelInfo.add(panelGraficoBarras);
		
		groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelBuscador, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelInfo, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panelBuscador, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)
				.addComponent(panelInfo, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
		);
		
		getContentPane().setLayout(groupLayout);

		// Método principal que se ejecuta al hacer clic sobre el botón de "Buscar Pokémon"
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Idconv = txtId.getText();
				String nombre = txtNombre.getText();
				
				if(!Idconv.isEmpty() && nombre.isEmpty()) {
			        BufferedReader br = null;
			        String linea = "";
			        String separador = ";";
			        
			        try {
			            br = new BufferedReader(new InputStreamReader(new FileInputStream("src/archivos/pokemon.csv"), "UTF8")); // Usamos "InputStreamReder" y "FileInputStream" (especificando la codificación) en vez del "FileReader" porque este último no lee caracteres especiales.
			            while ((linea = br.readLine()) != null) {
			            	String[] infoPoke = linea.split(separador);
			            	if(Idconv.equals(infoPoke[0])) {
			            		lblEncontrado.setText("Pokémon encontrado.");			            		
			            		lblEncontrado.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			            		Pokemon poke = new Pokemon(Integer.parseInt(infoPoke[0]), infoPoke[1], infoPoke[2], infoPoke[3], Integer.parseInt(infoPoke[4]), Integer.parseInt(infoPoke[5]), Integer.parseInt(infoPoke[6]), Integer.parseInt(infoPoke[7]), Integer.parseInt(infoPoke[8]), Integer.parseInt(infoPoke[9]), Integer.parseInt(infoPoke[10]), Integer.parseInt(infoPoke[11]), Boolean.parseBoolean(infoPoke[12]));
			            		DatosPokemon(poke);
			            		ImagenPokemon(poke);
			            		SonidoPokemon(poke);
			            		break;
			            	}
			            	else {
			            		lblEncontrado.setText("Pokémon no encontrado.");
			            		lblEncontrado.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			            		vaciarPokedex();
			            	}
			            }
			        } catch (FileNotFoundException e1) {
			            e1.printStackTrace();
			        } catch (IOException e2) {
			            e2.printStackTrace();
			        } finally {
			            if (br != null) {
			                try {
			                    br.close();
			                } catch (IOException e3) {
			                    e3.printStackTrace();
			                }
			            }
			        }
				}
				
				else if (Idconv.isEmpty() && !nombre.isEmpty()) {					
					BufferedReader br = null;
			        String linea = "";
			        String separador = ";";
			        
			        try {
			        	br = new BufferedReader(new InputStreamReader(new FileInputStream("src/archivos/pokemon.csv"), "UTF8"));
			            while ((linea = br.readLine()) != null) {
			            	String[] infoPoke = linea.split(separador);			            
			            	if(nombre.toUpperCase().equals(infoPoke[1].toUpperCase())) {
			            		lblEncontrado.setText("Pokémon encontrado.");
			            		lblEncontrado.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			            		Pokemon poke = new Pokemon(Integer.parseInt(infoPoke[0]), infoPoke[1], infoPoke[2], infoPoke[3], Integer.parseInt(infoPoke[4]), Integer.parseInt(infoPoke[5]), Integer.parseInt(infoPoke[6]), Integer.parseInt(infoPoke[7]), Integer.parseInt(infoPoke[8]), Integer.parseInt(infoPoke[9]), Integer.parseInt(infoPoke[10]), Integer.parseInt(infoPoke[11]), Boolean.parseBoolean(infoPoke[12]));
			            		DatosPokemon(poke);
			            		ImagenPokemon(poke);
			            		SonidoPokemon(poke);
			            		break;
			            	}
			            	else {
			            		lblEncontrado.setText("Pokémon no encontrado.");
			            		lblEncontrado.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			            		vaciarPokedex();
			            	}
			            }
			        } catch (FileNotFoundException e1) {
			            e1.printStackTrace();
			        } catch (IOException e2) {
			            e2.printStackTrace();
			        } finally {
			            if (br != null) {
			                try {
			                    br.close();
			                } catch (IOException e3) {
			                    e3.printStackTrace();
			                }
			            }
			        }
				}
				
				else if (!Idconv.isEmpty() && !nombre.isEmpty()) {					
					BufferedReader br = null;
			        String linea = "";
			        String separador = ";";
			        
			        try {
			        	br = new BufferedReader(new InputStreamReader(new FileInputStream("src/archivos/pokemon.csv"), "UTF8"));
			            while ((linea = br.readLine()) != null) {
			            	String[] infoPoke = linea.split(separador);			            
			            	if(Idconv.equals(infoPoke[0]) && nombre.toUpperCase().equals(infoPoke[1].toUpperCase())) {			            		
			            		lblEncontrado.setText("Pokémon encontrado.");
			            		lblEncontrado.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			            		Pokemon poke = new Pokemon(Integer.parseInt(infoPoke[0]), infoPoke[1], infoPoke[2], infoPoke[3], Integer.parseInt(infoPoke[4]), Integer.parseInt(infoPoke[5]), Integer.parseInt(infoPoke[6]), Integer.parseInt(infoPoke[7]), Integer.parseInt(infoPoke[8]), Integer.parseInt(infoPoke[9]), Integer.parseInt(infoPoke[10]), Integer.parseInt(infoPoke[11]), Boolean.parseBoolean(infoPoke[12]));
			            		DatosPokemon(poke);
			            		ImagenPokemon(poke);
			            		SonidoPokemon(poke);
			            		break;
			            	}			            	
			            	else {
			            		lblEncontrado.setText("El ID y el nombre del Pokémon no corresponden.");
			            		vaciarPokedex();
			            	}
			            }
			        } catch (FileNotFoundException e1) {
			            e1.printStackTrace();
			        } catch (IOException e2) {
			            e2.printStackTrace();
			        } finally {
			            if (br != null) {
			                try {
			                    br.close();
			                } catch (IOException e3) {
			                    e3.printStackTrace();
			                }
			            }
			        }
				}
			
				else {					
					lblEncontrado.setText("Introduce un Pokémon, por favor.");
					vaciarPokedex();
				}
			}	
		});
	}
	
	// Método con el que hacemos aparecer la imagen del Pokémon
	private void ImagenPokemon(Pokemon poke) {
		ImageIcon PokeImg = new ImageIcon("src/imagenes/pokes/"+poke.getNombre()+".png"); // Obtenemos la imagen del directorio a partir del nombre del Pokémon		

		Image image = PokeImg.getImage(); // Pasamos la variable ImageIcon a Image para así poder reescalarla
		Image newimg = image.getScaledInstance(foto.getWidth(), foto.getHeight(),  java.awt.Image.SCALE_SMOOTH); // Reescalamos la imagen para que encaje en el JLabel
		
		PokeImg = new ImageIcon(newimg); // Volemos a pasar la imagen a ImageIcon para poder asignarla al JLabel
		
		foto.setIcon(PokeImg); // Asignamos la imagen al JLabel
	}
	
	// Método con el que reproducimos el grito del Pokémon
	private void SonidoPokemon(Pokemon poke) {
		try {
			File file = new File("src/sonidos/"+poke.getNombre()+".wav"); // Obtenemos el sonido del directorio a partir del nombre del Pokémon
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file)); // Obtenemos el archivo
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN); // Con "FloatControl" regulamos el sonido
			gainControl.setValue(-20.0f); // Reducimos el volumen 20 decibelios.
			clip.start(); // Reproducimos el sonido
		}catch (Exception e) {
			System.err.println(e.getMessage());
	    }
	}
	
	// Método con el que mostramos la descripción y estadísticas del Pokémon
	private void DatosPokemon(Pokemon poke) {
		lblNombreIDPoke.setText(poke.getNombre()+" (# "+poke.getId()+")"); // Mostramos nombre e ID del Pokémon
		
		TiposPokemon(poke); // Método con el que mostramos los tipos del Pokémon de forma gráfica
		
		switch(poke.getGeneracion()) { // Mostramos la generación y región a la cual pertenece el Pokémon
		case 1: lblGeneracion.setText("Primera generación");
				lblRegion.setText(("Kanto"));
				break;
		case 2: lblGeneracion.setText("Segunda generación (Johto)");
				break;
		case 3: lblGeneracion.setText("Tercera generación (Hoenn)");
				break;
		case 4: lblGeneracion.setText("Cuarta generación (Sinnoh)");
				break;
		case 5: lblGeneracion.setText("Quinta generación (Teselia)");
				break;
		case 6: lblGeneracion.setText("Sexta generación (Kalos)");
				break;
		case 7: lblGeneracion.setText("Séptima generación (Alola)");
				break;
		case 8: lblGeneracion.setText("Octava generación (Galar)");
				break;
		}
		
		if(poke.isLegendario()) // Mostramos si el Pokémon es o no legendario
			lblLegendario.setText("¡Legendario!");
		else
			lblLegendario.setText(null);
		
		BufferedReader br = null;
        String linea = "";
        String separador = ";";
        
        // Asignamos la descripción del Pokémon
        try {
        	br = new BufferedReader(new InputStreamReader(new FileInputStream("src/archivos/descripciones.csv"), "UTF8"));
            while ((linea = br.readLine()) != null) {
            	String[] descripcion = linea.split(separador);
            	if(descripcion[0].equals(Integer.toString(poke.getId()))) { // Si el ID de la línea corresponde con el del Pokémon que le pasamos por parámetro...			            		            		
            		lblDescripcionPoke.setText(descripcion[1]); // Mostramos la descripción, la cual se ubica en la segunda columna del CSV.
            		lblDescripcionPoke.setCaretPosition(0); // Con esto hacemos que el texto del JTextArea se muestre desde el principio y no tengamos que subir el JScrollPane
            		break; // Una vez encuentra el ID, rompemos el bucle
            	}
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
        
        // Asignamos todas las estadísticas del Pokémon en el dataset
        datasetEstadisticas.addValue(poke.getPs(), "Estadística", "PS");
        datasetEstadisticas.addValue(poke.getAtaque(), "Estadística", "Ataque");
        datasetEstadisticas.addValue(poke.getDefensa(), "Estadística", "Defensa");
        datasetEstadisticas.addValue(poke.getAtaque_especial(), "Estadística", "Ataque especial");
        datasetEstadisticas.addValue(poke.getDefensa_especial(), "Estadística", "Defensa especial");
        datasetEstadisticas.addValue(poke.getVelocidad(), "Estadística", "Velocidad");
	}
	
	private void TiposPokemon(Pokemon poke) {
		ImageIcon tipo1 = new ImageIcon("src/imagenes/tipos/"+poke.getTipo1()+".png");		
		lblTipo1.setIcon(tipo1);
		
		ImageIcon tipo2 = new ImageIcon("src/imagenes/tipos/"+poke.getTipo2()+".png");		
		lblTipo2.setIcon(tipo2);
	}
	
	private void vaciarPokedex() {
		lblNombreIDPoke.setText(null);
		lblGeneracion.setText(null);
		lblRegion.setText(null);
		lblLegendario.setText(null);
		foto.setIcon(null);
		lblDescripcionPoke.setText(null);
		lblTipo1.setIcon(null);
		lblTipo2.setIcon(null);
		datasetEstadisticas.clear();
	}
}
