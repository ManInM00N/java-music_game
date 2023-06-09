import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.File;
import java.net.URL;


/**
 * @version 1.0
 * @Author ManInM00N  Computer Science class 3 2200303310
 * @Date 2023/5/27 20:49
 * @×¢ÊÍ
 */

public class GameRes {
    public static JLabel pecfectIcon = new JLabel(new ImageIcon("src/image/pure.png"));
    public static JLabel goodIcon = new JLabel(new ImageIcon("src/image/far.png"));
    public static JLabel missIcon = new JLabel(new ImageIcon("src/image/lost.png"));
    public static JLabel total = new JLabel("0");
    public static JLabel score = new JLabel("Score:");
    static JLabel background = new JLabel(new ImageIcon("src/image/playbg.png"));
    public static JPanel state = new JPanel();
    static JLabel S = new JLabel(new ImageIcon("src/image/"+(char)Pages.keyCode1+".png"));
    static JLabel D = new JLabel(new ImageIcon("src/image/"+(char)Pages.keyCode2+".png"));
    static JLabel J = new JLabel(new ImageIcon("src/image/"+(char)Pages.keyCode3+".png"));
    static JLabel K = new JLabel(new ImageIcon("src/image/"+(char)Pages.keyCode4+".png"));
    static JLabel giveup = new JLabel(new ImageIcon("src/image/giveup.png"));
    static JLabel tip = new JLabel(new ImageIcon("src/image/tip.png"));
    public static AudioClip[] Sound = new AudioClip[6];
    public static AudioClip resultbgm;
    public static void load(Note[] notes) {
        S.setIcon(new ImageIcon("src/image/"+(char)Pages.keyCode1+".png"));
        D.setIcon(new ImageIcon("src/image/"+(char)Pages.keyCode2+".png"));
        J.setIcon(new ImageIcon("src/image/"+(char)Pages.keyCode3+".png"));
        K.setIcon(new ImageIcon("src/image/"+(char)Pages.keyCode4+".png"));
        try {
            URL tap = new File("src/sound/tap.wav").toURI().toURL();
            Sound[0] = Applet.newAudioClip(tap);
            Sound[1] = Applet.newAudioClip(tap);
            Sound[2] = Applet.newAudioClip(tap);
            Sound[3] = Applet.newAudioClip(tap);
            Sound[4] = Applet.newAudioClip(tap);
            Sound[5] = Applet.newAudioClip(tap);

            resultbgm = Applet.newAudioClip(new File("src/sound/result_bgm.wav").toURI().toURL());
        } catch (Exception e) {
        }
        for (int i = 0; i < 40; i++) {
            notes[i] = new Note();
            Pages.window.getContentPane().add(notes[i]);
//            Pages.window.getLayeredPane().setComponentZOrder(notes[i],1);
        }

        pecfectIcon.setVisible(false);
        goodIcon.setVisible(false);
        missIcon.setVisible(false);
        tip.setVisible(false);
        state.add(pecfectIcon);
        state.add(goodIcon);
        state.add(missIcon);
        state.setLayout(null);
        giveup.setBounds(1050,0,111,111);
        pecfectIcon.setBounds(150, 300, 114, 108);
        goodIcon.setBounds(150, 300, 114, 108);
        missIcon.setBounds(150, 300, 114, 108);
        total.setBounds(1080,350,300,108);
        score.setBounds(900,350,180,108);
        tip.setBounds(10,500,400,50);
        S.setBounds(409,694,111,111);
        D.setBounds(530,694,111,111);
        J.setBounds(651,694,111,111);
        K.setBounds(772,694,111,111);
        state.add(S);
        state.add(D);
        state.add(J);
        state.add(K);
        state.add(giveup);
        state.add(tip);
        state.add(total);
        state.add(score);
        total.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD,52));
        total.setForeground(Color.ORANGE);
        score.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD,52));
        score.setForeground(Color.WHITE);
        Figure.addFigure();
        state.add(background);

        Pages.window.getContentPane().add(state);
//        Pages.window.getContentPane().setComponentZOrder(state,0);
        state.setBounds(0,0,1280,800);
        background.setVisible(false);
        background.setBounds(0, 0, 1280, 800);
        background.setVisible(true);
        state.setVisible(true);
        state.setOpaque(false);
        S.setVisible(true);
        D.setVisible(true);
        J.setVisible(true);
        K.setVisible(true);
        if (Pages.auto==true) {
            tip.setVisible(true);
        }
    }
}
