package com.test.interceptor.domain;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJson
@RooJpaActiveRecord(finders = { "findStorysByProject", "findStorysByProjectAndNameEquals" })
public class Story {

    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @ManyToOne
    private Project project;
}
