package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.Book;

/**
 * 教材信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-07-07
 */
public interface BookMapper 
{
    /**
     * 查询教材信息
     * 
     * @param bookId 教材信息ID
     * @return 教材信息
     */
    public Book selectBookById(Long bookId);

    /**
     * 查询教材信息列表
     * 
     * @param book 教材信息
     * @return 教材信息集合
     */
    public List<Book> selectBookList(Book book);

    /**
     * 新增教材信息
     * 
     * @param book 教材信息
     * @return 结果
     */
    public int insertBook(Book book);

    /**
     * 修改教材信息
     * 
     * @param book 教材信息
     * @return 结果
     */
    public int updateBook(Book book);

    /**
     * 删除教材信息
     * 
     * @param bookId 教材信息ID
     * @return 结果
     */
    public int deleteBookById(Long bookId);

    /**
     * 批量删除教材信息
     * 
     * @param bookIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBookByIds(Long[] bookIds);
}
