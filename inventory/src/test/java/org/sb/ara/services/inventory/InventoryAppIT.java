package org.sb.ara.services.inventory;

import org.junit.Test;
import org.sb.rm.inventory.controller.InventoryController;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tngtech.jgiven.integration.spring.SimpleSpringRuleScenarioTest;

@SpringBootTest(classes = { InventoryController.class, InventoryAppTestContext.class, MockServletContext.class })
@WebAppConfiguration
public class InventoryAppIT extends SimpleSpringRuleScenarioTest<InventoryAppStage> {

  @Test
  public void contextLoads() {
  }

  @Test
  public void the_root_path_returns_greetings_from_JGiven() throws Exception {
    when().get("/");
    then().the_status_is(HttpStatus.OK).and().the_content_is("TODO_IMPLEMENTATION");
  }

  @Test
  public void register_configuration_info() throws Exception {
    when().post("/configurations");
    then().the_status_is(HttpStatus.CREATED);
  }

  @Test
  public void ensure_reachability() {

  }

  @Test
  public void describe_build() {

  }

  @Test
  public void describe_commit() {

  }

  @Test
  public void describe_binary() {

  }

  @Test
  public void grab_change_detail() {

  }

  //@formatter:off
  
  /**
   * 1. given a commit id, find detail about it
   * 2. given a build id, find detail about it
   * 3. given a binary id, find detail about it
   */
  
  //@formatter:on
}
