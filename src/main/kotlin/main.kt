import models.App
import utility.PATH_FILE_GOOGLE_PLAY_CSV


fun main() {
    val readCSV = ReadCSV()
    val file = readCSV.readCSV(PATH_FILE_GOOGLE_PLAY_CSV)

    val dataSource: DataSource = DataParser()
   print( Analyzer().largestAppDevelopedSpecificCompany(dataSource.getAllApps(file)))

}

fun seeResultOfRequirements(apps:List<App>):String {
    val analyzer = Analyzer()
    var results = ""
    var lineNumber:String
    println("This is the work of a group of young programmers who have a lot of hope and imagination \nto imagine a big and bright future for themselves.so we would like to thank the hand that came to help us \nto put us on the right path that leads to that bright future.\nThank you Bariq <3 . " +
            "\nYou can inquire from the program about this following information : \n  ")

    val textOfRequirements = listOf(
        "1- how many apps were developed by Google in the dataset. \n, apps developed by Google\n",
        "2- the percentage of Medical apps. \n, percent of applications are medical applications\n",
        "3- what is the oldest app in the dataset. \n,\nOh my gosh this app is full of dust and spiderwebs\n",
        "4- the percentage of apps running on android 9 and up only. \n, percent of the apps running on android 9 and up only\n",
        "5- what are the largest 10 apps in the dataset. \n,\nOh my God these developers think people have Google servers on their phones\n",
        "6- what are the top 10 installed apps. \n,\nThese are my role models in life. I hope to become one of these applications one day\n",
        "7- Exit.\n"
    )
    while (true){
        for (it in textOfRequirements) print(it.split(',')[0])
        print("\nEnter the number to display the information -> ")
        lineNumber = readLine().toString()
        print("\nYou asked me about")
        when(lineNumber){
            "1" ->results = textOfRequirements[0].split(',')[0].drop(3) + (analyzer.countAppsDevelopedBySpecificCompany(apps,"google")).toString() + textOfRequirements[0].split(',')[1]
            "2" ->results = textOfRequirements[1].split(',')[0].drop(3) + (analyzer.findPercentageOfSpecificApp(apps,"medical")).toString() + textOfRequirements[1].split(',')[1]
//            "3"->results = textOfRequirements[2].split(',')[0].drop(3) + ("app name: ${analyzer.getOldestApp(apps)?.name} ,last update at:  ${analyzer.getOldestApp(apps)?.updatedAt}") + textOfRequirements[2].split(',')[1]
            "3"->results = textOfRequirements[2].split(',')[0].drop(3) + analyzer.getOldestApp(apps) + textOfRequirements[2].split(',')[1]
            "4"->results = textOfRequirements[3].split(',')[0].drop(3) + (analyzer.calculatePercentageOfAppsRunningOnSpecificVersion(apps,"9.1 and up")).toString()  + textOfRequirements[3].split(',')[1]
            "5"->{
                results += textOfRequirements[4].split(',')[0].drop(3)
                analyzer.getTopInstalledApps(apps,10).forEach(){
                    results +="app name: ${it.name} , app size ${it.size}M\n"
                }
                results += textOfRequirements[4].split(',')[1]
            }
            "6"->{
                results += textOfRequirements[5].split(',')[0].drop(3)
                analyzer.getTopInstalledApps(apps,10).forEach(){
                    results +="app name: ${it.name} , users installs the app for ${it.installsCount} times\n"
                }
                results += textOfRequirements[5].split(',')[1]
            }
            "7"-> { println(" . . . oh! Are you leaving me? \n . . . I love u <3 see u later \n . . . I'll be ready when you need me again \n \n")
                break
            }
            else -> {println(" nothing! You entered an incorrect number\n")
                results = ""
            }
        }
        if( results != "" ){
            print(" $results..Always at your service\n\n")
        }
    }

    return ""
}