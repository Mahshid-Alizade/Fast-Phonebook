import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;

public class ByName extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private static ByName frame;
	static String name;
	private JList<String> list;
	private static JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//set scrollpane's visible FALSE
		scrollPane.setVisible(false);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ByName();
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
	@SuppressWarnings("rawtypes")
	public ByName() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 332, 126);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 175, 175), 4), "  ENTER NAME :  ",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		
		//manage some keyListener
		textField.addKeyListener(new KeyAdapter() {
			DefaultListModel model = new DefaultListModel();

			@SuppressWarnings("unchecked")
			@Override
			//suggestion while typing
			public void keyTyped(KeyEvent arg0) {
				model.clear();
				//call method to find all children of thi prefix
				Trie.getChild(textField.getText().trim(), list, model);
				scrollPane.setVisible(true);
			}

			@SuppressWarnings("unchecked")
			@Override
			//when press "BACK SPACE"
			public void keyPressed(KeyEvent e) {

				int keyCode = e.getKeyCode();
				model.clear();
				if (keyCode == KeyEvent.VK_BACK_SPACE) {
					Trie.getChild(textField.getText().trim(), list, model);
					scrollPane.setVisible(true);
				}

			}
			@SuppressWarnings("unchecked")
			@Override
			public void keyReleased(KeyEvent e) {
				model.clear();
				Trie.getChild(textField.getText().trim(), list, model);
				scrollPane.setVisible(true);
			}
		});
		
		textField.setBounds(27, 24, 196, 38);
		panel.add(textField);
		textField.setColumns(10);

		scrollPane.setBounds(27, 61, 196, 51);
		panel.add(scrollPane);

		list = new JList<String>();
		list.addMouseListener(new MouseAdapter() {
			@Override
			//when click on JList's Item
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(list.getSelectedValue());
				scrollPane.setVisible(false); 
			}
		});
		scrollPane.setViewportView(list);

		JButton btnOK = new JButton("O K");
		btnOK.setBounds(238, 23, 73, 39);
		panel.add(btnOK);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ByNum.number = null;//set number NULL
				name = textField.getText();//set name
				frame.dispose();
			}
		});
		btnOK.setBackground(Color.PINK);
		btnOK.setForeground(Color.BLACK);
		btnOK.setFont(new Font("Agency FB", Font.BOLD, 25));
	}

	//return static field name
	public static String getname() {
		return name;
	}
}
