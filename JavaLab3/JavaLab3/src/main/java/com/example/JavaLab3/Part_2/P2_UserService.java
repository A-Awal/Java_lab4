package com.example.JavaLab3.Part_2;

import com.example.JavaLab3.Part_1.User;
import com.example.JavaLab3.Part_1.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepositoryInterface _userRepo;

    public UserService(UserRepositoryInterface userRepo) {
        _userRepo = userRepo;
    }

    public User findUserById(int id){
        return _userRepo.findUserById(id);
    }

    public int createUser(UserDTO userDto){
        try{
//            JMapper<User, UserDTO> mapper = new JMapper<User, UserDTO>(User.class, UserDTO.class);

//            User newUser = mapper.getDestination(userDto);
            User newUser = new User();
            newUser.setName(userDto.getName());
            newUser.setId(userDto.getId());
            return _userRepo.addUser(newUser);
        }catch(Exception e){
            return -1;
        }

    }

    public void updateUser(UserDTO userDTO, int id) throws Exception{{
    }
        User toUpdate = _userRepo.findUserById(id);

        if(toUpdate == null){
            throw new Exception();
        }

//        JMapper<User, UserDTO> mapper = new JMapper<>(User.class, UserDTO.class);
//
//        User updatedUser = mapper.getDestination(toUpdate, userDTO);
        User updatedUser = new User();
        updatedUser.setName(userDTO.getName());
        updatedUser.setId(id);
        updatedUser.setAge(userDTO.getAge());

        var x =  _userRepo.deleteUserById(toUpdate);
        _userRepo.updateUser(updatedUser);


    }

    public boolean deleteUser(int id){

        return _userRepo.deleteUserById(_userRepo.findUserById(id));
    }
}
