
import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * @version 1.0
 * @Author ManInM00N  Computer Science class 3 2200303310
 * @Date 2023/6/1 15:54
 * @×¢ÊÍ
 */

public class Pages {

    public static JFrame window = new JFrame();
    public static boolean ret = false;
    public static boolean has = false;
    public static boolean auto = false;
    public static boolean highspeed = false;
    public static int keyCode1 = KeyEvent.VK_S;
    public static int keyCode2 = KeyEvent.VK_D;
    public static int keyCode3 = KeyEvent.VK_J;
    public static int keyCode4 = KeyEvent.VK_K;
    static Select select = new Select();
    public Pages() {
        window.setSize(1280, 835);
        window.setResizable(false);
        window.setVisible(true);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void run() {
        while (true) {
            ret = false;
            has = false;
            select.selectInit();
            while (has == false){
            }
            while (ret==false) {
            }
        }
    }

}
