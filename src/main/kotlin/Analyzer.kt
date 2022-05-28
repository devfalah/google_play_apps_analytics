import models.App
import kotlin.math.*


class Analyzer {

    private val helper = Helper()
    fun calculateCountAppsDevelopedByGoogle(apps:List<App>):Int{
        TODO("not implemented")
    }


    fun  calculatePercentageOfMedicalApps(apps: List<App>): Any? {
        if (apps.isEmpty()) return null
        var countMedicalApps = 0.0
        apps.forEach {
            if (  it.category.lowercase().trim() == "medical" )
                countMedicalApps++
        }
        return ( countMedicalApps / apps.size * 100).roundTo1Digit()
    }


    fun  getOldestApp(apps:List<App>):App?{
        TODO("not implemented")
    }
    fun  calculatePercentageOfAppsRunningOnAndroid9AndUpOnly(apps:List<App>):Double{
        var counter = 0.0
        if (apps.isEmpty()) return -1.0
       apps.forEach{
            if (it.requiresAndroid.trim() == "9 and up") {
                counter++
            }
           if (it.requiresAndroid=="9andup" || it.requiresAndroid== "9 andup" || it.requiresAndroid=="9and up") return -1.0
        }
        return ((counter / apps.size)* 100).roundTo1Digit()
    }
    fun  getLargest10Apps(apps:List<App>):List<App> {
        if (apps.isEmpty()) {
            return emptyList<App>();
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
    fun Double.roundTo1Digit(): Double = round(this * 10) / 10
}
