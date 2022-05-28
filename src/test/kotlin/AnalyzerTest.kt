import models.App
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals


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