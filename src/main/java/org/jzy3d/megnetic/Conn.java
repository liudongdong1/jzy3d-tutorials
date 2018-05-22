package org.jzy3d.megnetic;

import java.sql.*;
import java.util.Queue;

public class Conn {
    public static Connection connection;      //声明Connection对象

    public static Connection getConnection() {    //建立返回值为Connection的方法
        if (connection != null)
            return connection;
        try {                             //加载数据库驱动
            Class.forName("org.sqlite.JDBC");
            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {                 //通过访问数据库的URL获取数据库连接对象
            connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/liudongdong19/Desktop/intel/myTest.db");
            System.out.println("数据库连接成功");
            System.out.print('\n');
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;           //按方法要求放回一个Connection对象
    }
    //private static final String savesql = "insert into t_SampleDatas(SampleData, description, level, image, difficulty, pinyin, sortOrder) values(?, ?, ?, ?, ?, ?, ?)";

    // private static final String updatesql = "update t_SampleDatas set SampleData=?, description=?, level=?, image=?, difficulty=?, pinyin=?, sortOrder=? where id=?";

   /* *//**
     * 保存
     *
     * @throws SQLException
     * @param1 表名
     * @return2 需要存储数据
     *//*
    public void add(String tableName, SampleData sampleData) throws SQLException {

        Connection connection = getConnection();

        PreparedStatement prep = connection.prepareStatement(savesql);

        prep.setString(1, SampleData.getSampleData());
        prep.setString(2, SampleData.getDescription());
        prep.setInt(3, SampleData.getLevel());
        prep.setBytes(4, SampleData.getImage());
        prep.setInt(5, SampleData.getDifficulty());
        prep.setString(6, SampleData.getPinyin());
        prep.setInt(7, SampleData.getSortOrder());
        prep.addBatch();

        connection.setAutoCommit(false);
        prep.executeBatch();
        connection.setAutoCommit(true);
    }

    *//**
     * 修改
     *
     * @throws SQLException
     * @param1 表名
     * @param2 需要添加的数据
     *//*
    public static void update(String tableName, Queue<SampleData> mQueue) throws SQLException {
        Connection connection = getConnection();

        PreparedStatement prep = connection.prepareStatement(updatesql);

        prep.setString(1, SampleData.getSampleData());
        prep.setString(2, SampleData.getDescription());
        prep.setInt(3, SampleData.getLevel());
        prep.setBytes(4, SampleData.getImage());
        prep.setInt(5, SampleData.getDifficulty());
        prep.setString(6, SampleData.getPinyin());
        prep.setInt(7, SampleData.getSortOrder());
        prep.setInt(8, SampleData.getId());

        connection.setAutoCommit(false);
        prep.executeUpdate();
        connection.setAutoCommit(true);
    }

    *//**
     * 列表
     *
     * @param sql
     * @return
     * @throws SQLException
     *//*
    public static List<SampleData> list(String sql) throws SQLException {

        Connection connection = getConnection();
        Statement stat = connection.createStatement();
        ResultSet rs = stat.executeQuery(sql);

        List<SampleData> SampleDatas = new ArrayList<>();

        SampleData SampleData;
        while (rs.next()) {
            SampleData = new SampleData();
            readResult(rs, SampleData);
            SampleDatas.add(SampleData);
        }
        rs.close();

        return SampleDatas;
    }

    *//**
     * 获取
     *
     * @param sql
     * @return
     * @throws SQLException
     *//*
    public static SampleData get(int id) throws SQLException {

        Connection connection = getConnection();
        Statement stat = connection.createStatement();
        ResultSet rs = stat.executeQuery("select * from t_SampleDatas where id = " + id);

        SampleData SampleData;
        if (rs.next()) {
            SampleData = new SampleData();
            readResult(rs, SampleData);
        } else {
            SampleData = null;
        }
        rs.close();

        return SampleData;
    }

    private static void readResult(ResultSet rs, SampleData SampleData) throws SQLException {
        SampleData.setId(rs.getInt("id"));
        SampleData.setSampleData(rs.getString("SampleData"));
        SampleData.setPinyin(rs.getString("pinyin"));
        SampleData.setImage(rs.getBytes("image"));
        SampleData.setLevel(rs.getInt("level"));
        SampleData.setDifficulty(rs.getInt("difficulty"));
        SampleData.setDescription(rs.getString("description"));
        SampleData.setSortOrder(rs.getInt("sortOrder"));
    }

    *//**
     * 执行Sql
     *
     * @param sql
     * @throws SQLException
     *//*
    public static void execute(String sql) throws SQLException {

        Connection connection = getConnection();

        Statement statement = connection.createStatement();

        statement.execute(sql);

    }*/

}
