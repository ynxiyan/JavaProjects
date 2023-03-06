package com.dao.impl;

import com.dao.AuthorDao;
import com.model.Author;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/5 20:13
 * @注释:实现作者接口
 */
public class AuthorDaoImpl extends BasicDao implements AuthorDao {
    private final String select = "select author.id,author.name,contact,phone,province.id as 'province_id',province.name as 'province',city.id as 'city_id',city.name as 'city',address ";
    private final String count = "count(1) as 'count' ";
    private final String from = "from author,province,city ";

    @Override
    public int selectAuthorByCount() {
        String sql = "select " + count + " from author";
        return Integer.parseInt(selectAggregate(sql).toString());
    }

    @Override
    public List<Author> selectAuthorAll(int begin, int pageSize) {
        String sql = select + from + "where author.province_id=province.id and author.city_id=city.id limit ?,?";
        return selectList(Author.class, sql, begin, pageSize);
    }

    @Override
    public List<Author> selectAuthorByName(int begin, int pageSize, Author author) {
        String sql = select + "," + count + from + "where author.name like ? and author.province_id=province.id and author.city_id=city.id group by author.id limit ?,?";
        return selectList(Author.class, sql, "%" + author.getName() + "%", begin, pageSize);
    }

    @Override
    public List<Author> selectAuthorByProvince_city(int begin, int pageSize, Author author) {
        String sql = select + "," + count + from + "where author.province_id=? and city_id=? and author.province_id=province.id and author.city_id=city.id group by author.id limit ?,?";
        return selectList(Author.class, sql, author.getProvince(), author.getCity(), begin, pageSize);
    }

    @Override
    public List<Author> selectAuthorByPhone(int begin, int pageSize, Author author) {
        String sql = select + "," + count + from + "where phone=? and author.province_id=province.id and author.city_id=city.id group by author.id limit ?,?";
        return selectList(Author.class, sql, author.getPhone(), begin, pageSize);
    }

    @Override
    public List<Author> selectAuthorByContact(int begin, int pageSize, Author author) {
        String sql = select + "," + count + from + "where contact like ? and author.province_id=province.id and author.city_id=city.id group by author.id limit ?,?";
        return selectList(Author.class, sql, "%" + author.getContact() + "%", begin, pageSize);
    }

    @Override
    public int insertAuthor(Author author) {
        String sql = "insert into author(name,contact,phone,province_id,city_id,address) values(?,?,?,?,?,?);";
        return update(sql, author.getName(), author.getContact(), author.getPhone(), author.getProvince(), author.getCity(), author.getAddress());
    }

    @Override
    public int deleteAuthorById(Author author) {
        String sql = "delete from author where id=?";
        return update(sql, author.getId());
    }

    @Override
    public int updateAuthorById(Author author) {
        String sql = "update author set author.name=?,contact=?,phone=?,author.province_id=?,author.city_id=?,address=? where author.id=?";
        return update(sql, author.getName(), author.getContact(), author.getPhone(), author.getProvince(), author.getCity(), author.getAddress(), author.getId());
    }
}
