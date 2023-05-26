import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessTheNumberGUI extends JFrame {
    private int secretNumber;
    private int attempts;

    private JLabel messageLabel;
    private JTextField guessField;
    private JButton guessButton;

    public GuessTheNumberGUI() {
        secretNumber = (int) (Math.random() * 100);
        attempts = 0;

        setTitle("Guess the Number");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        messageLabel = new JLabel("Enter your guess (0-99):");
        guessField = new JTextField(10);
        guessButton = new JButton("Guess");

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        add(messageLabel);
        add(guessField);
        add(guessButton);

        pack();
        setVisible(true);
    }

    private void checkGuess() {
        int guess = Integer.parseInt(guessField.getText());
        attempts++;

        if (guess == secretNumber) {
            JOptionPane.showMessageDialog(this, "Congratulations! You guessed the number in " + attempts + " attempts.", "Guess the Number", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else if (guess < secretNumber) {
            JOptionPane.showMessageDialog(this, "Too low! Try again.", "Guess the Number", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Too high! Try again.", "Guess the Number", JOptionPane.WARNING_MESSAGE);
        }

        guessField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GuessTheNumberGUI();
            }
        });
    }
}

