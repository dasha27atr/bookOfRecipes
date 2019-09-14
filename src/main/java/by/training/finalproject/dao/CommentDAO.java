package by.training.finalproject.dao;

import by.training.finalproject.entity.Comment;
import by.training.finalproject.entity.Mark;

import java.util.List;

public interface CommentDAO extends AbstractDAO<Mark,Integer> {
    List<Comment> findByUser();
    List<Comment> findByRecipe();
}
