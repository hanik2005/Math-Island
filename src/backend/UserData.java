package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserData {
    private static String userName;
    private static ArrayList<String> usernames = new ArrayList<>();
    private static ArrayList<Float> playTimes = new ArrayList<>();
    private static ArrayList<String> categories = new ArrayList<>();
    
    public void setUserName(String userName) {
        UserData.userName = userName;
    }

    public String getUserName() {
        return UserData.userName;
    }

    public static void setUserDatas() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/math_login", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT username, play_time FROM users");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                String username = rs.getString("username");
                float playTime = rs.getFloat("play_time");
                usernames.add(username);
                playTimes.add(playTime);
            }
            connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void clearUserDatas() {
        usernames.clear();
        playTimes.clear();
        categories.clear();
    }

    public static ArrayList<String> getUsernames() {
        return usernames;
    }

    public static ArrayList<Float> getPlayTimes() {
        return playTimes;
    }
  public static void updatePlayTime(String username, double playTime) {
    try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/math_login", "root", "");

        // Check if the user already exists
        PreparedStatement selectStatement = connection.prepareStatement("SELECT play_time FROM users WHERE username = ?");
        selectStatement.setString(1, username);
        ResultSet resultSet = selectStatement.executeQuery();

        if (resultSet.next()) {
            // User already exists
            double existingPlayTime = resultSet.getDouble("play_time");
            if (existingPlayTime == 0.0 || playTime < existingPlayTime) {
                // Update if the existing play time is 0.0 or the new play time is smaller than the existing
                PreparedStatement updateStatement = connection.prepareStatement("UPDATE users SET play_time = ? WHERE username = ?");
                updateStatement.setDouble(1, playTime);
                updateStatement.setString(2, username);
                updateStatement.executeUpdate();
                updateStatement.close();
            }
        } else {
            // User doesn't exist, insert the new user with the provided play time
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO users (username, play_time) VALUES (?, ?)");
            insertStatement.setString(1, username);
            insertStatement.setDouble(2, playTime); // Set the initial play time to the provided value
            insertStatement.executeUpdate();
            insertStatement.close();
        }

        resultSet.close();
        selectStatement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}




}
