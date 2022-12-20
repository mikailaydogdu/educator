package com.app.educator.service.serviceImpl;

import com.app.educator.dto.UserDto;
import com.app.educator.dto.UserProj;
import com.app.educator.entity.User;
import com.app.educator.repository.UserRepository;
import com.app.educator.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public User createUser(User user) {
        User saveUser = userRepository.save(user);
        return saveUser;
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> mapUser = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return mapUser;
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return user.get();
        }else {
            return null;
        }
    }

    @Override
    public User updateUser(User user, Long id) {
        Optional<User> editUser = userRepository.findById(id);
        editUser.get().setUserName(user.getUserName());
        editUser.get().setBio(user.getBio());
        editUser.get().setFirstName(user.getFirstName());
        editUser.get().setLastName(user.getLastName());
        editUser.get().setCountry(user.getCountry());
        editUser.get().setCity(user.getCity());
        editUser.get().setDistrict(user.getDistrict());
        editUser.get().setImg(user.getImg());
        return userRepository.save(editUser.get());
    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional<User> delUser = userRepository.findById(id);
        if (delUser.isPresent()){
            userRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Page<UserProj> pagination(int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        return userRepository.findAllByDeletedFalse(UserProj.class, pageable);
    }

}
