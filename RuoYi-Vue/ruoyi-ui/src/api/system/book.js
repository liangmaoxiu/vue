import request from '@/utils/request'

// 查询教材信息列表
export function listBook(query) {
  return request({
    url: '/system/book/list',
    method: 'get',
    params: query
  })
}

// 查询教材信息详细
export function getBook(bookId) {
  return request({
    url: '/system/book/' + bookId,
    method: 'get'
  })
}

// 新增教材信息
export function addBook(data) {
  return request({
    url: '/system/book',
    method: 'post',
    data: data
  })
}

// 修改教材信息
export function updateBook(data) {
  return request({
    url: '/system/book',
    method: 'put',
    data: data
  })
}

// 删除教材信息
export function delBook(bookId) {
  return request({
    url: '/system/book/' + bookId,
    method: 'delete'
  })
}

// 导出教材信息
export function exportBook(query) {
  return request({
    url: '/system/book/export',
    method: 'get',
    params: query
  })
}

// 下载商品导入模板
export function importTemplate() {
  return request({
    url: '/system/book/importTemplate',
    method: 'get'
  })
}