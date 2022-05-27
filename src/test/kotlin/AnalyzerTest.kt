import models.App
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals
import org.junit.jupiter.api.Assertions.assertArrayEquals
import kotlin.test.assertContains

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AnalyzerTest {
    val fakeApps=FakeData().fakeApps
    private lateinit var analyzer :Analyzer

    @BeforeAll
    fun setup(){
        this.analyzer =Analyzer()
    }

    // Test Cases for : ((getOldestApp method))
    //=========================================
    @Test
    fun should_ReturnOldestApp_When_ListOfAppsIsCorrect(){
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(fakeApps)
        // then
        assertEquals(fakeApps[1], oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DateFormatHasNoSpace(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[4].updatedAt = "May152020"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DateFormatHasOneLeftSpace(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[4].updatedAt = "May 152020"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DateFormatHasOneRightSpace(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[2].updatedAt = "March18 2022"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_MonthIsAnumber(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[2].updatedAt = "6 10 2022"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_MonthNotCapitalized(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[5].updatedAt = "march 19 2021"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_MonthMisspelled(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[1].updatedAt = "Arpil 10 2022"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DayIsLessThan_1(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[1].updatedAt = "June 0 2022"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DayIsGreaterThan_31(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[6].updatedAt = "Arpil 35 2022"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_YearLessThan2008(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[7].updatedAt = "Arpil 10 2006"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DateFormatIsReversed(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[7].updatedAt = "2020 10 Arpil"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_MonthReversedWithDay(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[7].updatedAt = "10 Arpil 2020"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun shouldReturn_Correct10LargestApp_WhenHaveCorrectData () {
        // given list of apps
        val apps = fakeApps
        // when sort apps descending
        val sortedApps = analyzer.getLargest10Apps(fakeApps).take(2)
        val exceptedApps = listOf<App>(
           fakeApps[4],
           fakeApps[17]
        )
        // then
        assertEquals(exceptedApps, sortedApps)
    }

    @Test
    fun shouldReturn_Correct10LargestApp_WhenHaveSizeSymbolINAnyLetterCases () {
        // given list of apps
        val apps = listOf<App>(
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
        val sortedApps = analyzer.getLargest10Apps(apps).take(2);
        val exceptedApps = listOf<App>(
            fakeApps[17],
            fakeApps[4])
        // then
        assertEquals(exceptedApps, sortedApps)
    }

    @Test
    fun shouldReturn_Correct10LargestApp_WhenSizeWithoutNumericValue() {
        // given list of apps
        val apps = listOf<App>(
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
        val sortedApps = analyzer.getLargest10Apps(apps).take(2);
        val exceptedApps = listOf<App>(
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
        val resultApps = analyzer.getLargest10Apps(apps);
        // then return empty list
        assertEquals(emptyList<App>(), resultApps)
    }




}