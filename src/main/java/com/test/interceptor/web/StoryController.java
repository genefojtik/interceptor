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

	@RequestMapping(value = "/ByProject/{projectId}", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindStorysByProject(@PathVariable("projectId") Long id) {
		Project project = Project.findProject(id);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Story.toJsonArray(Story.findStorysByProject(project).getResultList()), headers, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/{storyId}", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("storyId") Long id) {
        Story story = Story.findStory(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (story == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(story.toJson(), headers, HttpStatus.OK);
    }
}
