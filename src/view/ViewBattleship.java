package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.io.File;
import java.io.IOException;

public class ViewBattleship {
	
	private Font font;
	private Color color;
	
	private JFrame principalFrame;
	private JPanel principalPanel;
	//COMPONENTES FRAME INICIAL
	private JPanel panelRegister;
	private JLabel title;
	private ImageIcon image;
	
	private JPanel data;
	private JLabel labelName;
	private JTextField name;
	private JLabel labelSize;
	private JComboBox<Integer> sizeBoards;
	
	private JButton startButton;

	//COMPONENTES FRAME PARA UBICAR BARCOS
	private JPanel chooseShips;
	private JPanel panelOptions;
	
	private ButtonGroup optionShip;
	private JRadioButton portaavion;
	private JRadioButton acorazado;
	private JRadioButton destructor;
	private JRadioButton destructor2;
	private JRadioButton submarino;
	
	private ButtonGroup direction;
	private JRadioButton left;
	private JRadioButton right;
	private JRadioButton top;
	private JRadioButton bottom;
	
	private JPanel panelShips;
	private JButton nextButton;
	
	//COMPONENTES FRAME DEL JUEGO 
	private JPanel mainPanel;
	private JButton[][] buttonsMachine;
	private JButton[][] buttonsPlayer;
	private JPanel centralPanel;
	
	private JPanel panelPlayer;
	private JPanel panelOpponent;
	
	private JPanel boardPlayer;
	private JPanel boardOpponent;
	private JLabel playerName;
	private JLabel opponentName;
	////
	private JPanel panelEndGame;
	private JLabel finishGame;
	
	public ViewBattleship() {
			
		this.principalFrame = new JFrame("BATALLA NAVAL");
		this.principalFrame.setSize(600, 400);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.principalFrame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.principalFrame.getHeight()) / 2);
		this.principalFrame.setLocation(x, y);
		this.principalFrame.setResizable(false);
		this.principalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initButtons();
		this.color = new Color(20,34,43,255);
	}
	private void initButtons() {
		this.startButton = new JButton("Comenzar");
		
		this.nextButton = new JButton("Jugar");
		
		this.sizeBoards = new JComboBox<Integer>();
		for (int i = 10; i <= 20; i++) {
			this.sizeBoards.addItem(i);
		}
		this.optionShip = new ButtonGroup();
		
		this.portaavion = new JRadioButton("Portaavión. (5 celdas)");
		portaavion.setBackground(new Color(115,137,133,255));
		this.acorazado = new JRadioButton("Acorazado. (4 celdas)");
		acorazado.setBackground(new Color(115,137,133,255));
		this.destructor = new JRadioButton("Destructor Uno. (3 celdas)");
		destructor.setBackground(new Color(115,137,133,255));
		this.destructor2 = new JRadioButton("Destructor Dos. (3 celdas)");		
		destructor2.setBackground(new Color(115,137,133,255));
		this.submarino = new JRadioButton("Submarino. (2 celdas)");
		submarino.setBackground(new Color(115,137,133,255));
		
		this.optionShip.add(portaavion);
		this.optionShip.add(acorazado);
		this.optionShip.add(destructor);
		this.optionShip.add(destructor2);
		this.optionShip.add(submarino);
		
		this.direction = new ButtonGroup();
		
		this.top = new JRadioButton("Arriba");
		top.setBackground(new Color(115,137,133,255));
		this.bottom = new JRadioButton("Abajo");
		bottom.setBackground(new Color(115,137,133,255));
		this.left = new JRadioButton("Izquierda");
		left.setBackground(new Color(115,137,133,255));
		this.right = new JRadioButton("Derecha");
		right.setBackground(new Color(115,137,133,255));
	}
	//Panel de inicio donde se ingresa el nombre del jugador
	public void register() {
		this.principalPanel = new JPanel(new BorderLayout());
		this.title = new JLabel("BATALLA NAVAL");
				
		this.font = new Font("Tahoma", 5, 10);
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("src//resources//fonts//Caveat.ttf")).deriveFont(Font.PLAIN, 50);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.title.setFont(font);
		this.title.setForeground(Color.WHITE);
		this.title.setHorizontalAlignment(JLabel.CENTER);
		this.title.setVerticalAlignment(JLabel.CENTER);
		
		
		this.panelRegister = new JPanel(new BorderLayout());
		this.panelRegister.setBackground(color);
		this.panelRegister.add(this.title, BorderLayout.NORTH);
		
		this.image = new ImageIcon("src//resources//register2.jpg");

		this.panelRegister.add(new JLabel(this.image), BorderLayout.CENTER);
		
		this.data = new JPanel(new GridLayout(5,1));
		this.labelName = new JLabel("Ingresa tu nombre");
		
		this.labelName.setForeground(Color.WHITE);
		this.labelName.setFont(new Font("Tahoma",5,15));
		this.name = new JTextField("Jugador");
		this.data.setBackground(this.color);
		this.labelSize = new JLabel("Ingresa el tamaño de la cuadricula");
		this.labelSize.setFont(new Font("Tahoma",5,15));
		this.labelSize.setForeground(Color.WHITE);
		this.startButton.setBackground(new Color(52,74,79,255));
		this.startButton.setForeground(Color.WHITE);
		this.startButton.setFont(new Font("Tahoma",Font.BOLD,20));
		
		data.add(labelName);
		data.add(name);
		data.add(labelSize);
		data.add(this.sizeBoards);
		data.add(startButton);
		panelRegister.add(data, BorderLayout.SOUTH);
		this.principalPanel.add(panelRegister);
		this.principalFrame.add(principalPanel, BorderLayout.CENTER);
	}
	//Segunda ventana. Se ubican los barcos de acuerdo a las opciones que elige el usuario;
	public void locateShips() {
		this.principalFrame.remove(this.principalPanel);
		this.principalPanel = new JPanel(new BorderLayout());
		this.chooseShips = new JPanel(new BorderLayout());
		this.chooseShips.setBackground(new Color(115,137,133,255));
		
		this.generateShipsPanel();
		this.generatePanelOptions();
		this.chooseShips.add(new JLabel("Ubica tus barcos"), BorderLayout.NORTH);
		
		
		JPanel content = new JPanel(new BorderLayout());
		content.add(panelOptions, BorderLayout.WEST);
		content.add(panelShips, BorderLayout.CENTER);
		this.chooseShips.add(content, BorderLayout.CENTER);
		
		this.nextButton.setBackground(new Color(52,74,79,255));
		this.nextButton.setForeground(Color.WHITE);
		this.nextButton.setFont(new Font("Tahoma",Font.BOLD,20));
		this.chooseShips.add(nextButton, BorderLayout.SOUTH);
		
		this.principalPanel.add(chooseShips);
		this.principalFrame.add(principalPanel, BorderLayout.CENTER);
		this.principalFrame.revalidate();
		this.principalFrame.repaint();
	}
	public void generateShipsPanel(){
		this.title = new JLabel("Selecciona el boton del que partirá tu barco");
		this.panelShips = new JPanel(new BorderLayout());
		this.panelShips.add(this.title, BorderLayout.NORTH);
		this.panelShips.setBackground(new Color(115,137,133,255));
		this.boardPlayer = new JPanel();
		this.boardPlayer.setBackground(new Color(115,137,133,255));
		this.generateBoard( this.boardPlayer, "PLAYER");
		this.buttonsPlayer = this.buttonsMachine;
		this.panelShips.add(boardPlayer, BorderLayout.CENTER);
		
	}
	public void generatePanelOptions() {
		this.panelOptions = new JPanel(new GridLayout(11,1));
		this.panelOptions.add(new JLabel("Selecciona el barco que quieres ubicar"));
		this.panelOptions.setBackground(new Color(115,137,133,255));
		
		this.panelOptions.add(portaavion);
		this.panelOptions.add(acorazado);
		this.panelOptions.add(destructor);
		this.panelOptions.add(destructor2);
		this.panelOptions.add(submarino);
		
		this.panelOptions.add(new JLabel("Selecciona la direccion en que ira el barco"));
			
		this.direction.add(top);
		this.direction.add(bottom);
		this.direction.add(left);
		this.direction.add(right);
		
		this.panelOptions.add(top);
		this.panelOptions.add(bottom);
		this.panelOptions.add(left);
		this.panelOptions.add(right);
		
	}
	public void generateGamePanel(){
		this.principalFrame.remove(this.principalPanel);
		this.principalPanel = new JPanel(new BorderLayout());
		
		//this.principalFrame.removeAll();
		this.mainPanel = new JPanel(new BorderLayout());
		
		this.centralPanel = new JPanel(new GridLayout(1,2));//panel que contiene los paneles de los tableros
		
		
		//GENERO UN LABEL QUE TENGA EL NOMBRE DEL JUGADOR
		this.playerName = new JLabel(this.name.getText());
		this.playerName.setHorizontalAlignment(JLabel.CENTER);
		this.playerName.setVerticalAlignment(JLabel.CENTER);
		//HAGO UN PANEL SECUNDARIO QUE CONTENGA EL NOMBRE DEL JUGADOR Y SU TABLERO
		this.panelPlayer = new JPanel();
		this.panelPlayer.setBackground(new Color(115,137,133,255));
		this.generateSidePanel(boardPlayer, playerName, panelPlayer);
		
		//this.mainPanel.add(this.panelPlayer, BorderLayout.WEST);

		this.boardOpponent = new JPanel();
		this.boardOpponent.setBackground(new Color(115,137,133,255));
		this.generateBoard(this.boardOpponent, "MAQUINA");
		this.opponentName = new JLabel("Máquina");
		this.opponentName.setHorizontalAlignment(JLabel.CENTER);
		this.opponentName.setVerticalAlignment(JLabel.CENTER);
		
		this.panelOpponent = new JPanel();
		this.panelOpponent.setBackground(new Color(115,137,133,255));
		this.generateSidePanel(boardOpponent, opponentName, panelOpponent);
		
		//this.mainPanel.add(this.panelOpponent, BorderLayout.EAST);
		this.centralPanel.add(panelPlayer);
		this.centralPanel.add(panelOpponent);
		
		this.mainPanel.add(centralPanel, BorderLayout.CENTER);
		//this.mainPanel.add(new JLabel("BATTLESHIP"), BorderLayout.SOUTH);
		
		this.principalPanel.add(mainPanel);
		this.principalFrame.add(principalPanel, BorderLayout.CENTER);
		this.principalFrame.revalidate();
		this.principalFrame.repaint();
	}
	public void generateSidePanel(JPanel board, JLabel name, JPanel panelSide) {
		panelSide.setLayout(new BorderLayout());
		panelSide.add(name, BorderLayout.NORTH);
		panelSide.add(board, BorderLayout.CENTER);
		
	}
	public void generateBoard ( JPanel panel, String typeBoard) {
		int  rows = (int) this.sizeBoards.getSelectedItem();
		int columns = rows;
		panel.setLayout(new GridLayout(rows,columns));
		this.buttonsMachine = new JButton[rows][columns];
		
		for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
            	
				buttonsMachine[i][j] = new JButton(); 
				buttonsMachine[i][j].setActionCommand(i+"-"+j+"-"+typeBoard);
				panel.add(buttonsMachine[i][j]);
            }
        }
		//framePrincipal.add(panel);
	}
	public void setColorButton(int row, int colum, String typeButton) {
		if(typeButton.equals("SHIP_PLAYER"))
			this.getButtonsPlayer()[row][colum].setBackground(Color.BLACK);
		/*else if(typeButton.equals("SHIP_MACHINE"))
			this.getButtonsMachine()[row][colum].setBackground(Color.GRAY);*/
		else if(typeButton.equals("ATTACK_MACHINE")) {
			this.getButtonsMachine()[row][colum].setBackground(Color.BLUE);
			this.getButtonsMachine()[row][colum].setEnabled(false);
		}else if(typeButton.equals("ATTACK_PLAYER"))
			this.getButtonsPlayer()[row][colum].setBackground(Color.BLUE);
		else if(typeButton.equals("SHIP_PLAYER_ATTACKED"))
			this.getButtonsPlayer()[row][colum].setBackground(Color.RED);
		else if(typeButton.equals("SHIP_MACHINE_ATTACKED"))
			this.getButtonsMachine()[row][colum].setBackground(Color.ORANGE);
	}
	public void finishGame(String winner) {
		this.principalFrame.remove(this.principalPanel);
		this.principalPanel = new JPanel(new BorderLayout());
		
		this.panelEndGame = new JPanel(new BorderLayout());
		this.panelEndGame.setBackground(color);
		if(winner.equals("player"))
			winner = this.name.getText();
		this.finishGame = new JLabel("GANADOR: "+winner);
		this.finishGame.setFont(font);
		this.finishGame.setForeground(Color.WHITE);
		this.finishGame.setHorizontalAlignment(JLabel.CENTER);
		this.finishGame.setVerticalAlignment(JLabel.CENTER);
		
		this.panelEndGame.add(finishGame, BorderLayout.CENTER);
		
		this.principalPanel.add(this.panelEndGame);
		this.principalFrame.add(this.principalPanel, BorderLayout.CENTER);
		this.principalFrame.revalidate();
		this.principalFrame.repaint();
	}
	public JPanel getBoardPlayer() {
		return boardPlayer;
	}
	public void setBoardPlayer(JPanel boardPlayer) {
		this.boardPlayer = boardPlayer;
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
	
	public JPanel getCentralPanel() {
		return centralPanel;
	}
	public void setCentralPanel(JPanel centralPanel) {
		this.centralPanel = centralPanel;
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
	public ButtonGroup getOptionShip() {
		return optionShip;
	}
	public void setOptionShip(ButtonGroup optionShip) {
		this.optionShip = optionShip;
	}
	public ButtonGroup getDirection() {
		return direction;
	}
	public void setDirection(ButtonGroup direction) {
		this.direction = direction;
	}
	public JRadioButton getPortaavion() {
		return portaavion;
	}
	public void setPortaavion(JRadioButton portaavion) {
		this.portaavion = portaavion;
	}
	public JRadioButton getAcorazado() {
		return acorazado;
	}
	public void setAcorazado(JRadioButton acorazado) {
		this.acorazado = acorazado;
	}
	public JRadioButton getDestructor() {
		return destructor;
	}
	public void setDestructor(JRadioButton destructor) {
		this.destructor = destructor;
	}
	public JRadioButton getDestructor2() {
		return destructor2;
	}
	public void setDestructor2(JRadioButton destructor2) {
		this.destructor2 = destructor2;
	}
	public JRadioButton getSubmarino() {
		return submarino;
	}
	public void setSubmarino(JRadioButton submarino) {
		this.submarino = submarino;
	}
	public JRadioButton getLeft() {
		return left;
	}
	public void setLeft(JRadioButton left) {
		this.left = left;
	}
	public JRadioButton getRight() {
		return right;
	}
	public void setRight(JRadioButton right) {
		this.right = right;
	}
	public JRadioButton getTop() {
		return top;
	}
	public void setTop(JRadioButton top) {
		this.top = top;
	}
	public JRadioButton getBottom() {
		return bottom;
	}
	public void setBottom(JRadioButton bottom) {
		this.bottom = bottom;
	}
	public JButton getNextButton() {
		return nextButton;
	}
	public void setNextButton(JButton nextButton) {
		this.nextButton = nextButton;
	}
	public JButton[][] getButtonsMachine() {
		return buttonsMachine;
	}
	public void setButtonsMachine(JButton[][] buttons) {
		this.buttonsMachine = buttons;
	}
	public JButton[][] getButtonsPlayer() {
		return buttonsPlayer;
	}
	public void setButtonsPlayer(JButton[][] buttonsPlayer) {
		this.buttonsPlayer = buttonsPlayer;
	}
	public JComboBox<Integer> getSizeBoards() {
		return sizeBoards;
	}
	public void setSizeBoards(JComboBox<Integer> sizeBoards) {
		this.sizeBoards = sizeBoards;
	}
	
}
