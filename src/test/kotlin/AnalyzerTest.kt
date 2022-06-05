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
        this.analyzer = Analyzer()
    }

    @BeforeEach
    fun initial(){
        //given
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

    /**
     * test function 3
     * function getOldestApp()
     */
    @Test
    fun should_ReturnNull_when_list_isEmpty(){
        //give set fakeApps is empty
        fakeApps= listOf()
        //when Oldest App
        val result = analyzer.getOldestApp(fakeApps)
        //then find the result
        assertNull(result)
    }

    @Test
    fun should_ReturnApp_when_list_isNotEmpty(){
        //when list not empty Oldest App
        val result = analyzer.getOldestApp(fakeApps)
        //then find the result
        assertNotNull(result)
    }

    @Test
    fun should_ReturnApp_when_list_isCorrect(){

        //when list oldest App correct
        val result = analyzer.getOldestApp(fakeApps)
        //then find the result
        var exception: App = App(
            name = "App 2",
            company = "Google LLC",
            category = "Medical",
            updatedAt = "September 26 2017".convertStringToDateObject(),
            size = "22M".convertSizeToUniqueUnit(),
            installsCount = 100000,
            currentVersion = "1.4.4-0e73d19a",
            requiresAndroid = "7.0 and up",
        )
        assertEquals(exception,result)
    }

    /**
     * test function 7
     * function largestAppDevelopedSpecificCompany()
     */
    @Test
    fun should_ReturnNull_when_Company_not_include_in_list_app(){
        //when get largest App Developed Specific Company
        val result = analyzer.largestAppDevelopedSpecificCompany(fakeApps," SpaceX ")
        //then find the result
        assertNull(result)
    }

    @Test
    fun should_ReturnNull_when_Company_Null_list(){
        //give
        var faker: List<App> = listOf()
        //when get largest App Developed Specific Company
        val result = analyzer.largestAppDevelopedSpecificCompany(faker)
        //then find the result
        assertNull(result)
    }

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
