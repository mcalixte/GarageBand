package com.soen343.gms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import javax.annotation.PostConstruct;

@Configuration
public class ThymeleafConfig {
    @Autowired
    private SpringResourceTemplateResolver resolver;

    @PostConstruct
    public void useDecoupledLogic() {
        resolver.setUseDecoupledLogic(true);
    }
}
