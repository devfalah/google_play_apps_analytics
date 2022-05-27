import models.App
import kotlin.math.*


class Analyzer {

    fun calculateCountAppsDevelopedByGoogle(apps:List<App>):Int{
        TODO("not implemented")
    }
    fun  calculatePercentageOfMedicalApps(apps:List<App>):Double{
        TODO("not implemented")
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
    fun  getLargest10Apps(apps:List<App>):List<App>{
        TODO("not implemented")
    }
    fun  getTop10InstalledApps(apps:List<App>):List<App>{
        TODO("not implemented")
    }
    fun Double.roundTo1Digit(): Double = round(this * 10) / 10
}
