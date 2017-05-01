package org.sb.rm.inventory;

import java.util.UUID;

import org.junit.Test;
import org.sb.rm.inventory.controller.InventoryController;
import org.sb.rm.inventory.model.BinaryRepo;
import org.sb.rm.inventory.model.CIServer;
import org.sb.rm.inventory.model.DevOpsTool;
import org.sb.rm.inventory.model.DevOpsTool.Credential;
import org.sb.rm.inventory.model.DevOpsTool.Endpoint;
import org.sb.rm.inventory.persistence.ToolChainRepository;
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
    then().the_status_is(HttpStatus.OK).and().the_content_is("implementation pending");
  }

  @Test
  public void it_is_possible_to_register_tools_required_for_ci() throws Exception {

    // @formatter:off
    ToolChain chain = ToolChain.builder().vcs((DevOpsTool
                                                        .builder()
                                                        .id(UUID.randomUUID().toString())
                                                        .credential(Credential.builder().userId("acme").password("bogus").build())
                                                        .endpoint(Endpoint.builder().url("git://nowhere").build())
                                                        .type(VCS.GIT).build()))
                                         .ci((DevOpsTool
                                                        .builder()
                                                        .credential(Credential.builder().userId("acme").password("bogus").build())
                                                        .endpoint(Endpoint.builder().url("http://jenkins.nowhere").build())
                                                        .type(CIServer.JENKINS).build()))
                                         .repo((DevOpsTool
                                                        .builder()
                                                        .credential(Credential.builder().userId("acme").password("bogus").build())
                                                        .endpoint(Endpoint.builder().url("http://nowhere").build())
                                                        .type(BinaryRepo.ARTIFACTORY).build()))                                         
                                         .build();

    // @formatter:on
    when().post(InventoryController.SETTINGS, chain);
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
