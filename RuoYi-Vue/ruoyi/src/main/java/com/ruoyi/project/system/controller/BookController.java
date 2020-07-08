package com.ruoyi.project.system.controller;

import java.util.List;

import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.security.LoginUser;
import com.ruoyi.framework.security.service.TokenService;
import com.ruoyi.project.system.domain.SysUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.domain.Book;
import com.ruoyi.project.system.service.IBookService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 教材信息Controller
 * 
 * @author ruoyi
 * @date 2020-07-07
 */
@RestController
@RequestMapping("/system/book")
public class BookController extends BaseController
{
    @Autowired
    private IBookService bookService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询教材信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:book:list')")
    @GetMapping("/list")
    public TableDataInfo list(Book book)
    {
        startPage();
        List<Book> list = bookService.selectBookList(book);
        return getDataTable(list);
    }

    /**
     * 导出教材信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:book:export')")
    @Log(title = "教材信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Book book)
    {
        List<Book> list = bookService.selectBookList(book);
        ExcelUtil<Book> util = new ExcelUtil<Book>(Book.class);
        return util.exportExcel(list, "book");
    }

    /**
     * 获取教材信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:book:query')")
    @GetMapping(value = "/{bookId}")
    public AjaxResult getInfo(@PathVariable("bookId") Long bookId)
    {
        return AjaxResult.success(bookService.selectBookById(bookId));
    }

    /**
     * 新增教材信息
     */
    @PreAuthorize("@ss.hasPermi('system:book:add')")
    @Log(title = "教材信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Book book)
    {
        return toAjax(bookService.insertBook(book));
    }

    /**
     * 修改教材信息
     */
    @PreAuthorize("@ss.hasPermi('system:book:edit')")
    @Log(title = "教材信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Book book)
    {
        return toAjax(bookService.updateBook(book));
    }

    /**
     * 删除教材信息
     */
    @PreAuthorize("@ss.hasPermi('system:book:remove')")
    @Log(title = "教材信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{bookIds}")
    public AjaxResult remove(@PathVariable Long[] bookIds)
    {
        return toAjax(bookService.deleteBookByIds(bookIds));
    }


    @Log(title = "商品管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:book:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<Book> util = new ExcelUtil<>(Book.class);
        List<Book> bookList = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String name = loginUser.getUsername();
        String message = bookService.importGoods(bookList, updateSupport, name);
        return AjaxResult.success(message);
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<Book> util = new ExcelUtil<>(Book.class);
        return util.importTemplateExcel("商户数据");
    }

}
