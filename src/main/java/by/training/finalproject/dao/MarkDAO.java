package by.training.finalproject.dao;

import by.training.finalproject.entity.Mark;

import java.util.List;

public interface MarkDAO extends AbstractDAO<Mark,Integer> {
    List<Mark> findByUser();
    List<Mark> findByRecipe();
}
