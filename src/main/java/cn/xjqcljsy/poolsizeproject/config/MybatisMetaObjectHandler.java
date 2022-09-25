package cn.xjqcljsy.poolsizeproject.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "ctime", Timestamp.class, new Timestamp(System.currentTimeMillis()));
        this.strictInsertFill(metaObject, "utime", Timestamp.class, new Timestamp(System.currentTimeMillis()));
        this.strictInsertFill(metaObject, "deleted", Integer.class, 0);
        this.strictInsertFill(metaObject, "version", Integer.class, 1);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "utime", Timestamp.class, new Timestamp(System.currentTimeMillis()));
    }
}
