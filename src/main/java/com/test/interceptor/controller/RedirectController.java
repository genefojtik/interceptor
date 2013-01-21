package com.test.interceptor.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.service.spi.InjectService;
import org.joda.time.LocalDate;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.interceptor.domain.Project;


@RequestMapping("/api/v1/**")
@Controller
public class RedirectController {
	
	// Show ProjectsByProjectID
	// ../projects/{project}
	@RequestMapping(value="projects/{project}", method=RequestMethod.GET)
	public String redirect_showProjectsByProjectId(@PathVariable("project") String project) {
		return "redirect:/projects/{project}";
	}
	
	// Show Projects
	// ../projects
	@RequestMapping(value="projects", method=RequestMethod.GET)
	public String redirect_showProjects() {
		return "redirect:/projects/";
	}
	
	// Show Stories By ProjectID
	// ../projects/{projectId}/stories
	@RequestMapping(value="projects/{project}/storys", method=RequestMethod.GET)
	public String redirect_showStoriesByProjectId(@PathVariable("project") String project) {
		return "redirect:/storys/ByProject/{project}";
	}
	
	// Show Stories By StoryId
	// ../projects/{projectId}/stories/{storyId}
	@RequestMapping(value="projects/{projectId}/storys/{storyId}", method=RequestMethod.GET)
	public String redirect_showStory(@PathVariable("storyId") String storyId) {
		return "redirect:/storys/{storyId}";
	}
	
}
