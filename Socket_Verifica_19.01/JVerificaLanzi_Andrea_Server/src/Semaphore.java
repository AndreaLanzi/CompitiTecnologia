public class Semaphore {

    int valore;

    public Semaphore(int initial) {
        valore = initial;
    }

    // void wait()
    synchronized public void P() {
        while (valore == 0) {              // semaforo rosso
            try {
                wait();
            } // il thread si sospende
            catch (InterruptedException e) {
            }
        }
        valore--;                          // pone il semaforo a rosso
    } //end P

    // void signal()
    synchronized public void V() {
        valore++;                          // pone semaforo a verde 
        notify();                          // risveglia thread in coda 
    } //end V

}
