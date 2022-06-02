package utility.extension

import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * convert String date to LocalDate Object
 * @return LocalDate
 */

fun String.convertStringDateToLocalDateObject(): LocalDate {
    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMMM d yyyy")
    return LocalDate.parse(this, formatter)
}