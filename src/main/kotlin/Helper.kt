



class Helper {

    public fun convertSize(size: String): Double {
        val appSize = size.uppercase()
        if (appSize.contains("M")){
            return appSize.replace("M","").toDouble()
        }
        else if(appSize.contains("G")){
            val sizeInGB = appSize.replace("G", "").toDouble()
            return sizeInGB * 1024
        } else if(appSize.contains("K")){
            return appSize.replace("K", "").toDouble() / 1024
        }
       return 0.0
    }
}