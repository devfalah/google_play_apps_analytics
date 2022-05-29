package models


data  class App(
    val name:String,
    val company:String,
    var category: String,
    var updatedAt:String,
    val size:String,
    val installsCount:Long,
    val currentVersion:String,
    var requiresAndroid:String,
) {
    override fun equals(other: Any?): Boolean {
        return size.uppercase() == (other as App).size.uppercase()
    }
}


