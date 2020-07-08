package com.ruoyi.project.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 教材信息对象 book
 * 
 * @author ruoyi
 * @date 2020-07-07
 */
public class Book extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 书本ID */
    private Long bookId;

    /** 商品编号 */
    private String code;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String name;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private BigDecimal price;

    /** 适用年级 */
    @Excel(name = "适用年级")
    private String grade;

    /* 出版社*/
    @Excel(name="出版社")
    private String remark;

    /* 库存*/
    @Excel(name="库存")
    private Integer stock;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /** 最后登陆IP */
    private String loginIp;

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /** 最后登陆时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date loginDate;

    public void setBookId(Long bookId) 
    {
        this.bookId = bookId;
    }

    public Long getBookId() 
    {
        return bookId;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setGrade(String grade) 
    {
        this.grade = grade;
    }

    public String getGrade() 
    {
        return grade;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }
    public void setLoginIp(String loginIp) 
    {
        this.loginIp = loginIp;
    }

    public String getLoginIp() 
    {
        return loginIp;
    }
    public void setLoginDate(Date loginDate) 
    {
        this.loginDate = loginDate;
    }

    public Date getLoginDate() 
    {
        return loginDate;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bookId", getBookId())
            .append("code", getCode())
            .append("name", getName())
            .append("price", getPrice())
            .append("grade", getGrade())
            .append("delFlag", getDelFlag())
            .append("loginIp", getLoginIp())
            .append("loginDate", getLoginDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("stock", getStock())
            .toString();
    }
}
