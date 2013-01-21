package com.test.interceptor.web;

import com.test.interceptor.domain.Project;
import com.test.interceptor.domain.Story;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/storys")
@Controller
@RooWebScaffold(path = "storys", formBackingObject = Story.class)
@RooWebJson(jsonObject = Story.class)
public class StoryController {

	@RequestMapping(value = "/ByProject/{project}", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindStorysByProject(@PathVariable("project") Long id) {
		Project project = Project.findProject(id);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Story.toJsonArray(Story.findStorysByProject(project).getResultList()), headers, HttpStatus.OK);
    }
	
	//@RequestParam("project") Long id
}
