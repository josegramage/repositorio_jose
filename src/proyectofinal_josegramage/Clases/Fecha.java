package proyectofinal_josegramage.Clases;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import proyectofinal_josegramage.Main;
import proyectofinal_josegramage.Modulos.Clientes.Clases.DAOgenerico;

@XStreamAlias("Fecha")
public class Fecha implements Serializable {
	@XStreamAlias("fecha")
	public String fecha;
	@XStreamAlias("dia")
	public int dia;
	@XStreamAlias("mes")
	public int mes;
	@XStreamAlias("anyo")
	public int anyo;

	public SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        public String date;
        
        public Fecha(String date) {
        this.date = date;
    }
        
        
	public Fecha(String fecha, int dia, int mes, int anyo) {

		this.fecha = fecha;
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
	}

                
	public  String toString() {
		return fecha /* + ", dia=" + dia + ", mes=" + mes + ", anyo=" + anyo */;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public Fecha(String introducefecha, String i) {

		String[] SplitArray = null;

		SplitArray = introducefecha.split("/");

		this.dia = Integer.parseInt(SplitArray[0]);
		this.mes = Integer.parseInt(SplitArray[1]);
		this.anyo = Integer.parseInt(SplitArray[2]);

		this.fecha = introducefecha;

	}

	
        
        public String aStringFecha() {

		String fecha = null;

		if (Main.conf== null) {
			fecha = this.dia + "/" + this.mes + "/" + this.anyo;
		}
		else {
			if (Main.conf.getFormatoFecha()== "1") {
			fecha = this.dia + "/" + this.mes + "/" + this.anyo;	
		}else if (Main.conf.getFormatoFecha() == "2") {
			fecha = this.mes + "/" + this.dia + "/" + this.anyo;
		} else if (Main.conf.getFormatoFecha() == "3") {
			fecha = this.dia + "-" + this.mes + "-" + this.anyo;
		} else if (Main.conf.getFormatoFecha() == "4") {
			fecha = this.mes + "-" + this.dia + "-" + this.anyo;
		} else if (Main.conf.getFormatoFecha() == "5") {
			fecha = this.dia + "." + this.mes + "." + this.anyo;
		} else if (Main.conf.getFormatoFecha() == "6") {
			fecha = this.mes + "." + this.dia + "." + this.anyo;
		}
	}
		return fecha;
	}

       
        
	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public int comprobarDia() {
		GregorianCalendar calendar = new GregorianCalendar();
		int dias[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (calendar.isLeapYear(this.anyo)) {
			dias[2] = 29;
		}

		if ((this.dia >= 1) && (this.dia <= dias[this.mes])) {
			return this.dia;
		} else {
			return -1;
		}
	}

	public int comprobarMes() {
		if ((this.mes >= 1) && (this.mes <= 12)) {
			return this.mes;
		} else {
			return -1;
		}
	}

	public int comprobarAnyo() {
		if ((this.anyo >= 1900) && (this.anyo <= 2100)) {
			return this.anyo;
		} else {
			return -1;
		}
	}

	public static int dia(String fecha) {
		int dia = 0;
		String[] fecha1 = fecha.split("/");
		dia = Integer.parseInt(fecha1[0]);

		return dia;
	}

	public static int mes(String fecha) {
		int mes = 0;
		String[] fecha1 = fecha.split("/");
		mes = Integer.parseInt(fecha1[1]);

		return mes;
	}

	public static int anyo(String fecha) {
		int anyo = 0;
		String[] fecha1 = fecha.split("/");
		anyo = Integer.parseInt(fecha1[2]);

		return anyo;
	}

	public static Fecha muestraFecha(String fecha) {

		int dia = 0, mes = 0, anyo = 0;
		Fecha f = null;
		dia = Fecha.dia(fecha);
		mes = Fecha.mes(fecha);
		anyo = Fecha.anyo(fecha);

		f = new Fecha(fecha, dia, mes, anyo);

		return f;
	}
        
               
        
	public static Fecha fechaHoy() {

		Calendar fech = new GregorianCalendar();

		String fecha = "";
		int anyo = fech.get(Calendar.YEAR);
		int mes = fech.get(Calendar.MONTH)+1;
		int dia = fech.get(Calendar.DAY_OF_MONTH);
		Fecha f = new Fecha(fecha, dia, mes, anyo);

		return f;

	}

	public int restaFechas() {
		int resultado = 0;
		Calendar actual = Calendar.getInstance();
		int Adia = actual.get(Calendar.DATE);
		int Ames = actual.get(Calendar.MONTH) + 1;
		int Aanyo = actual.get(Calendar.YEAR);

		resultado = Aanyo - this.anyo;

		if (Ames < this.mes) {
			resultado = resultado - 1;
		} else if (Ames == this.mes) {
			if (Adia < this.dia) {
				resultado = resultado - 1;
			}
		}
		return resultado;
	}

	// para restar directamente

	public static int restaFechas(String mensaje) {

		String fecha = "";
		int dia = 0, mes = 0, anyo = 0, dif = 0;
		Fecha f = new Fecha(fecha, dia, mes, anyo);

		f = DAOgenerico.pedirFecha(null);
		dif = f.restaFechas();
		return dif;
	}

	public int compararFechas(Fecha f2) {
		int valor = 0;
		// 1 mayor
		// 0 igual
		// -1 menor
		if (this.anyo == f2.anyo) {
			if (this.mes == f2.mes) {
				if (this.dia > f2.dia) {
					valor = 1;

				} else if (this.dia == f2.dia) {
					valor = 0;

				} else {
					valor = -1;
				}
			} else if (this.mes < f2.mes) {
				valor = -1;
			} else {
				valor = 1;
			}
		} else if (this.anyo > f2.anyo) {
			valor = 1;
		} else {
			valor = -1;
		}
		return valor;
	}

	public int comparaFechas(Fecha fecha2) {

		Calendar cal1 = this.deStringToCalendar(fecha);
		Calendar cal2 = this.deStringToCalendar(fecha2.aStringFecha());

		if (cal1.before(cal2))
			return 1;
		else if (cal1.after(cal2))
			return 2;
		else
			return 3;
	}

	public Calendar deStringToCalendar(String fecha) {
		Date fechaDate = new Date();
		Calendar fechaCalendar = new GregorianCalendar();
		try {
			fechaDate = formato.parse(fecha);
			fechaCalendar.setTime(fechaDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaCalendar;
	}
}