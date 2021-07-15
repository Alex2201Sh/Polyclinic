package by.it_academy.polyclinic.dao;

import by.it_academy.polyclinic.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> index() {
        return jdbcTemplate.query("SELECT * FROM polyclinic.users", new BeanPropertyRowMapper<>(User.class));
    }

    public User show(int id) {
        return jdbcTemplate.query("SELECT * FROM polyclinic.users WHERE id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(User.class)).
                stream().findAny().orElse(null);
    }

    public void save(User user) {
        jdbcTemplate.update("INSERT INTO polyclinic.users(" +
                "                first_name, surname, email, address, phone_number, med_card, health_status, user_role)" +
                " VALUES( ?, ?, ?, ?, ?, ?, ?, ?)",
                user.getFirstName(), user.getSurname(), user.getEmail(), user.getAddress(),
                user.getPhoneNumber(),user.getMedCard(), user.getHealthStatus(),
                user.getUserRole());
    }

    public void update(int id, User updatedUser) {
        jdbcTemplate.update("UPDATE polyclinic.users SET " +
                        "first_name=?, surname=?, email=?, address=?, " +
                        "phone_number=?, med_card=?, health_status=?, " +
                        "user_role=? WHERE id=?;",
                updatedUser.getFirstName(), updatedUser.getSurname(), updatedUser.getEmail(), updatedUser.getAddress(),
                updatedUser.getPhoneNumber(), updatedUser.getMedCard(), updatedUser.getHealthStatus(),
                updatedUser.getUserRole(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM polyclinic.users WHERE id=?", id);
    }

}
