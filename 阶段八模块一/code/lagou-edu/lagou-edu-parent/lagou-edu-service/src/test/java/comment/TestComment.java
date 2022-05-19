package comment;

import com.lagou.comment.CommentService;
import com.lagou.entity.CourseComment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @BelongsProject:comment
 * @Author: JinHua
 * @CreateTime:2022/5/12
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-*.xml"})
public class TestComment {
    @Autowired
    private CommentService commentService;

    @Test
    public void getCommentsByCourseId() {
//        int pageSize = 20;
//        int pageIndex = 3; //页码（第几页）
//        List<CourseComment> list = commentService.getCommentsByCourseId(1,
//                (pageIndex - 1) * pageSize, pageSize);
//        for (int i = 0; i < list.size(); i++) {
//            CourseComment comment = list.get(i);
//            System.out.println((i + 1) + "、楼     【" + comment.getUserName() + "】     说：" + comment.getComment());
//        }
    }
}
