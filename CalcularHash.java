package examen;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
public class CalcularHash {
 
	public static void main(String[] args) {
		try {
			FileOutputStream fileout = new FileOutputStream("DATOS.DAT");
			ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
			MessageDigest md = MessageDigest.getInstance("SHA");
			String datos = "En un lugar de la Mancha de cuyo nombre no quiero acordarme, \n"
					+ "no ha mucho tiempo que vivía un hidalgo de los lanza en \n"
					+ "astillero, adarga antigua, rocín flaco y galgo corredor. Una olla \n"
					+ "de algo más vaca que carnero, salpicón las más noches, duelos y quebrantos \n"
					+ "los sábados, lantejas los viernes, algún palomino de añadidura \n"
					+ "los domingos, consumían las tres partes de su hacienda. El reso della \n "
					+ "concluían sayo de velarte, calzas de velludo para las fiestas con \n "
					+ "sus pantuflos de lo mismo, y los días de entresemana se honraba con su \n"
					+ "velloría de lo más fino";
			byte dataBytes[] = datos.getBytes();
			md.update(dataBytes);
			byte resumen [] = md.digest();
			dataOS.writeObject(datos);
			dataOS.writeObject(resumen);
			dataOS.close();
			fileout.close();
			System.out.println("Datos:" + datos);
			System.out.println("\n Resumen creado con éxito");
		
	}catch (IOException e) { e.printStackTrace();
 
	}catch(NoSuchAlgorithmException e) {e.printStackTrace();
 
	}
}
}
 