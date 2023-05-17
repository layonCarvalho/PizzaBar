package PizzaBar.service.impl


import PizzaBar.entities.dto.request.RequestDeleteUserEntity
import PizzaBar.entities.dto.request.RequestPostUserEntity
import PizzaBar.entities.dto.request.RequestPutUserEntity
import PizzaBar.entities.dto.response.ResponseGetUserEntity
import PizzaBar.entities.exception.UserDeleteException
import PizzaBar.entities.exception.UserException
import PizzaBar.entities.exception.UserPostException
import PizzaBar.entities.exception.UserPutException
import PizzaBar.repository.user.domain.User
import PizzaBar.repository.user.domain.toDomain
import PizzaBar.repository.user.repository.UserRepository
import PizzaBar.service.user.UserService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val repository: UserRepository) : UserService {

    val LOG = LoggerFactory.getLogger(UserServiceImpl::class.java)

    override fun get() : ResponseGetUserEntity {

        LOG.info("START GET User")

        var response = emptyList<User>()

        runCatching {

            response = repository.findAll()

        }.onFailure {

            LOG.error("ERROR GET User message: {} causeMessage: {}", it.message, it.cause!!.message)

            throw UserException(it, HttpStatus.INTERNAL_SERVER_ERROR, "USER_GET_EXCEPTION", "user.get.exception")

        }.onSuccess {

            LOG.info("END GET User response: {}", response)

        }

        return ResponseGetUserEntity(response)

    }



    override fun post(body: RequestPostUserEntity) {

        LOG.info("START POST User body: {}", body)

        runCatching {

            val domain = body.toEntity().toDomain()

            repository.save(domain)

        }.onFailure {

            LOG.error("ERROR POST User body: {} message: {} causeMessage: {}", body, it.message, it.cause!!.message)

            throw UserPostException(it, HttpStatus.INTERNAL_SERVER_ERROR, "USER_POST_EXCEPTION", "user.post.exception")

        }.onSuccess {

            LOG.info("END POST User")

        }
    }



    override fun put(body: RequestPutUserEntity){

        LOG.info("START PUT User  body: {}", body)

        runCatching {

            val domain = body.toDomain()

            repository.save(domain)

        }.onFailure {

            LOG.error("ERROR PUT User body: {} message: {} causeMessage: {}", body, it.message, it.cause!!.message)

            throw UserPutException(it, HttpStatus.INTERNAL_SERVER_ERROR, "USER_PUT_EXCEPTION", "user.put.exception")

        }.onSuccess {

            LOG.info("END PUT User")

        }

    }

    override fun delete(body: RequestDeleteUserEntity){

        LOG.info("START DELETE User body: {}", body)

        runCatching {

            val response = repository.findByNameIn(body.user.name)

            repository.deleteAll(response)

        }.onFailure {

            LOG.error("ERROR DELETE User body: {} message: {} causeMessage: {}", body, it.message, it.cause!!.message)

            throw UserDeleteException(it, HttpStatus.INTERNAL_SERVER_ERROR, "USER_DELETE_EXCEPTION", "user.delete.exception")

        }.onSuccess {

            LOG.info("END DELETE USER")
        }

    }
}


