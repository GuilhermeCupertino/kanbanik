package com.googlecode.kanbanik.client.api;

import java.util.List;

public class Dtos {

    private Dtos() {
    }

    public interface BaseDto {
        String getCommandName();
        void setCommandName(String commandName);

        String getSessionId();
        void setSessionId(String sessionId);
    }

    public interface LoginDto extends BaseDto {
        String getUserName();
        void setUserName(String userName);

        String getPassword();
        void setPassword(String password);
    }

    public interface SessionDto extends BaseDto {
    }

    public interface StatusDto {
        Boolean isSuccess();
        void setSuccess(Boolean success);

        void setReason(String reason);
        String getReason();
    }

    public interface UserDto extends BaseDto {

        void setUserName(String userName);
        String getUserName();

        void setRealName(String realName);
        String getRealName();

        int getVersion();
        public void setVersion(int version);

        public String getPictureUrl();
        public void setPictureUrl(String pictureUrl);

        public String getSessionId();
        public void setSessionId(String sessionId);

        public List<PermissionDto> getPermissions();
        public void setPermissions(List<PermissionDto> permissions);

        public Boolean getUnlogged();
        public void setUnlogged(Boolean unlogged);
    }

    public enum PermissionTypes {

        ReadUser(5),
        EditUserData(1),
        EditUserPermissions(7),
        CreateUser(8),
        DeleteUser(9),

        ReadBoard(3),
        EditBoard(21),
        CreateBoard(22),
        DeleteBoard(23),

        ReadProject(4),
        EditProject(24),
        CreateProject(25),
        DeleteProject(26),

        ReadClassOfService(6),
        CreateClassOfService(18),
        EditClassOfService(19),
        DeleteClassOfService(20),

        MoveTask_p(10),
        CreateTask_p(11),
        EditTask_p(12),
        DeleteTask_p(13),

        MoveTask_b(14),
        CreateTask_b(15),
        EditTask_b(16),
        DeleteTask_b(17)

        ;

        PermissionTypes(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }
    }

    public interface PermissionDto {
        Integer getPermissionType();
        void setPermissionType(Integer  permissionType);

        List<String> getArgs();
        void setArgs(List<String> args);
    }

    public interface UserManipulationDto extends UserDto, BaseDto {
        String getPassword();
        void setPassword(String password);

        String getNewPassword();
        void setNewPassword(String newPassword);
    }

    public interface ClassOfServiceDto extends BaseDto {
        String getId();
        void setId(String id);

        String getName();
        void setName(String name);

        String getDescription();
        void setDescription(String description);

        String getColour();
        void setColour(String colour);

        int getVersion();
        void setVersion(int version);
    }

    public interface ClassOfServicesDto {
        List<ClassOfServiceDto> getValues();
        void setValues(List<ClassOfServiceDto> values);
    }

    public interface TaskTag {
        String getId();
        void setId(String id);

        void setName(String name);
        String getName();

        String getDescription();
        void setDescription(String description);

        String getPictureUrl();
        void setPictureUrl(String pictureUrl);

        String getOnClickUrl();
        void setOnClickUrl(String onClickUrl);

        Integer getOnClickTarget();
        void setOnClickTarget(Integer onClickTarget);

        void setColour(String colour);
        String getColour();
    }

    public enum TagClickTarget {
        NEW_WINDOW(1),
        NONE(-1);
        private int id;

        private TagClickTarget(int id) {
            this.id = id;
        }

        public static TagClickTarget from(Integer id) {
            if (id == null) {
                return NONE;
            } else if (id == 1) {
                return NEW_WINDOW;
            }

            return NONE;
        }

        public int getId() {
            return id;
        }
    }

    public interface ProjectDto extends BaseDto {
        String getId();
        void setId(String id);

        String getName();
        void setName(String name);

        int getVersion();
        void setVersion(int version);

        List<String> getBoardIds();
        void setBoardIds(List<String> boardIds);
    }

    public interface ProjectsDto {
        List<ProjectDto> getValues();
        void setValues(List<ProjectDto> values);
    }

    public interface ProjectWithBoardDto extends BaseDto {
        void setProject(ProjectDto project);
        ProjectDto getProject();

        void setBoardId(String boardId);
        String getBoardId();
    }

    public interface ErrorDto {
        String getErrorMessage();
        void setErrorMessage(String errorMessage);
    }

    public interface EventDto {
        String getSource();
        void setSource(String source);

        String getPayload();
        void setPayload(String payload);
    }

    public interface UsersDto {
        List<UserDto> getValues();
        void setValues(List<UserDto> values);
    }

    public interface TaskDto extends BaseDto {
        String getId();
        void setId(String id);

        String getName();
        void setName(String name);

        String getDescription();
        void setDescription(String description);

        ClassOfServiceDto getClassOfService();
        void setClassOfService(ClassOfServiceDto classOfService);

        String getTicketId();
        void setTicketId(String ticketId);

        String getWorkflowitemId();
        void setWorkflowitemId(String workflowitemId);

        int getVersion();
        void setVersion(int version);

        String getProjectId();
        void setProjectId(String projectId);

        UserDto getAssignee();
        void setAssignee(UserDto assignee);

        String getOrder();
        void setOrder(String order);

        String getDueDate();
        void setDueDate(String dueDate);

        String getBoardId();
        void setBoardId(String boardId);

        List<TaskTag> getTaskTags();
        void setTaskTags(List<TaskTag> taskTags);
    }

    public interface TasksDto extends BaseDto {
        List<TaskDto> getValues();
        void setValues(List<TaskDto> values);
    }

    public interface FiltersDto {
        List<FilterDto> getValues();
        void setValues(List<FilterDto> values);
    }

    public interface MoveTaskDto extends BaseDto {
        TaskDto getTask();
        void setTask(TaskDto task);

        String getPrevOrder();
        void setPrevOrder(String prevOrder);

        String getNextOrder();
        void setNextOrder(String nextOrder);
    }

    public interface DeleteWorkflowitemDto extends BaseDto {
        WorkflowitemDto getWorkflowitem();
        void setWorkflowitem(WorkflowitemDto workflowitem);

        Boolean getIncludingTasks();
        void setIncludingTasks(Boolean includingTasks);
    }

    public interface WorkflowitemDto extends BaseDto {
        String getName();
        void setName(String name);

        String getId();
        void setId(String id);

        int getWipLimit();
        void setWipLimit(int wipLimit);

        String getItemType();
        void setItemType(String itemType);

        int getVersion();
        void setVersion(int version);

        WorkflowDto getNestedWorkflow();
        void setNestedWorkflow(WorkflowDto nestedWorkflow);

        WorkflowDto getParentWorkflow();
        void setParentWorkflow(WorkflowDto parentWorkflow);

        int getVerticalSize();
        void setVerticalSize(int verticalSize);
    }

    public enum ItemType {
        HORIZONTAL("H"),
        VERTICAL("V");

        private String type;
        private ItemType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

       public static ItemType from(String type) {
           if ("H".equals(type)) {
               return HORIZONTAL;
           }

           if ("V".equals(type)) {
               return VERTICAL;
           }

           return HORIZONTAL;
       }

    }

    public interface WorkflowDto extends BaseDto {
        String getId();
        void setId(String id);

        List<WorkflowitemDto> getWorkflowitems();
        void setWorkflowitems(List<WorkflowitemDto> workflowitems);

        BoardDto getBoard();
        void setBoard(BoardDto board);
    }

    public interface BoardDto extends BaseDto {
        void setName(String name);
        String getName();

        String getId();
        void setId(String id);

        int getVersion();
        void setVersion(int version);

        int getWorkflowVerticalSizing();
        void setWorkflowVerticalSizing(int workflowVerticalSizing);

        WorkflowDto getWorkflow();
        void setWorkflow(WorkflowDto workflow);

        List<TaskDto> getTasks();
        void setTasks(List<TaskDto> tasks);

        boolean isShowUserPictureEnabled();
        void setShowUserPictureEnabled(boolean showUserPictureEnabled);

        boolean isFixedSizeShortDescription();
        void setFixedSizeShortDescription(boolean fixedSizeShortDescription);
    }

    public interface BoardWithProjectsDto extends BaseDto {
        void setBoard(BoardDto board);
        BoardDto getBoard();

        void setProjectsOnBoard(ProjectsDto projectsOnBoard);
        ProjectsDto getProjectsOnBoard();

    }

    public interface BoardsWithProjectsDto extends BaseDto {
        List<BoardWithProjectsDto> getValues();
        void setValues(List<BoardWithProjectsDto> values);
    }

    public interface FilterDataDto {
        void setFullTextFilter(FullTextMatcherDataDto fullTextFilter);
        FullTextMatcherDataDto getFullTextFilter();

        void setUsers(List<UserWithSelectedDto> users);
        List<UserWithSelectedDto> getUsers();

        void setDueDate(DateMatcherDataDto dueDate);
        DateMatcherDataDto getDueDate();

        void setClassesOfServices(List<ClassOfServiceWithSelectedDto> classesOfServices);
        List<ClassOfServiceWithSelectedDto> getClassesOfServices();

        void setBoards(List<BoardWithSelectedDto> boards);
        List<BoardWithSelectedDto> getBoards();

        void setBoardWithProjectsDto(List<BoardWithProjectsWithSelectedDto> boardWithProjectsDto);
        List<BoardWithProjectsWithSelectedDto> getBoardWithProjectsDto();

        void setTaskTags(List<TaskTagWithSelected> taskTags);
        List<TaskTagWithSelected> getTaskTags();

        void setActive(Boolean active);
        Boolean isActive();
    }

    public interface FilterWithSelected {
        void setSelected(Boolean selected);
        Boolean isSelected();
    }

    public interface TaskTagWithSelected extends FilterWithSelected {
        void setTaskTag(TaskTag taskTag);
        TaskTag getTaskTag();
    }

    public interface UserWithSelectedDto extends FilterWithSelected {
        UserDto getUser();
        void setUser(UserDto user);
    }

    public interface ClassOfServiceWithSelectedDto extends FilterWithSelected {
        ClassOfServiceDto getClassOfService();
        void setClassOfService(ClassOfServiceDto classOfService);
    }

    public interface BoardWithSelectedDto extends FilterWithSelected {
        BoardDto getBoard();
        void setBoard(BoardDto board);
    }

    public interface BoardWithProjectsWithSelectedDto extends FilterWithSelected {
        BoardWithProjectsDto getBoardWithProjects();
        void setBoardWithProjects(BoardWithProjectsDto boardWithProjects);
    }

    public interface FullTextMatcherDataDto {
        void setString(String string);
        String getString();

        void setCaseSensitive(Boolean caseSensitive);
        Boolean isCaseSensitive();

        void setRegex(Boolean regex);
        Boolean isRegex();

        void setInverse(Boolean inverse);
        Boolean isInverse();

        void setFilteredEntities(List<FilteredEntity> filteredEntities);
        List<FilteredEntity> getFilteredEntities();
    }

    public enum FilteredEntity {
        SHORT_DESCRIPTION(1),
        LONG_DESCRIPTION(2),
        TICKET_ID(3);

        private int id;

        public int getId() {
            return id;
        }

        private FilteredEntity(int id) {
            this.id = id;
        }

    }

    public interface DateMatcherDataDto {
        void setDateFrom(String dateFrom);
        String getDateFrom();

        void setDateTo(String dateTo);
        String getDateTo();

        void setCondition(Integer condition);
        Integer getCondition();
    }

    public interface GetAllBoardsWithProjectsDto extends BaseDto {
        void setIncludeTasks(Boolean includeTasks);
        Boolean isIncludeTasks();

        void setIncludeTaskDescription(Boolean includeTaskDescription);
        Boolean isIncludeTaskDescription();

        List<FilterDto> getFilters();
        void setFilters(List<FilterDto> filters);
    }

    public interface EditWorkflowParams extends BaseDto {
        void setCurrent(WorkflowitemDto current);
        WorkflowitemDto getCurrent();

        void setNext(WorkflowitemDto next);
        WorkflowitemDto getNext();

        void setDestinationWorkflow(WorkflowDto next);
        WorkflowDto getDestinationWorkflow();

        void setBoard(BoardDto board);
        BoardDto getBoard();

    }

    public enum WorkflowVerticalSizing {
        BALANCED(-1),
        MIN_POSSIBLE(1);

        private int sizing;

        private WorkflowVerticalSizing(int sizing) {
            this.sizing = sizing;
        }

        public int getSizing() {
            return sizing;
        }

        public static WorkflowVerticalSizing from(int i) {
            if (i == 0 || i == -1) {
                return BALANCED;
            }

            if (i == 1) {
                return MIN_POSSIBLE;
            }

            // default
            return BALANCED;
        }
    }

    public interface EmptyDto {

    }

    public interface FilterDto {
        void setBid(String bid);
        void setBname(String bname);

        String getBid();
        String getBname();

        void setPid(String pid);
        void setPname(String pname);

        String getPid();
        String getPname();
    }

}
