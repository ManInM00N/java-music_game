import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @version 1.0
 * @Author ManInM00N  Computer Science class 3 2200303310
 * @Date 2023/6/5 14:09
 * @注释
 */
public class Settings {
    JLabel settingbg = new JLabel();
    JLabel Code1 = new JLabel();
    JLabel Code2 = new JLabel();
    JLabel Code3 = new JLabel();
    JLabel Code4 = new JLabel();
    JLabel selec1 = new JLabel();
    JLabel selec2 = new JLabel();
    JLabel selec3 = new JLabel();
    JLabel selec4 = new JLabel();
    JPanel state = new JPanel();
    JLabel tip2 = new JLabel("点击下列按钮图标来修改键盘映射");
    JLabel tip = new JLabel("请按下一个按键来设定该位置键盘映射");
    JLabel tip3 = new JLabel("目前暂不支持一个按键同时映射两列音轨");
    JLabel retur = new JLabel("返回");
    changelistener cha = new changelistener();
    public void Init(){
        settingbg.setIcon(new ImageIcon("src/image/playbg.png"));
        Code1.setIcon(new ImageIcon("src/image/"+(char)Pages.keyCode1+".png"));
        Code2.setIcon(new ImageIcon("src/image/"+(char)Pages.keyCode2+".png"));
        Code3.setIcon(new ImageIcon("src/image/"+(char)Pages.keyCode3+".png"));
        Code4.setIcon(new ImageIcon("src/image/"+(char)Pages.keyCode4+".png"));
        selec1.setIcon(new ImageIcon("src/image/selc1.png"));
        selec2.setIcon(new ImageIcon("src/image/selc2.png"));
        selec3.setIcon(new ImageIcon("src/image/selc3.png"));
        selec4.setIcon(new ImageIcon("src/image/selc4.png"));
        settingbg.setBounds(0,0,1280,800);
        state.setLayout(null);
        state.setBounds(0,0,1280,800);
        state.setOpaque(false);
        state.add(Code1);
        state.add(Code2);
        state.add(Code3);
        state.add(Code4);
        state.add(selec1);
        state.add(selec2);
        state.add(selec3);
        state.add(selec4);
        state.add(tip);
        state.add(tip2);
        state.add(retur);
        state.add(tip3);
        Code1.setBounds(409,694,111,111);
        Code2.setBounds(530,694,111,111);
        Code3.setBounds(651,694,111,111);
        Code4.setBounds(772,694,111,111);
        selec1.setBounds(409,500,111,111);
        selec2.setBounds(530,500,111,111);
        selec3.setBounds(651,500,111,111);
        selec4.setBounds(772,500,111,111);
        retur.setBounds(50,650,150,100);
        tip.setBounds(350,150,700,140);
        tip2.setBounds(350,150,700,140);
        tip3.setBounds(350,250,700,140);
        Font Font1 = new Font("微软雅黑" ,Font.BOLD,36);
        retur.setFont(new Font("黑体", Font.BOLD,60));
        retur.setForeground(Color.WHITE);
//        Font1.
        tip.setFont(Font1);
        tip2.setFont(Font1);
        tip3.setFont(Font1);
        tip.setForeground(Color.CYAN);
        tip3.setForeground(Color.CYAN);
        tip2.setForeground(Color.CYAN);
        Code1.setName("1");
        Code2.setName("2");
        Code3.setName("3");
        Code4.setName("4");
        Code1.addMouseListener(new click(Code1.getName()));
        Code2.addMouseListener(new click(Code2.getName()));
        Code3.addMouseListener(new click(Code3.getName()));
        Code4.addMouseListener(new click(Code4.getName()));
        retur.addMouseListener(new retu());
        tip.setVisible(false);
        tip2.setVisible(true);
        tip3.setVisible(false);
        Code1.setVisible(true);
        Code2.setVisible(true);
        Code3.setVisible(true);
        Code4.setVisible(true);
        selec1.setVisible(false);
        selec2.setVisible(false);
        selec3.setVisible(false);
        selec4.setVisible(false);
        state.setVisible(true);
        Pages.window.getContentPane().add(state);
        Pages.window.getContentPane().add(settingbg);
    }
    class changelistener implements KeyListener {
        String nn;
        changelistener(){

        }
        changelistener(String mame){
            this.nn = mame;
        }
        @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyPressed(KeyEvent e) {
            int keynum = e.getKeyCode();
            if(keynum<'A'||keynum>'Z') keynum= 65;
            if (nn.equals("1")){
                Pages.keyCode1=keynum;
                Code1.setIcon(new ImageIcon("src/image/"+(char)Pages.keyCode1+".png"));
                selec1.setVisible(false);
            }else if (nn.equals("2")){
                Pages.keyCode2=keynum;
                Code2.setIcon(new ImageIcon("src/image/"+(char)Pages.keyCode2+".png"));
                selec2.setVisible(false);
            }else if (nn.equals("3")){
                Pages.keyCode3=keynum;
                selec3.setVisible(false);
                Code3.setIcon(new ImageIcon("src/image/"+(char)Pages.keyCode3+".png"));
            }else {
                Pages.keyCode4=keynum;
                selec4.setVisible(false);
                Code4.setIcon(new ImageIcon("src/image/"+(char)Pages.keyCode4+".png"));
            }
            Code1.setEnabled(true);
            Code2.setEnabled(true);
            Code3.setEnabled(true);
            Code4.setEnabled(true);
            tip2.setVisible(true);
            tip.setVisible(false);
            tip3.setVisible(false);
            retur.setEnabled(false);
            Pages.window.removeKeyListener(cha);
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
    class click implements MouseListener{
        String nn;
        click(String name){
            nn = name;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            cha.nn = this.nn;
            tip.setVisible(true);
            tip2.setVisible(false);
            tip3.setVisible(true);
            if (nn.equals("1")){
                selec1.setVisible(true);
            }else if (nn.equals("2")){
                selec2.setVisible(true);
            }else if (nn.equals("3")){
                selec3.setVisible(true);
            }else {
                selec4.setVisible(true);
            }
            Code1.setEnabled(false);
            Code2.setEnabled(false);
            Code3.setEnabled(false);
            Code4.setEnabled(false);
            retur.setEnabled(false);
            Pages.window.addKeyListener(cha);
            Pages.window.requestFocusInWindow();
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
    class retu implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if (Pages.keyCode1==Pages.keyCode2||Pages.keyCode1==Pages.keyCode3||Pages.keyCode1==Pages.keyCode4||Pages.keyCode2==Pages.keyCode3||Pages.keyCode2==Pages.keyCode4||Pages.keyCode3==Pages.keyCode4){
                JDialog tixin = new JDialog(Pages.window,"提示",true);
                tixin.setBounds(400,300,490,100);
                JLabel tixinLabel = new JLabel("键盘映射不合理,存在一个按键对应多个音轨");
                tixinLabel.setFont(new Font("微软雅黑", Font.BOLD,24));
                tixin.getContentPane().add(tixinLabel,BorderLayout.CENTER);
                tixinLabel.setVisible(true);
                tixin.setVisible(true);
            }else
            Pages.select.selectInit();
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

