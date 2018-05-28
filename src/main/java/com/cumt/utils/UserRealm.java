
package com.cumt.utils;
import javax.annotation.Resource;

import com.cumt.pojo.User;
import com.cumt.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class UserRealm extends AuthorizingRealm {

    @Resource
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        User user = null;
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String email = upToken.getUsername();
        user = userService.getUserByUserId(email);
        if (user == null)
            throw new UnknownAccountException("用户不存在！");
        Object principal = email;
        Object credentials = user.getPassword();
        String realmName = getName();
        ByteSource credentialsSalt = ByteSource.Util.bytes(email);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt,
                realmName);
        return info;
    }

}