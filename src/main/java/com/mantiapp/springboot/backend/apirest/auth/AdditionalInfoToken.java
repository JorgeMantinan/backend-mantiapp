package com.mantiapp.springboot.backend.apirest.auth;

import com.mantiapp.springboot.backend.apirest.models.entity.Owner;
import com.mantiapp.springboot.backend.apirest.models.services.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AdditionalInfoToken implements TokenEnhancer {

    @Autowired
    private IOwnerService ownerService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

        // oAuth2Authentication.getName() Obtain the email (the "username" to enter in app)
        Owner owner = ownerService.findByEmail(oAuth2Authentication.getName());

        Map<String, Object> info = new HashMap<>();
        info.put("owner_name", owner.getName());
        info.put("owner_lastname", owner.getLastname());
        info.put("owner_email", owner.getEmail());

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);

        return oAuth2AccessToken;
    }
}
