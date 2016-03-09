package com.performance.home;

import com.github.dandelion.core.web.DandelionFilter;
import com.performance.IntegrationTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockFilterConfig;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
public class HomeControllerTest {

    @Resource
    private WebApplicationContext context;

    private DandelionFilter dandelionFilter;
    private MockMvc mockMvc;

    @PostConstruct
    public void init() throws Exception {
        dandelionFilter = new DandelionFilter();
        dandelionFilter.init(new MockFilterConfig());
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .addFilter(dandelionFilter)
                .build();
    }

    @Test
    public void slow() throws Exception {
        mockMvc.perform(get("/slow"))
                .andExpect(status().isOk());
    }

    @Test
    public void fast() throws Exception {
        mockMvc.perform(get("/fast"))
                .andExpect(status().isOk());
    }
}