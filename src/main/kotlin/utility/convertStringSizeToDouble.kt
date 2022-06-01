package utility

fun convertSizeToMegabyte(size: String): Double {
    return when {
        size.contains("M") -> {
            size.dropLast(1).toDouble()
        }
        size.contains("G") -> {
            size.dropLast(1).toDouble() * 1024
        }
        else -> 0.0
    }
}