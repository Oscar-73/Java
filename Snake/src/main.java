import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class main {
		
	/* Per al funcionament b�sic del programa, he seguit el seg�ent tutorial: https://www.youtube.com/watch?v=_SqnzvJuKiA
	 * 
	 * Tot i aix�, he tingut molts problemes seguint-lo, ja que alguns m�todes a mi no em funcionaven i he distat
	 * d'algunes de les seves eleccions a l'hora de desenvolupar-lo.
	 * 
	 * Elements nous afegits per m�:
	 * 	� Opcions per mostrar el nom de jugador, seleccionar el color de la serp i seleccionar la seva alimentaci�.
	 *  � Diferents menjars per tipus d'alimentaci�, cadascun amb els seus punt al menjar-lo.
	 *  � M�sica de fons i sons al menjar i al morir.
	 *  � Un fons
	 *  � Icones en ambdues finestres
	 */

	public static void main(String[] args) {
		
		opcions op = new opcions();
		op.setVisible(true);
	}

}
