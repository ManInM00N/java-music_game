
import javazoom.jl.player.Player;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Timer;
import java.util.TimerTask;
/**
 * @version 1.0
 * @Author ManInM00N  Computer Science class 3 2200303310
 * @Date 2023/6/2 11:31
 * @注释
 */

class SE_Miss  extends Thread  {
    public JLabel tx = new JLabel();
    ImageIcon[] img = new ImageIcon[16];
    SE_Miss(int x,int y){
        for(int i = 0; i < 9; i++){
            img[i] = new ImageIcon("src/note/note_Miss_"+(i+1)+".png");
        }
        tx.setBounds(x,y,105,12);
        Pages.window.getLayeredPane().add(tx);
        Pages.window.getLayeredPane().setComponentZOrder(tx,0);
        tx.setVisible(true);
    }
    @Override
    public void run() {
        for(int i = 0; i < 9; i++){
            tx.setIcon(img[i]);
            try {
                this.sleep(20);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
        tx.setVisible(false);
        Pages.window.getLayeredPane().remove(this.tx);
    }

}
class SE_Good  extends Thread  {
    public JLabel tx = new JLabel();
    ImageIcon[] img = new ImageIcon[16];
    SE_Good(int x,int y){
        for(int i = 0; i < 16; i++){
            img[i] = new ImageIcon("src/note/note_Good_"+(i+1)+".png");
        }
        tx.setBounds(x-20,y-75,150,150);
        Pages.window.getLayeredPane().add(tx);
        Pages.window.getLayeredPane().setComponentZOrder(tx,0);
        tx.setVisible(true);
    }
    @Override
    public void run() {
        for(int i = 0; i < 16; i++){
            tx.setIcon(img[i]);
            try {
                this.sleep(20);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
        tx.setVisible(false);
        Pages.window.getLayeredPane().remove(this.tx);
    }

}
class SE  extends Thread  {
    public JLabel tx = new JLabel();
    ImageIcon[] img = new ImageIcon[16];
    SE(int x,int y){
        for(int i = 0; i < 16; i++){
            img[i] = new ImageIcon("src/note/note_"+(i+1)+".png");
        }
        tx.setBounds(x-20,y-75,150,150);
        Pages.window.getLayeredPane().add(tx);
        Pages.window.getLayeredPane().setComponentZOrder(tx,0);
        tx.setVisible(true);
    }
    @Override
    public void run() {
        for(int i = 0; i < 16; i++){
            tx.setIcon(img[i]);
            try {
                this.sleep(20);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
        tx.setVisible(false);
        Pages.window.getLayeredPane().remove(this.tx);
    }

}
public class InGame {
    int x1 = 409;
    int x2 = 530;
    int x3 = 651;
    int x4 = 772;
    int missUp = 594;
    int goodUp = 614;
    int perfectUp = 644;
    int perfectDown = 724;
    int goodDown = 744;
    Note[] notes = new Note[40];
    int noteIndex = 0;
    String noteRecord;
    int next = 0;
    int speedLimit = 0;
    int speed = 0;
    int combo = 0;
    int maxCombo = 0;
    int perfectAmount = 0;
    int goodAmount = 0;
    int missAmount = 0;
    public static Integer totalscores = 0;
    boolean give = false;
    public static JLabel giveup = new JLabel(new ImageIcon("src/image/giveup.png"));
    Player gamePlayer;
    Timer timer;
    int SoundIndex = 0;
    HitListener hitListener = new HitListener();
    Result result = new Result();
    public void soundplay(){
        GameRes.Sound[SoundIndex].play();
        SoundIndex++;
        SoundIndex %=6;
    }

    public void combochange(boolean ok){
        Figure.comboFigure1[combo % 10].setVisible(false);
        Figure.comboFigure10[combo / 10 % 10].setVisible(false);
        Figure.comboFigure100[combo / 100 % 10].setVisible(false);
        if (ok)
            combo++;
        else combo =0;
        Figure.comboFigure1[combo % 10].setVisible(true);
        Figure.comboFigure10[combo / 10 % 10].setVisible(true);
        Figure.comboFigure100[combo / 100 % 10].setVisible(true);
        GameRes.total.setText(totalscores.toString());
    }
    public void inGameInit(String audioFilePath, String scoreFilePath) {
        noteIndex = 0;
        next = 0;
        speedLimit = 0;
        speed = 0;
        combo = 0;
        maxCombo = 0;
        perfectAmount = 0;
        goodAmount = 0;
        missAmount = 0;
        SoundIndex = 0;
        totalscores = 0;
        GameRes.total.setText(totalscores.toString());
        give = false;
        GameRes.load(notes);
        giveup.setBounds(1050,0,111,111);
        Pages.window.getLayeredPane().add(giveup);
        Pages.window.getLayeredPane().setComponentZOrder(giveup,1);
        Pages.window.addKeyListener(hitListener);
        giveup.setVisible(true);
        try {
            FileReader in = new FileReader(scoreFilePath);
            BufferedReader reader = new BufferedReader(in);
            speedLimit = Integer.valueOf(reader.readLine()).intValue();// note生成间隔，以刷新次数为单位
            if(Pages.highspeed)
                speedLimit *=2;
            noteRecord = reader.readLine();
            reader.close();
            in.close();
            gamePlayer = new Player(new FileInputStream(audioFilePath));

        } catch (Exception e) {

        }
        giveup.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                noteIndex = 0;
                next = 0;
                speedLimit = 0;
                speed = 0;
                combo = 0;
                maxCombo = 0;
                perfectAmount = 0;
                goodAmount = 0;
                missAmount = 0;
                totalscores = 0;
                SoundIndex = 0;
                timer.cancel();
                gamePlayer.close();
                Pages.window.getLayeredPane().removeKeyListener(hitListener);
                Pages.window.getContentPane().removeKeyListener(hitListener);
                give = true;
                Pages.has = false;
                Pages.select.selectInit();
                Pages.ret = true;
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });
    }
    public void start() {
        Pages.window.getContentPane().addKeyListener(hitListener);
        Pages.window.requestFocusInWindow();
        Thread music = new Thread() {
            public void run() {
                try {
                    gamePlayer.play();
                } catch (Exception e) {
                }
            }
        };
        timer = new Timer(true);
        music.start();//开进程放音乐
        if (!Pages.highspeed) {
            timer.scheduleAtFixedRate(new Drop(), 0, 10);//开进程下落音符 每10ms刷新画面
        }else{
            timer.scheduleAtFixedRate(new Drop(), 0, 5);//开进程下落音符 每5ms刷新画面
        }
    }
    class Drop extends TimerTask {
        public void drawnote(int X,int Y) {
            notes[noteIndex].x = X;
            notes[noteIndex].y = Y;
            notes[noteIndex].setLocation(notes[noteIndex].x, notes[noteIndex].y);
            notes[noteIndex].setVisible(true);
            noteIndex++;
            noteIndex %=40;
            next++;
        }
        @Override
        public void run() {
            if (give==true) {
                return;
            }
            if (speed == 0) {
                switch (noteRecord.charAt(next)) {
                case '0': {
                    next++;
                    break;
                }
                case '1': {
                    drawnote(x1,0);
                    break;
                }
                case '2': {
                    drawnote(x2,0);
                    break;
                }
                case '3': {
                    drawnote(x3,0);
                    break;
                }
                case '4': {
                    drawnote(x4,0);
                    break;
                }
                case '5': {
                    timer.cancel();
                    gamePlayer.close();
                    Pages.window.removeKeyListener(hitListener);
                    try {
                        GameRes.resultbgm.play();
                    } catch (Exception e) {
                    }
                    result.resultPage(perfectAmount, goodAmount, missAmount, maxCombo);
                    return;
                }
                case 'A': {
                    drawnote(x1,0);
                    drawnote(x2,0);
                    break;
                }
                case 'B': {
                    drawnote(x2,0);
                    drawnote(x3,0);
                    break;
                }
                case 'C': {
                    drawnote(x3,0);
                    drawnote(x4,0);
                    break;
                }
                case 'D': {
                    drawnote(x1,0);
                    drawnote(x3,0);
                    break;
                }
                case 'E': {
                    drawnote(x2,0);
                    drawnote(x4,0);
                    break;
                }
                case 'F': {
                    drawnote(x1,0);
                    drawnote(x4,0);
                    break;
                }
                }
            }
            speed++;
            speed %= speedLimit;
            for (int i = 0; i < 40; i++) {
                if (notes[i].isVisible()) {
                    notes[i].y += 4;
//                    notes[i].y+=2;
                    notes[i].setLocation(notes[i].x, notes[i].y);
                    if (Pages.auto==true) {
                        if (notes[i].y >= 684) {
                            notes[i].setVisible(false);
                            GameRes.pecfectIcon.setVisible(true);
                            GameRes.goodIcon.setVisible(false);
                            GameRes.missIcon.setVisible(false);
                            totalscores+=100;
                            combochange(true);

                            soundplay();
                            new SE(notes[i].x, notes[i].y).start();//特效播放
                            perfectAmount++;
                            if (combo > maxCombo) {
                                maxCombo = combo;
                            }
                        }
                    }
                    else {
                        if (notes[i].y >= 790) {
                            notes[i].setVisible(false);
                            GameRes.pecfectIcon.setVisible(false);
                            GameRes.goodIcon.setVisible(false);
                            GameRes.missIcon.setVisible(true);
                            Figure.comboFigure1[combo % 10].setVisible(false);
                            Figure.comboFigure10[combo / 10 % 10].setVisible(false);
                            Figure.comboFigure100[combo / 100 % 10].setVisible(false);
                            Figure.comboFigure1[0].setVisible(true);
                            Figure.comboFigure10[0].setVisible(true);
                            Figure.comboFigure100[0].setVisible(true);
                            combo = 0;
                            new SE_Miss(notes[noteIndex].x, notes[noteIndex].y).start();//特效播放
                            missAmount++;
                        }
                    }
                }
            }
        }
    }

    class HitListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
        @Override
        public void keyPressed(KeyEvent e) {
            int noteIndex = -1;
            int noteY = -1;
            int noteX = 0;
            int keyCode = e.getKeyCode();
            System.out.println("1");
            if (keyCode == Pages.keyCode1) {
                noteX = x1;
            } else if (keyCode == Pages.keyCode2) {
                noteX = x2;
            } else if (keyCode == Pages.keyCode3) {
                noteX = x3;
            } else if (keyCode == Pages.keyCode4) {
                noteX = x4;
            }
            for (int i = 0; i < 40; i++) {
                if (notes[i].x == noteX && notes[i].isVisible() && notes[i].y > noteY) {
                    noteY = notes[i].y;
                    noteIndex = i;
                }
            }
            if (noteIndex == -1) {
                return;
            }
            if (Pages.auto==false) {
                if (noteY >= perfectUp && noteY <= perfectDown) {
                    notes[noteIndex].setVisible(false);
                    GameRes.pecfectIcon.setVisible(true);
                    GameRes.goodIcon.setVisible(false);
                    GameRes.missIcon.setVisible(false);
                    totalscores+=100;
                    combochange(true);
                    soundplay();
                    new SE(notes[noteIndex].x, notes[noteIndex].y).start();//特效播放
                    perfectAmount++;
                } else if ((noteY < perfectUp && noteY >= goodUp) || (noteY > perfectDown && noteY <= goodDown)) {
                    notes[noteIndex].setVisible(false);
                    GameRes.pecfectIcon.setVisible(false);
                    GameRes.goodIcon.setVisible(true);
                    GameRes.missIcon.setVisible(false);
                    totalscores+=63;
                    combochange(true);
                    soundplay();
                    new SE_Good(notes[noteIndex].x, notes[noteIndex].y).start();//特效播放
                    goodAmount++;
                } else if ((noteY < goodUp && noteY >= missUp) || (noteY > goodDown)) {
                    notes[noteIndex].setVisible(false);
                    GameRes.pecfectIcon.setVisible(false);
                    GameRes.goodIcon.setVisible(false);
                    GameRes.missIcon.setVisible(true);
                    combochange(false);
                    new SE_Miss(notes[noteIndex].x, notes[noteIndex].y).start();//特效播放
                    missAmount++;
                }
                if (combo > maxCombo) {
                    maxCombo = combo;
                }
            }
        }

    }
}
