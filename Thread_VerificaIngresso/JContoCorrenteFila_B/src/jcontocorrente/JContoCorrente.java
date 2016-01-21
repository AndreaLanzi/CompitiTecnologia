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
public class JContoCorrente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         ContoCorrente conto = new ContoCorrente();
         Semaphore sem = new Semaphore(1);
         Figli figlia = new Figli(conto , sem ,'1');
         Figli figlio = new Figli(conto , sem, '2');
         Genitori padre = new Genitori (conto, sem ,'P');
         Genitori madre = new Genitori (conto, sem ,'M');
         Genitori nonna = new Genitori (conto, sem ,'N');
         
        //CORREZIONI: 
         //riga 41 del file Genitori.java (aggiunte le graffe che avevo sbagliato anche in verifica -.-)
         
         figlia.start();
         figlio.start();
         
         madre.start();
         padre.start();
         nonna.start();
         
         try{
             figlia.join();
             figlio.join();
             madre.join();
             padre.join();
             nonna.join();
             
         }
         catch (Exception E)
         {
             System.out.println("Error");
         }
        System.out.println("fine (o è in rosso o ha riempito i vettori,. stampo resoconto finale:");
        conto.resoconto();
        
    
    }
}

