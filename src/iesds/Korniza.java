package iesds;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

import java.awt.*;
import java.util.ArrayList;

public class Korniza extends JFrame implements ActionListener {
	Strategjite[][] loja;
	ArrayList<String> strategjiteShtylle;// = new ArrayList<String>("LCR");
	ArrayList<String> strategjiteRresht;// = new ArrayList<String>("UMD");

	Strategjite[][][] lojet;
	JButton butoni;
	int i = 1;
	int indeksiShtylle;
	int indeksiRresht;

	JLabel[][] labelat;
	JPanel tabela = new JPanel();

	public Korniza(Strategjite[][] loja, ArrayList<String> strategjiteRresht, ArrayList<String> strategjiteShtylle) {
		this.loja = loja;
		this.strategjiteRresht = strategjiteRresht;
		this.strategjiteShtylle = strategjiteShtylle;
		lojet = new Strategjite[2 * (loja.length + loja[0].length)][][];
		lojet[0] = loja;

		int n = loja.length;
		int m = loja[0].length;
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel matrica = new JPanel();
		matrica.setLayout(new BorderLayout());
		JPanel lojtari1 = new JPanel();
		lojtari1.setLayout(new GridLayout(n, 1));
		// lojtari1.setLayout(new BoxLayout(lojtari1, BoxLayout.PAGE_AXIS));
		lojtari1.setSize(400, 100);
		lojtari1.setBackground(Color.white);

		JLabel[] sL1 = new JLabel[n];
		for (int i = 0; i < n; i++) {
			sL1[i] = new JLabel("  " + strategjiteRresht.get(i) + "  ");
			lojtari1.add(sL1[i]);

		}
		JPanel lojtari2 = new JPanel();
		lojtari2.setLayout(new GridLayout(1, m + 1));
		lojtari2.setBackground(Color.white);
		// lojtari1.setLayout(new BoxLayout(lojtari1, BoxLayout.PAGE_AXIS));
		// lojtari2.setSize(400,100);

		JLabel[] sL2 = new JLabel[m + 1];
		// sL2[0] = new JLabel("1\\2");
		// lojtari2.add(sL2[0]);
		for (int i = 1; i < m + 1; i++) {
			sL2[i] = new JLabel(strategjiteShtylle.get(i - 1) + "");
			sL2[i].setHorizontalAlignment(JLabel.CENTER);
			lojtari2.add(sL2[i]);

		}
		matrica.add(lojtari2, BorderLayout.NORTH);
		matrica.add(lojtari1, BorderLayout.WEST);
		matrica.add(tabela, BorderLayout.CENTER);
		matrica.setBorder(BorderFactory.createEmptyBorder(20, 20, 50, 20));
		matrica.setBackground(Color.WHITE);

		tabela.setLayout(new GridLayout(n, m));
		labelat = new JLabel[n][m];
		Font fontiNumrave = new Font("Consolas", Font.PLAIN, 18);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				labelat[i][j] = new JLabel(" " + loja[i][j].toString() + " ");
				labelat[i][j].setBorder(new LineBorder(Color.black));
				labelat[i][j].setHorizontalAlignment(JLabel.CENTER);
				labelat[i][j].setVerticalAlignment(JLabel.CENTER);
				labelat[i][j].setBackground(new Color(240, 240, 240));
				labelat[i][j].setForeground(Color.black);
				labelat[i][j].setOpaque(true);
				labelat[i][j].setFont(fontiNumrave);
				tabela.add(labelat[i][j]);

			}
		}
		// tabela = new Paneli(loja);
		tabela.setBorder(BorderFactory.createEmptyBorder(0, 0, 02, 10));
		tabela.setBackground(Color.white);
		// c.add(tabela, BorderLayout.CENTER);
		c.add(matrica, BorderLayout.CENTER);

		JPanel paneliButonave = new JPanel();
		paneliButonave.setLayout(new FlowLayout());
		paneliButonave.setBackground(Color.white);
		Font fontiButonit = new Font("Calibri", Font.BOLD, 14);
		butoni = new JButton("Vazhdo hapin tjeter");
		butoni.addActionListener(this);
		butoni.setBackground(new Color(239, 240, 242));// e hirte
		butoni.setForeground(Color.black);
		butoni.setFont(fontiButonit);
		paneliButonave.add(butoni);
		c.add(paneliButonave, BorderLayout.SOUTH);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		c.setBackground(Color.white);

	}

	public void actionPerformed(ActionEvent e) {

		lojet[i] = Eliminimi.fshijRreshtin(lojet[i - 1]);

		boolean fshiRreshti = lojet[i].length != lojet[i - 1].length;
		if (fshiRreshti) {
			Strategjite[] st = Eliminimi.gjejRreshtinEVogel(lojet[i - 1]);
			indeksiRresht = Metodat.gjejIndeksin(lojet[i - 1], st);

			Strategjite[] stMadhe = Eliminimi.gjejRreshtinEMadh(lojet[i - 1]);
			int indeksiMadh = Metodat.gjejIndeksin(lojet[i - 1], stMadhe);
			// System.out.println("Indeksi rresht i madh:" +indeksiMadh);

			for (int k = 0; k < lojet[i - 1].length; k++) {
				for (int j = 0; j < lojet[i - 1][0].length; j++) {
					if (indeksiMadh == k) {
						labelat[k][j].setForeground(new Color(0, 128, 0));
						labelat[k][j].setFont(new Font("Consolas", Font.BOLD, 18));
					}
					if (indeksiRresht == k) {
						labelat[k][j].setForeground(new Color(244, 23, 31));
						labelat[k][j].setFont(new Font("Consolas", Font.BOLD, 18));
						// labelat[k][j].setForeground(Color.white);
					}

				}
			}
			JOptionPane.showMessageDialog(butoni,
					"Meqe strategjia e lojtarit te pare " + strategjiteRresht.get(indeksiRresht)
							+ " eshte rigorozisht e dominuar nga strategjia e tij " + strategjiteRresht.get(indeksiMadh)
							+ "\natehere e eliminojme.\n" + "Kliko OK(Ose Enter) per te pare lojen e re!");
			dispose();
			strategjiteRresht.remove(indeksiRresht);
			// System.out.println("STR I RI: "+ strategjiteShtylle.toString());
			new Korniza(lojet[i], strategjiteRresht, strategjiteShtylle);
		}

		lojet[i + 1] = Eliminimi.fshijShtyllen(lojet[i]);
		boolean fshiShtylla = lojet[i + 1][0].length != lojet[i][0].length;

		if (!fshiRreshti) {

			if (fshiShtylla) {
				Strategjite[] st = Eliminimi.gjejShtyllenEVogel(lojet[i]);
				indeksiShtylle = Metodat.gjejIndeksin(Metodat.transpono(lojet[i]), st);

				Strategjite[] stMadhe = Eliminimi.gjejShtyllenEMadhe(lojet[i]);
				int indeksiMadh = Metodat.gjejIndeksin(Metodat.transpono(lojet[i]), stMadhe);

				for (int k = 0; k < lojet[i].length; k++) {
					for (int j = 0; j < lojet[i][0].length; j++) {
						if (indeksiShtylle == j) {
							labelat[k][j].setForeground(new Color(244, 23, 31)); // kuqe
							labelat[k][j].setFont(new Font("Consolas", Font.BOLD, 18));
						}
						if (indeksiMadh == j) {
							labelat[k][j].setForeground(new Color(0, 128, 0));// gjelber
							labelat[k][j].setFont(new Font("Consolas", Font.BOLD, 18));
						}
					}
				}
				JOptionPane.showMessageDialog(butoni,
						"Meqe strategjia e lojtarit te dyte " + strategjiteShtylle.get(indeksiShtylle)
								+ " eshte rigorozisht e dominuar nga strategjia e tij "
								+ strategjiteShtylle.get(indeksiMadh) + "\natehere e eliminojme.\n"
								+ "Kliko OK(Ose Enter) per te pare lojen e re!");
				dispose();
				strategjiteShtylle.remove(indeksiShtylle);
				new Korniza(lojet[i + 1], strategjiteRresht, strategjiteShtylle);

			}

			if ((!fshiRreshti && !fshiShtylla) || ((lojet[i + 1].length == 1) && (lojet[i + 1][0].length == 1))) {

				if ((lojet[i + 1].length == 1) && (lojet[i + 1][0].length == 1)) {
					labelat[0][0].setForeground(new Color(0, 128, 0));
					labelat[0][0].setFont(new Font("Consolas", Font.BOLD, 18));
					JOptionPane.showMessageDialog(butoni, "Ky eshte cifti qe dy lojtare racionale do zgjedhin");

				} else {
					JOptionPane.showMessageDialog(butoni, "Loja nuk mund te reduktohet me shume!");
				}
				butoni.setEnabled(false);
			}
		}
		i = i + 2;

	}

}
