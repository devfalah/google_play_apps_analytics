
fun main() {


  val googlePlayApps = DataParser().getGooglePlayAppsFromCsv()

//  println(googlePlayApps[0].updatedAt)
  println(Analyzer().calculatePercentageOfMedicalApps(googlePlayApps))

}

