package models

data class App(
    val name:String,
    val company:String,
    val category: String,
    val updatedAt:String,
    val size:String,
    val installsCount:Long,
    val currentVersion:String,
    val requiresAndroid:String,
){
    override fun equals(other: Any?): Boolean {
        return size.uppercase() == (other as App).size.uppercase()
    }
}

