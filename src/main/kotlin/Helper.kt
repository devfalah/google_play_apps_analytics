



class Helper {

    public fun convertSize(size: String): Double {
        if (size.contains("M")){
            return size.replace("M","").toDouble()
        }
        else if(size.contains("G")){
            val sizeInGB = size.replace("G", "").toDouble()
            return sizeInGB * 1024
        }
       return 0.0
    }
}