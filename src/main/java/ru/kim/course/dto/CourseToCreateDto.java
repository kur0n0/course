package ru.kim.course.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CourseToCreateDto {

    @NotBlank(message = "Название курса не должно быть пустым")
    @Size(min = 3, max = 255, message = "Длина названия курса не должна быть от 3 до 255 символов")
    private String name;

    @Size(max = 255, message = "Длина описания не должна быть больше 255")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
