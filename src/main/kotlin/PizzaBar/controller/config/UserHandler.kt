package PizzaBar.controller.config

import org.slf4j.LoggerFactory
import org.springframework.context.MessageSource
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class UserHandler (val messageSource: MessageSource){

    val LOG = LoggerFactory.getLogger(UserHandler::class.java)!!

    //TODO MAPEAR AS EXCECOES NO HANDLER
}