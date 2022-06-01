package utility

import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * convert String date to LocalDate Object
 * @required String date
 * @return LocalDate
 */

fun convertStringDateToLocalDateObject(date: String): LocalDate {
    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMMM d yyyy")
    return LocalDate.parse(date, formatter)
}