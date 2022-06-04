import models.App
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Test
import utility.extension.convertSizeToUniqueUnit
import utility.extension.convertStringToDateObject


import kotlin.test.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AnalyzerTest {
    private lateinit var fakeApps :List<App>
    private lateinit var analyzer: Analyzer

    @BeforeAll
    fun setup() {
        this.analyzer = Analyzer()
    }

    @BeforeEach
    fun initial(){
        fakeApps = FakeData().fakeApps
    }



    //test fun_2
    @Test
    fun should_ReturnPercentageAppsOfSpecificCategory_when_CategoryNameIsValid(){
        //given
        //when calculate the percentage of valid category name
        val result = analyzer.findPercentageOfSpecificApp(fakeApps,"Medical")
        //then find the result
        assertEquals(25.0,result)
}



    //test fun_2
    @Test
    fun should_ReturnZero_when_calculateThePercentageOfNotValidCategoryName(){
        //given
        // when calculate the percentage of Not valid category name
        val result = analyzer.findPercentageOfSpecificApp(fakeApps,"AliZainy")
        //then find the result
        assertEquals(0.0,result)
    }



    //test fun_2
    @Test
    fun should_ReturnZero_when_CategoryIsBlankString(){
        //given
        //when calculate empty category
        val result = analyzer.findPercentageOfSpecificApp(fakeApps,"")
        //then find the result
        assertEquals(0.0,result)
    }



    //test fun_2
    @Test
    fun should_ReturnPercentageAppsOfSpecificCategory_when_CategoryIsUpperOrLowerCase(){
        //given
        //when calculate the percentage of category name with upper or lower case
        val result = analyzer.findPercentageOfSpecificApp(fakeApps,"MEDICAL")
        //then find the result
        assertEquals(25.0,result)
    }



    //test fun_2
    @Test
    fun should_ReturnPercentageAppsOfSpecificCategory_when_CategoryNameWithSpaces(){
        //given
        //when calculate the percentage of category name with spaces
        val result = analyzer.findPercentageOfSpecificApp(fakeApps," Medical ")
        //then find the result
        assertEquals(25.0,result)
    }



    //test fun_2
    @Test
    fun should_ReturnNan_when_ListOfFakeAppsIsEmpty(){
        //given
        fakeApps= listOf()
        //when calculate the percentage of category name
        val result = analyzer.findPercentageOfSpecificApp(fakeApps," Medical ")
        //then find the result
        assertEquals(Double.NaN,result)
    }



    //test fun_6
    @Test
    fun should_ReturnTopAppInstall_When_ItHasValidData() {
        //given fake data from our class FakeData as list call fakeApps
        val appList =  fakeApps
        //when search for top 3 apps installed
        val result = analyzer.getTopInstalledApps(apps = appList, top = 3)
        //then should return that order of top 3 installed apps
        val topThreeApps = listOf(
            App(
                name = "App 7",
                company = "WhatsApp LLC",
                category = "Communication",
                updatedAt = "May 9 2022".convertStringToDateObject(),
                size = "800M".convertSizeToUniqueUnit(),
                installsCount = 5000000000,
                currentVersion = "2.22.10.73",
                requiresAndroid = "4.1 and up",
            ),
            App(
                name = "App 17",
                company = "WhatsApp LLC",
                category = "Communication",
                updatedAt = "May 9 2022".convertStringToDateObject(),
                size = "800M".convertSizeToUniqueUnit(),
                installsCount = 5000000000,
                currentVersion = "2.22.10.73",
                requiresAndroid = "4.1 and up",
            ),
            App(
                name = "App 18",
                company = "Game Insight",
                category = "Action",
                updatedAt = "May 12 2022".convertStringToDateObject(),
                size = "1.1G".convertSizeToUniqueUnit(),
                installsCount = 50000000,
                currentVersion = "30.0.271",
                requiresAndroid = "5.0 and up",
            )

        )
        assertEquals(topThreeApps, result)
    }

    //test fun_6
    @Test
    fun should22_ReturnTopAppInstall_When_ItHasLessDataThanRequired() {
        //given valid list of data consisting of three objects
        val apps = listOf(
                App(
                    name = "App 7",
                    company = "WhatsApp LLC",
                    category = "Communication",
                    updatedAt = "May 9 2022".convertStringToDateObject(),
                    size = "800M".convertSizeToUniqueUnit(),
                    installsCount = 5000000000,
                    currentVersion = "2.22.10.73",
                    requiresAndroid = "4.1 and up",
                ),
                App(
                    name = "App 17",
                    company = "WhatsApp LLC",
                    category = "Communication",
                    updatedAt = "May 9 2022".convertStringToDateObject(),
                    size = "800M".convertSizeToUniqueUnit(),
                    installsCount = 5000000000,
                    currentVersion = "2.22.10.73",
                    requiresAndroid = "4.1 and up",
                ),
                App(
                    name = "App 18",
                    company = "Game Insight",
                    category = "Action",
                    updatedAt = "May 12 2022".convertStringToDateObject(),
                    size = "1.1G".convertSizeToUniqueUnit(),
                    installsCount = 50000000,
                    currentVersion = "30.0.271",
                    requiresAndroid = "5.0 and up",
                )
        )
        //when fined top 10 app install
        val result = analyzer.getTopInstalledApps(apps = apps, top = 10)
        //then should return this list apps data
        val topThreeApps = listOf(
            App(
                name = "App 7",
                company = "WhatsApp LLC",
                category = "Communication",
                updatedAt = "May 9 2022".convertStringToDateObject(),
                size = "800M".convertSizeToUniqueUnit(),
                installsCount = 5000000000,
                currentVersion = "2.22.10.73",
                requiresAndroid = "4.1 and up",
            ),
            App(
                name = "App 17",
                company = "WhatsApp LLC",
                category = "Communication",
                updatedAt = "May 9 2022".convertStringToDateObject(),
                size = "800M".convertSizeToUniqueUnit(),
                installsCount = 5000000000,
                currentVersion = "2.22.10.73",
                requiresAndroid = "4.1 and up",
            ),
            App(
                name = "App 18",
                company = "Game Insight",
                category = "Action",
                updatedAt = "May 12 2022".convertStringToDateObject(),
                size = "1.1G".convertSizeToUniqueUnit(),
                installsCount = 50000000,
                currentVersion = "30.0.271",
                requiresAndroid = "5.0 and up",
            )
        )

        assertEquals(topThreeApps, result)
    }

    //test fun_6
    @Test
    fun should_ReturnEmptyList_When_TheListIsEmpty() {
        //liven empty list
        fakeApps = listOf()
        //when search for find top ten app Install
        val result = analyzer.getTopInstalledApps(apps = fakeApps , top = 10)
        //then should return empty list
        assertEquals(listOf(), result)
    }

    //test fun_6
    @Test
    fun should_ReturnEmptyList_When_TheEnterNumberOfAppsIsZero() {
        //given fake data from our class FakeData as list call fakeApps
        val appList =  fakeApps
        //when search for top 3 app install
        val result = analyzer.getTopInstalledApps(apps = appList, top =  0)
        //then should return empty list
        assertEquals(listOf(), result)
    }

    //test fun_6
    @Test
    fun should_ReturnEmptyList_When_AppsNumberIsNegative() {
        //given fake data from our class FakeData as list call fakeApps
        val appList =  fakeApps
        //when search for top 3 app install
        val result = analyzer.getTopInstalledApps(apps = appList, top =  -1)
        //then should return empty list
        assertEquals(listOf(), result)
    }

}
