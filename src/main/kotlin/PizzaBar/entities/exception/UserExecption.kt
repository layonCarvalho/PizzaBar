package PizzaBar.entities.exception

import org.springframework.http.HttpStatus

class UserException(val exception: Throwable, val httpStatusCode: HttpStatus, val codeMessage: String, val messageProperty: String) : RuntimeException()
class UserPostException(val exception: Throwable, val httpStatusCode: HttpStatus, val codeMessage: String, val messageProperty: String) : RuntimeException()
class UserPutException(val exception: Throwable, val httpStatusCode: HttpStatus, val codeMessage: String, val messageProperty: String) : RuntimeException()
class UserDeleteException(val exception: Throwable, val httpStatusCode: HttpStatus, val codeMessage: String, val messageProperty: String) : RuntimeException()