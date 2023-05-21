package PizzaBar.entities.dto.request

import PizzaBar.entities.domain.UserEntity

class RequestPostUserEntity (val name:String,
                             val senha:String

){

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
    fun toEntity() = UserEntity(name = name, senha = senha)

}
