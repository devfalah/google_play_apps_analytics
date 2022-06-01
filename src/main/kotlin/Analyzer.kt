import models.App
import kotlin.math.round


class Analyzer {
    fun calculateCountAppsDevelopedByGoogle(apps:List<App>): Int {
        return apps.filter { it.company.contains("Google") }.size
    }


    fun  calculatePercentageOfMedicalApps(apps: List<App>): Double? {
        if (apps.isEmpty()) return null
        val countOfMedicalApps = apps.filter { it.category.lowercase().trim() == "medical"  }.size

        return round( countOfMedicalApps.toDouble() / apps.size * 100) / 100
    }

    /**
     * @return OldestApp in model app
     * @param apps<App>
     *
     */
    fun  getOldestApp(apps:List<App>): App?  = apps.minByOrNull { it.updatedAt }


    fun  calculatePercentageOfAppsRunningOnAndroid9AndUpOnly(apps:List<App>):Double{
        var counter = 0.0
        if (apps.isEmpty()) return -1.0
        apps.forEach {
            if (it.requiresAndroid.trim() == "9 and up") {
                counter++
            }
        }
        return round( counter / apps.size * 100) / 100
    }
    fun  getLargest10Apps(apps:List<App>):List<App> = apps.sortedByDescending { it.size }.take(10)

    fun  getTop10InstalledApps(apps: List<App>):List<App>{
        if (apps.isEmpty()||apps.size<10){
            return emptyList()
        }

        if(apps.all { it.installsCount < 0 })  {
            return emptyList()
        }
        return apps.sortedByDescending { it.installsCount}.take(10)

    }


}
