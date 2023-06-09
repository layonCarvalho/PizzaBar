package PizzaBar.repository.user.domain

import PizzaBar.entities.domain.UserEntity
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


@Entity
@Table(schema = "public", name = "tb_user")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", nullable = false)
    var id: Long? = null,

    @NotNull
    @Column(name = "nome")
    @Size(min=2, max=30)
    val name: String? = null,

    @Column(name = "senha")
    @Min(18)
    val senha: String? = null,

    @Column(name = "ativo")
    val active: Boolean? = null,


    @Column(name = "dh_criacao")
    val dateCreate: LocalDateTime? = LocalDateTime.now(),

    @Column(name = "dh_alteracao")
    val dateUpdate: LocalDateTime? = null,


    @Column(name = "dh_exclusao")
    val dateExclude: LocalDateTime? = null)


fun List<User>.toEntity() = map { it.toEntity() }

fun User.toEntity() = UserEntity(id = id,
    name = name,
    senha = senha,
    active = active,
    dateCreate	  = dateCreate,
    dateUpdate = dateUpdate,
    dateExclude = dateExclude)

fun List<UserEntity>.toDomain() =  map { it.toDomain() }

fun UserEntity.toDomain() = User (
    id = id,
    name = name,
    senha = senha,
    active = active,
    dateCreate = dateCreate,
    dateUpdate = dateUpdate,
    dateExclude = dateExclude)


