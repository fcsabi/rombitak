/*
* File: Mainviews.java
* Author: Farkas CSaba
* Copyright: 2022, Farkas Csaba
* Group: Szoft_II_N
* Date: 2022-12-16
* Github: https://github.com/fcsabi/
* Licenc: GNU GPL
*/


package views;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainViews extends JFrame {
  JPanel mainPanel;

  JPanel northPanel;
    JLabel mainLabel;

    JPanel középPanel;
    JPanel sideInput;
    JPanel angleInput;
    JPanel buttonPanel;
    JButton submitButton;
    JButton resetButton;
    JPanel perimeterDisplay;
    JPanel areaDisplay;

  JPanel southPanel;
    JButton exitButton;
    JButton creditsButton;

  public void MainFrame() {

    setMainPanel();
    setComponents();
    addComponentsToPanels();
    setFrame();
  }

  private void setComponents() {

    GridLayout Grid_1_2 = new GridLayout(1, 2);

    northPanel = new JPanel();
      mainLabel = new JLabel("Rombusz adatai");

        középPanel = new JPanel(new GridLayout(5, 1));

      sideInput = new JPanel();
      sideInput.setToolTipText("A oldal (m):");
      angleInput = new JPanel();
      angleInput.setToolTipText(("Alpha (°): "));

      buttonPanel = new JPanel(Grid_1_2);

      submitButton = new JButton("Számítás");
      resetButton = new JButton("Újra");

      perimeterDisplay = new JPanel();
      perimeterDisplay.setToolTipText("Kerület (m): ");
      areaDisplay = new JPanel();
      areaDisplay.setToolTipText("Terület (m²): ");

    southPanel = new JPanel(Grid_1_2);

      exitButton = new JButton("Kilépés");
      creditsButton = new JButton("Névjegy");

  }

  private void addComponentsToPanels() {
    northPanel.add(mainLabel);

    középPanel.add(sideInput);
    középPanel.add(angleInput);
    középPanel.add(buttonPanel);

    buttonPanel.add(submitButton);
    buttonPanel.add(resetButton);

    középPanel.add(perimeterDisplay);
    középPanel.add(areaDisplay);

    southPanel.add(creditsButton);
    southPanel.add(exitButton);

    mainPanel.add(northPanel, BorderLayout.NORTH);
    mainPanel.add(középPanel, BorderLayout.CENTER);
    mainPanel.add(southPanel, BorderLayout.SOUTH);
  }

  private void setMainPanel() {
    this.mainPanel = new JPanel(new BorderLayout());

    this.add(this.mainPanel);
  }

  private void setFrame() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(400, 300);
    this.setTitle("Rombitak");
    this.setVisible(true);

  }

  // methods to access buttons
  public JButton getSubmitButton() {
    return this.submitButton;
  }
  public JButton getResetButton() {
    return this.resetButton;
  }
  public JButton getCreditsButton() {
    return this.creditsButton;
  }
  public JButton getExitButton() {
    return this.exitButton;
  }

  // methods to access input fields
  public JPanel getSideInput() {
    return this.sideInput;
  }
  public JPanel getAngleInput() {
    return this.angleInput;
  }

  //methods to access display fields
  public JPanel getPerimeterDisplay() {
    return this.perimeterDisplay;
  }
  public JPanel getAreaDisplay() {
    return this.areaDisplay;
  }
}