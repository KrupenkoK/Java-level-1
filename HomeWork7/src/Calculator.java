import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private static final int WIN_HEIGHT = 400;
    private static final int WIN_WIDTH = 400;
    private static final int WIN_POS_X = 800;
    private static final int WIN_POS_Y = 300;

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton plusbtn = new JButton("+");
        JButton minusbtn = new JButton("-");
        JButton multiplybtn = new JButton("*");
        JButton divisionbtn = new JButton("/");
        JButton equalitbtn = new JButton("=");


        JButton onebtn = new JButton("1");
        JButton twobtn = new JButton("2");
        JButton threebtn = new JButton("3");
        JButton fourbtn = new JButton("4");
        JButton fivebtn = new JButton("5");
        JButton sixbtn = new JButton("6");
        JButton sevenbtn = new JButton("7");
        JButton eightbtn = new JButton("8");
        JButton ninebtn = new JButton("9");
        JButton zerobtn = new JButton("0");


        JPanel jpanel = new JPanel(new GridLayout(5,3));


        jpanel.add(onebtn);
        jpanel.add(twobtn);
        jpanel.add(plusbtn);
        jpanel.add(threebtn);
        jpanel.add(fourbtn);
        jpanel.add(minusbtn);
        jpanel.add(fivebtn);
        jpanel.add(sixbtn);
        jpanel.add(multiplybtn);
        jpanel.add(sevenbtn);
        jpanel.add(eightbtn);
        jpanel.add(divisionbtn);
        jpanel.add(ninebtn);
        jpanel.add(zerobtn);
        jpanel.add(equalitbtn);


        add(jpanel, BorderLayout.CENTER);

        onebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("1");
            }
        });

        twobtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("2");
            }
        });

        plusbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("+");
            }
        });

        threebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("3");
            }
        });

        fourbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("4");
            }
        });

        minusbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("-");
            }
        });

        fivebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("5");
            }
        });

        sixbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("6");
            }
        });

        multiplybtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("*");
            }
        });

        sevenbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("7");
            }
        });

        eightbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("8");
            }
        });

        divisionbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("/");
            }
        });

        ninebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("9");
            }
        });

        zerobtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("0");
            }
        });

        equalitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("=");
            }
        });

        setBounds(WIN_POS_X,WIN_POS_Y,WIN_WIDTH,WIN_HEIGHT);
        setVisible(true);

    }



}
