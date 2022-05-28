import models.App
import java.text.DateFormat
import java.text.SimpleDateFormat

class Analyzer {

    fun calculateCountAppsDevelopedByGoogle(apps:List<App>):Int{
        TODO("not implemented")
    }
    fun  calculatePercentageOfMedicalApps(apps:List<App>):Double{
        TODO("not implemented")
    }
    fun  getOldestApp(apps:List<App>):App?{
        val formatter: DateFormat = SimpleDateFormat("MMMM dd yy")
        return apps.minByOrNull { formatter.parse(it.updatedAt) }
    }
    fun  calculatePercentageOfAppsRunningOnAndroid9AndUpOnly(apps:List<App>):Double{
        TODO("not implemented")
    }
    fun  getLargest10Apps(apps:List<App>):List<App>{
        TODO("not implemented")
    }
    fun  getTop10InstalledApps(apps:List<App>):List<App>{
        TODO("not implemented")
    }
}
