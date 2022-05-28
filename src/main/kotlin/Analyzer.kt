import models.App

class Analyzer {

    var helper = Helper()
    fun calculateCountAppsDevelopedByGoogle(apps:List<App>):Int{
        TODO("not implemented")
    }

     ///calculate the percentage of Medical Apps
    fun  calculatePercentageOfMedicalApps(apps: List<App>): Any? {
        if (apps.isEmpty()) return null
        var countMedicalApps = 0.0
        apps.forEach {
            if (  it.category?.lowercase()?.trim() == "medical" )
                countMedicalApps++
        }
        return String.format("%.1f", countMedicalApps / apps.size * 100).toDouble()
    }


    fun  getOldestApp(apps:List<App>):App?{
        TODO("not implemented")
    }
    fun  calculatePercentageOfAppsRunningOnAndroid9AndUpOnly(apps:List<App>):Double{
        TODO("not implemented")
    }
    fun  getLargest10Apps(apps:List<App>):List<App> {
        if (apps.isEmpty()) {
            return emptyList<App>();
        }
        return apps.sortedByDescending { helper.convertSize(it.size) }.take(10)
    }
    fun  getTop10InstalledApps(apps: List<App>):List<App>{
        if (apps.isEmpty()||apps.size<10){
            return emptyList<App>()
        }

        if(apps.all { it.installsCount < 0 })  {
            return emptyList()
        }
        return apps.sortedByDescending { it.installsCount}.take(10)

    }
}
