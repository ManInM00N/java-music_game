
import javax.swing.*;
/**
 * @version 1.0
 * @Author ManInM00N  Computer Science class 3 2200303310
 * @Date 2023/6/1 15:54
 * @×¢ÊÍ
 */

public class Note extends JLabel {
    static ImageIcon noteIcon = new ImageIcon("src/image/note.png");
    public int x;
    public int y;
    public Note() {
        this.setIcon(noteIcon);
        this.setSize(105, 12);
        this.setVisible(false);
        this.setOpaque(false);
    }

}
