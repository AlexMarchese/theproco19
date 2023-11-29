
/**
 * Die Klasse Verpackungs_Roboter stellt eine Erweiterung der Klasse Roboter dar und Verpackt die montierten Produkte.
 * 
 * 
 * @author GBI Gruppe 19
 * @version 1.0
 * 
 */
public class Verpackungs_Roboter extends Roboter
{
  // Instanzvariablen
  String name; 

  /**
   * Konstruktor für Objekte der Klasse Verpackungs_Roboter
   */
  // public Verpackungs_Roboter(Lager lager){
  public Verpackungs_Roboter(){
    super();
    super.setzeName("Verpackungsroboter");
    }
  //  {super(lager);
  //       // Zeit wird in Millisekunden angegeben
  //       produktionsZeit  = 1000*5/60; // Zeit Stuhl
  //       produktionsZeit  = 1000*10/60; // Zeit Sofa
        
  //  }
   
  //  /**
  //    * Verpackt Produkt - benutzt die Materialien (in diesem Fall Kartoneinheiten), dann ruft super.produziereProdukt
  //    */
  //  public void produziereProdukt(Produkt produkt)
  //  { if (produkt instanceof Stuhl)
  //       {
  //           Lager.benutzeKartoneinheiten(Stuhl.gibKartoneinheiten());
  //       }
  //       else if(produkt instanceof Sofa)
  //       {
  //           Lager.benutzeKartoneinheiten(Sofa.gibKartoneinheiten());
  //       }
  //       else
  //       {
  //       }
  //       super.produziereProdukt(produkt);
  //   }
}