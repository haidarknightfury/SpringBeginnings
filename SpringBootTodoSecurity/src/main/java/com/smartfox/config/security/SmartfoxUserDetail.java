package com.smartfox.config.security;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smartfox.model.User;
import com.smartfox.model.UserAuthority;

/**
 * The UserDetail class - contains the object User
 * Alternatively could make the User implement UserDetails and have the necessary methods
 * @author hdargaye
 *
 */
public class SmartfoxUserDetail implements UserDetails {

    private static final long serialVersionUID = 1L;
    private User user;
    private List<UserAuthority> authGroups;

    public SmartfoxUserDetail(User user, List<UserAuthority> authGroups) {
        this.setUser(user);
        this.authGroups = authGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (null == this.authGroups) {
            return Collections.emptySet();
        }
        return this.authGroups.stream().map(authGroup -> new SimpleGrantedAuthority(authGroup.getAuthGroup())).collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return this.getUser().getPassword();
    }

    public User getUser() {
        return this.user;
    }

    @Override
    public String getUsername() {
        return this.getUser().getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
