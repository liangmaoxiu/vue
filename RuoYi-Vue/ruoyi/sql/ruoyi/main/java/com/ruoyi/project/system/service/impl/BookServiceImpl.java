package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.BookMapper;
import com.ruoyi.project.system.domain.Book;
import com.ruoyi.project.system.service.IBookService;

/**
 * 教材信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-07
 */
@Service
public class BookServiceImpl implements IBookService 
{
    @Autowired
    private BookMapper bookMapper;

    /**
     * 查询教材信息
     * 
     * @param bookId 教材信息ID
     * @return 教材信息
     */
    @Override
    public Book selectBookById(Long bookId)
    {
        return bookMapper.selectBookById(bookId);
    }

    /**
     * 查询教材信息列表
     * 
     * @param book 教材信息
     * @return 教材信息
     */
    @Override
    public List<Book> selectBookList(Book book)
    {
        return bookMapper.selectBookList(book);
    }

    /**
     * 新增教材信息
     * 
     * @param book 教材信息
     * @return 结果
     */
    @Override
    public int insertBook(Book book)
    {
        book.setCreateTime(DateUtils.getNowDate());
        return bookMapper.insertBook(book);
    }

    /**
     * 修改教材信息
     * 
     * @param book 教材信息
     * @return 结果
     */
    @Override
    public int updateBook(Book book)
    {
        book.setUpdateTime(DateUtils.getNowDate());
        return bookMapper.updateBook(book);
    }

    /**
     * 批量删除教材信息
     * 
     * @param bookIds 需要删除的教材信息ID
     * @return 结果
     */
    @Override
    public int deleteBookByIds(Long[] bookIds)
    {
        return bookMapper.deleteBookByIds(bookIds);
    }

    /**
     * 删除教材信息信息
     * 
     * @param bookId 教材信息ID
     * @return 结果
     */
    @Override
    public int deleteBookById(Long bookId)
    {
        return bookMapper.deleteBookById(bookId);
    }
}
