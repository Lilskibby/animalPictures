import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GUI implements ActionListener
{
    private Networking client;
    private JButton catButton;
    private JButton duckButton;
    private JButton foxButton;
    private JButton dogButton;
    private JFrame frame;
    private Sound sound = new Sound();
    private JCheckBox soundsCheck;

    public GUI()
    {

        frame = new JFrame("Animal App");
        client = new Networking(); // our "networking client"
        catButton = new JButton("Cat");
        duckButton = new JButton("Duck");
        foxButton = new JButton("Fox");
        dogButton = new JButton("Dog");
        soundsCheck = new JCheckBox("Sounds");
        setupGui();
    }

    private void setupGui()
    {
        //Creating a Frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // ends program when you hit the X

        //rando color
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);

        JLabel welcomeLabel = new JLabel("Animals!");
        welcomeLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        welcomeLabel.setForeground(new Color(r, g, b));

        JPanel logoWelcomePanel = new JPanel(); // the panel is not visible in output
        logoWelcomePanel.add(welcomeLabel);
        logoWelcomePanel.setVisible(true);


        //bottom panel with text field and buttons
        JPanel entryPanel = new JPanel(); // the panel is not visible in output
        JPanel checkP = new JPanel();


        entryPanel.add(catButton);
        entryPanel.add(dogButton);
        entryPanel.add(duckButton);
        entryPanel.add(foxButton);
        checkP.add(soundsCheck);



        //Adding Components to the frame
        frame.add(logoWelcomePanel, BorderLayout.NORTH);
        frame.add(entryPanel);
        frame.add(checkP, BorderLayout.AFTER_LAST_LINE);

        // PART 2 -- SET UP EVENT HANDLING
        //setting up buttons to use ActionListener interface and actionPerformed method
        catButton.addActionListener(this);
        dogButton.addActionListener(this);
        foxButton.addActionListener(this);
        duckButton.addActionListener(this);

        // showing the frame
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(catButton))
        {
            try
            {
                URL imageURL = new URL(client.parseCat(client.makeRequest(client.CATURL)));
                BufferedImage image = ImageIO.read(imageURL);
                JFrame woo = new JFrame();
                JLabel animalPic =new JLabel(new ImageIcon(image));
                woo.setForeground(new Color(0, 0, 0));
                woo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                woo.add(animalPic);
                woo.pack();
                woo.setVisible(true);
                if(soundsCheck.isSelected())
                {
                    sound.playSound("src\\cat.mp3");
                }

            }
            catch(Exception l)
            {
                System.out.println(l.getMessage());
            }

        }
        else if(e.getSource().equals(dogButton))
        {
            try
            {
                URL imageURL = new URL(client.parseDog(client.makeRequest(client.DOGURL)));
                BufferedImage image = ImageIO.read(imageURL);
                JFrame woo = new JFrame();
                JLabel animalPic =new JLabel(new ImageIcon(image));
                woo.setForeground(new Color(0, 0, 0));
                woo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                woo.add(animalPic);
                woo.pack();
                woo.setVisible(true);
                if(soundsCheck.isSelected())
                {
                    sound.playSound("src\\dog.mp3");
                }
            }
            catch(Exception l)
            {
                System.out.println(l.getMessage());
            }
        }
        else if(e.getSource().equals(duckButton))
        {
            try
            {
                URL imageURL = new URL(client.parseDuck(client.makeRequest(client.DUCKURL)));
                BufferedImage image = ImageIO.read(imageURL);
                JFrame woo = new JFrame();
                JLabel animalPic =new JLabel(new ImageIcon(image));
                woo.setForeground(new Color(0, 0, 0));
                woo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                woo.add(animalPic);
                woo.pack();
                woo.setVisible(true);
                if(soundsCheck.isSelected())
                {
                    sound.playSound("src\\duck.mp3");
                }
            }
            catch(Exception l)
            {
                System.out.println(l.getMessage());
            }
        }
        else if(e.getSource().equals(foxButton))
        {
            try
            {
                URL imageURL = new URL(client.parseFox(client.makeRequest(client.FOXURL)));
                BufferedImage image = ImageIO.read(imageURL);
                JFrame woo = new JFrame();
                JLabel animalPic =new JLabel(new ImageIcon(image));
                woo.setForeground(new Color(0, 0, 0));
                woo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                woo.add(animalPic);
                woo.pack();
                woo.setVisible(true);
                if(soundsCheck.isSelected())
                {
                    sound.playSound("src\\fox.mp3");
                }
            }
            catch(Exception l)
            {
                System.out.println(l.getMessage());
            }
        }
    }
}
