package org.sb.rm.inventory;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.sb.rm.inventory.controller.InventoryController;
import org.sb.rm.inventory.model.ToolChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.Quoted;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class InventoryAppStage extends Stage<InventoryAppStage> {

  private MockMvc mvc;
  private ResultActions mvcResult;

  @Autowired
  InventoryController inventoryController;

  @BeforeStage
  public void setUp() throws Exception {
    mvc = MockMvcBuilders.standaloneSetup(inventoryController).build();
  }

  public InventoryAppStage get(@Quoted String path) throws Exception {
    mvcResult = mvc.perform(MockMvcRequestBuilders.get(path).accept(MediaType.APPLICATION_JSON));
    return this;
  }

  public InventoryAppStage post(@Quoted String path, ToolChain chain) throws Exception {
    byte[] json = TestUtil.convertObjectToJsonBytes(chain);
    ObjectMapper mapper = new ObjectMapper();
    // @formatter:off
    mvcResult = mvc.perform(MockMvcRequestBuilders.post(path)
                   .contentType(TestUtil.APPLICATION_JSON_UTF8)
                   .content(mapper.writeValueAsString(chain))
                   .accept(MediaType.APPLICATION_JSON));
    // @formatter:on
    return this;
  }

  public InventoryAppStage the_status_is(HttpStatus status) throws Exception {
    mvcResult.andExpect(status().is(status.value()));
    return this;
  }

  public InventoryAppStage the_content_is(@Quoted String content) throws Exception {
    mvcResult.andExpect(content().string(equalTo(content)));
    return this;
  }

}
