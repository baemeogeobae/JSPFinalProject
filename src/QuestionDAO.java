import vo.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {

    Statement statement;
    ResultSet resultSet;
    Question question;
    List<Question> questions = new ArrayList<>();
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    public QuestionDAO() {
        try {
            statement = DBConnUtils.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Question> selectQuestion() {
        String query = "select * from question";
        try {
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                question = new Question();

                question.setId(resultSet.getInt("id"));
                question.setTitle(resultSet.getString("title"));
                question.setContents(resultSet.getString("contents"));
                question.setCount_of_answer(resultSet.getInt("count_of_answer"));
                question.setWriter_id(resultSet.getInt("writer_id"));
                question.setCreate_date(resultSet.getTimestamp("create_date"));

                questions.add(question);

            }
            resultSet.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (NullPointerException nullPointerException) {
            nullPointerException.printStackTrace();
        }

        return questions;
    }

    public void insertQuestion(String title, String contents) {

        String query = "INSERT INTO QUESTION (TITLE, CONTENTS, COUNT_OF_ANSWER, WRITER_ID, CREATE_DATE) VALUES ("+title+"', '"+contents+"', '"+1+"', '"+timestamp+"')";

        try {
            Statement statement = DBConnUtils.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
}
