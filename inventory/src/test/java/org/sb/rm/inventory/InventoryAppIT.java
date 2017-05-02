package org.sb.rm.inventory;

import org.junit.Test;
import org.sb.rm.inventory.controller.InventoryController;
import org.sb.rm.inventory.model.BinaryRepo;
import org.sb.rm.inventory.model.CIServer;
import org.sb.rm.inventory.model.DevOpsTool;
import org.sb.rm.inventory.model.DevOpsTool.Credential;
import org.sb.rm.inventory.model.DevOpsTool.Endpoint;
import org.sb.rm.inventory.model.ToolChain;
import org.sb.rm.inventory.model.VCS;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tngtech.jgiven.integration.spring.SimpleSpringRuleScenarioTest;

@SpringBootTest(classes = { InventoryController.class, InventoryAppTestContext.class, MockServletContext.class })
@ComponentScan
@WebAppConfiguration
public class InventoryAppIT extends SimpleSpringRuleScenarioTest<InventoryAppStage> {

  @Test
  public void contextLoads() {
  }

  @Test
  public void it_is_possible_to_get_detail_about_tools() throws Exception {
    when().get(InventoryController.SETTINGS + "/" + "SINGLETON");
    then().the_status_is(HttpStatus.FOUND);
  }

  @Test
  public void it_is_possible_to_register_tools_required_for_ci() throws Exception {

    // @formatter:off
    ToolChain chain = ToolChain.builder() .id("SINGLETON")
                                          .vcs((DevOpsTool
                                                        .builder()
                                                        .id("SINGLETON_VCS")
                                                        .credential(Credential.builder().userId("acme").password("bogus").build())
                                                        .endpoint(Endpoint.builder().url("git://nowhere").build())
                                                        .type(VCS.GIT.toString()).build()))
                                         .ci((DevOpsTool
                                                        .builder()
                                                        .id("SINGLETON_CI_SERVER")                                                        
                                                        .credential(Credential.builder().userId("acme").password("bogus").build())
                                                        .endpoint(Endpoint.builder().url("http://jenkins.nowhere").build())
                                                        .type(CIServer.JENKINS.toString()).build()))
                                         .repo((DevOpsTool
                                                        .builder()
                                                        .id("SINGLETON_BINARY_REPO")
                                                        .credential(Credential.builder().userId("acme").password("bogus").build())
                                                        .endpoint(Endpoint.builder().url("http://nowhere").build())
                                                        .type(BinaryRepo.ARTIFACTORY.toString()).build()))                                         
                                         .build();

    // @formatter:on
    when().post(InventoryController.SETTINGS, chain);
    then().the_status_is(HttpStatus.CREATED);
  }

  @Test
  public void it_is_possible_to_ensure_configured_tools_can_be_connected() throws Exception {
    when().resources_configured_are_pinged(InventoryController.SETTINGS + "/" + "SINGLETON");
    then().result_is_success();
  }

  //@formatter:on
}
