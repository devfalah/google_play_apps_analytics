import models.App
import utility.SetIndex
import utility.extension.convertSizeToUniqueUnit
import utility.extension.convertStringToDateObject
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
                name=appData[SetIndex.NAME],
                company = appData[SetIndex.COMPANY],
                category = appData[SetIndex.CATEGORY],
                updatedAt = appData[SetIndex.UPDATED_AT].convertStringToDateObject(),
                size = appData[SetIndex.SIZE].convertSizeToUniqueUnit(),
                installsCount = appData[SetIndex.INSTALLS_COUNT].toLong(),
                currentVersion = appData[SetIndex.CURRENT_VERSION],
                requiresAndroid = appData[SetIndex.REQUIRES_ANDROID],
                )
            )

        }
        return  googlePlayApps
    }
}