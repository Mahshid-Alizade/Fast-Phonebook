import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MainClass extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Text Fields
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField numberTextField;
	private JTextField locationTextField;
	private JTextField postalCodeTextField;
	private JTextField emailTextField;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private static JLabel errorLabel = new JLabel();
	private ButtonGroup bg;

	// some Field for add and edit contact
	String name;
	String phoneNumber;
	String location;
	String postalCode;
	String gender;
	String group;
	String email;
	int contactCode;
	private static JTable table;
	static JButton contactPic;
	static JButton searchPicButton;

	static Stack stack;
	static Contact contacts[] = new Contact[100];
	private JTextField searchNameField;
	private JTextField searchNumField;
	private JTextField searchAddressField;
	private JTextField searchPostalCodeField;
	private JTextField searchEmailField;
	private JTextField searchGenderField;

	public static boolean leftSide = false;
	public static boolean rightSide = false;

	/**
	 * Launch the application.
	 * 
	 * 
	 */
	public static void main(String[] args) throws IOException {
		Trie.setRoot();// set root of Trie tree
		fillStack(stack = new Stack());// fill stack[99 , 0]
		table = new JTable();
		try {
		readFromFile();
		}catch (Exception e) {
			errorLabel.setText("WelCome :) ");
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass frame = new MainClass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public MainClass() {
		setType(Type.UTILITY);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(204, 102, 255), 4), "  Information  ", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 301, 341);
		contentPane.add(panel);

		JLabel label = new JLabel("Name :");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		label.setBounds(20, 131, 82, 28);
		panel.add(label);

		JLabel label_1 = new JLabel("Phone Number :");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		label_1.setBounds(20, 157, 117, 28);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Address :");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		label_2.setBounds(20, 187, 82, 28);
		panel.add(label_2);

		JLabel lblPostalcode = new JLabel("PostalCode :");
		lblPostalcode.setHorizontalAlignment(SwingConstants.LEFT);
		lblPostalcode.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblPostalcode.setBounds(20, 215, 82, 28);
		panel.add(lblPostalcode);

		JLabel label_4 = new JLabel("Email :");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		label_4.setBounds(20, 269, 82, 28);
		panel.add(label_4);

		JLabel label_6 = new JLabel("Gender :");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		label_6.setBounds(20, 243, 82, 28);
		panel.add(label_6);

		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		nameTextField.setText("");
		nameTextField.setColumns(10);
		nameTextField.setBackground(new Color(204, 102, 255));
		nameTextField.setBounds(85, 137, 194, 20);
		panel.add(nameTextField);

		numberTextField = new JTextField();
		numberTextField.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		numberTextField.setText("");
		numberTextField.setColumns(10);
		numberTextField.setBackground(new Color(204, 102, 255));
		numberTextField.setBounds(132, 163, 147, 20);
		panel.add(numberTextField);

		locationTextField = new JTextField();
		locationTextField.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		locationTextField.setToolTipText("X Y R Country Province City  Parish Alley");
		locationTextField.setColumns(10);
		locationTextField.setBackground(new Color(204, 102, 255));
		locationTextField.setBounds(99, 193, 180, 20);
		panel.add(locationTextField);

		postalCodeTextField = new JTextField();
		postalCodeTextField.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		postalCodeTextField.setColumns(10);
		postalCodeTextField.setBackground(new Color(204, 102, 255));
		postalCodeTextField.setBounds(109, 221, 170, 20);
		panel.add(postalCodeTextField);

		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		emailTextField.setColumns(10);
		emailTextField.setBackground(new Color(204, 102, 255));
		emailTextField.setBounds(85, 275, 194, 20);
		panel.add(emailTextField);

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFocusable(false);
		rdbtnMale.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		rdbtnMale.setBounds(108, 246, 64, 23);
		panel.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFocusable(false);
		rdbtnFemale.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		rdbtnFemale.setBounds(179, 246, 100, 23);
		panel.add(rdbtnFemale);

		bg = new ButtonGroup();
		bg.add(rdbtnFemale);
		bg.add(rdbtnMale);

		errorLabel.setFont(new Font("Agency FB", Font.PLAIN, 23));
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
		errorLabel.setBackground(Color.RED);
		errorLabel.setBounds(20, 302, 259, 28);
		panel.add(errorLabel);

		// ADD BUTTON
		JButton btnAdd = new JButton("A d d");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddRowAction(e);
			}
		});

		btnAdd.setFocusable(false);
		btnAdd.setBackground(new Color(204, 102, 255));
		btnAdd.setFont(new Font("Agency FB", Font.BOLD, 17));
		btnAdd.setBounds(155, 23, 123, 30);
		panel.add(btnAdd);

		contactPic = new JButton("");
		contactPic.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\000.png"));
		contactPic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Set picture for the first time
				leftSide = true;
				rightSide = false;
				Pictures.main(null);
			}
		});
		contactPic.setBounds(20, 30, 123, 82);
		panel.add(contactPic);

		JButton btnBRO = new JButton("B r o w s e");
		btnBRO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				int flag = chooser.showOpenDialog(null);
				if (flag == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();

					try {
						contactPic.setIcon(new ImageIcon(file.getPath()));

						errorLabel.setText("THAT'S OK :D ");
					} catch (Exception e) {
						System.err.println(e);
						System.out.println("here");
					}
				}
			}
		});
		btnBRO.setFont(new Font("Agency FB", Font.BOLD, 17));
		btnBRO.setFocusable(false);
		btnBRO.setBackground(new Color(204, 102, 255));
		btnBRO.setBounds(155, 56, 123, 30);
		panel.add(btnBRO);

		// save contacts information to file
		JButton btnSAV = new JButton("S a v e  I n f o");
		btnSAV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String writeToFile = "";
				for (int i = 0; contacts[i] != null; i++) {
					writeToFile += contacts[i].getInfo() + "\r\n";
				}
				sendToFile(writeToFile);
			}
		});
		btnSAV.setFont(new Font("Agency FB", Font.BOLD, 17));
		btnSAV.setFocusable(false);
		btnSAV.setBackground(new Color(204, 102, 255));
		btnSAV.setBounds(155, 89, 123, 30);
		panel.add(btnSAV);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(204, 102, 255), 4));
		panel_1.setBounds(10, 358, 601, 123);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(3, 3, 595, 117);
		panel_1.add(scrollPane);

		table.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		// fill Text fields By clicking on each row of Table
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				searchNameField.setText(model.getValueAt(table.getSelectedRow(), 1).toString());
				searchNumField.setText(model.getValueAt(table.getSelectedRow(), 2).toString());
				searchAddressField.setText(model.getValueAt(table.getSelectedRow(), 3).toString());
				searchPostalCodeField.setText(model.getValueAt(table.getSelectedRow(), 4).toString());
				searchGenderField.setText(model.getValueAt(table.getSelectedRow(), 5).toString());
				searchEmailField.setText(model.getValueAt(table.getSelectedRow(), 6).toString());
				searchPicButton.setIcon(contacts[(int)model.getValueAt(table.getSelectedRow(), 7)].getPicture());

			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Select", "Name", "Nmber", "Loction", "PostalCode", "Gender", "Email", "Code" }) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { Boolean.class, Object.class, Object.class, Object.class, Object.class,
					Object.class, Object.class, Object.class };

			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(58);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(57);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setPreferredWidth(78);
		table.getColumnModel().getColumn(7).setPreferredWidth(36);
		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(204, 102, 255), 4), "  Search  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(315, 11, 296, 341);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		// BYNAME BUTTON FOR SEARCH BY NAME
		JButton btnBYN = new JButton("B y  N a m e");
		btnBYN.setFocusable(false);
		btnBYN.setBackground(new Color(204, 102, 255));
		btnBYN.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnBYN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ByName.main(null);
			}
		});
		btnBYN.setBounds(152, 23, 123, 30);
		panel_2.add(btnBYN);

		// BYNUM BUTTON FOR SEARCH BY NUMBER
		JButton btnBYN_1 = new JButton("B y  N u m");
		btnBYN_1.setFocusable(false);
		btnBYN_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ByNum.main(null);
			}
		});
		btnBYN_1.setBackground(new Color(204, 102, 255));
		btnBYN_1.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnBYN_1.setBounds(152, 56, 123, 30);
		panel_2.add(btnBYN_1);

		JLabel label_3 = new JLabel("Name :");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		label_3.setBounds(21, 123, 82, 28);
		panel_2.add(label_3);

		JLabel label_5 = new JLabel("Phone Number :");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		label_5.setBounds(21, 149, 117, 28);
		panel_2.add(label_5);

		JLabel label_8 = new JLabel("Address :");
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		label_8.setBounds(21, 179, 82, 28);
		panel_2.add(label_8);

		JLabel label_9 = new JLabel("PostalCode :");
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		label_9.setBounds(21, 207, 82, 28);
		panel_2.add(label_9);

		JLabel label_10 = new JLabel("Email :");
		label_10.setHorizontalAlignment(SwingConstants.LEFT);
		label_10.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		label_10.setBounds(21, 261, 82, 28);
		panel_2.add(label_10);

		JLabel label_11 = new JLabel("Gender :");
		label_11.setHorizontalAlignment(SwingConstants.LEFT);
		label_11.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		label_11.setBounds(21, 235, 82, 28);
		panel_2.add(label_11);

		searchNameField = new JTextField();
		searchNameField.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		searchNameField.setText("");
		searchNameField.setColumns(10);
		searchNameField.setBackground(new Color(204, 102, 255));
		searchNameField.setBounds(80, 129, 195, 20);
		panel_2.add(searchNameField);

		searchNumField = new JTextField();
		searchNumField.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		searchNumField.setText("");
		searchNumField.setColumns(10);
		searchNumField.setBackground(new Color(204, 102, 255));
		searchNumField.setBounds(138, 157, 137, 20);
		panel_2.add(searchNumField);

		searchAddressField = new JTextField();
		searchAddressField.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		searchAddressField.setColumns(10);
		searchAddressField.setBackground(new Color(204, 102, 255));
		searchAddressField.setBounds(100, 184, 175, 20);
		panel_2.add(searchAddressField);

		searchPostalCodeField = new JTextField();
		searchPostalCodeField.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		searchPostalCodeField.setColumns(10);
		searchPostalCodeField.setBackground(new Color(204, 102, 255));
		searchPostalCodeField.setBounds(115, 213, 160, 20);
		panel_2.add(searchPostalCodeField);

		searchEmailField = new JTextField();
		searchEmailField.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		searchEmailField.setColumns(10);
		searchEmailField.setBackground(new Color(204, 102, 255));
		searchEmailField.setBounds(80, 269, 195, 20);
		panel_2.add(searchEmailField);

		searchGenderField = new JTextField();
		searchGenderField.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		searchGenderField.setColumns(10);
		searchGenderField.setBackground(new Color(204, 102, 255));
		searchGenderField.setBounds(91, 241, 184, 20);
		panel_2.add(searchGenderField);

		// Edit Button
		JButton btnEdit = new JButton("E d i t");
		btnEdit.setBounds(21, 300, 75, 30);
		panel_2.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent arg0) {

				int contactCode = table.getSelectedRow();

				// fields to create new contact
				String name1;
				String phoneNumber1;
				String location1;
				String postalCode1;
				String gender1;
				String email1;
				Icon pic1;

				DefaultTableModel model = (DefaultTableModel) table.getModel();

				if (contactCode == -1) {
					if (table.getRowCount() == 0)
						errorLabel.setText("Table is empty");
					else// if we want edit SEARCHED Contact
						edit();
				} else {
					// if we want edit Selected Contact of Table

					// NAME//////////////////////////////////////////////////
					if (!searchNameField.getText().equals("")) {
						// check is there?
						Trie.delete(contacts[contactCode].getName());
						name1 = searchNameField.getText();
						if (Trie.search(name1)) {
							errorLabel.setText("THIS NAME IS AVAILABLE");
							Trie.insert(contacts[contactCode].getName(), contactCode);
							return;
						}
						Trie.insert(contacts[contactCode].getName(), contactCode);
						model.setValueAt(searchNameField.getText(), contactCode, 1);
						Trie.edit(getName(contactCode), name1, contactCode);
					} else {
						name1 = getName(contactCode);
					}

					// NUMBER////////////////////////////////////////////////
					if (!searchNumField.getText().equals("")) {
						// check is there?
						Trie.delete(contacts[contactCode].getNumber());
						phoneNumber1 = searchNumField.getText();
						if (Trie.search(phoneNumber1)) {
							errorLabel.setText("THIS NUMBER IS AVAILABLE");
							Trie.insert(contacts[contactCode].getNumber(), contactCode);
							return;
						}
						Trie.insert(contacts[contactCode].getNumber(), contactCode);
						model.setValueAt(searchNumField.getText(), contactCode, 2);
						Trie.edit(getNum(contactCode), phoneNumber1, contactCode);
					} else {
						phoneNumber1 = getNum(contactCode);
					}

					// ADDRESS///////////////////////////////////////////////
					if (!searchAddressField.getText().equals("")) {
						model.setValueAt(searchAddressField.getText(), contactCode, 3);
						location1 = searchAddressField.getText();
					} else {
						location1 = getAddress(contactCode);
					}

					// POSTALCODE////////////////////////////////////////////
					if (!searchPostalCodeField.getText().equals("")) {
						model.setValueAt(searchPostalCodeField.getText(), contactCode, 4);
						postalCode1 = searchPostalCodeField.getText();
					} else {
						postalCode1 = getPostalCode(contactCode);
					}

					// GENDER////////////////////////////////////////////////
					if (!searchGenderField.equals("")) {
						model.setValueAt(searchGenderField.getText(), contactCode, 5);
						gender1 = searchGenderField.getText();
					} else
						gender1 = getGender(contactCode);

					// EMAIL////////////////////////////////////////////////
					if (!searchEmailField.getText().equals("")) {
						model.setValueAt(searchEmailField.getText(), contactCode, 6);
						email1 = searchEmailField.getText();
					} else {
						email1 = getEmail(contactCode);
					}

					// PICTURE//////////////////////////////////////////////
					pic1 = searchPicButton.getIcon();

					// Update list
					Contact c = new Contact(contactCode, name1, phoneNumber1, gender1, email1, location1, postalCode1,
							pic1);
					contacts[contactCode] = c;
				}

			}
		});
		btnEdit.setFocusable(false);
		btnEdit.setBackground(new Color(204, 102, 255));
		btnEdit.setFont(new Font("Agency FB", Font.BOLD, 17));

		JButton btnRemove = new JButton("D e l");
		btnRemove.setBounds(110, 300, 75, 30);
		panel_2.add(btnRemove);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				boolean itsSelected = false;
				int code = 0;
				int size = table.getRowCount();
				for (int i = 0; table.getRowCount() != 0 && i < size; i++) {
					if ((boolean) table.getValueAt(i, 0)) {
						itsSelected = true;
						break;
					}
				}

				if (!itsSelected) {
					if (table.getRowCount() == 0)
						errorLabel.setText("There is no contact");
					else {// Delete Searched Contact
						code = Trie.getCode(searchNameField.getText());
						stack.push(code);
						// delet name and number from Trie Tree
						Trie.delete(getName(code));
						Trie.delete(getNum(code));
						contacts[code] = null;
						model.removeRow(code);
					}

					// delete selected contact of Table
				} else if (itsSelected) {
					for (int i = size - 1; i >= 0; i--) {
						if ((boolean) table.getValueAt(i, 0)) {
							stack.push(i);
							// delet name and number from Trie Tree
							Trie.delete(getName((int)model.getValueAt(table.getSelectedRow(), 7)));
							Trie.delete(getNum((int)model.getValueAt(table.getSelectedRow(), 7)));
							contacts[i] = null;
							model.removeRow(i);
						}
					}
				}

				nameTextField.setText("");
				numberTextField.setText("");
				locationTextField.setText("");
				postalCodeTextField.setText("");
				emailTextField.setText("");
			}
		});
		btnRemove.setFocusable(false);
		btnRemove.setBackground(new Color(204, 102, 255));
		btnRemove.setFont(new Font("Agency FB", Font.BOLD, 17));

		// REFRESH button for clear TextFields
		JButton btnREF = new JButton("R e f");
		btnREF.setFont(new Font("Agency FB", Font.BOLD, 17));
		btnREF.setBounds(200, 300, 75, 30);
		panel_2.add(btnREF);
		btnREF.setFocusable(false);
		btnREF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for (int i = 0; i < getContactSize(); i++) {

					model.setValueAt(getName(i), i, 1);
					model.setValueAt(getNum(i), i, 2);
					model.setValueAt(getAddress(i), i, 3);
					model.setValueAt(getPostalCode(i), i, 4);
					model.setValueAt(getGender(i), i, 5);
					model.setValueAt(getEmail(i), i, 6);
					model.setValueAt(i, i, 7);

				}

				searchNameField.setText("");
				searchNumField.setText("");
				searchAddressField.setText("");
				searchGenderField.setText("");
				searchEmailField.setText("");
				searchGenderField.setText("");
				searchPicButton.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\000.png"));
				errorLabel.setText("");

			}
		});
		btnREF.setBackground(new Color(204, 102, 255));

		searchPicButton = new JButton("");
		searchPicButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Set picture for the edit time
				leftSide = false;
				rightSide = true;
				Pictures.main(null);
			}
		});
		searchPicButton.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\000.png"));
		searchPicButton.setBounds(19, 28, 123, 82);
		panel_2.add(searchPicButton);

		JButton btnSEA = new JButton("S e a r c h");
		// SEARCH button for search Finded Contact in Trie
		btnSEA.setFocusable(false);
		btnSEA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int code = 0;
				String name = ByName.getname();
				String number = ByNum.getNum();
				String searchWith = "";

				// to find the index of contact in array
				if (name == null)
					searchWith = number;
				else if (number == null)
					searchWith = name;

				// if contact is available...
				if (Trie.search(searchWith)) {
					code = Trie.getCode(searchWith);

					searchNameField.setText(contacts[code].getName());
					searchNumField.setText(contacts[code].getNumber());
					searchAddressField.setText(contacts[code].getAddress());
					searchGenderField.setText(contacts[code].getGender());
					searchEmailField.setText(contacts[code].getEmail());
					searchPostalCodeField.setText(contacts[code].getPostalCode());
					searchPicButton.setIcon(contacts[code].getPicture());

				} else {// if the contact not found
					errorLabel.setText("THIS CONTACT IS NOT AVAILABLE");
				}

			}
		});
		btnSEA.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnSEA.setBackground(new Color(204, 102, 255));
		btnSEA.setBounds(152, 89, 123, 30);
		panel_2.add(btnSEA);
		generateTable();
	}

	// THIS FUNCTION CALLED IN ADD BUTTON
	private void btnAddRowAction(java.awt.event.ActionEvent evt) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String gender;

		// GENDER
		if (rdbtnMale.isSelected()) {
			gender = rdbtnMale.getText();

		} else if (rdbtnFemale.isSelected()) {
			gender = rdbtnFemale.getText();
		} else {
			gender = "";
		}

		// NAME
		name = nameTextField.getText();
		// NUMBER
		phoneNumber = numberTextField.getText();
		// if contact is TEKRARI
		if (Trie.search(name) || Trie.search(phoneNumber)) {
			errorLabel.setText("THIS CONTACT IS AVAILABLE");
			return;
		}

		if (!name.equals("") && !phoneNumber.equals("")) {

			contactCode = (int) stack.pop().data;
			// ADDRESS
			location = locationTextField.getText();
			// POSTALCODE
			postalCode = postalCodeTextField.getText();
			// EMAIL
			email = emailTextField.getText();

			// dd contacts Info to Talbe
			model.addRow(new Object[] { false, name, phoneNumber, location, postalCode, gender, email, contactCode });
			contacts[contactCode] = new Contact(contactCode, name, phoneNumber, gender, email, location, postalCode,
					contactPic.getIcon());
			// insert name and number to TRIE
			Trie.insert(name, contactCode);
			Trie.insert(phoneNumber, contactCode);
			errorLabel.setText("");
		} else {
			errorLabel.setText("FILL NAME AND NUMBER FIELD");
		}

		// REFRESH textFields
		nameTextField.setText("");
		numberTextField.setText("");
		locationTextField.setText("");
		postalCodeTextField.setText("");
		emailTextField.setText("");
		bg.clearSelection();
		contactPic.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\000.png"));

	}

	@SuppressWarnings("unlikely-arg-type")
	// This Function Called for edit Searched Contact
	private void edit() {

		String name1;
		String phoneNumber1;
		String location1;
		String postalCode1;
		String gender1;
		String email1;
		Icon pic1;

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		String searchWith = "";
		// for Get code of contact
		if (ByName.name == null)
			searchWith = ByNum.number;
		else if (ByNum.number == null)
			searchWith = ByName.name;

		int contactCode = Trie.getCode(searchWith);

		// Name//////////////////////////////////////////////////////
		if (!searchNameField.getText().equals("")) {

			// check is there?
			Trie.delete(contacts[contactCode].getName());
			name1 = searchNameField.getText();
			if (Trie.search(name1)) {
				errorLabel.setText("THIS NAME IS AVAILABLE");
				Trie.insert(contacts[contactCode].getName(), contactCode);
				return;
			}
			Trie.insert(contacts[contactCode].getName(), contactCode);
			model.setValueAt(searchNameField.getText(), contactCode, 1);
			Trie.edit(getName(contactCode), name1, contactCode);
		} else {
			name1 = getName(contactCode);
		}
		// NUMBER/////////////////////////////////////////////////////
		if (!searchNumField.getText().equals("")) {

			// check is there?
			Trie.delete(contacts[contactCode].getNumber());
			phoneNumber1 = searchNumField.getText();
			if (Trie.search(phoneNumber1)) {
				errorLabel.setText("THIS NUMBER IS AVAILABLE");
				Trie.insert(contacts[contactCode].getNumber(), contactCode);
				return;
			}
			Trie.insert(contacts[contactCode].getNumber(), contactCode);
			model.setValueAt(searchNumField.getText(), contactCode, 2);
			Trie.edit(getNum(contactCode), phoneNumber1, contactCode);
		} else {
			phoneNumber1 = getNum(contactCode);
		}

		// ADDRESS////////////////////////////////////////////////
		if (!searchAddressField.getText().equals("")) {
			model.setValueAt(searchAddressField.getText(), contactCode, 3);
			location1 = searchAddressField.getText();
		} else {
			location1 = getAddress(contactCode);
		}

		// POSTALCODE//////////////////////////////////////////////
		if (!searchPostalCodeField.getText().equals("")) {
			model.setValueAt(searchPostalCodeField.getText(), contactCode, 4);
			postalCode1 = searchPostalCodeField.getText();
		} else {
			postalCode1 = getPostalCode(contactCode);
		}

		// GENDER//////////////////////////////////////////////////
		if (!searchGenderField.equals("")) {
			model.setValueAt(searchGenderField.getText(), contactCode, 5);
			gender1 = searchGenderField.getText();
		} else
			gender1 = getGender(contactCode);

		// EMAIL////////////////////////////////////////////////////
		if (!searchEmailField.getText().equals("")) {
			model.setValueAt(searchEmailField.getText(), contactCode, 6);
			email1 = searchEmailField.getText();
		} else {
			email1 = getEmail(contactCode);
		}

		// PICTURE//////////////////////////////////////////////////
		pic1 = searchPicButton.getIcon();

		// Update list
		Contact c = new Contact(contactCode, name1, phoneNumber1, gender1, email1, location1, postalCode1, pic1);
		contacts[contactCode] = c;
	}

	// write contact's information to File
	static void sendToFile(String sendToFile) {
		BufferedWriter output = null;

		try {
			File file = new File("Records.txt");
			output = new BufferedWriter(new FileWriter(file, false));
			output.write(sendToFile);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null)
				try {
					output.close();
				} catch (IOException e) {
					System.out.println("line 867");
				}
		}
	}

	// Read from file and add to contacts array
	static void readFromFile() throws IOException {

		BufferedReader in = new BufferedReader(new FileReader("Records.txt"));

		String c;
		while ((c = in.readLine()) != null) {
			String temp[] = new String[7];
			temp = c.split("-");
			int poped = (int) stack.pop().data;
			String name = temp[0].trim();
			String phoneNumber = temp[1].trim();
			String location = temp[3].trim();
			String email = temp[2].trim();
			String postalCode = temp[4].trim();
			String gender = temp[5].trim();
			Icon picture = new ImageIcon(temp[6].trim());
			contacts[poped] = new Contact(poped, name, phoneNumber, gender, email, location, postalCode, picture);
			Trie.insert(name, poped);
			Trie.insert(phoneNumber, poped);
		}
		in.close();
	}

	// fill stack [99,0]
	private static void fillStack(Stack stack) {
		for (int i = 99; i >= 0; i--)
			stack.push(i);
	}

	private static void generateTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = 0; contacts[i] != null; i++) {
			Contact temp = contacts[i];
			model.addRow(new Object[] { false, temp.getName(), temp.getNumber(), temp.getAddress(),
					temp.getPostalCode(), temp.getGender(), temp.getEmail(), i });
		}
	}

	// GETTER METHODS
	public static int getContactSize() {
		return (int) stack.peek().data;
	}

	public String getName(int code) {
		return contacts[code].getName();
	}

	public String getNum(int code) {
		return contacts[code].getNumber();
	}

	public String getAddress(int code) {
		return contacts[code].getAddress();
	}

	public String getEmail(int code) {
		return contacts[code].getEmail();
	}

	public String getPostalCode(int code) {
		return contacts[code].getPostalCode();
	}

	public String getGender(int code) {
		return contacts[code].getGender();
	}
}
