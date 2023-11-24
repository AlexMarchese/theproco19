
/**
 * Die Klasse Lager Holzarbeitungs_Roboter 
 * 
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 * 
 */
public class Holzarbeitungs_Roboter extends Roboter
{
    // Instanzvariablen 

    /**
     * Konstruktor für Objekte der Klasse Holzarbeitungs_Roboter
     */
    public Holzarbeitungs_Roboter(Lager lager)
    {
        super(lager);
        // Zeit wird in Millisekunden angegeben
        stuhlZeit = 1000*10/60; 
        sofaZeit = 1000*30/60;
        name = "Holzbearbeitungsroboter";
    }
        
   // Produziert Produkt - benutzt die Materialen (in diesem Fall Holzeinheiten und Schrauben), dann ruft super.produziereProdukt
    public void produziereProdukt(Produkt produkt)
    {
        if(produkt instanceof Stuhl)
        {
            Lager.benutzeHolzeinheiten(Stuhl.gibAnzahlHolzeinheiten());
            Lager.benutzeSchrauben(Stuhl.gibAnzahlSchrauben());
        }
        else if(produkt instanceof Sofa)
        {
            Lager.benutzeHolzeinheiten(Sofa.gibAnzahlHolzeinheiten());
            Lager.benutzeSchrauben(Sofa.gibAnzahlSchrauben());
        }
        else
        {
        }
        super.produziereProdukt(produkt);
    }
}



