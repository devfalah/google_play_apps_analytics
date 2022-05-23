

fun main() {
    val dataParser=DataParser()
    val googlePlayApps=dataParser.getGooglePlayAppsFromCsv()
    googlePlayApps.forEach{ println(it.name) }

}