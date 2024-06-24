package riccardogulin.u5d7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import riccardogulin.u5d7.entities.User;
import riccardogulin.u5d7.services.UsersService;

import java.util.List;

// ------------------------------------------------- USERS CRUD ------------------------------------------
/*

1. GET http://localhost:3001/users
2. POST http://localhost:3001/users (+ body)
3. GET http://localhost:3001/users/{userId}
4. PUT http://localhost:3001/users/{userId} (+ body)
5. DELETE http://localhost:3001/users/{userId}

 */
@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;

	// 1. GET http://localhost:3001/users
	@GetMapping
	private List<User> getAllUsers(){
		return this.usersService.getUsersList();
	}

	// 2. POST http://localhost:3001/users (+ body)
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) // Status Code 201
	private User saveUser(@RequestBody User body){
		return this.usersService.saveUser(body);
	}

	// 3. GET http://localhost:3001/users/{userId}
	@GetMapping("/{userId}")
	private User findUserById(@PathVariable int userId){
		return this.usersService.findById(userId);
	}

	// 4. PUT http://localhost:3001/users/{userId} (+ body)
	@PutMapping("/{userId}")
	private User findUserByIdAndUpdate(@PathVariable int userId, @RequestBody User body){
		return this.usersService.findByIdAndUpdate(userId, body);
	}

	// 5. DELETE http://localhost:3001/users/{userId}
	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204
	private void findUserByIdAndDelete(@PathVariable int userId){
		this.usersService.findByIdAndDelete(userId);
	}



}
