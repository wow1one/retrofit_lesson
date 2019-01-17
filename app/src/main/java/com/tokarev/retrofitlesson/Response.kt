package com.tokarev.retrofitlesson

class Response<T> {

    var result: T? = null
    var exception: Throwable? = null

    val isSuccess: Boolean
        get() = exception == null

    constructor(result: T) {
        this.result = result
    }

    constructor(exception: Throwable) {
        this.exception = exception
    }
}