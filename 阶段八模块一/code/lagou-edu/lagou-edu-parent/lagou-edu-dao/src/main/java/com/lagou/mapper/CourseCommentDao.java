package com.lagou.mapper;


import com.lagou.entity.CourseComment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程留言表(CourseComment)表数据库访问层
 *
 * @author JinHua
 * @since 2022-05-12 05:04:40
 */
@Service
public interface CourseCommentDao {

    /**
     * 保存评论
     *
     * @param comment
     * @return
     */
    Integer saveComment(CourseComment comment);

    /**
     * 某个课程的全部留言（分页）
     *
     * @param courseid 课程编号
     * @param offset   数据偏移
     * @param pageSize 每页条目数
     * @return 留言集合
     */
    List<CourseComment> getCommentsByCourseId(@Param("courseid") Integer courseid,
                                              @Param("offset") Integer offset,
                                              @Param("pageSize") Integer pageSize);

    /**
     * 查看某个用户的某条留言是否点过赞
     *
     * @param comment_id 留言编号
     * @param userid     用户编号
     * @return 0：没点过赞，1：点过赞
     */
    Integer existsFavorite(@Param("cid") Integer comment_id, @Param("uid") Integer
            userid);

    /**
     * 保存点赞信息
     *
     * @param comment_id 留言编号
     * @param userid     用户编号
     * @return 0：保存失败，1：保存成功
     */
    Integer saveCommentFavorite(@Param("cid") Integer comment_id, @Param("uid") Integer userid);

    /**
     * 更新点赞信息的状态（将is_del=0，表示已赞）
     *
     * @param status     状态，0：已赞，1：取消赞
     * @param comment_id 留言编号
     * @param userid     用户编号
     * @return 0：保存失败，1：保存成功
     */


    Integer updateFavoriteStatus(@Param("status") Integer status, @Param("cid") Integer comment_id, @Param("uid") Integer userid);

    /**
     * 更新点赞的数量
     *
     * @param x          +1的话，赞的数量增加，-1的话，赞的数量减少
     * @param comment_id 某条留言的编号
     * @return 0：保存失败，1：保存成功
     */


    Integer updateLikeCount(@Param("x") Integer x, @Param("comment_id") Integer comment_id);

}

