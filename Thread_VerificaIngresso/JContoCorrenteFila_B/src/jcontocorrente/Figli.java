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
public class Figli extends Thread{
    private ContoCorrente puntatoreConto;
    private Semaphore puntatoreSem;
    private char figlio;
    
    
    public Figli(ContoCorrente puntatore, Semaphore puntatoreSem, char figlio)
    {
        this.puntatoreSem=puntatoreSem;
        puntatoreConto=puntatore;
        this.figlio = figlio;  
    }

  
    public void run()
    {      
        while(puntatoreConto.possoPrelevare()) 
        {
          //prelevo X soldi
             int taglio = (int)(Math.random()*800)+500;  //da 500 a 1300;
            
             puntatoreSem.P(); //Inizio area critica
                if(puntatoreConto.prelievo(taglio, figlio))
                {
                   System.out.println("Il figlio "+figlio+", ha prelevato -"+taglio+"€"); 
                   System.out.println("Conto corrente attuale: "+puntatoreConto.getCassa()+"€");
                }
                if(puntatoreConto.getCassa()<0)
                    System.out.println("ROSSO!");
              puntatoreSem.V(); //fine area critica
                       
            //Al Termine di ogni operazione il thread dorme per un tempo random
                try
                {   
                    Figli.sleep((int) (Math.random() * 10));
                }
                catch (Exception E) 
                {
                    System.out.println("Error2");
                }
        }//End while
                

                
            
        try
        {   
            Figli.sleep((int) (Math.random() * 10));
        }
        catch (Exception E) 
        {
            System.out.println("Error2");
        }
    
    }//end run 

}