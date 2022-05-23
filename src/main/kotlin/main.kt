

fun main() {

    val googlePlayApps=DataParser().getGooglePlayAppsFromCsv()
    googlePlayApps.forEach{ println(it.name) }

}