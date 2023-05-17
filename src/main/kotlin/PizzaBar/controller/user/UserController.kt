package PizzaBar.controller.user

import PizzaBar.entities.dto.request.RequestDeleteUserEntity
import PizzaBar.entities.dto.request.RequestPostUserEntity
import PizzaBar.entities.dto.request.RequestPutUserEntity
import PizzaBar.service.user.UserService
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@ApiOperation(tags =["User CRUD"], value ="Layer responsible to recevie request to manager Create/Read/Update/Delete the user entity")
class UserController (val service : UserService){


    @GetMapping("user/v1")
    @ApiOperation("find all user´s", response = HttpStatus::class)
    fun get() = ResponseEntity.ok(service.get())

    @PostMapping("user/v1")
    @ApiOperation("Save new user", response = HttpStatus::class)
    fun post(@RequestBody body: RequestPostUserEntity): ResponseEntity<HttpStatus>{

        service.post(body)

        return ResponseEntity.ok(HttpStatus.OK)
    }

    @PutMapping("user/v1")
    @ApiOperation("Update data user", response = HttpStatus::class)
    fun put(@RequestBody body: RequestPutUserEntity): ResponseEntity<HttpStatus>{

        service.put(body)

        return ResponseEntity.ok(HttpStatus.OK)
    }

    @DeleteMapping("user/v1")
    @ApiOperation("Exclude user by name",response=HttpStatus::class)
    fun delete(@RequestBody body: RequestDeleteUserEntity):ResponseEntity<HttpStatus>{

        service.delete(body)

        return ResponseEntity.ok(HttpStatus.OK)


    }



}
