package ru.job4j.tracker.store;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenSaveItemAndFindByNameThenMustBeTheSame() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("item1");
        Item second = new Item("item2");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("item1"));
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void whenSaveItemAndFindALLThenMustBeTheSame() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("item1");
        Item second = new Item("item2");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("item1"));
        List<Item> result = tracker.findAll();
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void whenReplase() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("item1");
        Item second = new Item("item2");
        tracker.add(first);
        int id = first.getId();
        tracker.replace(id, second);
        assertThat(tracker.findById(id).getName()).isEqualTo("item2");
    }

    @Test
    public void whenDelete() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("item1");
        tracker.add(first);
        int id = first.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id).getName()).isEqualTo(null);
    }
}