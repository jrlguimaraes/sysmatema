package br.unesp.sysmatema.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class DataHoraUtil {
	
	public static Calendar toCalendar(String dataHora) throws Exception {

		Calendar calendar = Calendar.getInstance();

		// Separando dia e mes e ano+hora
		String[] split = dataHora.split("/");
		// Separando Ano e hora
		String[] split_year_time = split[2].split(" ");
		// Separando HORA e MINUTO
		String[] split_hora_min = split_year_time[1].split(":");

		try {
			// calendar.set(year, month, date, hourOfDay, minute, second);
			calendar.set(
					Integer.valueOf(split_year_time[0]),
					(Integer.valueOf(split[1]) - 1), // Começa com Mes em 0 a 11
					Integer.valueOf(split[0]),
					Integer.valueOf(split_hora_min[0]),
					Integer.valueOf(split_hora_min[1]));

		} catch (Exception e) {
			throw new Exception("Erro ao converter data. O formato deve ser: dd/MM/yyyy HH:mm");
		}
		return calendar;
	}
	
	public static String calendarToString(Calendar c) {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/YYYY HH:mm");
		return format1.format(c.getTime());
	}
	

	// http://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401

	/*
	 * ************* DATA INICIO ************* Calendar c1 = Calendar.getInstance();
	 * c1.set(Calendar.YEAR, 2014); c1.set(Calendar.MONTH, Calendar.SEPTEMBER);
	 * c1.set(Calendar.DAY_OF_MONTH, 22);
	 * 
	 * c1.set(Calendar.HOUR_OF_DAY, 13); c1.set(Calendar.MINUTE, 30);
	 * 
	 * ************ DATA TERMINO ************* Calendar c2 = Calendar.getInstance();
	 * c2.set(Calendar.YEAR, 2014); c2.set(Calendar.MONTH, Calendar.SEPTEMBER);
	 * c2.set(Calendar.DAY_OF_MONTH, 22);
	 * 
	 * c2.set(Calendar.HOUR_OF_DAY, 16); c2.set(Calendar.MINUTE, 45);
	 */


}
