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


}