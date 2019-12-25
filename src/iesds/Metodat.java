package iesds;

public class Metodat {
	public static Strategjite[][] transpono(Strategjite[][] matrica) {
		int m = matrica.length;
		int n = matrica[0].length;

		Strategjite[][] rez = new Strategjite[n][m];

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				rez[x][y] = matrica[y][x];
			}
		}

		return rez;
	}

	public static boolean rreshtNull(Strategjite[] rreshti) {
		boolean rez = false;
		for (int i = 0; i < rreshti.length; i++) {
			if (rreshti[i] == null) {
				rez = true;
			}
		}
		return rez;
	}

	private static boolean barazimiRreshtave(Strategjite[] r1, Strategjite[] r2) {
		boolean rez = true;
		for (int i = 0; i < r1.length; i++) {
			if (r1[i].st1 != r2[i].st1 || r1[i].st2 != r2[i].st2) {
				rez = false;
				break;
			}
		}
		return rez;
	}

	static boolean barazimiShtyllave(Strategjite[] sh1, Strategjite[] sh2) {
		boolean rez = true;
		for (int i = 0; i < sh1.length; i++) {
			if (sh1[i].st2 != sh2[i].st2 || sh1[i].st2 != sh2[i].st2) {
				rez = false;
				break;
			}
		}
		return rez;
	}

	public static int gjejIndeksin(Strategjite[][] matrica, Strategjite[] rreshti) {
		int rez = 0;
		for (int i = 0; i < matrica.length; i++) {
			if (barazimiRreshtave(matrica[i], rreshti)) {
				rez = i;
			}
		}
		return rez;
	}

	public static int gjejIndeksinShtylle(Strategjite[][] matrica, Strategjite[] rreshti) {
		matrica = Metodat.transpono(matrica);
		int rez = 0;
		for (int i = 0; i < matrica.length; i++) {
			if (barazimiShtyllave(matrica[i], rreshti)) {
				rez = i;
			}
		}
		return rez;
	}

	public static Strategjite[][] zevendesoRreshtat(Strategjite[][] matrica, Strategjite[] rreshti) {
		Strategjite[][] temp = new Strategjite[matrica.length][matrica[0].length];

		if (!rreshtNull(rreshti)) {
			int indeksi = gjejIndeksin(matrica, rreshti);

			temp[0] = matrica[indeksi];
			for (int k = 1; k < matrica.length; k++) {
				if (k <= indeksi)
					temp[k] = matrica[k - 1];
				else
					temp[k] = matrica[k];

			}

			return temp;
		} else
			return matrica;
	}

	public static Strategjite[][] zevendesoShtyllat(Strategjite[][] matrica, Strategjite[] shtylla) {
		Strategjite[][] matricaRe = transpono(matrica);
		Strategjite[][] temp = new Strategjite[matricaRe.length][matricaRe[0].length];

		if (!rreshtNull(shtylla)) {
			int indeksi = gjejIndeksin(matricaRe, shtylla);

			temp[0] = matricaRe[indeksi];
			for (int k = 1; k < temp.length; k++) {
				if (k <= indeksi)
					temp[k] = matricaRe[k - 1];
				else
					temp[k] = matricaRe[k];

			}

			return transpono(temp);
		} else
			return matrica;
	}

}
