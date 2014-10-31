package com.mahadihasan.tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author MdMahadiHasan
 */
/**
 * JFrame to hold TicTacToe board.
 */
public class TicTacToeFrame extends JFrame {

    private char whoseTurn = 'X';
    private boolean gameOver = false;

    private final Cell[][] cells = new Cell[3][3];

    JLabel jlblStatus = new JLabel("X's turn to play");

    public TicTacToeFrame() {
        JPanel panel = new JPanel(new GridLayout(3, 3, 1, 1));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                panel.add(cells[i][j] = new Cell());
            }
        }

        panel.setBorder(new LineBorder(Color.BLACK, 1));
        jlblStatus.setBorder(new LineBorder(Color.BLUE, 2));
        jlblStatus.setFont(new Font(Font.SANS_SERIF, 1, 12));
        add(panel, BorderLayout.CENTER);
        add(jlblStatus, BorderLayout.SOUTH);
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j].getToken() == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWon(char token) {
        for (int i = 0; i < 3; i++) {
            if ((cells[i][0].getToken() == token)
                    && (cells[i][1].getToken() == token)
                    && (cells[i][2].getToken() == token)) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if ((cells[0][j].getToken() == token)
                    && (cells[1][j].getToken() == token)
                    && (cells[2][j].getToken() == token)) {
                return true;
            }
        }
        if ((cells[0][0].getToken() == token)
                && (cells[1][1].getToken() == token)
                && (cells[2][2].getToken() == token)) {
            return true;
        }

        return (cells[0][2].getToken() == token)
                && (cells[1][1].getToken() == token)
                && (cells[2][0].getToken() == token);
    }

    public class Cell extends JPanel {

        private char token = ' ';

        public Cell() {
            setBorder(new LineBorder(Color.BLACK, 2));
            addMouseListener(new MyMouseListener());
        }

        public char getToken() {
            return token;
        }

        public void setToken(char c) {
            token = c;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (token == 'X') {
                g.setColor(Color.RED);
                g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
                g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
            } else if (token == 'O') {
                g.setColor(Color.BLUE);
                g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
            }
        }

        private class MyMouseListener extends MouseAdapter {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (gameOver) {
                    return;
                }

                if (token == ' ' && whoseTurn != ' ') {
                    setToken(whoseTurn);
                }

                if (isWon(whoseTurn)) {
                    jlblStatus.setText(whoseTurn + " won! Game over!");
                    JOptionPane.showMessageDialog(null, "'"+whoseTurn+"' won! Game over!");
                    whoseTurn = ' ';
                    gameOver = true;
                } else if (isFull()) {
                    jlblStatus.setText("Tie game! Game over!");
                    JOptionPane.showMessageDialog(null, " Tie game! Game over!");
                    whoseTurn = ' ';
                    gameOver = true;
                } else {
                    whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
                    jlblStatus.setText(whoseTurn + "'s turn.");
                }
            }
        }
    }
}
