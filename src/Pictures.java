import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Pictures extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Icon picture;
	private static Pictures frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Pictures();
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
	public Pictures() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//if this button selected
		//set PICTURE the Icon of that Button
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\12.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				picture = button.getIcon();

				if (MainClass.leftSide)
					MainClass.contactPic.setIcon(picture);
				else if (MainClass.rightSide)
					MainClass.searchPicButton.setIcon(picture);
				frame.dispose();
			}
		});
		button.setBounds(10, 11, 123, 82);
		contentPane.add(button);

		//if this button selected
		//set PICTURE the Icon of that Button
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\13.png"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				picture = button_1.getIcon();
				if (MainClass.leftSide)
					MainClass.contactPic.setIcon(picture);
				else if (MainClass.rightSide)
					MainClass.searchPicButton.setIcon(picture);
				frame.dispose();
			}
		});
		button_1.setBounds(143, 11, 123, 82);
		contentPane.add(button_1);

		//if this button selected
		//set PICTURE the Icon of that Button
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\14.png"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				picture = button_2.getIcon();
				if (MainClass.leftSide)
					MainClass.contactPic.setIcon(picture);
				else if (MainClass.rightSide)
					MainClass.searchPicButton.setIcon(picture);
				frame.dispose();
			}
		});
		button_2.setBounds(276, 11, 123, 82);
		contentPane.add(button_2);

		//if this button selected
		//set PICTURE the Icon of that Button
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\15.png"));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				picture = button_3.getIcon();
				if (MainClass.leftSide)
					MainClass.contactPic.setIcon(picture);
				else if (MainClass.rightSide)
					MainClass.searchPicButton.setIcon(picture);
				frame.dispose();
			}
		});
		button_3.setBounds(409, 11, 123, 82);
		contentPane.add(button_3);

		//if this button selected
		//set PICTURE the Icon of that Button
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\16.png"));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				picture = button_4.getIcon();
				if (MainClass.leftSide)
					MainClass.contactPic.setIcon(picture);
				else if (MainClass.rightSide)
					MainClass.searchPicButton.setIcon(picture);
				frame.dispose();
			}
		});
		button_4.setBounds(10, 104, 123, 82);
		contentPane.add(button_4);

		//if this button selected
		//set PICTURE the Icon of that Button
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\17.png"));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				picture = button_5.getIcon();
				if (MainClass.leftSide)
					MainClass.contactPic.setIcon(picture);
				else if (MainClass.rightSide)
					MainClass.searchPicButton.setIcon(picture);
				frame.dispose();
			}
		});
		button_5.setBounds(143, 104, 123, 82);
		contentPane.add(button_5);

		//if this button selected
		//set PICTURE the Icon of that Button
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\18.png"));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				picture = button_6.getIcon();
				if (MainClass.leftSide)
					MainClass.contactPic.setIcon(picture);
				else if (MainClass.rightSide)
					MainClass.searchPicButton.setIcon(picture);
				frame.dispose();
			}
		});
		button_6.setBounds(276, 104, 123, 82);
		contentPane.add(button_6);

		//if this button selected
		//set PICTURE the Icon of that Button
		JButton button_7 = new JButton("");
		button_7.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\20181220_193449.jpg"));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				picture = button_7.getIcon();
				if (MainClass.leftSide)
					MainClass.contactPic.setIcon(picture);
				else if (MainClass.rightSide)
					MainClass.searchPicButton.setIcon(picture);
				frame.dispose();
			}
		});
		button_7.setBounds(409, 104, 123, 82);
		contentPane.add(button_7);

		//if this button selected
		//set PICTURE the Icon of that Button
		JButton button_8 = new JButton("");
		button_8.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\20181220_193505.jpg"));
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				picture = button_8.getIcon();
				if (MainClass.leftSide)
					MainClass.contactPic.setIcon(picture);
				else if (MainClass.rightSide)
					MainClass.searchPicButton.setIcon(picture);
				frame.dispose();
			}
		});
		button_8.setBounds(10, 197, 123, 82);
		contentPane.add(button_8);

		//if this button selected
		//set PICTURE the Icon of that Button
		JButton button_9 = new JButton("");
		button_9.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\20181220_193519.jpg"));
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				picture = button_9.getIcon();
				if (MainClass.leftSide)
					MainClass.contactPic.setIcon(picture);
				else if (MainClass.rightSide)
					MainClass.searchPicButton.setIcon(picture);
				frame.dispose();
			}
		});
		button_9.setBounds(143, 197, 123, 82);
		contentPane.add(button_9);

		//if this button selected
		//set PICTURE the Icon of that Button
		JButton button_10 = new JButton("");
		button_10.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\20181220_193534.jpg"));
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				picture = button_10.getIcon();
				if (MainClass.leftSide)
					MainClass.contactPic.setIcon(picture);
				else if (MainClass.rightSide)
					MainClass.searchPicButton.setIcon(picture);
				frame.dispose();
			}
		});
		button_10.setBounds(276, 197, 123, 82);
		contentPane.add(button_10);

		//if this button selected
		//set PICTURE the Icon of that Button
		JButton button_11 = new JButton("");
		button_11.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\23.png"));
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				picture = button_11.getIcon();
				if (MainClass.leftSide)
					MainClass.contactPic.setIcon(picture);
				else if (MainClass.rightSide)
					MainClass.searchPicButton.setIcon(picture);
				frame.dispose();
			}
		});
		button_11.setBounds(409, 197, 123, 82);
		contentPane.add(button_11);

		//if this button selected
		//set PICTURE the Icon of that Button
		JButton button_12 = new JButton("");
		button_12.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\24.png"));
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				picture = button_12.getIcon();
				if (MainClass.leftSide)
					MainClass.contactPic.setIcon(picture);
				else if (MainClass.rightSide)
					MainClass.searchPicButton.setIcon(picture);
				frame.dispose();
			}
		});
		button_12.setBounds(10, 290, 123, 82);
		contentPane.add(button_12);

		//if this button selected
		//set PICTURE the Icon of that Button
		JButton button_13 = new JButton("");
		button_13.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\25.png"));
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				picture = button_13.getIcon();
				if (MainClass.leftSide)
					MainClass.contactPic.setIcon(picture);
				else if (MainClass.rightSide)
					MainClass.searchPicButton.setIcon(picture);
				frame.dispose();
			}
		});
		button_13.setBounds(143, 290, 123, 82);
		contentPane.add(button_13);

		//if this button selected
		//set PICTURE the Icon of that Button
		JButton button_14 = new JButton("");
		button_14.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\26.png"));
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				picture = button_14.getIcon();
				if (MainClass.leftSide)
					MainClass.contactPic.setIcon(picture);
				else if (MainClass.rightSide)
					MainClass.searchPicButton.setIcon(picture);
				frame.dispose();
			}
		});
		button_14.setBounds(276, 290, 123, 82);
		contentPane.add(button_14);

		//if this button selected
		//set PICTURE the Icon of that Button
		JButton button_15 = new JButton("");
		button_15.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\27.png"));
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				picture = button_15.getIcon();
				if (MainClass.leftSide)
					MainClass.contactPic.setIcon(picture);
				else if (MainClass.rightSide)
					MainClass.searchPicButton.setIcon(picture);
				frame.dispose();
			}
		});
		button_15.setBounds(409, 290, 123, 82);
		contentPane.add(button_15);
	}

}
