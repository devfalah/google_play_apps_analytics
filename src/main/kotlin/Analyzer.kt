import models.App
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.round


class Analyzer {

    private val helper = Helper()
    fun CountAppsDevelopedBySpecificCompany(apps:List<App>,companyName:String)= apps.filter { it.company.contains(companyName) }.size



    fun  findPercentageOfSpecificApp(apps: List<App>,appType:String): Double? {
        if (apps.isEmpty() && appType.isEmpty()) return null
        val countSpecificApp = apps.filter { it.category == appType  }.size
        return helper.roundTo1Digit( countSpecificApp.toDouble() / apps.size * 100)
    }


    fun  getOldestApp(apps:List<App>)= apps.minByOrNull { SimpleDateFormat("MMMM dd yy").parse(it.updatedAt.trim()) }



    fun  calculatePercentageOfAppsRunningOnSpecificVersion(apps:List<App>):Double{
        var counter = 0.0
        if (apps.isEmpty()) return -1.0
        apps.forEach {
            if (it.requiresAndroid.trim() == "9 and up") {
                counter++
            }
        }
        return helper.roundTo1Digit((counter / apps.size)* 100)
    }



    fun  getLargestNApps(apps:List<App>,n:Int):List<App> {
        if (apps.isEmpty()) {
            return emptyList()
        }
        return apps.sortedByDescending { helper.convertSize(it.size) }.take(n)
    }



    fun  getTopInstalledApps(apps: List<App>,top:Int):List<App>{
        if (apps.isEmpty()){
            return emptyList()
        }
        if(apps.all { it.installsCount < 0 })  {
            return emptyList()
        }
        return apps.sortedByDescending { it.installsCount}.take(top)

    }
}
