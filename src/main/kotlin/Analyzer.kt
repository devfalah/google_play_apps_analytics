import models.App
import kotlin.math.round


class Analyzer {
    fun countAppsDevelopedBySpecificCompany(apps:List<App>,companyName:String): Int {
        return if ( apps.isNotEmpty() && companyName.isNotEmpty() ){
            apps.count { it.company.contains(companyName.trim()) }
        }
        else{
            -1
        }

    }




    fun  findPercentageOfSpecificApp(apps: List<App>,appType:String): Double {
        val countSpecificApp = apps.count { it.category.lowercase() == appType.lowercase().trim() }

        return if ( apps.isEmpty() && appType.isEmpty() ) -1.0
               else round( countSpecificApp.toDouble() / apps.size * 100)
    }



    /**
     * @return OldestApp in model app
     * @param apps<App>
     *
     */
    fun  getOldestApp(apps:List<App>): String? {
        return if(apps.isNotEmpty()) {
            apps.minByOrNull { it.updatedAt }!!.name
        } else null
    }




    fun  calculatePercentageOfAppsRunningOnSpecificVersion(apps:List<App>,version:String):Double{
        var counter = 0.0
        if (apps.isEmpty()) return -1.0
        apps.forEach {
            if (it.requiresAndroid.trim() == version) {
                counter++
            }
        }
        return round( counter / apps.size * 100) / 100
    }



    fun  getLargestApps(apps:List<App>,n:Int):List<App> = apps.sortedByDescending { it.size }.take(n)



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
