package repository;

import db.DatabaseConnection;
import model.Movie;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    public void createTable(){
        String sql = """
            CREATE TABLE IF NOT EXISTS movies(
                id INT AUTO_INCREMENT PRIMARY KEY,
                title VARCHAR2(45) NOT NULL,
                director VARCHAR2(30) NOT NULL,
                releaseyear INT NOT NULL
            )
            """;
        try(Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement()){

            statement.execute(sql);
            System.out.println("Table 'movies' created.");

        }catch(SQLException e){
            System.out.println("Error while creating table: " + e.getMessage());
        }
    }

    public void addMovie(Movie movie){
        String sql = "INSERT INTO movies (title, director, releaseyear) VALUES (?, ?, ?)";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getDirector());
            preparedStatement.setInt(3, movie.getReleaseYear());

            preparedStatement.executeUpdate();
            System.out.println("Movie added: " + movie.getTitle());
        }catch(SQLException e){
            System.out.println("Error adding movie: " + e.getMessage());
        }
    }

    public List<Movie> getAllMovies(){
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movies";
        try(Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){

            while(resultSet.next()){
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("director"),
                        resultSet.getInt("releaseyear")
                );
                movies.add(movie);
            }
        }catch(SQLException e){
            System.out.println("Error retrieving movies: " + e.getMessage());
        }
        return movies;
    }

    public void updateMovieTitle(int id, String newTitle){
        String sql = "UPDATE movies SET title = ? WHERE id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, newTitle);
            preparedStatement.setInt(2, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            if(rowsUpdated > 0){
                System.out.println("Movie with id " + id + " updated successfully");
            }else{
                System.out.println("No movie found with id " + id);
            }
        }catch(SQLException e){
            System.out.println("Error updating movie: " + e.getMessage());
        }
    }

    public void deleteMovie(int id){
        String sql = "DELETE FROM movies WHERE id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            int rowsUpdated = preparedStatement.executeUpdate();

            if(rowsUpdated > 0){
                System.out.println("Movie with id " + id + " deleted successfully");
            }else{
                System.out.println("No movie found with id " + id);
            }
        }catch(SQLException e){
            System.out.println("Error deleting movie: " + e.getMessage());
        }
    }
}
