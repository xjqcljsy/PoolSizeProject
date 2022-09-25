package cn.xjqcljsy.poolsizeproject.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.sql.Timestamp;

@Data
@TableName(value = "t_user")
public class User {
    @TableId(value = "f_id",type = IdType.ASSIGN_ID)
    private String id;
    @TableField(value = "f_name")
    private String name;
    @TableField(value = "f_age")
    private Integer age;
    @TableField(value = "f_address")
    private String address;
    @TableField(value = "f_ctime",fill = FieldFill.INSERT)
    private Timestamp ctime;
    @TableField(value = "f_utime",fill = FieldFill.INSERT_UPDATE)
    private Timestamp utime;
    @TableLogic(value = "0",delval = "f_id")
    @TableField(value = "f_deleted", fill = FieldFill.INSERT)
    private Integer deleted;
    @Version
    @TableField(value = "f_version", fill = FieldFill.INSERT)
    private Integer version;
}
