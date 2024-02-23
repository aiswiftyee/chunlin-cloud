package com.chunlin.cloud.domain.system.entity.db;

import com.chunlin.cloud.domain.system.entity.SysUserEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DO（Data Object，数据对象）：如果实体类的字段和复杂查询不匹配时，使用 DO 来接收
 * <p>
 *     <ul>
 *         <li>DO 的概念相对通用，有时可以与 Entity 重叠使用，用来表示应用程序内部使用的数据结构，尤其是在分层架构中，DO 用于在应用的不同层级之间传递数据</li>
 *         <li>在某些上下文中，DO 也可以特指业务逻辑层（Business Logic Layer, BLL）中处理业务逻辑的数据对象，它包含了业务逻辑所需的所有属性，可能是对 Entity 的扩展或简化</li>
 *         <li>不同项目或团队可能会有不同的定义，有的地方将 DO 视为纯粹的数据容器，与 Entity 类似但仅限于应用内部使用，而不涉及持久化层的具体实现</li>
 *     </ul>
 * </p>
 * <p>
 *     总结如下：
 *     <ul>
 *         <li>Entity 通常与数据库直接关联，负责数据的持久化</li>
 *         <li>DTO 专注于跨服务或客户端 - 服务器间的通信，包含的是数据传输所需的最小属性集</li>
 *         <li>DO 则更多关注应用内部数据的表示，它可以作为业务逻辑处理的对象，也可能用作 Entity 和其他数据结构的中间载体</li>
 *     </ul>
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchUserDO extends SysUserEntity {

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门负责人
     */
    private String deptLeader;

}

