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
    String key;
    /**
     * 子命令对象
     */
    List<CommandEntity> children;
    /**
     * 命令描述信息
     */
    String desc;
}
