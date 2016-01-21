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
public class ContoCorrente {
    
    //Creo vettore parallelo che contiene chi ha versato e chi ha preso dal conto
    public int[] entrate; 
    public char[] identificativoEntrate;
    public int[] uscite;
    public char[] identificativoUscite;
    
    
    private int LastEntrate=0;  //contiene l'ultima posizione utilizzata nel vettore entrate
    private int LastUscite=0; //contiene l'ultima posizione utilizzata nel vettore uscite
    public int cassaTotale=3000; //all'inizio ci sono 3mila euro sul conto
    
     public ContoCorrente()
       {
           entrate =  new int[600];
           uscite =  new int[600];
           
           identificativoEntrate =  new char[600];
           identificativoUscite =  new char[600];
          
           
       }
     
     public boolean possoVersare()
     {
         if(LastEntrate<600)
             return true;
         else 
             return false;
     
     }
     
       public boolean possoPrelevare()
     {
         if(LastUscite<600 && getCassa()>0)
             return true;
         else 
             return false;
     
     }
       
     public int getCassa()  //restituisce il totale nel conto. se è in rosso restituisce -1
     {
        if(cassaTotale<=0)
           return -1;
        else 
            return cassaTotale;
         
     }
     
     public void resoconto()
     {
         //conto Versamenti:
         int countMadre=0, countPadre=0, countNonna=0;
         for(int i=0; i<600; i++)
         {
                 if(identificativoEntrate[i]=='M') countMadre+=entrate[i];
               else  if(identificativoEntrate[i]=='P') countPadre+=entrate[i];  
               else  if(identificativoEntrate[i]=='N') countNonna+=entrate[i]; 
         }
         //stampo
         //mamma ha versato countMadre
         //ecc...
         System.out.println("madre ha versato: "+ countMadre);
         System.out.println("padre ha versato: "+ countPadre);
         System.out.println("nonna ha versato: "+ countNonna);
         
         //Conto Prelievi
          int countFiglio1=0, countFiglio2=0;
         for(int i=0; i<600; i++)
         {
                 if(identificativoUscite[i]=='1') countFiglio1+=uscite[i];
               else  if(identificativoUscite[i]=='2') countFiglio2+=uscite[i];  
         }
         //stampo
         //figlio1 ha prelevato countFiglio1
         //ecc...
         System.out.println("figlio 1 ha prelevato: "+ countFiglio1);
         System.out.println("figlio 2 ha prelevato: "+ countFiglio2);
         
         
     }
     
     public boolean versamento(int taglio, char genitore) //restituisce true se riesce a versare.
     {
        if(LastEntrate<600)
        {
           entrate[LastEntrate]=taglio;
           identificativoEntrate[LastEntrate]=genitore;
           LastEntrate++;
           cassaTotale+=taglio;
           return true;
        }
        else
        {
            return false;
        }
         
     }
     
     public boolean prelievo(int taglio, char figlio) //restituisce true se riesce a prelevare.
     {
        if(LastUscite<600)
        {
           uscite[LastUscite]=taglio;
           identificativoUscite[LastUscite]=figlio;
           LastUscite++;
           cassaTotale-=taglio;
           return true;
        }
        else
        {
            return false;
        }
         
     }
     
     
     public int getLastLastEntrate()
     {
         return LastEntrate;
     }
     
     public int getLastLastUscite()
     {
         return LastUscite;
     }
     
     
     
     
}
