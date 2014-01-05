package com.googlecode.kanbanik.shared;

import java.io.Serializable;

public enum ServerCommand implements Serializable {
	GET_ALL_BOARDS_WITH_PROJECTS,
	GET_ALL_PROJECTS,
	MOVE_TASK, 
	SAVE_PROJECT, 
	SAVE_TASK, 
	SAVE_BOARD,
	SAVE_CLASS_OF_SERVICE,
	DELETE_CLASS_OF_SERVICE,
	GET_BOARD,
	GET_TASK,
	DELETE_TASKS,
	DELETE_BOARD,
	DELETE_PROJECT,
	ADD_PROJECTS_TO_BOARD,
	REMOVE_PROJECTS_FROM_BOARD,
	EDIT_WORKFLOW,
	EDIT_WORKFLOWITEM_DATA,
	DELETE_WORKFLOWITEM,

	GET_ALL_USERS_COMMAND,
	CREATE_USER_COMMAND,
	DELETE_USER_COMMAND,
	EDIT_USER_COMMAND
	
}
