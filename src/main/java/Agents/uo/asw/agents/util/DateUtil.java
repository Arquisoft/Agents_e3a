package Agents.uo.asw.agents.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * Clase de utilidad para fechas
 *
 */
public class DateUtil {

	/**
	 * Calcula la edad a patir de la fecha de nacimiento
	 * @param fechaNacimiento
	 * @return anyos de la persona
	 */
	public static int getYears(Date fechaNacimiento) {
		Calendar cc = Calendar.getInstance();
		cc.setTime(fechaNacimiento);
		LocalDate birthdate = LocalDate.of(cc.get(Calendar.YEAR), cc.get(Calendar.MONTH) + 1, cc.get(Calendar.DAY_OF_MONTH));
		LocalDate now = LocalDate.now();
		Long years = ChronoUnit.YEARS.between(birthdate, now);
		return years.intValue();
	}
}
