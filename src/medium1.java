import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class medium1  implements ActionListener {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll;
    private JTextArea ta; //typing area
    private int WIDTH = 800;
    private int HEIGHT = 700;


    public medium1 () {
        prepareGUI();
    }

    public static void main(String[] args) {
        medium1 buttonPresser = new medium1();
        buttonPresser.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new BorderLayout(2, 3));

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

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
         controlPanel = new JPanel();
           controlPanel.setLayout(new GridLayout(2,3)); //set the layout of the pannel

          mainFrame.add(controlPanel);
             mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showEventDemo() {

        JButton okButton = new JButton("Button 1");
        JButton submitButton = new JButton("Button 2");
        JButton cancelButton = new JButton("Button 3");
        JButton submittButton = new JButton("Button 4");
        JButton cancelttButton = new JButton("Button 5");

        okButton.setActionCommand("OK");
        submitButton.setActionCommand("Submit");
        cancelButton.setActionCommand("Cancel");

        okButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());

        mainFrame.add(okButton,BorderLayout.NORTH);
        controlPanel.add(submitButton,BorderLayout.EAST);
        mainFrame.add(cancelButton,BorderLayout.SOUTH);
        controlPanel.add(submittButton,BorderLayout.WEST);
        controlPanel.add(cancelttButton,BorderLayout.CENTER);

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