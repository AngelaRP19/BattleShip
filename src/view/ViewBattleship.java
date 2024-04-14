package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewBattleship {
 
	private JFrame principalFrame;
	private JPanel panelRegister;
	private JLabel labelName;
	private JTextField name;
	private JButton startButton;

	private JPanel mainPanel;
	private JButton[][] buttons;
	private JPanel centralPanel;
	
	private JPanel panelPlayer;
	private JPanel panelOpponent;
	
	private JPanel boardPlayer;
	private JPanel boardOpponent;
	private JLabel playerName;
	private JLabel opponentName;
	
	public ViewBattleship() {
		this.principalFrame = new JFrame("BATALLA NAVAL");
		this.principalFrame.setBounds(0, 0, 800, 700);
	}
	public void init() {
		this.panelRegister = new JPanel(new BorderLayout());
		this.panelRegister.add(new JLabel("BATALLA NAVAL"), BorderLayout.NORTH);
		
		this.labelName = new JLabel("Ingresa tu nombre");
		this.name = new JTextField(20);
		this.startButton = new JButton("Comenzar");
		this.panelRegister.add(labelName);
		this.panelRegister.add(name);
		this.panelRegister.add(startButton);
		this.principalFrame.add(panelRegister);
	}
	
	public void generateMainPanel(){
		this.mainPanel = new JPanel(new BorderLayout());
		
		this.centralPanel = new JPanel(new GridLayout(1,2));//panel que contiene los paneles de los tableros
		
		//GENERO UN PANEL QUE CONTENGA EL TABLERO
		this.boardPlayer = new JPanel();
		this.generateBoard(10, 10, this.boardPlayer);
		//GENERO UN LABEL QUE TENGA EL NOMBRE DEL JUGADOR
		this.playerName = new JLabel("lala");
		//HAGO UN PANEL SECUNDARIO QUE CONTENGA EL NOMBRE DEL JUGADOR Y SU TABLERO
		this.panelPlayer = new JPanel();
		this.generateSidePanel(boardPlayer, playerName, panelPlayer);
		
		//this.mainPanel.add(this.panelPlayer, BorderLayout.WEST);

		this.boardOpponent = new JPanel();
		this.generateBoard(10, 10, this.boardOpponent);
		this.opponentName = new JLabel("Máquina");
		this.panelOpponent = new JPanel();
		this.generateSidePanel(boardOpponent, opponentName, panelOpponent);
		
		//this.mainPanel.add(this.panelOpponent, BorderLayout.EAST);
		this.centralPanel.add(panelPlayer);
		this.centralPanel.add(panelOpponent);
		
		this.mainPanel.add(centralPanel, BorderLayout.CENTER);
		this.mainPanel.add(new Label("BATTLESHIP"), BorderLayout.SOUTH);
		this.principalFrame.add(mainPanel);
	}
	public void generateSidePanel(JPanel board, JLabel name, JPanel panelSide) {
		panelSide.setLayout(new BorderLayout());
		panelSide.add(name, BorderLayout.NORTH);
		panelSide.add(board, BorderLayout.CENTER);
		
	}
	public void generateBoard (int rows, int columns, JPanel panel) {
		
		panel.setLayout(new GridLayout(rows,columns));
		this.buttons = new JButton[rows][columns];

		for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
				buttons[i][j] = new JButton(" "); 
                panel.add(buttons[i][j]);
            }
        }
		//framePrincipal.add(panel);
	}
	public JFrame getPrincipalFrame() {
		return principalFrame;
	}
	public void setPrincipalFrame(JFrame frame) {
		this.principalFrame = frame;
	}
	public JPanel getPanel() {
		return panelRegister;
	}
	public void setPanel(JPanel panel) {
		this.panelRegister = panel;
	}
	public JLabel getLabelName() {
		return labelName;
	}
	public void setLabelName(JLabel labelName) {
		this.labelName = labelName;
	}
	public JTextField getName() {
		return name;
	}
	public void setName(JTextField name) {
		this.name = name;
	}
	public JButton getStartButton() {
		return startButton;
	}
	public void setStartButton(JButton startButton) {
		this.startButton = startButton;
	}
	public JPanel getMainPanel() {
		return mainPanel;
	}
	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	public JButton[][] getButtons() {
		return buttons;
	}
	public void setButtons(JButton[][] buttons) {
		this.buttons = buttons;
	}
	public JPanel getCentralPanel() {
		return centralPanel;
	}
	public void setCentralPanel(JPanel centralPanel) {
		this.centralPanel = centralPanel;
	}
	public JPanel getPanelPlayer() {
		return panelPlayer;
	}
	public void setPanelPlayer(JPanel panelPlayer) {
		this.panelPlayer = panelPlayer;
	}
	public JPanel getPanelOpponent() {
		return panelOpponent;
	}
	public void setPanelOpponent(JPanel panelOpponent) {
		this.panelOpponent = panelOpponent;
	}
	public JPanel getBoardPlayer() {
		return boardPlayer;
	}
	public void setBoardPlayer(JPanel boardPlayer) {
		this.boardPlayer = boardPlayer;
	}
	public JPanel getBoardOpponent() {
		return boardOpponent;
	}
	public void setBoardOpponent(JPanel boardOpponent) {
		this.boardOpponent = boardOpponent;
	}
	public JLabel getPlayerName() {
		return playerName;
	}
	public void setPlayerName(JLabel playerName) {
		this.playerName = playerName;
	}
	public JLabel getOpponentName() {
		return opponentName;
	}
	public void setOpponentName(JLabel opponentName) {
		this.opponentName = opponentName;
	}
	
}
