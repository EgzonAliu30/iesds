package iesds;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class IESDSTestClass {
	public static void main(String[] args) {
		int n = Integer.parseInt(JOptionPane.showInputDialog("Jepni numrin e strategjive " + "te lojtarit te pare:"));
		int m = Integer.parseInt(JOptionPane.showInputDialog("Jepni numrin e strategjive " + "te lojtarit te dyte:"));

		Strategjite[][] loja = new Strategjite[n][m];

		Eliminimi e = new Eliminimi();
		ArrayList<String> strategjiteShtylle = new ArrayList<String>();
		ArrayList<String> strategjiteRresht = new ArrayList<String>();

		Eliminimi.emeroStrategjiteRresht(n, strategjiteRresht);
		Eliminimi.emeroStrategjiteShtylle(m, strategjiteShtylle);

		e.filloLojen(loja, strategjiteRresht, strategjiteShtylle);

		new Korniza(loja, strategjiteRresht, strategjiteShtylle);

	}

}
