package org.sb.rm.inventory.controller;

import org.sb.rm.inventory.model.ToolChain;
import org.sb.rm.inventory.persistence.ToolChainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@EnableAutoConfiguration
@ComponentScan(basePackages = { "org.sb.rm.inventory.controller",  "org.sb.rm.inventory.persistence"})
public class InventoryController {

  public static final String SETTINGS = "/settings";

  @Autowired
  private ToolChainRepository repo;

  // http://stackoverflow.com/questions/2606572/junit-splitting-integration-test-and-unit-tests
  // https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-rest-api/
  // https://www.petrikainulainen.net/programming/spring-framework/spring-from-the-trenches-adding-validation-to-a-rest-api/
  // https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-configuration#appcontext-config

  @GetMapping(SETTINGS + "/{id}")
  public ResponseEntity<String> index(@PathVariable String id) {
    log.info("id is : {}", id);
    return new ResponseEntity<String>("implementation pending", HttpStatus.OK);
  }

  @PostMapping(SETTINGS)
  public ResponseEntity<ToolChain> createSettings(@RequestBody ToolChain toolChain) {
    log.info("toolChain is : {}", toolChain);
    repo.save(toolChain);
    return new ResponseEntity<ToolChain>(toolChain, HttpStatus.CREATED);
  }

  public static void main(String[] args) throws Exception {
//    // @formatter:off
//    ToolChain chain = ToolChain.builder().vcs((DevOpsTool
//                                                        .builder()
//                                                        .credential(Credential.builder().userId("acme").password("bogus").build())
//                                                        .endpoint(Endpoint.builder().url("git://nowhere").build())
//                                                        .type(VCS.GIT).build()))
//                                         .ci((DevOpsTool
//                                                        .builder()
//                                                        .credential(Credential.builder().userId("acme").password("bogus").build())
//                                                        .endpoint(Endpoint.builder().url("http://jenkins.nowhere").build())
//                                                        .type(CIServer.JENKINS).build()))
//                                         .repo((DevOpsTool
//                                                        .builder()
//                                                        .credential(Credential.builder().userId("acme").password("bogus").build())
//                                                        .endpoint(Endpoint.builder().url("http://nowhere").build())
//                                                        .type(BinaryRepo.ARTIFACTORY).build()))                                         
//                                         .build();
//
//    // @formatter:on
    // ObjectMapper mapper = new ObjectMapper();
    // System.out.println(mapper.writeValueAsString(chain));
    // String str = mapper.writeValueAsString(chain);
    //
    // ToolChain c = mapper.readValue(str, ToolChain.class);
    SpringApplication.run(InventoryController.class, args);

  }

}
