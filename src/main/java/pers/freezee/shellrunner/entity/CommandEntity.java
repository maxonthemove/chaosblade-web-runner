package pers.freezee.shellrunner.entity;

import lombok.Data;

import java.util.List;

/**
 * 命令实体
 */
@Data
public class CommandEntity {
    /**
     * 键,命令字段
     */
    private String key;
    /**
     * 子命令对象
     */
    private transient List<CommandEntity> children;
    /**
     * 命令描述信息
     */
    private String desc;
}
