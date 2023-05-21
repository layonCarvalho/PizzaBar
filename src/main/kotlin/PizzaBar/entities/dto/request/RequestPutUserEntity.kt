package PizzaBar.entities.dto.request

import PizzaBar.entities.domain.UserEntity
import PizzaBar.repository.user.domain.User

class RequestPutUserEntity { val  user : PutUserEntity = TODO()

    class PutUserEntity(
        val name: String? = null,
        val senha: String? = null,
        val active: Boolean? = true
    ) {

        override fun toString(): String {
            return "PutUserEntity(name=$name, cellphone=$1cellphone, active=$active)"
        }

    }

    fun PutUserEntity.toEntity(id: Long) = UserEntity(
        id = id,
        name = this.name?.let { it },
        senha = this.senha?.let { it })


    fun toDomain() = User()
}

