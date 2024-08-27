import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
    Calendar calendar;
    SimpleDateFormat timeFormat;
    JLabel timeLabel;
    JPanel pnl;
    String time;
    Font font;

    MyFrame() {
        System.out.println("Saat İşliyor..");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clock Program");
        this.setSize(350, 120);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        pnl = new JPanel();
        pnl.setBackground(Color.BLACK);
        pnl.setLayout(new FlowLayout());// Panele flowlayout ekledik

        timeFormat = new SimpleDateFormat("HH:mm:ss a");// saat formatını 24 lük a.m/p.m ayarladık
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 44));
        timeLabel.setForeground(Color.GREEN);

        pnl.add(timeLabel);// labeli panele paneli de frame'e ekledik
        this.add(pnl);
        this.setVisible(true);

        setTime();
    }

    public void setTime() {
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());// zamanı çektik ve stringe atadık
            timeLabel.setText(time);
            System.out.println(time);// Konsol çıktısı
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}