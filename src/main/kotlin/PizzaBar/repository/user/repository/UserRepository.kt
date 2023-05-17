package PizzaBar.repository.user.repository

import PizzaBar.repository.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findByNameIn(user: List<String>): List<User>

}