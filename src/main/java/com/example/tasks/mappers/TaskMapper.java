package com.example.tasks.mappers;

import com.example.tasks.models.Task;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TaskMapper {

    @Insert("INSERT INTO tasks(name, description, start_date) VALUES(#{name}, #{description}, #{startDate})")
    void insertTask(Task task);

    @Select("SELECT id, name, description, start_date AS startDate FROM tasks WHERE id = #{id}")
    Task getTaskById(int id);

    @Select("SELECT id, name, description, start_date AS startDate FROM tasks")
    List<Task> getAllTasks();

    @Update("UPDATE tasks SET name = #{name}, description = #{description}, start_date = #{startDate} WHERE id = #{id}")
    void updateTask(Task task);

    @Delete("DELETE FROM tasks WHERE id = #{id}")
    void deleteTask(int id);
}
