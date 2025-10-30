import java.util.Scanner;

public class Mainthread
{
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(System.in);

			String[] info = new String[15];
        	Posicion pos = new Posicion();

			HiloEscribe h1 = new HiloEscribe(pos);
        	h1.setInfo(info);
        	h1.setIni(0);
        	h1.setTmp(500);
        	h1.setName("Hilo 1");
		
			System.out.println("\n\nIniciando hilo...");
        	h1.start();

        	String opcion;
            boolean salir = false;

            while (!salir) {
                System.out.println("\n=== CONTROL DE HILO ===");
                System.out.println("1. Pausar hilo");
                System.out.println("2. Continuar hilo");
                System.out.println("3. Terminar hilo");
                System.out.println("4. Mostrar arreglo");
                System.out.println("5. Mostrar estado del hilo");
                System.out.println("6. Salir");
                System.out.print("\nElige una opción: ");

                opcion = sc.nextLine();

                switch (opcion) {
                	case "1":
                        System.out.println("Pausando hilo...");
                        h1.pausar();
                        break;

                    case "2":
                        System.out.println("Continuando hilo...");
                        h1.reanudar();
                        break;

                    case "3":
                        System.out.println("Terminando hilo...");
                        h1.interrupt(); 
                        h1.join();
                        System.out.println("Hilo terminado.");
                        break;

                    case "4":
                        System.out.println("\nContenido del arreglo:");
                        for (int i = 0; i < info.length; i++) {
                            System.out.println(i + ": " + info[i]);
                        }
                        break;

                    case "5":
                        System.out.println("\nEstado del hilo:");
                        System.out.println("Estado: " + h1.getState());
                        break;

                    case "6":
                        System.out.println("Saliendo del programa...");
                        salir = true;
                        break;

                    default:
                        System.out.println("Opción no válida.");

                }
                Thread.sleep(400);
            }
            sc.close();
    	} catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Indice fuera de rango.");
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido.");
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
	}
}
