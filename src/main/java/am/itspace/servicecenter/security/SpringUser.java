package am.itspace.servicecenter.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SpringUser extends User {
    private am.itspace.servicecenter.entity.User user;

    public SpringUser(am.itspace.servicecenter.entity.User user) {
        super(user.getEmail(), user.getPassword(),
                user.isActive(),true,true,true,
                AuthorityUtils.createAuthorityList(user.getUserType().name()));
        this.user = user;
    }

    public am.itspace.servicecenter.entity.User  getUser() {
        return user;
    }
}