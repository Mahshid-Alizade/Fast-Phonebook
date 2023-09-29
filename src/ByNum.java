import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ByNum extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	static String number ;
	private static ByNum frame;
	private static JScrollPane scrollPane = new JScrollPane();
	private JList<String> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//set scrollpane's visible FALSE
		scrollPane.setVisible(false);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ByNum();
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
	public ByNum() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 175, 175), 4), "  ENTER NUM :  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 332, 126);
		contentPane.add(panel);
		
		textField = new JTextField();
		//manage some keyListener
		textField.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("rawtypes")
			DefaultListModel model = new DefaultListModel();
			
			@SuppressWarnings("unchecked")
			@Override
			//suggestion while typing
			public void keyTyped(KeyEvent arg0) {
				model.clear();
				//call method to find all children of thi prefix
				Trie.getChild(textField.getText().trim(), list, model);
				list.setModel(model);
				scrollPane.setVisible(true);
			}
			@SuppressWarnings("unchecked")
			@Override
			public void keyReleased(KeyEvent e) {
				model.clear();
				Trie.getChild(textField.getText().trim(), list, model);
				list.setModel(model);
				scrollPane.setVisible(true);
			}
			@SuppressWarnings("unchecked")
			@Override
			//when press "BACK SPACE"
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				model.clear();
				list.setModel(model);
				if (keyCode == KeyEvent.VK_BACK_SPACE) {
					System.out.println("ooof");
					Trie.getChild(textField.getText().trim(), list, model);
					scrollPane.setVisible(true);
				}
			}
		});
		textField.setColumns(10);
		textField.setBounds(27, 24, 196, 38);
		panel.add(textField);
		
		JButton button = new JButton("O K");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ByName.name = null;//set name NULL
				number = textField.getText();//set number
				frame.dispose();
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Agency FB", Font.BOLD, 25));
		button.setBackground(Color.PINK);
		button.setBounds(238, 23, 73, 39);
		panel.add(button);
		
		
		scrollPane.setBounds(27, 61, 196, 51);
		panel.add(scrollPane);
		
		list = new JList<String>();
		//when click on JList's Item
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(list.getSelectedValue());
				scrollPane.setVisible(false);
			}
		});
		scrollPane.setViewportView(list);
	}
	
	
	//return static field number
	public static String getNum() {
		return number;
	}

}
