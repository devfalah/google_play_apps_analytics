import models.App
import java.util.*

class Analyzer {

    fun calculateCountAppsDevelopedByGoogle(apps:List<App>): Int {
        return apps.filter { it.company.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            .trimStart().contains("Google") }.size
    }
    fun  calculatePercentageOfMedicalApps(apps:List<App>):Double{
        TODO("not implemented")
    }
    fun  getOldestApp(apps:List<App>):App?{
        TODO("not implemented")
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
