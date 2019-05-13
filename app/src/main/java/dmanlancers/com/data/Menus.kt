package dmanlancers.com.data

import com.google.gson.annotations.SerializedName

data class Menus(val id : Int,
                 val id_restaurant : Int,
                 @SerializedName("special_name")
                 val name : String,
                 @SerializedName("image")
                 val image : String,
                 val type : String,
                 val price : Float,
                 val date : String,
                 @SerializedName("created_at")
                 val created : String?,
                 @SerializedName("updated_at")
                 val updated : String?)