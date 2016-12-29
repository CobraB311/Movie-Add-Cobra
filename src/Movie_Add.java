import Models.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Movie_Add extends JDialog {
    private JPanel contentPane;
    private JLabel lblTitle;
    private JPanel mainPanel;
    private JTextField txtTitle;
    private JComboBox comboBoxType;
    private JPanel zuidPaneel;
    private JLabel lblType;
    private JComboBox comboBoxGenre;
    private JLabel lblGenre;
    private JLabel lblYear;
    private JTextField txtYear;
    private JLabel lblQuality;
    private JComboBox comboBoxQuality;
    private JLabel lblOwner;
    private JComboBox comboBoxOwner;
    private JTextArea textAreaActors;
    private JLabel lblActors;
    private JLabel lblCollection;
    private JCheckBox collectionCheckBox;
    private JTextField txtCollection;
    private JButton btnAdd;
    private JLabel lblSeason;
    private JTextField txtSeason;
    private JLabel lblEpisodes;
    private JTextField txtEpisodes;
    private JTextField Target;
    private JTextField Source;
    private JLabel lblInfo;
    private JTextField txtInfo;

    private static final String MOVIE = "Movie";
    private static final String SERIE = "Serie";

    private String outputSeries = "";
    private String outputMovies = "";
    private String source = "";

    private static Movie_Add dialog;
    //private JButton buttonOK;

    public Movie_Add() {
        System.out.println("2");

        setContentPane(contentPane);
        setModal(true);
        //getRootPane().setDefaultButton(buttonOK);
        //txtCollection.setVisible(false);

        outputMovies = System.getProperty("user.home") + "\\Dropbox\\Snoesmap\\Movies-Series\\Movies Bought\\";
        source = System.getProperty("user.home") + "\\Dropbox\\Snoesmap\\Movies-Series";
        Source.setText(source);
        Source.setEnabled(false);
        Target.setText(outputMovies);
        Target.setEnabled(false);

        fill();

        lblEpisodes.setVisible(false);
        lblSeason.setVisible(false);
        txtEpisodes.setVisible(false);
        txtSeason.setVisible(false);

        collectionCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
                if (collectionCheckBox.isSelected()) {
                    txtCollection.setVisible(true);
                    repaint();
                    System.out.println("Selected");
                } else {
                    txtCollection.setVisible(false);
                    repaint();
                    System.out.println("Not Selected");
                }

            }
        });
        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.

                //New Part

                if (comboBoxType.getSelectedItem().toString().equals(MOVIE)) {

                    Movie movie = new Movie();

                    if(!txtTitle.getText().isEmpty()) {
                        movie.withTitle(txtTitle.getText());
                    } else {
                        lblInfo.setForeground(Color.red);
                        lblInfo.setText("Title can't be empty.");
                        return;
                    }

                }

                //End New Part

                // Movie Part
                if (comboBoxType.getSelectedItem().toString().equals("Movie")) {
                    outputMovies = outputMovies + comboBoxGenre.getSelectedItem().toString();

                    File f = new File(outputMovies);
                    System.out.println(f.toString());
                    if (f.exists() && (!txtTitle.getText().equals(""))) {
                        System.out.println("Folder Exist");

                        File movieFolder;
                        Path destBig;

                        if (!textAreaActors.getText().equals("")) {                   //Met Acteurs
                            if (!collectionCheckBox.isSelected()) {                   //Collection

                                movieFolder = new File(
                                        outputMovies
                                                + "\\"
                                                + txtTitle.getText()
                                                + " "
                                                + txtYear.getText()
                                                + " - "
                                                + textAreaActors.getText()
                                );

                                Path dest = Paths.get(
                                        outputMovies
                                                + "\\"
                                                + txtTitle.getText()
                                                + " "
                                                + txtYear.getText()
                                                + " - "
                                                + textAreaActors.getText()
                                                + "\\"
                                                + txtTitle.getText()
                                                + " "
                                                + txtYear.getText()
                                                + " - "
                                                + textAreaActors.getText()
                                                + " - "
                                                + comboBoxQuality.getSelectedItem().toString()
                                                + ".mp4"
                                );

                                System.out.println("Not Collection");
                                destBig = dest;
                            } else {                                                    //Non Collection

                                movieFolder = new File(
                                        outputMovies
                                                + "\\"
                                                + txtCollection.getText()
                                                + "\\"
                                                + txtTitle.getText()
                                                + " "
                                                + txtYear.getText()
                                                + " - "
                                                + textAreaActors.getText()
                                );

                                Path dest = Paths.get(
                                        outputMovies
                                                + "\\"
                                                + txtCollection.getText()
                                                + "\\"
                                                + txtTitle.getText()
                                                + " "
                                                + txtYear.getText()
                                                + " - "
                                                + textAreaActors.getText()
                                                + "\\"
                                                + txtTitle.getText()
                                                + " "
                                                + txtYear.getText()
                                                + " - "
                                                + textAreaActors.getText()
                                                + " - "
                                                + comboBoxQuality.getSelectedItem().toString()
                                                + ".mp4"
                                );

                                System.out.println("Collection");
                                destBig = dest;
                            }
                            movieFolder.mkdirs();

                            Path src = Paths.get(
                                    source
                                            + "\\Movie Bought "
                                            + comboBoxQuality.getSelectedItem().toString()
                                            + " "
                                            + comboBoxOwner.getSelectedItem().toString()
                                            + ".mp4"
                            );

                            try {
                                Files.copy(src, destBig);
                            } catch (IOException i) {
                                i.printStackTrace();
                            }
                        } else {                                                        //Zonder Acteurs
                            if (!collectionCheckBox.isSelected()) {
                                movieFolder = new File(outputMovies + "\\" + txtTitle.getText() + " " + txtYear.getText());
                                Path dest = Paths.get(outputMovies + "\\" + txtTitle.getText() + " " + txtYear.getText() + "\\" + txtTitle.getText() + " " + txtYear.getText() + " - " + comboBoxQuality.getSelectedItem().toString() + ".mp4");
                                System.out.println("Not Collection");
                                destBig = dest;
                            } else {
                                movieFolder = new File(outputMovies + "\\" + txtCollection.getText() + "\\" + txtTitle.getText() + " " + txtYear.getText());
                                Path dest = Paths.get(outputMovies + "\\" + txtCollection.getText() + "\\" + txtTitle.getText() + " " + txtYear.getText() + "\\" + txtTitle.getText() + " " + txtYear.getText() + " - " + comboBoxQuality.getSelectedItem().toString() + ".mp4");
                                System.out.println("Collection");
                                destBig = dest;
                            }
                            movieFolder.mkdirs();
                            Path src = Paths.get(source + "\\Movie Bought " + comboBoxQuality.getSelectedItem().toString() + " " + comboBoxOwner.getSelectedItem().toString() + ".mp4");
                            try {
                                Files.copy(src, destBig);
                            } catch (IOException i) {
                                i.printStackTrace();
                            }
                        }

                        System.out.println(outputMovies + "\\" + txtTitle.getText() + " " + txtYear.getText() + " - " + textAreaActors.getText());


                    } else {
                        System.out.println("Folder doesn't exist or Title is empty");
                    }

                    txtTitle.setText("");
                    txtYear.setText("");
                    textAreaActors.setText("");
                    outputMovies = System.getProperty("user.home") + "\\Dropbox\\Snoesmap\\Movies-Series\\Movies Bought\\";
                }

                // Serie Part
                if(comboBoxType.getSelectedItem().toString().equals("Serie")){

                    if(!comboBoxQuality.getSelectedItem().toString().equals("720p")){

                        outputSeries = System.getProperty("user.home") + "\\Dropbox\\Snoesmap\\Movies-Series";
                        Target.setText(outputSeries);

                        File f = new File(outputSeries);
                        if (f.exists() && (!txtTitle.getText().equals("")) && (!txtEpisodes.getText().equals(""))&& (!txtSeason.getText().equals(""))) {
                            System.out.println("Folder Exist");

                            File serieFolder;

                            Path src = Paths.get(outputSeries + "\\Season Bought " + comboBoxOwner.getSelectedItem().toString() + " " + comboBoxQuality.getSelectedItem().toString() + ".mp4");

                            serieFolder = new File(outputSeries + "\\Series Bought" + "\\" + txtTitle.getText() + "\\Season " + txtSeason.getText() + " - " + txtYear.getText());
                            serieFolder.mkdirs();

                            boolean oneven = false;

                            int lengte = Integer.parseInt(txtEpisodes.getText());
                            if(lengte%2 == 0){
                                //Even
                            }
                            if(lengte%2 == 1){
                                //Oneven
                                lengte = lengte-1;
                                oneven = true;
                            }

                            Path destBig = Paths.get("");

                            for(int i=1; i<=lengte; i=i+2){
                                System.out.println("Episode: " + i);

                                if(i < 9){
                                    if(Integer.parseInt(txtSeason.getText()) < 10){
                                        destBig = Paths.get(outputSeries + "\\Series Bought" + "\\" + txtTitle.getText() + "\\Season " + txtSeason.getText() + " - " + txtYear.getText() + "\\" + txtTitle.getText() + " - s0" + txtSeason.getText() + "e0" + i + "-e0" + (i+1) + ".mp4");
                                        System.out.println("i<10 en S<10");
                                    }
                                    else{
                                        destBig = Paths.get(outputSeries + "\\Series Bought" + "\\" + txtTitle.getText() + "\\Season " + txtSeason.getText() + " - " + txtYear.getText() + "\\" + txtTitle.getText() + " - s" + txtSeason.getText() + "e0" + i + "-e0" + (i+1) + ".mp4");
                                        System.out.println("i<10");
                                    }
                                }
                                if(i == 9){
                                    destBig = Paths.get(outputSeries + "\\Series Bought" + "\\" + txtTitle.getText() + "\\Season " + txtSeason.getText() + " - " + txtYear.getText() + "\\" + txtTitle.getText() + " - s0" + txtSeason.getText() + "e0" + i + "-e" + (i+1) + ".mp4");
                                }
                                if(i > 10) {
                                    if (Integer.parseInt(txtSeason.getText()) < 10) {
                                        destBig = Paths.get(outputSeries + "\\Series Bought" + "\\" + txtTitle.getText() + "\\Season " + txtSeason.getText() + " - " + txtYear.getText() + "\\" + txtTitle.getText() + " - s0" + txtSeason.getText() + "e" + i + "-e" + (i + 1) + ".mp4");
                                        System.out.println("S<10");
                                    } else {
                                        destBig = Paths.get(outputSeries + "\\Series Bought" + "\\" + txtTitle.getText() + "\\Season " + txtSeason.getText() + " - " + txtYear.getText() + "\\" + txtTitle.getText() + " - s" + txtSeason.getText() + "e" + i + "-e" + (i + 1) + ".mp4");
                                        System.out.println("Niets");
                                    }
                                }

                                try {
                                    Files.copy(src, destBig);
                                } catch (IOException j) {
                                    j.printStackTrace();
                                }

                            }
                            if(oneven){
                                // Oneven
                                Path destBig2 = Paths.get("");
                                lengte = lengte+1;

                                if(lengte < 9) {
                                    if (Integer.parseInt(txtSeason.getText()) < 10) {
                                        destBig2 = Paths.get(outputSeries + "\\Series Bought" + "\\" + txtTitle.getText() + "\\Season " + txtSeason.getText() + " - " + txtYear.getText() + "\\" + txtTitle.getText() + " - s0" + txtSeason.getText() + "e0" + lengte + ".mp4");
                                        System.out.println("i<10 en S<10");
                                    } else {
                                        destBig2 = Paths.get(outputSeries + "\\Series Bought" + "\\" + txtTitle.getText() + "\\Season " + txtSeason.getText() + " - " + txtYear.getText() + "\\" + txtTitle.getText() + " - s" + txtSeason.getText() + "e0" + lengte + ".mp4");
                                        System.out.println("i<10");
                                    }
                                }
                                if(lengte == 9){
                                    destBig2 = Paths.get(outputSeries + "\\Series Bought" + "\\" + txtTitle.getText() + "\\Season " + txtSeason.getText() + " - " + txtYear.getText() + "\\" + txtTitle.getText() + " - s0" + txtSeason.getText() + "e0" + lengte + ".mp4");
                                }
                                if(lengte > 10){
                                    if(Integer.parseInt(txtSeason.getText()) < 10){
                                        destBig2 = Paths.get(outputSeries + "\\Series Bought" + "\\" + txtTitle.getText() + "\\Season " + txtSeason.getText() + " - " + txtYear.getText() + "\\" + txtTitle.getText() + " - s0" + txtSeason.getText() + "e" + lengte + ".mp4");
                                        System.out.println("S<10");
                                    }
                                    else{
                                        destBig2 = Paths.get(outputSeries + "\\Series Bought" + "\\" + txtTitle.getText() + "\\Season " + txtSeason.getText() + " - " + txtYear.getText() + "\\" + txtTitle.getText() + " - s" + txtSeason.getText() + "e" + lengte + ".mp4");
                                        System.out.println("Niets");
                                    }
                                }

                                try {
                                    Files.copy(src, destBig2);
                                } catch (IOException j) {
                                    j.printStackTrace();
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Folder doesn't exist or Title/Season/Episode is empty");
                        }

                        int Season = Integer.parseInt(txtSeason.getText());
                        Season++;
                        txtSeason.setText("" + Season);

                        int Year = Integer.parseInt(txtYear.getText());
                        Year++;
                        txtYear.setText("" + Year);

                    }
                    else {
                        System.out.println("There is no 720p");
                    }

                }

            }

        });
        comboBoxType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.

                if(comboBoxType.getSelectedItem().toString().equals("Serie")){


                    txtCollection.setVisible(false);
                    collectionCheckBox.setVisible(false);
                    lblCollection.setVisible(false);

                    lblEpisodes.setVisible(true);
                    lblSeason.setVisible(true);
                    txtEpisodes.setVisible(true);
                    txtSeason.setVisible(true);

                    comboBoxGenre.setVisible(false);
                    lblGenre.setVisible(false);

                    textAreaActors.setVisible(false);
                    lblActors.setVisible(false);

                    comboBoxOwner.setSelectedIndex(1);

                    System.out.println("Dialog Dimension Serie: " + dialog.getSize().toString());
                }
                else{
                    txtCollection.setVisible(true);
                    collectionCheckBox.setVisible(true);
                    lblCollection.setVisible(true);

                    lblEpisodes.setVisible(false);
                    lblSeason.setVisible(false);
                    txtEpisodes.setVisible(false);
                    txtSeason.setVisible(false);

                    comboBoxGenre.setVisible(true);
                    lblGenre.setVisible(true);

                    textAreaActors.setVisible(true);
                    lblActors.setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("1");

        //Movie_Add dialog = new Movie_Add();
        dialog = new Movie_Add();       //Vanboven gedeclareerd
        dialog.pack();
        dialog.setSize(550, 500);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        System.out.println("Dialog Dimension Movie: " + dialog.getSize().toString());
        //System.out.println("Dialog Dimension Movie: " + dialog.getBounds().toString());

        System.exit(0);
    }

    private void fill() {

        /*txtCollection.setVisible(false);
        repaint();
        System.out.println("Not Visible");  */

        System.out.println("Even: " + 18450%2);
        System.out.println("Oneven: " + 15785%2);

        //Type, Genre, Quality, Owner
        String[] types = {"Movie", "Serie"},
                genres = {"Action", "Adventure", "Animation", "Comedy", "Crime", "Dancing", "Drama", "Fantasy", "Horror", "Thriller", "War"},
                quality = {"2160p", "1080p", "720p", "480p"},
                owners = {"Ruben", "Kitty"};
        for (int i = 0; i < types.length; i++) {
            comboBoxType.addItem(types[i]);
        }

        for (int i = 0; i < genres.length; i++) {
            comboBoxGenre.addItem(genres[i]);
        }

        for (int i = 0; i < quality.length; i++) {
            comboBoxQuality.addItem(quality[i]);
        }

        for (int i = 0; i < owners.length; i++) {
            comboBoxOwner.addItem(owners[i]);
        }
    }

}
