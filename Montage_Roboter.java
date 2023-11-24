
/**
 * Die Klasse Lager Montage_Roboter
 * 
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 * 
 */
public class Montage_Roboter extends Roboter
{
    // Instanzvariablen

    /**
     * Konstruktor für Objekte der Klasse Montage_Roboter
     */
    public Montage_Roboter(Lager lager)
    {
        super(lager);
        // Zeit wird in Millisekunden angegeben
        produktionsZeit = 1000*5/60; // Zeit Stuhl
        produktionsZeit = 1000*15/60; // Zeit Sofa
        name = "Montageroboter";
    }

   /**
     * Produziere Produkt - benutzt die Materialien (in diesem Fall Kissen), dann ruft super.produziereProdukt
     */
   public void produziereProdukt(Produkt produkt)
 {
        if(produkt instanceof Stuhl)
        {
            // Stühle brauchen keine Kissen
        }
        else if(produkt instanceof Sofa)
        {
            // in der Aufgabenstellung wird nicht gesagt, in welchem Schritt
            // Kissen verwendet werden. Montage schien uns sinnvoll zu sein
            Lager.benutzeKissen(Sofa.gibKissen());
        }
        else
        {
        }
        super.produziereProdukt(produkt);
    }
}
