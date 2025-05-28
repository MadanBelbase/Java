import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessTheNumberGame extends JFrame implements ActionListener {
    private int randomNumber;
    private int attempts;
    private int userScore = 0;
    private int computerScore = 0;

    private JButton guessButton;
    private JTextField inputField;
    private JLabel messageLabel;
    

    public GuessTheNumberGame() {
        super("Guess the Number - User vs Computer");

        setLayout(new FlowLayout());

        messageLabel = new JLabel("Guess a number between 1 and 100 (3 tries):");
        add(messageLabel);

        inputField = new JTextField(10);
        add(inputField);

        guessButton = new JButton("Guess");
        guessButton.addActionListener(this);
        add(guessButton);

        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        startNewGame();
    }

    private void startNewGame() {
        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1;
        attempts = 3;
        inputField.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        String inputText = inputField.getText();

        try {
            int guess = Integer.parseInt(inputText);

            if (guess < 1 || guess > 100) {
                JOptionPane.showMessageDialog(this, "Enter a number between 1 and 100.");
                return;
            }

            attempts--;

            if (guess == randomNumber) {
                userScore++;
                JOptionPane.showMessageDialog(this, "Correct! You guessed it!");
                showScoreAndAskReplay();
                return;
            } else if (guess < randomNumber) {
                JOptionPane.showMessageDialog(this, "Too low! Attempts left: " + attempts);
            } else {
                JOptionPane.showMessageDialog(this, "Too high! Attempts left: " + attempts);
            }

            if (attempts == 0) {
                computerScore++;
                JOptionPane.showMessageDialog(this, "Out of attempts! The number was: " + randomNumber);
                showScoreAndAskReplay();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Enter a number.");
        }
    }

    private void showScoreAndAskReplay() {
        String scoreMessage = "Score:\nYou: " + userScore + "\nComputer: " + computerScore;
        int option = JOptionPane.showConfirmDialog(this, scoreMessage + "\nGame Over! Play again?", "Game Result", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            startNewGame();
        } else {
            JOptionPane.showMessageDialog(this, "Thanks for playing!\nFinal Score - You: " + userScore + " | Computer: " + computerScore);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new GuessTheNumberGame();
    }
}
