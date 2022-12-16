/*
* File: MaincONTROLLER.java
* Author: Farkas CSaba
* Copyright: 2022, Farkas Csaba
* Group: Szoft_II_N
* Date: 2022-12-16
* Github: https://github.com/fcsabi/
* Licenc: GNU GPL
*/



package controllers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import lan.bcs.InputPanel;
import views.MainFrame;

public class MainController<MainFrame> implements ActionListener {
  MainFrame mainFrame;

  JButton submitButton;
  JButton resetButton;
  JButton creditsButton;
  JButton exitButton;

  JPanel sideInput;
  JPanel angleInput;

  JPanel perimeterDisplay;
  JPanel areaDisplay;
  
  public MainController() {

    start();
    addActionEvents();
  }

  private void start() {
    this.mainFrame = new MainFrame();

    submitButton = mainFrame.getSubmitButton();
    resetButton = mainFrame.getResetButton();
    creditsButton = mainFrame.getCreditsButton();
    exitButton = mainFrame.getExitButton();

    sideInput = mainFrame.getSideInput();
    angleInput = mainFrame.getAngleInput();

    perimeterDisplay = mainFrame.getPerimeterDisplay();
    areaDisplay = mainFrame.getAreaDisplay();
  }

  private void addActionEvents() {
    submitButton.addActionListener(this);
    resetButton.addActionListener(this);
    exitButton.addActionListener(this);
    creditsButton.addActionListener(this);
  }

  private void calculate(double side, double angle) {
    Double perimeter = 4 * side;

    Double area = Math.pow(side, 2) * Math.sin(Math.toRadians(angle));

    perimeterDisplay.setValue(perimeter.toString());
    areaDisplay.setValue(area.toString());
  }

  private void tryCalculate() {

    String sideInputString = sideInput.getValue();
    String angleInputString = angleInput.getValue();

    try {
      Double side = Double.parseDouble(sideInputString);
      Double angle = Double.parseDouble(angleInputString);

      calculate(side, angle);

    } catch (NumberFormatException e) {

      String content = "Hiba nem jo adatok!";
      String title = "HIBA";

      JOptionPane.showMessageDialog(
        mainFrame.getContentPane(),
        content,
        title,
        JOptionPane.ERROR_MESSAGE
      );
    }

  }

  private void reset() {
    sideInput.setValue(null);
    angleInput.setValue(null);
    perimeterDisplay.setValue(null);
    areaDisplay.setValue(null);
  }

  private void displayCredits() {
    
    String content = 
      " Farkas Csaba " 
      + " Szoft II/N "
      +  "2022.12.16";

    String title = "Rombitak 0.0.0.0.0.0.1";

    JOptionPane.showMessageDialog(
      mainFrame.getContentPane(), 
      content, 
      title, 
      JOptionPane.INFORMATION_MESSAGE);

  }

  private void exit() {
    System.exit(0);
  }

  @Override
  public void actionPerformed(ActionEvent event) {

    Object source = event.getSource();

    if (source == submitButton) {
      tryCalculate();
    } else if (source == resetButton) {
      reset();
    } else if (source == creditsButton) {
      displayCredits();
    } else if (source == exitButton) {
      exit();
    }
  }
}