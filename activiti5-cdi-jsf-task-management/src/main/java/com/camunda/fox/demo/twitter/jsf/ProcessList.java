package com.camunda.fox.demo.twitter.jsf;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * backing bean for retrieving a list of processes
 * 
 * @author meyerd
 */
@Named
@RequestScoped
public class ProcessList {
  
  private String processDefinitionKey; 

  @Inject
  private RepositoryService repositoryService;
  
  @Produces
  @Named("processDefinitionList")
  public List<ProcessDefinition> getProcessDefinitionList() {
    return repositoryService.createProcessDefinitionQuery()
            .list();
  }
  
  public void setProcessDefinitionKey(String processDefinitionKey) {
    this.processDefinitionKey = processDefinitionKey;
  }
  
  public String getProcessDefinitionKey() {
    return processDefinitionKey;
  }

}
