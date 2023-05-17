package PizzaBar.service.user

import PizzaBar.entities.dto.request.RequestDeleteUserEntity
import PizzaBar.entities.dto.request.RequestPostUserEntity
import PizzaBar.entities.dto.request.RequestPutUserEntity
import PizzaBar.entities.dto.response.ResponseGetUserEntity

interface UserService {

    fun get () : ResponseGetUserEntity

    fun post(body : RequestPostUserEntity)

    fun put(body: RequestPutUserEntity)

    fun delete(body: RequestDeleteUserEntity)
}