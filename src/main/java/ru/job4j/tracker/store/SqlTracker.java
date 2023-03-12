package ru.job4j.tracker.store;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Store;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    public SqlTracker() {
    }

    private void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public Item add(Item item) {
        Timestamp timestamp = Timestamp.valueOf(item.getCreated());
        try (PreparedStatement st =
                     cn.prepareStatement("insert into items (name, created) values (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, item.getName());
            st.setTimestamp(2, timestamp);
            st.execute();
            try (ResultSet key = st.getGeneratedKeys()) {
                if (key.next()) {
                    item.setId(key.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        var result = false;
        Timestamp timestamp = Timestamp.valueOf(item.getCreated());
        try (PreparedStatement st =
                     cn.prepareStatement("update items set name = ?, created = ? where id = ?")) {
            st.setString(1, item.getName());
            st.setTimestamp(2, timestamp);
            st.setInt(3, id);
            result = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        var result = false;
        try (PreparedStatement st =
                     cn.prepareStatement("delete from items where id = ?")) {
            st.setInt(1, id);
            result = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement st = cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = st.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement st = cn.prepareStatement("select * from items where name = ?")) {
            st.setString(1, key);
            try (ResultSet resultSet = st.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name")
                    ));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return items;
    }

    @Override
    public Item findById(int id) throws SQLException {
        var resultItem = new Item();
        try (PreparedStatement st = cn.prepareStatement("select * from items where id = ?")) {
            st.setInt(1, id);
            try (ResultSet resultSet = st.executeQuery()) {
                while (resultSet.next()) {
                    resultItem.setId(id);
                    resultItem.setName("name");
                    resultItem.setCreated(LocalDateTime.parse("created"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultItem;
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }
}
