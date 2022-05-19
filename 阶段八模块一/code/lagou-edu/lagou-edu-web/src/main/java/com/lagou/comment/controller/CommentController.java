package com.lagou.comment.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lagou.comment.CommentService;
import com.lagou.entity.CourseComment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject:com.lagou.comment.controller
 * @Author: JinHua
 * @CreateTime:2022/5/12
 * @Description:
 */
@RestController
@RequestMapping("course")
public class CommentController {
    @Reference // 远程消费
    private CommentService commentService;

    @GetMapping("comment/saveCourseComment")
    public Object saveCourseComment() {
        CourseComment comment = new CourseComment();
        comment.setCourseId(7); // 课程编号
        comment.setSectionId(8); // 章节编号
        comment.setLessonId(10);// 小节编号
        comment.setUserId(100030011); // 用户编号
        comment.setUserName("Angier"); // 用户昵称
        comment.setParentId(0); //没有父id
        comment.setComment("old tie, 666!");// 留言内容
        comment.setType(0); // 0用户留言
        comment.setLastOperator(100030011); //最后操作的用户编号
        Integer i = commentService.saveComment(comment);
        System.out.println(i);
        return null;
    }

    @GetMapping("comment/getCourseCommentList/{courseid}/{pageIndex}/{pageSize}")
    public List<CourseComment> getCommentsByCourseId(@PathVariable("courseid")
                                                             Integer courseid,
                                                     @PathVariable("pageIndex")
                                                             Integer pageIndex,
                                                     @PathVariable("pageSize")
                                                             Integer pageSize) {
        return commentService.getCommentsByCourseId(courseid, pageIndex, pageSize);
    }

    // 点赞
    @GetMapping("comment/saveFavorite/{commentid}/{userid}")
    public Integer saveFavorite(@PathVariable("commentid") Integer
                                        commentid, @PathVariable("userid") Integer userid) {
        return commentService.saveFavorite(commentid, userid);
    }

    // 取消赞
    @GetMapping("comment/cancelFavorite/{commentid}/{userid}")
    public Integer cancelFavorite(@PathVariable("commentid") Integer
                                          commentid, @PathVariable("userid") Integer userid) {
        return commentService.cancelFavorite(commentid, userid);
    }
}
