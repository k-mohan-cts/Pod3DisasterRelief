package org.cognizant.disastermanagement.service;
import org.cognizant.disastermanagement.dao.UserRepository;
import org.cognizant.disastermanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository UserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // Must be this exception
        try {
            Long userID = Long.parseLong(username);

            User user = UserRepository.findById(Math.toIntExact(userID))
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + userID));

            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUserId().toString())
                    .password(user.getPasswordHash()) // Remember: this must be a BCrypt hash now!
                    .roles(String.valueOf(user.getRole()))
                    .build();

        } catch (NumberFormatException e) {
            throw new UsernameNotFoundException("User ID must be a numeric value");
        }
    }
}