import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class medium2  implements ActionListener {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JLabel numberLabel;
    private JLabel numbersLabel;
    private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll;
    private JTextArea ta; //typing area
    private int WIDTH = 800;
    private int HEIGHT = 700;


    public medium2 () {
        prepareGUI();
    }

    public static void main(String[] args) {
        medium2 buttonPresser = new medium2();
        buttonPresser.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(3, 3));

        //menu at top
        cut = new JMenuItem("cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        selectAll = new JMenuItem("selectAll");
        cut.addActionListener((ActionListener) this);
        copy.addActionListener((ActionListener) this);
        paste.addActionListener((ActionListener) this);
        selectAll.addActionListener((ActionListener) this);

        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        //end menu at top

        //   ta = new JTextArea();
        //   ta.setBounds(50, 5, WIDTH - 100, HEIGHT - 50);
        mainFrame.add(mb);  //add menu bar
        //  mainFrame.add(ta);//add typing area
        mainFrame.setJMenuBar(mb); //set menu bar

        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        numberLabel= new JLabel("Label 1", JLabel.CENTER);
        numbersLabel= new JLabel("Label 2", JLabel.CENTER);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
controlPanel.setLayout(new BorderLayout(2,3)); //set the layout of the pannel


        mainFrame.setVisible(true);
    }

    private void showEventDemo() {

        JButton ok1Button = new JButton("Button 1");
        JButton submit2Button = new JButton("Button 2");
        JButton cancel3Button = new JButton("Button 3");
        JButton submitt4Button = new JButton("Button 4");
        JButton canceltt5Button = new JButton("Button 5");
        JButton okk6Button = new JButton("Button 6");
        JButton submittt7Button = new JButton("Button 7");
        JButton cancelll8Button = new JButton("Button 8");
        JButton submitttt9Button = new JButton("Button 9");
        JButton cancelttttt10Button = new JButton("Button 10");


        ok1Button.setActionCommand("OK");
        submit2Button.setActionCommand("Submit");
        cancel3Button.setActionCommand("Cancel");





        ok1Button.addActionListener(new ButtonClickListener());
        submit2Button.addActionListener(new ButtonClickListener());
        cancel3Button.addActionListener(new ButtonClickListener());

        mainFrame.add(ok1Button,BorderLayout.NORTH);
        mainFrame.add(submit2Button,BorderLayout.EAST);
        mainFrame.add(cancel3Button,BorderLayout.SOUTH);
        mainFrame.add(submitt4Button,BorderLayout.WEST);
        //controlPanel.add(numberLabel);
        mainFrame.add(controlPanel);
        controlPanel.add(numbersLabel);
        controlPanel.add(submitttt9Button,BorderLayout.EAST);
        controlPanel.add(cancelttttt10Button,BorderLayout.SOUTH);
        mainFrame.add(canceltt5Button,BorderLayout.CENTER);
        mainFrame.add(okk6Button,BorderLayout.NORTH);
        mainFrame.add(submittt7Button,BorderLayout.EAST);
        mainFrame.add(cancelll8Button,BorderLayout.SOUTH);


        controlPanel.add(numberLabel);
        //controlPanel.add(numbersLabel);

        mainFrame.setVisible(true);
    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        // if (e.getSource() == cut)
        //     ta.cut();
        //    if (e.getSource() == paste)
        //        ta.paste();
        //    if (e.getSource() == copy)
        //        ta.copy();
        //   if (e.getSource() == selectAll)
        //       ta.selectAll();
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("OK")) {
                //      statusLabel.setText("Ok Button clicked.");
            } else if (command.equals("Submit")) {
                //      statusLabel.setText("Submit Button clicked.");
            } else {
                //     statusLabel.setText("Cancel Button clicked.");
            }
        }
    }
}