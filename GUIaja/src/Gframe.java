import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.security.cert.CollectionCertStoreParameters;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Gframe {

	private JFrame frame;
	private JTextField namaplayer;
	private JTextField kill;
	private JTextField death;
	private JTextField assist;
	private JTextField headshot;
	private JTable tabel;
	private DefaultTableModel border;
	ArrayList<Player> players = new ArrayList<Player>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gframe window = new Gframe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gframe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(Color.WHITE);
		frame.setBounds(100, 100, 893, 554);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		namaplayer = new JTextField();
		namaplayer.setBounds(113, 34, 148, 36);
		namaplayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(namaplayer);
		namaplayer.setColumns(10);

		JLabel lblPlayerName = new JLabel("PlayerName");
		lblPlayerName.setBounds(29, 37, 96, 31);
		frame.getContentPane().add(lblPlayerName);

		JLabel lblNewLabel = new JLabel("Kills");
		lblNewLabel.setBounds(29, 96, 45, 42);
		frame.getContentPane().add(lblNewLabel);

		kill = new JTextField();
		kill.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent z) {
				char x = z.getKeyChar();
				String key = String.valueOf(x);
				if(!(key.matches("(.*)[0-9](.*)")) && (x != 'b')) {
					z.consume();
				}
			}
		});
		kill.setBounds(113, 99, 148, 36);
		frame.getContentPane().add(kill);
		kill.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Death");
		lblNewLabel_1.setBounds(29, 189, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);

		death = new JTextField();
		death.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent z) {
				char x = z.getKeyChar();
				String key = String.valueOf(x);
				if(!(key.matches("(.*)[0-9](.*)")) && (x != 'b')) {
					z.consume();
				}
			}
		});
		death.setBounds(113, 179, 148, 36);
		frame.getContentPane().add(death);
		death.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Assist");
		lblNewLabel_2.setBounds(29, 265, 72, 22);
		frame.getContentPane().add(lblNewLabel_2);

		assist = new JTextField();
		assist.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent z) {
				char x = z.getKeyChar();
				String key = String.valueOf(x);
				if(!(key.matches("(.*)[0-9](.*)")) && (x != 'b')) {
					z.consume();
				}
			}
		});
		assist.setBounds(113, 258, 148, 36);
		frame.getContentPane().add(assist);
		assist.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Headshot");
		lblNewLabel_3.setBounds(29, 355, 72, 16);
		frame.getContentPane().add(lblNewLabel_3);

		headshot = new JTextField();
		headshot.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent z) {
				char x = z.getKeyChar();
				String key = String.valueOf(x);
				if(!(key.matches("(.*)[0-9](.*)")) && (x != 'b')) {
					z.consume();
				}
			}
		});
		headshot.setBounds(113, 345, 148, 36);
		frame.getContentPane().add(headshot);
		headshot.setColumns(10);

		JButton btninput = new JButton("Input Data");
		btninput.setBackground(new Color(218, 165, 32));
		btninput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String player = namaplayer.getText();
				String kills = kill.getText();
				String Assist = assist.getText();
				String Death = death.getText();
				String Headshot = headshot.getText() + "%";
				players.add(new Player(player, Headshot, kills, Assist, Death));
				border = (DefaultTableModel) tabel.getModel();
				Object[] x = new Object[5];
				Collections.sort(players, new kdaComparator());
				table();
				JOptionPane.showMessageDialog(null, "Data Sudah Tersimpan");
				namaplayer.setText("");
				kill.setText("");
				death.setText("");
				assist.setText("");
				headshot.setText("");
			}
		});
		btninput.setBounds(86, 408, 107, 31);
		frame.getContentPane().add(btninput);

		JButton btndlt = new JButton("Delete Data");
		btndlt.setBackground(new Color(218, 165, 32));
		btndlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus?", "Hapus Data", JOptionPane.YES_NO_OPTION);
				int row = tabel.getSelectedRow(); 
				if (row >= 0) {					
					if(confirm == 0) {
						border.removeRow(row);
						JOptionPane.showMessageDialog(null, "Data Sudah Terhapus");
					}				
				} else {
					JOptionPane.showMessageDialog(null, "Pilih baris yang akan dihapus");
				}
			}
		});
		btndlt.setBounds(355, 408, 107, 31);
		frame.getContentPane().add(btndlt);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(334, 37, 529, 334);
		frame.getContentPane().add(scrollPane);

		tabel = new JTable();
		tabel.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No.", "PlayerName", "Kills", "Assist", "Death", "Headshot", "KDA"
			}
		));
		tabel.getColumnModel().getColumn(1).setPreferredWidth(99);
		scrollPane.setViewportView(tabel);
		
		JButton topkill = new JButton("Top Kills");
		topkill.setBackground(new Color(218, 165, 32));
		topkill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Collections.sort(players, new topkillComparator());
				table();
			}
		});
		topkill.setBounds(215, 408, 122, 31);
		frame.getContentPane().add(topkill);
		
		JLabel lblNewLabel_4 = new JLabel("Leaderboards Player");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(358, 2, 200, 22);
		frame.getContentPane().add(lblNewLabel_4);
	}

	public void table() {
		border.setRowCount(0);
		Collections.reverse(players);
		for (int i = 0; i < players.size(); i++) {
			String nomor = String.valueOf(i+1);
			String player = players.get(i).namaplayer;
			String kills = players.get(i).getKills();
			String Assist = players.get(i).Assist;
			String Death = players.get(i).Death;
			String Headshot = players.get(i).Headshot;
			String kda = String.valueOf(players.get(i).getKda());
			Object[] data = new Object[7];
			data[0] = nomor;
			data[1] = player;
			data[2] = kills;
			data[3] = Assist;
			data[4] = Death;
			data[5] = Headshot;
			data[6] = kda;
			border.addRow(data);
		}
	}
}
