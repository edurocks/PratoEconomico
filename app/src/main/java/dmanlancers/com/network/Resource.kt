package dmanlancers.com.network

import androidx.annotation.Nullable

class Resource<T> private constructor(val status: Status, @param:Nullable @field:Nullable val data: T,
                                      @param:Nullable @field:Nullable val message: String?) {

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {

        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, @Nullable data: T): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}
