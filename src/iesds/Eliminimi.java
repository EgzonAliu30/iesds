package iesds;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Eliminimi {
	public static boolean krahasoRreshtat(Strategjite[] rreshti1, Strategjite[] rreshti2) {
		boolean rez = true;
		for (int i = 0; i < rreshti1.length; i++) {
			if (rreshti1[i].st1 >= rreshti2[i].st1) {
				rez = false;
				break;
			}
		}

		return rez;
	}

	public static boolean krahasoShtyllat(Strategjite[] rreshti1, Strategjite[] rreshti2) {
		boolean rez = true;
		for (int i = 0; i < rreshti1.length; i++) {
			if (rreshti1[i].st2 >= rreshti2[i].st2) {
				rez = false;
				break;
			}
		}
		return rez;
	}

	public static Strategjite[] gjejRreshtinEVogel(Strategjite[][] matrica) {

		Strategjite[] rreshti = new Strategjite[matrica[0].length];

		for (int i = 0; i < matrica.length; i++) {

			for (int j = 0; j < matrica.length; j++) {

				if (i != j) {
					boolean dominohet = krahasoRreshtat(matrica[i], matrica[j]);
					// System.out.print(dominohet + " ");
					if (dominohet) {
						for (int k = 0; k < rreshti.length; k++)
							rreshti[k] = matrica[i][k];
						return rreshti;

					}
				}
			}
		}
		return rreshti;
	}

	public static Strategjite[] gjejRreshtinEMadh(Strategjite[][] matrica) {
		Strategjite[] rreshti = new Strategjite[matrica[0].length];
		for (int i = 0; i < matrica.length; i++) {

			for (int j = 0; j < matrica.length; j++) {

				if (i != j) {
					boolean dominohet = krahasoRreshtat(matrica[i], matrica[j]);
					// System.out.print(dominohet + " ");
					if (dominohet) {
						for (int k = 0; k < rreshti.length; k++)
							rreshti[k] = matrica[j][k];
						return rreshti;

					}
				}
			}
		}

		// for(int m=0; m< rreshti.length; m++) System.out.print(rreshti[m] + " ");
		return rreshti;
	}

	public static Strategjite[] gjejShtyllenEVogel(Strategjite[][] matrica) {
		Strategjite[][] matricaRe = Metodat.transpono(matrica);
		Strategjite[] shtylla = new Strategjite[matricaRe[0].length];
		// for(int i=0; i< rreshti.length; i++) System.out.print(rreshti[i] +" ");
		// rreshti1 me i vogli per momentin
		for (int i = 0; i < matricaRe.length; i++) {

			for (int j = 0; j < matricaRe.length; j++) {

				if (i != j) {
					boolean dominohet = krahasoShtyllat(matricaRe[i], matricaRe[j]);
					// System.out.print(dominohet + " ");
					if (dominohet) {
						for (int k = 0; k < shtylla.length; k++)
							shtylla[k] = matricaRe[i][k];
						return shtylla;

					}
				}
			}
		}

		// for(int m=0; m< rreshti.length; m++) System.out.print(rreshti[m] + " ");
		return shtylla;
	}

	public static Strategjite[] gjejShtyllenEMadhe(Strategjite[][] matrica) {
		Strategjite[][] matricaRe = Metodat.transpono(matrica);
		Strategjite[] shtylla = new Strategjite[matricaRe[0].length];
//	for(int i=0; i< rreshti.length; i++) System.out.print(rreshti[i] +" ");
		// rreshti1 me i vogli per momentin
		for (int i = 0; i < matricaRe.length; i++) {

			for (int j = 0; j < matricaRe.length; j++) {

				if (i != j) {
					boolean dominohet = krahasoShtyllat(matricaRe[i], matricaRe[j]);
					// System.out.print(dominohet + " ");
					if (dominohet) {
						for (int k = 0; k < shtylla.length; k++)
							shtylla[k] = matricaRe[j][k];
						return shtylla;

					}
				}
			}
		}

// for(int m=0; m< rreshti.length; m++) System.out.print(rreshti[m] + "  ");
		return shtylla;
	}

	public static Strategjite[][] fshijRreshtin(Strategjite[][] matrica) {
		int n = matrica.length;
		int m = matrica[0].length;

		Strategjite[] rreshti = gjejRreshtinEVogel(matrica);
		boolean rreshtNull = Metodat.rreshtNull(rreshti);

		if (!rreshtNull) {
			n = n - 1;
		}

		Strategjite[][] matricaRe = new Strategjite[n][m];

		matrica = Metodat.zevendesoRreshtat(matrica, rreshti);// vendos rreshtin per tu eliminuar te parin
		// Metodat.afisho(matrica); System.out.println();

		if (!rreshtNull) { // nese ka rresht per tu eliminuar mbushe matricen e re
							// injoro rreshtin e pare
			for (int i = 1; i < matrica.length; i++) {
				for (int j = 0; j < matrica[i].length; j++) {
					matricaRe[i - 1][j] = matrica[i][j];
				}
			}
		}

		else { // [perndryshe rimbushe matricen e re te komplet te njejte me te vjetren
			for (int i = 0; i < matrica.length; i++) {
				for (int j = 0; j < matrica[i].length; j++) {
					matricaRe[i][j] = matrica[i][j];
				}
			}
		}
		return matricaRe;
	}

	public static Strategjite[][] fshijShtyllen(Strategjite[][] matrica) {
		int n = matrica.length;
		int m = matrica[0].length;

		Strategjite[] shtylla = gjejShtyllenEVogel(matrica);
		boolean shtylleNull = Metodat.rreshtNull(shtylla);

		if (!shtylleNull) {
			m = m - 1;
		}

		Strategjite[][] matricaRe = new Strategjite[n][m];

		matrica = Metodat.zevendesoShtyllat(matrica, shtylla);// vendos rreshtin per tu eliminuar te parin

		if (!shtylleNull) { // nese ka rresht per tu eliminuar mbushe matricen e re
							// injoro shtyllen e pare
			for (int i = 0; i < matrica.length; i++) {
				for (int j = 1; j < matrica[0].length; j++) {
					matricaRe[i][j - 1] = matrica[i][j];
				}
			}
		}

		else { // [perndryshe rimbushe matricen e re te komplet te njejte me te vjetren
			for (int i = 0; i < matrica.length; i++) {
				for (int j = 0; j < matrica[0].length; j++) {
					matricaRe[i][j] = matrica[i][j];
				}
			}
		}

		return matricaRe;
	}

	public void filloLojen(Strategjite[][] loja, ArrayList<String> l1, ArrayList<String> l2) {
		int n = loja.length;
		int m = loja[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int s1 = Integer.parseInt(JOptionPane.showInputDialog("Caktoni U1(" + l1.get(i) + " , " + l2.get(j) + ")!"));
				int s2 = Integer.parseInt(JOptionPane.showInputDialog("Caktoni U2(" + l1.get(i) + " , " + l2.get(j) + ")!"));
				// int s1 = (int)(Math.random()*1111);
				// int s2 = (int)(Math.random()*1111);
				loja[i][j] = new Strategjite(s1, s2);

			}
		}
	}

	static void emeroStrategjiteRresht(int n, ArrayList<String> emrat) {
		for (int i = 0; i < n; i++) {
			emrat.add(JOptionPane.showInputDialog("Emeroni strategjine " + (i + 1) + " te lojtarit te pare!"));
		}
	}

	static void emeroStrategjiteShtylle(int m, ArrayList<String> emrat) {
		for (int i = 0; i < m; i++) {
			emrat.add(JOptionPane.showInputDialog("Emeroni strategjine " + (i + 1) + " te lojtarit te dyte!"));
		}
	}

}
