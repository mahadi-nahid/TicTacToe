package com.mahadihasan.tictactoe;

import javax.swing.JFrame;

/**
 *
 * @author MdMahadiHasan
 */

public class TicTacToe {

    public static void main(String[] args) {
        
        TicTacToeFrame  ticTacToe = new TicTacToeFrame();
        ticTacToe.setTitle("TicTacToe Game!");
        ticTacToe.setSize(550, 550);
        
        
        ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticTacToe.setLocationRelativeTo(null);
        ticTacToe.setVisible(true);
        ticTacToe.setResizable(false);
    }
}
