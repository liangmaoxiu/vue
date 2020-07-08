package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.Book;
import com.ruoyi.project.system.domain.SysUser;

/**
 * 教材信息Service接口
 * 
 * @author ruoyi
 * @date 2020-07-07
 */
public interface IBookService 
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
     * 批量删除教材信息
     * 
     * @param bookIds 需要删除的教材信息ID
     * @return 结果
     */
    public int deleteBookByIds(Long[] bookIds);

    /**
     * 删除教材信息信息
     * 
     * @param bookId 教材信息ID
     * @return 结果
     */
    public int deleteBookById(Long bookId);

    /**
     * 导入商户数据
     *
     * @param bookList 商户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param name 操作用户
     * @return 结果
     */
    public String importGoods( List<Book> bookList, Boolean isUpdateSupport, String name);
}
