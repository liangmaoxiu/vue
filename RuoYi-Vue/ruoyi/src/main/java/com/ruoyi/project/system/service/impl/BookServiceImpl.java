package com.ruoyi.project.system.service.impl;

import java.util.List;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
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

    /**
     * 导入商品信息
     * @param bookList 商户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param name 操作用户
     * @return
     */
    @Override
    public String importGoods(List<Book> bookList, Boolean isUpdateSupport, String name) {
        if (StringUtils.isNull(bookList) || bookList.size() == 0)
        {
            throw new CustomException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Book book : bookList)
        {
            try
            {
                // 验证是否存在这个用户
                Book obj = bookMapper.selectByName(book.getName());
                if (StringUtils.isNull(obj))
                {
                    book.setCreateBy(name);
                    this.insertBook(book);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、商品名称 " + book.getName() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    book.setUpdateBy(name);
                    this.updateBook(book);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、商品名称 " + book.getName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、商品名称 " +  book.getName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、商品名称 " + book.getName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
