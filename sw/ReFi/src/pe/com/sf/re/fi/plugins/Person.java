package pe.com.sf.re.fi.plugins;
import java.awt.Color;

public class Person {

  private String name;
  private Color schriftfarbe;

  public Person(String name, Color schriftfarbe){
    this.name = name;
    this.schriftfarbe = schriftfarbe;
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Color getSchriftfarbe() {
    return schriftfarbe;
  }
  public void setSchriftfarbe(Color schriftfarbe) {
    this.schriftfarbe = schriftfarbe;
  }
}