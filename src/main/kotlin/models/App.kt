package models


data  class App(
    val name:String,
<<<<<<< HEAD
    val company:String,
    var category: String,
=======
    var company:String,
    val category: String,
>>>>>>> 291d12f2c86844399115468bc42e498573eef40e
    var updatedAt:String,
    val size:String,
    val installsCount:Long,
    val currentVersion:String,
    val requiresAndroid:String,
){
    override fun equals(other: Any?): Boolean {
        return size.uppercase() == (other as App).size.uppercase()
    }
}

