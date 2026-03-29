package com.example.TODOApplication.Repository;

import com.example.TODOApplication.POJO.Todo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TODORepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void save(Todo todo) {
        entityManager.persist(todo);
    }

    public List<Todo> findAll() {               // HQl (HIBRENATE QUERY LANGUAGE)
        TypedQuery<Todo> typedQuery = entityManager.createQuery("from Todo",Todo.class);
        return typedQuery.getResultList();
    }

    public Optional<Todo> findTODOById(long id) {
        Todo todo = entityManager.find(Todo.class,id);
        return Optional.ofNullable(todo);
    }

    @Transactional
    public void updateTodo(Todo oldTodo) {
        entityManager.merge(oldTodo);
    }
}
