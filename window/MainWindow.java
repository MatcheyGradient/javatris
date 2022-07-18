package window;

import javax.swing.*;

public class MainWindow extends JFrame{
    public MainWindow(){
        this.add(new Drawer());
        this.setTitle("javatris");
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}