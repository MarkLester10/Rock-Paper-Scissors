import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Dimension;

public class RPSGame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					RPSGame window = new RPSGame();
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
	static class global{
		public static int userChoice=0;
		public static int computerChoice=0;
		public static String msg="";
		public static int userScore=0;
		public static int computerScore=0;
		
	}
	public RPSGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	

	public void initialize() {
		frame = new JFrame("Rock Paper Scissors");
		frame.setBackground(new Color(51, 51, 102));
		
		JPanel bestPanel = new JPanel();
		bestPanel.setMinimumSize(new Dimension(100, 100));
		bestPanel.setBackground(new Color(51, 51, 102));
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(51, 51, 102));
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonPanel.setLayout(null);
		
		
		JPanel playPanel = new JPanel();
		playPanel.setBackground(new Color(51, 51, 102));
		playPanel.setLayout(null);
		JButton playButton = new JButton("Play");
		playButton.setForeground(Color.WHITE);
		playButton.setBackground(new Color(51, 255, 153));
		playButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 25));
		playButton.setBounds(275, 65, 110, 40);
		playPanel.add(playButton);
		
		Container content = frame.getContentPane();
		content.setLayout(new GridLayout(3,1));
		content.add(buttonPanel);
		
		JLabel lblNewLabel = new JLabel("0");
		lblNewLabel.setBounds(138, 74, 109, 60);
		buttonPanel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 60));
		
		JLabel lblComputer = new JLabel("Computer");
		lblComputer.setBounds(87, 134, 162, 26);
		buttonPanel.add(lblComputer);
		lblComputer.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblComputer.setForeground(new Color(102, 102, 153));
		lblComputer.setBackground(new Color(51, 0, 102));
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(371, 123, 59, 38);
		buttonPanel.add(comboBox);
		comboBox.addItem("1");
		comboBox.addItem("2"); 
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7");
		comboBox.addItem("8");
		comboBox.addItem("9");
		comboBox.addItem("10");
		comboBox.setSelectedItem(null);
		comboBox.setBackground(new Color(0, 102, 102));
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		
		JLabel bestOf = new JLabel("Best Of: ");
		bestOf.setBounds(361, 81, 88, 38);
		buttonPanel.add(bestOf);
		bestOf.setBackground(new Color(102, 0, 153));
		bestOf.setForeground(new Color(0, 102, 102));
		bestOf.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		
		JLabel label = new JLabel("0");
		label.setBounds(605, 74, 109, 60);
		buttonPanel.add(label);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Showcard Gothic", Font.PLAIN, 60));
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(585, 134, 88, 26);
		buttonPanel.add(lblUser);
		lblUser.setForeground(new Color(0, 0, 51));
		lblUser.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblUser.setBackground(new Color(51, 0, 102));
		
		JLabel lblRock = new JLabel("rock");
		lblRock.setForeground(new Color(102, 51, 204));
		lblRock.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblRock.setBackground(new Color(51, 0, 102));
		lblRock.setBounds(245, 21, 88, 26);
		buttonPanel.add(lblRock);
		
		JLabel lblPaper = new JLabel("paper");
		lblPaper.setForeground(new Color(204, 51, 102));
		lblPaper.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblPaper.setBackground(new Color(51, 0, 102));
		lblPaper.setBounds(349, 21, 109, 26);
		buttonPanel.add(lblPaper);
		
		JLabel lblScissors = new JLabel("scissors");
		lblScissors.setForeground(new Color(204, 153, 255));
		lblScissors.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblScissors.setBackground(new Color(51, 0, 102));
		lblScissors.setBounds(467, 21, 148, 26);
		buttonPanel.add(lblScissors);
		content.add(bestPanel);
		bestPanel.setLayout(null);
		content.add(playPanel);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				label.setText("0");
				lblNewLabel.setText("0");
				comboBox.setSelectedItem(null);
				buttonGroup.clearSelection();
				global.computerScore=0;
				global.userScore=0;
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Showcard Gothic", Font.PLAIN, 25));
		btnReset.setBackground(new Color(255, 51, 102));
		btnReset.setBounds(414, 65, 110, 40);
		playPanel.add(btnReset);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(162, 14, 21, 22);
		playPanel.add(radioButton);
		radioButton.setMinimumSize(new Dimension(45, 45));
		radioButton.setMaximumSize(new Dimension(35, 46));
		radioButton.setForeground(new Color(204, 51, 102));
		radioButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 45));
		radioButton.setBackground(new Color(51, 51, 102));
		radioButton.setActionCommand("1");
		buttonGroup.add(radioButton);
		
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(386, 14, 21, 22);
		playPanel.add(radioButton_1);
		radioButton_1.setForeground(new Color(153, 51, 153));
		radioButton_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 45));
		radioButton_1.setBackground(new Color(51, 51, 102));
		radioButton_1.setActionCommand("2");
		buttonGroup.add(radioButton_1);
		
		
		JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(612, 14, 21, 22);
		playPanel.add(radioButton_2);
		radioButton_2.setForeground(new Color(153, 102, 204));
		radioButton_2.setFont(new Font("Showcard Gothic", Font.PLAIN, 45));
		radioButton_2.setBackground(new Color(51, 51, 102));
		radioButton_2.setActionCommand("3");
		buttonGroup.add(radioButton_2);
		
		
		JLabel rock = new JLabel();
		rock.setBounds(98, 25, 141, 135);
		bestPanel.add(rock);
		ImageIcon rockIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("rockFinal.png")));
		Image rockImageIcon = rockIcon.getImage();
		Image rockImageIcon2 = rockImageIcon.getScaledInstance(rock.getWidth(), rock.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon rckIcon = new ImageIcon(rockImageIcon2);
		rock.setIcon(rckIcon);
		
		
		JLabel paperlabel = new JLabel();
		paperlabel.setBounds(321, 25, 141, 135);
		bestPanel.add(paperlabel);
		ImageIcon paperIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("paperFinal.png")));
		Image paperImageIcon = paperIcon.getImage();
		Image paperImageIcon2 = paperImageIcon.getScaledInstance(paperlabel.getWidth(), paperlabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon pprIcon = new ImageIcon(paperImageIcon2);
		paperlabel.setIcon(pprIcon);
		paperlabel.setLabelFor(radioButton_1);
		
		JLabel sclabel = new JLabel();
		sclabel.setBounds(551, 25, 141, 135);
		bestPanel.add(sclabel);
		ImageIcon scIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("scissorFinal.png")));
		Image scImageIcon = scIcon.getImage();
		Image scImageIcon2 = scImageIcon.getScaledInstance(sclabel.getWidth(), sclabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scsIcon = new ImageIcon(scImageIcon2);
		sclabel.setIcon(scsIcon);
		sclabel.setLabelFor(radioButton_2);
		
		
		
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				global.userChoice = Integer.parseInt(buttonGroup.getSelection().getActionCommand());
				int bestScore = Integer.parseInt((String) comboBox.getSelectedItem());
				final int ROCK = 1;
				final int PAPER = 2;
				final int SCISSORS = 3;
				Random generate = new Random();
				global.computerChoice = generate.nextInt(3) + 1;
					
				
//				USER CHOICE IS ROCK
				
					if(global.userChoice == ROCK) {
						if(global.computerChoice == ROCK) {
							
							JPanel message = new JPanel();
							message.setLayout(null);
							message.setMinimumSize(new Dimension(100, 100));
							ImageIcon rock = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("rockFinal.png")));
							JLabel rockIcon = new JLabel(rock);
							
							
							JLabel text = new JLabel("Rock vs Rock: It's a Tie"); 
							JLabel text2 = new JLabel("Computer Chose Rock"); 
							
							text.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text.setForeground(new Color(51, 51, 102));
							text2.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text2.setForeground(new Color(204, 21, 102));
							
							message.setLayout(new BorderLayout());
							message.add(text, BorderLayout.NORTH);
							message.add(rockIcon, BorderLayout.CENTER);
							message.add(text2, BorderLayout.SOUTH);
							
							JOptionPane.showMessageDialog(null,message,"Results",JOptionPane.PLAIN_MESSAGE);
						}
						else if(global.computerChoice == PAPER) {
			
							global.computerScore++;
							lblNewLabel.setText(Integer.toString(global.computerScore));
							
							
							JPanel message = new JPanel();
							message.setLayout(null);
							message.setMinimumSize(new Dimension(100, 100));
							ImageIcon paper = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("paperFinal.png")));
							JLabel paperIcon = new JLabel(paper);
							
							
							JLabel text = new JLabel("Rock vs Paper: You Lose"); 
							JLabel text2Paper = new JLabel("Computer Chose Paper"); 
							
							text.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text.setForeground(new Color(51, 51, 102));
							text2Paper.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text2Paper.setForeground(new Color(253, 216, 53));
							
							message.setLayout(new BorderLayout());
							message.add(text, BorderLayout.NORTH);
							message.add(paperIcon, BorderLayout.CENTER);
							message.add(text2Paper, BorderLayout.SOUTH);
							
							JOptionPane.showMessageDialog(null,message,"Results",JOptionPane.PLAIN_MESSAGE);
							
							if(global.computerScore == bestScore) {
								computerWon();
							}
						
						}
						else if(global.computerChoice == SCISSORS) {
							global.userScore++;
							label.setText(Integer.toString(global.userScore));
							
							
							JPanel message = new JPanel();
							message.setLayout(null);
							message.setMinimumSize(new Dimension(100, 100));
							ImageIcon scissors = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("scissorFinal.png")));
							JLabel scissorsIcon = new JLabel(scissors);
							
							
							JLabel text = new JLabel("Rock vs Scissors: Won"); 
							JLabel text3Scissors = new JLabel("Computer Chose Scissors"); 
							
							text.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text.setForeground(new Color(51, 51, 102));
							text3Scissors.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text3Scissors.setForeground(new Color(66, 165, 245));

							message.setLayout(new BorderLayout());
							message.add(text, BorderLayout.NORTH);
							message.add(scissorsIcon, BorderLayout.CENTER);
							message.add(text3Scissors, BorderLayout.SOUTH);
							
							JOptionPane.showMessageDialog(null,message,"Results",JOptionPane.PLAIN_MESSAGE);
							
							if(global.userScore == bestScore) {
								userWon();
							}
						}
					}
					
					
//					WHEN USER CHOICE IS PAPER
					else if(global.userChoice == PAPER) {
						if(global.computerChoice == PAPER) {
							
							JPanel message = new JPanel();
							message.setLayout(null);
							message.setMinimumSize(new Dimension(100, 100));
							ImageIcon paper = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("paperFinal.png")));
							JLabel paperIcon = new JLabel(paper);
							
							
							JLabel text = new JLabel("Paper vs Paper: It's a Tie"); 
							JLabel text2Paper = new JLabel("Computer Chose Paper"); 
							
							text.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text.setForeground(new Color(51, 51, 102));
							text2Paper.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text2Paper.setForeground(new Color(253, 216, 53));
							
							message.setLayout(new BorderLayout());
							message.add(text, BorderLayout.NORTH);
							message.add(paperIcon, BorderLayout.CENTER);
							message.add(text2Paper, BorderLayout.SOUTH);
							
							JOptionPane.showMessageDialog(null,message,"Results",JOptionPane.PLAIN_MESSAGE);
						}
						else if(global.computerChoice == ROCK) {
							
							global.userScore++;
							label.setText(Integer.toString(global.userScore));

							JPanel message = new JPanel();
							message.setLayout(null);
							message.setMinimumSize(new Dimension(100, 100));
							ImageIcon rock = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("rockFinal.png")));
							JLabel rockIcon = new JLabel(rock);
							
							
							JLabel text = new JLabel("Paper vs Rock: You Won!"); 
							JLabel text2 = new JLabel("Computer Chose Rock"); 
							
							text.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text.setForeground(new Color(51, 51, 102));
							text2.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text2.setForeground(new Color(204, 21, 102));
							
							message.setLayout(new BorderLayout());
							message.add(text, BorderLayout.NORTH);
							message.add(rockIcon, BorderLayout.CENTER);
							message.add(text2, BorderLayout.SOUTH);
							
							JOptionPane.showMessageDialog(null,message,"Results",JOptionPane.PLAIN_MESSAGE);
							
							
								if(global.userScore == bestScore) {					
								userWon();
							}
							
						}
						else if(global.computerChoice == SCISSORS) {
							
							global.computerScore++;
							lblNewLabel.setText(Integer.toString(global.computerScore));

							JPanel message = new JPanel();
							message.setLayout(null);
							message.setMinimumSize(new Dimension(100, 100));
							ImageIcon scissors = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("scissorFinal.png")));
							JLabel scissorsIcon = new JLabel(scissors);
							
							
							JLabel text = new JLabel("Paper vs Scissors: You Lose"); 
							JLabel text3Scissors = new JLabel("Computer Chose Scissors"); 
							
							text.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text.setForeground(new Color(51, 51, 102));
							text3Scissors.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text3Scissors.setForeground(new Color(66, 165, 245));	
							
							message.setLayout(new BorderLayout());
							message.add(text, BorderLayout.NORTH);
							message.add(scissorsIcon, BorderLayout.CENTER);
							message.add(text3Scissors, BorderLayout.SOUTH);
							
							JOptionPane.showMessageDialog(null,message,"Results",JOptionPane.PLAIN_MESSAGE);
							
							if(global.computerScore == bestScore) {
								computerWon();
							}
							
						}
					}
					
					
//					WHEN USER CHOICE IS SCISSORS
					else if(global.userChoice == SCISSORS) {
						if(global.computerChoice == SCISSORS) {
							JPanel message = new JPanel();
							message.setLayout(null);
							message.setMinimumSize(new Dimension(100, 100));
							ImageIcon scissors = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("scissorFinal.png")));
							JLabel scissorsIcon = new JLabel(scissors);
							
							
							JLabel text = new JLabel("Scissors vs Scissors: It's a Tie"); 
							JLabel text3Scissors = new JLabel("Computer Chose Scissors"); 
							
							text.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text.setForeground(new Color(51, 51, 102));
							text3Scissors.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text3Scissors.setForeground(new Color(66, 165, 245));
						
							message.setLayout(new BorderLayout());
							message.add(text, BorderLayout.NORTH);
							message.add(scissorsIcon, BorderLayout.CENTER);
							message.add(text3Scissors, BorderLayout.SOUTH);
							
							JOptionPane.showMessageDialog(null,message,"Results",JOptionPane.PLAIN_MESSAGE);
						}
						else if(global.computerChoice == ROCK) {
							global.computerScore++;
							lblNewLabel.setText(Integer.toString(global.computerScore));
							
							JPanel message = new JPanel();
							message.setLayout(null);
							message.setMinimumSize(new Dimension(100, 100));
							ImageIcon rock = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("rockFinal.png")));
							JLabel rockIcon = new JLabel(rock);
							
							
							JLabel text = new JLabel("Scissors vs Rock: You Lose"); 
							JLabel text2 = new JLabel("Computer Chose Rock"); 
							
							text.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text.setForeground(new Color(51, 51, 102));
							text2.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text2.setForeground(new Color(204, 21, 102));
							
							message.setLayout(new BorderLayout());
							message.add(text, BorderLayout.NORTH);
							message.add(rockIcon, BorderLayout.CENTER);
							message.add(text2, BorderLayout.SOUTH);
							
							JOptionPane.showMessageDialog(null,message,"Results",JOptionPane.PLAIN_MESSAGE);
							if(global.computerScore == bestScore) {
								computerWon();
							}
						}
						else if(global.computerChoice == PAPER) {
							global.userScore++;
							label.setText(Integer.toString(global.userScore));
							
							JPanel message = new JPanel();
							message.setLayout(null);
							message.setMinimumSize(new Dimension(100, 100));
							ImageIcon paper = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("paperFinal.png")));
							JLabel paperIcon = new JLabel(paper);
							
							
							JLabel text = new JLabel("Scissors vs Paper: You Won!"); 
							JLabel text2Paper = new JLabel("Computer Chose Paper"); 
							
							text.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text.setForeground(new Color(51, 51, 102));
							text2Paper.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
							text2Paper.setForeground(new Color(253, 216, 53));
							
							message.setLayout(new BorderLayout());
							message.add(text, BorderLayout.NORTH);
							message.add(paperIcon, BorderLayout.CENTER);
							message.add(text2Paper, BorderLayout.SOUTH);
							
							JOptionPane.showMessageDialog(null,message,"Results",JOptionPane.PLAIN_MESSAGE);
							
							if(global.userScore == bestScore) {
								userWon();
							}
						}
					}
			}
		});
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(824,521);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	
	
//	function userwon
	public void userWon() {
		JPanel Winnermessage = new JPanel();
		Winnermessage.setLayout(null);
		Winnermessage.setMinimumSize(new Dimension(100, 100));
		ImageIcon computerWon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("userWon.png")));
		JLabel cmptrIcon = new JLabel(computerWon);
		JLabel asarTalo = new JLabel("Congratulations! You won the game");
		
		JLabel winner = new JLabel("Humans are still better than you guys haha"); 

		
		winner.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		winner.setForeground(new Color(149, 117, 205));
		
		
		asarTalo.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		asarTalo.setForeground(new Color(0, 230, 118));
		
		Winnermessage.setLayout(new BorderLayout());
		Winnermessage.add(winner, BorderLayout.SOUTH);
		Winnermessage.add(cmptrIcon, BorderLayout.CENTER);
		Winnermessage.add(asarTalo, BorderLayout.NORTH);

		JOptionPane.showMessageDialog(null,Winnermessage ,"Final Score",JOptionPane.PLAIN_MESSAGE);
			global.userScore=0;
			global.computerScore=0;
	}
	
	//function computerWon
	public void computerWon() {
		JPanel Winnermessage = new JPanel();
		Winnermessage.setLayout(null);
		Winnermessage.setMinimumSize(new Dimension(100, 100));
		ImageIcon computerWon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("computerWon.png")));
		JLabel cmptrIcon = new JLabel(computerWon);
		JLabel asarTalo = new JLabel("Sorry, You Lose the Game This Time");
		
		JLabel winner = new JLabel("Computer is better than Humans haha"); 

		
		winner.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		winner.setForeground(new Color(255, 64, 129));
		
		asarTalo.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		asarTalo.setForeground(new Color(149, 117, 205));
		
		Winnermessage.setLayout(new BorderLayout());
		Winnermessage.add(winner, BorderLayout.SOUTH);
		Winnermessage.add(cmptrIcon, BorderLayout.CENTER);
		Winnermessage.add(asarTalo, BorderLayout.NORTH);
		JOptionPane.showMessageDialog(null,Winnermessage ,"Final Score",JOptionPane.PLAIN_MESSAGE);
		global.userScore=0;
		global.computerScore=0;
	}
	
	
}
