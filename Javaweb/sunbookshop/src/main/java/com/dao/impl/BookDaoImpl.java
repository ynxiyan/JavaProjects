package com.dao.impl;

import com.dao.BookDao;
import com.model.Author;
import com.model.Book;
import com.model.Type;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/6 16:54
 * @注释:实现图书接口
 */
public class BookDaoImpl extends BasicDao implements BookDao {
    //公共查询方法
    //查询字段
    private final String select = "select books.id,book_name,author.id as 'author_id',author.name as 'name',type.id as 'type_id',type.name as 'type',ISBN,price,inventory,in_flg ";
    //查询总数
    private final String count = "count(1) as 'count' ";
    //表
    private final String from = "from books,author,type ";

    @Override
    public int selectBookByCount() {
        String sql = "select " + count + "from books";
        return Integer.parseInt(selectAggregate(sql).toString());
    }

    @Override
    public List<Author> selectByAuthor() {
        String sql = "select id,name as 'name' from author";
        return selectList(Author.class, sql);
    }

    @Override
    public List<Type> selectByType() {
        String sql = "select id,name as 'type' from type";
        return selectList(Type.class, sql);
    }

    @Override
    public List<Book> selectBookAll(int begin, int pageSize) {
        String sql = select + from + "where books.author_id=author.id and books.type_id=type.id limit ?,?";
        return selectList(Book.class, sql, begin, pageSize);
    }

    @Override
    public List<Book> selectBookByBook_name(int begin, int pageSize, Book book) {
        String sql = select + "," + count + from + "where book_name like ? and books.author_id=author.id and books.type_id=type.id group by books.id limit ?,?";
        return selectList(Book.class, sql, "%" + book.getBook_name() + "%", begin, pageSize);
    }

    @Override
    public List<Book> selectBookByAuthor(int begin, int pageSize, Book book) {
        String sql = select + "," + count + from + "where books.author_id=? and books.author_id=author.id and books.type_id=type.id group by books.id limit ?,?";
        return selectList(Book.class, sql, book.getName(), begin, pageSize);
    }

    @Override
    public List<Book> selectBookByType(int begin, int pageSize, Book book) {
        String sql = select + "," + count + from + "where books.type_id=? and books.author_id=author.id and books.type_id=type.id group by books.id limit ?,?";
        return selectList(Book.class, sql, book.getType(), begin, pageSize);
    }

    @Override
    public int insertBook(Book book) {
        String sql = "insert into books(book_name,author_id,type_id,ISBN,price,inventory,in_flg) values(?,?,?,?,?,?,?);";
        return update(sql, book.getBook_name(), book.getName(), book.getType(), book.getISBN(), book.getPrice(), book.getInventory(), book.getIn_flg());
    }

    @Override
    public int updateBookById(Book book) {
        String sql = "update books set in_flg=1 where id=?";
        return update(sql, book.getId());
    }

    @Override
    public int deleteBookById(Book book) {
        String sql = "delete from books where id=?";
        return update(sql, book.getId());
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update books set book_name=?,author_id=?,type_id=?,ISBN=?,price=?,inventory=? where books.id=?";
        return update(sql, book.getBook_name(), book.getName(), book.getType(), book.getISBN(), book.getPrice(), book.getInventory(), book.getId());
    }
}
