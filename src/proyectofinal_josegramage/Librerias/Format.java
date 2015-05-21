package proyectofinal_josegramage.Librerias;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;


public class Format {
	
	// 1 decimal
	public static String format1d(double number){
		DecimalFormat format1 = new DecimalFormat(".0");
		return format1.format(number);
	}
	
	// 2 decimales
	public static String format2d(double number){
		DecimalFormat format1 = new DecimalFormat(".00");
		return format1.format(number);
	}
	
	// 3 decimales
	public static String format3d(double number){
		DecimalFormat format1 = new DecimalFormat(".000");
		return format1.format(number);
	}
	
	// redondea
	public static String dosDecimalesRedondea(double num){//2.315f
		DecimalFormat format2 = new DecimalFormat("00.00");
		float f = (float)num;
		return(format2.format(f));//02,32
	}
	
	//  Euro 
	public static String FormatEuro(double moneda){
		NumberFormat coin=NumberFormat.getCurrencyInstance( Locale.FRANCE );
		return coin.format(moneda);
	}
}