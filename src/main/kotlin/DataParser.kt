import models.App
import utility.extension.convertSizeToUniqueUnit
import utility.extension.convertStringDateToLocalDateObject
import java.io.File

class DataParser {

    /**
     * convert data from csv file to @sample App model
     * @return List<App>
     */
    fun getGooglePlayAppsFromCsv():List<App>{
        val googlePlayApps= mutableListOf<App>()
        val file= File("assets/google_play.csv")
        file.forEachLine {
            val appData=it.split(",")
            googlePlayApps.add(
                App(
                name=appData[0],
                company = appData[1],
                category = appData[2],
                updatedAt = appData[3].convertStringDateToLocalDateObject(),
                size = appData[4].convertSizeToUniqueUnit(),
                installsCount = appData[5].toLong(),
                currentVersion = appData[6],
                requiresAndroid = appData[7],
                )
            )

        }
        return  googlePlayApps
    }
}