package models
import java.time.LocalDate

data class App(
    val name: String,
    val company: String,
    val category: String,
    val updatedAt: LocalDate,
    val size: Double,
    val installsCount: Long,
    val currentVersion: String,
    val requiresAndroid: String,



) {}


