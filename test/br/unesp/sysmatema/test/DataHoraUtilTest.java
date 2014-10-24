package br.unesp.sysmatema.test;

import static org.junit.Assert.*;
import static br.unesp.sysmatema.util.DataHoraUtil.*;

import java.util.Calendar;

import org.junit.Test;

public class DataHoraUtilTest {

	@Test
	public void VerificaConversorDeStringParaData() {
		String data1 = "22/09/2014 13:30";
		String data2 = "22/09/2014 16:45";
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		try {
			c1 = toCalendar(data1);
			c2 = toCalendar(data2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(data1, calendarToString(c1));
		assertEquals(data2, calendarToString(c2));

		assertNotNull(c1);
		assertNotNull(c2);
	}

}
