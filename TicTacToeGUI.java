package tictactoe;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;

public class TicTacToeGUI extends JFrame {
    private JButton[][] buttons;
    private JLabel statusLabel;
    private JButton resetButton;
    private GameController controller;

    public TicTacToeGUI(GameController controller) {
        this.controller = controller;
        initializeUI(); // sets up user interface 
    }

    private void initializeUI() {
        setTitle("Tic Tac Toe");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        buttons = new JButton[3][3];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                JButton button = new JButton("");
                button.setFont(new Font("Arial", Font.BOLD, 60));
                final int r = row, c = col;
                button.addActionListener(e -> {
                    if (controller != null) {
                        controller.onCellClicked(r, c);
                    }
                });
                buttons[row][col] = button;
                boardPanel.add(button);
            }
        }

        statusLabel = new JLabel("Player 1's turn", SwingConstants.CENTER);
        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            if (controller != null) {
                controller.onResetClicked();
            }
        });

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(statusLabel, BorderLayout.CENTER);
        bottomPanel.add(resetButton, BorderLayout.EAST);

        add(boardPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void updateBoard(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char cell = board[row][col];
                if (cell == ' ') {
                    buttons[row][col].setText("");
                } else {
                    buttons[row][col].setText(String.valueOf(cell));
                }
                buttons[row][col].setEnabled(board[row][col] == ' ');
            }
        }
    }

    public void showWinner(Player player) {
        statusLabel.setText(player.getName() + " wins!");
    }

    public void showDraw() {
        statusLabel.setText("It's a draw");
    }

    public void showMessage(String message) {
        statusLabel.setText(message);
    }

    public void clearBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
                buttons[row][col].setEnabled(true);
            }
        }
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }
}
