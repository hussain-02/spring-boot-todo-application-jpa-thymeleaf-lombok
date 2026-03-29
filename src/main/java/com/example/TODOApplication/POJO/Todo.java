package com.example.TODOApplication.POJO;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "todoTasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Todo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;
    private String taskContent;
    private boolean completionStatus;

}
