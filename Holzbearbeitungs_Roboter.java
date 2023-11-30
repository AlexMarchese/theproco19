
/**
 * Die Klasse Holzarbeitungs_Roboter stellt eine Erweiterung der Klasse Roboter dar und bearbeitet Holz.
 * 
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 * 
 */
public class Holzbearbeitungs_Roboter extends Roboter
{
    // Instanzvariablen
    String name; 
  
    /**
     * Konstruktor für Objekte der Klasse Holzarbeitungs_Roboter
     */
    // public Holzarbeitungs_Roboter(Lager lager){
    public Holzbearbeitungs_Roboter(){
      super();
      super.setzeName("Holzbearbeitungsroboter");
      }
}
/*    /**
     * Konstruktor für Objekte der Klasse Holzarbeitungs_Roboter

    public Holzarbeitungs_Roboter(Lager lager)
    {
        super(lager);
        // Zeit wird in Millisekunden angegeben
        produktionsZeit = 1000*10/60; // Zeit Stuhl
        produktionsZeit = 1000*30/60; // Zeit Sofa
        name = "Holzbearbeitungsroboter";
    }
        
   // Produziert Produkt - benutzt die Materialen (in diesem Fall Holzeinheiten und Schrauben), dann ruft super.produziereProdukt
    public void produziereProdukt(Produkt produkt)
    {
        if(produkt instanceof Stuhl)
        {
            meinLager.benutzeHolzeinheiten(Stuhl.gibAnzahlHolzeinheiten());
            meinLager.benutzeSchrauben(Stuhl.gibAnzahlSchrauben());
        }
        else if(produkt instanceof Sofa)
        {
            meinLager.benutzeHolzeinheiten(Sofa.gibAnzahlHolzeinheiten());
            meinLager.benutzeSchrauben(Sofa.gibAnzahlSchrauben());
        }
        else
        {
        }
        super.produziereProdukt(produkt);
    }
}
**/


