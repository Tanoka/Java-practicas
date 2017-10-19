package basic;

// import java.util.Date;
// import java.util.Calendar;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

class Dates {
	static public void main(String args[]) {
		Date fecha = new Date();

		System.out.println("Fecha de hoy: "+fecha);

		long msec = fecha.getTime();
		System.out.println("Milliseconds since Jan. 1, 1970 GMT = " + msec);


		//Comparar una fecha string, de una base de datos, formulario, etc.. 
		//con el momento actual
		String cadenaFecha = "09/11/2017 13:54:12";
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			Date fechaForm = inputFormat.parse(cadenaFecha);
			System.out.println("Fecha formulario: "+fechaForm);
	                if (fechaForm.after(fecha)) {
        	               System.out.println("Fecha string es mayor que fecha actual");
			} else if(fechaForm.before(fecha)) {
                               System.out.println("Fecha string es menor que fecha actual");
                        } 	      

		} catch (ParseException ex) {
			System.err.println("ParseException: " + ex.getMessage());
		}


		//Presentar una fecha con otros formatos
		GregorianCalendar calendarDate = new GregorianCalendar(2012, 7, 14, 23, 56);
		Date date4 = calendarDate.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("EE dd MMM yyyy hh:mm a");
		System.out.println("Formatos: "+dateFormat.format(date4));


		//Comparar fechas más antiguas que 1970..no se puede usar Date
		GregorianCalendar calendar1 = new GregorianCalendar(1213, 7, 14);
		GregorianCalendar calendar2 = new GregorianCalendar(1482, 12, 25);
		if (calendar1.before(calendar2)) {
			System.out.println("Comparando calendars, calendar1 es antes: "+calendar1.get(Calendar.YEAR));
		}
		//Incrementar una fecha Calendar en n meses años, etc..
		calendar2.add(Calendar.MONTH, 6);
		System.out.println("Sumo meses a un calendar con add, mes: "+calendar2.get(Calendar.MONTH)+ " año: "+calendar2.get(Calendar.YEAR));

		//Métodos: get, set, getTime, getInstance,getTimeZone...
		Calendar calendario = Calendar.getInstance();

		System.out.println("Calendar mes: "+calendario.get(Calendar.MONTH));
		System.out.println("Calendar año: "+calendario.get(Calendar.YEAR));

		calendario.set(Calendar.HOUR, 13);
		System.out.println("Calendar nueva hora: "+calendario.get(Calendar.HOUR));

		//Date. Clase que representa un instante en el tiempo, en milisegundos. A partir de 1970
		//
		//DateFormat (abstract), SimpleDateFormat - java.text.*
		//	A class for formatting and parsing dates in a locale-sensitive manner. 
		//
		//Calendar (abstract), GregorianCalendar
		//	provides the standard calendar system used by most of the world.
		//
		//TimeZone (abstract), SimpleTimeZone
		//	
		//Locale
		//
		//JAVA 8:
		//java.time.*
		// DateTimeFormatter, LocalDate, LocalDateTime, ZoneDateTime, Instant, ....

	}

}
