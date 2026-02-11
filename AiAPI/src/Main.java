import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main implements ActionListener {

    private JFrame frame;
    private JComboBox<String> heroABox;
    private JComboBox<String> heroBBox;
    private JButton fightButton;
    private JButton randomButton;
    private JButton clearButton;
    private JTextArea resultsArea;
    private JLabel imageA;
    private JLabel imageB;
    private JLabel nameALabel;
    private JLabel nameBLabel;
    private JLabel statsALabel;
    private JLabel statsBLabel;

    private JSONArray heroes;
    private List<JSONObject> customHeroes = new ArrayList<>();

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        loadData();
        loadCustomHeroes();
        prepareGUI();
    }

    // ------------------------ API HEROES ------------------------
    private void loadData() {
        try {
            URL url = new URL("https://akabab.github.io/superhero-api/api/all.json");
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String jsonText = "", line;
            while ((line = reader.readLine()) != null) jsonText += line;
            reader.close();

            JSONParser parser = new JSONParser();
            heroes = (JSONArray) parser.parse(jsonText);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to load hero data from API.");
        }
    }

    // ------------------------ CUSTOM HEROES ------------------------
    private void loadCustomHeroes() {
        // Percy Jackson
        JSONObject percy = new JSONObject();
        percy.put("name", "Percy Jackson");
        JSONObject percyStats = new JSONObject();
        percyStats.put("intelligence", 55);
        percyStats.put("strength", 85);
        percyStats.put("speed", 85);
        percyStats.put("durability", 80);
        percyStats.put("power", 95);
        percyStats.put("combat", 90);
        percy.put("powerstats", percyStats);
        JSONObject percyImages = new JSONObject();
        percyImages.put("md", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS64TBbDYwy7F2HSiZbn-m0ibdebDKsv-_TAg&s");
        percy.put("images", percyImages);
        customHeroes.add(percy);

        // Invincible
        JSONObject invincible = new JSONObject();
        invincible.put("name", "Invincible");
        JSONObject invStats = new JSONObject();
        invStats.put("intelligence", 70);
        invStats.put("strength", 95);
        invStats.put("speed", 100);
        invStats.put("durability", 100);
        invStats.put("power", 90);
        invStats.put("combat", 92);
        invincible.put("powerstats", invStats);
        JSONObject invImages = new JSONObject();
        invImages.put("md", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbpPgYcie9hBm7_DFP5jOFUpFQE3GjyHp5BQ&s");
        invincible.put("images", invImages);
        customHeroes.add(invincible);

        // Omni-man
        JSONObject omniman = new JSONObject();
        omniman.put("name", "Omni-man");
        JSONObject omniStats = new JSONObject();
        omniStats.put("intelligence", 75);
        omniStats.put("strength", 97);
        omniStats.put("speed", 100);
        omniStats.put("durability", 93);
        omniStats.put("power", 90);
        omniStats.put("combat", 87);
        omniman.put("powerstats", omniStats);
        JSONObject omniImages = new JSONObject();
        omniImages.put("md", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKdBSqIFCPzCOj8DCcMnFtqWXgf-nige_mrw&s");
        omniman.put("images", omniImages);
        customHeroes.add(omniman);

        // Conquest
        JSONObject conquest = new JSONObject();
        conquest.put("name", "Conquest");
        JSONObject conqStats = new JSONObject();
        conqStats.put("intelligence", 65);
        conqStats.put("strength", 100);
        conqStats.put("speed", 100);
        conqStats.put("durability", 95);
        conqStats.put("power", 92);
        conqStats.put("combat", 94);
        conquest.put("powerstats", conqStats);
        JSONObject conqImages = new JSONObject();
        conqImages.put("md", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpmRG7t9vS6WZvbQjYkmzRgmEHmT3o_3fYAA&s");
        conquest.put("images", conqImages);
        customHeroes.add(conquest);

        // Thragg
        JSONObject thragg = new JSONObject();
        thragg.put("name", "Thragg");
        JSONObject thraggStats = new JSONObject();
        thraggStats.put("intelligence", 75);
        thraggStats.put("strength", 100);
        thraggStats.put("speed", 100);
        thraggStats.put("durability", 100);
        thraggStats.put("power", 94);
        thraggStats.put("combat", 97);
        thragg.put("powerstats", thraggStats);
        JSONObject thraggImages = new JSONObject();
        thraggImages.put("md", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQsKd0gqYkJPOVmVdCBcyIn0IB5YBJ7L5cI_A&s");
        thragg.put("images", thraggImages);
        customHeroes.add(thragg);

        // Atom Eve
        JSONObject eve = new JSONObject();
        eve.put("name", "Atom Eve");
        JSONObject eveStats = new JSONObject();
        eveStats.put("intelligence", 80);
        eveStats.put("strength", 72);
        eveStats.put("speed", 81);
        eveStats.put("durability", 75);
        eveStats.put("power", 100);
        eveStats.put("combat", 71);
        eve.put("powerstats", eveStats);
        JSONObject eveImages = new JSONObject();
        eveImages.put("md", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFMKugWvnaUzX86LQW1DV8j6D0qsTkxZdaxQ&s");
        eve.put("images", eveImages);
        customHeroes.add(eve);

        // Loic (easter egg)
        JSONObject loic = new JSONObject();
        loic.put("name", "Loic");
        JSONObject loicStats = new JSONObject();
        loicStats.put("intelligence", 0);
        loicStats.put("strength", 0);
        loicStats.put("speed", 0);
        loicStats.put("durability", 0);
        loicStats.put("power", 0);
        loicStats.put("combat", 0);
        loic.put("powerstats", loicStats);
        JSONObject loicImages = new JSONObject();
        loicImages.put("md", "failed to render, forehead too big");
        loic.put("images", loicImages);
        customHeroes.add(loic);

        // Jaxon Smith-Njigba
        JSONObject jsn = new JSONObject();
        jsn.put("name", "Jaxon Smith-Njigba");
        JSONObject jsnStats = new JSONObject();
        jsnStats.put("intelligence", 100000);
        jsnStats.put("strength", 100000);
        jsnStats.put("speed", 100000);
        jsnStats.put("durability", 100000);
        jsnStats.put("power", 100000);
        jsnStats.put("combat", 100000);
        jsn.put("powerstats", jsnStats);
        JSONObject jsnImages = new JSONObject();
        jsnImages.put("md", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR56T_oPisgcsbFEKYsh8uW-GrQ_WSiwUihbg&s");
        jsn.put("images", jsnImages);
        customHeroes.add(jsn);

        // Batman who Laughs
        JSONObject bwl = new JSONObject();
        bwl.put("name", "Batman who Laughs");
        JSONObject bwlStats = new JSONObject();
        bwlStats.put("intelligence", 100);
        bwlStats.put("strength", 100);
        bwlStats.put("speed", 100);
        bwlStats.put("durability", 100);
        bwlStats.put("power", 100);
        bwlStats.put("combat", 100);
        bwl.put("powerstats", bwlStats);
        JSONObject bwlImages = new JSONObject();
        bwlImages.put("md", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJxDpflboFYbgVuaUXHk1y1GKBTjwRkcGn0g&s");
        bwl.put("images", bwlImages);
        customHeroes.add(bwl);
    }
    // ------------------------------------------------

    private JSONObject findHero(String input) {
        if (input == null || input.isEmpty()) return null;
        String search = input.trim().toLowerCase();
        for (JSONObject hero : customHeroes) {
            if (((String) hero.get("name")).toLowerCase().equals(search)) return hero;
        }
        for (Object o : heroes) {
            JSONObject hero = (JSONObject) o;
            String name = ((String) hero.get("name")).toLowerCase();
            JSONObject bio = (JSONObject) hero.get("biography");
            String fullName = bio != null && bio.get("fullName") != null ? ((String) bio.get("fullName")).toLowerCase() : "";
            if (name.equals(search) || fullName.equals(search)) return hero;
        }
        return null;
    }

    private int getScore(JSONObject stats) {
        int intelligence = ((Number) stats.get("intelligence")).intValue();
        int strength     = ((Number) stats.get("strength")).intValue();
        int speed        = ((Number) stats.get("speed")).intValue();
        int durability   = ((Number) stats.get("durability")).intValue();
        int power        = ((Number) stats.get("power")).intValue();
        int combat       = ((Number) stats.get("combat")).intValue();
        int total = intelligence + strength + speed + durability + power + combat;
        return total;
    }

    private List<String> getCategories(JSONObject hero) {
        List<String> categories = new ArrayList<>();
        JSONObject stats = (JSONObject) hero.get("powerstats");
        int intelligence = ((Number) stats.get("intelligence")).intValue();
        int strength     = ((Number) stats.get("strength")).intValue();
        int speed        = ((Number) stats.get("speed")).intValue();
        int durability   = ((Number) stats.get("durability")).intValue();
        int power        = ((Number) stats.get("power")).intValue();

        if (intelligence >= 85) categories.add("Mind");
        if (strength >= 85) categories.add("Physical");
        if (speed >= 85) categories.add("Speedster");
        if (durability >= 85) categories.add("Tank");
        if (power >= 85) categories.add("Energy");
        if (categories.isEmpty()) categories.add("Balanced");
        return categories;
    }

    private int[] applyCategoryRules(List<String> catsA, List<String> catsB, int scoreA, int scoreB) {
        for (String catA : catsA) {
            for (String catB : catsB) {
                if (catA.equals("Mind") && catB.equals("Energy")) scoreB -= 30;
                if (catB.equals("Mind") && catA.equals("Energy")) scoreA -= 30;

                if (catA.equals("Physical") && catB.equals("Energy")) scoreA += 20;
                if (catB.equals("Physical") && catA.equals("Energy")) scoreB += 20;

                if (catA.equals("Speedster") && catB.equals("Physical")) scoreA += 15;
                if (catB.equals("Speedster") && catA.equals("Physical")) scoreB += 15;

                if (catA.equals("Energy") && catB.equals("Tank")) scoreA += 20;
            }
        }
        return new int[]{scoreA, scoreB};
    }

    private void setImage(JLabel label, JLabel nameLabel, JSONObject hero) {
        try {
            String url = (String)((JSONObject)hero.get("images")).get("md");
            ImageIcon icon = new ImageIcon(new URL(url));
            Image img = icon.getImage().getScaledInstance(225, 250, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(img));
            nameLabel.setText((String) hero.get("name"));
            nameLabel.setHorizontalAlignment(JLabel.CENTER);
            nameLabel.setForeground(new Color(0, 200, 255));// Hero name bright for dark mode
        } catch (Exception e) {
            label.setIcon(null);
            nameLabel.setText((String) hero.get("name"));
            nameLabel.setForeground(new Color(0, 200, 255)); // fallback color
        }
    }

    private void fight(String heroAName, String heroBName) {
        JSONObject heroA = findHero(heroAName);
        JSONObject heroB = findHero(heroBName);

        if (heroA == null || heroB == null) {
            resultsArea.setText("Error: Hero not found.\nPlease select both heroes from the dropdown.");
            return;
        }

        if (heroAName.equals(heroBName)) {
            resultsArea.setText("Error: Both heroes are the same.\nPlease pick different heroes.");
            return;
        }

        JSONObject statsA = (JSONObject) heroA.get("powerstats");
        JSONObject statsB = (JSONObject) heroB.get("powerstats");

        int scoreA = getScore(statsA);
        int scoreB = getScore(statsB);

        String nameA = ((String) heroA.get("name")).toLowerCase();
        String nameB = ((String) heroB.get("name")).toLowerCase();

        // Agent Bob easter egg
        if (nameA.equals("agent bob") && !nameB.equals("agent bob")) scoreA = 100000;
        if (nameB.equals("agent bob") && !nameA.equals("agent bob")) scoreB = 100000;

        List<String> catsA = getCategories(heroA);
        List<String> catsB = getCategories(heroB);

        int[] bonusScores = {0,0};
        if (scoreA < 100000 && scoreB < 100000) {
            int[] newScores = applyCategoryRules(catsA, catsB, scoreA, scoreB);
            bonusScores[0] = newScores[0] - scoreA;
            bonusScores[1] = newScores[1] - scoreB;
            scoreA = newScores[0];
            scoreB = newScores[1];
        }

        setImage(imageA, nameALabel, heroA);
        setImage(imageB, nameBLabel, heroB);

        statsALabel.setText(getStatTextWithBonus(heroA, bonusScores[0]));
        statsBLabel.setText(getStatTextWithBonus(heroB, bonusScores[1]));

        resultsArea.setText("");
        if (scoreA > scoreB)
            resultsArea.append("Winner: " + heroA.get("name") + "\n");
        else if (scoreB > scoreA)
            resultsArea.append("Winner: " + heroB.get("name") + "\n");
        else
            resultsArea.append("Result: Tie\n");

        resultsArea.append("\nBattle Analysis:\n");
        resultsArea.append(aiExplain(heroA, heroB, scoreA, scoreB, catsA, catsB));
    }

    private String getStatTextWithBonus(JSONObject hero, int bonus) {
        JSONObject stats = (JSONObject) hero.get("powerstats");
        int baseScore = getScore(stats);
        int totalScore = baseScore + bonus;
        return "<html>INT: " + stats.get("intelligence") +
                "<br>STR: " + stats.get("strength") +
                "<br>SPD: " + stats.get("speed") +
                "<br>DUR: " + stats.get("durability") +
                "<br>POW: " + stats.get("power") +
                "<br>COM: " + stats.get("combat") +
                (bonus != 0 ? "<br>Bonus: +" + bonus : "") +
                "<br>Total Score: " + totalScore + "</html>";
    }

    private String aiExplain(JSONObject heroA, JSONObject heroB, int scoreA, int scoreB,
                             List<String> catsA, List<String> catsB) {
        String nameA = ((String) heroA.get("name"));
        String nameB = ((String) heroB.get("name"));

        if (nameA.equalsIgnoreCase("agent bob"))
            return "Agent Bob reveals his hidden omnipotence and effortlessly wins.\n";
        if (nameB.equalsIgnoreCase("agent bob"))
            return "Agent Bob was holding back this whole time. Total domination.\n";
        if (nameA.equalsIgnoreCase("Jaxon Smith-Njigba"))
            return "JSN's aura is overpowering and comes out with the victory.\n";
        if (nameB.equalsIgnoreCase("Jaxon Smith-Njigba"))
            return "JSN's aura is overpowering and comes out with the victory.\n";

        StringBuilder explanation = new StringBuilder();
        for (String catA : catsA) {
            for (String catB : catsB) {
                if (catA.equals("Mind") && catB.equals("Energy"))
                    explanation.append(nameA + " uses intellect to outsmart " + nameB + ".\n");
                if (catB.equals("Mind") && catA.equals("Energy"))
                    explanation.append(nameB + " uses intellect to outsmart " + nameA + ".\n");
                if (catA.equals("Physical") && catB.equals("Energy"))
                    explanation.append(nameA + "'s strength counters " + nameB + "'s energy.\n");
                if (catB.equals("Physical") && catA.equals("Energy"))
                    explanation.append(nameB + "'s strength counters " + nameA + "'s energy.\n");
                if (catA.equals("Speedster") && catB.equals("Physical"))
                    explanation.append(nameA + "'s speed evades " + nameB + "'s attacks.\n");
                if (catB.equals("Speedster") && catA.equals("Physical"))
                    explanation.append(nameB + "'s speed evades " + nameA + "'s attacks.\n");
                if (catA.equals("Energy") && catB.equals("Tank"))
                    explanation.append(nameA + "'s energy overpowers " + nameB + "'s durability.\n");
                if (catB.equals("Energy") && catA.equals("Tank"))
                    explanation.append(nameB + "'s energy overpowers " + nameA + "'s durability.\n");
            }
        }
        if (explanation.length() == 0) {
            if (scoreA > scoreB) explanation.append(nameA + " wins due to higher combat stats.\n");
            else if (scoreB > scoreA) explanation.append(nameB + " wins due to higher combat stats.\n");
            else explanation.append("Both fighters are evenly matched.\n");
        }
        return explanation.toString();
    }

    private Vector<String> getAllHeroNames() {
        Vector<String> names = new Vector<>();
        for (JSONObject hero : customHeroes) names.add((String) hero.get("name"));
        for (Object o : heroes) {
            JSONObject hero = (JSONObject) o;
            names.add((String) hero.get("name"));
        }
        return names;
    }

    private void prepareGUI() {
        frame = new JFrame("Hero Fight");
        frame.setSize(900, 750);
        frame.setLayout(new BorderLayout());

        Color bgColor = new Color(30, 30, 30);      // Dark mode background
        Color panelColor = new Color(70, 70, 70);   // Darker panel for buttons
        Color textColor = Color.WHITE;              // Default text color

        frame.getContentPane().setBackground(bgColor);

        // Top Panel: selectors + labels
        JPanel topPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        topPanel.setBackground(bgColor);
        JLabel labelA = new JLabel("Hero A:");
        JLabel labelB = new JLabel("Hero B:");
        labelA.setForeground(textColor);
        labelB.setForeground(textColor);
        topPanel.add(labelA);
        topPanel.add(labelB);
        heroABox = new JComboBox<>(getAllHeroNames());
        heroABox.setEditable(true);
        heroBBox = new JComboBox<>(getAllHeroNames());
        heroBBox.setEditable(true);
        topPanel.add(heroABox);
        topPanel.add(heroBBox);

        // Center Panel: images + names + stats
        JPanel centerPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        centerPanel.setBackground(bgColor);
        imageA = new JLabel();
        imageB = new JLabel();
        nameALabel = new JLabel();
        nameALabel.setForeground(new Color(0, 200, 255)); // hero name color
        nameBLabel = new JLabel();
        nameBLabel.setForeground(new Color(0, 200, 255));
        statsALabel = new JLabel();
        statsALabel.setForeground(textColor);
        statsBLabel = new JLabel();
        statsBLabel.setForeground(textColor);
        centerPanel.add(imageA);
        centerPanel.add(statsALabel);
        centerPanel.add(statsBLabel);
        centerPanel.add(imageB);
        centerPanel.add(nameALabel);
        centerPanel.add(new JLabel()); // empty spacer
        centerPanel.add(new JLabel()); // empty spacer
        centerPanel.add(nameBLabel);

        // Bottom panel: buttons + results
        JPanel bottomPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        bottomPanel.setBackground(bgColor);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(bgColor);
        fightButton = new JButton("Fight!");
        fightButton.setBackground(panelColor);
        fightButton.setForeground(Color.BLACK);
        fightButton.addActionListener(this);
        randomButton = new JButton("Random Fight");
        randomButton.setBackground(panelColor);
        randomButton.setForeground(Color.BLACK);
        randomButton.addActionListener(e -> {
            Random r = new Random();
            heroABox.setSelectedIndex(r.nextInt(heroABox.getItemCount()));
            heroBBox.setSelectedIndex(r.nextInt(heroBBox.getItemCount()));
            fight((String)heroABox.getSelectedItem(), (String)heroBBox.getSelectedItem());
        });
        clearButton = new JButton("Clear");
        clearButton.setBackground(panelColor);
        clearButton.setForeground(Color.BLACK);
        clearButton.addActionListener(e -> {
            heroABox.setSelectedIndex(0);
            heroBBox.setSelectedIndex(0);
            imageA.setIcon(null);
            imageB.setIcon(null);
            nameALabel.setText("");
            nameBLabel.setText("");
            statsALabel.setText("");
            statsBLabel.setText("");
            resultsArea.setText("");
        });
        buttonsPanel.add(fightButton);
        buttonsPanel.add(randomButton);
        buttonsPanel.add(clearButton);

        resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        resultsArea.setBackground(new Color(40, 40, 40));
        resultsArea.setForeground(textColor);
        JScrollPane scroll = new JScrollPane(resultsArea);

        bottomPanel.add(buttonsPanel);
        bottomPanel.add(scroll);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        applyFonts();   fightButton.setForeground(Color.BLACK);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void applyFonts() {
        // Font system (clean + readable)
        Font nameFont = new Font("Segoe UI", Font.BOLD, 18);
        Font bodyFont = new Font("Segoe UI", Font.PLAIN, 14);
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);
        Font monoFont = new Font("Consolas", Font.PLAIN, 13);

        heroABox.setFont(bodyFont);
        heroBBox.setFont(bodyFont);

        nameALabel.setFont(nameFont);
        nameBLabel.setFont(nameFont);

        statsALabel.setFont(bodyFont);
        statsBLabel.setFont(bodyFont);

        fightButton.setFont(buttonFont);
        randomButton.setFont(buttonFont);
        clearButton.setFont(buttonFont);

        resultsArea.setFont(monoFont);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fight((String) heroABox.getSelectedItem(), (String) heroBBox.getSelectedItem());
    }
}

