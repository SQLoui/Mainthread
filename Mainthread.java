import java.util.Scanner;

public class Mainthread
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] info = new String[30];
        Posicion pos = new Posicion();

		HiloEscribe h1 = new HiloEscribe(pos);
        h1.setInfo(info);
        h1.setIni(0);
        h1.setTmp(500);
		
		System.out.println("Iniciando hilo...");
        h1.start();

        System.out.println("\n Arreglo:");
        for (int i = 0; i < info.length; i++) {
        	System.out.println(i + ": " + info[i]);
        }
	}
}
