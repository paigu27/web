package com.myblog.repository;

import com.myblog.common.PageResult;
import com.myblog.model.Message;

import java.util.List;
import java.util.Optional;

/**
 * Week 05 - 存储边界（Repository 接口）。
 * 边界不是地点，是对上层的一个承诺：无论存储是内存 List 还是 MySQL，接口不变。
 * Week 07 - 增加 search（在记忆中发现）。
 */
public interface MessageRepository {

    /** 保存一条留言，返回带 id 的实体。 */
    Message save(Message message);

    /** 全部留言（Week 07 后由 search 取代，保留作单条/测试用途）。 */
    List<Message> findAll();

    /** 按 id 取一条；不存在返回 empty。 */
    Optional<Message> findById(Long id);

    /** Week 07：keyword 过滤 + page/size 分页，total 必须来自数据库。 */
    PageResult<Message> search(String keyword, int page, int size);
}
