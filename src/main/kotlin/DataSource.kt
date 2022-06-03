import models.App
import java.io.File

interface DataSource {

    fun getAllApps(file: File): List<App>

}