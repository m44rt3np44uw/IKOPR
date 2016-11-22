package Week_1.Opdracht_1;

import javax.swing.*;
import java.awt.*;

public class  HoofdPaneel extends JPanel
{
  private VerkeersLichtModel model;
  private VerkeersLichtView  view;
  private VerkeersController controller;

  public HoofdPaneel()
  {
    // geef dit paneel een borderlayout
    this.setLayout(new BorderLayout());

    // model wordt een nieuw VerkeersLichtModel
    this.model = new VerkeersLichtModel(true, true, true);

    // view wordt een nieuw view-object van het model;
    this.view = new VerkeersLichtView(this.model);

    // controller wordt een nieuw control van het
    // model en de view
    this.controller = new VerkeersController(this.model, this.view);

    // voeg de view toe aan het centrum van het paneel
    this.add(this.view, BorderLayout.CENTER);

    // voeg de controller toe aan het zuiden van het paneel
    this.add(this.controller, BorderLayout.SOUTH);
  }

}