package models

import java.util.*

data class App(
    val name: String,
    val company: String,
    val category: String,
    val updatedAt: Date,
    val size: Double,
    val installsCount: Long,
    val currentVersion: String,
    val requiresAndroid: String,
) {}


