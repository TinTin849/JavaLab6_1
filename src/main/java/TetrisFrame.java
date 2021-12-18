import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serial;

public class TetrisFrame extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    JLabel statusbar, score;

    public TetrisFrame() {
        score = new JLabel("Счет:");
        statusbar = new JLabel("0");
        add(score, BorderLayout.SOUTH);
        add(statusbar, BorderLayout.SOUTH);
        Board board = new Board(this);
        JOptionPane.showMessageDialog(board,
                """
                        Тетрис\s
                         Луговой А. ИКПИ-96
                        Об игре:
                         Ваша задача уничтожить строки блоков не оставляя пустого пространства между блоками
                         Кнопки :\s
                         Перемещение по горизонтали:
                         1. Влево : Стрелка влево
                         2. Вправо: Стрелка вправо
                         Повороты фигуры
                         1. Влево : Стрелка вверх\s
                         2. Вправо: Стрелка вниз \s
                         Опустить фигуры вниз :Пробел
                         Пауза: Нажмите <P>
                         Лучший результат: Нажмите <H>
                         Новая игра: Нажмите <N>
                        """);
        add(board);
        board.start();

        setSize(300, 600);
        setTitle("Tetris IKPI-96");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        TetrisFrame game = new TetrisFrame();
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }

    public JLabel getStatusBar() {
        return statusbar;
    }
}