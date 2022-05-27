import models.App
import java.io.File

class DataParser {
    fun getGooglePlayAppsFromCsv():List<App>{
        val googlePlayApps= mutableListOf<App>()
        val file= File("google_play.csv")
        file.forEachLine {
            val appData=it.split(",")
            googlePlayApps.add(App(
                name=appData[0],
                company = appData[1],
                category = appData[2],
                updatedAt = appData[3],
                size = appData[4],
                installsCount = appData[5].toLong(),
                currentVersion = appData[6],
                requiresAndroid = appData[7],
            ))

        }
        return  googlePlayApps
    }
}