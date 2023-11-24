
/**
 * Die Klasse Lager Verpackungs_Roboter 
 * 
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 * 
 */
public class Verpackungs_Roboter extends Roboter
{
    // Instanzvariablen 

   /**
     * Konstruktor für Objekte der Klasse Verpackungs_Roboter
     */
   public Verpackungs_Roboter(Lager lager)
   {super(lager);
        // Zeit wird in Millisekunden angegeben
        stuhlZeit = 1000*5/60; 
        sofaZeit = 1000*10/60;
        name = "Verpackungsroboter";
   }
   
   /**
     * Verpackt Produkt - benutzt die Materialien (in diesem Fall Kartoneinheiten), dann ruft super.produziereProdukt
     */
   public void produziereProdukt(Produkt produkt)
   { if (produkt instanceof Stuhl)
        {
            Lager.benutzeKartoneinheiten(Stuhl.gibKartoneinheiten());
        }
        else if(produkt instanceof Sofa)
        {
            Lager.benutzeKartoneinheiten(Sofa.gibKartoneinheiten());
        }
        else
        {
        }
        super.produziereProdukt(produkt);
    }
}
