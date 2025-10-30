public class HiloEscribe extends Thread {
    
    private String info[];
    private int ini;
    private int tmp;
    private Posicion p;

    private boolean pausar = false;

    public HiloEscribe(Posicion x) {
        this.p = x;
    }
    public synchronized void pausar() {
        pausar = true;
    }

    public synchronized void reanudar() {
        pausar = false;
        notify();
    }

    public void setTmp(int tmp) {
        this.tmp = tmp;
    }

    @Override
    public void run() {
        for (int i = ini; i < ini + 5; i++) {
            try {

                synchronized (this) {
                    while (pausar) {
                        wait(); 
                    }
                }

                synchronized (p) {
                    //info[p.getP()] = getName() + " " + i + "-" + p.getP();
                    info[p.getP()] = getName() + ": " + i;
                    System.out.println(" " + getName() + " : " + i);
                    p.incrementa();
                }

                sleep(tmp);

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("NO HAY ESPACIO");
                break;
            } catch (InterruptedException e) {
                System.out.println("INTERRUPCION");
                break;
            }
        }
    }

    public void setIni(int x) {
        ini = x;
    }

    public void setInfo(String x[]) {
        info = x;
    }
}
