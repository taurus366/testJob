package com.example.testjob.service.Impl;

import com.example.testjob.common.CookieFunction;
import com.example.testjob.model.dto.UserDTO;
import com.example.testjob.model.entity.*;
import com.example.testjob.model.service.UserRegistrationEditServiceModel;
import com.example.testjob.repository.*;
import com.example.testjob.service.UserService;
import com.example.testjob.service.UserSessionService;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SectorRepository sectorRepository;
    private final UnderSectorOneRepository underSectorOneRepository;
    private final UnderSectorTwoRepository underSectorTwoRepository;
    private final UnderSectorThreeRepository underSectorThreeRepository;
    private final UserSessionRepository userSessionRepository;
    private final CookieFunction cookieFunction;
    private final UserSessionService userSessionService;

    public UserServiceImpl(UserRepository userRepository, SectorRepository sectorRepository, UnderSectorOneRepository underSectorOneRepository, UnderSectorTwoRepository underSectorTwoRepository, UnderSectorThreeRepository underSectorThreeRepository, UserSessionRepository userSessionRepository, CookieFunction cookieFunction, UserSessionService userSessionService) {
        this.userRepository = userRepository;
        this.sectorRepository = sectorRepository;
        this.underSectorOneRepository = underSectorOneRepository;
        this.underSectorTwoRepository = underSectorTwoRepository;
        this.underSectorThreeRepository = underSectorThreeRepository;
        this.userSessionRepository = userSessionRepository;
        this.cookieFunction = cookieFunction;
        this.userSessionService = userSessionService;
    }


    @Override
    public UserDTO postNewUserAndTokenToDB(UserRegistrationEditServiceModel newUser, HttpServletRequest request, HttpServletResponse response) {

        Object[] allSectors = this.getAllSectors(newUser.getSectorId(), newUser.getUnderSectorOneId(), newUser.getUnderSectorTwoId(), newUser.getUnderSectorThreeId());

        UserEntity user = new UserEntity();

        user
                .setUsername(newUser.getUsername())
                .setAgree(newUser.isAgree())
                .setSector(((SectorEntity) allSectors[0]))
                .setUnderSectorOne((UnderSectorOneEntity) allSectors[1])
                .setUnderSectorTwo((UnderSectorTwoEntity) allSectors[2])
                .setUnderSectorThree((UnderSectorThreeEntity) allSectors[3])
                .setCreated(Instant.now());


        UserEntity savedUser = this.userRepository
                .save(user);

        String newToken = getToken();

        //        ADD TOKEN TO USERS_SESSION / DOESN'T NEED TO CHANGE IT TO USERSSESSIONSERVICE !

        UserSessionEntity newUserToken = new UserSessionEntity();
        newUserToken
                .setUser(savedUser)
                .setToken(newToken)
                .setCreated(Instant.now());

        UserSessionEntity userSessionEntity = this.userSessionRepository
                .save(newUserToken);

        //        ADD TOKEN TO USERS_SESSION / DOESN'T NEED TO CHANGE IT TO USERSSESSIONSERVICE !

        this.cookieFunction.addTokenToBrowser(request, response, userSessionEntity);

        return asUserDTO(savedUser);
    }

    @Override
    public UserDTO editCurrentUser(UserRegistrationEditServiceModel currentUser, HttpServletRequest request, HttpServletResponse response) {

        Cookie[] cookies = request.getCookies();
        Cookie userCookie = null;



        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("USERSESSIONID")) {
                userCookie = cookie;
                break;
            }
        }

        System.out.println(userCookie);

         UserEntity userEntityByToken = this.userSessionService.checkIfTokenExistsAndUser(userCookie.getValue());
        System.out.println(userEntityByToken.getId());

        if (userEntityByToken != null){

            Object[] allSectors = this.getAllSectors(currentUser.getSectorId(), currentUser.getUnderSectorOneId(), currentUser.getUnderSectorTwoId(), currentUser.getUnderSectorThreeId());

           userEntityByToken
                   .setUsername(currentUser.getUsername())
                   .setAgree(currentUser.isAgree())
                   .setSector((SectorEntity) allSectors[0])
                   .setUnderSectorOne((UnderSectorOneEntity) allSectors[1])
                   .setUnderSectorTwo((UnderSectorTwoEntity) allSectors[2])
                   .setUnderSectorThree((UnderSectorThreeEntity) allSectors[3])
                   .setModified(Instant.now());

            userEntityByToken = this.userRepository
                   .save(userEntityByToken);

        }

        return asUserDTO(userEntityByToken);
    }

    private UserDTO asUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();

        return userDTO
                .setUsername(userEntity.getUsername())
                .setSector(userEntity.getSector().getName())
                .setUnderSectorOne(userEntity.getUnderSectorOne().getName())
                .setUnderSectorTwo(userEntity.getUnderSectorTwo().getName())
                .setUnderSectorThree(userEntity.getUnderSectorThree().getName())
                .setAgree(userEntity.getAgree());
    }

    private String getToken() {
        return UUID.randomUUID().toString();
    }

    private Object[] getAllSectors(long sectorId,long underSectorOneId,long underSectorTwoId,long underSectorThreeId) {
        SectorEntity sector = this.sectorRepository.getById(sectorId);
        UnderSectorOneEntity underSectorOne = this.underSectorOneRepository.getById(underSectorOneId);
        UnderSectorTwoEntity underSectorTwo = this.underSectorTwoRepository.getById(underSectorTwoId);
        UnderSectorThreeEntity underSectorThree = this.underSectorThreeRepository.getById(underSectorThreeId);

        return new Object[]{sector,underSectorOne,underSectorTwo,underSectorThree};
    }


}
