package com.dancoder.redash.dao.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author dancoder
 */
@Data
@TableName(value = "users")
public class UserDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orgId;
    private String name;
    private String email;
    private String profileImageUrl;
    private String passwordHash;
    private Integer[] groups;
    private String apiKey;
    private Timestamp disabledAt;
    private Object details;

    @LastModifiedDate
    private Timestamp createdAt;
    @LastModifiedDate
    private Timestamp updatedAt;

    // PG json 使用model、mapper、以及数据操作时的写法：https://blog.csdn.net/weixin_42800689/article/details/91413254

    // https://www.cnblogs.com/kylindai/p/3563818.html
}
