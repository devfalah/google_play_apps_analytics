import models.App
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Test
import utility.extension.convertSizeToUniqueUnit
import utility.extension.convertStringToDateObject
import java.util.Arrays


import kotlin.test.*


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AnalyzerTest {
    private lateinit var fakeApps :List<App>
    private lateinit var analyzer: Analyzer

    @BeforeAll
    fun setup() {
        analyzer = Analyzer()
    }

    @BeforeEach
    fun initial(){
        //given
        fakeApps = FakeData().fakeApps
    }


    //test fun_1
    @Test
    fun should_ReturnTheCountOfAppsDevelopedBySpecificCompany_when_CompanyNameIsValid(){
        //given
        //when calculate the app that developed by specific company with a valid name
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps,"Google")
        //then find the result
        assertEquals(5,result)
    }

    //test fun_1
    @Test
    fun should_ReturnMinusOne_when_CountAppsDevelopedByBlankStringCompanyName(){
        //given
        //when count the app that developed by specific company with a blank company name
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps,"")
        //then find the result
        assertEquals(-1,result)
    }

    //test fun_1
    @Test
    fun should_ReturnZero_when_CountTheCompanyNameSeparatedBySpace(){
        //given
        //when count the app that developed by specific company with a space in the middle
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps,"Goo gle")
        //then find the result
        assertEquals(0,result)
    }

    //test fun_1
    @Test
    fun should_ReturnTheCountOfAppDevelopedBySpecificCompany_when_CompanyNameContainSpaceAtTheEnd(){
        //given
        //when count the app that developed by specific company with a space at the end
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps," Google ")
        //then find the result
        assertEquals(5,result)
    }

    //test fun_1
    @Test
    fun should_ReturnZero_when_CountAppsDevelopedBySpecificNotValidCompanyName(){
        //given
        //when count the app that developed by specific company with not valid company name
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps,"AliZainy")
        //then find the result
        assertEquals(0,result)
    }

    //test fun_1
    @Test
    fun should_ReturnZero_when_CountAppsDevelopedBySpecificUpperCaseCompanyName(){
        //given
        //when count the app that developed by specific company with upper case company name
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps,"GOOGLE")
        //then find the result
        assertEquals(0,result)
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


//        assertEquals(fakeApps[5],result)
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







    //test fun_4
    @Test
    fun should_ReturnPercentageOfAppsRunningOnSpecificVersion_when_VersionIsValid(){
        //given
        //when calculate the percentage of apps running on specific valid version
        val result = analyzer.calculatePercentageOfAppsRunningOnSpecificVersion(fakeApps,"9 and up")
        //then find the result
        assertEquals(0.2, result)
    }



    //test fun_4
    @Test
    fun should_ReturnZero_WhenCalculatePercentageOfAppsRunningOnBlankStringVersion(){
        //given
        //when calculate the percentage of apps running on blank version
        val result = analyzer.calculatePercentageOfAppsRunningOnSpecificVersion(fakeApps, "")
        //then
        assertEquals(0.0,result)
    }



    //test fun_4
    @Test
    fun should_ReturnZero_when_CalculatePercentageOfAppsRunningOnNotValidVersion(){
        //given
        //when calculate percentage of apps running on not valid version
        val result = analyzer.calculatePercentageOfAppsRunningOnSpecificVersion(fakeApps, "9.0")
        //then find the result
        assertEquals(0.0, result)
    }



    //test fun_4
    @Test
    fun should_ReturnMinusOne_when_CalculatePercentageOfAppsRunningOnSpecificVersion_UsingEmptyList(){
        //given
        fakeApps= listOf()
        //when calculate percentage of apps using empty list
        val result = analyzer.calculatePercentageOfAppsRunningOnSpecificVersion(fakeApps, "9.0")
        //then find the result
        assertEquals(-1.0, result)
    }


    /**
     * test function 7
     * function largestAppDevelopedSpecificCompany()
     */
    //test fun_5
    @Test
    fun should_ReturnNull_when_Company_not_include_in_list_app(){
        //when get largest App Developed Specific Company
        val result = analyzer.largestAppDevelopedSpecificCompany(fakeApps," SpaceX ")
        //then find the result
        assertNull(result)
    }

    //test fun_5
    @Test
    fun should_ReturnNull_when_Company_Null_list(){
        //give
        var faker: List<App> = listOf()
        //when get largest App Developed Specific Company
        val result = analyzer.largestAppDevelopedSpecificCompany(faker)
        //then find the result
        assertNull(result)
    }

    //test fun_5
    @Test
    fun should_ReturnNull_when_Company_correct(){
        //when get largest App Developed Specific Company
        val result = analyzer.largestAppDevelopedSpecificCompany(fakeApps, "Google LLC")
        //then find the result
        var exception: App = App(
            name = "App 8",
            company = "Google LLC",
            category = "Tools",
            updatedAt = "May 12 2022".convertStringToDateObject(),
            size = "28M".convertSizeToUniqueUnit(),
            installsCount = 100000,
            currentVersion = "Varies with device",
            requiresAndroid = "Varies with device",
        )
        assertEquals(exception,result)

    }


}
