
public class Mainthread
{
	public static void main(String[] args) {
		try{

			String[] info = new String[5];
        	Posicion pos = new Posicion();

			HiloEscribe h1 = new HiloEscribe(pos);
        	h1.setInfo(info);
        	h1.setIni(0);
        	h1.setTmp(500);
        	h1.setName("Hilo 1");
		
			System.out.println("\n\nIniciando hilo...");
        	h1.start();

        	Thread.sleep(900);

        	System.out.println("Pausa de hilo...");
        	h1.pausar();

        	Thread.sleep(2000);

        	System.out.println("Continuando hilo...");
        	h1.reanudar();
        	Thread.sleep(900);

        	h1.join();

        	System.out.println("\n Arreglo:");
        	for (int i = 0; i < info.length; i++) {
        		System.out.println(info[i]);
        	}

        	System.out.println("\nEstado del hilo: " + h1.getState());

    	} catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Indice fuera de rango.");
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido.");
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
	}
}
