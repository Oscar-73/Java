import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class main {
		
	/* Per al funcionament bàsic del programa, he seguit el següent tutorial: https://www.youtube.com/watch?v=_SqnzvJuKiA
	 * 
	 * Tot i això, he tingut molts problemes seguint-lo, ja que alguns mètodes a mi no em funcionaven i he distat
	 * d'algunes de les seves eleccions a l'hora de desenvolupar-lo.
	 * 
	 * Elements nous afegits per mí:
	 * 	· Opcions per mostrar el nom de jugador, seleccionar el color de la serp i seleccionar la seva alimentació.
	 *  · Diferents menjars per tipus d'alimentació, cadascun amb els seus punt al menjar-lo.
	 *  · Música de fons i sons al menjar i al morir.
	 *  · Un fons
	 *  · Icones en ambdues finestres
	 */

	public static void main(String[] args) {
		
		opcions op = new opcions();
		op.setVisible(true);
	}

}
