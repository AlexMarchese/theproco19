
/**
 * Die Klasse Lager Montage_Roboter
 * 
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 * 
 */
public class Lackier_Roboter extends Roboter
{
    
    /**
     * Konstruktor für Objekte der Klasse Montage_Roboter
     */
    public Lackier_Roboter(Lager lager)
    {
        super(lager);
        // Zeit wird in Millisekunden angegeben
        produktionsZeit = 1000*2/60; // Zeit Stuhl
        produktionsZeit = 1000*5/60; // Zeit Sofa
        name = "Lackierroboter";
    }

   /**
     //Produziert Produkt - benutzt die Materialien (in diesem Fall Farbe), dann ruft super.produziereProdukt
     */
    public void produziereProdukt(Produkt produkt)
    {
        if(produkt instanceof Stuhl)
        {
            Lager.benutzeFarbeinheiten(Stuhl.gibAnzahlFarbeinheiten());
        }
        else if(produkt instanceof Sofa)
        {
            Lager.benutzeFarbeinheiten(Sofa.gibAnzahlFarbeinheiten());
        }
        else
        {
        }
        super.produziereProdukt(produkt);
    }
}
