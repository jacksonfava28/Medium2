import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class HeroFight implements ActionListener {

    private JFrame frame;
    private JTextField heroAField;
    private JTextField heroBField;
    private JButton fightButton;
    private JTextArea resultsArea;
    private JLabel imageA;
    private JLabel imageB;

    private JSONArray heroes;

    public static void main(String[] args) {
        new HeroFight();
    }

    public HeroFight() {
        loadData();
        prepareGUI();
    }

    // Load all hero data once
    private void loadData() {
        try {
            URL url = new URL("https://akabab.github.io/superhero-api/api/all.json");
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String jsonText = "", line;
            while ((line = reader.readLine()) != null) jsonText += line;
            reader.close();

            JSONParser parser = new JSONParser();
            heroes = (JSONArray) parser.parse(jsonText);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to load hero data.");
        }
    }

    // Find hero by name
    private JSONObject findHero(String name) {
        for (Object o : heroes) {
            JSONObject hero = (JSONObject) o;
            if (((String) hero.get("name")).equalsIgnoreCase(name)) {
                return hero;
            }
        }
        return null;
    }

    // Simple score (just adds stats)
    private int getScore(JSONObject stats) {
        int total = 0;
        total += ((Number) stats.get("intelligence")).intValue();
        total += ((Number) stats.get("strength")).intValue();
        total += ((Number) stats.get("speed")).intValue();
        total += ((Number) stats.get("durability")).intValue();
        total += ((Number) stats.get("combat")).intValue();
        return total;
    }

    // Set hero image
    private void setImage(JLabel label, JSONObject hero) {
        try {
            String url = (String)((JSONObject)hero.get("images")).get("md");
            ImageIcon icon = new ImageIcon(new URL(url));
            Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            label.setIcon(null);
        }
    }

    private void fight(String heroAName, String heroBName) {
        JSONObject heroA = findHero(heroAName);
        JSONObject heroB = findHero(heroBName);

        if (heroA == null || heroB == null) {
            resultsArea.setText("Hero not found.");
            return;
        }

        JSONObject statsA = (JSONObject) heroA.get("powerstats");
        JSONObject statsB = (JSONObject) heroB.get("powerstats");

        int scoreA = getScore(statsA);
        int scoreB = getScore(statsB);

        // Set images
        setImage(imageA, heroA);
        setImage(imageB, heroB);

        resultsArea.setText("");
        resultsArea.append("Hero A: " + heroA.get("name") + "\n");
        resultsArea.append("Score: " + scoreA + "\n\n");

        resultsArea.append("Hero B: " + heroB.get("name") + "\n");
        resultsArea.append("Score: " + scoreB + "\n\n");

        if (scoreA > scoreB)
            resultsArea.append("Winner: " + heroA.get("name") + "\n");
        else if (scoreB > scoreA)
            resultsArea.append("Winner: " + heroB.get("name") + "\n");
        else
            resultsArea.append("Result: Tie\n");

        // AI explanation (placeholder)
        resultsArea.append("\nAI Analysis:\n");
        resultsArea.append(aiExplain(heroA, heroB, scoreA, scoreB));
    }

    // Simple AI explanation
    private String aiExplain(JSONObject heroA, JSONObject heroB, int scoreA, int scoreB) {
        if (scoreA > scoreB)
            return heroA.get("name") + " wins due to higher overall combat stats.\n";
        else if (scoreB > scoreA)
            return heroB.get("name") + " wins due to superior abilities.\n";
        else
            return "Both fighters are evenly matched.\n";
    }

    private void prepareGUI() {
        frame = new JFrame("Hero Fight");
        frame.setSize(500, 650);
        frame.setLayout(new GridLayout(6, 1));

        heroAField = new JTextField("Enter Hero A");
        heroBField = new JTextField("Enter Hero B");

        fightButton = new JButton("Fight!");
        fightButton.addActionListener(this);

        imageA = new JLabel("", SwingConstants.CENTER);
        imageB = new JLabel("", SwingConstants.CENTER);

        resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultsArea);

        frame.add(heroAField);
        frame.add(heroBField);
        frame.add(fightButton);
        frame.add(imageA);
        frame.add(imageB);
        frame.add(scroll);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String heroA = heroAField.getText().trim();
        String heroB = heroBField.getText().trim();
        if (!heroA.isEmpty() && !heroB.isEmpty())
            fight(heroA, heroB);
    }
}
