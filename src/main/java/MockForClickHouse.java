import com.github.javafaker.Faker;
import ru.yandex.clickhouse.ClickHouseConnection;
import ru.yandex.clickhouse.ClickHouseDataSource;

import java.sql.*;
import java.util.Date;

public class MockForClickHouse {
    public static void main(String[] args) {
//        String url = "jdbc:clickhouse://10.254.10.50:8123/asdumcore";
        String url = "jdbc:clickhouse://localhost:8123/default";
        String user = "default";
        String urlPl = "jdbc:postgresql://10.254.5.200:5100/asdumcore";
        String userPl = "asdumcore";


        try (Connection connection = DriverManager.getConnection(urlPl, userPl, "PdvKW6TvWrr7ybbOSbub")) {
            System.out.println("start " + new Date());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from tracks_history limit 3000000;");
            System.out.println("end " + new Date());
            ClickHouseDataSource dataSource = new ClickHouseDataSource(url);
            try (ClickHouseConnection connectionCl = dataSource.getConnection(user, "")) {
                insertDataClHouse(connectionCl,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            insertDataPg(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    private static void insertDataClHouse(ClickHouseConnection connection,ResultSet rs) throws SQLException {
        Faker faker = new Faker();
        String insertSQL = """
                INSERT INTO tracks_history (all_meter, all_second, lat, lng, last_update, speed, system_time, battery, idle, tracker_id, tracker_type,
                is_active, in_polygon, in_radius, in_route, is_working, in_repair, course) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (PreparedStatement stmt = connection.prepareStatement(insertSQL)) {
            while (rs.next()) {
                stmt.setInt(1, (int) rs.getLong("all_meter"));
                stmt.setInt(2, (int) rs.getLong("all_second"));
                stmt.setDouble(3, rs.getDouble("lat"));
                stmt.setDouble(4, rs.getDouble("lng"));
                stmt.setTimestamp(5, rs.getTimestamp("last_update"));
                stmt.setInt(6, rs.getInt("speed"));
                stmt.setTimestamp(7, rs.getTimestamp("system_time"));
                stmt.setDouble(8, rs.getDouble("battery"));
                stmt.setBoolean(9, rs.getBoolean("idle"));
                stmt.setString(10, rs.getString("tracker_id"));
                stmt.setString(11, rs.getObject("tracker_type") != null ? rs.getString("tracker_type") : null);
                stmt.setBoolean(12, rs.getBoolean("is_active"));
                stmt.setBoolean(13, rs.getBoolean("in_polygon"));
                stmt.setBoolean(14, rs.getBoolean("in_radius"));
                stmt.setBoolean(15, rs.getBoolean("in_route"));
                stmt.setBoolean(16, rs.getBoolean("is_working"));
                stmt.setBoolean(17, rs.getBoolean("in_repair"));
                stmt.setInt(18, rs.getInt("course"));

                stmt.addBatch();
            }
            System.out.println("query executed at ->  " + new Date());
            stmt.executeBatch();
            System.out.println("query end at ->  " + new Date());
        }
    }

    private static void insertDataPg(Connection connection) throws SQLException {
        Faker faker = new Faker();
        String insertSQL = """
                INSERT INTO tracks_daily (all_meter, all_second, lat, lng, last_update, speed, system_time, battery, idle, tracker_id, tracker_type,
                is_active, in_polygon, in_radius, in_route, is_working, in_repair, course) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (PreparedStatement stmt = connection.prepareStatement(insertSQL)) {

            for (int i = 1; i <= 1000000; i++) {
                stmt.setInt(1, 1000 + i);
                stmt.setInt(2, 3600 + (i * 10));
                stmt.setDouble(3, 37.7749 + (i * 0.001));
                stmt.setDouble(4, -122.4194 + (i * 0.001));
                stmt.setTimestamp(5, new java.sql.Timestamp(new Date().getTime()));
                stmt.setInt(6, 60 + (i % 10));
                stmt.setTimestamp(7, new java.sql.Timestamp(new Date().getTime()));
                stmt.setDouble(8, 75.5 + (i * 0.1));
                stmt.setBoolean(9, i % 2 == 0);
                stmt.setString(10, "tracker" + i);
                stmt.setString(11, "type" + (char) (65 + (i % 26)));
                stmt.setBoolean(12, i % 2 == 0);
                stmt.setBoolean(13, i % 2 == 0);
                stmt.setBoolean(14, i % 2 == 0);
                stmt.setBoolean(15, i % 2 == 0);
                stmt.setBoolean(16, i % 2 == 0);
                stmt.setBoolean(17, i % 2 == 0);
                stmt.setInt(18, 180 + (i % 360));

                stmt.addBatch();
            }
            System.out.println("query executed at ->  " + new Date());
            stmt.executeBatch();
            System.out.println("query end at ->  " + new Date());
        }
    }
}
