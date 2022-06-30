package counter;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class wydmuszkaa {


	private JFrame frame;
	private JTextField WYSZUKAJ;
	private JTextField textField_10;
	private JPasswordField passwordField;
	private JTextField loginField;
	private JButton btnWyloguj;
	private JTextField txtKontotoken;
	private JTextField Konto;
	private JTextField txtTypSprawy;
	private JPanel DaneKontaktowe;
	private JTextField txnDanekontaktowe;
	private JTextField txtImie;
	private JTextField Imie;
	private JTextField txtNazwisko;
	private JTextField Nazwisko;
	private JTextField txtTelefon;
	private JTextField Telefon;
	private JTextField txtEmail;
	private JTextField Email;
	private JButton IND_button;
	private JButton MSP_Button;
	private JButton Clear_button;
	private JTextField Ostatnia_sprawa_field;
	private JTextField txtSymptom;
	private JTextField symptom;
	private JComboBox SposobZalozenia;
	private JSlider WolumenSplider;
	private JTextField textField_6;

	private JTextField txtAdditionalInformation;
	private JTextField aditonalinformation;
	private JTextField txtSolution;
	private JTextField solution;
	private JTextField txtStatusComments;
	private JTextField statuscomments;
	private JTextField txtWolumenPracy;
	private JTextField Wolumen;
	private JTextField txtWyszukaj;
	private JTextField txtKategoria;
	private JComboBox Kategorie;
	private JScrollPane scrollPane_1;
	private JTable MEMO;
	private JTextField zalogowanyjako;
	private JTextField txtTematNotatki;
	private JTextField TEMAT_NOTATKI_CCB;
	private JTextField MEMO_CCB;
	private JTextField txnMEMO_CCB;
	private JTextField txtNotatka_CCB;
	private JTextField NOTATKA_CCB;
	private JTextField txtNumerReferencyjnyTransakcji_CCB;
	private JTextField numerreferencyjnytransakcji;
	private JTextField txtDataWaluty_CCB;
	private JTextField DATA_WLAUTY_CCB;


	public String Login;
	public char[] Password;
	public String CaseTypeID;
	public String ContactID;
	private String Baza_Spraw_Pending;
	private String[] split;
	private  File file;
	private  File umilator;
	private String OstatniaKonto;
	private String OstatniaImie; 
	private String OstatniaNazwisko; 
	private String OstatniaTelefon; 
	private String OstatniaEmail;
	private String Ostatniasymptom;
	private String Ostatniasolution;
	private String Ostatniaaditonalinformation;
	private String Ostatniastatuscomments;
	private String OstatniaTEMAT_NOTATKI_CCB;
	private String OstatniaMEMO_CCB;
	private String Ostatnianumerreferencyjnytransakcji;
	private String OstatniaDATA_WLAUTY_CCB;
	private String OstatniaNOTATKA_CCB;
	private String OstatniaWolumen;
	private String Smart;
	private String Memo;
	public String InquirySourceID;
	private BufferedReader bf;


	public void szlip() {	

		while (true) {


			try {

				while(!umilator.isFile())
				{
					TimeUnit.SECONDS.sleep(1);

				}
				BufferedReader xd = new BufferedReader(new FileReader(".\\HUB.txt"));
				String line = xd.readLine();
				split = line.split(";",-1);

				Konto.setText(split[4]);
				Imie.setText(split[0]);
				Nazwisko.setText(split[1]);
				Telefon.setText(split[2]);
				Email.setText(split[3]);
				SposobZalozenia.setSelectedIndex(1);		
				xd.close();
				umilator.delete();

			}
			catch(  Exception  e2) {	
				System.out.println("zaczytuje plik");

			}



		}
	}	




	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {




				try {
					wydmuszkaa window = new wydmuszkaa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public wydmuszkaa() {


		textField_6 = new JTextField();
		file= new File(".\\dataOUT.txt");
		umilator= new File(".\\HUB.txt");

		new Thread(this::szlip).start();

		initialize();
	}

	@SuppressWarnings("deprecation")
	private void initialize() {
		JTabbedPane tabbedPane;

		JPanel Formularz_Sprawy;
		JPanel TypSprawy;
		JPanel panel;
		JPanel panel_2;
		JPanel SYMPTOM_HD;

		JComboBox Klasa_postaci;
		JComboBox RecivedBy;
		JComboBox comboBox_2;

		JCheckBox PENDING;

		JLabel lblNewLabel;
		JLabel lblHaso;

		JButton btnNewButton_1;
		JButton btnNewButton_2;
		JButton btnNewButton; 
		JButton Zaloguj;

		String[] Nazwy_zespoly = new String[] {"Wybierz","HD", "CCB", "PLATYNA", "CS LORO"};

		DefaultTableModel dtm;

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(".\\StarsLogo.png"));
		frame.getContentPane().setBackground(new Color(51, 204, 255));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		////////////////////////////////////////////////////////////////////////////////////////

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setEnabled(false);
		tabbedPane.setBounds(-1, 55, 1085, 606);
		frame.getContentPane().add(tabbedPane);
		////////
		Formularz_Sprawy = new JPanel();	
		Formularz_Sprawy.setBackground(new Color(0, 204, 255));
		tabbedPane.addTab("Formularz Sprawy", null, Formularz_Sprawy, null);
		Formularz_Sprawy.setLayout(null);
		////////
		TypSprawy = new JPanel();
		TypSprawy.setBackground(new Color(51, 204, 255));
		TypSprawy.setForeground(Color.WHITE);
		TypSprawy.setBounds(10, 11, 510, 61);
		Formularz_Sprawy.add(TypSprawy);
		TypSprawy.setLayout(null);
		////////		 
		Klasa_postaci = new JComboBox();
		Klasa_postaci.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Klasa_postaci.setModel(new DefaultComboBoxModel(Nazwy_zespoly));
		Klasa_postaci.setBounds(256, 26, 89, 22);
		frame.getContentPane().add(Klasa_postaci);

		////////Interfejs logowania 

		lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(12, 11, 112, 16);
		frame.getContentPane().add(lblNewLabel);

		lblHaso = new JLabel("HAS\u0141O");
		lblHaso.setVerticalAlignment(SwingConstants.BOTTOM);
		lblHaso.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaso.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHaso.setBounds(134, 11, 112, 16);
		frame.getContentPane().add(lblHaso);



		passwordField = new JPasswordField();
		passwordField.setBounds(133, 27, 114, 20);
		frame.getContentPane().add(passwordField);

		loginField = new JTextField();
		loginField.setBounds(10, 27, 114, 20);
		frame.getContentPane().add(loginField);
		loginField.setColumns(10);

		zalogowanyjako = new JTextField();
		zalogowanyjako.setHorizontalAlignment(SwingConstants.CENTER);
		zalogowanyjako.setForeground(Color.WHITE);
		zalogowanyjako.setFont(new Font("Georgia", Font.BOLD, 14));
		zalogowanyjako.setEditable(false);
		zalogowanyjako.setColumns(10);
		zalogowanyjako.setBackground(new Color(0, 102, 204));
		zalogowanyjako.setBounds(12, 24, 431, 25);
		frame.getContentPane().add(zalogowanyjako);
		zalogowanyjako.setVisible(false);


		Zaloguj = new JButton("Zaloguj");
		Zaloguj.setBounds(355, 26, 105, 22);



		btnWyloguj = new JButton("Wyloguj");
		btnWyloguj.setForeground(Color.RED);
		btnWyloguj.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnWyloguj.setBounds(969, 22, 105, 22);
		frame.getContentPane().add(btnWyloguj);
		btnWyloguj.setVisible(false);

		Zaloguj.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(Zaloguj);

		txtTypSprawy = new JTextField();
		txtTypSprawy.setText("TYP SPRAWY");
		txtTypSprawy.setHorizontalAlignment(SwingConstants.CENTER);
		txtTypSprawy.setForeground(Color.WHITE);
		txtTypSprawy.setFont(new Font("Georgia", Font.BOLD, 14));
		txtTypSprawy.setEditable(false);
		txtTypSprawy.setColumns(10);
		txtTypSprawy.setBackground(new Color(0, 102, 204));
		txtTypSprawy.setBounds(0, 0, 510, 25);
		TypSprawy.add(txtTypSprawy);




		SposobZalozenia = new JComboBox();
		SposobZalozenia.setSelectedItem("Konto");
		SposobZalozenia.setMaximumRowCount(3);
		SposobZalozenia.setModel(new DefaultComboBoxModel(new String[] {"Token", "Konto", "Non-Client"}));
		SposobZalozenia.setBounds(10, 32, 129, 22);
		TypSprawy.add(SposobZalozenia);

		RecivedBy = new JComboBox();
		RecivedBy.setModel(new DefaultComboBoxModel(new String[] {"Phone", "Email", "Chat"}));
		RecivedBy.setBounds(203, 32, 126, 22);
		TypSprawy.add(RecivedBy);




		PENDING = new JCheckBox("PENDING");
		PENDING.setBackground(new Color(51, 204, 255));
		PENDING.setBounds(399, 32, 105, 23);
		TypSprawy.add(PENDING);



		DaneKontaktowe = new JPanel();
		DaneKontaktowe.setBounds(10, 70, 510, 200);
		DaneKontaktowe.setBackground(new Color(51, 204, 255));
		Formularz_Sprawy.add(DaneKontaktowe);
		DaneKontaktowe.setLayout(null);

		txnDanekontaktowe = new JTextField();
		txnDanekontaktowe.setText("DANE KONTAKTOWE");
		txnDanekontaktowe.setHorizontalAlignment(SwingConstants.CENTER);
		txnDanekontaktowe.setForeground(Color.WHITE);
		txnDanekontaktowe.setFont(new Font("Georgia", Font.BOLD, 14));
		txnDanekontaktowe.setEditable(false);
		txnDanekontaktowe.setColumns(10);
		txnDanekontaktowe.setBackground(new Color(0, 102, 204));
		txnDanekontaktowe.setBounds(0, 0, 510, 25);
		DaneKontaktowe.add(txnDanekontaktowe);

		txtKontotoken = new JTextField();
		txtKontotoken.setBounds(0, 36, 151, 20);
		DaneKontaktowe.add(txtKontotoken);
		txtKontotoken.setText("Konto/Token");
		txtKontotoken.setHorizontalAlignment(SwingConstants.CENTER);
		txtKontotoken.setForeground(Color.WHITE);
		txtKontotoken.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtKontotoken.setEditable(false);
		txtKontotoken.setColumns(10);
		txtKontotoken.setBackground(new Color(0, 102, 204));

		Konto = new JTextField();

		Konto.setHorizontalAlignment(SwingConstants.CENTER);
		Konto.setBounds(150, 36, 270, 20);
		DaneKontaktowe.add(Konto);
		Konto.setColumns(10);

		txtImie = new JTextField();
		txtImie.setText("Imie");
		txtImie.setHorizontalAlignment(SwingConstants.CENTER);
		txtImie.setForeground(Color.WHITE);
		txtImie.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtImie.setEditable(false);
		txtImie.setColumns(10);
		txtImie.setBackground(new Color(0, 102, 204));
		txtImie.setBounds(0, 67, 151, 20);
		DaneKontaktowe.add(txtImie);

		Imie = new JTextField();
		Imie.setHorizontalAlignment(SwingConstants.CENTER);
		Imie.setColumns(10);
		Imie.setBounds(150, 67, 270, 20);
		DaneKontaktowe.add(Imie);

		txtNazwisko = new JTextField();
		txtNazwisko.setText("Nazwisko");
		txtNazwisko.setHorizontalAlignment(SwingConstants.CENTER);
		txtNazwisko.setForeground(Color.WHITE);
		txtNazwisko.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtNazwisko.setEditable(false);
		txtNazwisko.setColumns(10);
		txtNazwisko.setBackground(new Color(0, 102, 204));
		txtNazwisko.setBounds(0, 98, 151, 20);
		DaneKontaktowe.add(txtNazwisko);

		Nazwisko = new JTextField();
		Nazwisko.setHorizontalAlignment(SwingConstants.CENTER);
		Nazwisko.setColumns(10);
		Nazwisko.setBounds(150, 98, 270, 20);
		DaneKontaktowe.add(Nazwisko);

		txtTelefon = new JTextField();
		txtTelefon.setText("Telefon");
		txtTelefon.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefon.setForeground(Color.WHITE);
		txtTelefon.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtTelefon.setEditable(false);
		txtTelefon.setColumns(10);
		txtTelefon.setBackground(new Color(0, 102, 204));
		txtTelefon.setBounds(0, 129, 151, 20);
		DaneKontaktowe.add(txtTelefon);

		Telefon = new JTextField();
		Telefon.setHorizontalAlignment(SwingConstants.CENTER);
		Telefon.setColumns(10);
		Telefon.setBounds(150, 129, 270, 20);
		DaneKontaktowe.add(Telefon);



		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBackground(new Color(0, 102, 204));
		txtEmail.setBounds(0, 160, 151, 20);
		DaneKontaktowe.add(txtEmail);

		Email = new JTextField();
		Email.setHorizontalAlignment(SwingConstants.CENTER);
		Email.setColumns(10);
		Email.setBounds(150, 160, 270, 20);
		DaneKontaktowe.add(Email);

		Konto.setEditable(true);
		Imie.setEditable(true);
		Nazwisko.setEditable(true);
		Telefon.setEditable(true);
		Email.setEditable(true);

		panel = new JPanel();
		panel.setBackground(new Color(51, 204, 255));
		panel.setBounds(10, 269, 510, 61);
		Formularz_Sprawy.add(panel);
		panel.setLayout(null);

		btnNewButton = new JButton("OSTATNIA SPRAWA");

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Konto.setText(OstatniaKonto);
				Imie.setText(OstatniaImie);
				Nazwisko.setText(OstatniaNazwisko);
				Telefon.setText(OstatniaTelefon);
				Email.setText(OstatniaEmail);
				symptom.setText(Ostatniasymptom);
				solution.setText(Ostatniasolution);
				aditonalinformation.setText(Ostatniaaditonalinformation);
				statuscomments.setText(Ostatniastatuscomments);
				TEMAT_NOTATKI_CCB.setText(OstatniaTEMAT_NOTATKI_CCB);
				MEMO_CCB.setText(OstatniaMEMO_CCB);
				numerreferencyjnytransakcji.setText(Ostatnianumerreferencyjnytransakcji);
				DATA_WLAUTY_CCB.setText(OstatniaDATA_WLAUTY_CCB);
				NOTATKA_CCB.setText(OstatniaNOTATKA_CCB);
				Wolumen.setText(OstatniaWolumen);




			}
		});


		btnNewButton.setBounds(10, 0, 200, 23);
		panel.add(btnNewButton);

		btnNewButton_1 = new JButton("ZAPISZ");
		btnNewButton_1.setBounds(10, 34, 89, 23);
		panel.add(btnNewButton_1);

		btnNewButton_2 = new JButton("WCZYTAJ");
		btnNewButton_2.setBounds(121, 34, 89, 23);
		panel.add(btnNewButton_2);

		Ostatnia_sprawa_field = new JTextField();
		Ostatnia_sprawa_field.setEditable(false);
		Ostatnia_sprawa_field.setBounds(220, 1, 280, 20);
		panel.add(Ostatnia_sprawa_field);
		Ostatnia_sprawa_field.setColumns(10);

		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(220, 34, 280, 22);
		panel.add(comboBox_2);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 204, 255));
		panel_2.setBounds(530, 11, 540, 550);
		Formularz_Sprawy.add(panel_2);
		panel_2.setLayout(null);

		txtWyszukaj = new JTextField();
		txtWyszukaj.setBounds(291, 0, 239, 25);
		txtWyszukaj.setText("WYSZUKAJ");
		txtWyszukaj.setHorizontalAlignment(SwingConstants.CENTER);
		txtWyszukaj.setForeground(Color.WHITE);
		txtWyszukaj.setFont(new Font("Georgia", Font.BOLD, 14));
		txtWyszukaj.setEditable(false);
		txtWyszukaj.setColumns(10);
		txtWyszukaj.setBackground(new Color(0, 102, 204));
		panel_2.add(txtWyszukaj);


		textField_6.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ( !(Character.isAlphabetic(c))&& (c != KeyEvent.VK_BACK_SPACE)&& (c != KeyEvent.VK_SPACE)) {
					e.consume();  // if it's not a number, ignore the event
				}
			}
		});


		textField_6.getDocument().addDocumentListener(new DocumentListener()
		{

			public void changedUpdate(DocumentEvent arg0) 
			{

			}
			public void insertUpdate(DocumentEvent arg0) 
			{
				DefaultTableModel Model = (DefaultTableModel)MEMO.getModel(); 
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(Model);
				MEMO.setRowSorter(tr);

				tr.setRowFilter(RowFilter.regexFilter(textField_6.getText().trim().toUpperCase()));
			}

			public void removeUpdate(DocumentEvent arg0) 
			{

				DefaultTableModel Model = (DefaultTableModel)MEMO.getModel(); 
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(Model);
				MEMO.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(textField_6.getText().trim().toUpperCase()));
			}
		});




		textField_6.setBounds(301, 25, 220, 20);
		textField_6.setColumns(10);
		panel_2.add(textField_6);

		txtKategoria = new JTextField();
		txtKategoria.setBounds(10, 0, 239, 25);
		txtKategoria.setText("KATEGORIA");
		txtKategoria.setHorizontalAlignment(SwingConstants.CENTER);
		txtKategoria.setForeground(Color.WHITE);
		txtKategoria.setFont(new Font("Georgia", Font.BOLD, 14));
		txtKategoria.setEditable(false);
		txtKategoria.setColumns(10);
		txtKategoria.setBackground(new Color(0, 102, 204));
		panel_2.add(txtKategoria);

		Kategorie = new JComboBox();
		Kategorie.setBounds(20, 24, 220, 22);
		panel_2.add(Kategorie);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setEnabled(false);



		scrollPane_1.getViewport().setBackground(Color.GRAY);

		scrollPane_1.setBounds(10, 56, 724, 483);
		panel_2.add(scrollPane_1);


		MEMO = new JTable();
		MEMO.setEnabled(false);

		MEMO.setModel(new DefaultTableModel(
				new Object[][] {
					{"", ""},
				},
				new String[] {
						"", ""
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		MEMO.getColumnModel().getColumn(0).setPreferredWidth(604);
		scrollPane_1.setViewportView(MEMO);

		MEMO.getTableHeader().setSize(2,30);
		MEMO.setForeground(Color.YELLOW);
		MEMO.setShowGrid(false);
		MEMO.setBackground(Color.GRAY);

		SYMPTOM_HD = new JPanel();
		SYMPTOM_HD.setBounds(10, 398, 510, 148);
		Formularz_Sprawy.add(SYMPTOM_HD);
		SYMPTOM_HD.setBackground(new Color(51, 204, 255));
		SYMPTOM_HD.setLayout(null);

		txtAdditionalInformation = new JTextField();
		txtAdditionalInformation.setText("ADDITIONAL INFORMATION");
		txtAdditionalInformation.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdditionalInformation.setForeground(Color.WHITE);
		txtAdditionalInformation.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtAdditionalInformation.setEditable(false);
		txtAdditionalInformation.setColumns(10);
		txtAdditionalInformation.setBackground(new Color(0, 102, 204));
		txtAdditionalInformation.setBounds(0, 83, 251, 20);
		SYMPTOM_HD.add(txtAdditionalInformation);

		aditonalinformation = new JTextField();
		aditonalinformation.setColumns(10);
		aditonalinformation.setBounds(10, 103, 241, 45);
		SYMPTOM_HD.add(aditonalinformation);

		txtSolution = new JTextField();
		txtSolution.setText("SOLUTION");
		txtSolution.setHorizontalAlignment(SwingConstants.CENTER);
		txtSolution.setForeground(Color.WHITE);
		txtSolution.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtSolution.setEditable(false);
		txtSolution.setColumns(10);
		txtSolution.setBackground(new Color(0, 102, 204));
		txtSolution.setBounds(0, 11, 251, 20);
		SYMPTOM_HD.add(txtSolution);

		solution = new JTextField();
		solution.setColumns(10);
		solution.setBounds(7, 30, 241, 45);
		SYMPTOM_HD.add(solution);

		txtStatusComments = new JTextField();
		txtStatusComments.setText("STATUS COMMENTS");
		txtStatusComments.setHorizontalAlignment(SwingConstants.CENTER);
		txtStatusComments.setForeground(Color.WHITE);
		txtStatusComments.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtStatusComments.setEditable(false);
		txtStatusComments.setColumns(10);
		txtStatusComments.setBackground(new Color(0, 102, 204));
		txtStatusComments.setBounds(259, 83, 251, 20);
		SYMPTOM_HD.add(txtStatusComments);

		statuscomments = new JTextField();
		statuscomments.setColumns(10);
		statuscomments.setBounds(269, 103, 241, 45);
		SYMPTOM_HD.add(statuscomments);

		symptom = new JTextField();
		symptom.setBounds(20, 356, 241, 45);
		Formularz_Sprawy.add(symptom);
		symptom.setHorizontalAlignment(SwingConstants.LEFT);
		symptom.setColumns(10);

		txtSymptom = new JTextField();
		txtSymptom.setBounds(10, 336, 251, 20);
		Formularz_Sprawy.add(txtSymptom);
		txtSymptom.setText("SYMPTOM");
		txtSymptom.setHorizontalAlignment(SwingConstants.CENTER);
		txtSymptom.setForeground(Color.WHITE);
		txtSymptom.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtSymptom.setEditable(false);
		txtSymptom.setColumns(10);
		txtSymptom.setBackground(new Color(0, 102, 204));




		Wolumen = new JTextField();
		Wolumen.setEditable(false);

		Wolumen.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();  // if it's not a number, ignore the event
				}
			}
		});



		Wolumen.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {

				try {
					int JackoRuszacz = Integer.parseInt(Wolumen.getText());


					WolumenSplider.setValue(JackoRuszacz);
				}
				catch(NumberFormatException xd)
				{
				}


			}
		});

		Wolumen.setBounds(465, 360, 27, 27);
		Formularz_Sprawy.add(Wolumen);
		Wolumen.setHorizontalAlignment(SwingConstants.CENTER);
		Wolumen.setColumns(10);

		txtWolumenPracy = new JTextField();
		txtWolumenPracy.setBounds(302, 336, 190, 20);
		Formularz_Sprawy.add(txtWolumenPracy);
		txtWolumenPracy.setText("WOLUMEN PRACY");
		txtWolumenPracy.setHorizontalAlignment(SwingConstants.CENTER);
		txtWolumenPracy.setForeground(Color.WHITE);
		txtWolumenPracy.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtWolumenPracy.setEditable(false);
		txtWolumenPracy.setColumns(10);
		txtWolumenPracy.setBackground(new Color(0, 102, 204));

		JPanel Symptom_CCB = new JPanel();
		Symptom_CCB.setBounds(10, 410, 510, 163);
		Formularz_Sprawy.add(Symptom_CCB);
		Symptom_CCB.setBackground(new Color(51, 204, 255));
		Symptom_CCB.setLayout(null);

		txtTematNotatki = new JTextField();
		txtTematNotatki.setText("TEMAT NOTATKI");
		txtTematNotatki.setHorizontalAlignment(SwingConstants.CENTER);
		txtTematNotatki.setForeground(Color.WHITE);
		txtTematNotatki.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtTematNotatki.setEditable(false);
		txtTematNotatki.setColumns(10);
		txtTematNotatki.setBackground(new Color(0, 102, 204));
		txtTematNotatki.setBounds(0, 0, 251, 18);
		Symptom_CCB.add(txtTematNotatki);

		TEMAT_NOTATKI_CCB = new JTextField();
		TEMAT_NOTATKI_CCB.setHorizontalAlignment(SwingConstants.LEFT);
		TEMAT_NOTATKI_CCB.setColumns(10);
		TEMAT_NOTATKI_CCB.setBounds(9, 18, 241, 27);
		Symptom_CCB.add(TEMAT_NOTATKI_CCB);

		MEMO_CCB = new JTextField();
		MEMO_CCB.setHorizontalAlignment(SwingConstants.LEFT);
		MEMO_CCB.setColumns(10);
		MEMO_CCB.setBounds(265, 18, 241, 27);
		Symptom_CCB.add(MEMO_CCB);

		txnMEMO_CCB = new JTextField();
		txnMEMO_CCB.setText("MEMO");
		txnMEMO_CCB.setHorizontalAlignment(SwingConstants.CENTER);
		txnMEMO_CCB.setForeground(Color.WHITE);
		txnMEMO_CCB.setFont(new Font("Georgia", Font.PLAIN, 14));
		txnMEMO_CCB.setEditable(false);
		txnMEMO_CCB.setColumns(10);
		txnMEMO_CCB.setBackground(new Color(0, 102, 204));
		txnMEMO_CCB.setBounds(261, 0, 251, 18);
		Symptom_CCB.add(txnMEMO_CCB);

		txtNotatka_CCB = new JTextField();
		txtNotatka_CCB.setText("NOTATKA");
		txtNotatka_CCB.setHorizontalAlignment(SwingConstants.CENTER);
		txtNotatka_CCB.setForeground(Color.WHITE);
		txtNotatka_CCB.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtNotatka_CCB.setEditable(false);
		txtNotatka_CCB.setColumns(10);
		txtNotatka_CCB.setBackground(new Color(0, 102, 204));
		txtNotatka_CCB.setBounds(0, 51, 251, 20);
		Symptom_CCB.add(txtNotatka_CCB);

		NOTATKA_CCB = new JTextField();
		NOTATKA_CCB.setHorizontalAlignment(SwingConstants.LEFT);
		NOTATKA_CCB.setColumns(10);
		NOTATKA_CCB.setBounds(9, 70, 241, 88);
		Symptom_CCB.add(NOTATKA_CCB);

		txtNumerReferencyjnyTransakcji_CCB = new JTextField();
		txtNumerReferencyjnyTransakcji_CCB.setText("NUMER REFERENCYJNY TRANSAKCJI");
		txtNumerReferencyjnyTransakcji_CCB.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumerReferencyjnyTransakcji_CCB.setForeground(Color.WHITE);
		txtNumerReferencyjnyTransakcji_CCB.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtNumerReferencyjnyTransakcji_CCB.setEditable(false);
		txtNumerReferencyjnyTransakcji_CCB.setColumns(10);
		txtNumerReferencyjnyTransakcji_CCB.setBackground(new Color(0, 102, 204));
		txtNumerReferencyjnyTransakcji_CCB.setBounds(255, 52, 251, 20);
		Symptom_CCB.add(txtNumerReferencyjnyTransakcji_CCB);

		numerreferencyjnytransakcji = new JTextField();
		numerreferencyjnytransakcji.setHorizontalAlignment(SwingConstants.LEFT);
		numerreferencyjnytransakcji.setColumns(10);
		numerreferencyjnytransakcji.setBounds(265, 70, 241, 27);
		Symptom_CCB.add(numerreferencyjnytransakcji);

		txtDataWaluty_CCB = new JTextField();
		txtDataWaluty_CCB.setText("DATA WALUTY");
		txtDataWaluty_CCB.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataWaluty_CCB.setForeground(Color.WHITE);
		txtDataWaluty_CCB.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtDataWaluty_CCB.setEditable(false);
		txtDataWaluty_CCB.setColumns(10);
		txtDataWaluty_CCB.setBackground(new Color(0, 102, 204));
		txtDataWaluty_CCB.setBounds(261, 103, 251, 20);
		Symptom_CCB.add(txtDataWaluty_CCB);

		DATA_WLAUTY_CCB = new JTextField();
		DATA_WLAUTY_CCB.setHorizontalAlignment(SwingConstants.LEFT);
		DATA_WLAUTY_CCB.setColumns(10);
		DATA_WLAUTY_CCB.setBounds(265, 122, 241, 27);
		Symptom_CCB.add(DATA_WLAUTY_CCB);
		Symptom_CCB.setVisible(false);

		JPanel Baza_Spraw = new JPanel();
		Baza_Spraw.setBackground(new Color(102, 204, 255));
		tabbedPane.addTab("Baza Spraw", null, Baza_Spraw, null);
		Baza_Spraw.setLayout(null);

		WYSZUKAJ = new JTextField();
		WYSZUKAJ.setBounds(10, 11, 190, 37);
		WYSZUKAJ.setText("WYSZUKAJ");
		WYSZUKAJ.setHorizontalAlignment(SwingConstants.CENTER);
		WYSZUKAJ.setForeground(new Color(255, 255, 255));
		WYSZUKAJ.setFont(new Font("Georgia", Font.PLAIN, 20));
		WYSZUKAJ.setEditable(false);
		WYSZUKAJ.setBackground(new Color(0, 102, 204));
		WYSZUKAJ.setColumns(10);
		Baza_Spraw.add(WYSZUKAJ);

		textField_10 = new JTextField();

		textField_10.setBounds(210, 22, 227, 20);
		textField_10.setColumns(10);
		Baza_Spraw.add(textField_10);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 1060, 514);
		Baza_Spraw.add(scrollPane);
		scrollPane.getViewport().setBackground(Color.black);


		String[] tblHead={"Data", "Użytkownik", "konto/token", "Memo", "Symptom", "Numer Sprawy", "Czas Pracy", "Pending", "Notatka", "Nr.Telefonu"};
		dtm=new DefaultTableModel(tblHead,0);
		JTable tbl=new JTable(dtm);
		tbl.getColumnModel().getColumn(0).setPreferredWidth(90);
		tbl.setForeground(Color.WHITE);
		scrollPane.setViewportView(tbl);
		tbl.setBackground(Color.black);

		textField_10.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ( !(Character.isAlphabetic(c))&& (c != KeyEvent.VK_BACK_SPACE)&& (c != KeyEvent.VK_SPACE)&& (c != KeyEvent.VK_MINUS)) {
					e.consume();  // if it's not a number, ignore the event
				}
			}
		});

		textField_10.getDocument().addDocumentListener(new DocumentListener()
		{

			public void changedUpdate(DocumentEvent arg0) 
			{


				DefaultTableModel Model = (DefaultTableModel)tbl.getModel(); 
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(Model);
				tbl.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(textField_10.getText().trim()));
			}
			public void insertUpdate(DocumentEvent arg0) 
			{


				DefaultTableModel Model = (DefaultTableModel)tbl.getModel(); 
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(Model);
				tbl.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(textField_10.getText().trim()));
			}

			public void removeUpdate(DocumentEvent arg0) 
			{


				DefaultTableModel Model = (DefaultTableModel)tbl.getModel(); 
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(Model);
				tbl.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(textField_10.getText().trim()));
			}
		});



		try {

			File DataBeseUp =new File(".\\DataBase.txt"); 

			bf = new BufferedReader(new FileReader(".\\DataBase.txt")); 

			while(bf.ready()) {

				String line = bf.readLine();

				String[] split = line.split(";",-1);
				dtm.insertRow(0, split);
			}

			bf.close(); 
		}
		catch(Exception c) {


		}


		scrollPane.setBackground(Color.BLACK);

		btnWyloguj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginField.setVisible(true);
				passwordField.setVisible(true);
				loginField.setText("");
				passwordField.setText("");		
				Zaloguj.setVisible(true);
				lblNewLabel.setVisible(true);
				lblHaso.setVisible(true);
				Klasa_postaci.setVisible(true);
				zalogowanyjako.setVisible(false);
				btnWyloguj.setVisible(false);
				tabbedPane.setEnabled(false);
				Formularz_Sprawy.setEnabled(false);
				scrollPane_1.setEnabled(false);
				MEMO.setEnabled(false);
				scrollPane_1.getViewport().setBackground(Color.GRAY);
				MEMO.setBackground(Color.GRAY);
			}
		});



		Zaloguj.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				zalogowanyjako.setText("Użytkownik [" + loginField.getText() +"], zalogowany jako: [" + Klasa_postaci.getSelectedItem()+"]" );
				Login = loginField.getText();
				Password = passwordField.getPassword();
				loginField.setVisible(false);
				passwordField.setVisible(false);
				Zaloguj.setVisible(false);
				lblNewLabel.setVisible(false);
				lblHaso.setVisible(false);
				Klasa_postaci.setVisible(false);
				zalogowanyjako.setVisible(true);
				btnWyloguj.setVisible(true);
				tabbedPane.setEnabled(true);
				Formularz_Sprawy.setEnabled(true);
				scrollPane_1.setEnabled(true);
				MEMO.setEnabled(true);
				scrollPane_1.getViewport().setBackground(Color.BLACK);
				MEMO.setBackground(Color.BLACK);









			}
		});	

		IND_button = new JButton("INW");
		IND_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SposobZalozenia.setSelectedItem("Non-Client");
				Imie.setText("KLIENT");
				Nazwisko.setText("INDYWIDUALNY");
				Telefon.setText("000000000");
				Email.setText("citiservice.polska@citi.com");
				symptom.setText("KLIENT INDYWIDUALNY");


			}
		});
		IND_button.setBounds(430, 36, 70, 23);
		DaneKontaktowe.add(IND_button);

		MSP_Button = new JButton("MSP");
		MSP_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				SposobZalozenia.setSelectedItem("Non-Client");
				Imie.setText("KLIENT");
				Nazwisko.setText("MSP");
				Telefon.setText("000000000");
				Email.setText("citiservice.polska@citi.com");
				symptom.setText("MSP");

			}
		});
		MSP_Button.setBounds(430, 67, 70, 23);
		DaneKontaktowe.add(MSP_Button);

		Clear_button = new JButton("CZYSC");
		Clear_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				czyszczenie();
			}
		});
		Clear_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Clear_button.setBounds(430, 160, 70, 23);
		DaneKontaktowe.add(Clear_button);

		WolumenSplider = new JSlider();

		WolumenSplider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				int slider = WolumenSplider.getValue();
				String slidertString = String.valueOf(slider);

				Wolumen.setText(slidertString);
				WolumenSplider.setToolTipText(slidertString);


			}
		});
		WolumenSplider.setBackground(new Color(0, 204, 255));
		WolumenSplider.setBorder(UIManager.getBorder("ScrollPane.border"));
		WolumenSplider.setForeground(Color.BLACK);
		WolumenSplider.setPaintTicks(true);
		WolumenSplider.setPaintLabels(true);
		WolumenSplider.setMinorTickSpacing(1);
		WolumenSplider.setMinimum(1);
		WolumenSplider.setMaximum(10);
		WolumenSplider.setValue(1);
		WolumenSplider.setBounds(302, 361, 164, 26);
		Formularz_Sprawy.add(WolumenSplider);

		RecivedBy.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (RecivedBy.getSelectedItem().toString()=="Phone") {

					ContactID="";

				}

				if (RecivedBy.getSelectedItem().toString()=="Email") {
					ContactID="2";
				}


				if (RecivedBy.getSelectedItem().toString()=="Chat") {
					ContactID="11";
				}

				if (RecivedBy.getSelectedItem().toString()=="Mail") {

					ContactID="9";

				}



			}
		});



		SposobZalozenia.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (SposobZalozenia.getSelectedItem().toString()=="Token") {

					CaseTypeID="1";
					InquirySourceID="";
					Konto.setEditable(true);
					Imie.setEditable(false);
					Nazwisko.setEditable(false);
					Telefon.setEditable(false);
					Email.setEditable(false);

				}

				else if (SposobZalozenia.getSelectedItem().toString()=="Konto") {
					CaseTypeID="2";
					InquirySourceID="";
					Konto.setEditable(true);
					Imie.setEditable(true);
					Nazwisko.setEditable(true);
					Telefon.setEditable(true);
					Email.setEditable(true);
				}


				else if (SposobZalozenia.getSelectedItem().toString()=="Non-Client") {
					CaseTypeID="3";
					InquirySourceID="";
					Konto.setEditable(false);
					Imie.setEditable(true);
					Nazwisko.setEditable(true);
					Telefon.setEditable(true);
					Email.setEditable(true);
				}

				else if (SposobZalozenia.getSelectedItem().toString()=="Client") {
					CaseTypeID="2";
					InquirySourceID="0";

					Konto.setEditable(true);
					Imie.setEditable(true);
					Nazwisko.setEditable(true);
					Telefon.setEditable(true);
					Email.setEditable(true);


				}



				else if (SposobZalozenia.getSelectedItem().toString()=="3rd Party Bank") {
					CaseTypeID="2";
					InquirySourceID="1";
					Konto.setEditable(true);
					Imie.setEditable(true);
					Nazwisko.setEditable(true);
					Telefon.setEditable(true);
					Email.setEditable(true);


				}

				else if (SposobZalozenia.getSelectedItem().toString()=="3rd Party Client") {
					CaseTypeID="2";
					InquirySourceID="2";
					Konto.setEditable(true);
					Imie.setEditable(true);
					Nazwisko.setEditable(true);
					Telefon.setEditable(true);
					Email.setEditable(true);


				}


				else if (SposobZalozenia.getSelectedItem().toString()=="Citi - Vendors") {
					CaseTypeID="2";
					InquirySourceID="12";
					Konto.setEditable(true);
					Imie.setEditable(true);
					Nazwisko.setEditable(true);
					Telefon.setEditable(true);
					Email.setEditable(true);


				}





			}
		});


		//wybór roli 
		Klasa_postaci.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if (Klasa_postaci.getSelectedItem().toString()=="HD") {
					SYMPTOM_HD.setVisible(true);
					Symptom_CCB.setVisible(false);
					Kategorie.setModel(new DefaultComboBoxModel(new String[] {"Helpdesk", "Awaria"}));	
					RecivedBy.setModel(new DefaultComboBoxModel(new String[] {"Phone", "Email", "Chat"}));	
					SposobZalozenia.setModel(new DefaultComboBoxModel(new String[] {"Token", "Konto", "Non-Client"}));
					SposobZalozenia.setSelectedIndex(0);
					RecivedBy.setSelectedIndex(0);
					Kategorie.setSelectedIndex(0);
					Wolumen.setText("1");
					WolumenSplider.setValue(1);

				}

				else if (Klasa_postaci.getSelectedItem().toString()=="CCB") {
					SYMPTOM_HD.setVisible(false);
					Symptom_CCB.setVisible(true);
					SposobZalozenia.setModel(new DefaultComboBoxModel(new String[] {"Client", "3rd Party Bank", "3rd Prarty Client", "Citi - Vendors"}));
					RecivedBy.setModel(new DefaultComboBoxModel(new String[] {"Phone", "Email", "Mail"}));
					Kategorie.setModel(new DefaultComboBoxModel(new String[] {"CHANNELS", "DOCUMENT FOR THE CLIENT", "NON-PRODUCT SPECIFIC", "PAYABLES", "RECEIVABLES", "TRADE","CARDS, LMS, FRAUD","Quick-Kill","Awaria"}));
					SposobZalozenia.setSelectedIndex(0);
					RecivedBy.setSelectedIndex(0);
					Kategorie.setSelectedIndex(0);
					Wolumen.setText("1");
					WolumenSplider.setValue(1);

				}


				else if (Klasa_postaci.getSelectedItem().toString()=="PLATYNA") {
					SYMPTOM_HD.setVisible(false);
					Symptom_CCB.setVisible(true);
					SposobZalozenia.setModel(new DefaultComboBoxModel(new String[] {"Client", "3rd Party Bank", "3rd Prarty Client", "Citi - Vendors"}));
					RecivedBy.setModel(new DefaultComboBoxModel(new String[] {"Phone", "Email", "Mail"}));
					Kategorie.setModel(new DefaultComboBoxModel(new String[] {"Non-Product Specific", "DOCUMENT FOR THE CLIENT", "Payables", "Receivables", "Trade", "CHANNELS","CARDS, LMS, FRAUD","Quick-Kill","Awaria"}));
					SposobZalozenia.setSelectedIndex(0);
					RecivedBy.setSelectedIndex(0);
					Kategorie.setSelectedIndex(0);
					Wolumen.setText("1");
					WolumenSplider.setValue(1);


				}

				else if (Klasa_postaci.getSelectedItem().toString()=="CS LORO") {
					SYMPTOM_HD.setVisible(false);
					Symptom_CCB.setVisible(true);
					Kategorie.setModel(new DefaultComboBoxModel(new String[] {"Gotówka", "CS LORO", "Post Facto", "SOiZB"}));
					SposobZalozenia.setModel(new DefaultComboBoxModel(new String[] {"Client", "3rd Party Bank", "3rd Prarty Client", "Citi - Vendors"}));
					RecivedBy.setModel(new DefaultComboBoxModel(new String[] {"Email", "SWIFT", "Mail", "Web"}));
					SposobZalozenia.setSelectedIndex(0);
					RecivedBy.setSelectedIndex(0);
					Kategorie.setSelectedIndex(0);


					Wolumen.setText("1");
					WolumenSplider.setValue(1);



				}
			}
		});


		//memo i smarty

		Kategorie.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {	

				if(Kategorie.getSelectedItem().toString()=="Helpdesk" && Klasa_postaci.getSelectedItem().toString()=="HD") {
					textField_6.setText("");
					MEMO.setRowSorter(null);
					MEMO.setModel(new DefaultTableModel(
							new Object[][] {
								{"P\u0141ATNO\u015ACI", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"MAIL- POTW. PRZELEW\u00D3W ORANGE /T-MOBILE/DHL/ CARREFOUR/UTC", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"LOGOWANIE", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"LOGOWANIE NA CZYJE\u015A KONTO", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"PRZEGLADARKA INTERNETOWA", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{" MOBILEPASS USTAWIENIE", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{" MOBILEPASS REAKTYWACJA", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"PYTANIA DOTYCZ\u0104CE PRODUKT\u00D3W, US\u0141UG, DZIALANIA SYSTEMU", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"AML", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"WYCI\u0104GI", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"EXPORT", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"IMPORT", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"XML /CFX", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"UPRAWNIENIA", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"AFRD", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"EWNIOSKI", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"NIE DOTYCZY EBHD", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"KLIENT IDYWIDUALNY", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"API", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"CTP", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"CITISFT", "Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"CDS", "Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"ADMINISTRATOR", "Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"SZKOLENIE INDYWIDUALNE", "Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"WEBINARIA", "Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"MAIL ONBOARDING","Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"INCYDENT", "Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"FRAUD","Channels > Application Errors / Issues > Application Investigation > CitiDirect BE > No Sub-Product"},

							},
							new String[] {
									"", ""
							}
							) {
						boolean[] columnEditables = new boolean[] {
								false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
					MEMO.getColumnModel().getColumn(0).setPreferredWidth(602);
					scrollPane_1.setViewportView(MEMO);


					RecivedBy.setSelectedIndex(0);


				}


				else if(Kategorie.getSelectedItem().toString()=="Awaria" && Klasa_postaci.getSelectedItem().toString()=="HD") {
					textField_6.setText("");
					MEMO.setRowSorter(null);
					MEMO.setModel(new DefaultTableModel(
							new Object[][] {
								{"AWARIA IMPORTU", "Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"AWARIA CITIDIRECT LOGOWANIE", "Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"AWARIA PŁATNOSCI", "Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"AWARIA DELPHI", "Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"AWARIA STATUSÓW", "Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"AWARIA DELPHI BRAK PLIKÓW", "Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},

							},
							new String[] {
									"", ""
							}
							) {
						boolean[] columnEditables = new boolean[] {
								false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
					MEMO.getColumnModel().getColumn(0).setPreferredWidth(602);
					scrollPane_1.setViewportView(MEMO);
					RecivedBy.setSelectedIndex(0);
				}



				else if(Kategorie.getSelectedItem().toString()=="CHANNELS" && Klasa_postaci.getSelectedItem().toString()=="CCB") {
					textField_6.setText("");
					MEMO.setRowSorter(null);
					MEMO.setModel(new DefaultTableModel(
							new Object[][] {
								{"ZABLOKOWANY TOKEN", "Channels > Application Access Issues > Safeword Problem > CitiDirect BE > No Sub-Product"},
								{"CitiDirect AWARIA", "Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"CitiDirect PYTANIA DOTYCZĄCE ZLECANIA PRZELEWU, PROBLEM Z LOGOWANIEM, IMPORTEM, WOLNY FORMAT", "Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"PRZEKIEROWANIA OGÓLNE", "Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"USTAWIENIE MOBILEPASS / Reset Mobilepass", "Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"WYCIĄGI NIE PODSTAWIŁY SIĘ", "Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"WYMIANA KARTY SW", "Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
							},
							new String[] {
									"", ""
							}
							) {
						boolean[] columnEditables = new boolean[] {
								false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
					MEMO.getColumnModel().getColumn(0).setPreferredWidth(602);
					scrollPane_1.setViewportView(MEMO);
					RecivedBy.setSelectedIndex(0);
				}


				else if(Kategorie.getSelectedItem().toString()=="DOCUMENT FOR THE CLIENT" && Klasa_postaci.getSelectedItem().toString()=="CCB") {
					textField_6.setText("");
					MEMO.setRowSorter(null);
					MEMO.setModel(new DefaultTableModel(
							new Object[][] {
								{"Audyt niestandardowy ","Documents for the client > Opinion/ Certificate > Audit -related Inquiry > Audit Certificate – Complex > no sub-type"},
								{"Audyt standardowy ","Documents for the client > Opinion/ Certificate > Audit -related Inquiry > Audit Certificate – Standard > no sub-type"},
								{"Opinie standardowe ","Documents for the client > Opinion/ Certificate > opinion > Standard opinion > Standard"},
								{"Opinie ze zdolnością  kredytową ","Documents for the client > Opinion/ Certificate > opinion > Non Standard opinion > creditworthiness"},
								{"Pisma urzędowe","Documents for the client > Opinion/ Certificate > Legal > Legal Certificate > no sub-type"},
								{"Potwierdzenia archiwalne powyżej 1 mc krajowe ","Documents for the client > Opinion/ Certificate > proof of payment > Archived payment > national"},
								{"Potwierdzenia archiwalne powyżej 1 mc zagraniczne","Documents for the client > Opinion/ Certificate > proof of payment > Archived payment > foregin"},
								{"Potwierdzenia bieżące krajowe ","Documents for the client > Opinion/ Certificate > proof of payment > Current payment > national"},
								{"Potwierdzenia bieżące zagraniczne ","Documents for the client > Opinion/ Certificate > proof of payment > Current payment > foregin"},
								{"Raporty Cititidrect ","Documents for the client > Opinion/ Certificate > reports > Citidirect reports > no sub-type"},
								{"Użytkownicy citidirect ","Documents for the client > Opinion/ Certificate > certificate > Non Standard Certificate > citidirect"},
								{"Wszystkie inne opinie niestandardowe (np.z wysokością środków, z saldem, z kredytem, z podaniem informacji o wszystkich rachunkach itd.)","Documents for the client > Opinion/ Certificate > opinion > Non Standard opinion > other"},
								{"Wszystkie inne raporty  z danymi bankowymi ","Documents for the client > Opinion/ Certificate > reports > Others reports > no sub-type"},
								{"Wszystkie inne zaświadczenia nie wymienione powyżej  niestandardowe (np.z wysokością środków, osoby z kwp, z kredytem, itd.)","Documents for the client > Opinion/ Certificate > certificate > Non Standard Certificate > other"},
								{"Zaświadczenie - O saldach ","Documents for the client > Opinion/ Certificate > certificate > Standard Certificate > account balances"},
								{"Zaświadczenie - Otwarcie rachunku ","Documents for the client > Opinion/ Certificate > certificate > Standard Certificate > account  openly "},
								{"Zaświadczenie - Prowadzenie rachunku ","Documents for the client > Opinion/ Certificate > certificate > Standard Certificate > account leading"},
								{"Zaświadczenie - Zamknięcie rachunku","Documents for the client > Opinion/ Certificate > certificate > Standard Certificate > account close"},
							},
							new String[] {
									"", ""
							}
							) {
						boolean[] columnEditables = new boolean[] {
								false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
					MEMO.getColumnModel().getColumn(0).setPreferredWidth(602);
					scrollPane_1.setViewportView(MEMO);
					RecivedBy.setSelectedIndex(0);
				}



				else if(Kategorie.getSelectedItem().toString()=="NON-PRODUCT SPECIFIC" && Klasa_postaci.getSelectedItem().toString()=="CCB") {
					textField_6.setText("");
					MEMO.setRowSorter(null);
					MEMO.setModel(new DefaultTableModel(
							new Object[][] {
								{"Aktywacja karty IVR ","Non-Product Specific > Application Access Request > Client Activation > No Product > IVR"},
								{"AUDYT zapytania","Non-Product Specific > Audit - Related Inquiry > Audit Certificate > No Product > No Sub-Product"},
								{"Braki danych GIIF/ AML","Non-Product Specific > Incomplete Documentation > AML / GIIF - Missing Representative Data > No Product > No Sub-Product"},
								{"Clint Touchpoint Call - Różne, szybkie pytania ","Non-Product Specific > Client Touchpoint Call > No Sub-Type > No Product > No Sub-Product"},
								{"Dokumentacja Klienta (różne) - status","Non-Product Specific > Account Documentation > No Sub-Type > No Product > No Sub-Product"},
								{"Kompletowanie dokumentacji - przesyłanie wniosków, weryfikacja","Non-Product Specific > Account Documentation > Completing Documents > No Product > No Sub-Product"},
								{"Niestandardowy raport","Non-Product Specific > Statement Or Report Request > Customized Report > Service Review > Global Review"},
								{"Nowy Klient - Welcome email / welcome call","Non-Product Specific > Client Touchpoint Call > New Client > No Product > No Sub-Product"},
								{"Problem z resetem hasła karty IVR ","Non-Product Specific > Application Access Issues > Password Reset > No Product > IVR"},
								{"Regeneracja wyciągów","Non-Product Specific > Statement Or Report Request > Statement Regeneration > No Product > No Sub-Product"},
								{"Szkolenie  /  CALL  /  Wizyta u klienta","Non-Product Specific > Client Visit > No Sub-Type > No Product > No Sub-Product"},
								{"Wyjaśnienie wszelkich opłat nie związanych z płatnościami","Non-Product Specific > Charges / Fees Inquiry > No Sub-Type > No Product > No Sub-Product"},
								{"Zajęcia komornicze","Non-Product Specific > Account Documentation > Execution Order > No Product > No Sub-Product"},
								{"Zamknięcie rachunków - inne ","Non-Product Specific > Account Closure Request > Account Closures > No Product > Global Billing"},
								{"Zapytania o wyciągi, JPK","Non-Product Specific > Statement Or Report Request > No Sub-Type > No Product > No Sub-Product"},
								{"Zapytanie o saldo rachunku ","Non-Product Specific > Account Balance Inquiry > No Sub-Type > No Product > No Sub-Product"},
								{"Zapytanie/ dochodzenie w sprawie Salda Końca Roku ","Non-Product Specific > Account Balance Inquiry > End Of Year Balance Inquiry > No Product > No Sub-Product"},
								{"Zgłoszenie błędnych ustawień na rachunkach","Non-Product Specific > Account Maintenance > No Sub-Type > No Product > No Sub-Product"},
							},
							new String[] {
									"", ""
							}
							) {
						boolean[] columnEditables = new boolean[] {
								false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
					MEMO.getColumnModel().getColumn(0).setPreferredWidth(602);
					scrollPane_1.setViewportView(MEMO);
					RecivedBy.setSelectedIndex(0);
				}



				else if(Kategorie.getSelectedItem().toString()=="PAYABLES" && Klasa_postaci.getSelectedItem().toString()=="CCB") {
					textField_6.setText("");
					MEMO.setRowSorter(null);
					MEMO.setModel(new DefaultTableModel(
							new Object[][] {
								{"Anulowanie płatności krajowej","Payables > Payment Cancellation > No Sub-Type > Funds Transfer > Funds Transfer - Domestic"},
								{"Anulowanie płatności zagranicznej","Payables > Payment Cancellation > No Sub-Type > Funds Transfer > Funds Transfer - Cross-Border"},
								{"Brak BDW/ brak szczegolow na BDW","Payables > Incomplete Documentation > Deposit Slip Copy > Funds Transfer > PLUS Payment"},
								{"BRAK SRODKOW _KRAJ","Payables > Unable To Effect Payment > Insufficient Funds > Funds Transfer > Funds Transfer - Domestic"},
								{"BRAK ŚRODKÓW_ZAGR","Payables > Unable To Effect Payment > Insufficient Funds > Funds Transfer > Funds Transfer - Cross-Borde"},
								{"Callback MIFT","Payables > Payment Transfer Request > MIFT Callback > Funds Transfer > Funds Transfer - Domestic"},
								{"DIRECT DEBIT ogólna kategoria","Payables > Payment Status > No Sub-Type > Direct Debit > Domestic Direct Debit"},
								{"Informacja  o monetach do odebrania, o korektach, blednie przelanych srodkach i ich wyksiegowaniu, ksiegowaniu na awarie, zatrzymania fałszywych znaków pieniężnych expres pieniężny","Payables > Client Touchpoint Call > No Sub-Type > Funds Transfer > PLUS Payment"},
								{"Korekta detali, nazwa bene  - płatność zagraniczna","Payables > Payment Amendment > Amend Beneficiary > Funds Transfer > Funds Transfer - Cross-Border"},
								{"Monitorowanie przepływu płatności krajowej (SORBNET)","Payables > Payment Monitoring > No Sub-Type > Funds Transfer > Funds Transfer - Domestic"},
								{"Monitorowanie przepływu płatności zagranicznej","Payables > Payment Monitoring > No Sub-Type > Funds Transfer > Funds Transfer - Cross-Border"},
								{"Odblokowanie książeczki czekowej","Payables > Check Book Request > No Sub-Type > Check > No Sub-Product"},
								{"OPLATY dotyczące przelewów","Payables > Charges / Fees Inquiry > No Sub-Type > Funds Transfer > Funds Transfer - Cross-Border"},
								{"Potwierdzenie płatności krajowej","Payables > Proof Of Payment > Archived Payment - Complex > Funds Transfer > Funds Transfer - Domestic"},
								{"Potwierdzenie realizacji płatności po stronie banku bene (Credit confirmation) - reklamacja ","Payables > Beneficiary Claims Non-Receipt > No Sub-Type > Funds Transfer > Funds Transfer - Cross-Border"},
								{"Potwierdzenie realizacji płatności po stronie banku bene (Credit confirmation) - reklamacja przekazy pocztowe","Payables > Beneficiary Claims Non-Receipt > No Sub-Type > Funds Transfer > Postal Orders"},
								{"Prosba Klienta o BDW","Payables > Unable To Apply Funds > Deposits > Funds Transfer > PLUS Payment"},
								{"Prosba klienta o protokoły róznic, zestawienia vendo","Payables > Payment Documents > No Sub-Type > Funds Transfer > PLUS Payment"},
								{"Prośba o księgowanie, szczegóły płatności, godzina księgowania","Payables > Transaction Details Request > No Sub-Type > Funds Transfer > Funds Transfer - Domestic"},
								{"Prośba o SWIFT zrealizowanej płatności","Payables > Proof Of Payment > Swift Copy > Funds Transfer > Funds Transfer - Cross-Border"},
								{"Przelew papierowy / MIFT","Payables > Payment Transfer Request > MIFT Payment > Funds Transfer > Funds Transfer - Domestic"},
								{"Status płatności krajowej ","Payables > Payment Status > No Sub-Type > Funds Transfer > Funds Transfer - Domestic"},
								{"Status płatności zagranicznej","Payables > Payment Status > No Sub-Type > Funds Transfer > Funds Transfer - Cross-Border"},
								{"Wyjaśnienie ksiegowania,  opóźnienie w ksiegowaniu, wyjasnienie roznic we wplatach (klient zgłasza zapytanie do księgowania jakie ma juz na wyciągu), problemy z deponowaniem wpłat na poczcie, brak księgowania","Payables > Cash Reconcilement Issue > Vendor Review > Funds Transfer > PLUS Payment"},
								{"Wyjaśnienie księgowań Split payment","Payables > Transaction Details Request > Tax / Social Security Office Payment > Funds Transfer > Funds Transfer - Domestic"},
								{"Zapytanie o COT zapytania ogólne","Payables > Client Touchpoint Call > No Sub-Type > Funds Transfer > PLUS Payment"},
								{"Zapytanie o czek","Payables > Check Status > No Sub-Type > Check > No Sub-Product"},
								{"Zmiana daty waluty przed realizacją, VD0","Payables > Payment Amendment > Amend Value Date > Funds Transfer > Funds Transfer - Cross-Border"},
								{"Zwrot środków płatności krajowej, zapytanie","Payables > Return Of Funds > No Sub-Type > Funds Transfer > Funds Transfer - Domestic"},
								{"Zwrot środków płatności zagranicznej, zapytanie","Payables > Return Of Funds > No Sub-Type > Funds Transfer > Funds Transfer - Cross-Border"},
							},
							new String[] {
									"", ""
							}
							) {
						boolean[] columnEditables = new boolean[] {
								false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
					MEMO.getColumnModel().getColumn(0).setPreferredWidth(602);
					scrollPane_1.setViewportView(MEMO);
					RecivedBy.setSelectedIndex(0);
				}

				else if(Kategorie.getSelectedItem().toString()=="RECEIVABLES" && Klasa_postaci.getSelectedItem().toString()=="CCB") {
					textField_6.setText("");
					MEMO.setRowSorter(null);
					MEMO.setModel(new DefaultTableModel(
							new Object[][] {
								{"Błedy w dowodach wpłaty, brak wypełnionych pól w BDW, błedny lub brak numeru rachunku na BDW","Receivables > Incomplete Documentation > Deposit Slip Copy > Cash > Closed Cash Deposits"},
								{"Brak BDW w zdeponowanym pakiecie- PROSBA Z BANKU DO KLIENTA","Receivables > Incomplete Documentation > No Deposit Slip > Cash > Closed Cash Deposits"},
								{"Brak właczenia lokalizacji, brak aktualnej listy konwojentów","Receivables > Incomplete Documentation > No Sub-Type > Cash > Closed Cash Deposits"},
								{"Informacja do Klienta o:  wykonanych korektach, róznicach we wpłacie","Receivables > Cash Reconcilement Issue > No Sub-Type > Cash > Closed Cash Deposits"},
								{"Informacja do/od Klienta o: zwrot/dostarczenie kluczy, worków, banknotów i monet nie spełniających wymogów NBP, dodatkowych elementów opakowań, etc., ","Receivables > Client Touchpoint Call > No Sub-Type > Cash > Closed Cash Deposits"},
								{"Opóźnienia w księgowaniu wpłat, błędne/brak księgowania wpłat, prośba Klienta o sprawdzenie poprawności księgowań wpłat, różnic prowizji, etc","Receivables > Cash Deposit Request > Delayed Deposit > Cash > Closed Cash Deposits"},
								{"Prośba od Klienta o skan BDW, raporty, rozliczenia vendo, protokoły różnic, protokoły zatrzymania fałszywych znaków pieniężnych","Receivables > Cash Reconcilement Issue > Additional Details Request > Cash > Closed Cash Deposits"},
								{"PUNKTY KASOWE pytania od banku do Klienta","Receivables > Cash Pickup Request > Cash Not Picked Up > Cash > Open Cash Deposits"},
								{"PUNKTY KASOWE pytania od Klienta do Banku","Receivables > Cash Reconcilement Issue > Additional Details Request > Cash > Open Cash Deposits"},
								{"Sprawy zwiazane z roznicami do wplat zamknietych (zazwyczaj potwierdzenie monitoringu) zglaszane przez klienta,","Receivables > Cash Reconcilement Issue > Vendor Review > Cash > Closed Cash Deposits"},
								{"ZASILENIA: anulowanie zasilenia, nieodebrane zasilenie, błędna dyspozycja zasilenia, różnice w zasileniach/wypłatach,","Receivables > Cash Delivery Request > Cash not Delivered > Cash > Closed Cash Deposits"},
								{"Zgłoszenia dotyczące konwojów","Receivables > Cash Pickup Request > Cash Not Picked Up > Cash > Closed Cash Deposits"},
							},
							new String[] {
									"", ""
							}
							) {
						boolean[] columnEditables = new boolean[] {
								false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
					MEMO.getColumnModel().getColumn(0).setPreferredWidth(602);
					scrollPane_1.setViewportView(MEMO);
					RecivedBy.setSelectedIndex(0);
				}	

				else if(Kategorie.getSelectedItem().toString()=="TRADE" && Klasa_postaci.getSelectedItem().toString()=="CCB") {
					textField_6.setText("");
					MEMO.setRowSorter(null);
					MEMO.setModel(new DefaultTableModel(
							new Object[][] {
								{"Akredytywa eksportowa - Weryfikacja dokumentów, prośba o wnioski, ogólne zapytania","Trade > Trade Document Processing Status > Document copy > Trade Services > Export Letter Of Credit"},
								{"Akredytywa importowa - Weryfikacja dokumentów, prośba o wnioski, ogólne zapytania","Trade > Trade Document Processing Status > Document copy > Trade Services > Import Letter Of Credit"},
								{"Dokumenty trade / przesyłki","Trade > Courier Or Package Tracking Info > No Sub-Type > Trade Services > Import Letter Of Credit"},
								{"Factoring -  ogólne zapytania","Trade > Trade Document Processing Status > No Sub-Type > Trade Finance > Global Accounts Receivable Finance"},
								{"Factoring -  zapytania dotyczące płatności","Trade > Payment Transfer Request > No Sub-Type > Trade Finance > Global Accounts Receivable Finance"},
								{"Gwarancja - Weryfikacja dokumentów, prośba o wnioski, ogólne zapytania","Trade > Trade Document Processing Status > No Sub-Type > Trade Services > Guarantees"},
								{"Inkaso eksportowe - Weryfikacja dokumentów, prośba o wnioski, ogólne zapytania","Trade > Trade Document Processing Status > Document copy > Trade Services > Export Collection"},
								{"Inkaso importowe - Weryfikacja dokumentów, prośba o wnioski, ogólne zapytania","Trade > Trade Document Processing Status > Document copy > Trade Services > Import Collection"},
								{"Kopia faktury","Trade > Trade Document Processing Status > Document copy > Trade Finance > Pre-Shipment Finance"},
								{"Trady ogólne","Trade > Client Feedback > No Sub-Type > Non-Product > No Sub-Product"},
							},
							new String[] {
									"", ""
							}
							) {
						boolean[] columnEditables = new boolean[] {
								false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
					MEMO.getColumnModel().getColumn(0).setPreferredWidth(602);
					scrollPane_1.setViewportView(MEMO);
					RecivedBy.setSelectedIndex(0);

				}	

				else if(Kategorie.getSelectedItem().toString()=="CARDS, LMS, FRAUD" && Klasa_postaci.getSelectedItem().toString()=="CCB") {
					textField_6.setText("");
					MEMO.setRowSorter(null);
					MEMO.setModel(new DefaultTableModel(
							new Object[][] {
								{"Fraud - zewnętrzny/ atak hakerski","Corporate Banking > Fraud - Related Inquiry > Citi Other Channels Attack > Funds Transfer > No Sub-Product"},
								{"FRAUD , fraud wewnętrzny po stronie banku, wewnętrzny po stronie Klienta","Corporate Banking > Fraud - Related Inquiry > Client Internal Fraud > Funds Transfer > No Sub-Product  "},
								{"Karty - wszelkie zapytania, wnioski, statusy, zwroty","Wholesale Cards > Client Feedback > No Sub-Type > Non-Product > No Sub-Product"},
								{"Założenie lokaty / Depozyt","LMS > Deposit Booking Request > No Sub-Type > Fixed Term Deposit > Time Deposits"},
								{"Zerwanie lokaty / Depozyt","LMS > Deposit Break Request > No Sub-Type > Fixed Term Deposit > Time Deposits"},
								{"Zerwanie lokaty / Depozyt","LMS > Deposit Break Request > No Sub-Type > Fixed Term Deposit > Time Deposits"},
							},
							new String[] {
									"", ""
							}
							) {
						boolean[] columnEditables = new boolean[] {
								false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
					MEMO.getColumnModel().getColumn(0).setPreferredWidth(602);
					scrollPane_1.setViewportView(MEMO);
					RecivedBy.setSelectedIndex(0);

				}	

				else if(Kategorie.getSelectedItem().toString()=="Quick-Kill" && Klasa_postaci.getSelectedItem().toString()=="CCB") {
					textField_6.setText("");
					MEMO.setRowSorter(null);
					MEMO.setModel(new DefaultTableModel(
							new Object[][] {
								{"Przekierowanie rozmowy","Channels > Client Training Opportunity > How Do I? > CitiDirect BE > No Sub-Product"},
								{"Przekierowanie rozmowy do doradcy","Non-Product Specific > Client Touchpoint Call > No Sub-Type > No Product > No Sub-Product"},
								{"Klient niezweryfikowany","Non-Product Specific > Client Touchpoint Call > No Sub-Type > No Product > No Sub-Product"},
								{"Przekierowanie Detal","Non-Product Specific > Client Touchpoint Call > No Sub-Type > No Product > No Sub-Product"},
								{"Przekierowanie MSP","Non-Product Specific > Client Touchpoint Call > No Sub-Type > No Product > No Sub-Product"},
								{"Przekierowanie na KARTY","Wholesale Cards > Client Feedback > No Sub-Type > Non-Product > No Sub-Product"},
							},
							new String[] {
									"", ""
							}
							) {
						boolean[] columnEditables = new boolean[] {
								false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
					MEMO.getColumnModel().getColumn(0).setPreferredWidth(602);
					scrollPane_1.setViewportView(MEMO);
					RecivedBy.setSelectedIndex(0);

				}	


				else if(Kategorie.getSelectedItem().toString()=="Awaria" && Klasa_postaci.getSelectedItem().toString()=="CCB") {
					textField_6.setText("");
					MEMO.setRowSorter(null);
					MEMO.setModel(new DefaultTableModel(
							new Object[][] {
								{"AWARIA IMPORTU","Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"AWARIA CITIDIRECT LOGOWANIE","Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"AWARIA PŁATNOSCI","Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"AWARIA DELPHI","Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"AWARIA STATUSÓW","Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"AWARIA DELPHI BRAK PLIKÓW","Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
								{"INTERFACE","Channels > Application Errors / Issues > Defect Fix In Progress > CitiDirect BE > No Sub-Product"},
							},
							new String[] {
									"", ""
							}
							) {
						boolean[] columnEditables = new boolean[] {
								false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
					MEMO.getColumnModel().getColumn(0).setPreferredWidth(602);
					scrollPane_1.setViewportView(MEMO);
					RecivedBy.setSelectedIndex(0);
				}	


			}
		});







		MEMO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				zakladanie_sprawy(PENDING, RecivedBy, dtm);
			}
		});

	}
	private void prep_ostatnia_sprawa() {

		OstatniaKonto = Konto.getText();
		OstatniaImie = Imie.getText();
		OstatniaNazwisko = Nazwisko.getText();
		OstatniaTelefon = Telefon.getText();
		OstatniaEmail = Email.getText();
		Ostatniasymptom = symptom.getText();
		Ostatniasolution= solution.getText();
		Ostatniaaditonalinformation= aditonalinformation.getText();
		Ostatniastatuscomments= statuscomments.getText();
		OstatniaTEMAT_NOTATKI_CCB = TEMAT_NOTATKI_CCB.getText();
		OstatniaMEMO_CCB= MEMO_CCB.getText();
		Ostatnianumerreferencyjnytransakcji= numerreferencyjnytransakcji.getText();
		OstatniaDATA_WLAUTY_CCB= DATA_WLAUTY_CCB.getText();
		OstatniaNOTATKA_CCB= NOTATKA_CCB.getText();
		OstatniaWolumen= Wolumen.getText();
		Ostatnia_sprawa_field.setText(OstatniaKonto+" "+ OstatniaImie+" "+ OstatniaNazwisko+" "+ Ostatniasymptom);

	}

	private void czyszczenie () {

		Konto.setText("");
		Imie.setText("");
		Nazwisko.setText("");
		Telefon.setText("");
		Email.setText("");
		symptom.setText("");
		solution.setText("");
		aditonalinformation.setText("");
		statuscomments.setText("");
		TEMAT_NOTATKI_CCB.setText("");
		MEMO_CCB.setText("");
		numerreferencyjnytransakcji.setText("");
		DATA_WLAUTY_CCB.setText("");
		NOTATKA_CCB.setText("");
		Wolumen.setText("1");
		WolumenSplider.setValue(1);

	}

	private void zakladanie_sprawy(JCheckBox PENDING, JComboBox RecivedBy,DefaultTableModel dtm) {
		try {

			System.out.println(MEMO.getValueAt(MEMO.getSelectedRow(), 0).toString());
			System.out.println(MEMO.getValueAt(MEMO.getSelectedRow(), 1).toString());

			Memo =  MEMO.getValueAt(MEMO.getSelectedRow(), 0).toString();       
			Smart =   MEMO.getValueAt(MEMO.getSelectedRow(), 1).toString();      
		}
		catch(Exception chuj){
			System.out.print("niedostepna tabela");

		}


		String Csum;
		Random rand = new Random();
		Csum = String.format("%04d", rand.nextInt(10000));


		String Token_Account = Konto.getText().trim();


		String Name= Imie.getText();
		String LastName = Nazwisko.getText();
		String PhoneNumber = Telefon.getText();
		String Email_plik= Email.getText();
		String Pending;
		if (PENDING.isSelected()) {
			Pending = "0";
			Baza_Spraw_Pending ="tak";
		}
		else {
			Pending = "1";
			Baza_Spraw_Pending ="nie";
		}
		String Volume = Wolumen.getText();
		String Symptom= symptom.getText();
		String Solution= solution.getText();
		String Additional_Information= aditonalinformation.getText() ;
		String Status= statuscomments.getText() ;
		String Value_date= DATA_WLAUTY_CCB.getText();			
		String NoteSubject= TEMAT_NOTATKI_CCB.getText();
		String NoteText=NOTATKA_CCB.getText();
		String Error_Source="";



		if (RecivedBy.getSelectedItem().toString()=="3rd Party") {

			Error_Source="3rd Party";

		}

		if (RecivedBy.getSelectedItem().toString()=="Citi - Vendors") {

			Error_Source="Citi - Vendors";

		}

		if (RecivedBy.getSelectedItem().toString()=="Client") {

			Error_Source="Client";

		}



		String Transaction_reference=numerreferencyjnytransakcji.getText();	
		String CountryCode="48";       


		if (JOptionPane.showConfirmDialog(null, "czy chesz założyć sprawę na "+ Memo+"?","ZAŁOŻENIE SPRAWY",JOptionPane.YES_NO_OPTION)==0) {


			long startTime = System.currentTimeMillis();

			long total = 0;
			for (int i = 0; i < 10000000; i++) {
				total += i;
			}

			try {

				file.delete();
			}
			catch(Exception e6) {		

			}

			File datain = new File(".\\dataIN.txt");
			try {
				PrintWriter zapis = new PrintWriter(".\\dataIN.txt");

				zapis.println(Csum+";"+CaseTypeID+";"+ ContactID +";"+Token_Account.toUpperCase().replace(" ", "")+";"+Name+";"+LastName.replace("-", " ")+";"+PhoneNumber+";"+Email_plik+";"+Pending+";"+Smart+";"+Volume+";"+InquirySourceID+";"+Memo+";"+Symptom+";"+Solution+";"+Additional_Information+";"+Status+";"+
						Value_date+";"+ Transaction_reference + ";"+NoteSubject+";"+NoteText+";"+Error_Source+";"+CountryCode+";");
				zapis.close();

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {

				String[] command = {"java", "-jar","CORE.jar" , ".\\" ,Csum , "1", loginField.getText(), String.valueOf(passwordField.getPassword())  };
				ProcessBuilder builder = new ProcessBuilder(command);
				builder = builder.directory(new File(".\\"));
				Process p = builder.start();

				System.out.print(Csum);
			}


			catch(Exception xd) {

				System.out.print(xd);
			}



			try {

				while(!file.isFile())
				{
					TimeUnit.SECONDS.sleep(1);

				}
				BufferedReader bf = new BufferedReader(new FileReader(".\\dataOUT.txt"));
				String line = bf.readLine();
				split = line.split(";",-1);
				System.out.print(split[1]);
				bf.close();
			}
			catch(  Exception  e2) {	
				e2.printStackTrace();


			}


			try {
				long stopTime = System.currentTimeMillis();
				long elapsedTime = stopTime - startTime;
				long czas = TimeUnit.MILLISECONDS.toSeconds(elapsedTime);


				String czas1 = String.valueOf(czas) + " sek";  


				if (split[1].equals("0")) {

					SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'o' HH:mm");
					Date date = new Date(System.currentTimeMillis());

					String[] item={formatter.format(date),Name + " "+ LastName,Token_Account.toUpperCase(),Memo,Symptom,split[2],czas1,Baza_Spraw_Pending,"Notka",PhoneNumber};
					dtm.insertRow(0, item);
					JOptionPane.showMessageDialog(null, "Sprawa pomyślnie założona "+ split[2] + " w " +czas1);

					Writer output;
					output = new BufferedWriter(new FileWriter(".\\DataBase.txt", true)); //clears file every time

					output.append(String.join(";", item)+"\n");

					output.close();



				}

				prep_ostatnia_sprawa();

				czyszczenie ();

			}
			catch(  Exception  e6) {	
				e6.printStackTrace();


			}

		}

	}
}