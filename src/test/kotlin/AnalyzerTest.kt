<<<<<<< HEAD

=======
>>>>>>> 291d12f2c86844399115468bc42e498573eef40e
import models.App
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance


import kotlin.test.assertEquals
import kotlin.test.assertNull


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AnalyzerTest {
    private val fakeApps = FakeData().fakeApps
    private lateinit var analyzer: Analyzer





    @BeforeAll
    fun setup() {
        this.analyzer = Analyzer()
    }

    // Test Cases for : ((getOldestApp method))
    //=========================================
    @Test
    fun should_ReturnOldestApp_When_ListOfAppsIsCorrect() {
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(fakeApps)
        // then
        assertEquals(fakeApps[1], oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DateFormatHasNoSpace() {
        // given list of apps
        val newFakeApps = fakeApps.toMutableList()
        newFakeApps[4].updatedAt = "May152020"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null, oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DateFormatHasOneLeftSpace() {
        // given list of apps
        val newFakeApps = fakeApps.toMutableList()
        newFakeApps[4].updatedAt = "May 152020"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null, oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DateFormatHasOneRightSpace() {
        // given list of apps
        val newFakeApps = fakeApps.toMutableList()
        newFakeApps[2].updatedAt = "March18 2022"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null, oldestApp)
    }

    @Test
    fun should_ReturnNull_When_MonthIsAnumber() {
        // given list of apps
        val newFakeApps = fakeApps.toMutableList()
        newFakeApps[2].updatedAt = "6 10 2022"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null, oldestApp)
    }

    @Test
    fun should_ReturnNull_When_MonthNotCapitalized() {
        // given list of apps
        val newFakeApps = fakeApps.toMutableList()
        newFakeApps[5].updatedAt = "march 19 2021"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null, oldestApp)
    }

    @Test
    fun should_ReturnNull_When_MonthMisspelled() {
        // given list of apps
        val newFakeApps = fakeApps.toMutableList()
        newFakeApps[1].updatedAt = "Arpil 10 2022"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null, oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DayIsLessThan_1() {
        // given list of apps
        val newFakeApps = fakeApps.toMutableList()
        newFakeApps[1].updatedAt = "June 0 2022"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null, oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DayIsGreaterThan_31() {
        // given list of apps
        val newFakeApps = fakeApps.toMutableList()
        newFakeApps[6].updatedAt = "Arpil 35 2022"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null, oldestApp)
    }

    @Test
    fun should_ReturnNull_When_YearLessThan2008() {
        // given list of apps
        val newFakeApps = fakeApps.toMutableList()
        newFakeApps[7].updatedAt = "Arpil 10 2006"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null, oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DateFormatIsReversed() {
        // given list of apps
        val newFakeApps = fakeApps.toMutableList()
        newFakeApps[7].updatedAt = "2020 10 Arpil"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null, oldestApp)
    }

    @Test
    fun should_ReturnNull_When_MonthReversedWithDay() {
        // given list of apps
        val newFakeApps = fakeApps.toMutableList()
        newFakeApps[7].updatedAt = "10 Arpil 2020"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null, oldestApp)
    }

<<<<<<< HEAD

    @Test
    fun shouldReturn_Correct10LargestApp_WhenHaveCorrectData () {
        // given list of apps
        val apps = fakeApps
        // when sort apps descending
        val sortedApps = analyzer.getLargest10Apps(apps).take(2)
        val exceptedApps = listOf(
           fakeApps[4],
           fakeApps[17]
        )
        // then
        assertEquals(exceptedApps, sortedApps)
    }

    @Test
    fun shouldReturn_Correct10LargestApp_WhenHaveSizeSymbolINAnyLetterCases () {
        // given list of apps
        val apps = listOf(
            App(
                name = "App 5",
                company = "Weedmaps",
                category = "Medical",
                updatedAt = "March 4 2022",
                size = "1.1g",
                installsCount = 1800000,
                currentVersion = "7.0.2",
                requiresAndroid = "5.0 and up",

                ),
            App(
                name = "App 18",
                company = "Game Insight",
                category = "Action",
                updatedAt = "May 12 2022",
                size = "1.1g",
                installsCount = 50000000,
                currentVersion = "30.0.271",
                requiresAndroid = "5.0 and up",

                ))
        // when sort apps descending
        val sortedApps = analyzer.getLargest10Apps(apps).take(2)
        val exceptedApps = listOf(
            fakeApps[17],
            fakeApps[4])
        // then
        assertEquals(exceptedApps, sortedApps)
    }

    @Test
    fun shouldReturn_Correct10LargestApp_WhenSizeWithoutNumericValue() {
        // given list of apps
        val apps = listOf(
           App( name = "App 16",
            company = "Craigpark Limited",
            category = "Productivity",
            updatedAt = "April 17 2022",
            size = "Varies with device",
            installsCount = 1000000,
            currentVersion = "5.3.5",
            requiresAndroid = "5.0 and up"),
            App(
                name = "App 5",
                company = "Weedmaps",
                category = "Medical",
                updatedAt = "March 4 2022",
                size = "1.1G",
                installsCount = 1800000,
                currentVersion = "7.0.2",
                requiresAndroid = "5.0 and up",

                ))
        // when sort apps descending
        val sortedApps = analyzer.getLargest10Apps(apps).take(2)
        val exceptedApps = listOf(
            fakeApps[4],
            fakeApps[15])
        // then
        assertEquals(exceptedApps.first().size, sortedApps.first().size)
    }

    @Test
    fun shouldReturnEmpty10LargestList_When_HaveEmptyAppList () {
        // given empty list
        val apps = listOf<App>()
        // when sort apps descending
        val resultApps = analyzer.getLargest10Apps(apps)
        // then return empty list
        assertEquals(emptyList(), resultApps)
    }




    @Test
    fun should_returnCorrectValue_When_GiveCorrect() {
        //give
        val apps = fakeApps
        //when
        val result = analyzer.getTop10InstalledApps(apps).take(10)
        println(result[0].name)
        val exceptedAPPS = listOf(
            fakeApps[6],
            fakeApps[16],
            fakeApps[17],
            fakeApps[10],
            fakeApps[5],
            fakeApps[8],
            fakeApps[18],
            fakeApps[4],
            fakeApps[9],
            fakeApps[11]

        )
        //then
        assertEquals(exceptedAPPS, result)

    }

    @Test
    fun should_returnEmpty_When_EmptyList() {
        //give
        val apps = listOf<App>()
        //when
        val result = analyzer.getTop10InstalledApps(apps)
        //then
        assertEquals(emptyList(), result)

    }

    @Test
    fun should_returnNull_When_TheListLessThan10() {
        //give
        val apps = listOf(App(
            name = "App 19",
            company = "TIMEFLIK (ex MR TIME)",
            category = "Personalization",
            updatedAt = "December 15 2021",
            size = "4.7M",
            installsCount = 5000000,
            currentVersion = "10, 1.0.0",
            requiresAndroid = "9 and up",

            ))
        //when
        val result = analyzer.getTop10InstalledApps(apps).take(10)

        //then
        assertEquals(emptyList(), result)


    }
    @Test
    fun should_returnNull_When_GiveNegativeValue() {
        //give
        val apps = listOf(App(
            name = "App 19",
            company = "TIMEFLIK (ex MR TIME)",
            category = "Personalization",
            updatedAt = "December 15 2021",
            size = "4.7M",
            installsCount = -5000000,
            currentVersion = "10, 1.0.0",
            requiresAndroid = "9 and up",

            ))
        //when
        val result = analyzer.getTop10InstalledApps(apps).take(10)

        //then
        assertEquals(emptyList(), result)

    }






    //   Test Cases End
    //=========================================


    // Test Cases for : ((calculatePercentageOfMedicalApps method))
    //=========================================
    @Test
    fun should_ReturnPercentageOfMedicalAppsValue_when_ListOfAppsIsCorrect() {
        //give correct list

        //when calculate the percentage of Medical Apps
        val percentage = analyzer.calculatePercentageOfMedicalApps(fakeApps)
        //then check the result
         assertEquals(25.0, percentage)
    }
    @Test
    fun should_ReturnPercentageOfMedicalAppsValue_when_MedicalIsLowercase() {
        //give category lowercase
        fakeApps[1].category = "medical"
        //when calculate the percentage of Medical Apps
        val percentage = analyzer.calculatePercentageOfMedicalApps(fakeApps)
        //then check the result
        assertEquals(25.0, percentage)
    }
    @Test
    fun should_ReturnPercentageOfMedicalAppsValue_when_CategoryIsUppercase() {
        //give category upercase
        fakeApps[1].category = "MEDICAL"
        //when calculate the percentage of Medical Apps
        val percentage = analyzer.calculatePercentageOfMedicalApps(fakeApps)
        //then check the result
        assertEquals(25.0, percentage)
    }
    @Test
    fun should_ReturnPercentageOfMedicalAppsValue_when_CategoryHaveSpace() {
        //give  category have space
        fakeApps[1].category = "  Medical "
       // fakeApps[1].category = "Medical "
       // fakeApps[1].category = " Medical"
        //when calculate the percentage of Medical Apps
        val percentage = analyzer.calculatePercentageOfMedicalApps(fakeApps)
        //then check the result
        assertEquals(25.0, percentage)
    }

    @Test
    fun should_ReturnNull_when_ListIsEmpty() {
        //give empty list
        //when calculate the percentage of Medical Apps
        val percentage = analyzer.calculatePercentageOfMedicalApps(emptyList())
        //then check the result

        assertNull(percentage)
    }
    //   Test Cases End
    //=========================================
}
=======
    // Test Cases for : ((getNumberOfAppsDevByGoogle))
    //=========================================

    @Test
    fun should_ReturnZero_When_EmptyList() {
        // given list
      // var listCompany = listOf<App>(fakeApps[4], fakeApps[17])
        var listCompany = listOf<App>()
        // when searching for a company
        var numOfAppDev = analyzer.calculateCountAppsDevelopedByGoogle(listCompany)
        // then check
        assertEquals(0, numOfAppDev)
    }

    @Test
    fun should_ReturnZero_When_NotFindCompane() {
   var listCompany = listOf<App>(
    fakeApps[2],fakeApps[3],fakeApps[4],fakeApps[5])
        // when searching for a company
        val numOfAppDev = analyzer.calculateCountAppsDevelopedByGoogle(listCompany)
        // then check
        assertEquals(0, numOfAppDev)
    }

    @Test
    fun should_ReturnOne_When_FindOneCompany() {
        var listCompany = listOf<App>(
            fakeApps[0],fakeApps[6])
        // when searching for company
        val numOfAppDev = analyzer.calculateCountAppsDevelopedByGoogle(listCompany)
        // then check
        assertEquals(1, numOfAppDev)
    }

    @Test
    fun should_ReturnOne_When_FindOneCompanyLowercase() {
        var listCompany = listOf<App>(
            fakeApps[15],fakeApps[6])
        // when searching for company
        val numOfAppDev = analyzer.calculateCountAppsDevelopedByGoogle(listCompany)
        // then check
        assertEquals(1, numOfAppDev)
    }

    @Test
    fun should_ReturnTow_When_FindTowCompany() {
        // given list
        var listCompany = listOf<App>(
            fakeApps[0],fakeApps[6],fakeApps[7],fakeApps[10])
        // when searching for company
        val numOfAppDev = analyzer.calculateCountAppsDevelopedByGoogle(listCompany)
        // then check
        assertEquals(2, numOfAppDev)
    }

    @Test
    fun should_ReturnSix_When_FindAllCompany() {
        // given list
        var listCompany = fakeApps
        // when searching for compane
        val numOfAppDev = analyzer.calculateCountAppsDevelopedByGoogle(listCompany)
        // then check
        assertEquals(6, numOfAppDev)
    }

}
>>>>>>> 291d12f2c86844399115468bc42e498573eef40e
