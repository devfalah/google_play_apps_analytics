package models

class App(
    val name:String,
    val company:String,
    var category: String?,
    var updatedAt:String,
    val size:String,
    val installsCount:Long,
    val currentVersion:String,
    val requiresAndroid:String,
)
