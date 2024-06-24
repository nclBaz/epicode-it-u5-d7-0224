package riccardogulin.u5d7.services;

import org.springframework.stereotype.Service;
import riccardogulin.u5d7.entities.User;
import riccardogulin.u5d7.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class UsersService {
	private List<User> usersList = new ArrayList<>();

	public List<User> getUsersList(){
		return this.usersList;
	}

	public User saveUser(User body){
		Random rndm = new Random();
        body.setId(rndm.nextInt(1,10000));
		this.usersList.add(body);
		return body;
	}

	public User findById(int id){
		User found = null;
		for(User user: this.usersList){
			if(user.getId() == id) found = user;
		}
		if(found == null) throw new NotFoundException(id);
		else return found;
	}

	public User findByIdAndUpdate(int id, User updatedUser){
		User found = null;
		for(User user: this.usersList){
			if(user.getId() == id) {
				found = user;
                found.setName(updatedUser.getName());
                found.setSurname(updatedUser.getSurname());
			}
		}
		if(found == null) throw new NotFoundException(id);
		else return found;
	}

	public void findByIdAndDelete(int id){
		Iterator<User> iterator = this.usersList.iterator();

		while(iterator.hasNext()){
			User current = iterator.next();
			if(current.getId() == id){
				iterator.remove();
			}
		}

	}

}
