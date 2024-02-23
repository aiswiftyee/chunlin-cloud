package com.chunlin.cloud.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * Mybatis Plus 自动填充配置
 */
@Slf4j
@Component
public class CustomMetaObjectHandler implements MetaObjectHandler {

    public static final String CREATE_TIME_FIELD = "createTime";

    public static final String CREATOR_ID_FIELD = "creatorId";

    public static final String UPDATE_TIME_FIELD = "updateTime";

    public static final String UPDATER_ID_FIELD = "updaterId";

    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasSetter(CREATE_TIME_FIELD)) {
            this.setFieldValByName(CREATE_TIME_FIELD, new Date(), metaObject);
        }

        Long userId = getUserIdSafely();
        if (metaObject.hasSetter(CREATOR_ID_FIELD) && userId != null) {
            this.strictInsertFill(metaObject, CREATOR_ID_FIELD, Long.class, getUserIdSafely());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasSetter(UPDATE_TIME_FIELD)) {
            this.setFieldValByName(UPDATE_TIME_FIELD, new Date(), metaObject);
        }

        Long userId = getUserIdSafely();
        if (metaObject.hasSetter(UPDATER_ID_FIELD) && userId != null) {
            this.strictUpdateFill(metaObject, UPDATER_ID_FIELD, Long.class, getUserIdSafely());
        }
    }

    public Long getUserIdSafely() {
        // TODO 临时使用管理员 ID，需要实现获取已登录用户 ID
        return 1L;
    }

}
