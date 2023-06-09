
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * @version 1.0
 * @Author ManInM00N  Computer Science class 3 2200303310
 * @Date 2023/5/30 19:06
 * @×¢ÊÍ
 */

class Cover extends JLabel {
    ImageIcon coverPic;
    String audioFilePath;
    String scoreFilePath;
    public Cover(String name) {
        coverPic = new ImageIcon("src/cover/" + name + ".png");
        audioFilePath = "src/mp3/" + name + ".mp3";
        scoreFilePath = "src/txt/" + name+".txt";
        this.setIcon(coverPic);
        this.setSize(150, 150);
        this.setVisible(false);
    }
}
public class Select {
    InGame inGame = new InGame();
    Settings settings = new Settings();
    JLabel b = new JLabel(new ImageIcon("src/image/selectbg.png"));
    JCheckBox c = new JCheckBox("Auto play");
    JCheckBox high = new JCheckBox("High Speed");
    JPanel bPanel = new JPanel();
    public void selectInit() {
        Pages.window.getContentPane().removeAll();
        Pages.window.getContentPane().repaint();
//        Pages.auto = false;
        Pages.select.c.setSelected(Pages.auto);
        Pages.select.high.setSelected(Pages.highspeed);
        JLabel settingchange = new JLabel();
        settingchange.setIcon(new ImageIcon("src/image/settingicon.png"));
        settingchange.setBounds(50,600,150,150);
        Cover cover1 = new Cover("Cyaegha");
        Cover cover2 = new Cover("Mandragora");
        Cover cover3 = new Cover("cybe");
        Cover cover4 = new Cover("Jumpover_Space");
        Cover cover5 = new Cover("Dorian_Bakudan");
        Cover cover6 = new Cover("Lunar_paradoxx");
        Cover cover7 = new Cover("Water");
        Cover cover8 = new Cover("happyhappy");
        c.setFont(new Font("Î¢ÈíÑÅºÚ",Font.BOLD,22));
        c.setBounds(1000,600,150,50);
        c.setOpaque(false);
        high.setFont(new Font("Î¢ÈíÑÅºÚ",Font.BOLD,22));
        high.setBounds(1000,650,200,50);
        high.setOpaque(false);
        JPanel webpanel = new JPanel();
        c.setVisible(true);
//        c.setSelected(false);
        high.setVisible(true);
//        Pages.auto = false;
        webpanel.setLayout(null);
        webpanel.setLayout(new GridLayout(2,4,50,25));
        webpanel.setBounds(250,120,750,450);
        webpanel.add(cover1);
        webpanel.add(cover2);
        webpanel.add(cover3);
        webpanel.add(cover4);
        webpanel.add(cover5);
        webpanel.add(cover6);
        webpanel.add(cover7);
        webpanel.add(cover8);
        Pages.window.getContentPane().add(c);
        Pages.window.getContentPane().add(high);
        Pages.window.getContentPane().add(settingchange);
        settingchange.addMouseListener(new setting());

        webpanel.setBackground(Color.WHITE);
        webpanel.setOpaque(false);
        Pages.window.getContentPane().add(webpanel);
        cover2.setVisible(true);
        cover1.setVisible(true);
        cover3.setVisible(true);
        cover4.setVisible(true);
        cover5.setVisible(true);
        cover6.setVisible(true);
        cover7.setVisible(true);
        cover8.setVisible(true);
        cover1.addMouseListener(new selectListener());
        cover2.addMouseListener(new selectListener());
        cover3.addMouseListener(new selectListener());
        cover4.addMouseListener(new selectListener());
        cover5.addMouseListener(new selectListener());
        cover6.addMouseListener(new selectListener());
        cover7.addMouseListener(new selectListener());
        cover8.addMouseListener(new selectListener());
        b.setVisible(false);
        Pages.window.getContentPane().add(b);
        b.setBounds(0, 0, 1280, 800);
        b.setVisible(true);
    }
    class setting implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            Pages.auto= Pages.select.c.isSelected();
            Pages.highspeed = Pages.select.high.isSelected();
            Pages.window.getContentPane().removeAll();
            Pages.window.getContentPane().repaint();
            settings.Init();
        }
        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
    class selectListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            Pages.auto= Pages.select.c.isSelected();
            Pages.highspeed = Pages.select.high.isSelected();
            Pages.window.getContentPane().removeAll();
            Pages.window.getContentPane().repaint();
            Pages.has = true;
            inGame.inGameInit(((Cover) e.getComponent()).audioFilePath  , ((Cover) e.getComponent()).scoreFilePath  );
            inGame.start();
        }
        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }

    }
}
