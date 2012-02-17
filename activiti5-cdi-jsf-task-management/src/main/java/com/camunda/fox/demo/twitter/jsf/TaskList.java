package com.camunda.fox.demo.twitter.jsf;

import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * Backing bean producing the activiti task list
 * 
 * @author meyerd
 */
public class TaskList {

  @Inject
  private CurrentUser currentUser;

  @Inject
  private TaskService taskService;
  
  @Produces  
  @Named("personalTaskList")
  public List<Task> getPersonalTaskList() {
     return taskService.createTaskQuery()
           .taskAssignee(currentUser.getUsername())
           .list();
  }

}
