/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcontocorrente;

/**
 *
 * @author verificainf
 */
public class Genitori extends Thread{
    private ContoCorrente puntatoreConto;
    private Semaphore puntatoreSem;
    private char genitore;
    
    
    public Genitori(ContoCorrente puntatore, Semaphore puntatoreSem, char genitore)
    { 
        this.puntatoreSem=puntatoreSem;
        this.puntatoreConto = puntatore;
        this.genitore = genitore;
        
    }

  
    public void run()
    {      
        while(puntatoreConto.possoVersare())
        {
          //immetto X soldi
             int taglio = (int)(Math.random()*400)+200;  //da 200 a 600;
            
            
             puntatoreSem.P(); //Inizio area critica
                if(puntatoreConto.versamento(taglio, genitore))
                {
                   System.out.println("Il genitore "+genitore+", ha versato +"+taglio+"€"); 
                   System.out.println("Conto corrente attuale: "+puntatoreConto.getCassa()+"€");
                }
                if(puntatoreConto.getCassa()>=9000)  
                {  //PARENTESI MANCANTI NEL PROGETTO ORIGINALE -.-
                    System.out.println("GITAAAAAAA!!!!");
                    puntatoreConto.prelievo(4000, genitore); //unico caso in cui un genitore prelieva
                }
                puntatoreSem.V(); //fine area critica  
                        
            //Al Termine di ogni operazione il thread dorme per un tempo random
                try
                {   
                    Genitori.sleep((int) (Math.random() * 10));
                }
                catch (Exception E) 
                {
                    System.out.println("Error2");
                }
            
            
        }//END WHILE
                
        
        try
        {   
            Genitori.sleep((int) (Math.random() * 10));
        }
        catch (Exception E) 
        {
            System.out.println("Error2");
        }
    
    }//end run 
}
