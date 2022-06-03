import models.App
import utility.SetIndex
import utility.extension.convertSizeToUniqueUnit
import utility.extension.convertStringDateToLocalDateObject
import java.io.File

class DataParser(): DataSource {

    /**
     * convert data from csv file to @sample App model
     * @return List<App>
     */
    private fun getGooglePlayAppsFromCsv(file: File): List<App> {
        val googlePlayApps = mutableListOf<App>()
        file.forEachLine {
            val appData = it.split(",")
            googlePlayApps.add(
                App(
                    name = appData[SetIndex.NAME],
                    company = appData[SetIndex.COMPANY],
                    category = appData[SetIndex.CATEGORY],
                    updatedAt = appData[SetIndex.UPDATED_AT].convertStringDateToLocalDateObject(),
                    size = appData[SetIndex.SIZE].convertSizeToUniqueUnit(),
                    installsCount = appData[SetIndex.INSTALLS_COUNT].toLong(),
                    currentVersion = appData[SetIndex.CURRENT_VERSION],
                    requiresAndroid = appData[SetIndex.REQUIRES_ANDROID],
                )
            )

        }
        return  googlePlayApps
    }

    override fun getAllApps(file: File): List<App> {
        return getGooglePlayAppsFromCsv(file)
    }
}