
import javax.swing.*;
/**
 * @version 1.0
 * @Author ManInM00N  Computer Science class 3 2200303310
 * @Date 2023/5/31 17:54
 * @×¢ÊÍ
 */

public class Figure {
    static ImageIcon[] figureIcons = { new ImageIcon("src/image/fig0.png"),
            new ImageIcon("src/image/fig1.png"),
            new ImageIcon("src/image/fig2.png"),
            new ImageIcon("src/image/fig3.png"),
            new ImageIcon("src/image/fig4.png"),
            new ImageIcon("src/image/fig5.png"),
            new ImageIcon("src/image/fig6.png"),
            new ImageIcon("src/image/fig7.png"),
            new ImageIcon("src/image/fig8.png"), 
            new ImageIcon("src/image/fig9.png") };
    public static JLabel[] comboFigure1 = { new JLabel(figureIcons[0]),
            new JLabel(figureIcons[1]),
            new JLabel(figureIcons[2]),
            new JLabel(figureIcons[3]), 
            new JLabel(figureIcons[4]),
            new JLabel(figureIcons[5]),
            new JLabel(figureIcons[6]),
            new JLabel(figureIcons[7]),
            new JLabel(figureIcons[8]),
            new JLabel(figureIcons[9]) };
    public static JLabel[] comboFigure10 = { new JLabel(figureIcons[0]),
            new JLabel(figureIcons[1]),
            new JLabel(figureIcons[2]),
            new JLabel(figureIcons[3]), 
            new JLabel(figureIcons[4]),
            new JLabel(figureIcons[5]),
            new JLabel(figureIcons[6]),
            new JLabel(figureIcons[7]),
            new JLabel(figureIcons[8]),
            new JLabel(figureIcons[9]) };
    public static JLabel[] comboFigure100 = { new JLabel(figureIcons[0]),
            new JLabel(figureIcons[1]),
            new JLabel(figureIcons[2]),
            new JLabel(figureIcons[3]), 
            new JLabel(figureIcons[4]),
            new JLabel(figureIcons[5]),
            new JLabel(figureIcons[6]),
            new JLabel(figureIcons[7]),
            new JLabel(figureIcons[8]),
            new JLabel(figureIcons[9]) };
    public static void addFigure() {
        for (int i = 0; i < 10; i++) {
            comboFigure1[i].setVisible(false);
            comboFigure10[i].setVisible(false);
            comboFigure100[i].setVisible(false);
            Pages.window.getLayeredPane().add(comboFigure1[i]);
            Pages.window.getLayeredPane().add(comboFigure10[i]);
            Pages.window.getLayeredPane().add(comboFigure100[i]);
            Pages.window.getLayeredPane().setComponentZOrder(comboFigure1[i],1);
            Pages.window.getLayeredPane().setComponentZOrder(comboFigure10[i],1);
            Pages.window.getLayeredPane().setComponentZOrder(comboFigure100[i],1);
            comboFigure1[i].setBounds(229, 370, 34, 86);
            comboFigure10[i].setBounds(193, 370, 34, 86);
            comboFigure100[i].setBounds(157, 370, 34, 86);
        }
        comboFigure1[0].setVisible(true);
        comboFigure10[0].setVisible(true);
        comboFigure100[0].setVisible(true);
    }
}
