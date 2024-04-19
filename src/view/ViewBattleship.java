package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ViewBattleship {
	
 
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
	private JTextField size;
	
	private JButton startButton;

	//COMPONENTES FRAME PARA UBICAR BARCOS
	private JPanel chooseShips;
	private JPanel panelOptions;
	
	private ButtonGroup optionShip;
	private JRadioButton portaavion;
	private JRadioButton acorazado;
	private JRadioButton destructor;
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
		//this.principalFrame.setBounds(400, 100, 800, 600);
		this.principalFrame.setBounds(0,0, 500, 300);
		this.principalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initButtons();
	}
	private void initButtons() {
		this.startButton = new JButton("Comenzar");
		this.nextButton = new JButton("Jugar");
		
		this.optionShip = new ButtonGroup();
		
		this.portaavion = new JRadioButton("Portaavión. (5 celdas)");
		this.acorazado = new JRadioButton("Acorazado. (4 celdas)");
		this.destructor = new JRadioButton("Destructor. (3 celdas)");
		this.submarino = new JRadioButton("Submarino. (2 celdas)");
		
		this.optionShip.add(portaavion);
		this.optionShip.add(acorazado);
		this.optionShip.add(destructor);
		this.optionShip.add(submarino);
		
		this.direction = new ButtonGroup();
		
		this.top = new JRadioButton("Arriba");
		this.bottom = new JRadioButton("Abajo");
		this.left = new JRadioButton("Izquierda");
		this.right = new JRadioButton("Derecha");
	}
	//Panel de inicio donde se ingresa el nombre del jugador
	public void register() {
		this.principalPanel = new JPanel(new BorderLayout());
		
		this.title = new JLabel("BATALLA NAVAL");
		this.title.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		this.panelRegister = new JPanel(new BorderLayout());
		this.panelRegister.setBackground(Color.gray);
		this.panelRegister.add(this.title, BorderLayout.NORTH);
		
		this.image = new ImageIcon("src//resources//register2.jpg");

		this.panelRegister.add(new JLabel(this.image), BorderLayout.CENTER);
		
		this.data = new JPanel(new GridLayout(5,1));
		this.labelName = new JLabel("Ingresa tu nombre");
		this.name = new JTextField(20);
		this.data.setBackground(Color.gray);
		this.labelSize = new JLabel("Ingresa el tamaño de la cuadricula");
		this.size = new JTextField("10");
		

		data.add(labelName);
		data.add(name);
		data.add(labelSize);
		data.add(size);
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
		
		this.generateShipsPanel();
		this.generatePanelOptions();
		this.chooseShips.add(new JLabel("Ubica tus barcos"), BorderLayout.NORTH);
		
		JPanel content = new JPanel(new BorderLayout());
		content.add(panelOptions, BorderLayout.WEST);
		content.add(panelShips, BorderLayout.CENTER);
		this.chooseShips.add(content, BorderLayout.CENTER);
		
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
		
		this.boardPlayer = new JPanel();
		this.generateBoard( this.boardPlayer, "PLAYER");
		this.panelShips.add(boardPlayer, BorderLayout.CENTER);
		
		//this.generatePanelOptions();
		//this.principalFrame.add(panelShips);
	}
	public void generatePanelOptions() {
		this.panelOptions = new JPanel(new GridLayout(10,1));
		this.panelOptions.add(new JLabel("Selecciona el barco que quieres ubicar"));
			
		this.panelOptions.add(portaavion);
		this.panelOptions.add(acorazado);
		this.panelOptions.add(destructor);
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
		
		//this.principalFrame.add(panelOptions);
		
	}
	public void generateGamePanel(){
		this.principalFrame.remove(this.principalPanel);
		this.principalPanel = new JPanel(new BorderLayout());
		
		//this.principalFrame.removeAll();
		this.mainPanel = new JPanel(new BorderLayout());
		
		this.centralPanel = new JPanel(new GridLayout(1,2));//panel que contiene los paneles de los tableros
		
		//GENERO UN PANEL QUE CONTENGA EL TABLERO
		/*
		this.boardPlayer = new JPanel();
		this.generateBoard(10, 10, this.boardPlayer);
		*/
		//GENERO UN LABEL QUE TENGA EL NOMBRE DEL JUGADOR
		this.playerName = new JLabel(this.name.getText());
		//HAGO UN PANEL SECUNDARIO QUE CONTENGA EL NOMBRE DEL JUGADOR Y SU TABLERO
		this.panelPlayer = new JPanel();
		this.generateSidePanel(boardPlayer, playerName, panelPlayer);
		
		//this.mainPanel.add(this.panelPlayer, BorderLayout.WEST);

		this.boardOpponent = new JPanel();
		this.generateBoard(this.boardOpponent, "MAQUINA");
		this.opponentName = new JLabel("Máquina");
		this.panelOpponent = new JPanel();
		this.generateSidePanel(boardOpponent, opponentName, panelOpponent);
		
		//this.mainPanel.add(this.panelOpponent, BorderLayout.EAST);
		this.centralPanel.add(panelPlayer);
		this.centralPanel.add(panelOpponent);
		
		this.mainPanel.add(centralPanel, BorderLayout.CENTER);
		this.mainPanel.add(new JLabel("BATTLESHIP"), BorderLayout.SOUTH);
		
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
		int  rows = Integer.parseInt(this.getSize().getText());
		int columns = rows;
		panel.setLayout(new GridLayout(rows,columns));
		this.buttons = new JButton[rows][columns];
		
		for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
            	
				buttons[i][j] = new JButton(); 
				buttons[i][j].setActionCommand(i+"-"+j+"-"+typeBoard);
				panel.add(buttons[i][j]);
            }
        }
		//framePrincipal.add(panel);
	}/*
	public void putShip(int row, int colum, int sizeShip, String direction) {
		sizeShip = sizeShip - 1;
		buttons[row][colum].setBackground(Color.red);
		buttons[row][colum].setEnabled(false);;
		if(direction.equals("top")) {
			for (int i = row-sizeShip; i < row; i++) {
				
				buttons[i][colum].setBackground(Color.red);
				buttons[i][colum].setEnabled(false);;
			}
		}else if(direction.equals("bottom")) {
			for (int i = row; i <= row+sizeShip; i++) {
				buttons[i][colum].setBackground(Color.red);
				buttons[i][colum].setEnabled(false);;
			}
		}else if(direction.equals("left")) {
			for (int i = colum-sizeShip; i < colum; i++) {
				buttons[row][i].setBackground(Color.red);
				buttons[row][i].setEnabled(false);
			}
		}else {//right
			for (int i = colum; i <= colum+sizeShip; i++) {
				buttons[row][i].setBackground(Color.red);
				buttons[row][i].setEnabled(false);
			}
		}
	}*/
	public void setColorButton(int row, int colum, String typeButton) {
		if(typeButton.equals("SHIP"))
			this.getButtons()[row][colum].setBackground(Color.red);
		else if(typeButton.equals("MACHINE"))
			this.getButtons()[row][colum].setBackground(Color.green);
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
	public JTextField getSize() {
		return size;
	}
	public void setSize(JTextField size) {
		this.size = size;
	}
	
}
