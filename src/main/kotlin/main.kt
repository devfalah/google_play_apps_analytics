import models.App


fun main() {
    val googlePlayApps=DataParser().getGooglePlayAppsFromCsv()
        seeResultOfRequirements(googlePlayApps)


}


fun seeResultOfRequirements(apps:List<App>):String {
    val analyzer = Analyzer()
    var results = ""
    var lineNumber:String
    var keepGoing:String
    println("This is the work of a group of young programmers who have a lot of hope and imagination \nto imagine a big and bright future for themselves.so we would like to thank the hand that came to help us \nto put us on the right path that leads to that bright future.\nThank you Bariq <3 . ")
    println("You can inquire from the program about this following information : \n")

    while (true){
        val textOfRequirements = listOf(
            "1- how many apps were developed by Google in the dataset. \n, apps developed by Google\n",
            "2- the percentage of Medical apps. \n, percent of applications are medical applications\n",
            "3- what is the oldest app 10 in the dataset \n,\nOh my gosh these apps are full of dust and spiderwebs\n",
            "4- the percentage of apps running on android 9 and up only. \n, percent of the apps running on android 9 and up only\n",
            "5- what are the largest 10 apps in the dataset \n,\nOh my God these developers think people have Google servers on their phones\n",
            "6- what are the top 10 installed apps. \n,\nThese are my role models in life. I hope to become one of these applications one day\n"
        )
        for (it in textOfRequirements) print(it.split(',')[0])

        print("\nEnter the number to display the information -> ")
        lineNumber = readLine().toString()
        print("\nYou asked me about")
        when(lineNumber){
            "1" ->results = textOfRequirements[0].split(',')[0].drop(3) + (analyzer.countAppsDevelopedBySpecificCompany(apps,"google")).toString() + textOfRequirements[0].split(',')[1]
            "2" ->results = textOfRequirements[1].split(',')[0].drop(3) + (analyzer.findPercentageOfSpecificApp(apps,"medical")).toString() + textOfRequirements[1].split(',')[1]
            "3"->results = textOfRequirements[2].split(',')[0].drop(3) + (analyzer.getOldestApp(apps)).toString()  + textOfRequirements[2].split(',')[1]
            "4"->results = textOfRequirements[3].split(',')[0].drop(3) + (analyzer.calculatePercentageOfAppsRunningOnSpecificVersion(apps,"9.1 and up")).toString()  + textOfRequirements[3].split(',')[1]
            "5"->results = textOfRequirements[4].split(',')[0].drop(3) + (analyzer.getLargestApps(apps,10)).toString()  + textOfRequirements[4].split(',')[1]
            "6"->results = textOfRequirements[5].split(',')[0].drop(3) + (analyzer.getTopInstalledApps(apps,10)).toString()  + textOfRequirements[5].split(',')[1]
            else -> println(" nothing! You entered an incorrect number\n")
        }
        print(" $results  \n..Always at your service, Do you want to ask me again?[y/n] ->")
        keepGoing = readLine().toString()
        when {
            keepGoing.lowercase() == "n" -> {
                println(" . . . oh! Are you leaving me? \n . . . I love u <3 see u later \n . . . I'll be ready when you need me again \n \n")
                break
            }
            keepGoing.lowercase() == "y" -> {
                println("I like how excited you are...let's go\n")
            }
            else -> {
                println("WTF...I'm assuming you want to ask me again\n")
            }
        }
    }

    return ""
}