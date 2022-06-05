package utility.extension

import java.text.SimpleDateFormat
import java.util.*

/**
 * convert String to date
 * @return Date Object
 */

fun String.convertStringToDateObject(): Date {
    return SimpleDateFormat("MMMM d yyyy").parse(this)
}