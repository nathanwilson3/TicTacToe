//Nathan Wilson

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class TicTacToe extends JFrame {
    //fields
    int xScore = 0;
    int oScore = 0;

    JPanel mainPanel = new JPanel();//this will hold the main buttons
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String currentPlayer = "X";
    Font font4Buttons = new Font(Font.SERIF, Font.BOLD, 100);
    JMenuBar mainMenu = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");

    JMenuItem reset = new JMenuItem("Reset");//added a menu item to reset the game
    JMenuItem exit = new JMenuItem("Exit");
    JMenuItem somethingElse = new JMenuItem("Something else");
    JMenuItem resetScore = new JMenuItem("Reset Score");//added a menu item to reset the score





    //methods
    public void SwitchPlayer()
    {
        if(currentPlayer == "X")
        {
            currentPlayer = "O";
        }
        else
        {
            currentPlayer = "X";
        }
        //currentPlayer = (currentPlayer=="X")?"O":"X";
    }

    public boolean CheckForWinner() {
        // check first row
        if (btn1.getText() == btn2.getText()
                && btn1.getText() == btn3.getText()
                && btn1.getText() != "")
            return true;

        // check second row
        if (btn4.getText() == btn5.getText()
                && btn4.getText() == btn6.getText()
                && btn4.getText() != "")
            return true;

        // check third row
        if (btn7.getText() == btn8.getText()
                && btn7.getText() == btn9.getText()
                && btn7.getText() != "")
            return true;

        // check first column
        if (btn1.getText() == btn4.getText()
                && btn1.getText() == btn7.getText()
                && btn1.getText() != "")
            return true;

        // check second column
        if (btn2.getText() == btn5.getText()
                && btn2.getText() == btn8.getText()
                && btn2.getText() != "")
            return true;

        // check third column
        if (btn3.getText() == btn6.getText()
                && btn3.getText() == btn9.getText()
                && btn3.getText() != "")
            return true;

        // check first diagonal
        if (btn1.getText() == btn5.getText()
                && btn1.getText() == btn9.getText()
                && btn1.getText() != "")
            return true;

        // check second diagonal
        if (btn3.getText() == btn5.getText()
                && btn3.getText() == btn7.getText()
                && btn3.getText() != "")
            return true;

        // all else
        return false;
    }

    //Check for a draw
    public boolean checkForDraw()
    {
        JButton[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        for(JButton btn : buttons)
        {
            if(btn.getText().equals(""))
            {
                return false; //There is still an empty square
            }
        }
        return true;
    }
    //Reset the game 
    public void resetGame()
    {
        JButton[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        for(JButton btn : buttons)
        {   //resets the game and sets player to x
            btn.setEnabled(true);
            btn.setText("");
            btn.setBackground(null);
        }
        currentPlayer = "X";
    }

    //click event handler
    public void ButtonClickHandler(ActionEvent e)
    {
        JButton theButtonClicked = (JButton)e.getSource();
        theButtonClicked.setEnabled(false);//disable the button that was clicked on
        theButtonClicked.setText(currentPlayer);//put "X" or "O" ...
        theButtonClicked.setBackground(currentPlayer == "X"?Color.CYAN: Color.ORANGE);//set background color for the button
        if(CheckForWinner())//do we have a winner
        {   
            //update the score of games won by each player
            if(currentPlayer.equals("X"))
            {   //increment x score if they won 
                xScore++;
            }
            else
            {   //otherwise increment O score
                oScore++;
            }
            JOptionPane.showMessageDialog(this, currentPlayer + " wins!\n\nTotal Wins:\nX: " + xScore + " - O: " + oScore);//we congratulate the user and display number of wins by each player

            //disable all buttons
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
        //check for a draw
        else if(checkForDraw())
        {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            resetGame();
        }
        SwitchPlayer();
    }

    public void someMethod()
    {
        JOptionPane.showMessageDialog(this, "Hello");
    }
    //ctor(s)
    public TicTacToe() {
        super();

        setContentPane(mainPanel);

        //build 9 buttons
        btn1 = new JButton(); btn1.addActionListener(e -> ButtonClickHandler(e)); btn1.setFont(font4Buttons);
        btn2 = new JButton(); btn2.addActionListener(e -> ButtonClickHandler(e)); btn2.setFont(font4Buttons);
        btn3 = new JButton(); btn3.addActionListener(e -> ButtonClickHandler(e)); btn3.setFont(font4Buttons);
        btn4 = new JButton(); btn4.addActionListener(e -> ButtonClickHandler(e)); btn4.setFont(font4Buttons);
        btn5 = new JButton(); btn5.addActionListener(e -> ButtonClickHandler(e)); btn5.setFont(font4Buttons);
        btn6 = new JButton(); btn6.addActionListener(e -> ButtonClickHandler(e)); btn6.setFont(font4Buttons);
        btn7 = new JButton(); btn7.addActionListener(e -> ButtonClickHandler(e)); btn7.setFont(font4Buttons);
        btn8 = new JButton(); btn8.addActionListener(e -> ButtonClickHandler(e)); btn8.setFont(font4Buttons);
        btn9 = new JButton(); btn9.addActionListener(e -> ButtonClickHandler(e)); btn9.setFont(font4Buttons);


        //add them to the main panel
        mainPanel.add(btn1);
        mainPanel.add(btn2);
        mainPanel.add(btn3);
        mainPanel.add(btn4);
        mainPanel.add(btn5);
        mainPanel.add(btn6);
        mainPanel.add(btn7);
        mainPanel.add(btn8);
        mainPanel.add(btn9);

        setJMenuBar(mainMenu);
        mainMenu.add(file);
        file.add(edit);
        file.add(reset);
        reset.addActionListener(e -> resetGame() );
        file.add(exit);
        file.add(resetScore);
        //add an action listener to the resetScore menu item
        resetScore.addActionListener( e -> {
            xScore = 0;
            oScore = 0;
            JOptionPane.showMessageDialog(this, "Scores reset!\n\nTotal Wins:\nX: " + xScore + " - O: " + oScore);
        });

        mainMenu.add(help);
        help.add(somethingElse);



        //set layout
        mainPanel.setLayout(new GridLayout(3,3));
        setTitle("CSC205 Tic Tac Toe");//leave this for the end
        setSize(500, 500);
        setLocation(100, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
}
