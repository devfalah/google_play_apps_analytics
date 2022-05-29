import models.App
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.round


class Analyzer {

    private val helper = Helper()
    fun calculateCountAppsDevelopedByGoogle(apps:List<App>): Int {
        return apps.filter { it.company.contains("Google") }.size
    }


    fun  calculatePercentageOfMedicalApps(apps: List<App>): Double? {
        if (apps.isEmpty()) return null
        val countOfMedicalApps = apps.filter { it.category.lowercase().trim() == "medical"  }.size

        return helper.roundTo1Digit( countOfMedicalApps.toDouble() / apps.size * 100)
    }


    fun  getOldestApp(apps:List<App>):App?{
        val formatter: DateFormat = SimpleDateFormat("MMMM dd yy")
        return apps.minByOrNull { formatter.parse(it.updatedAt.trim()) }
    }
    fun  calculatePercentageOfAppsRunningOnAndroid9AndUpOnly(apps:List<App>):Double{
        var counter = 0.0
        if (apps.isEmpty()) return -1.0
        apps.forEach {
            if (it.requiresAndroid.trim() == "9 and up") {
                counter++
            }
        }
        return helper.roundTo1Digit((counter / apps.size)* 100)
    }
    fun  getLargest10Apps(apps:List<App>):List<App> {
        if (apps.isEmpty()) {
            return emptyList()
        }
        return apps.sortedByDescending { helper.convertSize(it.size) }.take(10)
    }
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
