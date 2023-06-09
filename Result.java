
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * @version 1.0
 * @Author ManInM00N  Computer Science class 3 2200303310
 * @Date 2023/5/31 22:14
 * @×¢ÊÍ
 */

public class Result {
    static JLabel result = new JLabel(new ImageIcon("src/image/resultbg.png"));
    ReturnListener returnListener = new ReturnListener();
    public void resultPage(int perfect, int good, int miss, int maxCombo) {
        Pages.window.getContentPane().removeAll();
        Pages.window.getContentPane().repaint();
        JPanel resultPanel = new JPanel();
        ImageIcon goback = new ImageIcon("src/image/goback.png");
        JLabel gobackLabel = new JLabel();
        gobackLabel.setBounds(950,750,300,50);
        gobackLabel.setIcon(goback);
        JLabel score = new JLabel();
        score.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD,52));
        score.setText("Score:"+InGame.totalscores.toString());
        score.setForeground(Color.ORANGE);
        JLabel perfect1 = new JLabel(Figure.figureIcons[perfect % 10]);
        JLabel perfect10 = new JLabel(Figure.figureIcons[perfect / 10 % 10]);
        JLabel perfect100 = new JLabel(Figure.figureIcons[perfect / 100 % 10]);

        JLabel good1 = new JLabel(Figure.figureIcons[good % 10]);
        JLabel good10 = new JLabel(Figure.figureIcons[good / 10 % 10]);
        JLabel good100 = new JLabel(Figure.figureIcons[good / 100 % 10]);

        JLabel miss1 = new JLabel(Figure.figureIcons[miss % 10]);
        JLabel miss10 = new JLabel(Figure.figureIcons[miss / 10 % 10]);
        JLabel miss100 = new JLabel(Figure.figureIcons[miss / 100 % 10]);

        JLabel maxCombo1 = new JLabel(Figure.figureIcons[maxCombo % 10]);
        JLabel maxCombo10 = new JLabel(Figure.figureIcons[maxCombo / 10 % 10]);
        JLabel maxCombo100 = new JLabel(Figure.figureIcons[maxCombo / 100 % 10]);
        
        perfect1.setVisible(false);
        perfect10.setVisible(false);
        perfect100.setVisible(false);
        good1.setVisible(false);
        good10.setVisible(false);
        good100.setVisible(false);
        miss1.setVisible(false);
        miss10.setVisible(false);
        miss100.setVisible(false);
        maxCombo1.setVisible(false);
        maxCombo10.setVisible(false);
        maxCombo100.setVisible(false);
        score.setVisible(false);
        gobackLabel.setVisible(false);

        Pages.window.getContentPane().add(perfect1);
        Pages.window.getContentPane().add(perfect10);
        Pages.window.getContentPane().add(perfect100);
        Pages.window.getContentPane().add(good1);
        Pages.window.getContentPane().add(good10);
        Pages.window.getContentPane().add(good100);
        Pages.window.getContentPane().add(miss1);
        Pages.window.getContentPane().add(miss10);
        Pages.window.getContentPane().add(miss100);
        Pages.window.getContentPane().add(maxCombo1);
        Pages.window.getContentPane().add(maxCombo10);
        Pages.window.getContentPane().add(maxCombo100);
        Pages.window.getContentPane().add(gobackLabel);
        Pages.window.getContentPane().add(score);
        result.setVisible(false);
        resultPanel.setVisible(true);
        resultPanel.setBounds(0,0,1280,800);
        resultPanel.add(result);
        Pages.window.getContentPane().add(resultPanel);
        result.setBounds(0, 0, 1280, 800);
        result.setVisible(true);

        score.setBounds(910,350,400,108);
        perfect1.setBounds(838, 210, 34, 86);
        perfect10.setBounds(802, 210, 34, 86);
        perfect100.setBounds(766, 210, 34, 86);
        good1.setBounds(838, 314, 34, 86);
        good10.setBounds(802, 314, 34, 86);
        good100.setBounds(766, 314, 34, 86);
        miss1.setBounds(838, 418, 34, 86);
        miss10.setBounds(802, 418, 34, 86);
        miss100.setBounds(766, 418, 34, 86);
        maxCombo1.setBounds(838, 522, 34, 86);
        maxCombo10.setBounds(802, 522, 34, 86);
        maxCombo100.setBounds(766, 522, 34, 86);
        
        try {
            Thread.sleep(750);
            perfect1.setVisible(true);
            perfect10.setVisible(true);
            perfect100.setVisible(true);
            Thread.sleep(750);
            good1.setVisible(true);
            good10.setVisible(true);
            good100.setVisible(true);
            Thread.sleep(750);
            miss1.setVisible(true);
            miss10.setVisible(true);
            miss100.setVisible(true);
            Thread.sleep(750);
            maxCombo1.setVisible(true);
            maxCombo10.setVisible(true);
            maxCombo100.setVisible(true);
            Thread.sleep(750);
            score.setVisible(true);
            Thread.sleep(750);
            gobackLabel.setVisible(true);
            Pages.has = false;
            Thread.sleep(8500);

            Pages.select.selectInit();
            Pages.ret = true;
//            Pages.window.addMouseListener(returnListener);
        } catch (InterruptedException e) {
        }
    }
    class ReturnListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            Pages.ret = true;
            Pages.window.removeMouseListener(returnListener);
        }
        @Override
        public void mousePressed(MouseEvent e) { }
        @Override
        public void mouseReleased(MouseEvent e) { }
        @Override
        public void mouseEntered(MouseEvent e) { }
        @Override
        public void mouseExited(MouseEvent e) { }

    }
}
