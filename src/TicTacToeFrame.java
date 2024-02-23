import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame
{
    private JPanel mainPanel, titlePanel, infoPanel, P1Panel, gamePanel, P2Panel, btnPanel;
    private JLabel titleLabel, P1Label, P2Label;
    private JTextPane P1Text, P2Text;
    private StyledDocument textPaneDoc;
    //Button Label Cheat-Sheet
    //Rows come before Columns (Row)(Column)Btn
    //Rows: T=Top  C=Center B=Bottom
    //Columns: L=Left C=Center R=Right
    private JButton TLBtn, TCBtn, TRBtn, CLBtn, CCBtn, CRBtn, BLBtn, BCBtn, BRBtn;
    private JButton newGameBtn, quitBtn;
    private static JButton[][] buttonGrid;
    private JOptionPane winOption, tieOption, errorOption;
    private ActionListener move = new moveListener();
    private ActionListener quit = new quitListener();
    private ActionListener newGame = new newGameListener();
    private static int ROW = 3;
    private static int COL = 3;
    public String player = "X";
    public String nextPlayer = "X";
    private static String board[][] = new String[ROW][COL];

    TicTacToeFrame()
    {
        setTitle("Tic Tac Toe");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        titlePanel = new JPanel();
        infoPanel = new JPanel();
        P1Panel = new JPanel();
        gamePanel = new JPanel();
        P2Panel = new JPanel();
        btnPanel = new JPanel();

        titleLabel = new JLabel("Tic Tac Toe");
        P1Label = new JLabel("Player 1");
        P2Label = new JLabel("Player 2");

        SimpleAttributeSet center = new SimpleAttributeSet();

        P1Text = new JTextPane();
        P1Text.setEditable(false);
        textPaneDoc = P1Text.getStyledDocument();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        textPaneDoc.setParagraphAttributes(0, textPaneDoc.getLength(), center, false);

        P2Text = new JTextPane();
        P2Text.setEditable(false);
        textPaneDoc = P2Text.getStyledDocument();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        textPaneDoc.setParagraphAttributes(0, textPaneDoc.getLength(), center, false);

        TLBtn = new JButton("_");
        TCBtn = new JButton("_");
        TRBtn = new JButton("_");
        CLBtn = new JButton("_");
        CCBtn = new JButton("_");
        CRBtn = new JButton("_");
        BLBtn = new JButton("_");
        BCBtn = new JButton("_");
        BRBtn = new JButton("_");
        newGameBtn = new JButton("New Game");
        buttonGrid = new JButton[ROW][COL];
        buttonGrid[0][0] = TLBtn;
        buttonGrid[0][1] = TCBtn;
        buttonGrid[0][2] = TRBtn;
        buttonGrid[1][0] = CLBtn;
        buttonGrid[1][1] = CCBtn;
        buttonGrid[1][2] = CRBtn;
        buttonGrid[2][0] = BLBtn;
        buttonGrid[2][1] = BCBtn;
        buttonGrid[2][2] = BRBtn;

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener(quit);

        winOption = new JOptionPane(player + " wins");
        tieOption = new JOptionPane("You tied");
        errorOption = new JOptionPane("You cannot more there");

        add(mainPanel);
        mainPanel.setLayout(new GridLayout(3,1,0,30));
        mainPanel.setBackground(new Color(33, 33, 33));
        mainPanel.add(titlePanel);
        mainPanel.add(infoPanel);
        mainPanel.add(btnPanel);

        titlePanel.setLayout(new GridLayout(1,1));
        titlePanel.setBackground(new Color(33, 33, 33));
        titlePanel.add(titleLabel);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
        titleLabel.setForeground(new Color(204, 70, 160));

        infoPanel.setLayout(new GridLayout(1,3));
        infoPanel.setBorder(new LineBorder(new Color(120, 33, 91)));
        infoPanel.setBackground(new Color(33, 33, 33));
        infoPanel.add(P1Panel);
        infoPanel.add(gamePanel);
        infoPanel.add(P2Panel);

        P1Panel.setLayout(new GridLayout(2,1));
        P1Panel.setBorder(new LineBorder(new Color(120, 33, 91)));
        P1Panel.setBackground(new Color(222, 135, 193));
        P1Panel.add(P1Label);
        P1Label.setHorizontalAlignment(JLabel.CENTER);
        P1Label.setFont(new Font("Times New Roman", Font.BOLD, 35));
        P1Label.setBorder(new LineBorder(new Color(120, 33, 91)));
        P1Label.setForeground(new Color(120, 33, 91));
        P1Panel.add(P1Text);
        P1Text.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));

        gamePanel.setLayout(new GridLayout(3,3));
        gamePanel.setBorder(new LineBorder(new Color(120, 33, 91)));
        gamePanel.setBackground(new Color(120, 33, 91));
        gamePanel.add(TLBtn);
        gamePanel.add(TCBtn);
        gamePanel.add(TRBtn);
        gamePanel.add(CLBtn);
        gamePanel.add(CCBtn);
        gamePanel.add(CRBtn);
        gamePanel.add(BLBtn);
        gamePanel.add(BCBtn);
        gamePanel.add(BRBtn);

        TLBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        TLBtn.setBorder(new LineBorder(new Color(120, 33, 91)));
        TLBtn.setBackground(new Color(222, 135, 193));
        TLBtn.setForeground(new Color(120, 33, 91));

        TCBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        TCBtn.setBorder(new LineBorder(new Color(120, 33, 91)));
        TCBtn.setBackground(new Color(222, 135, 193));
        TCBtn.setForeground(new Color(120, 33, 91));

        TRBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        TRBtn.setBorder(new LineBorder(new Color(120, 33, 91)));
        TRBtn.setBackground(new Color(222, 135, 193));
        TRBtn.setForeground(new Color(120, 33, 91));

        CLBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        CLBtn.setBorder(new LineBorder(new Color(120, 33, 91)));
        CLBtn.setBackground(new Color(222, 135, 193));
        CLBtn.setForeground(new Color(120, 33, 91));

        CCBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        CCBtn.setBorder(new LineBorder(new Color(120, 33, 91)));
        CCBtn.setBackground(new Color(222, 135, 193));
        CCBtn.setForeground(new Color(120, 33, 91));

        CRBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        CRBtn.setBorder(new LineBorder(new Color(120, 33, 91)));
        CRBtn.setBackground(new Color(222, 135, 193));
        CRBtn.setForeground(new Color(120, 33, 91));

        BLBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        BLBtn.setBorder(new LineBorder(new Color(120, 33, 91)));
        BLBtn.setBackground(new Color(222, 135, 193));
        BLBtn.setForeground(new Color(120, 33, 91));

        BCBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        BCBtn.setBorder(new LineBorder(new Color(120, 33, 91)));
        BCBtn.setBackground(new Color(222, 135, 193));
        BCBtn.setForeground(new Color(120, 33, 91));

        BRBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        BRBtn.setBorder(new LineBorder(new Color(120, 33, 91)));
        BRBtn.setBackground(new Color(222, 135, 193));
        BRBtn.setForeground(new Color(120, 33, 91));

        TLBtn.addActionListener(move);
        TCBtn.addActionListener(move);
        TRBtn.addActionListener(move);
        CLBtn.addActionListener(move);
        CCBtn.addActionListener(move);
        CRBtn.addActionListener(move);
        BLBtn.addActionListener(move);
        BCBtn.addActionListener(move);
        BRBtn.addActionListener(move);

        P2Panel.setLayout(new GridLayout(2,1));
        P2Panel.setBorder(new LineBorder(new Color(120, 33, 91)));
        P2Panel.setBackground(new Color(222, 135, 193));
        P2Panel.add(P2Label);
        P2Label.setHorizontalAlignment(JLabel.CENTER);
        P2Label.setFont(new Font("Times New Roman", Font.BOLD, 35));
        P2Label.setBorder(new LineBorder(new Color(120, 33, 91)));
        P2Label.setForeground(new Color(120, 33, 91));
        P2Panel.add(P2Text);
        P2Text.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));

        btnPanel.setLayout(new GridLayout(1,2));
        btnPanel.setBackground(new Color(33, 33, 33));
        btnPanel.setBorder(new LineBorder(new Color(120, 33, 91)));
        btnPanel.add(newGameBtn);
        newGameBtn.addActionListener(newGame);
        newGameBtn.setMaximumSize(new Dimension(400, 100));
        newGameBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        newGameBtn.setBorder(new LineBorder(new Color(204, 70, 160)));
        newGameBtn.setBackground(new Color(120, 33, 91));
        newGameBtn.setForeground(new Color(204, 70, 160));
        btnPanel.add(quitBtn);
        quitBtn.setMaximumSize(new Dimension(400, 100));
        quitBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        quitBtn.setBorder(new LineBorder(new Color(204, 70, 160)));
        quitBtn.setBackground(new Color(120, 33, 91));
        quitBtn.setForeground(new Color(204, 70, 160));

        P1Text.setText("It's your turn");
        P2Text.setText("");
    }

    public class moveListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            JButton src = (JButton) AE.getSource();
            player = nextPlayer;
            if(src.getText().equals("_"))
            {
                for(int row = 0; row < ROW; row++)
                {
                    for(int col = 0; col < COL; col++)
                    {
                        if (buttonGrid[row][col] == src) {
                            src.setText(player);
                            if (player.equals("X"))
                            {
                                nextPlayer = "O";
                                P2Text.setText("It's your turn");
                                P1Text.setText("");
                            }
                            else {
                                nextPlayer = "X";
                                P1Text.setText("It's your turn");
                                P2Text.setText("");
                            }
                            board[row][col] = player;
                            if (isWin("X"))
                            {
                                JOptionPane.showMessageDialog(null, "X wins!");
                                TLBtn.setEnabled(false);
                                TCBtn.setEnabled(false);
                                TRBtn.setEnabled(false);
                                CLBtn.setEnabled(false);
                                CCBtn.setEnabled(false);
                                CRBtn.setEnabled(false);
                                BLBtn.setEnabled(false);
                                BCBtn.setEnabled(false);
                                BRBtn.setEnabled(false);
                            }
                            else if (isWin("O"))
                            {
                                JOptionPane.showMessageDialog(null, "O wins!");
                                TLBtn.setEnabled(false);
                                TCBtn.setEnabled(false);
                                TRBtn.setEnabled(false);
                                CLBtn.setEnabled(false);
                                CCBtn.setEnabled(false);
                                CRBtn.setEnabled(false);
                                BLBtn.setEnabled(false);
                                BCBtn.setEnabled(false);
                                BRBtn.setEnabled(false);
                            }
                            else if (isTie())
                            {
                                JOptionPane.showMessageDialog(null, "It's a tie!");
                                TLBtn.setEnabled(false);
                                TCBtn.setEnabled(false);
                                TRBtn.setEnabled(false);
                                CLBtn.setEnabled(false);
                                CCBtn.setEnabled(false);
                                CRBtn.setEnabled(false);
                                BLBtn.setEnabled(false);
                                BCBtn.setEnabled(false);
                                BRBtn.setEnabled(false);
                            }
                        }
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You cannot select this tile");
                if(player.equals("O"))
                {
                    P2Text.setText("It's your turn");
                    P1Text.setText("");
                }
                else if (player.equals("X"))
                {
                    P1Text.setText("It's your turn");
                    P2Text.setText("");
                }
            }
        }
    }
    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }
        return false;
    }
    private static boolean isColWin(String player)
    {
        for(int col = 0; col < COL; col++)
        {
            if(buttonGrid[0][col].getText().equals(player) && buttonGrid[1][col].getText().equals(player) && buttonGrid[2][col].getText().equals(player))
            {
                return true;
            }
        }
        return false;
    }
    private static boolean isRowWin(String player)
    {
        for(int row = 0; row < ROW; row++)
        {
            if(buttonGrid[row][0].getText().equals(player) && buttonGrid[row][1].getText().equals(player) && buttonGrid[row][2].getText().equals(player))
            {
                return true;
            }
        }
        return false;
    }
    private static boolean isDiagonalWin(String player){
        if(buttonGrid[0][0].getText().equals(player) && buttonGrid[1][1].getText().equals(player) && buttonGrid[2][2].getText().equals(player))
        {
            return true;
        }
        else if(buttonGrid[0][2].getText().equals(player) && buttonGrid[1][1].getText().equals(player) && buttonGrid[2][0].getText().equals(player))
        {
            return true;
        }
        return false;
    }
    private static boolean isTie()
    {
        String player = "X";
        boolean isFilled = true;
        boolean isWin = false;

        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                if(buttonGrid[row][col].getText().equals("_"))
                {
                    isFilled = false;
                }
            }
        }

        if(isWin("X") || isWin("Y"))
        {
            isWin = true;
        }

        if(isFilled && !isWin)
        {
            return true;
        }

        return false;
    }

    private class newGameListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            P1Text.setText("It's your turn");
            P2Text.setText("");
            TLBtn.setText("_");
            TCBtn.setText("_");
            TRBtn.setText("_");
            CLBtn.setText("_");
            CCBtn.setText("_");
            CRBtn.setText("_");
            BLBtn.setText("_");
            BCBtn.setText("_");
            BRBtn.setText("_");
            player = "X";
            nextPlayer = "X";
            TLBtn.setEnabled(true);
            TCBtn.setEnabled(true);
            TRBtn.setEnabled(true);
            CLBtn.setEnabled(true);
            CCBtn.setEnabled(true);
            CRBtn.setEnabled(true);
            BLBtn.setEnabled(true);
            BCBtn.setEnabled(true);
            BRBtn.setEnabled(true);
        }
    }
    private class quitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            System.exit(0);
        }
    }
}