package com.linkedInclone.userservice.service;

import com.linkedInclone.userservice.Exception.NotFoundException;
import com.linkedInclone.userservice.model.User;
import com.linkedInclone.userservice.repository.UserRepository;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.hibernate.loader.ast.spi.Loadable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
//        LocalDate birthDate = LocalDate.parse((CharSequence) user.getBirthDate()) ;
        LocalDate birthDate = Date.valueOf(user.getBirthDate().toLocalDate()).toLocalDate();
        LocalDate today = LocalDate.now();
        Period diff = Period.between(birthDate, today);
        if (diff.getYears()<18){
            throw  new NotFoundException("Votre age doit etre supperieur a 18 ans. Merci!");
        }
//        User checkUser = userRepository.findUserByEmail(user.getEmail());
        if (userRepository.findUserByEmail(user.getEmail())!=null){
            throw  new NotFoundException("Cette adresse email est deja prise");
        }
        user.setAge(diff.getYears());
        user.setRegistrationDate(LocalDateTime.now());

        return userRepository.save(user);
    }
    public List<User> fetchUsers(){
        return userRepository.findAll();
    }
    public User fetchUserById(int id){
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found."));
    }

    public User updateUser(int userId, User userDetail){
        User updateUser = userRepository.findById(userId).
                orElseThrow( ()-> new NotFoundException("User not exist with id. " + userId));
        updateUser.setUsername(userDetail.getUsername());
        updateUser.setFirstName(userDetail.getFirstName());
        updateUser.setLastName(userDetail.getLastName());
        updateUser.setPassword(userDetail.getPassword());
        updateUser.setEmail(userDetail.getEmail());
        updateUser.setBirthDate(userDetail.getBirthDate());
        updateUser.setAge(userDetail.getAge());
        updateUser.setLastLoginDate(userDetail.getLastLoginDate());
        return userRepository.save(updateUser);
    }
    public User deleteUser(int userId) {
       User user= userRepository.findById(userId).
                orElseThrow( () -> new NotFoundException("User not found"));
        userRepository.deleteById(userId);
        return user;
    }

    public void updateLastLogin(int userId){
        User updateUser = userRepository.findById(userId).
                orElseThrow( ()-> new NotFoundException("User not exist with id. " + userId));

        updateUser.setLastLoginDate(Timestamp.valueOf(LocalDateTime.now()));
//        return userRepository.save(updateUser);
    }

    public User login(String email, String password){
        User user = userRepository.findUserByEmailAndPassword(email, password).orElseThrow( ()-> new NotFoundException("User not exist with id. "));
        updateLastLogin(user.getId());
        return user;
    }
}
