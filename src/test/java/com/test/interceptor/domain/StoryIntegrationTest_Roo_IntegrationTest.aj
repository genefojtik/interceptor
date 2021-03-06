// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.test.interceptor.domain;

import com.test.interceptor.domain.Story;
import com.test.interceptor.domain.StoryDataOnDemand;
import com.test.interceptor.domain.StoryIntegrationTest;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect StoryIntegrationTest_Roo_IntegrationTest {
    
    declare @type: StoryIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: StoryIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: StoryIntegrationTest: @Transactional;
    
    @Autowired
    StoryDataOnDemand StoryIntegrationTest.dod;
    
    @Test
    public void StoryIntegrationTest.testCountStorys() {
        Assert.assertNotNull("Data on demand for 'Story' failed to initialize correctly", dod.getRandomStory());
        long count = Story.countStorys();
        Assert.assertTrue("Counter for 'Story' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void StoryIntegrationTest.testFindStory() {
        Story obj = dod.getRandomStory();
        Assert.assertNotNull("Data on demand for 'Story' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Story' failed to provide an identifier", id);
        obj = Story.findStory(id);
        Assert.assertNotNull("Find method for 'Story' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Story' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void StoryIntegrationTest.testFindAllStorys() {
        Assert.assertNotNull("Data on demand for 'Story' failed to initialize correctly", dod.getRandomStory());
        long count = Story.countStorys();
        Assert.assertTrue("Too expensive to perform a find all test for 'Story', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Story> result = Story.findAllStorys();
        Assert.assertNotNull("Find all method for 'Story' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Story' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void StoryIntegrationTest.testFindStoryEntries() {
        Assert.assertNotNull("Data on demand for 'Story' failed to initialize correctly", dod.getRandomStory());
        long count = Story.countStorys();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Story> result = Story.findStoryEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Story' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Story' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void StoryIntegrationTest.testFlush() {
        Story obj = dod.getRandomStory();
        Assert.assertNotNull("Data on demand for 'Story' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Story' failed to provide an identifier", id);
        obj = Story.findStory(id);
        Assert.assertNotNull("Find method for 'Story' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyStory(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'Story' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void StoryIntegrationTest.testMergeUpdate() {
        Story obj = dod.getRandomStory();
        Assert.assertNotNull("Data on demand for 'Story' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Story' failed to provide an identifier", id);
        obj = Story.findStory(id);
        boolean modified =  dod.modifyStory(obj);
        Integer currentVersion = obj.getVersion();
        Story merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Story' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void StoryIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Story' failed to initialize correctly", dod.getRandomStory());
        Story obj = dod.getNewTransientStory(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Story' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Story' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'Story' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void StoryIntegrationTest.testRemove() {
        Story obj = dod.getRandomStory();
        Assert.assertNotNull("Data on demand for 'Story' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Story' failed to provide an identifier", id);
        obj = Story.findStory(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Story' with identifier '" + id + "'", Story.findStory(id));
    }
    
}
