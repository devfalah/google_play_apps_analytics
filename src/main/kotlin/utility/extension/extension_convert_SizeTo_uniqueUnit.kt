package utility.extension

/**
 * convert app from String type to Double and convert it to unique unit
 * @return Double
 */

fun String.convertSizeToUniqueUnit(): Double {
    return when {
        this.contains("M") -> {
            this.dropLast(1).toDouble()
        }
        this.contains("G") -> {
            this.dropLast(1).toDouble() * 1024
        }
        else -> 0.0
    }
}
